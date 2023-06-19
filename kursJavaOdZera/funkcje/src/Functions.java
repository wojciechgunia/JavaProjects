public class Functions
{
    public static void main(String[] args)
    {
        showPerson("Wojciech",21,true);
        showPerson("Anna",19,false);
        showPerson("Adam",20,true);
    }

    public static void showPerson(String name,int age,boolean study)
    {
        String info = "Name: "+name+"\n"+"Age: "+age+"\n"+"Student: "+study+"\n\n";
        System.out.println(info);
    }

}
