package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import main.enums.ErrorMessage;
import main.enums.OperationType;

public class InputProcessor {
    //
    public void validatorInput(String input) {
        Validator.isNull(input);
        Validator.isEmpty(input);
    }

    public void validatorInput(String inputNum, String inputSymbol) {
        String[] inputNumList = inputNum.split("[:,]+");
        for (String s : inputNumList) {
            Integer num = Integer.parseInt(s);
            if (num != Math.floor(num)) {
                Validator.isFloat(true);
            }
        }
    }

    public int validatorInput(String[] input) {

        return 0;
    }

    public String[] parserInput(String input) {
        Validator.notSpaceOper(input);

        String[] strArr = input.split(" "); // { "3:4", "+" }

        return strArr;
    }

    public List<Double> alterInputNum(String inputNum) {
        List<Double> numIntList = new ArrayList<>();

        String[] s = inputNum.split("[:,]+"); // { "3", "4" }
        try {
            List<String> numStrList = Arrays.asList(s);
            numIntList = numStrList.stream().map(Double::parseDouble).collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
        }
        // ONE_NUM

        return numIntList;
    }

    public OperationType alterInputSymbol(String input) {
        OperationType op = OperationType.fromSymbol(input);

        return op;
    }
}
