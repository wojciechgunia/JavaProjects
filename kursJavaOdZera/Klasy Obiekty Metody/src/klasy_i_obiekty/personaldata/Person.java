package klasy_i_obiekty.personaldata;

public class Person
{
    private final String name;
    private final int age;
    private final boolean study;
    private final Gender gender;

    public Person(String name, int age, boolean study, Gender gender)
    {
        this.name = name;
        this.age = age;
        this.study = study;
        this.gender = gender;

    }

    public String showPerson()
    {
        return "Name: "+this.name+"\n"+"Age: "+this.age+"\n"+"Student: "+this.study+"\n"+"Gender: "+this.gender+"\n";
    }
}
