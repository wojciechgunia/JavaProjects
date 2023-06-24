package dziedziczenie.exercise.figure;

public class Square extends Figure
{
    private final int a;
    public Square(int a)
    {
        this.a = a;
    }
    public int calculateArea()
    {
        return this.a*this.a;
    }
}
