package net.one97.paytm.feed.d.a;

import android.view.View;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C0556a f34264a;

    /* renamed from: b  reason: collision with root package name */
    final int f34265b;

    /* renamed from: net.one97.paytm.feed.d.a.a$a  reason: collision with other inner class name */
    public interface C0556a {
        void a(int i2, View view);
    }

    public a(C0556a aVar, int i2) {
        this.f34264a = aVar;
        this.f34265b = i2;
    }

    public final void onClick(View view) {
        this.f34264a.a(this.f34265b, view);
    }
}
