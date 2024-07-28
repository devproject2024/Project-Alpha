package net.one97.paytm.recharge.common.utils;

import android.view.View;
import androidx.core.h.u;

public final class bk {

    /* renamed from: a  reason: collision with root package name */
    public final View f61611a;

    /* renamed from: b  reason: collision with root package name */
    public int f61612b;

    /* renamed from: c  reason: collision with root package name */
    public int f61613c;

    /* renamed from: d  reason: collision with root package name */
    private int f61614d;

    /* renamed from: e  reason: collision with root package name */
    private int f61615e;

    public bk(View view) {
        this.f61611a = view;
    }

    public final void a() {
        View view = this.f61611a;
        u.f(view, this.f61614d - (view.getTop() - this.f61612b));
        View view2 = this.f61611a;
        u.g(view2, this.f61615e - (view2.getLeft() - this.f61613c));
    }

    public final boolean a(int i2) {
        if (this.f61614d == i2) {
            return false;
        }
        this.f61614d = i2;
        a();
        return true;
    }
}
