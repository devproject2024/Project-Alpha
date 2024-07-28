package com.google.zxing.client.a;

import com.google.zxing.r;
import java.util.regex.Pattern;

public final class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f40055a = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    static boolean a(String str) {
        return str != null && f40055a.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    public final /* synthetic */ q a(r rVar) {
        String[] a2;
        String b2 = b(rVar);
        if (!b2.startsWith("MATMSG:") || (a2 = a("TO:", b2)) == null) {
            return null;
        }
        for (String a3 : a2) {
            if (!a(a3)) {
                return null;
            }
        }
        return new h(a2, (String[]) null, (String[]) null, a("SUB:", b2, false), a("BODY:", b2, false));
    }
}
