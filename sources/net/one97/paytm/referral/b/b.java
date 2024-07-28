package net.one97.paytm.referral.b;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.referral.model.TermsAndCondition;
import net.one97.paytm.referral.model.TermsAndConditionData;
import net.one97.paytm.vipcashback.R;

public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f20023a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.referral.d.a f20024b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f20025c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(net.one97.paytm.referral.d.a.class);
            k.a((Object) a2, "ViewModelProviders.of(it…ralViewModel::class.java]");
            this.f20024b = (net.one97.paytm.referral.d.a) a2;
        }
    }

    public final void setupDialog(Dialog dialog, int i2) {
        TermsAndConditionData data;
        String terms;
        TermsAndConditionData data2;
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        String str = null;
        View inflate = View.inflate(getContext(), R.layout.fragment_tandc_referral, (ViewGroup) null);
        k.a((Object) inflate, "View.inflate(context, R.…ent_tandc_referral, null)");
        this.f20023a = inflate;
        View view = this.f20023a;
        if (view == null) {
            k.a("mRootView");
        }
        dialog.setContentView(view);
        View view2 = this.f20023a;
        if (view2 == null) {
            k.a("mRootView");
        }
        View findViewById = view2.findViewById(R.id.terms_header);
        k.a((Object) findViewById, "mRootView.findViewById(R.id.terms_header)");
        TextView textView = (TextView) findViewById;
        View view3 = this.f20023a;
        if (view3 == null) {
            k.a("mRootView");
        }
        View findViewById2 = view3.findViewById(R.id.tv_terms_and_condition);
        k.a((Object) findViewById2, "mRootView.findViewById(R…d.tv_terms_and_condition)");
        TextView textView2 = (TextView) findViewById2;
        net.one97.paytm.referral.d.a aVar = this.f20024b;
        if (aVar == null) {
            k.a("mReferralViewModel");
        }
        TermsAndCondition value = aVar.f20034e.getValue();
        if (!(value == null || (data2 = value.getData()) == null)) {
            str = data2.getTermsTitle();
        }
        textView.setText(str);
        net.one97.paytm.referral.d.a aVar2 = this.f20024b;
        if (aVar2 == null) {
            k.a("mReferralViewModel");
        }
        TermsAndCondition value2 = aVar2.f20034e.getValue();
        if (!(value2 == null || (data = value2.getData()) == null || (terms = data.getTerms()) == null)) {
            textView2.setText(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(terms, 0) : Html.fromHtml(terms));
        }
        View view4 = this.f20023a;
        if (view4 == null) {
            k.a("mRootView");
        }
        View findViewById3 = view4.findViewById(R.id.closeBottomSheet);
        k.a((Object) findViewById3, "mRootView.findViewById(R.id.closeBottomSheet)");
        ((ImageButton) findViewById3).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20026a;

        a(b bVar) {
            this.f20026a = bVar;
        }

        public final void onClick(View view) {
            this.f20026a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f20025c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
