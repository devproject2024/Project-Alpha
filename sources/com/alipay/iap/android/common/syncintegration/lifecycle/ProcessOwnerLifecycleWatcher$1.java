package com.alipay.iap.android.common.syncintegration.lifecycle;

import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.alipay.iap.android.common.b.c;

class ProcessOwnerLifecycleWatcher$1 implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f14708a;

    @aa(a = k.a.ON_START)
    public void onEnterForeground() {
        this.f14708a.f14710b = true;
        c.e();
        this.f14708a.a();
    }

    @aa(a = k.a.ON_STOP)
    public void onEnterBackground() {
        this.f14708a.f14710b = false;
        c.e();
        this.f14708a.b();
    }
}
