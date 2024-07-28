package com.bumptech.glide.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.b.c;
import com.bumptech.glide.g.j;

final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    final c.a f6435a;

    /* renamed from: b  reason: collision with root package name */
    boolean f6436b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f6437c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6438d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f6439e = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            boolean z = e.this.f6436b;
            e.this.f6436b = e.a(context);
            if (z != e.this.f6436b) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    new StringBuilder("connectivity changed, isConnected: ").append(e.this.f6436b);
                }
                e.this.f6435a.a(e.this.f6436b);
            }
        }
    };

    public final void c() {
    }

    e(Context context, c.a aVar) {
        this.f6437c = context.getApplicationContext();
        this.f6435a = aVar;
    }

    static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) j.a((ConnectivityManager) context.getSystemService("connectivity"), "Argument must not be null")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }

    public final void a() {
        if (!this.f6438d) {
            this.f6436b = a(this.f6437c);
            try {
                this.f6437c.registerReceiver(this.f6439e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f6438d = true;
            } catch (SecurityException unused) {
                Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
    }

    public final void b() {
        if (this.f6438d) {
            this.f6437c.unregisterReceiver(this.f6439e);
            this.f6438d = false;
        }
    }
}
