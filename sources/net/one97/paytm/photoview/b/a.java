package net.one97.paytm.photoview.b;

import android.content.Context;
import android.widget.OverScroller;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    protected OverScroller f59691a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f59692b = false;

    public a(Context context) {
        this.f59691a = new OverScroller(context);
    }

    public boolean a() {
        if (this.f59692b) {
            this.f59691a.computeScrollOffset();
            this.f59692b = false;
        }
        return this.f59691a.computeScrollOffset();
    }

    public final void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f59691a.fling(i2, i3, i4, i5, i6, i7, i8, i9, 0, 0);
    }

    public final void b() {
        this.f59691a.forceFinished(true);
    }

    public final boolean c() {
        return this.f59691a.isFinished();
    }

    public final int d() {
        return this.f59691a.getCurrX();
    }

    public final int e() {
        return this.f59691a.getCurrY();
    }
}
