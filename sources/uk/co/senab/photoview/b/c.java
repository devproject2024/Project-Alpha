package uk.co.senab.photoview.b;

import android.content.Context;
import android.widget.Scroller;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private Scroller f21320a;

    public c(Context context) {
        this.f21320a = new Scroller(context);
    }

    public final boolean a() {
        return this.f21320a.computeScrollOffset();
    }

    public final void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f21320a.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public final void b() {
        this.f21320a.forceFinished(true);
    }

    public final boolean c() {
        return this.f21320a.isFinished();
    }

    public final int d() {
        return this.f21320a.getCurrX();
    }

    public final int e() {
        return this.f21320a.getCurrY();
    }
}
