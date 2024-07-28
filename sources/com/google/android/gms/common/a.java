package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8345a = false;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<IBinder> f8346b = new LinkedBlockingQueue();

    public final void onServiceDisconnected(ComponentName componentName) {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f8346b.add(iBinder);
    }
}
