package scanner.exercise;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.Scanner;

public class CircleArea
{
    public static void main(String[] args)
    {
        circleArea();
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static void circleArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double r = scanner.nextDouble();
        double pole = Math.pow(r, 2)*Math.PI;
        System.out.println("The area of the circle is: "+roundAvoid(pole,3));
    }
}
