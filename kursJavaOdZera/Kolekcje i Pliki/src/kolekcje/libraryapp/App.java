package kolekcje.libraryapp;

import java.util.*;

public class App
{
    private final List<Author> authors = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();
    private final List<Genre> genres = new ArrayList<>();

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
        Collections.addAll(genres, Genre.values());
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
        System.out.println("-------------------------------");
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
        System.out.println("-----------------------------");
    }

    public void printGenre()
    {
        int i=1;
        System.out.println("-----------Genre-------------");
        for(Genre genre : genres)
        {
            System.out.println(i+". "+genre);
            i++;
        }
        System.out.println("-----------------------------");
    }

    public Author getAuthor(int id)
    {
        return authors.get(id);
    }

    public void addAuthor(Author author)
    {
        this.authors.add(author);
    }

    public void addAuthor()
    {
        String firstName,lastName;
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.print("Author first name: ");
            firstName=scan.next();
            System.out.print("Author last name: ");
            lastName=scan.next();
            System.out.println("Author "+firstName+" "+lastName+" to add");
            System.out.print("Are data correct (t/f): ");
            String correct=scan.next();
            if(Objects.equals(correct, "t") || Objects.equals(correct, "T"))
            {
                this.authors.add(new Author(firstName,lastName));
            }

        }
        catch (Exception e)
        {
            System.out.println("Error occured. Try again.");
        }
    }

    public Book getBook(int id)
    {
        return books.get(id);
    }

    public void addBook(Book book)
    {
        this.books.add(book);
    }

    public void addBook()
    {
        String title;
        int genre;
        int author;
        Scanner scan = new Scanner(System.in);
        try
        {
            System.out.print("Book title: ");
            title=scan.nextLine();
            printAuthors();
            System.out.print("Author id: ");
            author=scan.nextInt();
            if(author>authors.size() || author<1)
                throw new IllegalArgumentException("Bad value of int");
            printGenre();
            System.out.print("Genre id: ");
            genre=scan.nextInt();
            if(genre>genres.size() || genre<1)
                throw new IllegalArgumentException("Bad value of int");
            System.out.println("Book: "+title+" | "+this.authors.get(author-1).getInfo()+" | "+genres.get(genre-1)+" to add");
            System.out.print("Are data correct (t/f): ");
            String correct=scan.next();
            if(Objects.equals(correct, "t") || Objects.equals(correct, "T"))
            {
                this.books.add(new Book(title,this.authors.get(author-1), genres.get(genre-1)));
            }
        }
        catch (Exception e)
        {
            System.out.println("Error occured. Try again.");
        }
    }

    public static void main(String[] args)
    {
        App app = new App();
        Scanner scan = new Scanner(System.in);
        boolean running=true;
        while(running)
        {
            running = appMenu(app, scan);
        }
    }

    private static boolean appMenu(App app, Scanner scan)
    {
        boolean running=true;
        System.out.println("===================================\n0. Exit\n1.Print Authors\n2.Print Books\n3.Add Author\n4.Add Book");
        System.out.print("Choose option: ");
        int opt;
        try
        {
            opt= scan.nextInt();
        }
        catch (Exception e)
        {
            opt=0;
        }
        switch (opt)
        {
            case 1 -> app.printAuthors();
            case 2 -> app.printBooks();
            case 3 -> app.addAuthor();
            case 4 -> app.addBook();
            default -> running = false;
        }
        return running;
    }
}
