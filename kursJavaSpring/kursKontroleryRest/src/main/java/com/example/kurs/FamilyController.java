package com.example.kurs;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

@RestController
@RequestMapping(value= "/api/v1/family")
public class FamilyController
{
    List<Family> familylist = new ArrayList<>();


    public FamilyController()
    {
        this.createFamily("Kowalscy");
        this.createFamily("Nowakowie");
        this.addMember("Kowalscy","Adam",42,"Male");
        this.addMember("Kowalscy","Marta",40,"Female");
        this.addMember("Nowakowie","Karol",42,"Male");
        this.addMember("Nowakowie","Anna",40,"Female");
        this.addMember("Nowakowie","Paweł",17,"Male");
    }
    @RequestMapping(value = "/GETALL", method = RequestMethod.GET)
    public List<Family> getAll()
    {
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
        if(family.getName() != null && !family.getMembers().isEmpty())
        {
            familylist.add(family);
            response.sendError(HttpServletResponse.SC_OK,"Poprawnie dodano rodzinę!");
        }
        else
        {
            response.sendError(HttpServletResponse.SC_CONFLICT, "Nazwa rodziny nie może być pusta oraz lista członków nie może być puta!");
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



}
