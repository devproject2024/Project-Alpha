package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public final class n implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final n f6327a = new n();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            Type type2 = null;
            int i2 = 0;
            if (ahVar.b(bb.WriteClassName) && (type instanceof ParameterizedType)) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Collection collection = (Collection) obj;
            ax axVar = ahVar.j;
            ahVar.a(axVar, obj, obj2, 0);
            if (ahVar.b(bb.WriteClassName)) {
                if (HashSet.class == collection.getClass()) {
                    baVar.append((CharSequence) "Set");
                } else if (TreeSet.class == collection.getClass()) {
                    baVar.append((CharSequence) "TreeSet");
                }
            }
            try {
                baVar.b('[');
                for (Object next : collection) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        baVar.b(',');
                    }
                    if (next == null) {
                        baVar.write("null");
                    } else {
                        Class<?> cls = next.getClass();
                        if (cls == Integer.class) {
                            baVar.a(((Integer) next).intValue());
                        } else if (cls == Long.class) {
                            baVar.a(((Long) next).longValue());
                            if (baVar.b(bb.WriteClassName)) {
                                baVar.a('L');
                            }
                        } else {
                            ahVar.a(cls).a(ahVar, next, Integer.valueOf(i3 - 1), type2);
                        }
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
