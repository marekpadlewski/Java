package geometry;

public class Segment implements Figure {
    public Point start;
    public Point end;

    public Segment(Point a, Point b){

        start = a;
        end = b;
    }

    @Override
    public void move(Vector v) {
        start.setX(start.getX() + v.dx);
        start.setY(start.getY() + v.dy);
        end.setX(end.getX() + v.dx);
        end.setY(end.getY() + v.dy);
    }

    @Override
    public void turn(Point p, double angle) {
        start.setX((start.getX() - p.getX()) * Math.cos(angle) + (start.getY() - p.getY()) * Math.sin(angle) + p.getX());
        start.setY(Math.abs((start.getX() - p.getX()) * Math.sin(angle) - (start.getY() - p.getY()) * Math.cos(angle) - p.getY()));
        end.setX((end.getX() - p.getX()) * Math.cos(angle) + (end.getY() - p.getY()) * Math.sin(angle) + p.getX());
        end.setY(Math.abs((end.getX() - p.getX()) * Math.sin(angle) - (end.getY() - p.getY()) * Math.cos(angle) - p.getY()));
    }

    @Override
    public void reflect(Line l) {
        double A = l.a/-l.b;

        start.setX((1-A*A)/(1+A*A)*start.getX() + 2*A/(1+A*A)*start.getY());
        start.setY(2*A/(1+A*A)*start.getX() - (1-A*A)/(1+A*A)*start.getY());
        end.setX((1-A*A)/(1+A*A)*end.getX() + 2*A/(1+A*A)*end.getY());
        end.setY(2*A/(1+A*A)*end.getX() - (1-A*A)/(1+A*A)*end.getY());
    }
}
