package pliki.libraryapp;

import kolekcje.libraryapp.Genre;

import java.io.*;
import java.util.*;

public class App
{
    private List<Author> authors = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private final List<Genre> genres = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in).useDelimiter("\\n");

    public App()
    {
        System.out.println("=========== Library App ===========");

        FileInputRead();

        Collections.addAll(this.genres, Genre.values());

        boolean running=true;
        while(running)
        {
            running = this.appMenu();
        }

        FileOutputWrite();

    }

    private void FileInputRead()
    {
        try
        {
            FileInputStream fisa = new FileInputStream("authors.txt");
            ObjectInputStream oisa = new ObjectInputStream(fisa);
            this.authors = (List<Author>) oisa.readObject();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        try
        {
            FileInputStream fisb = new FileInputStream("books.txt");
            ObjectInputStream oisb = new ObjectInputStream(fisb);
            this.books = (List<Book>) oisb.readObject();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void FileOutputWrite()
    {
        try
        {
            FileOutputStream fosa = new FileOutputStream("authors.txt");
            ObjectOutputStream oosa = new ObjectOutputStream(fosa);
            oosa.writeObject(this.authors);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileOutputStream fosb = new FileOutputStream("books.txt");
            ObjectOutputStream oosb = new ObjectOutputStream(fosb);
            oosb.writeObject(this.books);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printAuthors()
    {
        int i=1;
        System.out.println("-----------Authors-------------");
        for(Author author : this.authors)
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
        for(Book book : this.books)
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
        for(Genre genre : this.genres)
        {
            System.out.println(i+". "+genre);
            i++;
        }
        System.out.println("-----------------------------");
    }
    public void addAuthor()
    {
        String firstName,lastName;
        try
        {
            System.out.print("Author first name: ");
            firstName=this.scan.next();
            firstName = firstName.trim();
            System.out.print("Author last name: ");
            lastName=this.scan.next();
            lastName = lastName.trim();
            System.out.println("Author "+firstName+" "+lastName+" to add");
            System.out.print("Are data correct (t/f): ");
            String correct=this.scan.next();
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
    public void addBook()
    {
        String title;
        int genre;
        int author;
        try
        {
            System.out.print("Book title: ");
            title=this.scan.next();
            title = title.trim();
            printAuthors();
            System.out.print("Author id: ");
            author=this.scan.nextInt();
            if(author>this.authors.size() || author<1)
                throw new IllegalArgumentException("Bad value of int");
            printGenre();
            System.out.print("Genre id: ");
            genre=this.scan.nextInt();
            if(genre>this.genres.size() || genre<1)
                throw new IllegalArgumentException("Bad value of int");
            System.out.println("Book: "+title+" | "+this.authors.get(author-1).getInfo()+" | "+this.genres.get(genre-1)+" to add");
            System.out.print("Are data correct (t/f): ");
            String correct=this.scan.next();
            if(Objects.equals(correct, "t") || Objects.equals(correct, "T"))
            {
                this.books.add(new Book(title,this.authors.get(author-1), this.genres.get(genre-1)));
            }
        }
        catch (Exception e)
        {
            System.out.println("Error occured. Try again.");
        }
    }
    private boolean appMenu()
    {
        boolean running=true;
        System.out.println("===================================\n0. Exit\n1.Print Authors\n2.Print Books\n3.Add Author\n4.Add Book");
        System.out.print("Choose option: ");
        int opt;
        try
        {
            opt= this.scan.nextInt();
        }
        catch (Exception e)
        {
            opt=0;
        }
        switch (opt)
        {
            case 1 -> this.printAuthors();
            case 2 -> this.printBooks();
            case 3 -> this.addAuthor();
            case 4 -> this.addBook();
            default -> running = false;
        }
        return running;
    }

    public static void main(String[] args)
    {
        new App();
    }
}
