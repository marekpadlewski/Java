import calculations.*;
import calculations.Number;

public class Main {

    public static void main(String args[]) throws Exception {

        Variable.addVariable("x", 2.0);
        Variable.addVariable("y", 17.0);

        Expression e1 = new Add(
                new Number(3),
                new Number(5));

        System.out.println(e1.toString() + " = " + e1.calculate());

        Expression e2 = new Add(
                new Number(2),
                new Mult(new Variable("x"),
                         new Number(7)));

        System.out.println(e2.toString() + " = " + e2.calculate());

        Expression e3 = new Div(
                new Sub(
                        new Mult(new Number(3),
                                 new Number(11)),
                        new Number(1)),
                new Add(new Number(7),
                        new Number(5)));


        System.out.println(e3.toString() + " = " + e3.calculate());



        Expression e4 = new Arctan(
                new Div(
                        new Mult(
                                new Add(new Variable("x"),
                                        new Number(13)),
                                new Variable("x")),
                        new Number(2)));

        System.out.println(e4.toString() + " = " + e4.calculate());

        Expression e5 = new Add(
                new Power(new Number(2),
                        new Number(5)),
                new Mult(new Variable("x"),
                        new Log(new Number(2),
                                new Variable("y"))));

        System.out.println(e5.toString() + " = " + e5.calculate());

    }
}
