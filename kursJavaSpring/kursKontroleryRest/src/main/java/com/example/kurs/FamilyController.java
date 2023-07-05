package com.example.kurs;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value= "/api/v1/family")
public class FamilyController
{

    @RequestMapping(value = "/GETALL", method = RequestMethod.GET)
    public List<Family> getAll()
    {
        List<Family> familylist = new ArrayList<>();
        List<Member> kowalscy = new ArrayList<>();
        kowalscy.add(new Member("Adam",42,"Male"));
        kowalscy.add(new Member("Marta",40,"Female"));
        familylist.add((new Family(UUID.randomUUID(),"Kowalscy",kowalscy)));
        List<Member> nowak = new ArrayList<>();
        nowak.add(new Member("Karol",42,"Male"));
        nowak.add(new Member("Anna",40,"Female"));
        nowak.add(new Member("Paweł",42,"Male"));
        familylist.add((new Family(UUID.randomUUID(),"Nowakowie",nowak)));
        return familylist;
    }

    @RequestMapping(value = "/GETbyName", method = RequestMethod.GET)
    public Family getByName(@RequestParam String familyName)
    {
        List<Family> familylist = new ArrayList<>();
        List<Member> kowalscy = new ArrayList<>();
        kowalscy.add(new Member("Adam",42,"Male"));
        kowalscy.add(new Member("Marta",40,"Female"));
        familylist.add((new Family(UUID.randomUUID(),"Kowalscy",kowalscy)));
        List<Member> nowak = new ArrayList<>();
        nowak.add(new Member("Karol",42,"Male"));
        nowak.add(new Member("Anna",40,"Female"));
        nowak.add(new Member("Paweł",42,"Male"));
        familylist.add((new Family(UUID.randomUUID(),"Nowakowie",nowak)));
        return familylist.stream().filter(family -> family.getName().equals(familyName)).findFirst().orElseThrow();
    }

}
