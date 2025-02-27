package main.enums;

public enum ErrorMessage {
    IS_EMPTY("입력 값이 빈 문자열입니다"),
    IS_NULL("입력 값이 NULL 입니다"),

    NON_NUMERIC("피연산자는 숫자여야 합니다"),
    NON_OPERATOR("연산자가 존재하지 않습니다"),
    NON_DELIMITER("구분자가 존재하지 않습니다"),
    INVALID_OPERATOR("지원하지 않는 연산자 입니다"),
    INVALID_DELIMITER("지원하지 않는 구분자 입니다"),
    ONE_NUMERIC("연산을 수행하려면 최소 두 개의 숫자가 필요합니다"),
    MULTIPLE_OPERATOR("연산자는 한개여야 합니다"),

    OUT_OF_RANGE("입력 값이 너무 크거나 작습니다"),
    NON_SPACE("공백이 존재하지 않습니다"),

    DIVISION_BY_ZERO("입력 값을 0으로 나눌 수 없습니다"),

    INVALID_FLOAT("실수 연산은 지원하지 않습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
