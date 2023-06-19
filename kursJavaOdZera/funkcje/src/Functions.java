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
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Student: "+study+"\n");
    }

}
