package com.business.merchant_payments.requestmoney;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.databinding.MpActivityPaymentLinkBinding;
import java.util.HashMap;
import kotlin.g.b.k;

public final class PaymentLinkActivity extends BaseActivity {
    public HashMap _$_findViewCache;
    public MpActivityPaymentLinkBinding mBinding;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MpActivityPaymentLinkBinding inflate = MpActivityPaymentLinkBinding.inflate(getLayoutInflater());
        k.b(inflate, "MpActivityPaymentLinkBin…g.inflate(layoutInflater)");
        this.mBinding = inflate;
        if (inflate == null) {
            k.a("mBinding");
        }
        inflate.back.setOnClickListener(new PaymentLinkActivity$onCreate$1(this));
        MpActivityPaymentLinkBinding mpActivityPaymentLinkBinding = this.mBinding;
        if (mpActivityPaymentLinkBinding == null) {
            k.a("mBinding");
        }
        CustomTextView customTextView = mpActivityPaymentLinkBinding.title;
        k.b(customTextView, "mBinding.title");
        customTextView.setText(getString(R.string.mp_payment_link_title));
        PaymentLinkFragment paymentLinkFragment = new PaymentLinkFragment();
        Intent intent = getIntent();
        k.b(intent, "intent");
        paymentLinkFragment.setArguments(intent.getExtras());
        addFragment(paymentLinkFragment, "PaymentLinkFragment");
        MpActivityPaymentLinkBinding mpActivityPaymentLinkBinding2 = this.mBinding;
        if (mpActivityPaymentLinkBinding2 == null) {
            k.a("mBinding");
        }
        setContentView(mpActivityPaymentLinkBinding2.getRoot());
    }

    private final void addFragment(Fragment fragment, String str) {
        getSupportFragmentManager().a().j().a(R.id.fragment_container, fragment, str).c();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        Fragment c2;
        LogUtility.d("ActivityResult", "------- REQUEST CODE -------");
        super.onActivityResult(i2, i3, intent);
        if (i2 == 6000 && (c2 = getSupportFragmentManager().c("PaymentLinkFragment")) != null && c2.isVisible()) {
            c2.onActivityResult(i2, i3, intent);
        }
    }
}
