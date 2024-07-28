package net.one97.paytm.paymentsBank.activity;

import android.os.Bundle;
import android.view.View;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankOpen.b.b;

public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    String f17419b = "";

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null && getArguments().containsKey("show_feature_specific_view")) {
            this.f17419b = getArguments().getString("show_feature_specific_view");
        }
    }

    public final void d() {
        net.one97.paytm.paymentsBank.e.a.a(getActivity(), this.f17419b, "pc_click_done_account_open");
        if (getActivity() != null && (getActivity() instanceof e)) {
            ((e) getActivity()).a(11);
        }
    }
}
