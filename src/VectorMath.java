import java.awt.geom.Point2D;

public class VectorMath {
    public static final double PI2 = Math.PI * 2;

    public static double dot(Point2D p1, Point2D p2) {
        return (p1.getX() * p2.getX()) + (p1.getY() * p2.getY());
    }

    public static Vector2D sum(Point2D... p) {
        double sumX = 0;
        double sumY = 0;

        for (Point2D point : p) {
            sumX += point.getX();
            sumY += point.getY();
        }

        return new Vector2D(sumX, sumY);
    }

    public static Vector2D subtract(Point2D p1, Point2D p2) {
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();

        return new Vector2D(x, y);
    }

    public static Vector2D scale(Point2D p, double scalar) {
        double x = p.getX() * scalar;
        double y = p.getY() * scalar;

        return new Vector2D(x, y);
    }

    public static double distanceBetween(Point2D p1, Point2D p2) {
        Vector2D v = VectorMath.subtract(p1, p2);

        return v.getLength();
    }

    public static double distanceBetweenSq(Point2D p1, Point2D p2) {
        Vector2D v = VectorMath.subtract(p1, p2);

        return v.getLengthSq();
    }

    public static double relativeAngle(Point2D origin, Point2D pointer) {
        Vector2D v = subtract(pointer, origin);

        return v.getDirection();
    }

    public static Vector2D normalise(Point2D p) {
        double length = p.distance(0, 0);

        double x = (p.getX() / length);
        double y = (p.getY() / length);

        return new Vector2D(x, y);
    }

    public static Vector2D average(Point2D... p) {
        Vector2D average = VectorMath.sum(p);
        average.scale(1.0 / p.length);

        return average;
    }
}