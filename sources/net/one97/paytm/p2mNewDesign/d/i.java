package net.one97.paytm.p2mNewDesign.d;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.List;
import net.one97.paytm.common.entity.offline_pg.UpiHelpModel;

final class i extends m {

    /* renamed from: a  reason: collision with root package name */
    private j f51186a;

    /* renamed from: b  reason: collision with root package name */
    private List<UpiHelpModel> f51187b;

    public final int getCount() {
        return 3;
    }

    i(j jVar, j jVar2, List<UpiHelpModel> list) {
        super(jVar);
        this.f51186a = jVar2;
        this.f51187b = list;
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            return k.a(this.f51187b.get(i2));
        }
        return null;
    }
}
