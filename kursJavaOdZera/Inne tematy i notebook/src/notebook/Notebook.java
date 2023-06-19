package notebook;

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

        //
    }

    //funkcje

    public static String funkcja(int argument1, String argument2) //definicja funkcji (String - rodzaj zwracanego wyniku)
    {
        String zdanie = argument1+argument2;
        zdanie += "\n";
        return zdanie; //zwracanie wyniku
    }

}
