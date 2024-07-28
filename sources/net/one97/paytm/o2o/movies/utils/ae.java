package net.one97.paytm.o2o.movies.utils;

public final class ae {
    public static Double a(String str) {
        double d2;
        try {
            d2 = Double.parseDouble(str);
        } catch (Exception unused) {
            d2 = 0.0d;
        }
        return Double.valueOf(d2);
    }
}
