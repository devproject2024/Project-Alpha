package net.one97.paytm.hotels2.c.a;

import android.widget.CompoundButton;

public final class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final C0508a f29969a;

    /* renamed from: b  reason: collision with root package name */
    final int f29970b = 1;

    /* renamed from: net.one97.paytm.hotels2.c.a.a$a  reason: collision with other inner class name */
    public interface C0508a {
        void a(boolean z);
    }

    public a(C0508a aVar) {
        this.f29969a = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f29969a.a(z);
    }
}
