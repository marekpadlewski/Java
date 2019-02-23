package calculations;

abstract class Operator2arg extends Operator1arg {

    protected Expression exp2;

    @Override
    public abstract double calculate();
}
