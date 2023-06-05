import org.jfree.fx.FXGraphics2D;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Random;

public class Vector2D extends Point2D implements Serializable {

    /**
     * The X coordinate of this <code>Vector2D</code>
     */
    private double x;

    /**
     * The Y coordinate of this <code>Vector2D</code>
     */
    private double y;

    /**
     * Constructs and initializes a <code>Vector2D</code> with
     * coordinates (0, 0)
     */
    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }


    /**
     * Constructs and initializes a <code>Vector2D</code> with
     * the given x and y coordinates
     *
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Constructs and initializes a <code>Vector2D</code> and
     * copies the point's coordinates
     *
     * @param p the <code>Point2D</code> to set this <code>Vector2D</code> to
     */
    public Vector2D(Point2D p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * @return the x coordinate
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * @return the y coordinate
     */
    @Override
    public double getY() {
        return this.y;
    }


    /**
     * Uses the pythagorean theorem to calculate the length/distance squared
     *
     * @return the length/distance squared of this <code>Vector2D</code>
     */
    public double getLengthSq() {
        return (this.x * this.x) + (this.y * this.y);
    }



    /**
     * Uses the pythagorean theorem to calculate the length/distance
     * of the vector
     *
     * @return the length/distance of the <code>Vector2D</code>
     */
    public double getLength() {
        return Math.sqrt(this.getLengthSq());
    }

    /**
     * Uses the inverse of the tangent function
     * to calculate the direction of the <code>Vector2D</code>
     *
     * @return the direction of a vector in radians
     */
    public double getDirection() {
        return Math.atan2(this.y, this.x);
    }

    /**
     * Sets the location of this <code>Vector2D</code> to the
     * specified coordinates.
     *
     * @param x the new X coordinate of this <code>Vector2D</code>
     * @param y the new Y coordinate of this <code>Vector2D</code>
     */
    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the location of this <code>Vector2D</code> to the same
     * coordinates as the specified <code>Point2D</code> object.
     *
     * @param p the specified <code>Point2D</code> to which to set
     *          this <code>Vector2D</code>
     */
    public void setLocation(Point2D p) {
        this.setLocation(p.getX(), p.getY());
    }

    /**
     * Sets the location of this <code>Vector2D</code> to the
     * specified X coordinate.
     *
     * @param x the new X coordinate of this {@code Vector2D}
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the location of this <code>Vector2D</code> to the
     * specified Y coordinate.
     *
     * @param y the new Y coordinate of this {@code Vector2D}
     */
    public void setY(double y) {
        this.y = y;
    }

    public void addX(double x) {
        this.x += x;
    }

    public void addY(double y) {
        this.y += y;
    }


    /**
     * Sets the location of this <code>Vector2D</code> to
     * random coordinates between 0 and the given coordinates.
     *
     * @param maxX the maximum value the new X coordinate can be
     * @param maxY the maximum value the new Y coordinate can be
     */
    public void setRandom(double maxX, double maxY) {
        this.setLocation(Math.random() * maxX, Math.random() * maxY);
    }

    /**
     * Normalizes this <code>Vector2D</code>
     * sets the length of this <code>Vector2D</code> to 1
     *
     * @return this <code>Vector2D</code>
     */
    public Vector2D normalize() {
        double length = this.getLength();

        this.setX(this.x / length);
        this.setY(this.y / length);

        return this;
    }

    /**
     * Scales the length/distance of this <code>Vector2D</code>
     * to match the given length
     *
     * @param length the new length of the <code>Vector2D</code>
     *
     * @return this <code>Vector2D</code>
     */
    public Vector2D setLength(double length) {
        this.normalize();

        this.setX(this.x * length);
        this.setY(this.y * length);

        return this;
    }

    /**
     * Rotates this <code>Vector2D</code> by an amount of degrees
     *
     * @param degrees the amount of degrees this <code>Vector2D</code> should rotate
     *
     * @return this <code>Vector2D</code>
     */
    public Vector2D rotate(double degrees) {
        double radians = Math.toRadians(degrees);

        double newX = this.x * Math.cos(radians) - this.y * Math.sin(radians);
        double newY = this.x * Math.sin(radians) + this.y * Math.cos(radians);

        this.setLocation(newX, newY);

        return this;
    }

    /**
     * Scales this <code>Vector2D</code> by the given amount
     *
     * @param scalar how much this <code>Vector2D</code> should be scaled by
     *
     * @return this <code>Vector2D</code>
     */
    public Vector2D scale(double scalar) {
        this.setLocation(this.x * scalar, this.y * scalar);

        return this;
    }

    /**
     * Vector addition
     *
     * @param p adds its values to this <code>Vector2D</code>
     *
     * @return this <code>Vector2D</code>
     */
    public Vector2D add(Point2D p) {
        this.setLocation(this.x + p.getX(), this.y + p.getY());

        return this;
    }

    /**
     * Vector subtraction
     *
     * @param p subtracts its values to this <code>Vector2D</code>
     *
     * @return this <code>Vector2D</code>
     */
    public Vector2D subtract(Point2D p) {
        this.setLocation(this.x - p.getX(), this.y - p.getY());

        return this;
    }

    /**
     * Gives a visualisation of this <code>Vector2D</code>
     *
     * <p>
     * Draws the vector with the origin on the given location
     *
     * @param graphics the tool used to draw the <code>Vector2D</code>
     * @param location the location where this <code>Vector2D</code> should be drawn
     */
    public void drawVector(FXGraphics2D graphics, Point2D location) {
        graphics.draw(new Line2D.Double(location.getX(), location.getY(),
                location.getX() + this.x, location.getY() + this.y));
    }

    /**
     * Returns a <code>String</code> that represents the value
     * of this <code>Vector2D</code>.
     *
     * @return a string representation of this <code>Vector2D</code>.
     */
    @Override
    public String toString() {
        return "Vector2D[" + this.x + ", " + this.y + "]";
    }
}