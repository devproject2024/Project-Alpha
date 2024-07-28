package net.one97.paytm.nativesdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.google.gson.f;
import com.google.gson.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.Utils.SharedPreferenceUtil;
import net.one97.paytm.nativesdk.app.DeferredCheckoutCallbackListener;
import net.one97.paytm.nativesdk.app.OnOrderCreatedListener;
import net.one97.paytm.nativesdk.app.PaytmSDKCallbackListener;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.UpiPushCallbackListener;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.Details;
import net.one97.paytm.nativesdk.common.model.EnabledPaymentMode;
import net.one97.paytm.nativesdk.dataSource.PaymentDataSource;
import net.one97.paytm.nativesdk.dataSource.PaymentsDataImpl;
import net.one97.paytm.nativesdk.dataSource.models.PaymentRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.UpiDataRequestModel;
import net.one97.paytm.nativesdk.dataSource.utils.PaymentUtility;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickTransactionInfo;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.UpiProfileDefaultBank;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.login.view.activity.PaytmMainActivity;
import net.one97.paytm.nativesdk.orflow.interfaces.OrFlowCallbackListener;
import net.one97.paytm.nativesdk.orflow.transaction.activity.BankOfferTransactionActivity;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaytmSDK {
    private static Application appContext = null;
    private static boolean isRecordingDisable = false;
    private static String mApi = "production";
    private static String mCashierRequestId = null;
    private static List<EnabledPaymentMode> mEnabledPayMode = null;
    private static Map<String, List<String>> mEnabledPayModeMap = new HashMap();
    private static PaytmSDKCallbackListener mPaytmSDKCallbackListener = null;
    private static Server mServer = null;
    private static String mUPITransId = null;
    private static UpiPushCallbackListener mUpiPushCallBackListener = null;
    private static boolean showOrderInfoPopup = true;
    private static String version = "";
    private boolean isSubscriptioFlow;
    private WeakReference<Context> mActivityContext;
    private double mAmount;
    private boolean mIsAuthenticated;
    private boolean mIsLoginRequired;
    private String mTransactionJson;
    private String mTransactionToken;
    private int merchantLogo;
    private String merchantName;
    private String mid;
    private String orderId;
    private Server server;
    private String ssoToken;

    public static String getNativeSdkVersion() {
        return BuildConfig.artifactoryVersion;
    }

    public static List<EnabledPaymentMode> getmEnabledPayMode() {
        return mEnabledPayMode;
    }

    public static Map<String, List<String>> getmEnabledPayModeMap() {
        return mEnabledPayModeMap;
    }

    public static void setmEnabledPayMode(String str) {
        try {
            for (EnabledPaymentMode enabledPaymentMode : (EnabledPaymentMode[]) new f().a(str, EnabledPaymentMode[].class)) {
                mEnabledPayModeMap.put(enabledPaymentMode.getMode(), enabledPaymentMode.getChannels());
            }
        } catch (p unused) {
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public static Server getServer() {
        return mServer;
    }

    public final void setSubscriptionFlow(boolean z) {
        this.isSubscriptioFlow = z;
        DirectPaymentBL.getInstance().setSubsCriptionFlow(true);
    }

    public static void init(String str, Application application) {
        version = str;
        appContext = application;
    }

    public static String getAppVersion() {
        return version;
    }

    public static void clearInstance() {
        mPaytmSDKCallbackListener = null;
        mUpiPushCallBackListener = null;
        VolleyRequestQueue.destroyInstance();
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static void setCheckoutCallbackListener(PaytmSDKRequestClient paytmSDKRequestClient) {
        DirectPaymentBL.getInstance().setRequestClient(paytmSDKRequestClient);
    }

    public static PaytmSDKRequestClient getCheckoutCallbackListener() {
        return DirectPaymentBL.getInstance().getRequestClient();
    }

    public static PaytmSDKCallbackListener getCallbackListener() {
        return mPaytmSDKCallbackListener;
    }

    public static UpiPushCallbackListener getUpiCallBackListener() {
        return mUpiPushCallBackListener;
    }

    public final void setUpiPushCallBackListener(UpiPushCallbackListener upiPushCallbackListener) {
        mUpiPushCallBackListener = upiPushCallbackListener;
    }

    public static void setServer(Server server2) {
        mServer = server2;
        NativeSdkGtmLoader.setServerUrl(server2);
    }

    public final void disableRecording(boolean z) {
        isRecordingDisable = z;
    }

    public static boolean isRecordingDisable() {
        return isRecordingDisable;
    }

    public static String getServerUrl(Server server2) {
        return NativeSdkGtmLoader.getBaseUrl(server2);
    }

    public static String getServerUrl(String str) {
        NativeSdkGtmLoader.setServerUrl(str);
        return NativeSdkGtmLoader.getBaseUrl(Server.CUSTOM_IP);
    }

    public PaytmSDK(Context context, String str, boolean z, double d2, String str2, String str3, PaytmSDKCallbackListener paytmSDKCallbackListener) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (paytmSDKCallbackListener == null) {
            throw new IllegalArgumentException("Callback listener cannot be null");
        } else if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Invalid Mid");
        } else if (TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Invalid orderId");
        } else if (!TextUtils.isEmpty(str)) {
            this.mActivityContext = new WeakReference<>(context);
            this.mTransactionToken = str;
            mPaytmSDKCallbackListener = paytmSDKCallbackListener;
            this.mAmount = d2;
            this.server = Server.PRODUCTION;
            this.mid = str2;
            if (!TextUtils.isEmpty(this.mid) && this.mid.equalsIgnoreCase(SDKConstants.NATIVESDK_ADD_MONEY_MERCHANT_ID)) {
                DirectPaymentBL.getInstance().setAddMoney(true);
            }
            DirectPaymentBL.getInstance().setToCreateOrderPaytmSdk(false);
            this.orderId = str3;
            this.merchantName = "";
            this.merchantLogo = 0;
            this.mIsAuthenticated = z;
            NativeSdkGtmLoader.setServerUrl(this.server);
            NativeSDKRepository.init(context, false);
            DirectPaymentBL.getInstance().generateRequestId();
        } else {
            throw new IllegalArgumentException("Invalid txn token");
        }
    }

    public PaytmSDK(Context context, String str, boolean z, double d2, String str2, String str3, String str4, PaytmSDKCallbackListener paytmSDKCallbackListener) {
        this(context, str, z, d2, str2, str3, paytmSDKCallbackListener);
        if (!TextUtils.isEmpty(str4)) {
            DirectPaymentBL.getInstance().setVerticalName(str4);
        }
    }

    private PaytmSDK(Builder builder) {
        clearInstance();
        if (builder.context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (builder.callbackListener == null) {
            throw new IllegalArgumentException("Callback listener cannot be null");
        } else if (TextUtils.isEmpty(builder.mid)) {
            throw new IllegalArgumentException("Invalid Mid");
        } else if (TextUtils.isEmpty(builder.orderId)) {
            throw new IllegalArgumentException("Invalid orderId");
        } else if (!TextUtils.isEmpty(builder.txnToken)) {
            if (!TextUtils.isEmpty(builder.verticalName)) {
                DirectPaymentBL.getInstance().setVerticalName(builder.verticalName);
            }
            appContext = (Application) builder.context.getApplicationContext();
            mPaytmSDKCallbackListener = builder.callbackListener;
            NativeSDKRepository.init(appContext, false);
            DirectPaymentBL.getInstance().generateRequestId();
            if (!TextUtils.isEmpty(builder.txnToken)) {
                MerchantBL.getMerchantInstance().setParseData(builder.txnToken, true, builder.amount, builder.orderId, builder.mid, "");
            } else {
                MerchantBL.getMerchantInstance().setParseData(builder.amount, builder.mid, "", "");
            }
            setEnablePaytmAssist(builder.isAssistEnabled);
            setNativePlusEnabled(builder.isNativePlusEnabled);
            setExtraParamsPTC(builder.extraParamsPTC);
            setServer(builder.server);
            if (!TextUtils.isEmpty(builder.serverUrl)) {
                NativeSdkGtmLoader.setServerUrl(builder.serverUrl);
            }
        } else {
            throw new IllegalArgumentException("Invalid txn token");
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public double amount;
        private String appVersion;
        /* access modifiers changed from: private */
        public PaytmSDKCallbackListener callbackListener;
        /* access modifiers changed from: private */
        public Context context;
        private boolean enableLogging;
        /* access modifiers changed from: private */
        public HashMap<String, Object> extraParamsPTC;
        /* access modifiers changed from: private */
        public boolean isAssistEnabled;
        /* access modifiers changed from: private */
        public boolean isNativePlusEnabled;
        private String merchantCallbackUrl;
        /* access modifiers changed from: private */
        public String mid;
        /* access modifiers changed from: private */
        public String orderId;
        /* access modifiers changed from: private */
        public Server server = Server.PRODUCTION;
        /* access modifiers changed from: private */
        public String serverUrl;
        /* access modifiers changed from: private */
        public String txnToken;
        /* access modifiers changed from: private */
        public String verticalName;

        public Builder(Context context2, String str, String str2, String str3, double d2, PaytmSDKCallbackListener paytmSDKCallbackListener) {
            this.context = context2;
            this.mid = str;
            this.orderId = str2;
            this.txnToken = str3;
            this.amount = d2;
            this.callbackListener = paytmSDKCallbackListener;
        }

        public PaytmSDK build() {
            return new PaytmSDK(this);
        }

        public void setAssistEnabled(boolean z) {
            this.isAssistEnabled = z;
        }

        public void setNativePlusEnabled(boolean z) {
            this.isNativePlusEnabled = z;
        }

        public void setVerticalName(String str) {
            this.verticalName = str;
        }

        public void setServer(Server server2) {
            this.server = server2;
        }

        public void setCustomEndPoint(String str) {
            this.serverUrl = str;
        }

        public void setLoggingEnabled(boolean z) {
            this.enableLogging = z;
        }

        public void setAppVersion(String str) {
            this.appVersion = str;
        }

        public void setMerchantCallbackUrl(String str) {
            this.merchantCallbackUrl = str;
        }

        public void setExtraParamsPTC(HashMap<String, Object> hashMap) {
            this.extraParamsPTC = hashMap;
        }
    }

    public final void setNativePlusEnabled(boolean z) {
        DirectPaymentBL.getInstance().setNativePlusEnabled(z);
    }

    private void setExtraParamsPTC(HashMap<String, Object> hashMap) {
        DirectPaymentBL.getInstance().setExtraParamsPTC(hashMap);
    }

    public final void setEnablePaytmAssist(boolean z) {
        MerchantBL.getMerchantInstance().setPaytmAssistEnabled(z);
    }

    public final void startTransaction(Context context, PaymentRequestModel paymentRequestModel) {
        PaymentUtility.INSTANCE.startTransaction(context, paymentRequestModel);
    }

    public final PaymentDataSource getPaymentDataLayer() {
        return PaymentsDataImpl.INSTANCE;
    }

    public final void setUpiMpin(Context context, UpiDataRequestModel upiDataRequestModel) {
        PaymentUtility.INSTANCE.setUpiPin(context, upiDataRequestModel);
    }

    public final void fetchUpiBalance(Context context, UpiDataRequestModel upiDataRequestModel) {
        PaymentUtility.INSTANCE.fetchUpiBalance(context, upiDataRequestModel);
    }

    @Deprecated
    public PaytmSDK(boolean z, Context context, String str, PaytmSDKCallbackListener paytmSDKCallbackListener, double d2, String str2, String str3, String str4, int i2, Server server2) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (TextUtils.isEmpty(str) || !SDKUtility.isValidJSON(str)) {
            throw new IllegalArgumentException("Invalid Transaction response: \n".concat(String.valueOf(str)));
        } else {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("body");
                if (optJSONObject == null || !optJSONObject.has("txnToken") || TextUtils.isEmpty(optJSONObject.getString("txnToken"))) {
                    throw new IllegalArgumentException("Invalid Transaction response: \n".concat(String.valueOf(str)));
                } else if (paytmSDKCallbackListener == null) {
                    throw new IllegalArgumentException("Callback listener cannot be null");
                } else if (TextUtils.isEmpty(str2)) {
                    throw new IllegalArgumentException("Invalid Mid");
                } else if (TextUtils.isEmpty(str3)) {
                    throw new IllegalArgumentException("Invalid orderId");
                } else if (TextUtils.isEmpty(str4)) {
                    throw new IllegalArgumentException("Invalid merchant name");
                } else if (server2 != null) {
                    this.mActivityContext = new WeakReference<>(context);
                    this.mTransactionJson = str;
                    mPaytmSDKCallbackListener = paytmSDKCallbackListener;
                    this.mAmount = d2;
                    this.server = server2;
                    this.mid = str2;
                    if (!TextUtils.isEmpty(this.mid) && this.mid.equalsIgnoreCase(SDKConstants.NATIVESDK_ADD_MONEY_MERCHANT_ID)) {
                        DirectPaymentBL.getInstance().setAddMoney(true);
                    }
                    DirectPaymentBL.getInstance().setToCreateOrderPaytmSdk(false);
                    this.orderId = str3;
                    this.merchantName = str4;
                    this.merchantLogo = i2;
                    NativeSdkGtmLoader.setServerUrl(server2);
                    MerchantBL.getMerchantInstance().setAppInvoke(z);
                    NativeSDKRepository.init(context, false);
                    DirectPaymentBL.getInstance().generateRequestId();
                } else {
                    throw new IllegalArgumentException("Invalid Server arguement");
                }
            } catch (JSONException unused) {
                throw new IllegalArgumentException("Invalid Transaction response: \n".concat(String.valueOf(str)));
            }
        }
    }

    @Deprecated
    public PaytmSDK(boolean z, Context context, String str, PaytmSDKCallbackListener paytmSDKCallbackListener, double d2, String str2, String str3, String str4, String str5, int i2, Server server2) {
        this(z, context, str, paytmSDKCallbackListener, d2, str2, str3, str4, i2, server2);
        if (!TextUtils.isEmpty(str5)) {
            DirectPaymentBL.getInstance().setVerticalName(str5);
        }
    }

    public PaytmSDK(Context context, double d2, String str, String str2, PaytmSDKCallbackListener paytmSDKCallbackListener) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid Mid");
        } else if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Invalid sso token");
        } else if (paytmSDKCallbackListener != null) {
            this.mActivityContext = new WeakReference<>(context);
            mPaytmSDKCallbackListener = paytmSDKCallbackListener;
            this.mAmount = d2;
            this.server = Server.PRODUCTION;
            this.ssoToken = str2;
            this.mid = str;
            if (!TextUtils.isEmpty(this.mid) && this.mid.equalsIgnoreCase(SDKConstants.NATIVESDK_ADD_MONEY_MERCHANT_ID)) {
                DirectPaymentBL.getInstance().setAddMoney(true);
            }
            DirectPaymentBL.getInstance().setToCreateOrderPaytmSdk(true);
            NativeSDKRepository.init(context, true);
            this.merchantName = "";
            this.merchantLogo = 0;
            NativeSdkGtmLoader.setServerUrl(Server.PRODUCTION);
            DirectPaymentBL.getInstance().generateRequestId();
            MerchantBL.getMerchantInstance().setSsoToken(str2);
            MerchantBL.getMerchantInstance().setAuthenticated(true);
        } else {
            throw new IllegalArgumentException("Callback listener cannot be null");
        }
    }

    public PaytmSDK(Context context, double d2, String str, String str2, String str3, PaytmSDKCallbackListener paytmSDKCallbackListener) {
        this(context, d2, str, str2, paytmSDKCallbackListener);
        if (!TextUtils.isEmpty(str3)) {
            DirectPaymentBL.getInstance().setVerticalName(str3);
        }
    }

    public static void setSDKCallbackListener(PaytmSDKCallbackListener paytmSDKCallbackListener) {
        mPaytmSDKCallbackListener = paytmSDKCallbackListener;
    }

    public final void setIsAppInvoke(boolean z) {
        MerchantBL.getMerchantInstance().setAppInvoke(z);
    }

    public final void setMWebAppInvoke(boolean z) {
        MerchantBL.getMerchantInstance().setMWebAppInvoke(z);
    }

    public static void parseAndSetInstruments(String str) {
        try {
            setResponse((CJPayMethodResponse) new f().a(str, CJPayMethodResponse.class), (VpaFetch) null);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public static CJPayMethodResponse parsePaymentInstrument(String str) {
        return (CJPayMethodResponse) new f().a(str, CJPayMethodResponse.class);
    }

    public static boolean isSubsDetailAvailable() {
        CJPayMethodResponse cjPayMethodResponse = DirectPaymentBL.getInstance().getCjPayMethodResponse();
        if (cjPayMethodResponse == null || cjPayMethodResponse.getBody() == null || cjPayMethodResponse.getBody().getSubscriptionDetailsInfo() == null || cjPayMethodResponse.getBody().getSubscriptionDetailsInfo().getDetails() == null) {
            return false;
        }
        Details details = cjPayMethodResponse.getBody().getSubscriptionDetailsInfo().getDetails();
        if (!TextUtils.isEmpty(details.getFrequencyValue()) || !TextUtils.isEmpty(details.getNextPaymentValue())) {
            return true;
        }
        return false;
    }

    public static void setResponse(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
        DirectPaymentBL.getInstance().setResponse(cJPayMethodResponse);
        DirectPaymentBL.getInstance().setFetchPayCallRequired(false);
    }

    public final void enablePushUpi(String str, String str2) throws IllegalArgumentException {
        MerchantBL.getMerchantInstance().setSsoToken(str);
        MerchantBL.getMerchantInstance().setSsoMobileNumber(str2);
        if (getContext() != null) {
            if (!SharedPreferenceUtil.getInstance().getString("SSO_TOKEN", "").equalsIgnoreCase(str) || !SharedPreferenceUtil.getInstance().getString(SDKConstants.SSO_MOBILE, "").equalsIgnoreCase(str2)) {
                SharedPreferenceUtil.getInstance().clearAll();
            }
            SharedPreferenceUtil.getInstance().setString("SSO_TOKEN", str);
            SharedPreferenceUtil.getInstance().setString(SDKConstants.SSO_MOBILE, str2);
            MerchantBL.getMerchantInstance().setPushUpiEnabled(true);
        }
    }

    public final void setBankParams(String str, String str2, String str3, String str4, String str5) {
        if (getContext() != null) {
            MerchantBL.getMerchantInstance().setSsoToken(str5);
            MerchantBL.getMerchantInstance().setSsoMobileNumber(str4);
            if (!SharedPreferenceUtil.getInstance().getString("SSO_TOKEN", "").equalsIgnoreCase(str5) || !SharedPreferenceUtil.getInstance().getString(SDKConstants.SSO_MOBILE, "").equalsIgnoreCase(str4)) {
                SharedPreferenceUtil.getInstance().clearAll();
            }
            SharedPreferenceUtil.getInstance().setString("SSO_TOKEN", str5);
            SharedPreferenceUtil.getInstance().setString(SDKConstants.SSO_MOBILE, str4);
            MerchantBL.getMerchantInstance().setBankParams(str2, str, str3, str4);
        }
    }

    public final void startTransaction() {
        if (!TextUtils.isEmpty(this.mTransactionJson)) {
            parseJSON();
            MerchantBL.getMerchantInstance().setParseData(this.mTransactionJson, this.mAmount, this.orderId, this.mid, this.merchantName);
        } else if (!TextUtils.isEmpty(this.mTransactionToken)) {
            MerchantBL.getMerchantInstance().setParseData(this.mTransactionToken, this.mIsAuthenticated, this.mAmount, this.orderId, this.mid, this.merchantName);
        } else {
            MerchantBL.getMerchantInstance().setParseData(this.mAmount, this.mid, this.merchantName, this.ssoToken);
        }
        openCashierPage();
    }

    public final void startTransactionOrFlow() {
        if (!TextUtils.isEmpty(this.mTransactionJson)) {
            parseJSON();
            MerchantBL.getMerchantInstance().setParseData(this.mTransactionJson, this.mAmount, this.orderId, this.mid, this.merchantName);
        } else if (!TextUtils.isEmpty(this.mTransactionToken)) {
            MerchantBL.getMerchantInstance().setParseData(this.mTransactionToken, this.mIsAuthenticated, this.mAmount, this.orderId, this.mid, this.merchantName);
        } else {
            MerchantBL.getMerchantInstance().setParseData(this.mAmount, this.mid, this.merchantName, this.ssoToken);
        }
        MerchantBL.getMerchantInstance().setTxnToken((String) null);
        MerchantBL.getMerchantInstance().setOrderId((String) null);
        if (getContext() != null) {
            getContext().startActivity(new Intent(getContext(), BankOfferTransactionActivity.class));
        }
    }

    public final void startTransactionUpiTokenFlow(String str, String str2, String str3, String str4, String str5) {
        PaymentInstrument paymentInstrument;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        DirectPaymentBL.getInstance().setUpiPushCustomSDKFlow(true);
        DirectPaymentBL.getInstance().setCustSdKVersion(str5);
        if (!TextUtils.isEmpty(this.mTransactionToken)) {
            MerchantBL.getMerchantInstance().setParseData(this.mTransactionToken, this.mIsAuthenticated, this.mAmount, this.orderId, this.mid, this.merchantName);
        } else {
            MerchantBL.getMerchantInstance().setParseData(this.mAmount, this.mid, this.merchantName, this.ssoToken);
        }
        UpiProfileDefaultBank upiProfileDefaultBank = (UpiProfileDefaultBank) new f().a(str4, UpiProfileDefaultBank.class);
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), (String) null, PayUtility.getUpiPushRequestParam(str6, str7, str8, SDKUtils.convertPojoToVpa(upiProfileDefaultBank)));
        } else {
            paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(getContext(), NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), PayUtility.getUpiPushRequestParamWebRedirection(str6, str7, str8, SDKUtils.convertPojoToVpa(upiProfileDefaultBank)));
        }
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        new TransactionProcessor(getContext(), "upi_push", paymentInstrument).startTransaction((View) null);
    }

    private void openCashierPage() {
        if (MerchantBL.getMerchantInstance().isAuthenticated() || MerchantBL.getMerchantInstance().isAoaEnabled() || !MerchantBL.getMerchantInstance().isShowLogin()) {
            startInstrumentActivity();
        } else if (getContext() != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(getContext(), PaytmMainActivity.class));
            intent.putExtra("amount", this.mAmount);
            intent.putExtra(SDKConstants.KEY_LOGIN_REQUIRED, this.mIsLoginRequired);
            intent.putExtra(SDKConstants.MERCHANT_LOGO, this.merchantLogo);
            getContext().startActivity(intent);
        }
    }

    private Context getContext() {
        WeakReference<Context> weakReference = this.mActivityContext;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (Context) this.mActivityContext.get();
    }

    private void startInstrumentActivity() {
        if (getContext() != null) {
            Intent intent = new Intent(getContext(), InstrumentActivity.class);
            intent.putExtra(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO, "Paytm Wallet");
            intent.putExtra(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO, "Balance Rs 1200");
            intent.putExtra(SDKConstants.MERCHANT_LOGO, this.merchantLogo);
            getContext().startActivity(intent);
        }
    }

    private void parseJSON() {
        if (getContext() != null) {
            if (!SDKUtility.isValidJSON(this.mTransactionJson)) {
                mPaytmSDKCallbackListener.onTransactionCancel(getContext().getString(R.string.transaction_json_not_valid_message));
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(this.mTransactionJson).optJSONObject("body");
                if (optJSONObject != null) {
                    this.mTransactionToken = optJSONObject.optString("txnToken");
                    this.mIsAuthenticated = optJSONObject.optBoolean("authenticated");
                    this.mIsLoginRequired = optJSONObject.optBoolean("isLoginRequired");
                }
                if (TextUtils.isEmpty(this.mTransactionJson)) {
                    mPaytmSDKCallbackListener.onTransactionCancel(getContext().getString(R.string.transaction_token_null_message));
                }
            } catch (JSONException e2) {
                LogUtility.printStackTrace(e2);
            }
        }
    }

    public final void enableAOA(boolean z) {
        MerchantBL.getMerchantInstance().enableAOA(z);
    }

    public final void setShowLogin(boolean z) {
        MerchantBL.getMerchantInstance().setShowLogin(z);
    }

    public final void setMerchantLogoUrl(String str) {
        MerchantBL.getMerchantInstance().setMerchantLogoUrl(str);
    }

    public final void setIsRetryTransaction(boolean z) {
        MerchantBL.getMerchantInstance().setRetryTransaction(z);
    }

    public final void setRetryErrorMsg(String str) {
        MerchantBL.getMerchantInstance().setRetryErrorMsg(str);
    }

    public final void setMerchantLogo(int i2) {
        this.merchantLogo = this.merchantLogo;
    }

    public final void setTransparentAppInvoke(boolean z) {
        MerchantBL.getMerchantInstance().setTransparentAppInvoke(z);
    }

    public final void setDeviceId(String str) {
        MerchantBL.getMerchantInstance().setDeviceId(str);
    }

    public final void setOrderCreatedListener(OnOrderCreatedListener onOrderCreatedListener) {
        DirectPaymentBL.getInstance().setOrderCreatedListener(onOrderCreatedListener);
    }

    public final void setGTMStringValues(HashMap<String, Object> hashMap) {
        DirectPaymentBL.getInstance().setGTMStringValues(hashMap);
    }

    public final void setRequestClient(PaytmSDKRequestClient paytmSDKRequestClient) {
        if (paytmSDKRequestClient != null) {
            DirectPaymentBL.getInstance().setRequestClient(paytmSDKRequestClient);
            return;
        }
        throw new IllegalStateException("Native sdk Request client can't be null");
    }

    public final PaytmSDKRequestClient getRequestClient(PaytmSDKRequestClient paytmSDKRequestClient) {
        return DirectPaymentBL.getInstance().getRequestClient();
    }

    public final void enablePPBViaUpi(boolean z) {
        DirectPaymentBL.getInstance().setPPBUpiFlag(z);
    }

    public static boolean isShowOrderInfoPopup() {
        return showOrderInfoPopup;
    }

    public static void setShowOrderInfoPopup(boolean z) {
        showOrderInfoPopup = z;
    }

    public final void setOrFlowCallbackListener(OrFlowCallbackListener orFlowCallbackListener) {
        DirectPaymentBL.getInstance().setOrFlowCallbackListener(orFlowCallbackListener);
    }

    public final void setTotalCashBackAmount(double d2) {
        MerchantBL.getMerchantInstance().setTotalCashBackAmount(Double.valueOf(d2));
    }

    public final void setHeaderLabelText(String str) {
        DirectPaymentBL.getInstance().setHeaderLabelText(str);
    }

    public final void setDeferredCheckoutCallbackListener(DeferredCheckoutCallbackListener deferredCheckoutCallbackListener) {
        DirectPaymentBL.getInstance().setDeferredCheckoutCallbackListener(deferredCheckoutCallbackListener);
    }

    public final void setCustomerId(String str) {
        DirectPaymentBL.getInstance().setCustomerId(str);
    }

    public final void setPriorityEnabledForOnUs(boolean z) {
        MerchantBL.getMerchantInstance().setPriorityEnableForOnUS(z);
    }

    public final void setPriorityEnableForAppInvokeFull(boolean z) {
        MerchantBL.getMerchantInstance().setPriorityEnableForAppInvokeFull(z);
    }

    public final void setSubventionProvider(ISubventionProvider iSubventionProvider) throws IllegalStateException {
        if (iSubventionProvider != null) {
            DirectPaymentBL.getInstance().setSubventionProvider(iSubventionProvider);
            return;
        }
        throw new IllegalStateException("subventionProvider cant be null");
    }

    public final void setVisaOneClickEnabled(boolean z) {
        DirectPaymentBL.getInstance().setVisaOneClickEnabledGTM(z);
    }

    public static String getTransId() {
        return mUPITransId;
    }

    public static void setTransId(String str) {
        mUPITransId = str;
    }

    public static void setCashierRequestId(String str) {
        mCashierRequestId = str;
    }

    public static String getCashierRequestId() {
        return mCashierRequestId;
    }

    public static PaymentDataSource getPaymentsHelper() {
        return PaymentsDataImpl.INSTANCE;
    }

    public final void registerOneClickTranscationListener(OneClickTransactionInfo oneClickTransactionInfo) {
        DirectPaymentBL.getInstance().setOneClickTranscationListener(oneClickTransactionInfo);
    }

    public final void setIsFromAllInOneSDK(boolean z) {
        MerchantBL.getMerchantInstance().setIsFromAllInOneSDK(z);
    }
}
