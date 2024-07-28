package com.google.zxing.client.a;

import com.google.zxing.a;
import com.google.zxing.e.aa;
import com.google.zxing.r;

public final class t extends u {
    public final /* synthetic */ q a(r rVar) {
        a aVar = rVar.f40580d;
        if (aVar != a.UPC_A && aVar != a.UPC_E && aVar != a.EAN_8 && aVar != a.EAN_13) {
            return null;
        }
        String b2 = b(rVar);
        if (!a((CharSequence) b2, b2.length())) {
            return null;
        }
        return new s(b2, (aVar == a.UPC_E && b2.length() == 8) ? aa.b(b2) : b2);
    }
}
