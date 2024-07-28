package net.one97.paytm.payments.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import net.one97.paytm.bankCommon.d.c;

public final class a extends m {

    /* renamed from: a  reason: collision with root package name */
    private c f17141a;

    /* renamed from: b  reason: collision with root package name */
    private c f17142b;

    public final int getCount() {
        return 2;
    }

    public a(j jVar) {
        super(jVar);
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0) {
            if (this.f17141a == null) {
                this.f17141a = new c();
            }
            return this.f17141a;
        } else if (i2 != 1) {
            return null;
        } else {
            if (this.f17142b == null) {
                this.f17142b = new c();
            }
            return this.f17142b;
        }
    }
}
