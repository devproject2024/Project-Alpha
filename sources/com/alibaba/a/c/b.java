package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class b implements at {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f6301a;

    /* renamed from: b  reason: collision with root package name */
    private final at f6302b;

    public b(Class<?> cls, at atVar) {
        this.f6301a = cls;
        this.f6302b = atVar;
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            ax axVar = ahVar.j;
            ahVar.a(axVar, obj, obj2, 0);
            try {
                baVar.b('[');
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 != 0) {
                        baVar.b(',');
                    }
                    Object obj3 = objArr[i2];
                    if (obj3 == null) {
                        baVar.append((CharSequence) "null");
                    } else if (obj3.getClass() == this.f6301a) {
                        this.f6302b.a(ahVar, obj3, Integer.valueOf(i2), (Type) null);
                    } else {
                        ahVar.a(obj3.getClass()).a(ahVar, obj3, Integer.valueOf(i2), (Type) null);
                    }
                }
                baVar.b(']');
            } finally {
                ahVar.j = axVar;
            }
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
