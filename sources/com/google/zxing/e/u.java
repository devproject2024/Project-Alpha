package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.v;
import com.google.zxing.w;
import java.util.Map;

public final class u implements v {

    /* renamed from: a  reason: collision with root package name */
    private final j f40393a = new j();

    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (aVar == a.UPC_A) {
            return this.f40393a.a("0".concat(String.valueOf(str)), a.EAN_13, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
    }
}
