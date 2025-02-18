package main;

import java.util.Arrays;

public class CalculatorUtils {
    public static double computeInteger(String[] listStrings) { // [3, 2, 3, *]
        double baseNum = Integer.parseInt(listStrings[0]); // 3.0
        String tokenSymbol = listStrings[listStrings.length - 1]; // *
        String[] listNum = Arrays.copyOfRange(listStrings, 1, listStrings.length - 1); // [2, 3]

        for (String str : listNum) {
            int num = Integer.parseInt(str);
            switch (tokenSymbol) {
                case "+":
                    baseNum = baseNum + num;
                    break;
                case "*":
                    baseNum = baseNum * num;
                    break;
                case "-":
                    baseNum = baseNum - num;
                    break;
                case "/":
                    baseNum = baseNum / num;
                    break;
            }
        }

        baseNum = Math.round(baseNum * 10) / 10.0;
        return baseNum;

    }

    public static String[] splitStrings(String input) {
        String[] listStrings = null;
        listStrings = input.split("[:, ]+");

        return listStrings;
    }

}
