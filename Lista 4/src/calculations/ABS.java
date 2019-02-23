package calculations;

public class ABS extends Operator1arg {

    public ABS(Expression a) {
        this.exp1 = a;
    }

    /**
     * Metoda calculate() nadpisana z abstrakcyjnej klasy Operator1Arg obliczajaca wartość bezwzględną wyrażenia
     *
     * @return double
     */
    @Override
    public double calculate() {
        return Math.abs(exp1.calculate());
    }


    /**
     * Metoda toString() nadpisana z abstrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "|" + exp1.toString() + "|";
    }


    /**
     * Metoda sprawdzająca czy dane dwa obiekty ABS są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        ABS other = (ABS)o;

        return this.exp1 == other.exp1;
    }
}
