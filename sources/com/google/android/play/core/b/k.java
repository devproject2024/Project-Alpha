package com.google.android.play.core.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class k implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f37309a;

    /* synthetic */ k(l lVar) {
        this.f37309a = lVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f37309a.f37311a.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f37309a.b((c) new i(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37309a.f37311a.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f37309a.b((c) new j(this));
    }
}
