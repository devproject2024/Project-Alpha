package net.one97.paytm.paymentsBank.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import net.one97.paytm.bankCommon.d.c;

public final class e extends m {

    /* renamed from: a  reason: collision with root package name */
    private c f17314a;

    /* renamed from: b  reason: collision with root package name */
    private c f17315b;

    public final int getCount() {
        return 2;
    }

    public e(j jVar) {
        super(jVar);
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0) {
            if (this.f17314a == null) {
                this.f17314a = new c();
            }
            return this.f17314a;
        } else if (i2 != 1) {
            return null;
        } else {
            if (this.f17315b == null) {
                this.f17315b = new c();
            }
            return this.f17315b;
        }
    }
}
