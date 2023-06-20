package exercises.calendar;

public class Calendar
{
    public static void main(String[] args)
    {
        int m = 6;
        System.out.println(getMonth(m));
    }

    public static month getMonth(int m)
    {
        switch(m)
        {
            case 1:
                return month.JANUARY;
            case 2:
                return month.FEBRUARY;
            case 3:
                return month.MARCH;
            case 4:
                return month.APRIL;
            case 5:
                return month.MAY;
            case 6:
                return month.JUNE;
            case 7:
                return month.JULY;
            case 8:
                return month.AUGUST;
            case 9:
                return month.SEPTEMBER;
            case 10:
                return month.OCTOBER;
            case 11:
                return month.NOVEMBER;
            case 12:
                return month.DECEMBER;
            default:
                return month.UNKNOWN;
        }
    }
}


