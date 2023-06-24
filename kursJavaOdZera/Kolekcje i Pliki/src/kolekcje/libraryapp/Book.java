package kolekcje.libraryapp;

public class Book
{
    private final String title;
    private final Author author;
    private final Genre genre;


    public Book(String title,Author author,Genre genre)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getInfo()
    {
        return title + " | " + author.getInfo() + " | " + genre;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}
