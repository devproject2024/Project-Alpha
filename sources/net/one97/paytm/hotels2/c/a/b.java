package net.one97.paytm.hotels2.c.a;

import android.view.View;

public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final a f29971a;

    /* renamed from: b  reason: collision with root package name */
    final int f29972b;

    public interface a {
        void a(int i2);
    }

    public b(a aVar, int i2) {
        this.f29971a = aVar;
        this.f29972b = i2;
    }

    public final void onClick(View view) {
        this.f29971a.a(this.f29972b);
    }
}
