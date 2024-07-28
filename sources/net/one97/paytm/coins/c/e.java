package net.one97.paytm.coins.c;

import com.paytm.utility.b;

public final class e {
    public static String a(double d2) {
        return b.a(d2, d2 - Math.floor(d2) != 0.0d ? "##,##,##,##,##0.00" : "##,##,##,##,##0.##");
    }
}
