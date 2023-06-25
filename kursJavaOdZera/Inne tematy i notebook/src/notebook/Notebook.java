package notebook;

import StringBuilder.personaldata.Person;

import java.util.Random;
import java.util.Scanner;

public class Notebook {

    public static void main(String[] args)
    {
        //zmienne

        int x = 5;  //x = 5
        int y = 10; //y = 10

        int sum = x+y; //sum = 5 + 10 = 15
        int sub = x-y; //sum = 5 - 10 = -5
        int mul = x*y; //sum = 5 * 10 = 50
        float div = (float) x /y; //sum = 5 / 10 = 0.5

        //x=y; //x = y = 10

        System.out.println(sum);
        System.out.println(sub);
        System.out.println(mul);
        System.out.println(div);
        System.out.println(x);

        String zdanie = "Ala" + " ma " + "kota"; // koniunkcja łańcuchów znakowych
        System.out.println(zdanie);

        //funkcje
        String info = funkcja(12,"Adam"); //wywołanie funkcji
        System.out.println(info);

        //enum
        /*
        public enum personaldata.Gender
        {
            MALE, FEMALE
        }/
        */

        // modulo
        System.out.println(16%5); // reszta z dzielenia 16 przez 5

        // if, else if, else
        if(x>y)
        {
            System.out.println(x);
        }
        else if(x==y)
        {
            System.out.println(x);
        }
        else
        {
            System.out.println(y);
        }

        //switch
        switch(x)
        {
            case 1:
                System.out.println("Jeden");
                break;

            default:
                System.out.println("Inna wartość");
                break;
        }

        //for
        for(int i=1;i<=20;i++)
        {
            if(i%3==0)
            {
                continue;
            }
            if(i==13)
            {
                break;
            }
            System.out.println(i);
        }

        //while
        int i = 1;
        while(i<=20)
        {
            if(i%3==0)
            {
                i++;
                continue;
            }
            if(i==13)
            {
                break;
            }
            System.out.println(i);
            i++;
        }

        //Tables
        int[] tableOfInts = new int[5];

        tableOfInts[0] = 1;
        tableOfInts[1] = 5;
        tableOfInts[2] = 123;
        tableOfInts[3] = 23;
        tableOfInts[4] = 1222333;

        for (int j = 0; j<tableOfInts.length ; j++)
        {
            System.out.println("tableOfInts["+j+"] = "+tableOfInts[j]);
        }

        //Java API

            //Math
            System.out.println(Math.min(4, 2));
            System.out.println(Math.floor(Math.sqrt(124)));

            //String
            System.out.println("pawel".toUpperCase());
            System.out.println("pawel".length());

            //Random
            Random r = new Random();
            System.out.println(r.nextInt(10,100));
            System.out.println(r.nextDouble(10,100));


        //scanner
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj imię: ");
        String nx = scan.next();
        System.out.println("Witaj "+nx+"!");

        System.out.print("Podaj a: ");
        int a = scan.nextInt();
        System.out.println("a = "+a);

        //exception create
        if(a<0)
            throw new IllegalStateException("'a' musi być większe od 0");

        //exceptions
        try
        {
            int b = scan.nextInt();
            System.out.println(b);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("Wypisz niezależnie");
        }

        //String Builder
        StringBuilder tx = new StringBuilder();
        for (int k=0;k<5;k++)
        {
            tx.append(k);
            tx.append("-------\n");
        }
        System.out.println(tx);
    }

    //funkcje

    public static String funkcja(int argument1, String argument2) //definicja funkcji (String - rodzaj zwracanego wyniku)
    {
        String zdanie = argument1+argument2;
        zdanie += "\n";
        return zdanie; //zwracanie wyniku
    }

}
