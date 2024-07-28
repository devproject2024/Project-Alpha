package net.one97.paytm.widget;

import android.view.View;
import androidx.core.h.u;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final View f72430a;

    /* renamed from: b  reason: collision with root package name */
    public int f72431b;

    /* renamed from: c  reason: collision with root package name */
    public int f72432c;

    /* renamed from: d  reason: collision with root package name */
    private int f72433d;

    /* renamed from: e  reason: collision with root package name */
    private int f72434e;

    public h(View view) {
        this.f72430a = view;
    }

    public final void a() {
        View view = this.f72430a;
        u.f(view, this.f72433d - (view.getTop() - this.f72431b));
        View view2 = this.f72430a;
        u.g(view2, this.f72434e - (view2.getLeft() - this.f72432c));
    }

    public final boolean a(int i2) {
        if (this.f72433d == i2) {
            return false;
        }
        this.f72433d = i2;
        a();
        return true;
    }
}
