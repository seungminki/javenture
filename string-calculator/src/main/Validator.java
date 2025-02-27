package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void notOperator(String[] input) {
        if (input.length <= 1) {
            throw new IllegalArgumentException(ErrorMessage.NON_OPERATOR.getMessage());
        }
    }

    public static void notDelimiter(String input) {
        // TODO: 1. 숫자만 추출 후 2. 구분자(로 추정되는) 있는 지 확인 3. 유효한 구분자인지 확인
    }

    public static void invalidDe(String input) {
        if (!input.contains(DelimiterType.COLON.getSymbol()) && !input.contains(DelimiterType.COMMA.getSymbol())) {
            throw new IllegalArgumentException(ErrorMessage.NON_DELIMITER.getMessage());
        }
    }

    public static void multipleOp(String input) { // "*+"
        if (input.length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.MULTIPLE_OPERATOR.getMessage());
        }
    }

    public static void notSpace(String input) {
        if (!input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NON_SPACE.getMessage());
        }
        Pattern pattern = Pattern.compile("\\s[\\+\\-*/:,]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find() == false) {
            throw new IllegalArgumentException(ErrorMessage.NON_SPACE.getMessage());
        }
    }

    public static void isFloat(String input) {
        String[] inputNumList = input.split("[:,]+");
        for (String s : inputNumList) {
            Double num = Double.parseDouble(s);
            if (num != Math.floor(num)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_FLOAT.getMessage());
            }
        }

    }

    public static void isOneNum(String[] input) {
        if (input.length <= 1) {
            throw new IllegalArgumentException(ErrorMessage.ONE_NUMERIC.getMessage());
        }

    }

}
