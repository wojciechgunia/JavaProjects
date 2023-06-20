package exercises;

public class FooBar
{
    public static void main(String[] args)
    {
        String text=foobar(15);
        System.out.println(text);
    }

    public static String foobar(int x)
    {
        if(x%3==0 && x%5==0)
            return "foobar";
        else if(x%3==0)
            return "foo";
        else if(x%5==0)
            return "bar";
        return  "";
    }
}
