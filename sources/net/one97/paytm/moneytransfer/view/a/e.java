package net.one97.paytm.moneytransfer.view.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;

public final class e extends m {

    /* renamed from: a  reason: collision with root package name */
    private String[] f54261a = new String[0];

    public e(j jVar, String[] strArr) {
        super(jVar);
        this.f54261a = strArr;
    }

    public final Fragment getItem(int i2) {
        return net.one97.paytm.moneytransfer.view.fragments.m.a(this.f54261a[i2]);
    }

    public final int getCount() {
        return this.f54261a.length;
    }
}
