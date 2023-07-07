package com.example.kurs;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Family
{
    private final String uid;
    private String name;
    private List<Member> members;

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
