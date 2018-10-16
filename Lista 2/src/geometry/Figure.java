package geometry;

public interface Figure {

    void move(Vector v);

    void turn(Point p, double angle);

    void reflect(Line l);
}
