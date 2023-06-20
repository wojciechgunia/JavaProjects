package loops;

public class Whileloops
{
    public static void main(String[] args)
    {
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

        i = 12;
        do
        {
            System.out.println(i);
            i++;
        } while(i<=10);
    }
}
