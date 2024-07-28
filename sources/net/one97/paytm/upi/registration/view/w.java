package net.one97.paytm.upi.registration.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import java.util.List;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.view.m;

public final class w extends o {

    /* renamed from: a  reason: collision with root package name */
    boolean f69083a = false;

    /* renamed from: b  reason: collision with root package name */
    private List<UpiProfileDefaultBank> f69084b;

    public w(j jVar, List<UpiProfileDefaultBank> list, boolean z) {
        super(jVar);
        this.f69084b = list;
        this.f69083a = z;
    }

    public final Fragment getItem(int i2) {
        return m.a(this.f69084b.get(i2), this.f69083a);
    }

    public final int getCount() {
        List<UpiProfileDefaultBank> list = this.f69084b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
