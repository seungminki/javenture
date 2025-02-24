package main;

import main.enums.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public void validateAll(String input) {

        isEmpty(input);
        validOperator(input);
        validSeparator(input);
        countNum(input);

    }

    public void isEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL.getMessage());
        }
    }

    public void validOperator(String input) {
        Pattern pattern = Pattern.compile("\\s[\\+\\-*/:,]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find() == false) {
            throw new IllegalArgumentException(ErrorMessage.NO_SPACE_OPERATOR.getMessage());
        }
    }

    public void validSeparator(String input) {
        if (!(input.contains(":") || input.contains(","))) {
            throw new IllegalArgumentException(ErrorMessage.NON_DELIMITER.getMessage());
        }
    }

    public void countNum(String input) {
        String[] listStrings = new String[0];

        listStrings = CalculatorUtils.splitStrings(input);
        if (listStrings.length < 3) {
            throw new IllegalArgumentException(ErrorMessage.ONE_NUMERIC.getMessage());
        }
    }
}
