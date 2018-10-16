package geometry;

public class Vector {

    public final double dx;
    public final double dy;

    public Vector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Vector composition(Vector v, Vector w){
        return new Vector(v.dx + w.dx, v.dy + w.dy);
    }
}
