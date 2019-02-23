package calculations;

public class Number extends Expression {

    private double value;

    public Number(double value){
        this.value = value;
    }

    @Override
    public double calculate() {
        return value;
    }

    /**
     * Metoda toString() nadpisana z abstrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString() {
        return "" + value;
    }


    /**
     * Metoda sprawdzająca czy dane dwa obiekty Number są sobie równe
     *
     * @return boolean
     * */
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;

        Number other = (Number) o;

        return this.value == other.value;
    }
}
