package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.a.a;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;
import com.google.firebase.c;
import com.google.firebase.e.h;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.af;
import com.google.firebase.iid.q;
import com.google.firebase.iid.w;
import com.google.firebase.installations.g;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class v {

    /* renamed from: b  reason: collision with root package name */
    private static final long f39036b = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a  reason: collision with root package name */
    final u f39037a;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f39038c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f39039d;

    /* renamed from: e  reason: collision with root package name */
    private final af f39040e;

    /* renamed from: f  reason: collision with root package name */
    private final q f39041f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, ArrayDeque<f<Void>>> f39042g = new a();

    /* renamed from: h  reason: collision with root package name */
    private final ScheduledExecutorService f39043h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f39044i = false;

    static Task<v> a(c cVar, FirebaseInstanceId firebaseInstanceId, af afVar, h hVar, com.google.firebase.b.c cVar2, g gVar, Context context, ScheduledExecutorService scheduledExecutorService) {
        return com.google.android.gms.tasks.h.a((Executor) scheduledExecutorService, new w(context, scheduledExecutorService, firebaseInstanceId, afVar, new q(cVar, afVar, hVar, cVar2, gVar)));
    }

    private v(FirebaseInstanceId firebaseInstanceId, af afVar, u uVar, q qVar, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f39038c = firebaseInstanceId;
        this.f39040e = afVar;
        this.f39037a = uVar;
        this.f39041f = qVar;
        this.f39039d = context;
        this.f39043h = scheduledExecutorService;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j) {
        a(new x(this, this.f39039d, this.f39040e, Math.min(Math.max(30, j << 1), f39036b)), j);
        a(true);
    }

    /* access modifiers changed from: package-private */
    public final void a(Runnable runnable, long j) {
        this.f39043h.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        r5.f39037a.a(r0);
        r1 = r5.f39042g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0 = r0.f39031c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r5.f39042g.containsKey(r0) != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r2 = r5.f39042g.get(r0);
        r3 = (com.google.android.gms.tasks.f) r2.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r3 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        r3.a(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (r2.isEmpty() == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        r5.f39042g.remove(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (a(r0) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() throws java.io.IOException {
        /*
            r5 = this;
        L_0x0000:
            monitor-enter(r5)
            com.google.firebase.messaging.u r0 = r5.f39037a     // Catch:{ all -> 0x0050 }
            com.google.firebase.messaging.t r0 = r0.a()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x000f
            c()     // Catch:{ all -> 0x0050 }
            r0 = 1
            monitor-exit(r5)     // Catch:{ all -> 0x0050 }
            return r0
        L_0x000f:
            monitor-exit(r5)     // Catch:{ all -> 0x0050 }
            boolean r1 = r5.a((com.google.firebase.messaging.t) r0)
            if (r1 != 0) goto L_0x0018
            r0 = 0
            return r0
        L_0x0018:
            com.google.firebase.messaging.u r1 = r5.f39037a
            r1.a(r0)
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.f<java.lang.Void>>> r1 = r5.f39042g
            monitor-enter(r1)
            java.lang.String r0 = r0.f39031c     // Catch:{ all -> 0x004d }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.f<java.lang.Void>>> r2 = r5.f39042g     // Catch:{ all -> 0x004d }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x002c
            monitor-exit(r1)     // Catch:{ all -> 0x004d }
            goto L_0x0000
        L_0x002c:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.f<java.lang.Void>>> r2 = r5.f39042g     // Catch:{ all -> 0x004d }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x004d }
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2     // Catch:{ all -> 0x004d }
            java.lang.Object r3 = r2.poll()     // Catch:{ all -> 0x004d }
            com.google.android.gms.tasks.f r3 = (com.google.android.gms.tasks.f) r3     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x0040
            r4 = 0
            r3.a(r4)     // Catch:{ all -> 0x004d }
        L_0x0040:
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x004d }
            if (r2 == 0) goto L_0x004b
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.f<java.lang.Void>>> r2 = r5.f39042g     // Catch:{ all -> 0x004d }
            r2.remove(r0)     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r1)     // Catch:{ all -> 0x004d }
            goto L_0x0000
        L_0x004d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004d }
            throw r0
        L_0x0050:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0050 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.v.a():boolean");
    }

    private static <T> T a(Task<T> task) throws IOException {
        try {
            return com.google.android.gms.tasks.h.a(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException e3) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e3);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean b() {
        return this.f39044i;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(boolean z) {
        this.f39044i = z;
    }

    private static boolean c() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    static final /* synthetic */ v a(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, af afVar, q qVar) throws Exception {
        return new v(firebaseInstanceId, afVar, u.a(context, scheduledExecutorService), qVar, context, scheduledExecutorService);
    }

    private boolean a(t tVar) throws IOException {
        try {
            String str = tVar.f39030b;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85) {
                    if (str.equals(AppConstants.USER_SUB_TYPE)) {
                        c2 = 1;
                    }
                }
            } else if (str.equals("S")) {
                c2 = 0;
            }
            if (c2 == 0) {
                String str2 = tVar.f39029a;
                w wVar = (w) a(this.f39038c.f());
                q qVar = this.f39041f;
                String a2 = wVar.a();
                String b2 = wVar.b();
                Bundle bundle = new Bundle();
                String valueOf = String.valueOf(str2);
                bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
                String valueOf2 = String.valueOf(str2);
                a(qVar.a(qVar.a(a2, b2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
                if (c()) {
                    String str3 = tVar.f39029a;
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 31);
                    sb.append("Subscribe to topic: ");
                    sb.append(str3);
                    sb.append(" succeeded.");
                }
            } else if (c2 == 1) {
                String str4 = tVar.f39029a;
                w wVar2 = (w) a(this.f39038c.f());
                q qVar2 = this.f39041f;
                String a3 = wVar2.a();
                String b3 = wVar2.b();
                Bundle bundle2 = new Bundle();
                String valueOf3 = String.valueOf(str4);
                bundle2.putString("gcm.topic", valueOf3.length() != 0 ? "/topics/".concat(valueOf3) : new String("/topics/"));
                bundle2.putString("delete", "1");
                String valueOf4 = String.valueOf(str4);
                a(qVar2.a(qVar2.a(a3, b3, valueOf4.length() != 0 ? "/topics/".concat(valueOf4) : new String("/topics/"), bundle2)));
                if (c()) {
                    String str5 = tVar.f39029a;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 35);
                    sb2.append("Unsubscribe from topic: ");
                    sb2.append(str5);
                    sb2.append(" succeeded.");
                }
            } else if (c()) {
                String valueOf5 = String.valueOf(tVar);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf5).length() + 24);
                sb3.append("Unknown topic operation");
                sb3.append(valueOf5);
                sb3.append(AppUtility.CENTER_DOT);
            }
            return true;
        } catch (IOException e2) {
            if ("SERVICE_NOT_AVAILABLE".equals(e2.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e2.getMessage())) {
                String message = e2.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
                sb4.append("Topic operation failed: ");
                sb4.append(message);
                sb4.append(". Will retry Topic operation.");
                return false;
            } else if (e2.getMessage() == null) {
                return false;
            } else {
                throw e2;
            }
        }
    }
}
