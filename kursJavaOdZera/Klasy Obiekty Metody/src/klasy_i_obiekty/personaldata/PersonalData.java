package klasy_i_obiekty.personaldata;

public class PersonalData
{
    public static void main(String[] args)
    {
        Person wojciech = new Person("Wojciech",21,true,Gender.MALE);
        Person anna = new Person("Anna",19,false,Gender.FEMALE);
        Person adam = new Person("Adam",20,true,Gender.MALE);

        System.out.println(wojciech.getPersonalData());
        System.out.println(wojciech.toString());

        System.out.println("----------------------------------------");
        System.out.println(anna.getPersonalData());
        System.out.println(anna.toString());

        System.out.println("----------------------------------------");
        adam.setStudy(false);
        adam.setAge(-2);
        adam.setAge(32);
        adam.setName("    ");
        adam.setName("  Krztsztof    ");

        System.out.println(adam.getPersonalData());
        System.out.println(adam.toString());
        System.out.println("----------------------------------------");
    }

}

