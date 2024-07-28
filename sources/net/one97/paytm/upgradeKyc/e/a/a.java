package net.one97.paytm.upgradeKyc.e.a;

import android.view.View;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C1305a f65801a;

    /* renamed from: b  reason: collision with root package name */
    final int f65802b;

    /* renamed from: net.one97.paytm.upgradeKyc.e.a.a$a  reason: collision with other inner class name */
    public interface C1305a {
        void a(int i2);
    }

    public a(C1305a aVar, int i2) {
        this.f65801a = aVar;
        this.f65802b = i2;
    }

    public final void onClick(View view) {
        this.f65801a.a(this.f65802b);
    }
}
