package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.c;
import com.google.zxing.d;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.r;
import java.util.Map;

public final class t extends y {

    /* renamed from: a  reason: collision with root package name */
    private final y f40392a = new i();

    public final r a(int i2, a aVar, int[] iArr, Map<e, ?> map) throws m, h, d {
        return a(this.f40392a.a(i2, aVar, iArr, map));
    }

    public final r a(int i2, a aVar, Map<e, ?> map) throws m, h, d {
        return a(this.f40392a.a(i2, aVar, map));
    }

    public final r a(c cVar, Map<e, ?> map) throws m, h {
        return a(this.f40392a.a(cVar, map));
    }

    /* access modifiers changed from: package-private */
    public final com.google.zxing.a b() {
        return com.google.zxing.a.UPC_A;
    }

    /* access modifiers changed from: protected */
    public final int a(a aVar, int[] iArr, StringBuilder sb) throws m {
        return this.f40392a.a(aVar, iArr, sb);
    }

    private static r a(r rVar) throws h {
        String str = rVar.f40577a;
        if (str.charAt(0) == '0') {
            r rVar2 = new r(str.substring(1), (byte[]) null, rVar.f40579c, com.google.zxing.a.UPC_A);
            if (rVar.f40581e != null) {
                rVar2.a(rVar.f40581e);
            }
            return rVar2;
        }
        throw h.getFormatInstance();
    }
}
