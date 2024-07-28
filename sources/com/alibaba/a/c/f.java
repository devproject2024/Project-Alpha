package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class f implements at {

    /* renamed from: a  reason: collision with root package name */
    public static f f6319a = new f();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            boolean[] zArr = (boolean[]) obj;
            baVar.a('[');
            for (int i2 = 0; i2 < zArr.length; i2++) {
                if (i2 != 0) {
                    baVar.a(',');
                }
                if (zArr[i2]) {
                    baVar.write("true");
                } else {
                    baVar.write("false");
                }
            }
            baVar.a(']');
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
