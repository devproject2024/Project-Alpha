package net.one97.paytm.nativesdk.transcation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.listeners.AssistBuilderCallBack;
import easypay.listeners.WebClientListener;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.PaytmAssist;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil;
import net.one97.paytm.nativesdk.common.listeners.PayFragmentInteractor;
import net.one97.paytm.nativesdk.common.model.OneClickResponse;
import net.one97.paytm.nativesdk.common.view.activity.BaseActivity;
import net.one97.paytm.nativesdk.orflow.transaction.activity.BankOfferTransactionActivity;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.BankFormItem;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;
import net.one97.paytm.payments.visascp.VisaSCPImpl;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import org.json.JSONException;
import org.json.JSONObject;

public class PayFragment extends h implements Response.ErrorListener, Response.Listener, WebClientListener {
    private static final String JAVA_SCRIPT = "javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);";
    private static final String JAVA_SCRIPT_DEVICE_RES_NOTIFY = "(function() { checkSelfPushFlag(); } )()";
    /* access modifiers changed from: private */
    public static final String TAG = PayFragment.class.getSimpleName();
    private String bankCode;
    /* access modifiers changed from: private */
    public BankFormItem bankFormItem;
    private boolean callbackSent = false;
    private String cardType;
    private String eventLinkId;
    private boolean isCollectApp = false;
    boolean isMWebAppInvoke = false;
    /* access modifiers changed from: private */
    public boolean isNbPageLoaded = false;
    private boolean isNewFlow = false;
    private boolean isRetryEnabled = false;
    boolean isWebViewNotInflated = false;
    private Activity mActivity;
    /* access modifiers changed from: private */
    public AlertDialog mAlertDialog;
    private String mAllUrls = "";
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mIsShowedOnce = false;
    private AssistMerchantDetails mPaytmAssist;
    /* access modifiers changed from: private */
    public View mView;
    /* access modifiers changed from: private */
    public WebView mWebView;
    String merchantCallbackUrl = null;
    /* access modifiers changed from: private */
    public OneClickResponse oneClickResponse;
    /* access modifiers changed from: private */
    public PayFragmentInteractor payFragmentInteractor;
    private String payType;
    /* access modifiers changed from: private */
    public PaymentInstrument paymentInstrument;
    /* access modifiers changed from: private */
    public String paymode;
    private String transactionId;
    private AtomicBoolean transactionProcessed = new AtomicBoolean(false);

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        this.mActivity = (Activity) context;
        Activity activity = this.mActivity;
        if (activity instanceof PayFragmentInteractor) {
            this.payFragmentInteractor = (PayFragmentInteractor) activity;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.paymentInstrument = (PaymentInstrument) bundle.getSerializable(SDKConstants.PAYMENT_INFO);
            this.paymode = bundle.getString(SDKConstants.KEY_PAYMODE);
        }
        PaymentInstrument paymentInstrument2 = this.paymentInstrument;
        String str = "";
        if (paymentInstrument2 != null) {
            this.bankCode = paymentInstrument2.getBankCode();
            this.payType = this.paymentInstrument.getPayType();
            this.cardType = this.paymentInstrument.getCardType();
        } else if (bundle != null) {
            this.bankCode = stringDefaultValue(bundle.getString("BANK_CODE"), str);
            this.payType = stringDefaultValue(bundle.getString(SDKConstants.PAY_TYPE), str);
            this.cardType = stringDefaultValue(bundle.getString("cardType"), str);
        }
        if (bundle != null) {
            str = stringDefaultValue(bundle.getString(SDKConstants.EVENT_LINK_ID), str);
        }
        this.eventLinkId = str;
        if (!(bundle == null || bundle.getSerializable(SDKConstants.EXTRA_BANK_FORM_ITEM) == null)) {
            this.bankFormItem = (BankFormItem) bundle.getSerializable(SDKConstants.EXTRA_BANK_FORM_ITEM);
        }
        if (bundle != null) {
            this.isNewFlow = bundle.getBoolean(SDKConstants.EXTRA_NEW_FLOW, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mView = layoutInflater.inflate(R.layout.fragment_pay_layout, viewGroup, false);
        } catch (Exception e2) {
            SDKUtility.logCrashAndException(getClass().getSimpleName(), "PayFragment#onCreateView", e2);
            this.isWebViewNotInflated = true;
            PayFragmentInteractor payFragmentInteractor2 = this.payFragmentInteractor;
            if (payFragmentInteractor2 != null) {
                payFragmentInteractor2.backToCashierPage(this, getString(R.string.webview_unavailable), true);
            }
        }
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.PG_SCREEN_LOADED, "bank_page", "", "", SDKConstants.GA_NATIVE_PLUS));
        return this.mView;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.isWebViewNotInflated) {
            hideLoaderDialog();
            initWebView();
            loadPG();
        }
    }

    private void initWebView() {
        PaytmAssist.Builder builder;
        this.mWebView = (WebView) this.mView.findViewById(R.id.wv_payment);
        if (PayUtility.isTransparentWebivewPaymode(this.paymode).booleanValue()) {
            this.mView.findViewById(R.id.parentLayout).setVisibility(8);
        }
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.addJavascriptInterface(new PaytmJavaScriptInterface(), "HTMLOUT");
        this.mWebView.requestFocus(130);
        this.mPaytmAssist = AssistMerchantDetails.getInstance();
        PaymentInstrument paymentInstrument2 = this.paymentInstrument;
        if (paymentInstrument2 == null || TextUtils.isEmpty(paymentInstrument2.getMid())) {
            builder = new PaytmAssist.Builder(this.mActivity, MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
        } else {
            builder = new PaytmAssist.Builder(this.mActivity, this.paymentInstrument.getMid(), this.paymentInstrument.getOrderId());
        }
        builder.setViewId(Integer.valueOf(R.id.easypayBrowserFragment));
        builder.setServer("PRODUCTION");
        builder.setWebView(this.mWebView);
        builder.setAssistEnabled(MerchantBL.getMerchantInstance().isPaytmAssistEnabled());
        builder.setNativeEnabled(false);
        builder.setEnableLogging(true);
        builder.setRiskEventLinkId(this.eventLinkId);
        builder.setUserId(DirectPaymentBL.getInstance().getCustomerId());
        builder.setCallBackListener(new AssistBuilderCallBack() {
            public void onBuilderStartFailure(String str, Exception exc) {
                String mid = MerchantBL.getMerchantInstance().getMid();
                String mid2 = PayFragment.this.paymentInstrument != null ? PayFragment.this.paymentInstrument.getMid() : "";
                SDKUtility.logCrashAndException(getClass().getSimpleName(), "MID from MerchantBL:" + mid + " and mid from payment instrument:" + mid2, exc);
            }
        });
        builder.build();
        PaytmAssist.startAssist();
        if (TextUtils.isEmpty(this.cardType)) {
            this.cardType = "";
        }
        if (!TextUtils.isEmpty(this.bankCode) && !TextUtils.isEmpty(this.payType)) {
            PaytmAssist.setBankInfo(this.bankCode, this.payType, this.cardType);
        }
        this.merchantCallbackUrl = MerchantBL.getMerchantInstance().getCallbackUrl();
        if (!TextUtils.isEmpty(this.merchantCallbackUrl)) {
            this.merchantCallbackUrl = this.merchantCallbackUrl.toLowerCase();
        }
        this.isMWebAppInvoke = MerchantBL.getMerchantInstance().ismWebAppInvoke();
        this.mWebView.setWebViewClient(PaytmAssist.getWebViewClientInstance());
        this.mWebView.setWebChromeClient(new WebChromeClient());
        PaytmAssist.getWebViewClientInstance().addAssistWebClientListener(this);
    }

    public void onBackPressed() {
        if (!this.isWebViewNotInflated) {
            if ("Net banking".equals(this.paymode)) {
                if (this.isNbPageLoaded) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_LOGIN, SDKConstants.GA_NB_BANK_PAGE_LOADED_BACK_CLICKED, DirectPaymentBL.getInstance().getBankName()));
                } else {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_REDIRECTION, SDKConstants.GA_NB_REDIRECTION_BACK_CLICKED, DirectPaymentBL.getInstance().getBankName()));
                }
            }
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("back_button_clicked", "", ""));
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_back_press, (ViewGroup) null, false);
            this.mAlertDialog = new AlertDialog.Builder(this.mContext).setView(inflate).create();
            inflate.findViewById(R.id.tv_yes).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PayFragment.this.dismissAlertDialog();
                    if ("Net banking".equals(PayFragment.this.paymode)) {
                        if (PayFragment.this.isNbPageLoaded) {
                            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_LOGIN, SDKConstants.GA_NB_BANK_PAGE_LOADED_BACK_CLICKED_CONFIRMED, DirectPaymentBL.getInstance().getBankName()));
                        } else {
                            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_REDIRECTION, SDKConstants.GA_NB_REDIRECTION_BACK_CLICKED_CONFIRMED, DirectPaymentBL.getInstance().getBankName()));
                        }
                    }
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.GA_KEY_CANCEL_PAYMENT, CommonPayParams.Builder.YES, ""));
                    AssistMerchantDetails.getInstance().OnBackPressClicked(Boolean.TRUE);
                    if (PayFragment.this.mWebView != null) {
                        LogUtility.d(PayFragment.TAG, "Back pressed, Webview not null, stop loading");
                        PayFragment.this.mWebView.stopLoading();
                        PayFragment.this.mWebView.destroy();
                    }
                }
            });
            inflate.findViewById(R.id.tv_no).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PayFragment.this.mAlertDialog.dismiss();
                    if ("Net banking".equals(PayFragment.this.paymode)) {
                        if (PayFragment.this.isNbPageLoaded) {
                            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_LOGIN, SDKConstants.GA_NB_BANK_PAGE_LOADED_BACK_CLICKED_CANCELLED, DirectPaymentBL.getInstance().getBankName()));
                        } else {
                            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_REDIRECTION, SDKConstants.GA_NB_REDIRECTION_BACK_CLICKED_CANCELLED, DirectPaymentBL.getInstance().getBankName()));
                        }
                    }
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.GA_KEY_CANCEL_PAYMENT, CommonPayParams.Builder.NO, ""));
                }
            });
            if (this.mAlertDialog.getWindow() != null) {
                this.mAlertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                Window window = this.mAlertDialog.getWindow();
                window.addFlags(2);
                window.setDimAmount(0.5f);
                window.setLayout((int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) * 0.7d), -2);
            }
            this.mAlertDialog.show();
        }
    }

    public void OnWcPageFinish(WebView webView, String str) {
        try {
            if (!this.mActivity.isFinishing() && !this.isRetryEnabled) {
                boolean z = !TextUtils.isEmpty(this.merchantCallbackUrl) && str.contains(this.merchantCallbackUrl);
                if (!this.mIsShowedOnce && !z) {
                    hideLoaderDialog();
                }
                this.mIsShowedOnce = true;
                if (this.payFragmentInteractor instanceof BankOfferTransactionActivity) {
                    this.payFragmentInteractor.onWebPageFinish();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (PayFragment.this.payFragmentInteractor != null) {
                                PayFragment.this.payFragmentInteractor.onWebPageFinish();
                            }
                        }
                    }, 200);
                }
                if (this.mView.findViewById(R.id.parentLayout).getVisibility() == 4) {
                    this.mView.findViewById(R.id.parentLayout).setVisibility(0);
                    this.mView.findViewById(R.id.parentLayout).startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.slide_in_right));
                    if (this.payFragmentInteractor != null) {
                        this.payFragmentInteractor.addPageVisibleGAEvent();
                    }
                }
                if (str != null && str.contains(SDKConstants.PG_STATIC_CALLBACK)) {
                    webView.loadUrl(JAVA_SCRIPT);
                }
                if ("Net banking".equals(this.paymode)) {
                    this.isNbPageLoaded = true;
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_LOGIN, SDKConstants.GA_NB_BANK_PAGE_LOADED, DirectPaymentBL.getInstance().getBankName()));
                }
            }
        } catch (Exception e2) {
            LogUtility.d(TAG, e2.toString());
        }
    }

    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
        try {
            if (!this.mActivity.isFinishing()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.mAllUrls);
                sb.append(this.mAllUrls.length() > 0 ? "|" : "");
                sb.append(str);
                this.mAllUrls = sb.toString();
                if (!this.isRetryEnabled) {
                    LogUtility.d("TAG", str);
                    if (str == null) {
                        return;
                    }
                    if (str.toLowerCase().contains(SDKConstants.PG_CALL_BACK)) {
                        webView.stopLoading();
                        if (PaytmSDK.getCallbackListener() != null) {
                            PaytmSDK.getCallbackListener().onTransactionResponse((Bundle) null);
                        }
                        Intent intent = new Intent("kill");
                        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
                        a.a(this.mContext.getApplicationContext()).a(intent);
                    } else if (!TextUtils.isEmpty(this.merchantCallbackUrl) && str.toLowerCase().contains(this.merchantCallbackUrl) && !str.contains(SDKConstants.PG_STATIC_CALLBACK)) {
                        closeAppInvoke(webView, str);
                    }
                }
            }
        } catch (Exception e2) {
            LogUtility.d(TAG, e2.toString());
        }
    }

    public void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
    }

    public boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        try {
            if (this.mActivity.isFinishing()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            LogUtility.d(TAG, e2.toString());
            return false;
        }
    }

    public void WcshouldInterceptRequest(final WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty("js/hideloader.js") && str.contains("js/hideloader.js")) {
            hideLoaderDialog();
        } else if (str.toLowerCase().contains("https://cart.paytm.com/payment/status")) {
            processInterceptedUrl(str, webView, false);
        } else if (!TextUtils.isEmpty(str) && str.contains(SDKConstants.PG_CALL_BACK)) {
            Activity activity = this.mActivity;
            if (activity != null && !activity.isFinishing()) {
                this.mActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            webView.stopLoading();
                        } catch (Exception e2) {
                            LogUtility.d("PayFragment", "Unable to stop webview" + e2.toString());
                        }
                    }
                });
            }
        } else if (!TextUtils.isEmpty(this.merchantCallbackUrl) && str.toLowerCase().contains(this.merchantCallbackUrl) && !str.contains(SDKConstants.PG_STATIC_CALLBACK)) {
            closeAppInvoke(webView, str);
        }
    }

    private void closeAppInvoke(WebView webView, String str) {
        if (this.isMWebAppInvoke) {
            stopLoading(webView);
        }
        processInterceptedUrl(str, webView, true);
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        LogUtility.d("PayFragment", "Inside onReceivedError:ErrorCode:" + i2 + "\tDescription:" + str + ":\tFailing url:" + str2);
    }

    private void stopLoading(final WebView webView) {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            this.mActivity.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        webView.stopLoading();
                    } catch (Exception e2) {
                        LogUtility.d("PayFragment", "Unable to stop webview" + e2.toString());
                    }
                }
            });
        }
    }

    private String stringDefaultValue(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public void loadPG() {
        if (!SDKUtility.isNetworkAvailable(this.mContext)) {
            PayFragmentInteractor payFragmentInteractor2 = this.payFragmentInteractor;
            if (payFragmentInteractor2 instanceof BankOfferTransactionActivity) {
                payFragmentInteractor2.backToCashierPage(this, "", true);
            } else {
                DialogUtility.showNoInternetDialog(this.mContext, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        PayFragment.this.payFragmentInteractor.backToCashierPage(PayFragment.this, "", false);
                    }
                });
            }
        } else if (!this.isNewFlow || this.bankFormItem == null) {
            PaymentInstrument paymentInstrument2 = this.paymentInstrument;
            if (paymentInstrument2 != null) {
                postPgdata(paymentInstrument2);
            }
        } else {
            postPgdata();
        }
    }

    private void postPgdata() {
        BankFormItem bankFormItem2 = this.bankFormItem;
        if (bankFormItem2 != null && bankFormItem2.getActionUrl() != null) {
            try {
                final byte[] postData = getPostData();
                if (this.mActivity != null && !this.mActivity.isFinishing()) {
                    this.mActivity.runOnUiThread(new Runnable() {
                        public void run() {
                            try {
                                PayFragment.this.mWebView.postUrl(PayFragment.this.bankFormItem.getActionUrl(), postData);
                            } catch (Exception e2) {
                                LogUtility.d("", e2.getMessage());
                            }
                        }
                    });
                }
            } catch (UnsupportedEncodingException e2) {
                LogUtility.d("", e2.getMessage());
            } catch (Exception e3) {
                LogUtility.d("", e3.getMessage());
            }
        }
    }

    private void postPgdata(final PaymentInstrument paymentInstrument2) {
        try {
            final byte[] postData = getPostData(paymentInstrument2);
            if (this.mActivity != null && !this.mActivity.isFinishing()) {
                this.mActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            PayFragment.this.mWebView.postUrl(paymentInstrument2.getmPGUrlToHit(), postData);
                        } catch (Exception e2) {
                            LogUtility.d(PayFragment.TAG, e2.getMessage());
                        }
                    }
                });
            }
        } catch (UnsupportedEncodingException e2) {
            LogUtility.d(TAG, e2.getMessage());
        } catch (Exception e3) {
            LogUtility.d(TAG, e3.getMessage());
        }
    }

    private byte[] getPostData() throws UnsupportedEncodingException {
        if (this.bankFormItem.getContent() == null) {
            return null;
        }
        Map map = (Map) this.bankFormItem.getContent();
        StringBuilder sb = new StringBuilder();
        int size = map.size();
        int i2 = 0;
        for (String str : map.keySet()) {
            if (map.get(str) != null) {
                sb.append(URLEncoder.encode(str, AppConstants.UTF_8) + "=" + URLEncoder.encode((String) map.get(str), AppConstants.UTF_8));
                if (i2 < size - 1) {
                    sb.append(AppConstants.AND_SIGN);
                }
                i2++;
            }
        }
        if (MerchantBL.getMerchantInstance().isAppInvoke()) {
            sb.append("&appCallbackUrl=true");
        }
        return sb.toString().getBytes();
    }

    private byte[] getPostData(PaymentInstrument paymentInstrument2) throws UnsupportedEncodingException {
        HashMap<String, String> hashMap = paymentInstrument2.getmPGParams();
        StringBuilder sb = new StringBuilder();
        int size = hashMap.size();
        int i2 = 0;
        for (String next : hashMap.keySet()) {
            sb.append(URLEncoder.encode(next, AppConstants.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(hashMap.get(next), AppConstants.UTF_8));
            if (i2 < size - 1) {
                sb.append(AppConstants.AND_SIGN);
            }
            i2++;
        }
        if (MerchantBL.getMerchantInstance().isAppInvoke()) {
            sb.append("&appCallbackUrl=true");
        }
        return sb.toString().getBytes();
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onTransactionResponse((Bundle) null);
        }
    }

    public void onResponse(Object obj) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onTransactionResponse((Bundle) null);
        }
    }

    class PaytmJavaScriptInterface {
        private PaytmJavaScriptInterface() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|21|22) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            net.one97.paytm.nativesdk.transcation.PayFragment.access$1000(r4.this$0, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004a */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void processResponse(java.lang.String r5) {
            /*
                r4 = this;
                monitor-enter(r4)
                java.lang.String r0 = net.one97.paytm.nativesdk.transcation.PayFragment.TAG     // Catch:{ all -> 0x0051 }
                net.one97.paytm.nativesdk.Utils.LogUtility.d(r0, r5)     // Catch:{ all -> 0x0051 }
                com.google.gson.f r0 = new com.google.gson.f     // Catch:{ Exception -> 0x004a }
                r0.<init>()     // Catch:{ Exception -> 0x004a }
                java.lang.Class<net.one97.paytm.nativesdk.common.model.TransactionResponse> r1 = net.one97.paytm.nativesdk.common.model.TransactionResponse.class
                java.lang.Object r0 = r0.a((java.lang.String) r5, r1)     // Catch:{ Exception -> 0x004a }
                net.one97.paytm.nativesdk.common.model.TransactionResponse r0 = (net.one97.paytm.nativesdk.common.model.TransactionResponse) r0     // Catch:{ Exception -> 0x004a }
                if (r0 == 0) goto L_0x0043
                java.lang.Boolean r1 = r0.getRetryAllowed()     // Catch:{ Exception -> 0x004a }
                if (r1 == 0) goto L_0x0043
                java.lang.Boolean r1 = r0.getRetryAllowed()     // Catch:{ Exception -> 0x004a }
                boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x004a }
                if (r1 == 0) goto L_0x0043
                java.lang.String r1 = r0.getErrorMessage()     // Catch:{ Exception -> 0x004a }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x004a }
                if (r1 != 0) goto L_0x0043
                net.one97.paytm.nativesdk.transcation.PayFragment r1 = net.one97.paytm.nativesdk.transcation.PayFragment.this     // Catch:{ Exception -> 0x004a }
                net.one97.paytm.nativesdk.common.listeners.PayFragmentInteractor r1 = r1.payFragmentInteractor     // Catch:{ Exception -> 0x004a }
                net.one97.paytm.nativesdk.transcation.PayFragment r2 = net.one97.paytm.nativesdk.transcation.PayFragment.this     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getErrorMessage()     // Catch:{ Exception -> 0x004a }
                r3 = 1
                r1.backToCashierPage(r2, r0, r3)     // Catch:{ Exception -> 0x004a }
                monitor-exit(r4)
                return
            L_0x0043:
                net.one97.paytm.nativesdk.transcation.PayFragment r0 = net.one97.paytm.nativesdk.transcation.PayFragment.this     // Catch:{ Exception -> 0x004a }
                r0.finishSdk(r5)     // Catch:{ Exception -> 0x004a }
                monitor-exit(r4)
                return
            L_0x004a:
                net.one97.paytm.nativesdk.transcation.PayFragment r0 = net.one97.paytm.nativesdk.transcation.PayFragment.this     // Catch:{ all -> 0x0051 }
                r0.finishSdk(r5)     // Catch:{ all -> 0x0051 }
                monitor-exit(r4)
                return
            L_0x0051:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transcation.PayFragment.PaytmJavaScriptInterface.processResponse(java.lang.String):void");
        }

        @JavascriptInterface
        public void setPaRes(String str) {
            LogUtility.d(PayFragment.TAG, "pares is: ".concat(String.valueOf(str)));
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PARES_SET, SDKConstants.GA_ENROLLMENT, PayFragment.this.paymentInstrument.getGaVisaPaymentMode()));
            SDKUtils.getVisaSDK(PayFragment.this.mContext).verifyDevice(PayFragment.this.paymentInstrument.getCardDetails().getFirstSixDigit(), PayFragment.this.paymentInstrument.getCardDetails().getLastFourDigit(), PayFragment.this.paymentInstrument.getCardDetails().getExpiryDate(), str, SDKUtility.getEncryptedAuthCode(PayFragment.this.paymentInstrument.getOneClickInfo()), DirectPaymentBL.getInstance().getCustomerId(), SDKUtility.getCorrelationId(PayFragment.this.paymentInstrument.getOneClickInfo()), new VisaSCPImpl.DeviceVerificationListener() {
                public void onRequestStart() {
                }

                public void onRequestEnd(boolean z, String str) {
                    String access$600 = PayFragment.TAG;
                    LogUtility.d(access$600, "setPaRas:onRequestEnd:calling loadNotifyJavaScript " + z + " " + str);
                    PaytmJavaScriptInterface.this.loadNotifyJavaScript();
                }

                public void onRequestError(String str, String str2, String str3) {
                    LogUtility.d(PayFragment.TAG, "setPaRas:onRequestError:calling loadNotifyJavaScript");
                    PaytmJavaScriptInterface.this.loadNotifyJavaScript();
                }
            });
        }

        @JavascriptInterface
        public void setOneClickToken(String str) {
            if (PayFragment.this.mContext != null) {
                LogUtility.d(PayFragment.TAG, "oneClickToken= ".concat(String.valueOf(str)));
                CardData cardDetails = PayFragment.this.paymentInstrument.getCardDetails();
                boolean isEnrollmentSuccess = SDKUtils.getVisaSDK(PayFragment.this.mContext).isEnrollmentSuccess(cardDetails.getFirstSixDigit(), cardDetails.getLastFourDigit(), cardDetails.getExpiryDate(), DirectPaymentBL.getInstance().getCustomerId());
                String oneClickToken = SDKUtility.setOneClickToken(PayFragment.this.mContext, cardDetails, str);
                OneClickResponse unused = PayFragment.this.oneClickResponse = SDKUtility.getOneClickInfoResponse(isEnrollmentSuccess, SDKUtils.getVisaSDK(PayFragment.this.mContext).isEnrollmentSuccess(cardDetails.getFirstSixDigit(), cardDetails.getLastFourDigit(), cardDetails.getExpiryDate(), DirectPaymentBL.getInstance().getCustomerId()), true, true);
                if (PayFragment.this.oneClickResponse != null) {
                    SDKUtility.sendEnrollmentGAEvent(PayFragment.this.oneClickResponse, oneClickToken, PayFragment.this.paymentInstrument);
                }
            }
        }

        /* access modifiers changed from: private */
        public void loadNotifyJavaScript() {
            if (Build.VERSION.SDK_INT < 19) {
                PayFragment.this.mWebView.addJavascriptInterface(this, getClass().getSimpleName());
                PayFragment.this.mWebView.loadUrl("javascript:CustomWebViewClient.oneClickEnrollConfirmation()");
                return;
            }
            PayFragment.this.mWebView.evaluateJavascript("(function() { oneClickEnrollConfirmation(); } )();", (ValueCallback) null);
        }
    }

    /* access modifiers changed from: private */
    public void finishSdk(String str) {
        String str2;
        if (!this.callbackSent) {
            this.callbackSent = true;
            sendHawkeyeEvent(str);
            checkVisaConsentFlow();
            Bundle bundle = new Bundle();
            try {
                str2 = new JSONObject(str).getString(SDKConstants.TXN_ID);
            } catch (JSONException unused) {
                str2 = "";
            }
            AssistMerchantDetails.getInstance().setTransactionId(str2);
            bundle.putString(SDKConstants.RESPONSE, str);
            if (PaytmSDK.getCallbackListener() == null) {
                return;
            }
            if (!SDKUtility.isPaytmApp(this.mContext)) {
                PaytmSDK.getCallbackListener().onTransactionResponse(bundle);
                PayUtility.killBroadcast(this.mActivity);
            } else if (PayUtility.isTxnStatusFlow(this.mContext)) {
                PayUtility.openTxnSummaryActivity(this.mContext);
            } else {
                if (MerchantBL.getMerchantInstance().isAppInvoke()) {
                    PaytmSDK.getCallbackListener().onTransactionResponse(bundle);
                } else {
                    PaytmSDK.getCallbackListener().onTransactionResponse((Bundle) null);
                }
                PayUtility.killBroadcast(this.mActivity);
            }
        }
    }

    private void checkVisaConsentFlow() {
        CardData cardDetails;
        PaymentInstrument paymentInstrument2 = this.paymentInstrument;
        if (paymentInstrument2 != null && paymentInstrument2.isSingleClickTransaction() && (cardDetails = this.paymentInstrument.getCardDetails()) != null && DirectPaymentBL.getInstance().getCustomerId() != null) {
            SharedPreferenceUtil.getInstance().setBoolean(SDKUtils.getVisaAlias(cardDetails.getFirstSixDigit(), cardDetails.getLastFourDigit(), DirectPaymentBL.getInstance().getCustomerId()), true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendHawkeyeEvent(java.lang.String r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r2 = r1.paymentInstrument
            if (r2 == 0) goto L_0x009a
            java.lang.String r2 = r2.getOneClickInfo()
            if (r2 == 0) goto L_0x009a
            net.one97.paytm.nativesdk.common.model.OneClickResponse r2 = r1.oneClickResponse
            if (r2 == 0) goto L_0x009a
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0033
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x002f }
            r4.<init>(r0)     // Catch:{ Exception -> 0x002f }
            java.lang.String r0 = "SUCCESS"
            java.lang.String r5 = "STATUS"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ Exception -> 0x002f }
            boolean r2 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x002f }
            java.lang.String r0 = "RESPCODE"
            int r3 = r4.optInt(r0, r3)     // Catch:{ Exception -> 0x002f }
            r9 = r3
            goto L_0x0034
        L_0x002f:
            r0 = move-exception
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0)
        L_0x0033:
            r9 = 0
        L_0x0034:
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r0 = r1.paymentInstrument
            long r13 = r0.getTransactionStartTime()
            if (r2 != 0) goto L_0x0057
            android.content.Context r0 = net.one97.paytm.nativesdk.PaytmSDK.getAppContext()
            net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent r3 = net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent.getInstance(r0)
            r4 = 0
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r13
            java.lang.String r8 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "online-pg-transaction"
            java.lang.String r10 = "Failure"
            r6 = r13
            r3.logApiEvent(r4, r5, r6, r8, r9, r10)
            return
        L_0x0057:
            net.one97.paytm.nativesdk.common.model.OneClickResponse r0 = r1.oneClickResponse
            if (r0 == 0) goto L_0x009a
            int r0 = r0.getStatusCode()
            r2 = 101(0x65, float:1.42E-43)
            if (r0 != r2) goto L_0x007f
            android.content.Context r0 = net.one97.paytm.nativesdk.PaytmSDK.getAppContext()
            net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent r10 = net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent.getInstance(r0)
            r11 = 0
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r13
            java.lang.String r15 = java.lang.String.valueOf(r2)
            r16 = 200(0xc8, float:2.8E-43)
            java.lang.String r12 = "online-pg-transaction"
            java.lang.String r17 = "Enrollment"
            r10.logApiEvent(r11, r12, r13, r15, r16, r17)
            return
        L_0x007f:
            android.content.Context r0 = net.one97.paytm.nativesdk.PaytmSDK.getAppContext()
            net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent r10 = net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent.getInstance(r0)
            r11 = 0
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r13
            java.lang.String r15 = java.lang.String.valueOf(r2)
            r16 = 200(0xc8, float:2.8E-43)
            java.lang.String r12 = "online-pg-transaction"
            java.lang.String r17 = "Repeat"
            r10.logApiEvent(r11, r12, r13, r15, r16, r17)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transcation.PayFragment.sendHawkeyeEvent(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void showLoaderDialog() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mView.findViewById(R.id.ltv_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
        this.mView.findViewById(R.id.cv_progressView).setVisibility(0);
    }

    private void hideLoaderDialog() {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            this.mActivity.runOnUiThread(new Runnable() {
                public void run() {
                    PayFragment.this.mView.findViewById(R.id.cv_progressView).setVisibility(8);
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (PaytmAssist.getWebViewClientInstance() != null) {
            PaytmAssist.getWebViewClientInstance().removeAssistWebClientListener(this);
        }
        PaytmAssist.removeAssist();
    }

    public void onResume() {
        super.onResume();
        Activity activity = this.mActivity;
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).hideKeyboard();
        }
    }

    /* access modifiers changed from: private */
    public void dismissAlertDialog() {
        NativeSDKRepository.getInstance().notifyServerAboutCloseOrder();
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onBackPressedCancelTransaction();
        }
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        a.a(this.mContext.getApplicationContext()).a(intent);
        this.mAlertDialog.dismiss();
    }

    private void processTxnStatusResponse(ProcessTransactionInfo processTransactionInfo) {
        String str;
        LogUtility.d("PayFragment", "Sending response back" + new f().b(processTransactionInfo));
        if (this.isRetryEnabled) {
            return;
        }
        if (processTransactionInfo == null || processTransactionInfo.getBody() == null || processTransactionInfo.getBody().getTxnInfo() == null) {
            finishSdk((String) null);
            return;
        }
        String b2 = new f().b(processTransactionInfo.getBody().getTxnInfo());
        try {
            str = new JSONObject(b2).getString(SDKConstants.TXN_ID);
        } catch (JSONException unused) {
            str = "";
        }
        AssistMerchantDetails.getInstance().setTransactionId(str);
        finishSdk(b2);
    }

    private void processInterceptedUrl(String str, final WebView webView, boolean z) {
        try {
            if (!this.transactionProcessed.get()) {
                this.transactionProcessed.set(true);
                LogUtility.d("PayFragment", "Dynamic callBackURL intercepted - before finishing");
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("retryAllowed");
                final String queryParameter2 = parse.getQueryParameter(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
                if (this.mActivity != null && !this.mActivity.isFinishing()) {
                    this.mActivity.runOnUiThread(new Runnable() {
                        public void run() {
                            PayFragment.this.showLoaderDialog();
                        }
                    });
                }
                LogUtility.d("PayFragment", "Retry Allowed:".concat(String.valueOf(queryParameter)));
                if (!TextUtils.isEmpty(queryParameter) && Boolean.valueOf(queryParameter).booleanValue()) {
                    this.isRetryEnabled = true;
                    hideLoaderDialog();
                    if (this.mActivity != null && !this.mActivity.isFinishing()) {
                        this.mActivity.runOnUiThread(new Runnable() {
                            public void run() {
                                try {
                                    webView.stopLoading();
                                    if (PayFragment.this.paymentInstrument != null) {
                                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, PayFragment.this.paymentInstrument.getGaPaymentMethod(), queryParameter2, PayFragment.this.paymentInstrument.getGaFlowType(), ""));
                                    }
                                    PayFragment.this.payFragmentInteractor.backToCashierPage(PayFragment.this, queryParameter2, true);
                                } catch (Exception e2) {
                                    LogUtility.d("PayFragment", "Unable to stop webview" + e2.toString());
                                }
                            }
                        });
                    }
                } else if (z) {
                    this.isRetryEnabled = false;
                    if (this.mActivity != null && !this.mActivity.isFinishing()) {
                        this.mActivity.runOnUiThread(new Runnable() {
                            public void run() {
                                if (PayFragment.this.paymentInstrument != null) {
                                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_complete", PayFragment.this.paymentInstrument.getGaPaymentMethod(), PayFragment.this.paymentInstrument.getGaPaymentMode(), PayFragment.this.paymentInstrument.getGaFlowType(), "Web Redirection:Status Unknown"));
                                }
                            }
                        });
                    }
                    LogUtility.d("PayFragment", "CallBackUrl intercepted - Hitting Api Call");
                    hitTransactionStatusAPI();
                } else {
                    this.transactionProcessed.set(false);
                }
            }
        } catch (Exception unused) {
            stopLoading(webView);
        }
    }

    private void hitTransactionStatusAPI() {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            this.mActivity.runOnUiThread(new Runnable() {
                public void run() {
                    PayFragment.this.showLoaderDialog();
                }
            });
        }
        PaymentRepository.Companion.getInstance(PaytmSDK.getAppContext()).makeTransactionRequest(new PaymentMethodDataSource.Callback<ProcessTransactionInfo>() {
            public void onErrorResponse(VolleyError volleyError, ProcessTransactionInfo processTransactionInfo) {
                LogUtility.d("PayFragment", "Transaction Status Error Response");
                PayFragment.this.processTransactionStatusApiResponse(processTransactionInfo);
            }

            public void onResponse(ProcessTransactionInfo processTransactionInfo) {
                LogUtility.d("PayFragment", "Transaction Status Success");
                PayFragment.this.processTransactionStatusApiResponse(processTransactionInfo);
            }
        });
    }

    /* access modifiers changed from: private */
    public void processTransactionStatusApiResponse(ProcessTransactionInfo processTransactionInfo) {
        LogUtility.d("PayFragment", "Dynamic callBackURL finished and Txn Status API response received");
        processTxnStatusResponse(processTransactionInfo);
    }

    public void onUserLeaveHint() {
        if ("Net banking".equals(this.paymode) && !this.isNbPageLoaded) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventNB(SDKConstants.GA_NB_REDIRECTION, SDKConstants.GA_NB_REDIRECTION_HOME_CLICKED, DirectPaymentBL.getInstance().getBankName()));
        }
    }
}
