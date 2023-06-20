package conditional_statements;

public class Switches
{
    public static void main(String[] args)
    {
        int i = 3;

        switch(i)
        {
            case 1:
                System.out.println("Jeden");
                break;

            case 2:
                System.out.println("Dwa");
                break;

            case 3:
                System.out.println("Trzy");
                break;

            default:
                System.out.println("Inna wartość");
                break;
        }

        String x = "Ala";

        switch(x)
        {
            case "Paweł":
                System.out.println("Jeden");
                break;

            case "Ala":
                System.out.println("Dwa");
                break;

            case "Adam":
                System.out.println("Trzy");
                break;

            default:
                System.out.println("Inna wartość");
                break;
        }

        Language y = Language.PL;

        switch(y)
        {
            case PL:
                System.out.println("Poland");
                break;

            case DE:
                System.out.println("Germany");
                break;

            case FR:
                System.out.println("France");
                break;

            default:
                System.out.println("Other country");
                break;
        }
    }
}
