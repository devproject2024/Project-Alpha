package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class r implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final r f6331a = new r();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            double[] dArr = (double[]) obj;
            int length = dArr.length - 1;
            if (length == -1) {
                baVar.append((CharSequence) "[]");
                return;
            }
            baVar.b('[');
            for (int i2 = 0; i2 < length; i2++) {
                double d2 = dArr[i2];
                if (Double.isNaN(d2)) {
                    baVar.write("null");
                } else {
                    baVar.append((CharSequence) Double.toString(d2));
                }
                baVar.b(',');
            }
            double d3 = dArr[length];
            if (Double.isNaN(d3)) {
                baVar.write("null");
            } else {
                baVar.append((CharSequence) Double.toString(d3));
            }
            baVar.b(']');
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
