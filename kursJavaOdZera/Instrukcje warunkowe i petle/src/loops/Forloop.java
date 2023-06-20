package loops;

public class Forloop
{
    public static void main(String[] args)
    {
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
    }
}
