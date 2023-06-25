package StringBuilder.personaldata;

import java.util.ArrayList;
import java.util.List;

public class PersonalData
{
    public static void main(String[] args)
    {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Wojciech",21,true,Gender.MALE));
        persons.add(new Person("Anna",19,false,Gender.FEMALE));
        persons.add(new Person("Adam",20,false,Gender.MALE));
        persons.add(new Person("Adam",22,true,Gender.MALE));

        StringBuilder tx = new StringBuilder();
        for (Person person : persons)
        {
            tx.append(person.getPersonalData());
            tx.append("----------------------------------------\n");
        }

        System.out.println(tx);
    }

}