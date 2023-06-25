package pliki.personaldata;

import kolekcje.personaldata.Gender;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersonalData
{
    public static void main(String[] args) throws IOException
    {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Wojciech",21,true, Gender.MALE));
        persons.add(new Person("Anna",19,false,Gender.FEMALE));
        persons.add(new Person("Adam",20,false,Gender.MALE));
        persons.add(new Person("Adam",22,true,Gender.MALE));

        String tx = "";

        for (Person person : persons)
        {
            tx += person.getPersonalData();
            tx += "-----------------------------------\n";
        }
        try
        {
            Files.writeString(Paths.get("data.txt"),tx, StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}