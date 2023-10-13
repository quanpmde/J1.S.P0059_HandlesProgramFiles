package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

    public String inputString(String title) {
        String s = "";
        while (s.isBlank() || s.isEmpty()) {
            System.out.print(title + ": ");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
        }
        return s;
    }

    public double inputDouble(String title) {
        double a = -1;
        while (a < 0) {
            try {
                System.out.print(title + ": ");
                Scanner sc = new Scanner(System.in);
                a = sc.nextDouble();
            } catch (InputMismatchException e) {
                a = -1;
            }
        }
        return a;
    }
}