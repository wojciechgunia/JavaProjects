package com.familyApi.FamilyApiCleanCode.facade;

import com.familyApi.FamilyApiCleanCode.mediator.Mediator;
import com.familyApi.FamilyApiCleanCode.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyController {
    public FamilyController(Mediator mediator)
    {
        this.mediator = mediator;
    }
    Mediator mediator;

    @RequestMapping(method = RequestMethod.POST,value = "/save")
    public void saveFamily(@RequestBody FamilyDTO familyDTO)
    {
        mediator.saveFamily(familyDTO);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getbyname")
    public List<FamilyDTO> getFamilyByParam(@RequestParam String name)
    {
        return mediator.getByFamilyName(name);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getAll")
    public List<FamilyDTO> getAllFamily()
    {
        return mediator.getAllFamily();
    }
}
