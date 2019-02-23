package calculations;

public class Arctan extends Operator1arg {
    
    public Arctan(Expression a) {
        this.exp1 = a;
    }

    /**
     * Metoda calculate() nadpisana z Arctantrakcyjnej klasy Operator1Arg obliczajaca Arctan wyrażenia
     *
     * @return double
     */
    @Override
    public double calculate() {
        return Math.atan(exp1.calculate());
    }


    /**
     * Metoda toString() nadpisana z Arctantrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "arctan(" + exp1.toString() + ")";
    }


    /**
     * Metoda sprawdzająca czy dane dwa obiekty Arctan są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        Arctan other = (Arctan)o;

        return this.exp1 == other.exp1;
    }
}
