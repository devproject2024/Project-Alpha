package net.one97.paytm.recharge.legacy.catalog.hathway.a;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRPlanExpiryDetails;
import net.one97.paytm.common.entity.shopping.CJRService;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.catalog.hathway.b.a;

@Deprecated
public final class d extends m {

    /* renamed from: a  reason: collision with root package name */
    private List<CJRPlanExpiryDetails> f62966a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<CJRPlanExpiryDetails> f62967b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Context f62968c;

    public final int getCount() {
        return 2;
    }

    public d(Context context, j jVar, CJRService cJRService) {
        super(jVar);
        this.f62968c = context;
        a(cJRService.getPlanExpiryDetails());
    }

    private void a(List<CJRPlanExpiryDetails> list) {
        if (list != null && list.size() > 0) {
            for (CJRPlanExpiryDetails next : list) {
                if ("addon".equalsIgnoreCase(next.getPackagename())) {
                    this.f62966a.add(next);
                } else if ("alacart".equalsIgnoreCase(next.getPackagename())) {
                    this.f62967b.add(next);
                }
            }
        }
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0) {
            return a.a(this.f62966a);
        }
        if (i2 == 1) {
            return a.a(this.f62967b);
        }
        return null;
    }

    public final CharSequence getPageTitle(int i2) {
        if (i2 == 0) {
            return this.f62968c.getString(R.string.add_ons);
        }
        if (i2 != 1) {
            return null;
        }
        return this.f62968c.getString(R.string.ala_carte);
    }
}
