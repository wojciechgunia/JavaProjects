package exercises;

public class ToThePower
{
    public static void main(String[] args)
    {
        for(int i=1;i<=5;i++)
        {
            int pow = i;
            for(int j=2;j<=4;j++)
            {
                pow *= i;
                System.out.println(i+"^"+j+" = "+pow);
            }
        }
    }
}
