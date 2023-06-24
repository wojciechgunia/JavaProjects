package klasy_i_obiekty.personaldata;

public class Person
{
    String name;
    int age;
    boolean study;
    Gender gender;

    public Person(String newName, int newAge, boolean newStudy, Gender newGender)
    {
        name = newName;
        age = newAge;
        study = newStudy;
        gender = newGender;

    }

    public String showPerson()
    {
        return "Name: "+name+"\n"+"Age: "+age+"\n"+"Student: "+study+"\n"+"Gender: "+gender+"\n";
    }
}
