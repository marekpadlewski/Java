package geometry;

public class Triangle implements Figure{

    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point x, Point y, Point z){

        double area = Math.abs((y.getX()-x.getX()) * (z.getY()-x.getY())
                        - (y.getY()-x.getY()) * (z.getX()-x.getX()))/2.0;


        if (area <= 0)
            throw new IllegalArgumentException("Z podanych punktów nie można utworzyć trójkąta!");

        else {
            a = x;
            b = y;
            c = z;
        }
    }

    @Override
    public void move(Vector v) {
        a.setX(a.getX() + v.dx);
        a.setY(a.getY() + v.dy);
        b.setX(b.getX() + v.dx);
        b.setY(b.getY() + v.dy);
        c.setX(c.getX() + v.dx);
        c.setY(c.getY() + v.dy);

    }

    @Override
    public void turn(Point p, double angle) {
        a.setX((a.getX() - p.getX()) * Math.cos(angle) + (a.getY() - p.getY()) * Math.sin(angle) + p.getX());
        a.setY(Math.abs((a.getX() - p.getX()) * Math.sin(angle) - (a.getY() - p.getY()) * Math.cos(angle) - p.getY()));
        b.setX((b.getX() - p.getX()) * Math.cos(angle) + (b.getY() - p.getY()) * Math.sin(angle) + p.getX());
        b.setY(Math.abs((b.getX() - p.getX()) * Math.sin(angle) - (b.getY() - p.getY()) * Math.cos(angle) - p.getY()));
        c.setX((c.getX() - p.getX()) * Math.cos(angle) + (c.getY() - p.getY()) * Math.sin(angle) + p.getX());
        c.setY(Math.abs((c.getX() - p.getX()) * Math.sin(angle) - (c.getY() - p.getY()) * Math.cos(angle) - p.getY()));

    }

    @Override
    public void reflect(Line l) {
       double A = l.a/-l.b;

        a.setX((1-A*A)/(1+A*A)*a.getX() + 2*A/(1+A*A)*a.getY());
        a.setY(2*A/(1+A*A)*a.getX() - (1-A*A)/(1+A*A)*a.getY());
        b.setX((1-A*A)/(1+A*A)*b.getX() + 2*A/(1+A*A)*b.getY());
        b.setY(2*A/(1+A*A)*b.getX() - (1-A*A)/(1+A*A)*b.getY());
        c.setX((1-A*A)/(1+A*A)*c.getX() + 2*A/(1+A*A)*c.getY());
        c.setY(2*A/(1+A*A)*c.getX() - (1-A*A)/(1+A*A)*c.getY());
    }
}
