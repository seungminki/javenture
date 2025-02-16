import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Calculator calculator = new Calculator();

        // Scanner sc = new Scanner(System.in);
        // System.out.print("입력해주세요 : ");
        // String input = sc.next();

        // String input = "11:4:25 *";
        // String input = "1:2,3:4 +";
        // String input = "6:10,2:3 *";
        // String input = "7,2:10 -";
        String input = "10:3 /";

        String[] listStrings = splStrings(input);

        double outputValue = compuInteger(listStrings);

        System.out.println("Print ::" + outputValue);

    }

    public static String[] splStrings(String input) {
        String[] listStrings = null;

        listStrings = input.split("[:, ]");

        return listStrings;
    }

    public static double compuInteger(String[] listStrings) {
        double baseNum = Integer.parseInt(listStrings[0]); // 3.0
        String tokenSymbol = listStrings[listStrings.length - 1]; // *
        String[] listNum = Arrays.copyOfRange(listStrings, 1, listStrings.length - 1); // [2, 3]

        switch (tokenSymbol) {
            case "+":
                for (String str : listNum) {
                    int num = Integer.parseInt(str);
                    baseNum = baseNum + num;
                }
                break;
            case "*":
                for (String str : listNum) {
                    int num = Integer.parseInt(str);
                    baseNum = baseNum * num;
                }
                break;
            case "-":
                for (String str : listNum) {
                    int num = Integer.parseInt(str);
                    baseNum = baseNum - num;
                }
                break;
            case "/":
                for (String str : listNum) {
                    int num = Integer.parseInt(str);
                    baseNum = baseNum / num;
                }
                baseNum = Math.round(baseNum * 10) / 10.0;
                break;
        }

        return baseNum;
    }
}
