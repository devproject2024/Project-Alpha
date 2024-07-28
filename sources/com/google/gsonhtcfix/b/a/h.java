package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.b.c;
import com.google.gsonhtcfix.b.d;
import com.google.gsonhtcfix.b.i;
import com.google.gsonhtcfix.e;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.v;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class h implements z {

    /* renamed from: a  reason: collision with root package name */
    private final c f39670a;

    /* renamed from: b  reason: collision with root package name */
    private final e f39671b;

    /* renamed from: c  reason: collision with root package name */
    private final d f39672c;

    public h(c cVar, e eVar, d dVar) {
        this.f39670a = cVar;
        this.f39671b = eVar;
        this.f39672c = dVar;
    }

    private boolean a(Field field, boolean z) {
        boolean z2;
        com.google.gsonhtcfix.a.a aVar;
        if (!this.f39672c.a(field.getType(), z)) {
            d dVar = this.f39672c;
            if ((dVar.f39740c & field.getModifiers()) == 0 && ((dVar.f39739b == -1.0d || dVar.a((com.google.gsonhtcfix.a.c) field.getAnnotation(com.google.gsonhtcfix.a.c.class), (com.google.gsonhtcfix.a.d) field.getAnnotation(com.google.gsonhtcfix.a.d.class))) && !field.isSynthetic() && ((!dVar.f39742e || ((aVar = (com.google.gsonhtcfix.a.a) field.getAnnotation(com.google.gsonhtcfix.a.a.class)) != null && (!z ? aVar.b() : aVar.a()))) && ((dVar.f39741d || !d.b(field.getType())) && !d.a(field.getType()))))) {
                List<com.google.gsonhtcfix.b> list = z ? dVar.f39743f : dVar.f39744g;
                if (!list.isEmpty()) {
                    new com.google.gsonhtcfix.c(field);
                    Iterator<com.google.gsonhtcfix.b> it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().a()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new a(this.f39670a.a(aVar), a(fVar, aVar, rawType), (byte) 0);
    }

    private Map<String, b> a(f fVar, com.google.gsonhtcfix.c.a<?> aVar, Class<?> cls) {
        int i2;
        h hVar = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gsonhtcfix.c.a<?> aVar2 = aVar;
        Class<? super Object> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i3 = 0;
            while (i3 < length) {
                Field field = declaredFields[i3];
                boolean a2 = hVar.a(field, true);
                boolean a3 = hVar.a(field, z);
                if (a2 || a3) {
                    field.setAccessible(true);
                    Type a4 = com.google.gsonhtcfix.b.b.a(aVar2.getType(), (Class<?>) cls2, field.getGenericType());
                    com.google.gsonhtcfix.a.b bVar = (com.google.gsonhtcfix.a.b) field.getAnnotation(com.google.gsonhtcfix.a.b.class);
                    String translateName = bVar == null ? hVar.f39671b.translateName(field) : bVar.a();
                    com.google.gsonhtcfix.c.a<?> aVar3 = com.google.gsonhtcfix.c.a.get(a4);
                    AnonymousClass1 r9 = r0;
                    final f fVar2 = fVar;
                    Field field2 = field;
                    final com.google.gsonhtcfix.c.a<?> aVar4 = aVar3;
                    i2 = i3;
                    final Field field3 = field2;
                    final boolean a5 = i.a((Type) aVar3.getRawType());
                    AnonymousClass1 r0 = new b(translateName, a2, a3) {

                        /* renamed from: a  reason: collision with root package name */
                        final y<?> f39673a = fVar2.a(aVar4);

                        /* access modifiers changed from: package-private */
                        public final void a(com.google.gsonhtcfix.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                            new k(fVar2, this.f39673a, aVar4.getType()).a(cVar, field3.get(obj));
                        }

                        /* access modifiers changed from: package-private */
                        public final void a(com.google.gsonhtcfix.d.a aVar, Object obj) throws IOException, IllegalAccessException {
                            Object a2 = this.f39673a.a(aVar);
                            if (a2 != null || !a5) {
                                field3.set(obj, a2);
                            }
                        }
                    };
                    b bVar2 = (b) linkedHashMap.put(r9.f39681g, r9);
                    if (bVar2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar2.f39681g);
                    }
                } else {
                    i2 = i3;
                }
                i3 = i2 + 1;
                z = false;
                hVar = this;
            }
            aVar2 = com.google.gsonhtcfix.c.a.get(com.google.gsonhtcfix.b.b.a(aVar2.getType(), (Class<?>) cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
            hVar = this;
        }
        return linkedHashMap;
    }

    static abstract class b {

        /* renamed from: g  reason: collision with root package name */
        final String f39681g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f39682h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f39683i;

        /* access modifiers changed from: package-private */
        public abstract void a(com.google.gsonhtcfix.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void a(com.google.gsonhtcfix.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.f39681g = str;
            this.f39682h = z;
            this.f39683i = z2;
        }
    }

    public static final class a<T> extends y<T> {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.gsonhtcfix.b.h<T> f39679a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, b> f39680b;

        /* synthetic */ a(com.google.gsonhtcfix.b.h hVar, Map map, byte b2) {
            this(hVar, map);
        }

        private a(com.google.gsonhtcfix.b.h<T> hVar, Map<String, b> map) {
            this.f39679a = hVar;
            this.f39680b = map;
        }

        public final T a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == com.google.gsonhtcfix.d.b.NULL) {
                aVar.k();
                return null;
            }
            T a2 = this.f39679a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f39680b.get(aVar.h());
                    if (bVar != null) {
                        if (bVar.f39683i) {
                            bVar.a(aVar, (Object) a2);
                        }
                    }
                    aVar.o();
                }
                aVar.d();
                return a2;
            } catch (IllegalStateException e2) {
                throw new v((Throwable) e2);
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public final void a(com.google.gsonhtcfix.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.e();
                return;
            }
            cVar.c();
            try {
                for (b next : this.f39680b.values()) {
                    if (next.f39682h) {
                        cVar.a(next.f39681g);
                        next.a(cVar, (Object) t);
                    }
                }
                cVar.d();
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }
    }
}
