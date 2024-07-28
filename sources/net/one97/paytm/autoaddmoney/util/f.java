package net.one97.paytm.autoaddmoney.util;

import java.util.Calendar;
import kotlin.g.b.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f49285a = new f();

    private f() {
    }

    public static String a(String str) {
        k.c(str, "inputYear");
        String valueOf = String.valueOf(Calendar.getInstance().get(1) / 100);
        StringBuilder sb = new StringBuilder(str);
        sb.insert(0, valueOf);
        String sb2 = sb.toString();
        k.a((Object) sb2, "newExpiryValidity.toString()");
        return sb2;
    }
}
