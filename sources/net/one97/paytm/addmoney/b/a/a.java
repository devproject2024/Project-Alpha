package net.one97.paytm.addmoney.b.a;

import android.view.View;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C0846a f48399a;

    /* renamed from: b  reason: collision with root package name */
    final int f48400b;

    /* renamed from: net.one97.paytm.addmoney.b.a.a$a  reason: collision with other inner class name */
    public interface C0846a {
        void a(int i2);
    }

    public a(C0846a aVar, int i2) {
        this.f48399a = aVar;
        this.f48400b = i2;
    }

    public final void onClick(View view) {
        this.f48399a.a(this.f48400b);
    }
}
