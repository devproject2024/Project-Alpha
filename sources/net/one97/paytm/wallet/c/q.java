package net.one97.paytm.wallet.c;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.List;
import net.one97.paytm.common.entity.offline_pg.UpiHelpModel;

final class q extends m {

    /* renamed from: a  reason: collision with root package name */
    private r f70111a;

    /* renamed from: b  reason: collision with root package name */
    private List<UpiHelpModel> f70112b;

    public final int getCount() {
        return 3;
    }

    q(j jVar, r rVar, List<UpiHelpModel> list) {
        super(jVar);
        this.f70111a = rVar;
        this.f70112b = list;
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            return s.a(this.f70112b.get(i2));
        }
        return null;
    }
}
