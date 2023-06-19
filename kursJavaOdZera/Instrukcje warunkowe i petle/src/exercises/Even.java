package exercises;

public class Even {
    public static void main(String[] args)
    {
        System.out.println("Liczba jest przeysta: "+evenNumber(12));
    }

    public static boolean evenNumber(int n)
    {
        if(n % 2 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
