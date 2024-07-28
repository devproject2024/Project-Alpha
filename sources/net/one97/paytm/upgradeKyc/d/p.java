package net.one97.paytm.upgradeKyc.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.KycFlowActivity;

public final class p extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f65739a;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_near_kyc_center_error, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        int i2 = R.id.fragment_visit_kyc_centre_btn_proceed;
        if (this.f65739a == null) {
            this.f65739a = new HashMap();
        }
        View view3 = (View) this.f65739a.get(Integer.valueOf(i2));
        if (view3 == null) {
            View view4 = getView();
            if (view4 == null) {
                view2 = null;
                ((Button) view2).setOnClickListener(this);
            }
            view3 = view4.findViewById(i2);
            this.f65739a.put(Integer.valueOf(i2), view3);
        }
        view2 = view3;
        ((Button) view2).setOnClickListener(this);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.fragment_visit_kyc_centre_btn_proceed;
        if (valueOf != null && valueOf.intValue() == i2) {
            Intent intent = new Intent(getContext(), KycFlowActivity.class);
            intent.setFlags(67108864);
            intent.putExtra("kyc_flow_purpose", 2);
            startActivity(intent);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65739a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
