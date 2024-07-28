package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.iid.af;
import java.io.IOException;

final class x implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f39050f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f39051g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f39052h = null;

    /* renamed from: a  reason: collision with root package name */
    private final Context f39053a;

    /* renamed from: b  reason: collision with root package name */
    private final af f39054b;

    /* renamed from: c  reason: collision with root package name */
    private final PowerManager.WakeLock f39055c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final v f39056d;

    /* renamed from: e  reason: collision with root package name */
    private final long f39057e;

    x(v vVar, Context context, af afVar, long j) {
        this.f39056d = vVar;
        this.f39053a = context;
        this.f39057e = j;
        this.f39054b = afVar;
        this.f39055c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    class a extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private x f39059b;

        public a(x xVar) {
            this.f39059b = xVar;
        }

        public final synchronized void onReceive(Context context, Intent intent) {
            if (this.f39059b != null) {
                if (this.f39059b.b()) {
                    boolean unused = x.c();
                    this.f39059b.f39056d.a(this.f39059b, 0);
                    context.unregisterReceiver(this);
                    this.f39059b = null;
                }
            }
        }
    }

    public final void run() {
        if (a(this.f39053a)) {
            this.f39055c.acquire(b.f38999a);
        }
        try {
            this.f39056d.a(true);
            if (!this.f39054b.a()) {
                this.f39056d.a(false);
                if (a(this.f39053a)) {
                    try {
                        this.f39055c.release();
                    } catch (RuntimeException unused) {
                    }
                }
            } else if (!b(this.f39053a) || b()) {
                if (this.f39056d.a()) {
                    this.f39056d.a(false);
                } else {
                    this.f39056d.a(this.f39057e);
                }
                if (a(this.f39053a)) {
                    try {
                        this.f39055c.release();
                    } catch (RuntimeException unused2) {
                    }
                }
            } else {
                a aVar = new a(this);
                c();
                x.this.f39053a.registerReceiver(aVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                if (a(this.f39053a)) {
                    try {
                        this.f39055c.release();
                    } catch (RuntimeException unused3) {
                    }
                }
            }
        } catch (IOException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Failed to sync topics. Won't retry sync. ".concat(valueOf);
            } else {
                new String("Failed to sync topics. Won't retry sync. ");
            }
            this.f39056d.a(false);
            if (a(this.f39053a)) {
                try {
                    this.f39055c.release();
                } catch (RuntimeException unused4) {
                }
            }
        } catch (Throwable th) {
            if (a(this.f39053a)) {
                try {
                    this.f39055c.release();
                } catch (RuntimeException unused5) {
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean b() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f39053a.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    public static boolean c() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    private static boolean a(Context context) {
        boolean z;
        boolean booleanValue;
        synchronized (f39050f) {
            if (f39051g == null) {
                z = a(context, "android.permission.WAKE_LOCK", f39051g);
            } else {
                z = f39051g.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            f39051g = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean b(Context context) {
        boolean z;
        boolean booleanValue;
        synchronized (f39050f) {
            if (f39052h == null) {
                z = a(context, "android.permission.ACCESS_NETWORK_STATE", f39052h);
            } else {
                z = f39052h.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            f39052h = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean a(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            a(str);
        }
        return z;
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 142);
        sb.append("Missing Permission: ");
        sb.append(str);
        sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        return sb.toString();
    }
}
