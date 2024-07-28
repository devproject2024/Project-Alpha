package com.squareup.b;

import com.squareup.b.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class a<M extends g> {

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<Field> f16037b = new Comparator<Field>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Field) obj).getName().compareTo(((Field) obj2).getName());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final List<Field> f16038a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<Field> f16039c = new ArrayList();

    public a(Class<M> cls) {
        for (Field field : cls.getDeclaredFields()) {
            k kVar = (k) field.getAnnotation(k.class);
            if (kVar != null) {
                if (kVar.c() == g.b.REQUIRED) {
                    try {
                        this.f16038a.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException unused) {
                        throw new AssertionError("No message field found for message field " + field.getName());
                    }
                }
                if (kVar.c() == g.b.REPEATED) {
                    try {
                        this.f16039c.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException unused2) {
                        throw new AssertionError("No message field found for message field " + field.getName());
                    }
                }
            }
        }
        Collections.sort(this.f16038a, f16037b);
    }

    /* access modifiers changed from: protected */
    public final void a(M m) {
        for (Field next : this.f16039c) {
            try {
                List list = (List) next.get(m);
                if (list == null) {
                    next.set(m, Collections.emptyList());
                } else if (!list.isEmpty()) {
                    int size = list.size();
                    int i2 = 0;
                    while (i2 < size) {
                        if (list.get(i2) != null) {
                            i2++;
                        } else {
                            throw new NullPointerException(String.format("Element at index %d of field %s is null", new Object[]{Integer.valueOf(i2), next.getName()}));
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } catch (IllegalArgumentException unused) {
                throw new AssertionError("Unable to access required fields");
            } catch (IllegalAccessException unused2) {
                throw new AssertionError("Unable to access required fields");
            }
        }
    }
}
