package kolekcje.personaldata;

import java.util.HashSet;
import java.util.Set;

public class PersonalData
{
    public static void main(String[] args)
    {
        Set<Person> persons = new HashSet<>();

        persons.add(new Person("Wojciech",21,true,Gender.MALE));
        persons.add(new Person("Anna",19,false,Gender.FEMALE));
        persons.add(new Person("Adam",20,false,Gender.MALE));
        persons.add(new Person("Adam",20,false,Gender.MALE));

        for (Person person : persons)
        {
            System.out.println(person.getPersonalData());
            System.out.println(person);
            System.out.println("----------------------------------------");
        }
    }

}

