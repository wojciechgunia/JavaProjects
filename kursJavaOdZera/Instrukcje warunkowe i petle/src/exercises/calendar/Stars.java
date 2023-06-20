package exercises.calendar;

public class Stars
{
    public static void main(String[] args)
    {
        int limit = 8;
        String stars = "";
        for(int i = 1;i<=limit;i++)
        {
            stars += "*";
            System.out.println(stars);
        }
    }
}