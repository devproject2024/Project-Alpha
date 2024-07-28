package net.one97.paytm.wallet.splitbill.a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import net.one97.paytm.wallet.splitbill.activity.SBSplitBillActivity;
import net.one97.paytm.wallet.splitbill.c.l;
import net.one97.paytm.wallet.splitbill.model.SBContactDetail;

public final class o extends androidx.fragment.app.o {

    /* renamed from: a  reason: collision with root package name */
    private Context f71943a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f71944b = false;

    /* renamed from: c  reason: collision with root package name */
    private SBSplitBillActivity f71945c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71946d;

    /* renamed from: e  reason: collision with root package name */
    private String f71947e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71948f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<SBContactDetail> f71949g;

    /* renamed from: h  reason: collision with root package name */
    private String f71950h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f71951i = true;

    public final int getCount() {
        return 2;
    }

    public final CharSequence getPageTitle(int i2) {
        return i2 == 0 ? "Bill paid by" : "How is the bill split";
    }

    public o(Context context, j jVar, ArrayList<SBContactDetail> arrayList, String str, String str2, ArrayList<SBContactDetail> arrayList2, ArrayList<SBContactDetail> arrayList3, boolean z) {
        super(jVar);
        this.f71943a = context;
        this.f71945c = (SBSplitBillActivity) context;
        this.f71946d = arrayList;
        this.f71947e = str;
        this.f71950h = str2;
        this.f71948f = arrayList2;
        this.f71949g = arrayList3;
        this.f71951i = z;
    }

    public final Fragment getItem(int i2) {
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", this.f71946d);
        bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
        bundle.putString("bill_amount", this.f71947e);
        bundle.putString("split_options", this.f71950h);
        bundle.putBoolean("is_equal", this.f71951i);
        bundle.putSerializable("paid_contact_list", this.f71948f);
        bundle.putSerializable("split_contact_list", this.f71949g);
        lVar.setArguments(bundle);
        return lVar;
    }
}
