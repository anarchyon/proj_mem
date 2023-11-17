package toygildin.myfuture.proj1;

import android.telephony.mbms.MbmsErrors;

public class Calculator {
    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int DIVIDE = 3;
    public static final int MULTIPLY = 4;
    private static final String PLUS_SYMBOL = "+", MINUS_SYMBOL = "-", DIVIDE_SYMBOL = "÷",
            MULTIPLY_SYMBOL = "×";
    private String operatorSymbol;
    private static final String ERROR_DIVIDE_BY_ZERO = "Деление на ноль!";
    private String history;
    private Double[] operands = new Double[2];
    private Integer operator;
    private Double result;
    private String resultString;
    private String notParsedOperand;
    private int cursorToOperand;

    public Calculator() {
        cleanNotParsedOperand();
        cursorToOperand = 0;
        operator = null;
    }

    public boolean canCalculate() {
        return operands[0] != null && operator != null && !notParsedOperand.isEmpty();
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void cleanNotParsedOperand() {
        notParsedOperand = "";
    }

    public void setNotParsedOperand(String notParsedOperand) {
        this.notParsedOperand = notParsedOperand;
    }

    public String getNotParsedOperand() {
        return notParsedOperand;
    }

    public String getResultString() {
        return resultString;
    }

    private void parseOperand() {
        if (!notParsedOperand.isEmpty()) {
            operands[cursorToOperand] = Double.valueOf(notParsedOperand);
            cleanNotParsedOperand();
        }
    }

    private void moveCursor() {
        cursorToOperand = ++cursorToOperand % operands.length;
    }

    public void calculate() {
        if (canCalculate()) {
            parseOperand();
            switch (operator) {
                case PLUS:
                    sum();
                    break;
                case MINUS:
                    minus();
                    break;
                case DIVIDE:
                    divide();
                    break;
                case MULTIPLY:
                    multiply();
                    break;
            }
            operator = null;
            operatorSymbol = null;
            operands = new Double[2];
            cursorToOperand = 0;
        }
    }

    private void sum() {
        result = operands[0] + operands[1];
        resultString = String.valueOf(result);
    }

    private void minus() {
        result = operands[0] - operands[1];
        resultString = String.valueOf(result);
    }

    private void divide() {
        if (operands[1] != 0) {
            result = operands[0] / operands[1];
            resultString = String.valueOf(result);
        } else {
            resultString = ERROR_DIVIDE_BY_ZERO;
        }
    }

    private void multiply() {
        result = operands[0] * operands[1];
        resultString = String.valueOf(result);
    }

    public void setOperator(int operator) {
        if (!notParsedOperand.isEmpty() && operands[0] == null) {
            parseOperand();
            moveCursor();
        } else if (operands[0] != null) {
            this.operator = operator;
        } else if (result != null) {
            operands[0] = result;
            moveCursor();
        } else return;
        this.operator = operator;
        switch (operator) {
            case PLUS:
                operatorSymbol = PLUS_SYMBOL;
                break;
            case MINUS:
                operatorSymbol = MINUS_SYMBOL;
                break;
            case DIVIDE:
                operatorSymbol = DIVIDE_SYMBOL;
                break;
            case MULTIPLY:
                operatorSymbol = MULTIPLY_SYMBOL;
                break;
        }
    }

    public void addDigitToOperand(String digit) {
        notParsedOperand += digit;
    }

    public String getTextForScreen() {
        if (operands[0] == null) {
            return getNotParsedOperand();
        } else if (operands[1] == null) {
            String string = operands[0] + operatorSymbol + getNotParsedOperand();
            return string;
        }
        return "";
    }
}
