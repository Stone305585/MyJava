package enum_study;

/**
 * Created by Stone on 2017/7/26.
 *
 * @author Stone<Stone305585@live.com>
 */
public enum Planet {

    MERCURY(3.302e+23, 2.439e6),

    VENUS(4.869e+24, 6.052e6);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double getSurfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}
