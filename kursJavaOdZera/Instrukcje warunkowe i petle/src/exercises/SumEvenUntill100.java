package exercises;

public class SumEvenUntill100
{
    public static void main(String[] args)
    {
        int sum = 0;
        int i = 0;
        while(sum<=100)
        {
            i += 2;
            System.out.println(sum + " + " + i + " = " + (sum + i));
            sum += i;
        }
        System.out.println("Max even: " + (i));
    }

}
