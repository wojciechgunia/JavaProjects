package dziedziczenie.exercise.figure;

public class App
{
    public static void main(String[] args)
    {
        Square s = new Square(12);
        System.out.println(s.calculateArea());

        Rectangle r = new Rectangle(2,6);
        System.out.println(r.calculateArea());
    }

}
