package Exercise;

import java.util.Random;

public class RandomMin
{
    public static void main(String[] args)
    {
        Random r = new Random();
        int[] table = new int[5];
        for(int i = 0; i < table.length;i++)
        {
            table[i]=r.nextInt();
            System.out.println("Table["+i+"] = "+table[i]);
        }
        int min = table[0];
        for(int i = 1; i< table.length;i++)
        {
            min=Math.min(min,table[i]);
        }
        System.out.println("Minimum is: "+min);
    }
}
