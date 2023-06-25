package pliki.libraryapp;

import kolekcje.libraryapp.Genre;

import java.io.Serializable;

public class Book implements Serializable
{
    private final String title;
    private final Author author;
    private final Genre genre;


    public Book(String title, Author author, Genre genre)
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
