package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public final class ak implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final ak f6279a = new ak();

    /* JADX INFO: finally extract failed */
    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ah ahVar2 = ahVar;
        Object obj3 = obj;
        Object obj4 = obj2;
        Type type2 = type;
        boolean b2 = ahVar2.b(bb.WriteClassName);
        ba baVar = ahVar2.f6266a;
        Type type3 = (!b2 || !(type2 instanceof ParameterizedType)) ? null : ((ParameterizedType) type2).getActualTypeArguments()[0];
        if (obj3 != null) {
            List list = (List) obj3;
            if (list.size() == 0) {
                baVar.append((CharSequence) "[]");
                return;
            }
            ax axVar = ahVar2.j;
            ahVar2.a(axVar, obj3, obj4, 0);
            try {
                if (baVar.b(bb.PrettyFormat)) {
                    baVar.b('[');
                    ahVar.b();
                    int i2 = 0;
                    for (Object next : list) {
                        if (i2 != 0) {
                            baVar.b(',');
                        }
                        ahVar.d();
                        if (next == null) {
                            ahVar2.f6266a.write("null");
                        } else if (ahVar2.a(next)) {
                            ahVar2.b(next);
                        } else {
                            at a2 = ahVar2.a(next.getClass());
                            ahVar2.j = new ax(axVar, obj3, obj4, 0);
                            a2.a(ahVar2, next, Integer.valueOf(i2), type3);
                        }
                        i2++;
                    }
                    ahVar.c();
                    ahVar.d();
                    baVar.b(']');
                    ahVar2.j = axVar;
                    return;
                }
                baVar.b('[');
                int i3 = 0;
                for (Object next2 : list) {
                    if (i3 != 0) {
                        baVar.b(',');
                    }
                    if (next2 == null) {
                        baVar.append((CharSequence) "null");
                    } else {
                        Class<?> cls = next2.getClass();
                        if (cls == Integer.class) {
                            baVar.a(((Integer) next2).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) next2).longValue();
                            if (b2) {
                                baVar.a(longValue, 'L');
                            } else {
                                baVar.a(longValue);
                            }
                        } else {
                            ahVar2.j = new ax(axVar, obj3, obj4, 0);
                            if (ahVar2.a(next2)) {
                                ahVar2.b(next2);
                            } else {
                                ahVar2.a(next2.getClass()).a(ahVar2, next2, Integer.valueOf(i3), type3);
                            }
                        }
                    }
                    i3++;
                }
                baVar.b(']');
                ahVar2.j = axVar;
            } catch (Throwable th) {
                ahVar2.j = axVar;
                throw th;
            }
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
