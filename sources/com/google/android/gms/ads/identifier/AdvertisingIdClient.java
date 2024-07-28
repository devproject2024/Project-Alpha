package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.SystemClock;
import com.google.android.gms.common.d;
import com.google.android.gms.common.f;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.a.e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AdvertisingIdClient {

    /* renamed from: a  reason: collision with root package name */
    private com.google.android.gms.common.a f8035a;

    /* renamed from: b  reason: collision with root package name */
    private e f8036b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8037c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f8038d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private b f8039e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f8040f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f8041g;

    /* renamed from: h  reason: collision with root package name */
    private final long f8042h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f8043a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8044b;

        public a(String str, boolean z) {
            this.f8043a = str;
            this.f8044b = z;
        }

        public final String a() {
            return this.f8043a;
        }

        public final String toString() {
            String str = this.f8043a;
            boolean z = this.f8044b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        CountDownLatch f8045a = new CountDownLatch(1);

        /* renamed from: b  reason: collision with root package name */
        boolean f8046b = false;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<AdvertisingIdClient> f8047c;

        /* renamed from: d  reason: collision with root package name */
        private long f8048d;

        public b(AdvertisingIdClient advertisingIdClient, long j) {
            this.f8047c = new WeakReference<>(advertisingIdClient);
            this.f8048d = j;
            start();
        }

        private final void a() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f8047c.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.b();
                this.f8046b = true;
            }
        }

        public final void run() {
            try {
                if (!this.f8045a.await(this.f8048d, TimeUnit.MILLISECONDS)) {
                    a();
                }
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    private AdvertisingIdClient(Context context, boolean z, boolean z2) {
        Context applicationContext;
        s.a(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f8040f = context;
        this.f8037c = false;
        this.f8042h = -1;
        this.f8041g = z2;
    }

    public static a a(Context context) throws IOException, IllegalStateException, com.google.android.gms.common.e, f {
        b bVar = new b(context);
        boolean a2 = bVar.a("gads:ad_id_app_context:enabled");
        float b2 = bVar.b("gads:ad_id_app_context:ping_ratio");
        String a3 = bVar.a("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, a2, bVar.a("gads:ad_id_use_persistent_service:enabled"));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.c();
            a d2 = advertisingIdClient.d();
            a(d2, a2, b2, SystemClock.elapsedRealtime() - elapsedRealtime, a3, (Throwable) null);
            advertisingIdClient.b();
            return d2;
        } catch (Throwable th) {
            advertisingIdClient.b();
            throw th;
        }
    }

    private static com.google.android.gms.common.a a(Context context, boolean z) throws IOException, com.google.android.gms.common.e, f {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int a2 = d.b().a(context, (int) h.f8688b);
            if (a2 == 0 || a2 == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    com.google.android.gms.common.stats.a.a();
                    if (com.google.android.gms.common.stats.a.b(context, intent, aVar, 1)) {
                        return aVar;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            } else {
                throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new com.google.android.gms.common.e(9);
        }
    }

    public static void a() {
    }

    private final void c() throws IOException, IllegalStateException, com.google.android.gms.common.e, f {
        s.c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f8037c) {
                b();
            }
            this.f8035a = a(this.f8040f, this.f8041g);
            this.f8036b = a(this.f8035a);
            this.f8037c = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r2 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.s.c(r0)
            monitor-enter(r2)
            android.content.Context r0 = r2.f8040f     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.common.a r0 = r2.f8035a     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0027
        L_0x000f:
            boolean r0 = r2.f8037c     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001d
            com.google.android.gms.common.stats.a.a()     // Catch:{ all -> 0x001d }
            android.content.Context r0 = r2.f8040f     // Catch:{ all -> 0x001d }
            com.google.android.gms.common.a r1 = r2.f8035a     // Catch:{ all -> 0x001d }
            com.google.android.gms.common.stats.a.a(r0, r1)     // Catch:{ all -> 0x001d }
        L_0x001d:
            r0 = 0
            r2.f8037c = r0     // Catch:{ all -> 0x0029 }
            r0 = 0
            r2.f8036b = r0     // Catch:{ all -> 0x0029 }
            r2.f8035a = r0     // Catch:{ all -> 0x0029 }
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            return
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            return
        L_0x0029:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.b():void");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        b();
        super.finalize();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:53|54|55) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:38|39|(3:41|42|43)|44|45|(1:47)|48) */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0088, code lost:
        throw new java.io.IOException("Remote exception");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x006b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.ads.identifier.AdvertisingIdClient.a d() throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.s.c(r0)
            monitor-enter(r7)
            boolean r0 = r7.f8037c     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x003c
            java.lang.Object r0 = r7.f8038d     // Catch:{ all -> 0x0089 }
            monitor-enter(r0)     // Catch:{ all -> 0x0089 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$b r1 = r7.f8039e     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0031
            com.google.android.gms.ads.identifier.AdvertisingIdClient$b r1 = r7.f8039e     // Catch:{ all -> 0x0039 }
            boolean r1 = r1.f8046b     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            r7.c()     // Catch:{ Exception -> 0x0028 }
            boolean r0 = r7.f8037c     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0020
            goto L_0x003c
        L_0x0020:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = "AdvertisingIdClient cannot reconnect."
            r0.<init>(r1)     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x0089 }
        L_0x0028:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = "AdvertisingIdClient cannot reconnect."
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0089 }
            throw r1     // Catch:{ all -> 0x0089 }
        L_0x0031:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = "AdvertisingIdClient is not connected."
            r1.<init>(r2)     // Catch:{ all -> 0x0039 }
            throw r1     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r1     // Catch:{ all -> 0x0089 }
        L_0x003c:
            com.google.android.gms.common.a r0 = r7.f8035a     // Catch:{ all -> 0x0089 }
            com.google.android.gms.common.internal.s.a(r0)     // Catch:{ all -> 0x0089 }
            com.google.android.gms.internal.a.e r0 = r7.f8036b     // Catch:{ all -> 0x0089 }
            com.google.android.gms.common.internal.s.a(r0)     // Catch:{ all -> 0x0089 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$a r0 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$a     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.a.e r1 = r7.f8036b     // Catch:{ RemoteException -> 0x0081 }
            java.lang.String r1 = r1.a()     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.a.e r2 = r7.f8036b     // Catch:{ RemoteException -> 0x0081 }
            boolean r2 = r2.b()     // Catch:{ RemoteException -> 0x0081 }
            r0.<init>(r1, r2)     // Catch:{ RemoteException -> 0x0081 }
            monitor-exit(r7)     // Catch:{ all -> 0x0089 }
            java.lang.Object r1 = r7.f8038d
            monitor-enter(r1)
            com.google.android.gms.ads.identifier.AdvertisingIdClient$b r2 = r7.f8039e     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x006b
            com.google.android.gms.ads.identifier.AdvertisingIdClient$b r2 = r7.f8039e     // Catch:{ all -> 0x007e }
            java.util.concurrent.CountDownLatch r2 = r2.f8045a     // Catch:{ all -> 0x007e }
            r2.countDown()     // Catch:{ all -> 0x007e }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$b r2 = r7.f8039e     // Catch:{ InterruptedException -> 0x006b }
            r2.join()     // Catch:{ InterruptedException -> 0x006b }
        L_0x006b:
            long r2 = r7.f8042h     // Catch:{ all -> 0x007e }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x007c
            com.google.android.gms.ads.identifier.AdvertisingIdClient$b r2 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$b     // Catch:{ all -> 0x007e }
            long r3 = r7.f8042h     // Catch:{ all -> 0x007e }
            r2.<init>(r7, r3)     // Catch:{ all -> 0x007e }
            r7.f8039e = r2     // Catch:{ all -> 0x007e }
        L_0x007c:
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            return r0
        L_0x007e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            throw r0
        L_0x0081:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = "Remote exception"
            r0.<init>(r1)     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0089 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.d():com.google.android.gms.ads.identifier.AdvertisingIdClient$a");
    }

    private static boolean a(a aVar, boolean z, float f2, long j, String str, Throwable th) {
        if (Math.random() > ((double) f2)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = "1";
        hashMap.put("app_context", z ? str2 : "0");
        if (aVar != null) {
            if (!aVar.f8044b) {
                str2 = "0";
            }
            hashMap.put("limit_ad_tracking", str2);
        }
        if (!(aVar == null || aVar.f8043a == null)) {
            hashMap.put("ad_id_size", Integer.toString(aVar.f8043a.length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new a(hashMap).start();
        return true;
    }

    private static e a(com.google.android.gms.common.a aVar) throws IOException {
        try {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            s.c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
            if (!aVar.f8345a) {
                aVar.f8345a = true;
                IBinder poll = aVar.f8346b.poll(10000, timeUnit);
                if (poll != null) {
                    return com.google.android.gms.internal.a.f.a(poll);
                }
                throw new TimeoutException("Timed out waiting for the service connection");
            }
            throw new IllegalStateException("Cannot call get on this connection more than once");
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
