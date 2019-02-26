package hu.me;

import java.io.File;
import java.util.ArrayList;

public class InputClass {

    private String muvelet;
    private ArrayList<Double> operandusok;

    public String getMuvelet() {
        return muvelet;
    }

    public void setMuvelet(String muvelet) {
        this.muvelet = muvelet;
    }

    public ArrayList<Double> getOperandusok() {
        return operandusok;
    }

    public void setOperandusok(ArrayList<Double> operandusok) {
        this.operandusok = operandusok;
    }

    public void setOperandusok(double op1, double op2) {
        ArrayList<Double> operands = new ArrayList<>();
        operands.add(op1);
        operands.add(op2);
        this.operandusok = operands;
    }

    @Override
    public String toString() {
        return "InputClass\n" +
                "muvelet='" + muvelet + '\'' + "\n" +
                "operandusok=" + operandusok;
    }
}
