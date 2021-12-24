package com.simulation.cannonball_simulator;

import java.awt.Point;
import java.util.ArrayList;

public class CannonBall {

    // Attributi
    private final Point posizione;

    // Costruttore
    public CannonBall(int x) {
        this.posizione = new Point(x, 0);
    }

    // Metodi
    public Point getPosition() {
        return new Point((int) this.posizione.getX(), (int) this.posizione.getY());
    }

    public void setPosition(int a, int b) { this.posizione.setLocation(a, b); }

    /**
     * This method moves the ball by using the bullet motion equations
     * of the position.
     * @param v is the initial speed
     * @param a is the angle between the bullet and X axis
     * @param t indicates how much big the time interval must be
     */
    public void move(double v, double a, double t) {

        double cos = Math.cos(Math.toRadians(a)); // Cosine of alpha
        double sin = Math.sin(Math.toRadians(a)); // Sine of alpha

        double new_x = (v*t*cos);
        double new_y = ( (v*t* sin) - ( (9.81*t*t) / 2) );

        this.posizione.setLocation(new_x, new_y);

    }

    /**
     * This method is used to shoot the bullet, it iterates on the move method to move the bullet.
     * @param a is the angle between the bullet and X axis
     * @param v is the initial speed
     * @param dS indicates how much big the time interval must be
     * @return an ArrayList of points that will be later converted to be plotted
     */
    public ArrayList<Point> shoot(double a, double v, double dS) {

        ArrayList<Point> res = new ArrayList<>(); // ArrayList of points

        res.add(this.getPosition());

        while ((int) this.getPosition().getY() >= 0) {

            move(v, a, dS);
            dS = dS + 0.2;
            res.add(this.getPosition());
        }

        Point lastP = res.remove(res.size() -1); // Removes the last point that is negative on Y axis
        lastP.setLocation(lastP.getX(), 0); // Sets the negative point to 0
        res.add(res.size(), lastP);

        return res;
    }

    public String toString() {
        return "(" + this.posizione.getX() + ", " + this.posizione.getY() + ")";
    }
}
