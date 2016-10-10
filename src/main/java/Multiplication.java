import Operations.BinaryOperation;

public class Multiplication implements BinaryOperation {
    @Override
    public double getResult(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
