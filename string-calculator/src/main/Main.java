package main;

import java.util.List;

import main.enums.OperationType;

public class Main {
    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO();
        InputProcessor inpo = new InputProcessor();
        // Calculator calculator = new Calculator();

        String input = consoleIO.getInput();

        inpo.validatorInput(input);
        String[] numbersAndSymbol = inpo.parserInput(input);

        inpo.validatorInput(numbersAndSymbol[0], numbersAndSymbol[1]);

        List<Double> numbersList = inpo.alterInputNum(numbersAndSymbol[0]);
        OperationType operator = inpo.alterInputSymbol(numbersAndSymbol[1]);

        Double result = Calculator.calculate(numbersList, operator);

        consoleIO.displayOutput(result);

    }
}
