package calculations;

abstract class Operator1arg extends Expression {

    protected Expression exp1;

    @Override
    public abstract double calculate();
}
