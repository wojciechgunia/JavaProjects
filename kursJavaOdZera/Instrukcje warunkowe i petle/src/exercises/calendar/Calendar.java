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
        if(m==1)
        {
            return month.JANUARY;
        }
        else if(m==2)
        {
            return month.FEBRUARY;
        }
        else if(m==3)
        {
            return month.MARCH;
        }
        else if(m==4)
        {
            return month.APRIL;
        }
        else if(m==5)
        {
            return month.MAY;
        }
        else if(m==6)
        {
            return month.JUNE;
        }
        else if(m==7)
        {
            return month.JULY;
        }
        else if(m==8)
        {
            return month.AUGUST;
        }
        else if(m==9)
        {
            return month.SEPTEMBER;
        }
        else if(m==10)
        {
            return month.OCTOBER;
        }
        else if(m==11)
        {
            return month.NOVEMBER;
        }
        else if(m==12)
        {
            return month.DECEMBER;
        }
        else
        {
            return month.UNKNOWN;
        }
    }
}

