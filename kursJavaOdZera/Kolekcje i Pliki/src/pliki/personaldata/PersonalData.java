package pliki.personaldata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalData
{
    public static void main(String[] args) throws IOException
    {
        List<Person> persons = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream(new File("persons.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            persons = (List<Person>) ois.readObject();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        for (Person p : persons)
        {
            System.out.println(p.getPersonalData());
        }

        try
        {
            FileOutputStream fout = new FileOutputStream("persons2.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(persons);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }

}