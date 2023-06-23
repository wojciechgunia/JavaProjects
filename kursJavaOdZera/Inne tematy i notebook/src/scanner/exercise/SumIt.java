package scanner.exercise;

import java.util.Scanner;

public class SumIt
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers will there be? : ");
        int n = scanner.nextInt();
        double[] numbers = new double[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter "+(i+1)+" number :");
            numbers[i] = scanner.nextDouble();
        }
        double sum = 0;
        for(double number : numbers)
        {
            sum += number;
        }
        System.out.println("Sum is "+sum);
    }
}
