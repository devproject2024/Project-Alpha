package com.alibaba.a.c;

import com.alibaba.a.d;
import java.io.IOException;
import java.lang.reflect.Type;

public final class ar implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final ar f6284a = new ar();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        Object[] objArr = (Object[]) obj;
        if (obj != null) {
            int length = objArr.length;
            int i2 = length - 1;
            if (i2 == -1) {
                baVar.append((CharSequence) "[]");
                return;
            }
            ax axVar = ahVar.j;
            int i3 = 0;
            ahVar.a(axVar, obj, obj2, 0);
            try {
                baVar.b('[');
                if (baVar.b(bb.PrettyFormat)) {
                    ahVar.b();
                    ahVar.d();
                    while (i3 < length) {
                        if (i3 != 0) {
                            baVar.a(',');
                            ahVar.d();
                        }
                        ahVar.c(objArr[i3]);
                        i3++;
                    }
                    ahVar.c();
                    ahVar.d();
                    baVar.a(']');
                    ahVar.j = axVar;
                    return;
                }
                Class<?> cls = null;
                at atVar = null;
                while (i3 < i2) {
                    Object obj3 = objArr[i3];
                    if (obj3 == null) {
                        baVar.append((CharSequence) "null,");
                    } else {
                        if (ahVar.a(obj3)) {
                            ahVar.b(obj3);
                        } else {
                            Class<?> cls2 = obj3.getClass();
                            if (cls2 == cls) {
                                atVar.a(ahVar, obj3, (Object) null, (Type) null);
                            } else {
                                atVar = ahVar.a(cls2);
                                atVar.a(ahVar, obj3, (Object) null, (Type) null);
                                cls = cls2;
                            }
                        }
                        baVar.b(',');
                    }
                    i3++;
                }
                Object obj4 = objArr[i2];
                if (obj4 == null) {
                    baVar.append((CharSequence) "null]");
                } else {
                    if (ahVar.a(obj4)) {
                        ahVar.b(obj4);
                    } else {
                        Integer valueOf = Integer.valueOf(i2);
                        if (obj4 == null) {
                            ahVar.f6266a.write("null");
                        } else {
                            ahVar.a(obj4.getClass()).a(ahVar, obj4, valueOf, (Type) null);
                        }
                    }
                    baVar.b(']');
                }
                ahVar.j = axVar;
            } catch (IOException e2) {
                throw new d(e2.getMessage(), e2);
            } catch (Throwable th) {
                ahVar.j = axVar;
                throw th;
            }
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
