package com.alipay.iap.android.common.syncintegration.lifecycle;

import com.alipay.iap.android.common.b.c;
import java.util.Iterator;
import java.util.List;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected List<Object> f14709a;

    /* access modifiers changed from: protected */
    public final void a() {
        new StringBuilder("notifyAppToForeground. callbacks count: ").append(this.f14709a.size());
        c.e();
        Iterator<Object> it2 = this.f14709a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        new StringBuilder("notifyAppToBackground. callbacks count: ").append(this.f14709a.size());
        c.e();
        Iterator<Object> it2 = this.f14709a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }
}
