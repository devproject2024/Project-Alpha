package net.one97.paytm.upgradeKyc.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.f;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upgradeKyc.utils.j;

public final class e extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f65679a;

    private View a(int i2) {
        if (this.f65679a == null) {
            this.f65679a = new HashMap();
        }
        View view = (View) this.f65679a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65679a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.complete_kyc_now_btn) {
            startActivity(new Intent(getActivity(), UpgradeKycActivity.class));
            dismiss();
        } else if (view != null && view.getId() == R.id.cross_iv) {
            dismiss();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.kyc_expired_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View.OnClickListener onClickListener = this;
        ((Button) a(R.id.complete_kyc_now_btn)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.cross_iv)).setOnClickListener(onClickListener);
        FragmentActivity activity = getActivity();
        Context context = null;
        String g2 = j.g(activity != null ? activity.getApplicationContext() : null);
        if (!TextUtils.isEmpty(g2)) {
            FragmentActivity activity2 = getActivity();
            if (j.d(activity2 != null ? activity2.getApplicationContext() : null) != 0 || !p.a(j.c(getActivity()), "otp", true)) {
                FragmentActivity activity3 = getActivity();
                if (j.d(activity3 != null ? activity3.getApplicationContext() : null) != 1 || !p.a(j.n(getActivity()), "EKYC_OTP", true)) {
                    FragmentActivity activity4 = getActivity();
                    if (j.d(activity4 != null ? activity4.getApplicationContext() : null) != 1 || !p.a(j.n(getActivity()), "MIN_KYC", true)) {
                        FragmentActivity activity5 = getActivity();
                        if (activity5 != null) {
                            context = activity5.getApplicationContext();
                        }
                        if (j.d(context) == 0 && j.j(getActivity())) {
                            String string = getString(R.string.add_money_unable, g2);
                            k.a((Object) string, "getString(R.string.add_money_unable, expirydate)");
                            TextView textView = (TextView) a(R.id.your_kyc_expired_tv);
                            k.a((Object) textView, "your_kyc_expired_tv");
                            textView.setVisibility(0);
                            TextView textView2 = (TextView) a(R.id.your_kyc_expired_tv);
                            k.a((Object) textView2, "your_kyc_expired_tv");
                            textView2.setText(string);
                            TextView textView3 = (TextView) a(R.id.rbi_guideline_tv);
                            k.a((Object) textView3, "rbi_guideline_tv");
                            textView3.setText(getString(R.string.min_kyc_expiring_soon));
                            return;
                        }
                        return;
                    }
                    String string2 = getString(R.string.add_money_unable, g2);
                    k.a((Object) string2, "getString(R.string.add_money_unable, expirydate)");
                    TextView textView4 = (TextView) a(R.id.your_kyc_expired_tv);
                    k.a((Object) textView4, "your_kyc_expired_tv");
                    textView4.setVisibility(0);
                    TextView textView5 = (TextView) a(R.id.your_kyc_expired_tv);
                    k.a((Object) textView5, "your_kyc_expired_tv");
                    textView5.setText(string2);
                    TextView textView6 = (TextView) a(R.id.rbi_guideline_tv);
                    k.a((Object) textView6, "rbi_guideline_tv");
                    textView6.setText(getString(R.string.min_kyc_expired_body));
                    return;
                }
                String string3 = getString(R.string.wallet_expired_on, g2);
                k.a((Object) string3, "getString(R.string.wallet_expired_on, expirydate)");
                TextView textView7 = (TextView) a(R.id.your_kyc_expired_tv);
                k.a((Object) textView7, "your_kyc_expired_tv");
                textView7.setVisibility(0);
                TextView textView8 = (TextView) a(R.id.your_kyc_expired_tv);
                k.a((Object) textView8, "your_kyc_expired_tv");
                textView8.setText(string3);
                return;
            }
            String string4 = getString(R.string.your_kyc_will_expire_on, g2);
            k.a((Object) string4, "getString(R.string.your_…ill_expire_on,expirydate)");
            TextView textView9 = (TextView) a(R.id.your_kyc_expired_tv);
            k.a((Object) textView9, "your_kyc_expired_tv");
            textView9.setVisibility(0);
            TextView textView10 = (TextView) a(R.id.your_kyc_expired_tv);
            k.a((Object) textView10, "your_kyc_expired_tv");
            textView10.setText(string4);
            return;
        }
        TextView textView11 = (TextView) a(R.id.your_kyc_expired_tv);
        k.a((Object) textView11, "your_kyc_expired_tv");
        textView11.setVisibility(8);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65679a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
