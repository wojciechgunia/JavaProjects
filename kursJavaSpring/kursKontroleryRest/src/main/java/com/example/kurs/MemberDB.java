package com.example.kurs;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "members")
@NoArgsConstructor
public class MemberDB
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @JoinColumn(name = "family_id",nullable = true)
    @OneToOne(mappedBy = "id")
    private FamilyDB family_id;

}
