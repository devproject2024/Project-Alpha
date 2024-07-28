package net.one97.paytm.recharge.c.a;

import android.view.View;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C1166a f60409a;

    /* renamed from: b  reason: collision with root package name */
    final int f60410b;

    /* renamed from: net.one97.paytm.recharge.c.a.a$a  reason: collision with other inner class name */
    public interface C1166a {
        void a(int i2);
    }

    public a(C1166a aVar, int i2) {
        this.f60409a = aVar;
        this.f60410b = i2;
    }

    public final void onClick(View view) {
        this.f60409a.a(this.f60410b);
    }
}
