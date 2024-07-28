package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class am implements at {

    /* renamed from: a  reason: collision with root package name */
    public static am f6281a = new am();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            long[] jArr = (long[]) obj;
            baVar.a('[');
            for (int i2 = 0; i2 < jArr.length; i2++) {
                if (i2 != 0) {
                    baVar.a(',');
                }
                baVar.a(jArr[i2]);
            }
            baVar.a(']');
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
