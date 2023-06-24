package dziedziczenie.exercise.figure;

public class Rectangle extends Figure
{
    private final int a;
    private final int b;
    public Rectangle(int a, int b)
    {
        this.a=a;
        this.b=b;
    }
    public int calculateArea()
    {
        return this.a*this.b;
    }
}
