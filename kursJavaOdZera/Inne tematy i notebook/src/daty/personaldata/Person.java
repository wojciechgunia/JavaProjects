package daty.personaldata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;

public class Person
{
    private final String name;
    private int age;
    private boolean study;
    private Gender gender;

    private LocalDate birthDate;
    private LocalDateTime creationTime;

    public Person(String name, int age, boolean study, Gender gender, LocalDate birthDate)
    {
        this.name = name;
        this.age = age;
        this.study = study;
        this.gender = gender;
        this.birthDate = birthDate;
        this.creationTime = LocalDateTime.now();
    }
    public String getPersonalData()
    {
        return "Name: "+this.name+"\n"+"Age: "+this.age+"\n"+"Student: "+this.study+"\n"+"Gender: "+this.gender+"\n"+"Birth date: "+this.birthDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))+"\n"+"Creation Time: "+this.creationTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG,FormatStyle.MEDIUM))+"\n";
    }
    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", study=" + study +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", creationTime=" + creationTime +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && study == person.study && Objects.equals(name, person.name) && gender == person.gender && Objects.equals(birthDate, person.birthDate) && Objects.equals(creationTime, person.creationTime);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, age, study, gender, birthDate, creationTime);
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

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreationTime()
    {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime)
    {
        this.creationTime = creationTime;
    }
}
