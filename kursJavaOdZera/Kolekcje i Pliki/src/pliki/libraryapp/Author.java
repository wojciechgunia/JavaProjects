package pliki.libraryapp;

import java.io.Serializable;

public class Author implements Serializable
{
    private final String firstName;
    private final String lastName;
    public Author(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getInfo()
    {
        return this.firstName+" "+this.lastName;
    }

    @Override
    public String toString()
    {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
