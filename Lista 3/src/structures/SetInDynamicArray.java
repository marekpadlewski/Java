package structures;

public class SetInDynamicArray extends SetInArray {

    /**Kontruktor odwouje sie do konstruktora klasy SetInArray, tworzac tablice o rozmiarze 2*/
    public SetInDynamicArray() {
        super(2);
    }

    @Override
    public void put(Pair p) throws Exception {

        if (amount() == maxSize){

            maxSize *= 2;

            Pair[] newArray = new Pair[maxSize];

            System.arraycopy(array, 0, newArray, 0, amount());

            array = newArray;
        }

        array[amount()] = p;
        currentAmount++;

    }


}
