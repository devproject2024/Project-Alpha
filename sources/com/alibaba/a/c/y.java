package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class y implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final y f6341a = new y();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            float[] fArr = (float[]) obj;
            int length = fArr.length - 1;
            if (length == -1) {
                baVar.append((CharSequence) "[]");
                return;
            }
            baVar.b('[');
            for (int i2 = 0; i2 < length; i2++) {
                float f2 = fArr[i2];
                if (Float.isNaN(f2)) {
                    baVar.write("null");
                } else {
                    baVar.append((CharSequence) Float.toString(f2));
                }
                baVar.b(',');
            }
            float f3 = fArr[length];
            if (Float.isNaN(f3)) {
                baVar.write("null");
            } else {
                baVar.append((CharSequence) Float.toString(f3));
            }
            baVar.b(']');
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
