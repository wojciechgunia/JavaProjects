package com.example.kurs;

import java.util.List;
import java.util.UUID;

public class Family
{
    private final String uid;
    private String name;
    private List<Member> members;

    public Family(String uid, String name, List<Member> members)
    {
        this.uid = uid;
        this.name = name;
        this.members = members;
    }

    public String getUid()
    {
        return uid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Member> getMembers()
    {
        return members;
    }

    public void setMembers(List<Member> members)
    {
        this.members = members;
    }

    public void addMember(Member member)
    {
        this.members.add(member);
    }
}
