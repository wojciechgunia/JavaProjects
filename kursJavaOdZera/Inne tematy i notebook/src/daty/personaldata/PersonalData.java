package daty.personaldata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonalData
{
    public static void main(String[] args)
    {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Wojciech",21,true, Gender.MALE, LocalDate.parse("2002-09-09")));
        persons.add(new Person("Anna",19,false, Gender.FEMALE, LocalDate.parse("2004-05-13")));
        persons.add(new Person("Adam",20,false, Gender.MALE, LocalDate.parse("2003-11-24")));
        persons.add(new Person("Adam",22,true, Gender.MALE, LocalDate.parse("2001-03-15")));

        StringBuilder tx = new StringBuilder();
        for (Person person : persons)
        {
            tx.append(person.getPersonalData());
            tx.append("----------------------------------------\n");
        }

        System.out.println(tx);
    }

}