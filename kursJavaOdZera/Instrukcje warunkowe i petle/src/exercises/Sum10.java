package exercises;

public class Sum10
{
    public static void main(String[] args)
    {
        int suma=0;
        for(int i=1;i<=10;i++)
        {
            System.out.println(suma+" + "+i+" = "+(suma+i));
            suma += i;
        }
    }
}
