package structures;

import java.util.Objects;

/**Klasa przedstawiająca parę klucz - wartość*/
public class Pair {
    /**Pole przechowujące klucz*/
    public final String key;
    /**Pole przechowujące wartość*/
    private double value;


    public Pair(String key, double value) {
        if (Objects.equals(key, ""))
            throw new IllegalArgumentException("Klucz nie może być pustym łańcuchem!");

        this.key = key;
        this.value = value;
    }

    /**Metoda ta zwraca nam wartość danej pary*/
    public double getValue() {
        return value;
    }

    /**Metoda ta ustawia wartość danej pary za pomocą parametru value*/
    public void setValue(double value) {
        this.value = value;
    }

    /**Metoda służąca do ładnego przekonwertowania pary w napis string*/
    public String toString(){
        return "(" + key + "," + value + ")";
    }

    /**Metoda sprawdzająca czy dane dwie obiekty Pair są sobie równe*/
    public boolean equals(Object o){

        if (getClass() != o.getClass())
            return false;


        Pair other = (Pair)o;

        return this.key.equals(other.key);
    }
}
