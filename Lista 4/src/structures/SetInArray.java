package structures;

public class SetInArray extends Set {

    /**Pole przechowujące tablicę par*/
    protected Pair array[];
    /**Pole przechowujace maksymalny dopuszczalny rozmiar tablicy*/
    protected int maxSize;
    /**Pole przechowujące aktualną ilość elementów w tablicy*/
    protected int currentAmount;

    /**Konstruktor przyjmujący za argument rozmiar i tworzący nowa tablice o tym rozmiarze*/
    public SetInArray(int size){
        if (size < 2)
            throw new IllegalArgumentException("Rozmiar tablicy nie może być mniejszy od 2!");

        else
        {
            array = new Pair[size];
            maxSize = size;
            currentAmount = 0;
        }
    }


    @Override
    public Pair search(String k) throws Exception {

        for (Pair e : array){
            if (e.key.equals(k))
                return e;
        }

        return null;
    }

    @Override
    public void put(Pair p) throws Exception {
        if (amount() == maxSize){
            throw new Exception("Nie można wstawić nowej pary, tablica jest pełna!");
        }

        else{
            array[amount()] = p;
            currentAmount++;
        }

    }

    @Override
    public double getValue(String k) throws Exception {
        for (Pair p : array){
            if (p.key.equals(k))
                return p.getValue();
        }

        throw new Exception("Brak pary z podanym kluczem!");
    }

    @Override
    public void update(Pair p) throws Exception {
        boolean find = false;


        for (int i = 0 ; i < amount() ; i++){
            if (array[i].equals(p)) {
                array[i] = p;
                find = true;
                break;
            }

        }

        if (!find)
            put(p);

    }

    @Override
    public void clear() {
        array = new Pair[maxSize];
        currentAmount = 0;
    }

    @Override
    public int amount() {
        return currentAmount;
    }

    public void printSet(){
        for (Pair e : array){

            if (e == null)
                break;

            System.out.println(e.toString());
        }
    }
}
