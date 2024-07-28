package net.one97.paytm.bankOpen.ica.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.b.g;
import net.one97.paytm.bankOpen.ica.view.stepview.BankStepsView;

public final class k extends g {

    /* renamed from: c  reason: collision with root package name */
    private d f16560c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f16561d;

    private View a(int i2) {
        if (this.f16561d == null) {
            this.f16561d = new HashMap();
        }
        View view = (View) this.f16561d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16561d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int d() {
        return 101;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_set_passcode_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((BankStepsView) a(R.id.stepsViewBank)).a(R.color.gray, R.color.dark_blue, R.color.paytm_primary_color, R.color.gray);
        ((BankStepsView) a(R.id.stepsViewBank)).setSteps(4, 4);
    }

    public final void e() {
        this.f16409b.setText(R.string.pb_ca_set_paytm_passcode);
        ((TextView) a(R.id.second_desc)).setText(R.string.pb_ca_reenter_passcd);
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof d) {
            this.f16560c = (d) context;
        }
    }

    public final void b() {
        TextView textView = this.f16409b;
        kotlin.g.b.k.a((Object) textView, "mTitleTv");
        textView.setText(getString(R.string.pb_ca_set_paytm_passcode));
        ((TextView) a(R.id.second_desc)).setText(R.string.pb_ca_enter_passcd);
        f();
    }

    public final void g() {
        d dVar = this.f16560c;
        if (dVar != null) {
            if (dVar == null) {
                kotlin.g.b.k.a();
            }
            dVar.onFragmentAction(105, (Object) null);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f16561d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
