package Exercise;

import java.util.Random;

public class Divider
{
    public static void main(String[] args)
    {
        Random r = new Random();
        int a,b;
        do
        {
            a = r.nextInt(2,101);
            b = r.nextInt(0, 101);
        }
        while(b%a!=0);
        System.out.println("a = "+a+", b = "+b);
    }
}
