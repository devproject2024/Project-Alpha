package com.google.zxing.client.a;

import com.google.zxing.a;
import com.google.zxing.r;

public final class p extends u {
    public final /* synthetic */ q a(r rVar) {
        if (rVar.f40580d != a.EAN_13) {
            return null;
        }
        String b2 = b(rVar);
        if (b2.length() != 13) {
            return null;
        }
        if (b2.startsWith("978") || b2.startsWith("979")) {
            return new o(b2);
        }
        return null;
    }
}
