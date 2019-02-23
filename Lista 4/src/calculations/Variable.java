package calculations;

import structures.Pair;
import structures.SetInDynamicArray;

public class Variable extends Expression {

    private static final SetInDynamicArray setOfVars = new SetInDynamicArray();
    private String name;

    public Variable(String name){
        this.name = name;
    }

    /**
     * Metoda dodająca parę zmienna - wartość do zbioru zmiennych
     */
    public static void addVariable(String key, double value){
        Pair p = new Pair(key, value);
        try {
            setOfVars.put(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda zwracająca wartość danej zmiennej
     *
     * @return double
     */
    @Override
    public double calculate(){
        try {
            return setOfVars.getValue(name);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Metoda toString() nadpisana z abstrakcyjnej klasy Object
     *
     * @return String
     */
    @Override
    public String toString(){
        return name;
    }
}
