import geometry.*;

public class Main {

    public static void main(String args[]){

        //Triangle t = new Triangle(new Point(0,0),new Point(1,1), new Point(2,2));
        //to jest test na rzucenie wyjatku, jak go odkomentujesz to wywali program

        //przesuwamy odcinek o wektor
        Segment s1 = new Segment(new Point(0,0), new Point(0,5));
        s1.move(new Vector(5,10));
        System.out.println("[" + s1.start.getX() + " " + s1.start.getY() + " ; " + s1.end.getX() + " " + s1.end.getY() + "]");

        System.out.println("---------------------------");

        //odbijamy trojkat symetrycznie od prostej y = 0
        Triangle t1 = new Triangle(new Point(0,0), new Point(6,0), new Point(3,10));
        t1.reflect(new Line(0,1,0));
        System.out.println("(" + t1.a.getX() + " , " + t1.a.getY() + " | " +
                t1.b.getX() + " , " + t1.b.getY() + " | " + t1.c.getX() + " , " + t1.c.getY() + ")");


        System.out.println("---------------------------");
        System.out.println("Czy proste prostopadle?");

        Line l = new Line(1,2,4);
        Line k = new Line(-2,1,7);

        if (Line.isPerpendicular(l,k))
            System.out.println("Tak!");

        else
            System.out.println("Nie!");

        Point p2 = Line.intersectionPoint(l,k);
        System.out.println("Punkt przecięcia prostych l i k: ");
        System.out.println("(" + p2.getX() + " , " + p2.getY() + ")");
    }
}
