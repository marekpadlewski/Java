package calculations;

public abstract class Expression implements Calculable {

    public static double add(Expression... wyr) {
        double sum = 0;

        for(Expression exp : wyr){

            sum += exp.calculate();
        }

        return sum;
    }

    public static double multiply(Expression... wyr){
        double product = 1;

        for(Expression exp : wyr){
            product *= exp.calculate();
        }

        return product;
    }

}
