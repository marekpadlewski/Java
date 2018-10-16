package geometry;

public class Line {

    public final double a;
    public final double b;
    public final double c;

    public Line(double a, double b, double c) {
        if (a == 0 && b == 0)
            throw new IllegalArgumentException("Oba współczynniki a i b prostej nie mogą być zerami!");

        else{
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    public static Line move(Line l, Vector v){
        return new Line(l.a + v.dy, l.b - v.dx, l.c);
    }

    public static boolean isParallel(Line k, Line l){
        return k.a * l.b == k.b * l.a;
    }

    public static boolean isPerpendicular(Line k, Line l){
        return k.a * l.a == -k.b * l.b;
    }

    public static Point intersectionPoint(Line k, Line l){

        if (isParallel(k, l))
            throw new IllegalArgumentException("Proste równoległe nie mają punktu przecięcia!");

        else{
            double w = k.a * l.b - l.a * k.b;
            double wx = -k.c * l.b - -l.c * k.b;
            double wy = k.a * -l.c - l.a * -k.c;

            return new Point(wx/w, wy/w);
        }
    }
}
