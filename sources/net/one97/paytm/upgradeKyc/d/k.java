package net.one97.paytm.upgradeKyc.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;

public final class k extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65705a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private Integer f65706b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f65707c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f65708d = Boolean.TRUE;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f65709e;

    private View a(int i2) {
        if (this.f65709e == null) {
            this.f65709e = new HashMap();
        }
        View view = (View) this.f65709e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65709e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b implements DialogInterface.OnShowListener {
        b() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                View findViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (findViewById != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) findViewById);
                    kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from<View>(bottomSheet)");
                    from.setState(3);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        kotlin.g.b.k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(new b());
        return onCreateDialog;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Boolean bool = null;
        Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("isKycDone")) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        this.f65706b = valueOf;
        Bundle arguments2 = getArguments();
        this.f65707c = arguments2 != null ? arguments2.getString("kycExpiryDate") : null;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            bool = Boolean.valueOf(arguments3.getBoolean("shouldShowUpgradeCTA"));
        }
        this.f65708d = bool;
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == net.one97.paytm.upgradeKyc.R.id.kyc_status_upgrade_btn) {
            startActivity(new Intent(getActivity(), UpgradeKycActivity.class));
            dismiss();
        }
        if (view != null && view.getId() == net.one97.paytm.upgradeKyc.R.id.kyc_status_cross_btn) {
            dismiss();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(net.one97.paytm.upgradeKyc.R.layout.kyc_account_status, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        View.OnClickListener onClickListener = this;
        ((ImageView) a(net.one97.paytm.upgradeKyc.R.id.kyc_status_cross_btn)).setOnClickListener(onClickListener);
        ((Button) a(net.one97.paytm.upgradeKyc.R.id.kyc_status_upgrade_btn)).setOnClickListener(onClickListener);
        Integer num = this.f65706b;
        Resources system = Resources.getSystem();
        kotlin.g.b.k.a((Object) system, "Resources.getSystem()");
        int i2 = (int) (system.getDisplayMetrics().density * 10.0f);
        if (num != null && num.intValue() == 1) {
            TextView textView = (TextView) a(net.one97.paytm.upgradeKyc.R.id.minkyc_completed_tv);
            kotlin.g.b.k.a((Object) textView, "minkyc_completed_tv");
            textView.setText(getString(net.one97.paytm.upgradeKyc.R.string.ekyc_completed));
            TextView textView2 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.monthly_wallet_limit_tv);
            kotlin.g.b.k.a((Object) textView2, "monthly_wallet_limit_tv");
            textView2.setText(getString(net.one97.paytm.upgradeKyc.R.string.yearly_wallet_limit));
            TextView textView3 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.monthly_limit_value_tv);
            kotlin.g.b.k.a((Object) textView3, "monthly_limit_value_tv");
            textView3.setText(getString(net.one97.paytm.upgradeKyc.R.string.two_lacs_limit));
            Button button = (Button) a(net.one97.paytm.upgradeKyc.R.id.kyc_status_upgrade_btn);
            kotlin.g.b.k.a((Object) button, "kyc_status_upgrade_btn");
            button.setText(getString(net.one97.paytm.upgradeKyc.R.string.get_full_kyc_done_to_upgrade));
            TextView textView4 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.send_money_tv);
            kotlin.g.b.k.a((Object) textView4, "send_money_tv");
            textView4.setCompoundDrawablePadding(i2);
            ((TextView) a(net.one97.paytm.upgradeKyc.R.id.send_money_tv)).setCompoundDrawablesWithIntrinsicBounds(net.one97.paytm.upgradeKyc.R.drawable.ic_tick_bottom_sheet, 0, 0, 0);
            ((TextView) a(net.one97.paytm.upgradeKyc.R.id.send_money_to_bank_tv)).setCompoundDrawablesWithIntrinsicBounds(net.one97.paytm.upgradeKyc.R.drawable.ic_tick_bottom_sheet, 0, 0, 0);
            TextView textView5 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.send_money_to_bank_tv);
            kotlin.g.b.k.a((Object) textView5, "send_money_to_bank_tv");
            textView5.setCompoundDrawablePadding(i2);
        } else if (num != null && num.intValue() == 0) {
            TextView textView6 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.minkyc_completed_tv);
            kotlin.g.b.k.a((Object) textView6, "minkyc_completed_tv");
            textView6.setText(getString(net.one97.paytm.upgradeKyc.R.string.min_kyc_completed));
            TextView textView7 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.monthly_wallet_limit_tv);
            kotlin.g.b.k.a((Object) textView7, "monthly_wallet_limit_tv");
            textView7.setText(getString(net.one97.paytm.upgradeKyc.R.string.monthly_wallet_limit));
            TextView textView8 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.monthly_limit_value_tv);
            kotlin.g.b.k.a((Object) textView8, "monthly_limit_value_tv");
            textView8.setText(getString(net.one97.paytm.upgradeKyc.R.string.ten_thsnd_limit));
            Button button2 = (Button) a(net.one97.paytm.upgradeKyc.R.id.kyc_status_upgrade_btn);
            kotlin.g.b.k.a((Object) button2, "kyc_status_upgrade_btn");
            button2.setText(getString(net.one97.paytm.upgradeKyc.R.string.upgrade_and_unlock_benefits));
            TextView textView9 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.send_money_tv);
            kotlin.g.b.k.a((Object) textView9, "send_money_tv");
            textView9.setCompoundDrawablePadding(i2);
            ((TextView) a(net.one97.paytm.upgradeKyc.R.id.send_money_tv)).setCompoundDrawablesWithIntrinsicBounds(net.one97.paytm.upgradeKyc.R.drawable.ic_redcross_bottom_sheet, 0, 0, 0);
            ((TextView) a(net.one97.paytm.upgradeKyc.R.id.send_money_to_bank_tv)).setCompoundDrawablesWithIntrinsicBounds(net.one97.paytm.upgradeKyc.R.drawable.ic_redcross_bottom_sheet, 0, 0, 0);
            TextView textView10 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.send_money_to_bank_tv);
            kotlin.g.b.k.a((Object) textView10, "send_money_to_bank_tv");
            textView10.setCompoundDrawablePadding(i2);
        }
        if (!TextUtils.isEmpty(this.f65707c)) {
            TextView textView11 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.kyc_expires_tv);
            kotlin.g.b.k.a((Object) textView11, "kyc_expires_tv");
            textView11.setVisibility(0);
            TextView textView12 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.kyc_expires_value_tv);
            kotlin.g.b.k.a((Object) textView12, "kyc_expires_value_tv");
            textView12.setText(this.f65707c);
            TextView textView13 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.kyc_expires_value_tv);
            kotlin.g.b.k.a((Object) textView13, "kyc_expires_value_tv");
            textView13.setVisibility(0);
        } else {
            TextView textView14 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.kyc_expires_tv);
            kotlin.g.b.k.a((Object) textView14, "kyc_expires_tv");
            textView14.setVisibility(8);
            TextView textView15 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.kyc_expires_value_tv);
            kotlin.g.b.k.a((Object) textView15, "kyc_expires_value_tv");
            textView15.setVisibility(8);
        }
        Boolean bool = this.f65708d;
        if (bool == null) {
            kotlin.g.b.k.a();
        }
        if (bool.booleanValue()) {
            Button button3 = (Button) a(net.one97.paytm.upgradeKyc.R.id.kyc_status_upgrade_btn);
            kotlin.g.b.k.a((Object) button3, "kyc_status_upgrade_btn");
            button3.setVisibility(0);
            return;
        }
        Button button4 = (Button) a(net.one97.paytm.upgradeKyc.R.id.kyc_status_upgrade_btn);
        kotlin.g.b.k.a((Object) button4, "kyc_status_upgrade_btn");
        button4.setVisibility(8);
        TextView textView16 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.paytm_acnt_status_tv);
        kotlin.g.b.k.a((Object) textView16, "paytm_acnt_status_tv");
        textView16.setText(getString(net.one97.paytm.upgradeKyc.R.string.ekyc_completed));
        TextView textView17 = (TextView) a(net.one97.paytm.upgradeKyc.R.id.minkyc_completed_tv);
        kotlin.g.b.k.a((Object) textView17, "minkyc_completed_tv");
        textView17.setVisibility(8);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65709e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
