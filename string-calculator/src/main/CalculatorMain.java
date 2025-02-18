package main;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Validator validator = new Validator();

        Scanner sc = new Scanner(System.in);
        System.out.print("입력해주세요 : ");
        String input = sc.nextLine();
        sc.close();

        System.out.println("Input :: " + input);

        // String input = "1:2,3:4 +";
        // String input = "6:10,2:3 *";
        // String input = "7,2:10 -";
        // String input = "10,3 /";

        validator.validateAll(input);

        String[] listStrings = CalculatorUtils.splitStrings(input);
        Double outputValue = CalculatorUtils.computeInteger(listStrings);
        System.out.println("Output :: " + outputValue);

    }
}
