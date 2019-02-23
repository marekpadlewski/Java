package calculations;

public class Mult extends Operator2arg {

    public Mult(Expression a, Expression b) {
        this.exp1 = a;
        this.exp2 = b;
    }

    /**
     * Metoda calculate() nadpisana z abstrakcyjnej klasy Operator2Arg obliczajaca iloraz dwóch wyrażeń
     *
     * @return double
     */
    @Override
    public double calculate() {
        return exp1.calculate() * exp2.calculate();
    }


    /**
     * Metoda toString() nadpisana z abstrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "(" + exp1.toString() + "*" + exp2.toString() + ")";
    }
    

    /**
     * Metoda sprawdzająca czy dane dwa obiekty Mult są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        Mult other = (Mult)o;

        return this.exp1 == other.exp1 && this.exp2 == other.exp2;
    }
}
