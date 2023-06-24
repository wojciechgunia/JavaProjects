package dziedziczenie.animals;

public class Swan extends Animal  implements Swimming,Flying
{
    public void swim()
    {
        System.out.println("Swan swim");
    }
    public void fly()
    {
        System.out.println("Swan fly");
    }
}
