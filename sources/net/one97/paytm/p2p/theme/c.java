package net.one97.paytm.p2p.theme;

final class c {
    static float b(float f2) {
        double d2;
        double d3;
        double d4;
        double d5 = (double) f2;
        if (d5 < 0.36363636363636365d) {
            d4 = 7.5625d * d5 * d5;
        } else {
            if (d5 < 0.7272727272727273d) {
                double d6 = (double) ((float) (d5 - 0.5454545454545454d));
                d2 = 7.5625d * d6 * d6;
                d3 = 0.75d;
            } else if (d5 < 0.9090909090909091d) {
                double d7 = (double) ((float) (d5 - 0.8181818181818182d));
                d2 = 7.5625d * d7 * d7;
                d3 = 0.9375d;
            } else {
                double d8 = (double) ((float) (d5 - 0.9545454545454546d));
                d2 = 7.5625d * d8 * d8;
                d3 = 0.984375d;
            }
            d4 = d2 + d3;
        }
        return (float) d4;
    }

    static float a(float f2, double d2) {
        return (float) (1.0d - Math.pow((double) (1.0f - f2), d2));
    }

    static float b(float f2, double d2) {
        float f3 = f2 * 2.0f;
        if (f3 < 1.0f) {
            return (float) (Math.pow((double) f3, d2) * 0.5d);
        }
        return (float) (1.0d - (Math.abs(Math.pow((double) (2.0f - f3), d2)) * 0.5d));
    }

    static float a(float f2) {
        return 1.0f - b(1.0f - f2);
    }
}
