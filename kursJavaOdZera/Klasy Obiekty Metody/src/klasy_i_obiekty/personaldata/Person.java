package klasy_i_obiekty.personaldata;

public class Person
{
    private final String name;
    private final int age;
    private final boolean study;
    private final Gender gender;

    public Person(String newName, int newAge, boolean newStudy, Gender newGender)
    {
        this.name = newName;
        this.age = newAge;
        this.study = newStudy;
        this.gender = newGender;

    }

    public String showPerson()
    {
        return "Name: "+this.name+"\n"+"Age: "+this.age+"\n"+"Student: "+this.study+"\n"+"Gender: "+this.gender+"\n";
    }
}
