public class Notebook {

    public static void main(String[] args)
    {
        //zmienne

        int x = 5;  //x = 5
        int y = 10; //y = 10

        int sum = x+y; //sum = 5 + 10

        //x=y; //x = y = 10

        System.out.println(sum);
        System.out.println(x);

        String zdanie = "Ala" + " ma " + "kota"; // koniunkcja łańcuchów znakowych
        System.out.println(zdanie);

        //funkcje
        String info = funkcja(12,"Adam"); //wywołanie funkcji
        System.out.println(info);

    }

    //funkcje

    public static String funkcja(int argument1, String argument2) //definicja funkcji (String - rodzaj zwracanego wyniku)
    {
        String zdanie = argument1+argument2;
        zdanie += "\n";
        return zdanie; //zwracanie wyniku
    }
}
