package net.one97.paytm.nativesdk.transcation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.y;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.bumptech.glide.b;
import com.google.gson.f;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.PaytmAssist;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.NativeOtpHelper;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.common.listeners.PayFragmentInteractor;
import net.one97.paytm.nativesdk.common.view.activity.BaseActivity;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.BankForm;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.DisplayFields;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.RiskContent;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.nativesdk.transcation.viewmodel.NativePlusPayViewModel;
import org.json.JSONException;
import org.json.JSONObject;

public final class NativePlusPayActivity extends BaseActivity implements View.OnClickListener, PayFragmentInteractor {
    /* access modifiers changed from: private */
    public final String TAG;
    private HashMap _$_findViewCache;
    private PaytmAssistParams assistParams;
    private boolean disableUiInteraction;
    /* access modifiers changed from: private */
    public boolean isOtpAutoFilled;
    /* access modifiers changed from: private */
    public boolean isOtpPasted;
    /* access modifiers changed from: private */
    public AlertDialog mAlertDialog;
    /* access modifiers changed from: private */
    public NativePlusPayViewModel mViewModel;
    private ObjectAnimator objectAnimator;
    public NativeOtpHelper otpHelper;
    /* access modifiers changed from: private */
    public PaymentInstrument paymentInstrument;
    private String paymode;
    private ProcessTransactionInfo processTransactionInfo;

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

    public NativePlusPayActivity() {
        String simpleName = NativePlusPayActivity.class.getSimpleName();
        k.a((Object) simpleName, "NativePlusPayActivity::class.java.simpleName");
        this.TAG = simpleName;
    }

    public static final /* synthetic */ NativePlusPayViewModel access$getMViewModel$p(NativePlusPayActivity nativePlusPayActivity) {
        NativePlusPayViewModel nativePlusPayViewModel = nativePlusPayActivity.mViewModel;
        if (nativePlusPayViewModel == null) {
            k.a("mViewModel");
        }
        return nativePlusPayViewModel;
    }

    public final NativeOtpHelper getOtpHelper() {
        NativeOtpHelper nativeOtpHelper = this.otpHelper;
        if (nativeOtpHelper == null) {
            k.a("otpHelper");
        }
        return nativeOtpHelper;
    }

    public final void setOtpHelper(NativeOtpHelper nativeOtpHelper) {
        k.c(nativeOtpHelper, "<set-?>");
        this.otpHelper = nativeOtpHelper;
    }

    public final void onCreate(Bundle bundle) {
        String stringExtra;
        Serializable serializableExtra;
        Serializable serializableExtra2;
        Serializable serializableExtra3;
        super.onCreate(bundle);
        setContentView(R.layout.activity_native_payment);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable(SDKConstants.EXTRA_PROCESSTRANSACTION_INFO);
            if (!(serializable instanceof ProcessTransactionInfo)) {
                serializable = null;
            }
            this.processTransactionInfo = (ProcessTransactionInfo) serializable;
            Serializable serializable2 = bundle.getSerializable(SDKConstants.EXTRA_ASSIST_PARAMS);
            if (!(serializable2 instanceof PaytmAssistParams)) {
                serializable2 = null;
            }
            this.assistParams = (PaytmAssistParams) serializable2;
        }
        Intent intent = getIntent();
        if (!(intent == null || (serializableExtra3 = intent.getSerializableExtra(SDKConstants.EXTRA_PROCESSTRANSACTION_INFO)) == null)) {
            if (!(serializableExtra3 instanceof ProcessTransactionInfo)) {
                serializableExtra3 = null;
            }
            this.processTransactionInfo = (ProcessTransactionInfo) serializableExtra3;
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (serializableExtra2 = intent2.getSerializableExtra(SDKConstants.EXTRA_ASSIST_PARAMS)) == null)) {
            if (!(serializableExtra2 instanceof PaytmAssistParams)) {
                serializableExtra2 = null;
            }
            this.assistParams = (PaytmAssistParams) serializableExtra2;
        }
        Intent intent3 = getIntent();
        if (!(intent3 == null || (serializableExtra = intent3.getSerializableExtra(SDKConstants.PAYMENT_INFO)) == null)) {
            if (!(serializableExtra instanceof PaymentInstrument)) {
                serializableExtra = null;
            }
            this.paymentInstrument = (PaymentInstrument) serializableExtra;
        }
        Intent intent4 = getIntent();
        if (!(intent4 == null || (stringExtra = intent4.getStringExtra(SDKConstants.KEY_PAYMODE)) == null)) {
            if (!(stringExtra instanceof String)) {
                stringExtra = null;
            }
            this.paymode = stringExtra;
        }
        Application application = getApplication();
        k.a((Object) application, "this.application");
        this.mViewModel = new NativePlusPayViewModel(application, this.processTransactionInfo);
        addSubmitObservable();
        addResendObserable();
        addCancelObserable();
        initUI();
        initOtpHelper();
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.PG_SCREEN_LOADED, "direct_otp", "", "", SDKConstants.GA_NATIVE_PLUS));
    }

    public final void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        bundle.putSerializable(SDKConstants.EXTRA_PROCESSTRANSACTION_INFO, this.processTransactionInfo);
        bundle.putSerializable(SDKConstants.EXTRA_ASSIST_PARAMS, this.assistParams);
        super.onSaveInstanceState(bundle);
    }

    private final void initOtpHelper() {
        PaytmAssist.Builder builder;
        Body body;
        RiskContent riskContent;
        PaymentInstrument paymentInstrument2 = this.paymentInstrument;
        String str = null;
        if (paymentInstrument2 != null) {
            if (!TextUtils.isEmpty(paymentInstrument2 != null ? paymentInstrument2.getMid() : null)) {
                Context context = this;
                PaymentInstrument paymentInstrument3 = this.paymentInstrument;
                String mid = paymentInstrument3 != null ? paymentInstrument3.getMid() : null;
                PaymentInstrument paymentInstrument4 = this.paymentInstrument;
                builder = new PaytmAssist.Builder(context, mid, paymentInstrument4 != null ? paymentInstrument4.getOrderId() : null);
                builder.setNativeEnabled(true);
                builder.setAssistEnabled(false);
                builder.setEnableLogging(true);
                ProcessTransactionInfo processTransactionInfo2 = this.processTransactionInfo;
                if (!(processTransactionInfo2 == null || (body = processTransactionInfo2.getBody()) == null || (riskContent = body.getRiskContent()) == null)) {
                    str = riskContent.getEventLinkId();
                }
                builder.setRiskEventLinkId(str);
                DirectPaymentBL instance = DirectPaymentBL.getInstance();
                k.a((Object) instance, "DirectPaymentBL.getInstance()");
                builder.setUserId(instance.getCustomerId());
                builder.setCallBackListener(new NativePlusPayActivity$initOtpHelper$1(this));
                builder.build();
                PaytmAssist.setSmsListener(new NativePlusPayActivity$initOtpHelper$2(this));
                PaytmAssist.startAssist();
            }
        }
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid2 = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        builder = new PaytmAssist.Builder(this, mid2, merchantInstance2.getOrderId());
        builder.setNativeEnabled(true);
        builder.setAssistEnabled(false);
        builder.setEnableLogging(true);
        ProcessTransactionInfo processTransactionInfo22 = this.processTransactionInfo;
        str = riskContent.getEventLinkId();
        builder.setRiskEventLinkId(str);
        DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
        k.a((Object) instance2, "DirectPaymentBL.getInstance()");
        builder.setUserId(instance2.getCustomerId());
        builder.setCallBackListener(new NativePlusPayActivity$initOtpHelper$1(this));
        builder.build();
        PaytmAssist.setSmsListener(new NativePlusPayActivity$initOtpHelper$2(this));
        PaytmAssist.startAssist();
    }

    private final void addAutoSubmitOtpUI() {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.autoSubmitProgressBar);
        k.a((Object) progressBar, "autoSubmitProgressBar");
        progressBar.setVisibility(0);
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(R.id.autoSubmitProgressBar);
        k.a((Object) progressBar2, "autoSubmitProgressBar");
        this.objectAnimator = ObjectAnimator.ofInt((ProgressBar) _$_findCachedViewById(R.id.autoSubmitProgressBar), H5Param.PROGRESS, new int[]{progressBar2.getProgress(), 100}).setDuration(4000);
        ObjectAnimator objectAnimator2 = this.objectAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.addUpdateListener(new NativePlusPayActivity$addAutoSubmitOtpUI$1(this));
        }
        ObjectAnimator objectAnimator3 = this.objectAnimator;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
        ((TextView) _$_findCachedViewById(R.id.tvPaySecurely)).setText(getString(R.string.tap_to_pause));
        ((TextView) _$_findCachedViewById(R.id.tvPaySecurely)).setCompoundDrawablePadding(20);
        ObjectAnimator objectAnimator4 = this.objectAnimator;
        if (objectAnimator4 != null) {
            objectAnimator4.addListener(new NativePlusPayActivity$addAutoSubmitOtpUI$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void removeAutoSubmitOtpUI() {
        ObjectAnimator objectAnimator2 = this.objectAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaySecurely);
        k.a((Object) textView, "tvPaySecurely");
        textView.setText(getString(R.string.pay_securely));
        ((TextView) _$_findCachedViewById(R.id.tvPaySecurely)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.autoSubmitProgressBar);
        k.a((Object) progressBar, "autoSubmitProgressBar");
        progressBar.setProgress(0);
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(R.id.autoSubmitProgressBar);
        k.a((Object) progressBar2, "autoSubmitProgressBar");
        progressBar2.setVisibility(8);
    }

    public final void onStop() {
        super.onStop();
    }

    public final void onStart() {
        super.onStart();
    }

    private final void addResendObserable() {
        NativePlusPayViewModel nativePlusPayViewModel = this.mViewModel;
        if (nativePlusPayViewModel == null) {
            k.a("mViewModel");
        }
        y<OtpApiResponse> otpResendResponse = nativePlusPayViewModel.getOtpResendResponse();
        if (otpResendResponse != null) {
            otpResendResponse.observe(this, new NativePlusPayActivity$addResendObserable$1(this));
        }
    }

    private final void addSubmitObservable() {
        NativePlusPayViewModel nativePlusPayViewModel = this.mViewModel;
        if (nativePlusPayViewModel == null) {
            k.a("mViewModel");
        }
        y<OtpApiResponse> otpSubmitResponse = nativePlusPayViewModel.getOtpSubmitResponse();
        if (otpSubmitResponse != null) {
            otpSubmitResponse.observe(this, new NativePlusPayActivity$addSubmitObservable$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void postDataOnCallBack(OtpApiResponse otpApiResponse) {
        String str;
        f fVar = new f();
        net.one97.paytm.nativesdk.transcation.model.Body body = otpApiResponse.getBody();
        Object obj = null;
        try {
            str = new JSONObject(fVar.b(body != null ? body.getTxnInfo() : null)).getString(SDKConstants.TXN_ID);
            k.a((Object) str, "responseObject.getString(TXN_ID)");
        } catch (JSONException unused) {
            str = "";
        }
        AssistMerchantDetails.getInstance().setTransactionId(str);
        if (MerchantBL.getMerchantInstance().ismWebAppInvoke()) {
            Activity activity = this;
            f fVar2 = new f();
            net.one97.paytm.nativesdk.transcation.model.Body body2 = otpApiResponse.getBody();
            if (body2 != null) {
                obj = body2.getTxnInfo();
            }
            PayUtility.finishSdk(activity, fVar2.b(obj));
            return;
        }
        ProcessTransactionInfo processTransactionInfo2 = new ProcessTransactionInfo(otpApiResponse.getHead(), new Body());
        Body body3 = processTransactionInfo2.getBody();
        if (body3 != null) {
            net.one97.paytm.nativesdk.transcation.model.Body body4 = otpApiResponse.getBody();
            body3.setCallBackUrl(body4 != null ? body4.getCallBackUrl() : null);
        }
        Body body5 = processTransactionInfo2.getBody();
        if (body5 != null) {
            net.one97.paytm.nativesdk.transcation.model.Body body6 = otpApiResponse.getBody();
            if (body6 != null) {
                obj = body6.getTxnInfo();
            }
            body5.setTxnInfo(obj);
        }
        PaymentRepository.Companion companion = PaymentRepository.Companion;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        companion.getInstance(applicationContext).postDataOnCallBack(processTransactionInfo2, new NativePlusPayActivity$postDataOnCallBack$1(this, otpApiResponse));
    }

    private final void addCancelObserable() {
        NativePlusPayViewModel nativePlusPayViewModel = this.mViewModel;
        if (nativePlusPayViewModel == null) {
            k.a("mViewModel");
        }
        y<OtpApiResponse> otpCancelResponse = nativePlusPayViewModel.getOtpCancelResponse();
        if (otpCancelResponse != null) {
            otpCancelResponse.observe(this, new NativePlusPayActivity$addCancelObserable$1(this));
        }
    }

    private final void initUI() {
        Body body;
        BankForm bankForm;
        DisplayFields displayField;
        String str;
        ProcessTransactionInfo processTransactionInfo2 = this.processTransactionInfo;
        if (!(processTransactionInfo2 == null || (body = processTransactionInfo2.getBody()) == null || (bankForm = body.getBankForm()) == null || (displayField = bankForm.getDisplayField()) == null)) {
            if (!TextUtils.isEmpty(displayField.getHeaderText())) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaymentAmount);
                k.a((Object) textView, "tvPaymentAmount");
                textView.setVisibility(0);
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvPaymentAmount);
                k.a((Object) textView2, "tvPaymentAmount");
                String headerText = displayField.getHeaderText();
                if (headerText != null) {
                    str = p.a(headerText, "\\u20B9", FilterPriceSliderFragment.RUPEE_SYMBOL, false);
                } else {
                    str = null;
                }
                textView2.setText(str);
            } else {
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.tvPaymentAmount);
                k.a((Object) textView3, "tvPaymentAmount");
                textView3.setVisibility(8);
            }
            if (!TextUtils.isEmpty(displayField.getBankLogo())) {
                ImageView imageView = (ImageView) _$_findCachedViewById(R.id.ivBankLogo);
                k.a((Object) imageView, "ivBankLogo");
                imageView.setVisibility(0);
                try {
                    b.a((FragmentActivity) this).a(displayField.getBankLogo()).a((ImageView) _$_findCachedViewById(R.id.ivBankLogo));
                } catch (Exception e2) {
                    LogUtility.printStackTrace(e2);
                }
            } else {
                ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.ivBankLogo);
                k.a((Object) imageView2, "ivBankLogo");
                imageView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(displayField.getDescriptionText())) {
                TextView textView4 = (TextView) _$_findCachedViewById(R.id.tvOtpMsg);
                k.a((Object) textView4, "tvOtpMsg");
                textView4.setVisibility(0);
                TextView textView5 = (TextView) _$_findCachedViewById(R.id.tvOtpMsg);
                k.a((Object) textView5, "tvOtpMsg");
                textView5.setText(displayField.getDescriptionText());
            } else {
                TextView textView6 = (TextView) _$_findCachedViewById(R.id.tvOtpMsg);
                k.a((Object) textView6, "tvOtpMsg");
                textView6.setVisibility(4);
            }
        }
        ((OtpEditText) _$_findCachedViewById(R.id.otpEditText)).setOnClickListener(new NativePlusPayActivity$initUI$2(this));
        OtpEditText otpEditText = (OtpEditText) _$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText, "otpEditText");
        otpEditText.setInputType(18);
        OtpEditText otpEditText2 = (OtpEditText) _$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText2, "otpEditText");
        otpEditText2.setTransformationMethod(new NativePlusPayActivity$initUI$3());
        ((OtpEditText) _$_findCachedViewById(R.id.otpEditText)).requestFocus();
        ((OtpEditText) _$_findCachedViewById(R.id.otpEditText)).setOnKeyListener(new NativePlusPayActivity$initUI$4(this));
        ((OtpEditText) _$_findCachedViewById(R.id.otpEditText)).setOnTextChangedListener(new NativePlusPayActivity$initUI$5(this));
        setFieldsVisibility();
        View.OnClickListener onClickListener = this;
        ((TextView) _$_findCachedViewById(R.id.tvGoToBankWebSite)).setOnClickListener(onClickListener);
        ((TextView) _$_findCachedViewById(R.id.tvResendOtp)).setOnClickListener(onClickListener);
        ((RelativeLayout) _$_findCachedViewById(R.id.payButton)).setOnClickListener(onClickListener);
        ((ImageView) _$_findCachedViewById(R.id.ivBack)).setOnClickListener(onClickListener);
    }

    private final void setFieldsVisibility() {
        NativePlusPayViewModel nativePlusPayViewModel = this.mViewModel;
        if (nativePlusPayViewModel == null) {
            k.a("mViewModel");
        }
        if (nativePlusPayViewModel.getDirectFormItemMap().get(DirectFormItemType.SUBMIT) != null) {
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.payButton);
            k.a((Object) relativeLayout, "payButton");
            relativeLayout.setVisibility(0);
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(R.id.payButton);
            k.a((Object) relativeLayout2, "payButton");
            relativeLayout2.setVisibility(8);
        }
        NativePlusPayViewModel nativePlusPayViewModel2 = this.mViewModel;
        if (nativePlusPayViewModel2 == null) {
            k.a("mViewModel");
        }
        if (nativePlusPayViewModel2.getDirectFormItemMap().get(DirectFormItemType.RESEND) != null) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvResendOtp);
            k.a((Object) textView, "tvResendOtp");
            textView.setVisibility(0);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvResendOtp);
            k.a((Object) textView2, "tvResendOtp");
            textView2.setVisibility(8);
        }
        NativePlusPayViewModel nativePlusPayViewModel3 = this.mViewModel;
        if (nativePlusPayViewModel3 == null) {
            k.a("mViewModel");
        }
        if (nativePlusPayViewModel3.getDirectFormItemMap().get(DirectFormItemType.PAYONBANK) != null) {
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(R.id.rlFooter);
            k.a((Object) relativeLayout3, "rlFooter");
            relativeLayout3.setVisibility(0);
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.footerSeparator);
            k.a((Object) textView3, "footerSeparator");
            textView3.setVisibility(0);
            return;
        }
        RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(R.id.rlFooter);
        k.a((Object) relativeLayout4, "rlFooter");
        relativeLayout4.setVisibility(8);
        TextView textView4 = (TextView) _$_findCachedViewById(R.id.footerSeparator);
        k.a((Object) textView4, "footerSeparator");
        textView4.setVisibility(8);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.ivBack;
        if (valueOf != null && valueOf.intValue() == i2) {
            onBackPressed();
            return;
        }
        int i3 = R.id.tvGoToBankWebSite;
        if (valueOf != null && valueOf.intValue() == i3) {
            PaytmAssist.removeAssist();
            Context context = this;
            if (!SDKUtility.isNetworkAvailable(context)) {
                DialogUtility.showNoInternetDialog(context, NativePlusPayActivity$onClick$1.INSTANCE);
                return;
            }
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.GA_DIRECT_OTP_ACTION, "go_to_bank", "init", SDKConstants.GA_NATIVE_PLUS, ""));
            payOnBankSite();
            return;
        }
        int i4 = R.id.tvResendOtp;
        if (valueOf != null && valueOf.intValue() == i4) {
            Context context2 = this;
            if (!SDKUtility.isNetworkAvailable(context2)) {
                DialogUtility.showNoInternetDialog(context2, NativePlusPayActivity$onClick$2.INSTANCE);
                return;
            }
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.GA_DIRECT_OTP_ACTION, "resend_otp", "init", SDKConstants.GA_NATIVE_PLUS, ""));
            disableResendButton();
            NativePlusPayViewModel nativePlusPayViewModel = this.mViewModel;
            if (nativePlusPayViewModel == null) {
                k.a("mViewModel");
            }
            nativePlusPayViewModel.resendOtp();
            return;
        }
        int i5 = R.id.payButton;
        if (valueOf != null && valueOf.intValue() == i5) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.autoSubmitProgressBar);
            k.a((Object) progressBar, "autoSubmitProgressBar");
            if (progressBar.getVisibility() == 0) {
                ((RelativeLayout) _$_findCachedViewById(R.id.payButton)).setOnClickListener((View.OnClickListener) null);
                new Handler().postDelayed(new NativePlusPayActivity$onClick$3(this), 1000);
                removeAutoSubmitOtpUI();
                return;
            }
            OtpEditText otpEditText = (OtpEditText) _$_findCachedViewById(R.id.otpEditText);
            k.a((Object) otpEditText, "otpEditText");
            if (isValidOtp(String.valueOf(otpEditText.getText()))) {
                submitOtp();
            } else {
                showOtpValidationError();
            }
        }
    }

    private final void submitOtp() {
        Context context = this;
        if (!SDKUtility.isNetworkAvailable(context)) {
            DialogUtility.showNoInternetDialog(context, NativePlusPayActivity$submitOtp$1.INSTANCE);
            enableUiInteraction();
            return;
        }
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.GA_DIRECT_OTP_ACTION, "submit_otp", "init", SDKConstants.GA_NATIVE_PLUS, ""));
        disableUiInteraction();
        NativePlusPayViewModel nativePlusPayViewModel = this.mViewModel;
        if (nativePlusPayViewModel == null) {
            k.a("mViewModel");
        }
        OtpEditText otpEditText = (OtpEditText) _$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText, "otpEditText");
        nativePlusPayViewModel.paySecurely(String.valueOf(otpEditText.getText()));
    }

    /* access modifiers changed from: private */
    public final void showOtpValidationError() {
        OtpEditText otpEditText = (OtpEditText) _$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText, "otpEditText");
        otpEditText.setError(true);
        ((OtpEditText) _$_findCachedViewById(R.id.otpEditText)).requestFocus();
        new Handler().postDelayed(new NativePlusPayActivity$showOtpValidationError$1(this), 100);
    }

    private final boolean isValidOtp(String str) {
        return str.length() == 6;
    }

    private final void disableUiInteraction() {
        this.disableUiInteraction = true;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "disableClickView");
        frameLayout.setClickable(true);
        showPaymentLoadingState();
        ((RelativeLayout) _$_findCachedViewById(R.id.payButton)).setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    public final void enableUiInteraction() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.disableUiInteraction = false;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "disableClickView");
        frameLayout.setClickable(false);
        ((RelativeLayout) _$_findCachedViewById(R.id.payButton)).setOnClickListener(this);
        hidePaymentLoadingState();
    }

    private final void showPaymentLoadingState() {
        if (((LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading)) != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading);
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.playAnimation();
                ((RelativeLayout) _$_findCachedViewById(R.id.payButton)).setBackgroundResource(R.drawable.native_button_onloading);
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading);
                k.a((Object) lottieAnimationView2, "ltv_loading");
                lottieAnimationView2.setVisibility(0);
                TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaySecurely);
                k.a((Object) textView, "tvPaySecurely");
                textView.setVisibility(8);
                return;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }

    private final void hidePaymentLoadingState() {
        if (((LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading)) != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading);
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.cancelAnimation();
                ((RelativeLayout) _$_findCachedViewById(R.id.payButton)).setBackgroundResource(R.drawable.nativesdk_button_click);
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading);
                k.a((Object) lottieAnimationView2, "ltv_loading");
                lottieAnimationView2.setVisibility(8);
                TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaySecurely);
                k.a((Object) textView, "tvPaySecurely");
                textView.setVisibility(0);
                return;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }

    public final void onBackPressed() {
        Window window;
        Context context = this;
        Window window2 = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_back_press, (ViewGroup) null, false);
        this.mAlertDialog = new AlertDialog.Builder(context).setView(inflate).create();
        ((TextView) inflate.findViewById(R.id.tv_yes)).setOnClickListener(new NativePlusPayActivity$onBackPressed$1(this, inflate));
        ((TextView) inflate.findViewById(R.id.tv_no)).setOnClickListener(new NativePlusPayActivity$onBackPressed$2(this));
        AlertDialog alertDialog = this.mAlertDialog;
        if (!(alertDialog == null || (window = alertDialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog alertDialog2 = this.mAlertDialog;
        if (alertDialog2 != null) {
            window2 = alertDialog2.getWindow();
        }
        if (window2 == null) {
            k.a();
        }
        window2.setLayout((int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) * 0.7d), -2);
        AlertDialog alertDialog3 = this.mAlertDialog;
        if (alertDialog3 != null) {
            alertDialog3.show();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        PaytmAssist.removeAssist();
    }

    /* access modifiers changed from: private */
    public final void redirectToPaymentOptions(String str) {
        Intent intent = new Intent();
        intent.putExtra("data", str);
        setResult(InstrumentActivity.SHOW_ALERT, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public final void backPressCancelTransaction() {
        NativeSDKRepository nativeSDKRepository;
        try {
            nativeSDKRepository = NativeSDKRepository.getInstance();
        } catch (IllegalStateException unused) {
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            NativeSDKRepository.init(this, instance.isToCreateOrderPaytmSdk());
            nativeSDKRepository = null;
        }
        if (nativeSDKRepository != null) {
            nativeSDKRepository.notifyServerAboutCloseOrder();
        }
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onBackPressedCancelTransaction();
        }
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        a.a(getApplicationContext()).a(intent);
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void enableResendButton() {
        ((TextView) _$_findCachedViewById(R.id.tvResendOtp)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(R.id.tvResendOtp)).setTextColor(androidx.core.content.b.c(this, R.color.paytm_blue));
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvResendOtp);
        k.a((Object) textView, "tvResendOtp");
        textView.setAlpha(1.0f);
    }

    private final void disableResendButton() {
        ((TextView) _$_findCachedViewById(R.id.tvResendOtp)).setOnClickListener((View.OnClickListener) null);
        ((TextView) _$_findCachedViewById(R.id.tvResendOtp)).setTextColor(androidx.core.content.b.c(this, R.color.black));
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvResendOtp);
        k.a((Object) textView, "tvResendOtp");
        textView.setAlpha(0.4f);
    }

    /* access modifiers changed from: private */
    public final void showResendOtpSuccessUi(String str) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.rlResendOtpSuccess);
        k.a((Object) linearLayout, "rlResendOtpSuccess");
        linearLayout.setVisibility(0);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaymentAmount);
        k.a((Object) textView, "tvPaymentAmount");
        textView.setVisibility(4);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.llOtpErrorView);
        k.a((Object) linearLayout2, "llOtpErrorView");
        linearLayout2.setVisibility(8);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvResendOtpSuccess);
        k.a((Object) textView2, "tvResendOtpSuccess");
        textView2.setText(Html.fromHtml(str));
    }

    private final void hideResendOtpSuccessUi() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.rlResendOtpSuccess);
        k.a((Object) linearLayout, "rlResendOtpSuccess");
        linearLayout.setVisibility(8);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaymentAmount);
        k.a((Object) textView, "tvPaymentAmount");
        textView.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.llOtpErrorView);
        k.a((Object) linearLayout2, "llOtpErrorView");
        linearLayout2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showOtpErrorView(String str) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.rlResendOtpSuccess);
        k.a((Object) linearLayout, "rlResendOtpSuccess");
        linearLayout.setVisibility(8);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaymentAmount);
        k.a((Object) textView, "tvPaymentAmount");
        textView.setVisibility(4);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.llOtpErrorView);
        k.a((Object) linearLayout2, "llOtpErrorView");
        linearLayout2.setVisibility(0);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvOtpErrorMsg);
        k.a((Object) textView2, "tvOtpErrorMsg");
        textView2.setText(Html.fromHtml(str));
    }

    /* access modifiers changed from: private */
    public final void hideOtpErrorView() {
        if (((LinearLayout) _$_findCachedViewById(R.id.rlResendOtpSuccess)) != null && ((TextView) _$_findCachedViewById(R.id.tvPaymentAmount)) != null && ((LinearLayout) _$_findCachedViewById(R.id.llOtpErrorView)) != null) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.rlResendOtpSuccess);
            k.a((Object) linearLayout, "rlResendOtpSuccess");
            linearLayout.setVisibility(8);
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvPaymentAmount);
            k.a((Object) textView, "tvPaymentAmount");
            textView.setVisibility(0);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.llOtpErrorView);
            k.a((Object) linearLayout2, "llOtpErrorView");
            linearLayout2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void showRetryDialog(String str) {
        Context context = this;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_retry, (ViewGroup) null, false);
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = (TextView) inflate.findViewById(R.id.tv_rejection);
            k.a((Object) textView, "tvRejectionMsg");
            textView.setText(charSequence);
        }
        AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
        ((TextView) inflate.findViewById(R.id.tv_okGotIt)).setOnClickListener(new NativePlusPayActivity$showRetryDialog$1(this, create));
        View findViewById = inflate.findViewById(R.id.v_underline);
        k.a((Object) findViewById, "view.findViewById<View>(R.id.v_underline)");
        findViewById.setVisibility(8);
        View findViewById2 = inflate.findViewById(R.id.iv_tip);
        k.a((Object) findViewById2, "view.findViewById<ImageView>(R.id.iv_tip)");
        ((ImageView) findViewById2).setVisibility(8);
        View findViewById3 = inflate.findViewById(R.id.tv_retry);
        k.a((Object) findViewById3, "view.findViewById<TextView>(R.id.tv_retry)");
        ((TextView) findViewById3).setVisibility(8);
        k.a((Object) create, "alertDialog");
        if (create.getWindow() != null) {
            Window window = create.getWindow();
            if (window == null) {
                k.a();
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        create.show();
        Rect rect = new Rect();
        Window window2 = getWindow();
        k.a((Object) window2, "window");
        window2.getDecorView().getWindowVisibleDisplayFrame(rect);
        Window window3 = create.getWindow();
        if (window3 == null) {
            k.a();
        }
        window3.setLayout(DialogUtility.getDialogWidth(context), -2);
    }

    public final void saveActivityFromFinish(String str) {
        if (!p.a(str, getChildClassName(), true)) {
            finish();
        }
    }

    public final String getChildClassName() {
        String localClassName = getLocalClassName();
        k.a((Object) localClassName, "localClassName");
        return localClassName;
    }

    private final void payOnBankSite() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(SDKConstants.EXTRA_NEW_FLOW, true);
        NativePlusPayViewModel nativePlusPayViewModel = this.mViewModel;
        if (nativePlusPayViewModel == null) {
            k.a("mViewModel");
        }
        bundle.putSerializable(SDKConstants.EXTRA_BANK_FORM_ITEM, nativePlusPayViewModel.getDirectFormItemMap().get(DirectFormItemType.PAYONBANK));
        PaytmAssistParams paytmAssistParams = this.assistParams;
        String str = null;
        bundle.putString(SDKConstants.PAY_TYPE, paytmAssistParams != null ? paytmAssistParams.getPayType() : null);
        PaytmAssistParams paytmAssistParams2 = this.assistParams;
        bundle.putString("BANK_CODE", paytmAssistParams2 != null ? paytmAssistParams2.getBankCode() : null);
        PaytmAssistParams paytmAssistParams3 = this.assistParams;
        if (paytmAssistParams3 != null) {
            str = paytmAssistParams3.getCardType();
        }
        bundle.putString("cardType", str);
        bundle.putString(SDKConstants.KEY_PAYMODE, this.paymode);
        addPayFragment(bundle);
        showPayOnBankLoader();
        this.disableUiInteraction = true;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "disableClickView");
        frameLayout.setClickable(true);
    }

    public final void backToCashierPage(Fragment fragment, String str, boolean z) {
        hidePayOnBankLoader();
        if (z) {
            redirectToPaymentOptions(str);
        }
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
        hidePayOnBankLoader();
        this.disableUiInteraction = false;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "disableClickView");
        frameLayout.setClickable(false);
        SDKUtils.dismissLoadingSheet(this);
    }

    private final void showPayOnBankLoader() {
        if (((LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading1)) != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading1);
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.playAnimation();
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading1);
                k.a((Object) lottieAnimationView2, "ltv_loading1");
                lottieAnimationView2.setVisibility(0);
                TextView textView = (TextView) _$_findCachedViewById(R.id.tvGoToBankWebSite);
                k.a((Object) textView, "tvGoToBankWebSite");
                textView.setVisibility(4);
                return;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }

    private final void hidePayOnBankLoader() {
        if (((LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading1)) != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading1);
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.cancelAnimation();
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading1);
                k.a((Object) lottieAnimationView2, "ltv_loading1");
                lottieAnimationView2.setVisibility(8);
                TextView textView = (TextView) _$_findCachedViewById(R.id.tvGoToBankWebSite);
                k.a((Object) textView, "tvGoToBankWebSite");
                textView.setVisibility(0);
                return;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }

    /* access modifiers changed from: private */
    public final boolean isValidItemPasted(String str) {
        OtpEditText otpEditText = (OtpEditText) _$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText, "otpEditText");
        Editable text = otpEditText.getText();
        if (text == null) {
            k.a();
        }
        if (text.length() == 6) {
            return true;
        }
        if (str == null) {
            return false;
        }
        int min = Math.min(str.length(), 6);
        for (int i2 = 0; i2 < min; i2++) {
            if (Character.isDigit(str.charAt(i2))) {
                return true;
            }
        }
        return false;
    }
}
