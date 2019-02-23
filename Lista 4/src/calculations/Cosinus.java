package calculations;

public class Cosinus extends Operator1arg {

    public Cosinus(Expression a) {
        this.exp1 = a;
    }

    /**
     * Metoda calculate() nadpisana z klasy Operator1Arg obliczajaca Cosinus wyrażenia
     *
     * @return double
     */
    @Override
    public double calculate() {
        return Math.cos(exp1.calculate());
    }


    /**
     * Metoda toString() nadpisana z abstrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "cos(" + exp1.toString() + ")";
    }


    /**
     * Metoda sprawdzająca czy dane dwa obiekty Cosinus są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        Cosinus other = (Cosinus)o;

        return this.exp1 == other.exp1;
    }
}
