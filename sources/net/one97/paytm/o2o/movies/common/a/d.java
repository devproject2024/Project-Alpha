package net.one97.paytm.o2o.movies.common.a;

import kotlin.g.b.k;
import kotlin.m.p;

public final class d {
    public static final String a(String str) {
        k.c(str, "$this$ifNotMakeHttp");
        String obj = p.b(str).toString();
        return (p.b(obj, "https://", false) || p.b(obj, "http://", false)) ? obj : "https://".concat(String.valueOf(obj));
    }

    public static final String b(String str) {
        if (str == null) {
            return null;
        }
        if (p.b(str).toString().length() == 0) {
            return null;
        }
        return str;
    }
}
