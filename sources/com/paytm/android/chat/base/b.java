package com.paytm.android.chat.base;

import android.os.Bundle;
import com.paytm.android.chat.base.c;
import com.paytm.android.chat.base.d;

public abstract class b<V extends d, P extends c<V>> extends a {

    /* renamed from: a  reason: collision with root package name */
    private V f41811a;

    /* renamed from: b  reason: collision with root package name */
    private P f41812b;

    public abstract V d();

    public abstract P e();

    public void onActivityCreated(Bundle bundle) {
        P p;
        super.onActivityCreated(bundle);
        if (this.f41811a == null) {
            this.f41811a = d();
        }
        if (this.f41812b == null) {
            this.f41812b = e();
        }
        V v = this.f41811a;
        if (v != null && (p = this.f41812b) != null) {
            p.f41813a = v;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        P p = this.f41812b;
        if (p != null) {
            p.f41813a = null;
            this.f41812b = null;
        }
    }
}
