package androidx.work;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5524a = l.a("WorkerFactory");

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.work.ListenableWorker a(android.content.Context r8, java.lang.String r9, androidx.work.WorkerParameters r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            java.lang.Class r3 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x000e }
            java.lang.Class<androidx.work.ListenableWorker> r4 = androidx.work.ListenableWorker.class
            java.lang.Class r3 = r3.asSubclass(r4)     // Catch:{ all -> 0x000e }
            goto L_0x0017
        L_0x000e:
            r3 = move-exception
            androidx.work.l.a()
            java.lang.Throwable[] r4 = new java.lang.Throwable[r2]
            r4[r1] = r3
            r3 = r0
        L_0x0017:
            r4 = 2
            if (r3 == 0) goto L_0x003d
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0035 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r1] = r6     // Catch:{ all -> 0x0035 }
            java.lang.Class<androidx.work.WorkerParameters> r6 = androidx.work.WorkerParameters.class
            r5[r2] = r6     // Catch:{ all -> 0x0035 }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r5)     // Catch:{ all -> 0x0035 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0035 }
            r5[r1] = r8     // Catch:{ all -> 0x0035 }
            r5[r2] = r10     // Catch:{ all -> 0x0035 }
            java.lang.Object r8 = r3.newInstance(r5)     // Catch:{ all -> 0x0035 }
            androidx.work.ListenableWorker r8 = (androidx.work.ListenableWorker) r8     // Catch:{ all -> 0x0035 }
            goto L_0x003e
        L_0x0035:
            r8 = move-exception
            androidx.work.l.a()
            java.lang.Throwable[] r10 = new java.lang.Throwable[r2]
            r10[r1] = r8
        L_0x003d:
            r8 = r0
        L_0x003e:
            if (r8 == 0) goto L_0x0061
            boolean r10 = r8.isUsed()
            if (r10 != 0) goto L_0x0047
            goto L_0x0061
        L_0x0047:
            java.lang.Class r8 = r7.getClass()
            java.lang.String r8 = r8.getName()
            java.lang.Object[] r10 = new java.lang.Object[r4]
            r10[r1] = r8
            r10[r2] = r9
            java.lang.String r8 = "WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker."
            java.lang.String r8 = java.lang.String.format(r8, r10)
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r8)
            throw r9
        L_0x0061:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.x.a(android.content.Context, java.lang.String, androidx.work.WorkerParameters):androidx.work.ListenableWorker");
    }

    public static x a() {
        return new x() {
        };
    }
}
