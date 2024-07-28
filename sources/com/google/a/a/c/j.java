package com.google.a.a.c;

import com.google.a.a.b.a.a.a.a.c;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

public final class j {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Field, j> f7595d = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    final boolean f7596a;

    /* renamed from: b  reason: collision with root package name */
    public final Field f7597b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7598c;

    public static j a(Enum<?> enumR) {
        try {
            j a2 = a(enumR.getClass().getField(enumR.name()));
            c.a(a2 != null, "enum constant missing @Value or @NullValue annotation: %s", enumR);
            return a2;
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.a.a.c.j a(java.lang.reflect.Field r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Map<java.lang.reflect.Field, com.google.a.a.c.j> r1 = f7595d
            monitor-enter(r1)
            java.util.Map<java.lang.reflect.Field, com.google.a.a.c.j> r2 = f7595d     // Catch:{ all -> 0x006b }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x006b }
            com.google.a.a.c.j r2 = (com.google.a.a.c.j) r2     // Catch:{ all -> 0x006b }
            boolean r3 = r5.isEnumConstant()     // Catch:{ all -> 0x006b }
            if (r2 != 0) goto L_0x0069
            if (r3 != 0) goto L_0x0021
            int r4 = r5.getModifiers()     // Catch:{ all -> 0x006b }
            boolean r4 = java.lang.reflect.Modifier.isStatic(r4)     // Catch:{ all -> 0x006b }
            if (r4 != 0) goto L_0x0069
        L_0x0021:
            if (r3 == 0) goto L_0x003f
            java.lang.Class<com.google.a.a.c.w> r2 = com.google.a.a.c.w.class
            java.lang.annotation.Annotation r2 = r5.getAnnotation(r2)     // Catch:{ all -> 0x006b }
            com.google.a.a.c.w r2 = (com.google.a.a.c.w) r2     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x0032
            java.lang.String r0 = r2.a()     // Catch:{ all -> 0x006b }
            goto L_0x0053
        L_0x0032:
            java.lang.Class<com.google.a.a.c.r> r2 = com.google.a.a.c.r.class
            java.lang.annotation.Annotation r2 = r5.getAnnotation(r2)     // Catch:{ all -> 0x006b }
            com.google.a.a.c.r r2 = (com.google.a.a.c.r) r2     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x003d
            goto L_0x0053
        L_0x003d:
            monitor-exit(r1)     // Catch:{ all -> 0x006b }
            return r0
        L_0x003f:
            java.lang.Class<com.google.a.a.c.m> r2 = com.google.a.a.c.m.class
            java.lang.annotation.Annotation r2 = r5.getAnnotation(r2)     // Catch:{ all -> 0x006b }
            com.google.a.a.c.m r2 = (com.google.a.a.c.m) r2     // Catch:{ all -> 0x006b }
            if (r2 != 0) goto L_0x004b
            monitor-exit(r1)     // Catch:{ all -> 0x006b }
            return r0
        L_0x004b:
            java.lang.String r0 = r2.a()     // Catch:{ all -> 0x006b }
            r2 = 1
            r5.setAccessible(r2)     // Catch:{ all -> 0x006b }
        L_0x0053:
            java.lang.String r2 = "##default"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x005f
            java.lang.String r0 = r5.getName()     // Catch:{ all -> 0x006b }
        L_0x005f:
            com.google.a.a.c.j r2 = new com.google.a.a.c.j     // Catch:{ all -> 0x006b }
            r2.<init>(r5, r0)     // Catch:{ all -> 0x006b }
            java.util.Map<java.lang.reflect.Field, com.google.a.a.c.j> r0 = f7595d     // Catch:{ all -> 0x006b }
            r0.put(r5, r2)     // Catch:{ all -> 0x006b }
        L_0x0069:
            monitor-exit(r1)     // Catch:{ all -> 0x006b }
            return r2
        L_0x006b:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.c.j.a(java.lang.reflect.Field):com.google.a.a.c.j");
    }

    private j(Field field, String str) {
        String str2;
        this.f7597b = field;
        if (str == null) {
            str2 = null;
        } else {
            str2 = str.intern();
        }
        this.f7598c = str2;
        this.f7596a = g.a((Type) this.f7597b.getType());
    }

    public final boolean a() {
        return Modifier.isFinal(this.f7597b.getModifiers());
    }

    public final Object a(Object obj) {
        return a(this.f7597b, obj);
    }

    public final void a(Object obj, Object obj2) {
        a(this.f7597b, obj, obj2);
    }

    private static Object a(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (Modifier.isFinal(field.getModifiers())) {
            Object a2 = a(field, obj);
            if (obj2 == null) {
                if (a2 == null) {
                    return;
                }
            } else if (obj2.equals(a2)) {
                return;
            }
            throw new IllegalArgumentException("expected final value <" + a2 + "> but was <" + obj2 + "> on " + field.getName() + " field in " + obj.getClass().getName());
        }
        try {
            field.set(obj, obj2);
        } catch (SecurityException e2) {
            throw new IllegalArgumentException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
