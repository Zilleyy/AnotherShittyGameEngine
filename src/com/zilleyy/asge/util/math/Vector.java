package com.zilleyy.asge.util.math;

/**
 * This class represents a vector of doubles in either two or three dimensions.
 *
 * Author - Cooper Cowley
 * Date   - 21st April, 2021 at 5.00 PM
 */
public final class Vector {

    /**
     * The x, y and z values of the vector object.
     */
    public double x, y, z;

    /**
     * A boolean value representing whether the vector is two-dimensional,
     * <br>
     * or if it is three-dimensional.
     */
    private final transient boolean twoDimensional;

    /**
     * Creates an empty three dimensional vector.
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;

        this.twoDimensional = false;
    }

    /**
     * Creates a two dimensional vector.
     * @param x the x value of the vector.
     * @param y the y value of the vector.
     */
    public Vector(final double x, final double y) {
        this.x = x;
        this.y = y;

        this.twoDimensional = true;
    }

    /**
     * Creates a three dimensional vector.
     * @param x the x value of the vector.
     * @param y the y value of the vector.
     * @param z the z value of the vector.
     */
    public Vector(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.twoDimensional = false;
    }

    /**
     * Getter method for the twoDimensional boolean.
     * @return whether the vector is two-dimensional or not.
     */
    private final boolean isTwoDimensional() {
        return this.twoDimensional;
    }

    public final Vector set(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
        return this;
    }

    public final Vector set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Adds two vectors together.
     * @param vector the other vector.
     */
    public final Vector add(final Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
        this.z += vector.z;
        return this;
    }

    /**
     * Adds values to the x and y positions of the vector.
     * @param x the x value to add to the current position.
     * @param y the y value to add to the current position.
     */
    public final Vector add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Subtracts another vector from this vector.
     * @param vector the other vector.
     */
    public final Vector subtract(final Vector vector) {
        this.x -= vector.x;
        this.y -= vector.y;
        this.z -= vector.z;
        return this;
    }

    /**
     * Multiplies two vectors by each other.
     * @param vector the other vector.
     */
    public final Vector multiply(final Vector vector) {
        this.x *= vector.x;
        this.y *= vector.y;
        this.z *= vector.z;
        return this;
    }

    public final Vector multiply(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }

    /**
     * Divides two vectors by each other.
     * @param vector the other vector.
     */
    public final Vector divide(final Vector vector) {
        this.x /= vector.x;
        this.y /= vector.y;
        this.z /= vector.z;
        return this;
    }

    /**
     * Divides the vector by a given value.
     * @param value the value to divide by.
     */
    public final Vector divide(double value) {
        this.x /= value;
        this.y /= value;
        this.z /= value;
        return this;
    }

    /**
     * Calculates the exponent of the vector using a given value to be used as a power.
     * @param value the value to be used as a power.
     */
    public final Vector power(double value) {
        this.x = Math.pow(this.x, value);
        this.y = Math.pow(this.y, value);
        this.z = this.twoDimensional ? 0 : Math.pow(this.z, value);
        return this;
    }

    /**
     * Squares all the values of the vector.
     */
    public final Vector square() {
        this.x = Math.pow(this.x, 2);
        this.y = Math.pow(this.y, 2);
        this.z = this.twoDimensional ? 0 : Math.pow(this.z, 2);
        return this;
    }

    /**
     * Cubes all the values of the vector.
     */
    public final Vector cube() {
        this.x = Math.pow(this.x, 3);
        this.y = Math.pow(this.y, 3);
        this.z = this.twoDimensional ? 0 : Math.pow(this.z, 3);
        return this;
    }

    /**
     * Square roots all the values of the vector.
     */
    public final Vector squareRoot() {
        this.x = Math.sqrt(this.x);
        this.y = Math.sqrt(this.y);
        this.z = this.twoDimensional ? 0 : Math.sqrt(this.z);
        return this;
    }

    /**
     * @param vector the vector to find the distance from.
     * @return the distance squared between the two vectors
     */
    public final double distance(final Vector vector) {
        final double x1 = this.x, y1 = this.y, z1 = this.z, x2 = vector.x, y2 = vector.y, z2 = vector.z;
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x2) + (this.twoDimensional ? 0 : (z2 - z1) * (z2 - z1)));
    }

    /**
     * Finds the midpoint between the vector and another vector.
     * @param vector
     * @return the midpoint vector.
     */
    public final Vector midpoint(final Vector vector) {
        final double x = (Math.max(this.x, vector.x) - Math.min(this.x, vector.x)) / 2.0,
                     y = (Math.max(this.y, vector.y) - Math.min(this.y, vector.y)) / 2.0,
                     z = (Math.max(this.z, vector.z) - Math.min(this.z, vector.z)) / 2.0;
        return this.twoDimensional ? new Vector(x, y) : new Vector(x, y, z);
    }

    /**
     * Calculates the magnitude / length of the vector
     * @return the calculated value.
     */
    public final double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y + (this.twoDimensional ? 0 : this.z * this.z));
    }

    /**
     * Normalize the vector to a length of 1.
     * @return
     */
    public final Vector normalize() {
        double magnitude = this.magnitude();
        if(magnitude != 0 && magnitude != 1) this.divide(magnitude);
        return this;
    }

    public final boolean lessThan(double x, double y) {
        return this.x < x && this.y < y;
    }

    public final boolean greaterThan(double x, double y) {
        return this.x > x && this.y > y;
    }

    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + (this.twoDimensional ? "]" : ", " + this.z + "]");
    }

}
