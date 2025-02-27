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
        Validator.multipleOp(inputSymbol);

        Validator.invalidDe(inputNum);
        Validator.isFloat(inputNum);
    }

    public String[] parserInput(String input) {
        Validator.notSpace(input);

        String[] strArr = input.split(" "); // { "3:4", "+" }
        Validator.notOperator(strArr);

        // TODO: e.g.) 2: 2 + 인 경우 {"2:", "2", "+"}으로 나눠지는 에러 해결

        return strArr;
    }

    public List<Double> alterInputNum(String inputNum) {
        List<Double> numIntList = new ArrayList<>();

        String[] s = inputNum.split("[:,]+"); // { "3", "4" }
        Validator.isOneNum(s);
        try {
            List<String> numStrList = Arrays.asList(s);
            numIntList = numStrList.stream().map(Double::parseDouble).collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
        }

        return numIntList;
    }

    public OperationType alterInputSymbol(String input) {
        OperationType op = OperationType.fromSymbol(input);

        return op;
    }
}
