package main;

import java.util.List;

import main.enums.ErrorMessage;
import main.enums.OperationType;

public class Calculator {
    static double result = 0;

    public static double calculate(List<Double> n, OperationType operation) {
        Double b = n.remove(0); // b = baseNum
        return switch (operation) {
            case PLUS -> add(b, n);
            case MINUS -> subtract(b, n);
            case MULTIPLY -> multiply(b, n);
            case DIVIDE -> divide(b, n);
        };
    }

    private static double add(Double baseNum, List<Double> numList) {
        for (Double n : numList) {
            baseNum += n;
        }
        result = baseNum;
        return result;
    }

    private static double subtract(Double baseNum, List<Double> numList) {
        for (Double n : numList) {
            baseNum -= n;
        }
        result = baseNum;
        return result;
    }

    private static double multiply(Double baseNum, List<Double> numList) {
        for (Double n : numList) {
            baseNum *= n;
        }
        result = baseNum;
        return result;
    }

    private static double divide(Double baseNum, List<Double> numList) {

        if (baseNum == 0 || numList.contains(0)) {
            throw new IllegalArgumentException(ErrorMessage.DIVISION_BY_ZERO.getMessage());
        }
        for (Double n : numList) {
            baseNum /= n;
        }
        result = baseNum;
        return result;
    }
}
