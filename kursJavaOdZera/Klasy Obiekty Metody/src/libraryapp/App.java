package libraryapp;

public class App
{
    public static void main(String[] args)
    {
        System.out.println(" --- Library App --- ");

        Author king = new Author("Stephen", "King");
        Author terry = new Author("Terry", "Prachett");
        Author aghata = new Author("Aghata", "Christie");
        Author sharma = new Author("Robin", "Sharma");

        Book carrie = new Book("Carrie", king, Genre.Horror);
        Book guards = new Book("Guard! Guard!", terry, Genre.Fantasy);
        Book nile = new Book("Death on the Nile", aghata, Genre.Mystery);
        Book club = new Book("The 5 am club", sharma, Genre.Personal_Development);

        System.out.println(carrie.getInfo());
        System.out.println(guards.getInfo());
        System.out.println(nile.getInfo());
        System.out.println(club.getInfo());
    }
}
