package com.example.kurs;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@RequestMapping(value= "/api/v1/family")
@Slf4j
public class FamilyController
{

    FamilyRepository familyRepository;

    @Autowired
    FamilyMapper familyMapper;

//    private static final Logger logger = Logger.getLogger(FamilyController.class.getName());

    public FamilyController(FamilyRepository familyRepository)
    {
        this.familyRepository = familyRepository;
    }

    List<Family> familylist = new ArrayList<>();

    @PostConstruct
    public void loadFamily()
    {
        this.createFamily("Kowalscy");
        this.createFamily("Nowakowie");
        this.addMember("Kowalscy","Adam",42,"Male");
        this.addMember("Kowalscy","Marta",40,"Female");
        this.addMember("Nowakowie","Karol",42,"Male");
        this.addMember("Nowakowie","Anna",40,"Female");
        this.addMember("Nowakowie","Paweł",17,"Male");
    }

    @GetMapping("createFamilyDB")
    @Transactional
    public void createFamilyDB()
    {
        log.info("Tworzenie rodziny");
        FamilyDB familyDB = new FamilyDB(11,"Kowalscy");
        log.info("Utworzono rodzine o id: {}",familyDB.getId());
        familyRepository.save(familyDB);
        log.warn("Zapisano rodzine");
    }

    @GetMapping("getFamilyDB")
    public Family getFamilyDB() throws URISyntaxException
    {
        return this.familyMapper.FamilyDbToFamily(familyRepository.findById(6L).get());
    }

    @GetMapping("getQuoteDB")
    public String getQuoteDB() throws URISyntaxException
    {
        RestTemplateApi restTemplateApi = new RestTemplateApi(new RestTemplate());
        return restTemplateApi.getQuotes();
    }


    @GetMapping("removeFamilyDB")
    public void removeFamily()
    {
        familyRepository.deleteById(5L);
    }

    @RequestMapping(value = "/GETALL", method = RequestMethod.GET)
    public List<Family> getAll(HttpServletResponse response)
    {
        response.setHeader("Lenght", String.valueOf(familylist.size()));
        Cookie cookie = new Cookie("Lenght", String.valueOf(familylist.size()));
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        return this.familylist;
    }

    @RequestMapping(value = "/GETbyName", method = RequestMethod.GET)
    public Family getByName(@RequestParam String familyName)
    {
        return this.familylist.stream().filter(family -> family.getName().equals(familyName)).findFirst().orElseThrow();
    }

    @RequestMapping(value = "/CreateFamily", method = RequestMethod.POST)
    public void createFamily(@RequestParam String name)
    {
        familylist.add((new Family(UUID.randomUUID().toString(),name,new ArrayList<>())));
    }

    @RequestMapping(value = "/CreateFamilyAll", method = RequestMethod.POST)
    public void createFamilyAll(@RequestBody Family family, HttpServletResponse response) throws IOException
    {
        if(family.getName().length()>1 && !family.getMembers().isEmpty())
        {
            familylist.add(family);
            response.sendError(HttpServletResponse.SC_OK,"Poprawnie dodano rodzinę!");
        }
        else if (family.getName().length()<=1)
        {
            throw new FamilyLenghtException("Nazwa rodziny nie może być pusta");
        }
        else
        {
            response.sendError(HttpServletResponse.SC_CONFLICT, "Lista członków nie może być puta!");
        }
    }

    @RequestMapping(value = "/AddMember", method = RequestMethod.POST)
    public void addMember(@RequestParam String familyName, @RequestParam String name,@RequestParam int age, @RequestParam String gender)
    {
        Family family = getByName(familyName);
        family.addMember(new Member(name,age,gender));
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PATCH)
    public void editFamily(@RequestBody Map<Object, Object> fields, @PathVariable String id, HttpServletResponse response) throws IOException
    {
        Optional<Family> family = this.familylist.stream().filter(value->value.getUid().equals(id)).findFirst();
        try
        {
            if(family.isPresent())
            {
                fields.forEach((k, v) -> {
                    Field field = ReflectionUtils.findField(Family.class, (String) k);
                    assert field != null;
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, family.get(), v);
                });
                response.sendError(HttpServletResponse.SC_OK, "Udana zmiana parametrów");
                return;
            }
        }
        catch (IOException e)
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Pola są podane niepoprawnie");
            return;
        }
        response.sendError(HttpServletResponse.SC_NO_CONTENT, "Taka rodzina nie istnieje");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateFamily(@RequestBody Family family, @PathVariable String id, HttpServletResponse response) throws IOException
    {
        for(int x = 0; x<familylist.size();x++)
        {
            if(familylist.get(x).getUid().equals(id))
            {
                familylist.set(x, family);
                response.sendError(HttpServletResponse.SC_OK, "Udana zmiana parametrów");
                return;
            }
            if(familylist.size()-1 == x)
            {
                familylist.add(family);
                response.sendError(HttpServletResponse.SC_OK, "Dodano nową rodzinę");
            }
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteFamily(@PathVariable String id, HttpServletResponse response) throws IOException
    {
        Optional<Family> family = this.familylist.stream().filter(value->value.getUid().equals(id)).findFirst();
        if(family.isPresent())
        {
            familylist.remove(family.get());
            response.sendError(HttpServletResponse.SC_OK, "Poprawnie usunięto rodzinę");
            return;
        }
        response.sendError(HttpServletResponse.SC_CONFLICT, "Taka rodzina nie istnieje");
    }

    @RequestMapping(value = "/google", method = RequestMethod.GET)
    public ResponseEntity<Void> getGoogle()
    {
        URI location = URI.create("https://google.com");
        return ResponseEntity.status(HttpStatus.FOUND).location(location).build();
    }

    @RequestMapping(value = "/getHeader", method = RequestMethod.GET)
    public void getHeader(HttpServletRequest request)
    {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName+ ": "+headerValue);
        }

        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
        {
            for(Cookie cookie: cookies)
            {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
    }

    @GetMapping(value = "/download")
    public ResponseEntity<Resource> downloadFile() throws IOException
    {
        File file = new File("src/main/resources/static/5c5446fca1c72_o.jpg");
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ file.getName()+"\"")
                .contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
    }

    @GetMapping("/video")
    public StreamingResponseBody streamVideo(HttpServletResponse response) throws IOException
    {
        response.setContentType("video/mp4");
        InputStream videoFileStream = new FileInputStream(new File("src/main/resources/static/video.mp4"));
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while((nRead = videoFileStream.read(data, 0, data.length)) != -1)
            {
                outputStream.write(data, 0, nRead);
            }
            videoFileStream.close();
        };
    }

}
