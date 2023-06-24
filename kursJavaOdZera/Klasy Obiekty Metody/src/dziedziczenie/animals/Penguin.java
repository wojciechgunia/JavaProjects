package dziedziczenie.animals;

public class Penguin extends Animal implements Swimming
{
    public void swim()
    {
        System.out.println("Penguin swim");
    }
}
