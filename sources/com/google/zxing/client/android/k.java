package com.google.zxing.client.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;

public final class k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f40251a = k.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Activity f40252b;

    /* renamed from: c  reason: collision with root package name */
    private final BroadcastReceiver f40253c = new b(this, (byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private boolean f40254d = false;

    /* renamed from: e  reason: collision with root package name */
    private AsyncTask<Object, Object, Object> f40255e;

    public k(Activity activity) {
        this.f40252b = activity;
        a();
    }

    public final synchronized void a() {
        d();
        this.f40255e = new a(this, (byte) 0);
        this.f40255e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public final synchronized void b() {
        d();
        if (this.f40254d) {
            this.f40252b.unregisterReceiver(this.f40253c);
            this.f40254d = false;
        }
    }

    public final synchronized void c() {
        if (!this.f40254d) {
            this.f40252b.registerReceiver(this.f40253c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f40254d = true;
        }
        a();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d() {
        AsyncTask<Object, Object, Object> asyncTask = this.f40255e;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f40255e = null;
        }
    }

    final class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(k kVar, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    k.this.a();
                } else {
                    k.this.d();
                }
            }
        }
    }

    final class a extends AsyncTask<Object, Object, Object> {
        private a() {
        }

        /* synthetic */ a(k kVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000);
                String unused = k.f40251a;
                k.this.f40252b.finish();
                return null;
            } catch (InterruptedException unused2) {
                return null;
            }
        }
    }
}
