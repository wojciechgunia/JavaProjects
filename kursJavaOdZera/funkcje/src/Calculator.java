public class Calculator
{
    public static void main(String[] args)
    {
        System.out.println(sum(42, 2.6));
        System.out.println(sub(42, 2.6));
        System.out.println(mul(42, 2.6));
        System.out.println(div(42, 2.6));
    }

    public static double sum(double a, double b)
    {
        return a + b;
    }

    public static double sub(double a, double b)
    {
        return a - b;
    }

    public static double mul(double a, double b)
    {
        return a * b;
    }

    public static double div(double a, double b)
    {
        return a / b;
    }
}
