package com.google.android.gms.internal.firebase_ml;

public final class az {

    /* renamed from: a  reason: collision with root package name */
    private static final bb f9755a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f9756b;

    static final class a extends bb {
        a() {
        }

        public final void a(Throwable th, Throwable th2) {
        }
    }

    public static void a(Throwable th, Throwable th2) {
        f9755a.a(th, th2);
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = a()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0015
            int r2 = r1.intValue()     // Catch:{ all -> 0x002a }
            r3 = 19
            if (r2 < r3) goto L_0x0015
            com.google.android.gms.internal.firebase_ml.be r2 = new com.google.android.gms.internal.firebase_ml.be     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x0064
        L_0x0015:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch:{ all -> 0x002a }
            r2 = r2 ^ r0
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.firebase_ml.bc r2 = new com.google.android.gms.internal.firebase_ml.bc     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x0064
        L_0x0024:
            com.google.android.gms.internal.firebase_ml.az$a r2 = new com.google.android.gms.internal.firebase_ml.az$a     // Catch:{ all -> 0x002a }
            r2.<init>()     // Catch:{ all -> 0x002a }
            goto L_0x0064
        L_0x002a:
            r2 = move-exception
            goto L_0x002e
        L_0x002c:
            r2 = move-exception
            r1 = 0
        L_0x002e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.firebase_ml.az$a> r4 = com.google.android.gms.internal.firebase_ml.az.a.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.firebase_ml.az$a r2 = new com.google.android.gms.internal.firebase_ml.az$a
            r2.<init>()
        L_0x0064:
            f9755a = r2
            if (r1 != 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            int r0 = r1.intValue()
        L_0x006d:
            f9756b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.az.<clinit>():void");
    }
}
