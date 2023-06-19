public class PersonalData
{
    public static void main(String[] args)
    {
        System.out.println(showPerson("Wojciech",21,true,Gender.MALE));
        System.out.println(showPerson("Anna",19,false,Gender.FEMALE));
        System.out.println(showPerson("Adam",20,true,Gender.MALE));
    }
    public static String showPerson(String name,int age,boolean study,Gender gender)
    {
        //String info = "Name: "+name+"\n"+"Age: "+age+"\n"+"Student: "+study+"\n\n"
        //System.out.println(info)
        return "Name: "+name+"\n"+"Age: "+age+"\n"+"Student: "+study+"\n"+"Gender: "+gender+"\n";
    }
}

