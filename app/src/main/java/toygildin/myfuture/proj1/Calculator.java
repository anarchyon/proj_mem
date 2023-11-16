package toygildin.myfuture.proj1;

public class Calculator{
    private String history;
    private int operand1;
    private int operand2;

    private String notParcedOperand;

    public Calculator(){
        cleanNotParcedOperand();
    };

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void cleanNotParcedOperand() {
        notParcedOperand = "";
    }

    public void setNotParcedOperand(String notParcedOperand) {
        this.notParcedOperand = notParcedOperand;
    }

    public String getNotParcedOperand() {
        return notParcedOperand;
    }
}
