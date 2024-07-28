package androidx.constraintlayout.motion.a;

import java.util.Arrays;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static c f2207a = new c();

    /* renamed from: c  reason: collision with root package name */
    public static String[] f2208c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: b  reason: collision with root package name */
    String f2209b = "identity";

    public double a(double d2) {
        return d2;
    }

    public double b(double d2) {
        return 1.0d;
    }

    public static c a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return new a("cubic(0.4, 0.0, 0.2, 1)");
        }
        if (c2 == 1) {
            return new a("cubic(0.4, 0.05, 0.8, 0.7)");
        }
        if (c2 == 2) {
            return new a("cubic(0.0, 0.0, 0.2, 0.95)");
        }
        if (c2 == 3) {
            return new a("cubic(1, 1, 0, 0)");
        }
        new StringBuilder("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ").append(Arrays.toString(f2208c));
        return f2207a;
    }

    public String toString() {
        return this.f2209b;
    }

    static class a extends c {

        /* renamed from: h  reason: collision with root package name */
        private static double f2210h = 0.01d;

        /* renamed from: i  reason: collision with root package name */
        private static double f2211i = 1.0E-4d;

        /* renamed from: d  reason: collision with root package name */
        double f2212d;

        /* renamed from: e  reason: collision with root package name */
        double f2213e;

        /* renamed from: f  reason: collision with root package name */
        double f2214f;

        /* renamed from: g  reason: collision with root package name */
        double f2215g;

        a(String str) {
            this.f2209b = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f2212d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i2 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i2);
            this.f2213e = Double.parseDouble(str.substring(i2, indexOf3).trim());
            int i3 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i3);
            this.f2214f = Double.parseDouble(str.substring(i3, indexOf4).trim());
            int i4 = indexOf4 + 1;
            this.f2215g = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        private double c(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.f2212d * d3 * d4 * d2) + (this.f2214f * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        private double d(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.f2213e * d3 * d4 * d2) + (this.f2215g * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        public final double b(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > f2211i) {
                d3 *= 0.5d;
                d4 = c(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (d(d6) - d(d5)) / (c(d6) - c(d5));
        }

        public final double a(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > f2210h) {
                d3 *= 0.5d;
                d4 = c(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double c2 = c(d5);
            double d6 = d4 + d3;
            double c3 = c(d6);
            double d7 = d(d5);
            return (((d(d6) - d7) * (d2 - c2)) / (c3 - c2)) + d7;
        }
    }
}
