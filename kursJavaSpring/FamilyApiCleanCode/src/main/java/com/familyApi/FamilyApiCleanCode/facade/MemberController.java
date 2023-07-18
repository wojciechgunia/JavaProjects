package com.familyApi.FamilyApiCleanCode.facade;

import com.familyApi.FamilyApiCleanCode.mediator.Mediator;
import com.familyApi.FamilyApiCleanCode.model.MemberDTO;
import com.familyApi.FamilyApiCleanCode.model.MemberExtendedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController
{
    public MemberController(Mediator mediator)
    {
        this.mediator = mediator;
    }
    Mediator mediator;

    @RequestMapping(method = RequestMethod.POST,value = "/member/save")
    public void saveMember(@RequestBody MemberDTO memberDTO)
    {
        mediator.saveMember(memberDTO);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/member/getbyname")
    public List<MemberExtendedDTO> getMemberByParam(@RequestParam String name)
    {
        return mediator.getByMemberName(name);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/member/getAll")
    public List<MemberExtendedDTO> getAllMember()
    {
        return mediator.getAllMember();
    }
}
