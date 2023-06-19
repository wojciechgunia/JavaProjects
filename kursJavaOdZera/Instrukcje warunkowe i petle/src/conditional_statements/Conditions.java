package conditional_statements;

public class Conditions {
    public static void main(String[] args) {

        boolean isVip = true;

        if( isVip )
        {
            System.out.println("Klient jest VIPem");
        }
        else
        {
            System.out.println("Klient nie jest VIPem");
        }
        System.out.println(getBigger(12,4));
        System.out.println(16%3); // modulo

    }

    public static int getBigger(int a, int b)
    {
        if(a>b)
        {
            return a;
        }
        else if(a==b)
        {
            return a;
        }
        else
        {
            return b;
        }

    }
}
