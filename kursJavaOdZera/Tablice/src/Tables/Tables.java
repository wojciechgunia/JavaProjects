package Tables;

public class Tables
{
    public static void main(String[] args)
    {
        for (int i = 0; i<args.length ; i++)
        {
            System.out.println(args[i]);
        }

        int[] tableOfInts = new int[5];

        tableOfInts[0] = 1;
        tableOfInts[1] = 5;
        tableOfInts[2] = 123;
        tableOfInts[3] = 23;
        tableOfInts[4] = 1222333;

        for (int i = 0; i<tableOfInts.length ; i++)
        {
            System.out.println("tableOfInts["+i+"] = "+tableOfInts[i]);
        }

        for(int i : tableOfInts)
        {
            System.out.println(i);
        }

    }
}