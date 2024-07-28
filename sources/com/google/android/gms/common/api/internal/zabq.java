package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zabq extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Context f8641a;

    /* renamed from: b  reason: collision with root package name */
    private final bj f8642b;

    public zabq(bj bjVar) {
        this.f8642b = bjVar;
    }

    public final synchronized void a() {
        if (this.f8641a != null) {
            this.f8641a.unregisterReceiver(this);
        }
        this.f8641a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f8642b.a();
            a();
        }
    }
}
