package calculations;

public class Min extends Operator2arg {

    public Min(Expression a, Expression b) {
        this.exp1 = a;
        this.exp2 = b;
    }

    /**
     * Metoda calculate() nadpisana z abstrakcyjnej klasy Operator2Arg obliczajaca min z dwóch wyrażeń
     *
     * @return double
     */
    @Override
    public double calculate() {
        return Math.min(exp1.calculate(), exp2.calculate());
    }


    /**
     * Metoda toString() nadpisana z abstrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "min(" + exp1.toString() + "," + exp2.toString() + ")";
    }

    
    /**
     * Metoda sprawdzająca czy dane dwa obiekty Min są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        Min other = (Min)o;

        return this.exp1 == other.exp1 && this.exp2 == other.exp2;
    }
}
