package main.enums;

public enum DelimiterType {
    COLON(":"),
    COMMA(",");

    private final String symbol;

    DelimiterType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public DelimiterType fromSymbol(String symbol) {
        for (DelimiterType op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
    }
}
