package net.one97.paytm.photoview.b;

import android.content.Context;
import android.widget.Scroller;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private Scroller f59697a;

    public c(Context context) {
        this.f59697a = new Scroller(context);
    }

    public final boolean a() {
        return this.f59697a.computeScrollOffset();
    }

    public final void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f59697a.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public final void b() {
        this.f59697a.forceFinished(true);
    }

    public final boolean c() {
        return this.f59697a.isFinished();
    }

    public final int d() {
        return this.f59697a.getCurrX();
    }

    public final int e() {
        return this.f59697a.getCurrY();
    }
}
