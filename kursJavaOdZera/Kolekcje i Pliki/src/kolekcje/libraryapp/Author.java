package kolekcje.libraryapp;

public class Author
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
}
