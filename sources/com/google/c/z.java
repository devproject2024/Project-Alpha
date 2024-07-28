package com.google.c;

final class z implements as {

    /* renamed from: a  reason: collision with root package name */
    private static final z f37935a = new z();

    private z() {
    }

    public static z a() {
        return f37935a;
    }

    public final boolean a(Class<?> cls) {
        return aa.class.isAssignableFrom(cls);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.c.ar b(java.lang.Class<?> r5) {
        /*
            r4 = this;
            java.lang.Class<com.google.c.aa> r0 = com.google.c.aa.class
            boolean r0 = r0.isAssignableFrom(r5)
            if (r0 == 0) goto L_0x0032
            java.lang.Class<com.google.c.aa> r0 = com.google.c.aa.class
            java.lang.Class r0 = r5.asSubclass(r0)     // Catch:{ Exception -> 0x0019 }
            com.google.c.aa r0 = com.google.c.aa.a(r0)     // Catch:{ Exception -> 0x0019 }
            java.lang.Object r0 = r0.k()     // Catch:{ Exception -> 0x0019 }
            com.google.c.ar r0 = (com.google.c.ar) r0     // Catch:{ Exception -> 0x0019 }
            return r0
        L_0x0019:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unable to get message info for "
            r2.<init>(r3)
            java.lang.String r5 = r5.getName()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5, r0)
            throw r1
        L_0x0032:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported message type: "
            r1.<init>(r2)
            java.lang.String r5 = r5.getName()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.z.b(java.lang.Class):com.google.c.ar");
    }
}
