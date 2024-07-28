package net.one97.paytm.paymentsBank.utils.photocrop.photoview.b;

import android.content.Context;
import android.widget.OverScroller;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    protected final OverScroller f19557a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19558b = false;

    public a(Context context) {
        this.f19557a = new OverScroller(context);
    }

    public boolean a() {
        if (this.f19558b) {
            this.f19557a.computeScrollOffset();
            this.f19558b = false;
        }
        return this.f19557a.computeScrollOffset();
    }

    public final void b() {
        this.f19557a.forceFinished(true);
    }

    public final boolean c() {
        return this.f19557a.isFinished();
    }

    public final int d() {
        return this.f19557a.getCurrX();
    }

    public final int e() {
        return this.f19557a.getCurrY();
    }
}
