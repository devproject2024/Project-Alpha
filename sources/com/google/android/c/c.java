package com.google.android.c;

import android.content.Intent;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static boolean f7632a;

    /* renamed from: b  reason: collision with root package name */
    private static final Intent f7633b = new Intent("com.google.android.now.NOW_AUTH_SERVICE").setPackage("com.google.android.googlequicksearchbox");

    public static class a extends Exception {
    }

    public static class d extends Exception {
    }

    /* renamed from: com.google.android.c.c$c  reason: collision with other inner class name */
    public static class C0111c extends Exception {
        private final long mNextRetryTimestampMillis;

        public C0111c(long j) {
            this.mNextRetryTimestampMillis = j;
        }

        public final long getNextRetryTimestampMillis() {
            return this.mNextRetryTimestampMillis;
        }
    }

    public static class b extends Exception {
        private final String mAccessToken;

        public b(String str) {
            this.mAccessToken = str;
        }

        public final String getAccessToken() {
            return this.mAccessToken;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r5, java.lang.String r6) throws java.io.IOException, com.google.android.c.c.d, com.google.android.c.c.C0111c, com.google.android.c.c.b, com.google.android.c.c.a {
        /*
            java.lang.String r0 = "error"
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            if (r1 != r2) goto L_0x0019
            boolean r1 = f7632a
            if (r1 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Cannot call this API from the main thread"
            r5.<init>(r6)
            throw r5
        L_0x0019:
            com.google.android.c.a r1 = new com.google.android.c.a
            r1.<init>()
            android.content.Intent r2 = f7633b
            r3 = 1
            boolean r2 = r5.bindService(r2, r1, r3)
            if (r2 == 0) goto L_0x00d9
            java.util.concurrent.atomic.AtomicBoolean r2 = r1.f7626a     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            boolean r2 = r2.get()     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            if (r2 != 0) goto L_0x00bc
            java.util.concurrent.atomic.AtomicBoolean r2 = r1.f7626a     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r2.set(r3)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.util.concurrent.BlockingQueue<android.os.IBinder> r2 = r1.f7627b     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.Object r2 = r2.take()     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            com.google.android.c.b r2 = com.google.android.c.b.a.a(r2)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.String r4 = r5.getPackageName()     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            android.os.Bundle r6 = r2.a(r6, r4)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            if (r6 == 0) goto L_0x00b4
            boolean r2 = r6.containsKey(r0)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            if (r2 == 0) goto L_0x00aa
            int r0 = r6.getInt(r0)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            if (r0 == 0) goto L_0x00a4
            if (r0 == r3) goto L_0x0098
            r2 = 2
            if (r0 == r2) goto L_0x008c
            r6 = 3
            if (r0 == r6) goto L_0x0086
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r2 = 26
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.String r2 = "Unknown error: "
            r6.append(r2)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r6.append(r0)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.io.IOException r6 = new java.io.IOException     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r3 = 49
            r2.<init>(r3)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.String r3 = "Unexpected error from Google Now app: "
            r2.append(r3)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r2.append(r0)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.String r0 = r2.toString()     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r6.<init>(r0)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            throw r6     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
        L_0x0086:
            com.google.android.c.c$a r6 = new com.google.android.c.c$a     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r6.<init>()     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            throw r6     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
        L_0x008c:
            com.google.android.c.c$b r0 = new com.google.android.c.c$b     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.String r2 = "access-token"
            java.lang.String r6 = r6.getString(r2)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r0.<init>(r6)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            throw r0     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
        L_0x0098:
            com.google.android.c.c$c r0 = new com.google.android.c.c$c     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.String r2 = "next-retry-timestamp-millis"
            long r2 = r6.getLong(r2)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r0.<init>(r2)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            throw r0     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
        L_0x00a4:
            com.google.android.c.c$d r6 = new com.google.android.c.c$d     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r6.<init>()     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            throw r6     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
        L_0x00aa:
            java.lang.String r0 = "auth-code"
            java.lang.String r6 = r6.getString(r0)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r1.a((android.content.Context) r5)
            return r6
        L_0x00b4:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            java.lang.String r0 = "Unexpected response from Google Now app"
            r6.<init>(r0)     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            throw r6     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
        L_0x00bc:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            r6.<init>()     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
            throw r6     // Catch:{ RemoteException -> 0x00cc, InterruptedException -> 0x00c4 }
        L_0x00c2:
            r6 = move-exception
            goto L_0x00d5
        L_0x00c4:
            java.io.InterruptedIOException r6 = new java.io.InterruptedIOException     // Catch:{ all -> 0x00c2 }
            java.lang.String r0 = "Interrupted while contacting Google Now app"
            r6.<init>(r0)     // Catch:{ all -> 0x00c2 }
            throw r6     // Catch:{ all -> 0x00c2 }
        L_0x00cc:
            r6 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = "Call to Google Now app failed"
            r0.<init>(r2, r6)     // Catch:{ all -> 0x00c2 }
            throw r0     // Catch:{ all -> 0x00c2 }
        L_0x00d5:
            r1.a((android.content.Context) r5)
            throw r6
        L_0x00d9:
            java.io.IOException r5 = new java.io.IOException
            java.lang.String r6 = "Failed to contact Google Now app"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.c.c.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
