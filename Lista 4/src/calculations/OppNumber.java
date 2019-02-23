package calculations;

public class OppNumber extends Operator1arg {

    public OppNumber(Expression a) {
        this.exp1 = a;
    }

    /**
     * Metoda calculate() nadpisana z OppNumbertrakcyjnej klasy Operator1Arg obliczająca przeciwieństwo wyrażenia
     *
     * @return double
     */
    @Override
    public double calculate() {
        return -exp1.calculate();
    }


    /**
     * Metoda toString() nadpisana z OppNumbertrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "-" + exp1.toString();
    }


    /**
     * Metoda sprawdzająca czy dane dwa obiekty OppNumber są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        OppNumber other = (OppNumber)o;

        return this.exp1 == other.exp1;
    }
}
