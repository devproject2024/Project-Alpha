package it.sephiroth.android.library.easing;

public final class a implements b {
    public final double a(double d2, double d3, double d4) {
        double d5 = (d2 / d4) - 1.0d;
        return (d3 * ((d5 * d5 * d5) + 1.0d)) + 0.0d;
    }

    public final double b(double d2, double d3, double d4) {
        double d5;
        double d6 = d2 / (d4 / 2.0d);
        if (d6 < 1.0d) {
            d5 = (d3 / 2.0d) * d6 * d6 * d6;
        } else {
            double d7 = d6 - 2.0d;
            d5 = (d3 / 2.0d) * ((d7 * d7 * d7) + 2.0d);
        }
        return d5 + 0.0d;
    }
}
