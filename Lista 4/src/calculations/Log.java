package calculations;

public class Log extends Operator2arg {
    
    public Log(Expression a, Expression b) {
        this.exp1 = a;
        this.exp2 = b;
    }

    /**
     * Metoda calculate() nadpisana z abstrakcyjnej klasy Operator2Arg obliczajaca logarytm o podstawie a z b
     *
     * @return double
     */
    @Override
    public double calculate() {
        return Math.log(exp2.calculate()) / Math.log(exp1.calculate());
    }


    /**
     * Metoda toString() nadpisana z abstrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "log(" + exp1.toString() + "," + exp2.toString() + ")";
    }


    /**
     * Metoda sprawdzająca czy dane dwa obiekty Log są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        Log other = (Log)o;

        return this.exp1 == other.exp1 && this.exp2 == other.exp2;
    }
}
