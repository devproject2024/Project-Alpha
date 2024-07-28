package kotlin.m;

import kotlin.g.b.k;

public class w extends v {
    public static final Double b(String str) {
        k.d(str, "$this$toDoubleOrNull");
        try {
            if (o.f47994a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
