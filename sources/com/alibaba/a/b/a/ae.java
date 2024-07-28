package com.alibaba.a.b.a;

import com.alibaba.a.b.i;
import java.lang.reflect.Constructor;

public final class ae extends s {
    public final int a() {
        return 12;
    }

    public ae(i iVar, Class<?> cls) {
        super(iVar, cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) != false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(com.alibaba.a.b.b r13, java.lang.reflect.Type r14, java.lang.Object r15) {
        /*
            r12 = this;
            com.alibaba.a.b.d r15 = r13.g()
            int r0 = r15.a()
            r1 = 8
            r2 = 0
            if (r0 != r1) goto L_0x0011
            r15.d()
            return r2
        L_0x0011:
            int r0 = r13.f6223f
            r3 = 2
            java.lang.String r4 = "syntax error"
            if (r0 != r3) goto L_0x001d
            r0 = 0
            r13.f6223f = r0
            goto L_0x0025
        L_0x001d:
            int r0 = r15.a()
            r3 = 12
            if (r0 != r3) goto L_0x0102
        L_0x0025:
            if (r14 == 0) goto L_0x0036
            boolean r0 = r14 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0036
            java.lang.Class r14 = (java.lang.Class) r14
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            boolean r0 = r0.isAssignableFrom(r14)
            if (r0 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r14 = r2
        L_0x0037:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r5 = r14
            r14 = r2
            r3 = r14
            r6 = r3
        L_0x0040:
            com.alibaba.a.b.j r7 = r13.b()
            java.lang.String r7 = r15.a((com.alibaba.a.b.j) r7)
            r8 = 13
            r9 = 16
            if (r7 != 0) goto L_0x0067
            int r10 = r15.a()
            if (r10 != r8) goto L_0x0059
            r15.a((int) r9)
            goto L_0x00e0
        L_0x0059:
            int r10 = r15.a()
            if (r10 != r9) goto L_0x0067
            com.alibaba.a.b.c r10 = com.alibaba.a.b.c.AllowArbitraryCommas
            boolean r10 = r15.a((com.alibaba.a.b.c) r10)
            if (r10 != 0) goto L_0x0040
        L_0x0067:
            r15.p()
            java.lang.String r10 = com.alibaba.a.a.DEFAULT_TYPE_KEY
            boolean r10 = r10.equals(r7)
            r11 = 4
            if (r10 == 0) goto L_0x008b
            int r5 = r15.a()
            if (r5 != r11) goto L_0x0085
            java.lang.String r5 = r15.l()
            java.lang.Class r5 = com.alibaba.a.d.g.a((java.lang.String) r5)
            r15.a((int) r9)
            goto L_0x00d7
        L_0x0085:
            com.alibaba.a.d r13 = new com.alibaba.a.d
            r13.<init>(r4)
            throw r13
        L_0x008b:
            java.lang.String r10 = "message"
            boolean r10 = r10.equals(r7)
            if (r10 == 0) goto L_0x00af
            int r14 = r15.a()
            if (r14 != r1) goto L_0x009b
            r14 = r2
            goto L_0x00a5
        L_0x009b:
            int r14 = r15.a()
            if (r14 != r11) goto L_0x00a9
            java.lang.String r14 = r15.l()
        L_0x00a5:
            r15.d()
            goto L_0x00d7
        L_0x00a9:
            com.alibaba.a.d r13 = new com.alibaba.a.d
            r13.<init>(r4)
            throw r13
        L_0x00af:
            java.lang.String r10 = "cause"
            boolean r11 = r10.equals(r7)
            if (r11 == 0) goto L_0x00be
            java.lang.Object r3 = r12.a((com.alibaba.a.b.b) r13, (java.lang.reflect.Type) r2, (java.lang.Object) r10)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            goto L_0x00d7
        L_0x00be:
            java.lang.String r10 = "stackTrace"
            boolean r10 = r10.equals(r7)
            if (r10 == 0) goto L_0x00d0
            java.lang.Class<java.lang.StackTraceElement[]> r6 = java.lang.StackTraceElement[].class
            java.lang.Object r6 = r13.a((java.lang.reflect.Type) r6)
            java.lang.StackTraceElement[] r6 = (java.lang.StackTraceElement[]) r6
            goto L_0x00d7
        L_0x00d0:
            java.lang.Object r10 = r13.a((java.lang.Object) r2)
            r0.put(r7, r10)
        L_0x00d7:
            int r7 = r15.a()
            if (r7 != r8) goto L_0x0040
            r15.a((int) r9)
        L_0x00e0:
            if (r5 != 0) goto L_0x00e8
            java.lang.Exception r13 = new java.lang.Exception
            r13.<init>(r14, r3)
            goto L_0x00f3
        L_0x00e8:
            java.lang.Throwable r13 = a((java.lang.String) r14, (java.lang.Throwable) r3, (java.lang.Class<?>) r5)     // Catch:{ Exception -> 0x00f9 }
            if (r13 != 0) goto L_0x00f3
            java.lang.Exception r13 = new java.lang.Exception     // Catch:{ Exception -> 0x00f9 }
            r13.<init>(r14, r3)     // Catch:{ Exception -> 0x00f9 }
        L_0x00f3:
            if (r6 == 0) goto L_0x00f8
            r13.setStackTrace(r6)
        L_0x00f8:
            return r13
        L_0x00f9:
            r13 = move-exception
            com.alibaba.a.d r14 = new com.alibaba.a.d
            java.lang.String r15 = "create instance error"
            r14.<init>(r15, r13)
            throw r14
        L_0x0102:
            com.alibaba.a.d r13 = new com.alibaba.a.d
            r13.<init>(r4)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.a.ae.a(com.alibaba.a.b.b, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    private static Throwable a(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor constructor = null;
        Constructor constructor2 = null;
        Constructor constructor3 = null;
        for (Constructor constructor4 : cls.getConstructors()) {
            if (constructor4.getParameterTypes().length == 0) {
                constructor3 = constructor4;
            } else if (constructor4.getParameterTypes().length == 1 && constructor4.getParameterTypes()[0] == String.class) {
                constructor2 = constructor4;
            } else if (constructor4.getParameterTypes().length == 2 && constructor4.getParameterTypes()[0] == String.class && constructor4.getParameterTypes()[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(new Object[]{str, th});
        } else if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(new Object[]{str});
        } else if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        } else {
            return null;
        }
    }
}
