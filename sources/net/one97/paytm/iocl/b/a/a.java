package net.one97.paytm.iocl.b.a;

import android.view.View;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C0194a f14189a;

    /* renamed from: b  reason: collision with root package name */
    final int f14190b;

    /* renamed from: net.one97.paytm.iocl.b.a.a$a  reason: collision with other inner class name */
    public interface C0194a {
        void a(int i2, View view);
    }

    public a(C0194a aVar, int i2) {
        this.f14189a = aVar;
        this.f14190b = i2;
    }

    public final void onClick(View view) {
        this.f14189a.a(this.f14190b, view);
    }
}
