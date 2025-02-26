package main;

import java.util.Scanner;

public class ConsoleIO {

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력해주세요 : ");
        String input = sc.nextLine();
        sc.close();

        System.out.println("Input :: " + input);

        return input;
    }

    public void displayOutput(Double outputValue) {
        outputValue = Math.round(outputValue * 10) / 10.0;
        System.out.println("Output :: " + outputValue);
    }
}
