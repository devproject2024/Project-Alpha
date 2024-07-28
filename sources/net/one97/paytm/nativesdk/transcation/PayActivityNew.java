package net.one97.paytm.nativesdk.transcation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.listeners.PayFragmentInteractor;
import net.one97.paytm.nativesdk.common.view.activity.BaseActivity;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.BankFormItem;

public final class PayActivityNew extends BaseActivity implements PayFragmentInteractor {
    private HashMap _$_findViewCache;
    private PaytmAssistParams assistParams;
    private BankFormItem bankFormItem;
    private boolean isNewFlow;
    private PaymentInstrument paymentInstrument;
    private String paymode = "";

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

    public final void addPageVisibleGAEvent() {
    }

    public final boolean shouldKillActivity() {
        return true;
    }

    public final void onCreate(Bundle bundle) {
        if (getIntent().hasExtra(SDKConstants.KEY_PAYMODE)) {
            String stringExtra = getIntent().getStringExtra(SDKConstants.KEY_PAYMODE);
            k.a((Object) stringExtra, "getIntent().getStringExt…SDKConstants.KEY_PAYMODE)");
            this.paymode = stringExtra;
            Boolean isTransparentWebivewPaymode = PayUtility.isTransparentWebivewPaymode(this.paymode);
            k.a((Object) isTransparentWebivewPaymode, "PayUtility.isTransparentWebivewPaymode(paymode)");
            if (isTransparentWebivewPaymode.booleanValue()) {
                setTheme(R.style.NativePayDialogTheme);
            } else {
                setTheme(R.style.NativePaytmAppTheme);
            }
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_pay_layout_new);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        Intent intent = getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(SDKConstants.PAYMENT_INFO) : null;
        if (!(serializableExtra instanceof PaymentInstrument)) {
            serializableExtra = null;
        }
        this.paymentInstrument = (PaymentInstrument) serializableExtra;
        Intent intent2 = getIntent();
        Serializable serializableExtra2 = intent2 != null ? intent2.getSerializableExtra(SDKConstants.EXTRA_ASSIST_PARAMS) : null;
        if (!(serializableExtra2 instanceof PaytmAssistParams)) {
            serializableExtra2 = null;
        }
        this.assistParams = (PaytmAssistParams) serializableExtra2;
        Intent intent3 = getIntent();
        Serializable serializableExtra3 = intent3 != null ? intent3.getSerializableExtra(SDKConstants.EXTRA_BANK_FORM_ITEM) : null;
        if (!(serializableExtra3 instanceof BankFormItem)) {
            serializableExtra3 = null;
        }
        this.bankFormItem = (BankFormItem) serializableExtra3;
        Intent intent4 = getIntent();
        boolean z = false;
        if (intent4 != null) {
            z = intent4.getBooleanExtra(SDKConstants.EXTRA_NEW_FLOW, false);
        }
        this.isNewFlow = z;
        if (!PayUtility.isTransparentWebivewPaymode(this.paymode).booleanValue()) {
            showLoaderDialog();
        } else {
            View findViewById = findViewById(R.id.parent_payActivityNew);
            k.a((Object) findViewById, "findViewById<RelativeLay…id.parent_payActivityNew)");
            ((RelativeLayout) findViewById).setVisibility(8);
        }
        init();
    }

    private final void init() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(SDKConstants.EXTRA_NEW_FLOW, this.isNewFlow);
        PaymentInstrument paymentInstrument2 = this.paymentInstrument;
        if (paymentInstrument2 != null) {
            paymentInstrument2.setGaFlowType(SDKConstants.GA_NATIVE_PLUS_REDIRECTION);
        }
        bundle.putSerializable(SDKConstants.PAYMENT_INFO, this.paymentInstrument);
        PaytmAssistParams paytmAssistParams = this.assistParams;
        if (paytmAssistParams != null) {
            String str = null;
            bundle.putString("BANK_CODE", paytmAssistParams != null ? paytmAssistParams.getBankCode() : null);
            PaytmAssistParams paytmAssistParams2 = this.assistParams;
            bundle.putString(SDKConstants.PAY_TYPE, paytmAssistParams2 != null ? paytmAssistParams2.getPayType() : null);
            PaytmAssistParams paytmAssistParams3 = this.assistParams;
            if (paytmAssistParams3 != null) {
                str = paytmAssistParams3.getCardType();
            }
            bundle.putString("cardType", str);
        }
        bundle.putSerializable(SDKConstants.EXTRA_BANK_FORM_ITEM, this.bankFormItem);
        bundle.putString(SDKConstants.KEY_PAYMODE, this.paymode);
        addPayFragment(bundle);
    }

    public final void saveActivityFromFinish(String str) {
        if (p.a(getChildClassName(), str, true)) {
            finish();
        }
    }

    public final String getChildClassName() {
        String localClassName = getLocalClassName();
        k.a((Object) localClassName, "getLocalClassName()");
        return localClassName;
    }

    public final void backToCashierPage(Fragment fragment, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("data", str);
        setResult(SDKConstants.SHOW_ALERT, intent);
        finish();
    }

    public final void addPayFragment(Bundle bundle) {
        PayFragment payFragment = new PayFragment();
        payFragment.setArguments(bundle);
        q a2 = getSupportFragmentManager().a();
        k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        a2.a(R.id.fragment_container, payFragment, PayFragment.class.getSimpleName());
        a2.c();
    }

    public final void onWebPageFinish() {
        hideLoaderDialog();
    }

    private final void showLoaderDialog() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ltv_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
        ((FrameLayout) _$_findCachedViewById(R.id.cv_progressView)).setVisibility(0);
    }

    private final void hideLoaderDialog() {
        ((FrameLayout) _$_findCachedViewById(R.id.cv_progressView)).setVisibility(8);
    }

    public final void onBackPressed() {
        Fragment c2 = getSupportFragmentManager().c(PayFragment.class.getSimpleName());
        if (c2 instanceof PayFragment) {
            ((PayFragment) c2).onBackPressed();
            return;
        }
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onBackPressedCancelTransaction();
        }
        finish();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        bundle.putSerializable(SDKConstants.EXTRA_BANK_FORM_ITEM, this.bankFormItem);
        bundle.putSerializable(SDKConstants.PAYMENT_INFO, this.paymentInstrument);
        bundle.putSerializable(SDKConstants.EXTRA_ASSIST_PARAMS, this.assistParams);
        bundle.putBoolean(SDKConstants.EXTRA_NEW_FLOW, this.isNewFlow);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable(SDKConstants.EXTRA_BANK_FORM_ITEM);
            if (!(serializable instanceof BankFormItem)) {
                serializable = null;
            }
            this.bankFormItem = (BankFormItem) serializable;
            Serializable serializable2 = bundle.getSerializable(SDKConstants.PAYMENT_INFO);
            if (!(serializable2 instanceof PaymentInstrument)) {
                serializable2 = null;
            }
            this.paymentInstrument = (PaymentInstrument) serializable2;
            Serializable serializable3 = bundle.getSerializable(SDKConstants.EXTRA_ASSIST_PARAMS);
            if (!(serializable3 instanceof PaytmAssistParams)) {
                serializable3 = null;
            }
            this.assistParams = (PaytmAssistParams) serializable3;
            this.isNewFlow = bundle.getBoolean(SDKConstants.EXTRA_NEW_FLOW);
        }
    }
}
