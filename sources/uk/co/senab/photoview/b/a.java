package uk.co.senab.photoview.b;

import android.content.Context;
import android.widget.OverScroller;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    protected OverScroller f21314a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21315b = false;

    public a(Context context) {
        this.f21314a = new OverScroller(context);
    }

    public boolean a() {
        if (this.f21315b) {
            this.f21314a.computeScrollOffset();
            this.f21315b = false;
        }
        return this.f21314a.computeScrollOffset();
    }

    public final void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f21314a.fling(i2, i3, i4, i5, i6, i7, i8, i9, 0, 0);
    }

    public final void b() {
        this.f21314a.forceFinished(true);
    }

    public final boolean c() {
        return this.f21314a.isFinished();
    }

    public final int d() {
        return this.f21314a.getCurrX();
    }

    public final int e() {
        return this.f21314a.getCurrY();
    }
}
