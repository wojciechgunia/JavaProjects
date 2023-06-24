package kolekcje.libraryapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    private final List<Author> authors = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();

    public App()
    {
        System.out.println("=========== Library App ===========");

        authors.add(new Author("Stephen", "King"));
        authors.add(new Author("Terry", "Prachett"));
        authors.add(new Author("Aghata", "Christie"));
        authors.add(new Author("Robin", "Sharma"));

        books.add(new Book("Carrie", authors.get(0), Genre.Horror));
        books.add(new Book("Guard! Guard!", authors.get(1), Genre.Fantasy));
        books.add(new Book("Death on the Nile", authors.get(2), Genre.Mystery));
        books.add(new Book("The 5 am club", authors.get(3), Genre.Personal_Development));
    }
    public void printAuthors()
    {
        int i=1;
        System.out.println("-----------Authors-------------");
        for(Author author : authors)
        {
            System.out.println(i+". "+author.getInfo());
            i++;
        }
        System.out.println("-------------------------------\n");
    }
    public void printBooks()
    {
        int i=1;
        System.out.println("-----------Books-------------");
        for(Book book : books)
        {
            System.out.println(i+". "+book.getInfo());
            i++;
        }
        System.out.println("-----------------------------\n");
    }

    public Author getAuthor(int id)
    {
        return authors.get(id);
    }

    public void addAuthor(Author author)
    {
        this.authors.add(author);
    }

    public Book getBook(int id)
    {
        return books.get(id);
    }

    public void addBook(Book book)
    {
        this.books.add(book);
    }

    public static void main(String[] args)
    {
        App app = new App();
        Scanner scan = new Scanner(System.in);
        boolean running=true;
        while(running)
        {
            System.out.println("===================================\n0. Exit\n1.Print Authors\n2.Print Books");
            System.out.print("Choose option: ");
            int opt;
            try
            {
                opt=scan.nextInt();
            }
            catch (Exception e)
            {
                opt=0;
            }
            switch (opt)
            {
                case 1 -> app.printAuthors();
                case 2 -> app.printBooks();
                default -> running = false;
            }
        }
    }
}
