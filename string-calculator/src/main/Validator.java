package main;

import main.enums.DelimiterType;
import main.enums.ErrorMessage;
import main.enums.OperationType;

public class Validator {

    public static void isNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL.getMessage());
        }
    }

    public static void isEmpty(String input) {
        if (input.trim() == "") {
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getMessage());
        }
    }

    public void notDelimiter(String input) {
        try {
            DelimiterType dp = DelimiterType.fromSymbol(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NON_DELIMITER.getMessage());
        }
    }

    public void invalidOp(String input) { // "&"
        try {
            OperationType op = OperationType.fromSymbol(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OPERATOR.getMessage());
        }
    }

    public void invalidDe(String input) { // ";"
        try {
            DelimiterType dp = DelimiterType.fromSymbol(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    public void multipleOp(String input) { // "*+"
        if (input.length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.MULTIPLE_OPERATOR.getMessage());
        }
    }

    public static void notSpaceOper(String input) {
        if (!input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NO_SPACE_OPERATOR.getMessage());
        }
    }

    public static void isFloat(boolean b) {
        if (b == true) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FLOAT.getMessage());
        }

    }

}
