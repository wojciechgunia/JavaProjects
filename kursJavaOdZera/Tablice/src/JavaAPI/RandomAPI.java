package JavaAPI;

import java.util.Random;

public class RandomAPI
{
    public static void main(String[] args)
    {
        Random r = new Random();
        System.out.println(r.nextInt(10,100));
        System.out.println(r.nextDouble(10,100));
        System.out.println(r.nextBoolean());
    }
}
