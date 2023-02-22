import java.awt.geom.Point2D;

public class VectorMath {
    public static final double PI2 = Math.PI * 2;

    public static double dot(Vector2D vector1, Vector2D vector2) {
        return (vector1.getX() * vector2.getX()) + (vector1.getY() * vector2.getY());
    }

    public static Vector2D sum(Vector2D... vector) {
        double x = 0;
        double y = 0;

        for (Vector2D vector2D : vector) {
            x += vector2D.getX();
            y += vector2D.getY();
        }

        return new Vector2D(x, y);
    }

    public static Vector2D subtract(Vector2D vector1, Vector2D vector2) {
        double x = vector1.getX() - vector2.getX();
        double y = vector1.getY() - vector2.getY();

        return new Vector2D(x, y);
    }

    public static double distanceBetween(Vector2D vector1, Vector2D vector2) {
        Vector2D v = VectorMath.subtract(vector1, vector2);

        return v.getLength();
    }

    public static double relativeAngle(Vector2D origin, Vector2D pointer) {
        Vector2D v = subtract(pointer, origin);

        return v.getDirection();
    }
}