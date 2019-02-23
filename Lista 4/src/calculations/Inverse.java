package calculations;

public class Inverse extends Operator1arg {
    
    public Inverse(Expression a) {
        this.exp1 = a;
    }

    /**
     * Metoda calculate() nadpisana z Inversetrakcyjnej klasy Operator1Arg obliczajaca inwersję wyrażenia
     *
     * @return double
     */
    @Override
    public double calculate() {
        return 1.0 / exp1.calculate();
    }


    /**
     * Metoda toString() nadpisana z Inversetrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "1/" + exp1.toString();
    }


    /**
     * Metoda sprawdzająca czy dane dwa obiekty Inverse są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        Inverse other = (Inverse)o;

        return this.exp1 == other.exp1;
    }
}
