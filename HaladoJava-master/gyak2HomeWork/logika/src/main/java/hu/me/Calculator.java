package hu.me;

public class Calculator {

    public double add(double a, double b) {
        return a+b;
    }

    public double sub(double a, double b) {
        return a-b;
    }

    public double mult(double a, double b) {
        return a*b;
    }

    public double div(double a, double b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Division by zero is mathematically wrong!");
        }
        return a/b;
    }
}
