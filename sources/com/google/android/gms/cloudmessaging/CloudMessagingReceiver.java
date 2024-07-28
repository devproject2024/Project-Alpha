package com.google.android.gms.cloudmessaging;

import android.content.BroadcastReceiver;
import com.google.android.gms.internal.c.a;
import com.google.android.gms.internal.c.b;
import com.google.android.gms.internal.c.d;
import java.util.concurrent.ExecutorService;

public abstract class CloudMessagingReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f8329a;

    public CloudMessagingReceiver() {
        b a2 = a.a();
        com.google.android.gms.common.util.a.b bVar = new com.google.android.gms.common.util.a.b("firebase-iid-executor");
        int i2 = d.f9116a;
        this.f8329a = a2.a(bVar);
    }
}
