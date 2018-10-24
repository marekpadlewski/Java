import structures.Pair;
import structures.Set;
import structures.SetInArray;
import structures.SetInDynamicArray;

public class Main {

    public static void main(String args[]) throws Exception {

        Set container = new SetInArray(3);

        container.put(new Pair("abc", 1));
        container.put(new Pair("def", 2));
        container.put(new Pair("ghi", 3));
        System.out.println(container.amount());
        //container.put(new Pair("jkl", 4));
        container.update(new Pair("def", 17));
        container.printSet();


        Set dymContainer = new SetInDynamicArray();
        dymContainer.put(new Pair("abc", 1));
        dymContainer.put(new Pair("def", 2));
        System.out.println(dymContainer.amount());
        dymContainer.put(new Pair("ghi", 3));
        System.out.println(dymContainer.amount());
        dymContainer.put(new Pair("jkl", 4));
        dymContainer.update(new Pair("mno", 17));
        System.out.println("Wartość dla klucza 'jkl' : " + dymContainer.getValue("jkl"));

        dymContainer.printSet();




    }
}
