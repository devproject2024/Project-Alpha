package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.iid.ar;
import com.sendbird.android.constant.StringSet;
import java.io.IOException;

final class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final long f38835a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f38836b = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final FirebaseInstanceId f38837c;

    as(FirebaseInstanceId firebaseInstanceId, long j) {
        this.f38837c = firebaseInstanceId;
        this.f38835a = j;
        this.f38836b.setReferenceCounted(false);
    }

    static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        as f38838a;

        public a(as asVar) {
            this.f38838a = asVar;
        }

        public final void onReceive(Context context, Intent intent) {
            as asVar = this.f38838a;
            if (asVar != null && asVar.b()) {
                FirebaseInstanceId.i();
                FirebaseInstanceId unused = this.f38838a.f38837c;
                FirebaseInstanceId.a((Runnable) this.f38838a, 0);
                this.f38838a.a().unregisterReceiver(this);
                this.f38838a = null;
            }
        }
    }

    public final void run() {
        if (aq.a().a(a())) {
            this.f38836b.acquire();
        }
        try {
            boolean z = true;
            this.f38837c.a(true);
            if (!this.f38837c.f38775e.a()) {
                this.f38837c.a(false);
                if (aq.a().a(a())) {
                    this.f38836b.release();
                    return;
                }
                return;
            }
            aq a2 = aq.a();
            Context a3 = a();
            if (a2.f38825b == null) {
                if (a3.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                    z = false;
                }
                a2.f38825b = Boolean.valueOf(z);
            }
            if (!a2.f38824a.booleanValue()) {
                Log.isLoggable("FirebaseInstanceId", 3);
            }
            if (!a2.f38825b.booleanValue() || b()) {
                if (c()) {
                    this.f38837c.a(false);
                } else {
                    this.f38837c.a(this.f38835a);
                }
                if (aq.a().a(a())) {
                    this.f38836b.release();
                    return;
                }
                return;
            }
            a aVar = new a(this);
            FirebaseInstanceId.i();
            aVar.f38838a.a().registerReceiver(aVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            if (aq.a().a(a())) {
                this.f38836b.release();
            }
        } catch (IOException e2) {
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            this.f38837c.a(false);
            if (aq.a().a(a())) {
                this.f38836b.release();
            }
        } catch (Throwable th) {
            if (aq.a().a(a())) {
                this.f38836b.release();
            }
            throw th;
        }
    }

    private boolean c() throws IOException {
        ar.a h2 = this.f38837c.h();
        boolean z = true;
        if (!this.f38837c.a(h2)) {
            return true;
        }
        try {
            FirebaseInstanceId firebaseInstanceId = this.f38837c;
            String a2 = af.a(firebaseInstanceId.f38774d);
            FirebaseInstanceId.a(firebaseInstanceId.f38774d);
            if (Looper.getMainLooper() != Looper.myLooper()) {
                String b2 = ((w) firebaseInstanceId.a(firebaseInstanceId.a(a2, "*"))).b();
                if (b2 == null) {
                    return false;
                }
                Log.isLoggable("FirebaseInstanceId", 3);
                if ((h2 == null || (h2 != null && !b2.equals(h2.f38832a))) && "[DEFAULT]".equals(this.f38837c.f38774d.b())) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(this.f38837c.f38774d.b());
                        if (valueOf.length() != 0) {
                            "Invoking onNewToken for app: ".concat(valueOf);
                        } else {
                            new String("Invoking onNewToken for app: ");
                        }
                    }
                    Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                    intent.putExtra(StringSet.token, b2);
                    Context a3 = a();
                    Intent intent2 = new Intent(a3, FirebaseInstanceIdReceiver.class);
                    intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                    intent2.putExtra("wrapped_intent", intent);
                    a3.sendBroadcast(intent2);
                }
                return true;
            }
            throw new IOException("MAIN_THREAD");
        } catch (IOException e2) {
            String message = e2.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z = false;
            }
            if (z) {
                String message2 = e2.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message2).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message2);
                sb.append(". Will retry token retrieval");
                return false;
            } else if (e2.getMessage() == null) {
                return false;
            } else {
                throw e2;
            }
        } catch (SecurityException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f38837c.f38774d.a();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
