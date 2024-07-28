package net.one97.paytm.paymentsBank.utils.photocrop.photoview.b;

import android.content.Context;
import android.widget.Scroller;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Scroller f19559a;

    public c(Context context) {
        this.f19559a = new Scroller(context);
    }

    public final boolean a() {
        return this.f19559a.computeScrollOffset();
    }

    public final void b() {
        this.f19559a.forceFinished(true);
    }

    public final boolean c() {
        return this.f19559a.isFinished();
    }

    public final int d() {
        return this.f19559a.getCurrX();
    }

    public final int e() {
        return this.f19559a.getCurrY();
    }
}
