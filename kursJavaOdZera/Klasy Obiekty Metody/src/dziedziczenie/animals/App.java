package dziedziczenie.animals;

public class App
{
    public static void main(String[] args)
    {
        Duck d = new Duck();

        d.eat();
        d.fly();
        d.swim();

        showMeHowYouSwim(d);

        System.out.println("---------------------------");

        Swan s = new Swan();

        s.eat();
        s.fly();
        s.swim();

        showMeHowYouSwim(s);
        showMeHowYouFly(s);

        System.out.println("---------------------------");

        Owl o = new Owl();
        o.eat();
        o.fly();
        showMeHowYouFly(o);

        System.out.println("---------------------------");

        Horse h = new Horse();
        h.eat();
        showMeHowYouEat(h);

        System.out.println("---------------------------");

        Penguin p = new Penguin();
        p.eat();
        showMeHowYouSwim(p);
    }

    public static void showMeHowYouSwim(Swimming b)
    {
        b.swim();
    }

    public static void showMeHowYouEat(Animal a)
    {
        a.eat();
    }

    public static void showMeHowYouFly(Flying b)
    {
        b.fly();
    }
}
