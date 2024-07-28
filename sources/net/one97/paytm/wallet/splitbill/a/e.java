package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import net.one97.paytm.wallet.splitbill.activity.SBBillSettlementActivity;
import net.one97.paytm.wallet.splitbill.c.d;
import net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse.SBGroupInfoBaseResponse;

public final class e extends o {

    /* renamed from: a  reason: collision with root package name */
    private Context f71789a;

    /* renamed from: b  reason: collision with root package name */
    private SBBillSettlementActivity f71790b;

    /* renamed from: c  reason: collision with root package name */
    private SBGroupInfoBaseResponse f71791c;

    public final int getCount() {
        return 2;
    }

    public final CharSequence getPageTitle(int i2) {
        return i2 == 0 ? "To Pay" : "To Receive";
    }

    public e(Context context, j jVar, SBGroupInfoBaseResponse sBGroupInfoBaseResponse) {
        super(jVar);
        this.f71789a = context;
        this.f71790b = (SBBillSettlementActivity) context;
        this.f71791c = sBGroupInfoBaseResponse;
    }

    public final Fragment getItem(int i2) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("sb_response_get_group_info", this.f71791c);
        bundle.putInt("fragment_position", i2);
        dVar.setArguments(bundle);
        return dVar;
    }
}
