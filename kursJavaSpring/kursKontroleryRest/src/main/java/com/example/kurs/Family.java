package com.example.kurs;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Family
{
    private String uid;
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
