package com.business.common_module.zxingutils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import com.business.common_module.utilities.LogUtility;

public final class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f7427a = g.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Activity f7428b;

    /* renamed from: c  reason: collision with root package name */
    private final BroadcastReceiver f7429c = new b(this, (byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private boolean f7430d = false;

    /* renamed from: e  reason: collision with root package name */
    private AsyncTask<Object, Object, Object> f7431e;

    public g(Activity activity) {
        this.f7428b = activity;
        a();
    }

    public final synchronized void a() {
        f();
        this.f7431e = new a(this, (byte) 0);
        this.f7431e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public final synchronized void b() {
        f();
        if (this.f7430d) {
            this.f7428b.unregisterReceiver(this.f7429c);
            this.f7430d = false;
            return;
        }
        LogUtility.d(f7427a, "PowerStatusReceiver was never registered?");
    }

    public final synchronized void c() {
        if (this.f7430d) {
            LogUtility.d(f7427a, "PowerStatusReceiver was already registered?");
        } else {
            this.f7428b.registerReceiver(this.f7429c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f7430d = true;
        }
        a();
    }

    /* access modifiers changed from: private */
    public synchronized void f() {
        AsyncTask<Object, Object, Object> asyncTask = this.f7431e;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f7431e = null;
        }
    }

    public final void d() {
        f();
    }

    final class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(g gVar, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    g.this.a();
                } else {
                    g.this.f();
                }
            }
        }
    }

    final class a extends AsyncTask<Object, Object, Object> {
        private a() {
        }

        /* synthetic */ a(g gVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000);
                LogUtility.i(g.f7427a, "Finishing activity due to inactivity");
                g.this.f7428b.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }
}
