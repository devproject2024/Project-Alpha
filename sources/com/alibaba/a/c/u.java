package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

public final class u implements at {

    /* renamed from: a  reason: collision with root package name */
    public static u f6335a = new u();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            Type type2 = null;
            int i2 = 0;
            if (ahVar.b(bb.WriteClassName) && (type instanceof ParameterizedType)) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Enumeration enumeration = (Enumeration) obj;
            ax axVar = ahVar.j;
            ahVar.a(axVar, obj, obj2, 0);
            try {
                baVar.b('[');
                while (enumeration.hasMoreElements()) {
                    Object nextElement = enumeration.nextElement();
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        baVar.b(',');
                    }
                    if (nextElement == null) {
                        baVar.write("null");
                    } else {
                        ahVar.a(nextElement.getClass()).a(ahVar, nextElement, Integer.valueOf(i3 - 1), type2);
                    }
                    i2 = i3;
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
