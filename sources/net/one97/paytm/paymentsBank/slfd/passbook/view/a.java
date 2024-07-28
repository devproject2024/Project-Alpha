package net.one97.paytm.paymentsBank.slfd.passbook.view;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.common.view.e;

public final class a extends o {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f19274a;

    /* renamed from: b  reason: collision with root package name */
    private final j f19275b;

    /* renamed from: c  reason: collision with root package name */
    private final int f19276c;

    public final int getCount() {
        return 3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Activity activity, j jVar, int i2) {
        super(jVar);
        k.c(activity, "context");
        k.c(jVar, "fm");
        this.f19274a = activity;
        this.f19275b = jVar;
        this.f19276c = i2;
    }

    public final Fragment getItem(int i2) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        if (i2 == 0) {
            bundle.putString("slfd_status", "A");
        } else if (i2 == 1) {
            bundle.putString("slfd_status", AppConstants.FEED_COMMUNITY);
        } else if (i2 == 2) {
            bundle.putString("slfd_status", "R");
        }
        eVar.setArguments(bundle);
        return eVar;
    }

    public final CharSequence getPageTitle(int i2) {
        if (i2 == 0) {
            String string = this.f19274a.getString(R.string.fd_tab_all);
            k.a((Object) string, "context.getString(R.string.fd_tab_all)");
            return string;
        } else if (i2 == 1) {
            String string2 = this.f19274a.getString(R.string.fd_tab_invested);
            k.a((Object) string2, "context.getString(R.string.fd_tab_invested)");
            return string2;
        } else if (i2 != 2) {
            String string3 = this.f19274a.getString(R.string.fd_tab_all);
            k.a((Object) string3, "context.getString(R.string.fd_tab_all)");
            return string3;
        } else {
            String string4 = this.f19274a.getString(R.string.fd_tab_redeemed);
            k.a((Object) string4, "context.getString(R.string.fd_tab_redeemed)");
            return string4;
        }
    }
}
