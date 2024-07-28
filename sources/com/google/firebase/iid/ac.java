package com.google.firebase.iid;

import com.google.firebase.iid.y;

final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final y.a f38790a;

    ac(y.a aVar) {
        this.f38790a = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        r3 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r3).length() + 8);
        r5.append("Sending ");
        r5.append(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        r3 = r0.f38905f.f38896a;
        r4 = r0.f38901b;
        r5 = android.os.Message.obtain();
        r5.what = r1.f38910c;
        r5.arg1 = r1.f38908a;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", false);
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.f38911d);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = r0.f38902c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0091, code lost:
        if (r1.f38906a == null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0093, code lost:
        r1.f38906a.send(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009c, code lost:
        if (r1.f38907b == null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009e, code lost:
        r1.f38907b.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ac, code lost:
        throw new java.lang.IllegalStateException("Both messengers are null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ad, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ae, code lost:
        r0.a(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.firebase.iid.y$a r0 = r8.f38790a
        L_0x0002:
            monitor-enter(r0)
            int r1 = r0.f38900a     // Catch:{ all -> 0x00b7 }
            r2 = 2
            if (r1 == r2) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            return
        L_0x000a:
            java.util.Queue<com.google.firebase.iid.y$c<?>> r1 = r0.f38903d     // Catch:{ all -> 0x00b7 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00b7 }
            if (r1 == 0) goto L_0x0017
            r0.b()     // Catch:{ all -> 0x00b7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            return
        L_0x0017:
            java.util.Queue<com.google.firebase.iid.y$c<?>> r1 = r0.f38903d     // Catch:{ all -> 0x00b7 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x00b7 }
            com.google.firebase.iid.y$c r1 = (com.google.firebase.iid.y.c) r1     // Catch:{ all -> 0x00b7 }
            android.util.SparseArray<com.google.firebase.iid.y$c<?>> r3 = r0.f38904e     // Catch:{ all -> 0x00b7 }
            int r4 = r1.f38908a     // Catch:{ all -> 0x00b7 }
            r3.put(r4, r1)     // Catch:{ all -> 0x00b7 }
            com.google.firebase.iid.y r3 = com.google.firebase.iid.y.this     // Catch:{ all -> 0x00b7 }
            java.util.concurrent.ScheduledExecutorService r3 = r3.f38897b     // Catch:{ all -> 0x00b7 }
            com.google.firebase.iid.ae r4 = new com.google.firebase.iid.ae     // Catch:{ all -> 0x00b7 }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x00b7 }
            r5 = 30
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00b7 }
            r3.schedule(r4, r5, r7)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            r3 = 3
            java.lang.String r4 = "MessengerIpcClient"
            boolean r3 = android.util.Log.isLoggable(r4, r3)
            if (r3 == 0) goto L_0x005b
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Sending "
            r5.append(r4)
            r5.append(r3)
        L_0x005b:
            com.google.firebase.iid.y r3 = com.google.firebase.iid.y.this
            android.content.Context r3 = r3.f38896a
            android.os.Messenger r4 = r0.f38901b
            android.os.Message r5 = android.os.Message.obtain()
            int r6 = r1.f38910c
            r5.what = r6
            int r6 = r1.f38908a
            r5.arg1 = r6
            r5.replyTo = r4
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r6 = 0
            java.lang.String r7 = "oneWay"
            r4.putBoolean(r7, r6)
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r6 = "pkg"
            r4.putString(r6, r3)
            android.os.Bundle r1 = r1.f38911d
            java.lang.String r3 = "data"
            r4.putBundle(r3, r1)
            r5.setData(r4)
            com.google.firebase.iid.y$b r1 = r0.f38902c     // Catch:{ RemoteException -> 0x00ad }
            android.os.Messenger r3 = r1.f38906a     // Catch:{ RemoteException -> 0x00ad }
            if (r3 == 0) goto L_0x009a
            android.os.Messenger r1 = r1.f38906a     // Catch:{ RemoteException -> 0x00ad }
            r1.send(r5)     // Catch:{ RemoteException -> 0x00ad }
            goto L_0x0002
        L_0x009a:
            com.google.firebase.iid.FirebaseIidMessengerCompat r3 = r1.f38907b     // Catch:{ RemoteException -> 0x00ad }
            if (r3 == 0) goto L_0x00a5
            com.google.firebase.iid.FirebaseIidMessengerCompat r1 = r1.f38907b     // Catch:{ RemoteException -> 0x00ad }
            r1.a(r5)     // Catch:{ RemoteException -> 0x00ad }
            goto L_0x0002
        L_0x00a5:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ RemoteException -> 0x00ad }
            java.lang.String r3 = "Both messengers are null"
            r1.<init>(r3)     // Catch:{ RemoteException -> 0x00ad }
            throw r1     // Catch:{ RemoteException -> 0x00ad }
        L_0x00ad:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            r0.a(r2, r1)
            goto L_0x0002
        L_0x00b7:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ac.run():void");
    }
}
