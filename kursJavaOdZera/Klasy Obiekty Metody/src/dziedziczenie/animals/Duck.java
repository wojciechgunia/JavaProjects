package dziedziczenie.animals;

public class Duck extends Animal implements Swimming,Flying
{
    public void swim()
    {
        System.out.println("Duck swim");
    }

    public void fly()
    {
        System.out.println("Duck fly");
    }
}
