package structures;

public abstract class Set {
    /** metoda ma szukać pary z określonym kluczem */
    public abstract Pair search (String k) throws Exception;
    /** metoda ma wstawiać do zbioru nową parę */
    public abstract void put (Pair p) throws Exception;
    /** metoda ma odszukać parę i zwrócić wartość związaną z kluczem */
    public abstract double getValue (String k) throws Exception;
    /** metoda ma wstawić do zbioru nową albo zaktualizować parę */
    public abstract void update (Pair p) throws Exception;
    /** metoda ma usunąć wszystkie pary ze zbioru */
    public abstract void clear ();
    /** metoda ma podać ile par jest przechowywanych w zbiorze */
    public abstract int amount ();
    /** metoda ma wypisać na ekran w sposób ładnie sformatowany wszystkie elementy zboru*/
    public abstract void printSet();
}
