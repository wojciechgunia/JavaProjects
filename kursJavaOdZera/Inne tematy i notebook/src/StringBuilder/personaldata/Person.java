package StringBuilder.personaldata;

import java.util.Objects;

public class Person
{
    private String name;
    private int age;
    private boolean study;
    private Gender gender;

    public Person(String name, int age, boolean study, Gender gender)
    {
        this.name = name;
        this.age = age;
        this.study = study;
        this.gender = gender;
    }
    public String getPersonalData()
    {
        return "Name: "+this.name+"\n"+"Age: "+this.age+"\n"+"Student: "+this.study+"\n"+"Gender: "+this.gender+"\n";
    }
    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", study=" + study +
                ", gender=" + gender +
                '}';
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && study == person.study && Objects.equals(name, person.name) && gender == person.gender;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(name, age, study, gender);
    }
    public void setName(String name)
    {
        name=name.trim();
        if(name.length()<3)
            System.out.println("Błąd! Podano błędne imię.");
        else
            this.name = name.substring(0,1).toUpperCase()+name.substring(1);
    }

    public void setAge(int age)
    {
        if(age>=0 && age<=150)
            this.age = age;
        else
            System.out.println("Błąd! Wiek musi być w przedziale [0 ,150].");
    }

    public void setStudy(boolean study)
    {
        this.study = study;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    public boolean getStudy()
    {
        return this.study;
    }

    public Gender getGender()
    {
        return this.gender;
    }
}
