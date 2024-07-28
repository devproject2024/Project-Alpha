package net.one97.paytm.paymentsBank.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.bankOpen.b.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.e.a;

public final class c extends f {
    private String o = "";
    private HashMap p;

    public final void e() {
    }

    public final boolean k() {
        return true;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("show_feature_specific_view")) {
            this.o = arguments.getString("show_feature_specific_view");
        }
    }

    public final int d() {
        return R.layout.fragment_payment_bank_set_nominee_v2;
    }

    public final void m() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof e)) {
            activity = null;
        }
        e eVar = (e) activity;
        if (eVar != null) {
            eVar.a(9);
        }
    }

    public final void j() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof net.one97.paytm.bankCommon.f.c)) {
            activity = null;
        }
        net.one97.paytm.bankCommon.f.c cVar = (net.one97.paytm.bankCommon.f.c) activity;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void f() {
        a.a(getActivity(), this.o, "pc_click_nominee_now");
        super.f();
    }

    public final void g() {
        a.a(getActivity(), this.o, "pc_click_nominee_later");
        super.g();
    }

    public final void i() {
        PaymentsBankBaseActivity paymentsBankBaseActivity;
        a.a(getActivity(), this.o, "pc_click_nominee_proceed");
        RadioButton radioButton = this.f16402c;
        k.a((Object) radioButton, "mRbtnAddNominee");
        if (!radioButton.isChecked()) {
            RadioButton radioButton2 = this.f16403d;
            k.a((Object) radioButton2, "mRbtnDoNotAddNominee");
            if (!radioButton2.isChecked()) {
                this.f16404e.setText(h());
                TextView textView = this.f16404e;
                k.a((Object) textView, "mTvError");
                textView.setVisibility(0);
                return;
            }
        }
        if ((getActivity() instanceof PaymentsBankBaseActivity) && (paymentsBankBaseActivity = (PaymentsBankBaseActivity) getActivity()) != null) {
            paymentsBankBaseActivity.f16348b = true;
        }
        RadioButton radioButton3 = this.f16403d;
        k.a((Object) radioButton3, "mRbtnDoNotAddNominee");
        if (radioButton3.isChecked()) {
            l();
        } else if (getActivity() != null && (getActivity() instanceof e)) {
            e eVar = (e) getActivity();
            if (eVar == null) {
                k.a();
            }
            eVar.a(2);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
