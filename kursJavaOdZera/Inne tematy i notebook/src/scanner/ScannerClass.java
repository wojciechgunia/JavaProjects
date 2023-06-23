package scanner;

import java.util.Scanner;

public class ScannerClass
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj imię: ");
        String nx = scan.next();
        System.out.println("Witaj "+nx+"!");

        System.out.print("Podaj a: ");
        int a = scan.nextInt();
        System.out.println("a = "+a);
    }

}
