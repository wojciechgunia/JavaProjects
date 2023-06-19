public class Functions
{
    public static void main(String[] args)
    {
        System.out.println(showPerson("Wojciech",21,true));
        System.out.println(showPerson("Anna",19,false));
        System.out.println(showPerson("Adam",20,true));
        System.out.println(singASong("Ala","kota"));
    }

    public static String showPerson(String name,int age,boolean study)
    {
        //String info = "Name: "+name+"\n"+"Age: "+age+"\n"+"Student: "+study+"\n\n"
        //System.out.println(info)
        return "Name: "+name+"\n"+"Age: "+age+"\n"+"Student: "+study+"\n";
    }

    public static String singASong(String person, String pet)
    {
        return person + " ma " + pet;
    }
}
