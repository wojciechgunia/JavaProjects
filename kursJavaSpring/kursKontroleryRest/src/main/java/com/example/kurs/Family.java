package com.example.kurs;

import java.util.List;
import java.util.UUID;

public class Family
{
    private final UUID uid;
    private String name;
    private List<Member> members;

    public Family(UUID uid, String name, List<Member> members)
    {
        this.uid = uid;
        this.name = name;
        this.members = members;
    }

    public UUID getUid()
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
}
