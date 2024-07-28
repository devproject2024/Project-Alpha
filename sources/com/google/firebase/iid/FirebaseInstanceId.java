package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.firebase.a.b;
import com.google.firebase.a.d;
import com.google.firebase.c;
import com.google.firebase.e.h;
import com.google.firebase.iid.ar;
import com.google.firebase.installations.g;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public class FirebaseInstanceId {

    /* renamed from: a  reason: collision with root package name */
    static ar f38770a;

    /* renamed from: b  reason: collision with root package name */
    static ScheduledExecutorService f38771b;

    /* renamed from: i  reason: collision with root package name */
    private static final long f38772i = TimeUnit.HOURS.toSeconds(8);
    private static final Pattern j = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: c  reason: collision with root package name */
    final Executor f38773c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public final c f38774d;

    /* renamed from: e  reason: collision with root package name */
    final af f38775e;

    /* renamed from: f  reason: collision with root package name */
    final q f38776f;

    /* renamed from: g  reason: collision with root package name */
    final ai f38777g;

    /* renamed from: h  reason: collision with root package name */
    public final a f38778h;
    private final g k;
    private boolean l;

    public static FirebaseInstanceId a() {
        return getInstance(c.e());
    }

    public static FirebaseInstanceId getInstance(c cVar) {
        a(cVar);
        return (FirebaseInstanceId) cVar.a(FirebaseInstanceId.class);
    }

    public class a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f38780b;

        /* renamed from: c  reason: collision with root package name */
        private final d f38781c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f38782d;

        /* renamed from: e  reason: collision with root package name */
        private b<com.google.firebase.a> f38783e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f38784f;

        a(d dVar) {
            this.f38781c = dVar;
        }

        private synchronized void b() {
            if (!this.f38782d) {
                this.f38780b = d();
                this.f38784f = c();
                if (this.f38784f == null && this.f38780b) {
                    this.f38783e = new o(this);
                    this.f38781c.a(com.google.firebase.a.class, this.f38783e);
                }
                this.f38782d = true;
            }
        }

        public final synchronized boolean a() {
            b();
            if (this.f38784f == null) {
                return this.f38780b && FirebaseInstanceId.this.f38774d.f();
            }
            return this.f38784f.booleanValue();
        }

        private Boolean c() {
            ApplicationInfo applicationInfo;
            Context a2 = FirebaseInstanceId.this.f38774d.a();
            SharedPreferences sharedPreferences = a2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = a2.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(a2.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private boolean d() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context a2 = FirebaseInstanceId.this.f38774d.a();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(a2.getPackageName());
                ResolveInfo resolveService = a2.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }
    }

    FirebaseInstanceId(c cVar, d dVar, h hVar, com.google.firebase.b.c cVar2, g gVar) {
        this(cVar, new af(cVar.a()), g.b(), g.b(), dVar, hVar, cVar2, gVar);
    }

    private FirebaseInstanceId(c cVar, af afVar, Executor executor, Executor executor2, d dVar, h hVar, com.google.firebase.b.c cVar2, g gVar) {
        this.l = false;
        if (af.a(cVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f38770a == null) {
                    f38770a = new ar(cVar.a());
                }
            }
            this.f38774d = cVar;
            this.f38775e = afVar;
            this.f38776f = new q(cVar, afVar, hVar, cVar2, gVar);
            this.f38773c = executor2;
            this.f38778h = new a(dVar);
            this.f38777g = new ai(executor);
            this.k = gVar;
            executor2.execute(new i(this));
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (a(h())) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(boolean z) {
        this.l = z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c() {
        if (!this.l) {
            a(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(long j2) {
        a((Runnable) new as(this, Math.min(Math.max(30, j2 << 1), f38772i)), j2);
        this.l = true;
    }

    static void a(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (f38771b == null) {
                f38771b = new ScheduledThreadPoolExecutor(1, new com.google.android.gms.common.util.a.b("FirebaseInstanceId"));
            }
            f38771b.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    public final String d() {
        a(this.f38774d);
        b();
        return e();
    }

    static void a(c cVar) {
        s.a(cVar.c().f38757d, (Object) "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        s.a(cVar.c().f38755b, (Object) "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        s.a(cVar.c().f38754a, (Object) "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        s.b(cVar.c().f38755b.contains(AppConstants.COLON), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.b(a(cVar.c().f38754a), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private static boolean a(String str) {
        return j.matcher(str).matches();
    }

    /* access modifiers changed from: package-private */
    public final String e() {
        try {
            f38770a.a(this.f38774d.h());
            Task<String> a2 = this.k.a();
            s.a(a2, (Object) "Task must not be null");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            a2.a(k.f38870a, (com.google.android.gms.tasks.c<String>) new l(countDownLatch));
            countDownLatch.await(30000, TimeUnit.MILLISECONDS);
            if (a2.b()) {
                return a2.d();
            }
            if (a2.c()) {
                throw new CancellationException("Task is already canceled");
            } else if (a2.a()) {
                throw new IllegalStateException(a2.e());
            } else {
                throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
            }
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final Task<w> f() {
        a(this.f38774d);
        return a(af.a(this.f38774d), "*");
    }

    /* access modifiers changed from: package-private */
    public final Task<w> a(String str, String str2) {
        return com.google.android.gms.tasks.h.a(null).b(this.f38773c, new j(this, str, b(str2)));
    }

    @Deprecated
    public final String g() {
        a(this.f38774d);
        ar.a h2 = h();
        if (a(h2)) {
            c();
        }
        return ar.a.a(h2);
    }

    /* access modifiers changed from: package-private */
    public final ar.a h() {
        return b(af.a(this.f38774d), "*");
    }

    /* access modifiers changed from: package-private */
    public final ar.a b(String str, String str2) {
        return f38770a.a(k(), str, str2);
    }

    /* access modifiers changed from: package-private */
    public final <T> T a(Task<T> task) throws IOException {
        try {
            return com.google.android.gms.tasks.h.a(task, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    j();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    static boolean i() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void j() {
        f38770a.a();
        if (this.f38778h.a()) {
            c();
        }
    }

    private static String b(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase(StringSet.gcm)) ? "*" : str;
    }

    /* access modifiers changed from: package-private */
    public final String k() {
        if ("[DEFAULT]".equals(this.f38774d.b())) {
            return "";
        }
        return this.f38774d.h();
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ar.a aVar) {
        return aVar == null || aVar.b(this.f38775e.c());
    }
}
