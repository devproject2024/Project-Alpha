package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class bc implements at {

    /* renamed from: a  reason: collision with root package name */
    public static bc f6308a = new bc();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            short[] sArr = (short[]) obj;
            baVar.a('[');
            for (int i2 = 0; i2 < sArr.length; i2++) {
                if (i2 != 0) {
                    baVar.a(',');
                }
                baVar.a((int) sArr[i2]);
            }
            baVar.a(']');
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
