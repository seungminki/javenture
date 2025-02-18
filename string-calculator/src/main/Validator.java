package main;

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
            throw new IllegalArgumentException("입력값이 null값 입니다");
        }
    }

    public void validOperator(String input) {
        Pattern pattern = Pattern.compile("\\s[\\+\\-*/:,]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find() == false) {
            throw new IllegalArgumentException("공백+사칙연산이 포함되지 않았습니다");
        }
    }

    public void validSeparator(String input) {
        if (!(input.contains(":") || input.contains(","))) {
            throw new IllegalArgumentException("(:) 또는 (,) 구분자가 사용되지 않았습니다");
        }
    }

    public void countNum(String input) {
        String[] listStrings = new String[0];

        listStrings = CalculatorUtils.splitStrings(input);
        if (listStrings.length < 3) {
            throw new IllegalArgumentException("연산에 필요한 최소 숫자 값이 아닙니다");
        }
    }
}
