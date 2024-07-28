package com.google.android.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

final class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    AtomicBoolean f7626a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    final BlockingQueue<IBinder> f7627b = new LinkedBlockingQueue();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f7628c = false;

    a() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7628c = true;
        this.f7627b.clear();
        this.f7627b.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f7628c = false;
    }

    public final void a(final Context context) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                if (a.this.f7628c) {
                    context.unbindService(a.this);
                }
            }
        });
    }
}
