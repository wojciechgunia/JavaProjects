package klasy_i_obiekty.personaldata;

public class PersonalData
{
    public static void main(String[] args)
    {
        Person wojciech = new Person("Wojciech",21,true,Gender.MALE);
        Person anna = new Person("Anna",19,false,Gender.FEMALE);
        Person adam = new Person("Adam",20,true,Gender.MALE);
        System.out.println(showPerson(wojciech.name, wojciech.age, wojciech.study, wojciech.gender));
        System.out.println(showPerson(anna.name, anna.age, anna.study, anna.gender));
        System.out.println(showPerson(adam.name, adam.age, adam.study, adam.gender));
    }
    public static String showPerson(String name,int age,boolean study,Gender gender)
    {
        //String info = "Name: "+name+"\n"+"Age: "+age+"\n"+"Student: "+study+"\n\n"
        //System.out.println(info)
        return "Name: "+name+"\n"+"Age: "+age+"\n"+"Student: "+study+"\n"+"personaldata.Gender: "+gender+"\n";
    }
}

