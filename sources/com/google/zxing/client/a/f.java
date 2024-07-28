package com.google.zxing.client.a;

import com.google.zxing.r;

public final class f extends a {
    public final /* synthetic */ q a(r rVar) {
        String str = rVar.f40577a;
        if (!str.startsWith("MEBKM:")) {
            return null;
        }
        String a2 = a("TITLE:", str, true);
        String[] a3 = a("URL:", str);
        if (a3 == null) {
            return null;
        }
        String str2 = a3[0];
        if (ad.a(str2)) {
            return new ac(str2, a2);
        }
        return null;
    }
}
