package net.one97.paytm.landingpage.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.b.e;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.i.f;
import net.one97.paytm.landingpage.R;

public class BottomSheetPostpaidInterstitialFragment extends f implements View.OnClickListener {
    private static BottomSheetPostpaidInterstitialFragment mInstance;
    private RoboButton btnProceedToActivate;
    private CheckBox cbTermsCondition;
    private boolean isPostpaidPopupShown = false;
    private ImageView ivCloseIcon;
    private RoboTextView tvTermsCondition;

    public boolean isPostpaidPopupShown() {
        return this.isPostpaidPopupShown;
    }

    public void setPostpaidPopupShown(boolean z) {
        this.isPostpaidPopupShown = z;
    }

    public static BottomSheetPostpaidInterstitialFragment newInstance() {
        if (mInstance == null) {
            mInstance = new BottomSheetPostpaidInterstitialFragment();
        }
        return mInstance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r0 = net.one97.paytm.utils.ag.a(r7.getApplicationContext());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkAndShowPostPaidBottomSheet(androidx.appcompat.app.AppCompatActivity r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0009
            boolean r0 = r7.isFinishing()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            android.content.Context r0 = r7.getApplicationContext()
            com.paytm.b.a.a r0 = net.one97.paytm.utils.ag.a(r0)
            r1 = 0
            java.lang.String r2 = "postpaid_popup_display_count"
            r3 = 1
            int r1 = r0.b((java.lang.String) r2, (int) r1, (boolean) r3)
            java.lang.Integer r4 = r6.getDisplayCount()
            int r4 = r4.intValue()
            if (r1 >= r4) goto L_0x0044
            boolean r4 = r6.isPostpaidPopupShown
            if (r4 != 0) goto L_0x0044
            java.lang.Class r4 = r6.getClass()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = "checkAndShowPostPaidBottomSheet"
            net.one97.paytm.utils.ao.a(r4, r5)     // Catch:{ Exception -> 0x0044 }
            androidx.fragment.app.j r7 = r7.getSupportFragmentManager()     // Catch:{ Exception -> 0x0044 }
            androidx.fragment.app.q r7 = r7.a()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "postpaid_bottom_sheet_fragment"
            r6.show((androidx.fragment.app.q) r7, (java.lang.String) r4)     // Catch:{ Exception -> 0x0044 }
            r6.setPostpaidPopupShown(r3)     // Catch:{ Exception -> 0x0044 }
            int r1 = r1 + r3
            r0.a((java.lang.String) r2, (int) r1, (boolean) r3)     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.fragment.BottomSheetPostpaidInterstitialFragment.checkAndShowPostPaidBottomSheet(androidx.appcompat.app.AppCompatActivity):void");
    }

    private Integer getDisplayCount() {
        e a2 = d.a();
        getContext();
        return Integer.valueOf(a2.b("postpaid_home_popup_display_count"));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_sheet_postpaid_interstitial, viewGroup, false);
        this.ivCloseIcon = (ImageView) inflate.findViewById(R.id.iv_close_icon);
        this.btnProceedToActivate = (RoboButton) inflate.findViewById(R.id.btn_proceed_to_activate);
        this.cbTermsCondition = (CheckBox) inflate.findViewById(R.id.cb_terms_conditions);
        this.tvTermsCondition = (RoboTextView) inflate.findViewById(R.id.tv_terms_and_condition);
        termsConditionClick();
        this.ivCloseIcon.setOnClickListener(this);
        this.btnProceedToActivate.setOnClickListener(this);
        this.cbTermsCondition.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BottomSheetPostpaidInterstitialFragment.this.lambda$onCreateView$0$BottomSheetPostpaidInterstitialFragment(compoundButton, z);
            }
        });
        if (!this.cbTermsCondition.isChecked()) {
            this.btnProceedToActivate.setEnabled(false);
        }
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$0$BottomSheetPostpaidInterstitialFragment(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.btnProceedToActivate.setEnabled(true);
        } else {
            this.btnProceedToActivate.setEnabled(false);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!this.isPostpaidPopupShown) {
            dismiss();
        }
    }

    private void termsConditionClick() {
        String string = getString(R.string.postpaid_terms_condition);
        int indexOf = string.indexOf("Terms & Conditions");
        this.tvTermsCondition.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvTermsCondition.setHighlightColor(0);
        SpannableString spannableString = new SpannableString(string);
        int i2 = 18 + indexOf;
        spannableString.setSpan("Terms & Conditions", indexOf, i2, 33);
        spannableString.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                d.a().j((Activity) BottomSheetPostpaidInterstitialFragment.this.getActivity());
            }
        }, indexOf, i2, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), indexOf, i2, 33);
        this.tvTermsCondition.setText(spannableString);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_close_icon) {
            dismiss();
        } else if (view.getId() == R.id.btn_proceed_to_activate) {
            dismiss();
            d.b().a(getContext(), "paytmmp://paytm-postpaid?url=homePageSplash");
        }
    }
}
