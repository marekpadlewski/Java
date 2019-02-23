package calculations;

public class Sinus extends Operator1arg {

    public Sinus(Expression a) {
        this.exp1 = a;
    }

    /**
     * Metoda calculate() nadpisana z abstrakcyjnej klasy Operator2Arg obliczajaca Sinus wyrażenia
     *
     * @return double
     */
    @Override
    public double calculate() {
        return Math.sin(exp1.calculate());
    }


    /**
     * Metoda toString() nadpisana z abstrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "sin(" + exp1.toString() + ")";
    }


    /**
     * Metoda sprawdzająca czy dane dwa obiekty Sinus są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        Sinus other = (Sinus)o;

        return this.exp1 == other.exp1;
    }
}
