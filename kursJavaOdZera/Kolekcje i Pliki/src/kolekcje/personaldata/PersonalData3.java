package kolekcje.personaldata;

import java.util.HashMap;
import java.util.Map;

public class PersonalData3
{
    public static void main(String[] args)
    {
        Map<Integer, Person> persons = new HashMap<>();

        persons.put(1,new Person("Wojciech",21,true,Gender.MALE));
        persons.put(2,new Person("Anna",19,false,Gender.FEMALE));
        persons.put(3,new Person("Adam",20,false,Gender.MALE));
        persons.put(4,new Person("Adam",21,true,Gender.MALE));

        for (Map.Entry<Integer, Person> entry : persons.entrySet())
        {
            System.out.println("Key: "+entry.getKey());
            System.out.println(entry.getValue().getPersonalData());
            System.out.println("----------------------------------------");
        }
    }

}

