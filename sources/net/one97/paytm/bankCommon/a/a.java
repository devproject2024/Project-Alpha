package net.one97.paytm.bankCommon.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import net.one97.paytm.bankCommon.d.c;

public final class a extends m {

    /* renamed from: a  reason: collision with root package name */
    private c f16184a;

    /* renamed from: b  reason: collision with root package name */
    private c f16185b;

    public final int getCount() {
        return 2;
    }

    public a(j jVar) {
        super(jVar);
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0) {
            if (this.f16184a == null) {
                this.f16184a = new c();
            }
            return this.f16184a;
        } else if (i2 != 1) {
            return null;
        } else {
            if (this.f16185b == null) {
                this.f16185b = new c();
            }
            return this.f16185b;
        }
    }
}
