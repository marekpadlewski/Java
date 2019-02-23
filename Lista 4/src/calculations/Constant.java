package calculations;

import structures.Pair;
import structures.SetInDynamicArray;

public class Constant extends Expression {

    private SetInDynamicArray setOfConstants  = new SetInDynamicArray();
    private String name;

    public Constant(String name) throws Exception {
        this.name = name;

        if (setOfConstants.amount() == 0)
            fillSet();

    }

    /**
     * Metoda wypełniająca zbiór stałych
     *
     * @throws Exception
     */
    private void fillSet() throws Exception {
        setOfConstants.put(new Pair("pi", 3.14));
        setOfConstants.put(new Pair("fi", 1.61));
        setOfConstants.put(new Pair("e", 0.57));

    }

    /**
     * Metoda zwracająca wartość danej stałej
     *
     * @return double
     */
    @Override
    public double calculate(){
        try {
            return setOfConstants.getValue(name);
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
