package net.one97.paytm.nativesdk;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.fetchMerchantInfo.MerchantInfoResp;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import org.json.JSONException;
import org.json.JSONObject;

public class MerchantBL {
    private static MerchantBL _instance;
    private String RSAkey;
    private String amount;
    private String appInvokePromoCode;
    private String authentication;
    private String callbackUrl;
    private String clientId;
    private String deviceId;
    private boolean isAoaEnabled = false;
    private boolean isAppInvoke;
    private boolean isAppInvokeTransparent;
    private boolean isAuthenticated;
    private boolean isFromAllInOneSDK = false;
    private boolean isPaytmAssistEnabled = false;
    private boolean isPriorityEnableForAppInvokeFull;
    private boolean isPriorityEnableForOnUS;
    private boolean isRetryTransaction = false;
    private boolean isValidatePromo;
    private boolean isWalletOtpFlow = true;
    public boolean isZeroSubscriptionFlow = false;
    private boolean mIsLoginRequired;
    private boolean mWebAppInvoke;
    private MerchantInfoResp merchantInfoResp;
    private int merchantLogo;
    private String merchantLogoUrl = "";
    private String merchantName;
    private String mid;
    private String mobileNumber;
    private String orderId;
    private double originalAmount;
    private boolean pushUpiEnabled;
    private String retryErrorMsg = "";
    private boolean showLogin = true;
    private String ssoMobileNumber;
    private String ssoToken;
    private String subscriptionId;
    private String token;
    private Double totalCashBackAmount = Double.valueOf(0.0d);
    private VpaFetch vpaFetch;

    public void setSsoToken(String str) {
        this.ssoToken = str;
    }

    public static MerchantBL getMerchantInstance() {
        if (_instance == null) {
            _instance = new MerchantBL();
        }
        return _instance;
    }

    public void setBankParams(String str, String str2, String str3, String str4) {
        this.authentication = str;
        this.RSAkey = str2;
        this.clientId = str3;
        this.mobileNumber = str4;
    }

    public void setParseData(String str, double d2, String str2, String str3, String str4) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("body");
            if (optJSONObject != null) {
                this.token = optJSONObject.optString("txnToken");
                this.isAuthenticated = optJSONObject.optBoolean("authenticated");
                this.mIsLoginRequired = optJSONObject.optBoolean("isLoginRequired");
                this.orderId = str2;
            }
            this.mid = str3;
            this.merchantName = str4;
            this.originalAmount = d2;
            checkForZeroAmountTransaction(d2);
            this.amount = SDKUtility.getDoubleFormaAmount(this.originalAmount);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    private void checkForZeroAmountTransaction(double d2) {
        if (Math.floor(d2) == 0.0d) {
            this.originalAmount = 1.0d;
            this.isZeroSubscriptionFlow = true;
        }
    }

    public void setParseData(double d2, String str, String str2, String str3) {
        this.mid = str;
        this.merchantName = str2;
        this.originalAmount = d2;
        this.amount = SDKUtility.getDoubleFormaAmount(d2);
        checkForZeroAmountTransaction(d2);
        this.ssoToken = str3;
    }

    public void setParseData(String str, boolean z, double d2, String str2, String str3, String str4) {
        this.token = str;
        this.isAuthenticated = z;
        this.orderId = str2;
        this.mid = str3;
        this.merchantName = str4;
        this.originalAmount = d2;
        checkForZeroAmountTransaction(d2);
        this.amount = SDKUtility.getDoubleFormaAmount(this.originalAmount);
    }

    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    public String getToken() {
        return this.token;
    }

    public String getAmount() {
        try {
            return getWithoutDoubleAmount(Double.valueOf(this.amount).doubleValue());
        } catch (Exception unused) {
            return "0.0";
        }
    }

    public void setAmount(Double d2) {
        this.originalAmount = d2.doubleValue();
        checkForZeroAmountTransaction(d2.doubleValue());
        this.amount = SDKUtility.getDoubleFormaAmount(this.originalAmount);
    }

    public String getWithoutDoubleAmount() {
        double d2 = this.originalAmount;
        try {
            if (this.isZeroSubscriptionFlow) {
                d2 = 0.0d;
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.US));
            decimalFormat.setDecimalSeparatorAlwaysShown(false);
            return decimalFormat.format(d2).replace(AppConstants.COMMA, "");
        } catch (Exception unused) {
            return String.valueOf(d2);
        }
    }

    public String getWithoutDoubleAmount(double d2) {
        DecimalFormat decimalFormat;
        if (d2 == 0.0d) {
            return "0";
        }
        try {
            if (d2 == Math.floor(d2)) {
                if (!Double.isInfinite(d2)) {
                    decimalFormat = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US));
                    decimalFormat.setDecimalSeparatorAlwaysShown(false);
                    return decimalFormat.format(d2).replace(AppConstants.COMMA, "");
                }
            }
            decimalFormat = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US));
            decimalFormat.setDecimalSeparatorAlwaysShown(false);
            return decimalFormat.format(d2).replace(AppConstants.COMMA, "");
        } catch (Exception unused) {
            return String.valueOf(d2);
        }
    }

    public boolean ismIsLoginRequired() {
        return this.mIsLoginRequired;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getSsoToken() {
        return this.ssoToken;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getRSAkey() {
        return this.RSAkey;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getAuthentication() {
        return this.authentication;
    }

    public void setAuthenticated(boolean z) {
        this.isAuthenticated = z;
    }

    public int getMerchantLogo() {
        return this.merchantLogo;
    }

    public void setMerchantLogo(int i2) {
        this.merchantLogo = i2;
    }

    public VpaFetch getVpaFetch() {
        return this.vpaFetch;
    }

    public void setVpaFetch(VpaFetch vpaFetch2) {
        this.vpaFetch = vpaFetch2;
    }

    public String getSsoMobileNumber() {
        return this.ssoMobileNumber;
    }

    public void setSsoMobileNumber(String str) {
        this.ssoMobileNumber = str;
    }

    public boolean isPushUpiEnabled() {
        return this.pushUpiEnabled;
    }

    public void setPushUpiEnabled(boolean z) {
        this.pushUpiEnabled = z;
    }

    public void clearInstance() {
        this.vpaFetch = null;
        this.authentication = null;
        this.RSAkey = null;
        this.clientId = null;
        this.mobileNumber = null;
        _instance = null;
    }

    public boolean isAppInvoke() {
        return this.isAppInvoke;
    }

    public void setAppInvoke(boolean z) {
        this.isAppInvoke = z;
    }

    public void setMWebAppInvoke(boolean z) {
        this.mWebAppInvoke = z;
    }

    public void setTransparentAppInvoke(boolean z) {
        this.isAppInvokeTransparent = z;
    }

    public boolean isTransparentAppInvoke() {
        return this.isAppInvokeTransparent;
    }

    public boolean isPaytmAssistEnabled() {
        return this.isPaytmAssistEnabled;
    }

    public void setPaytmAssistEnabled(boolean z) {
        this.isPaytmAssistEnabled = z;
    }

    public void enableAOA(boolean z) {
        this.isAoaEnabled = z;
    }

    public boolean isAoaEnabled() {
        return this.isAoaEnabled;
    }

    public void setMerchantLogoUrl(String str) {
        this.merchantLogoUrl = str;
    }

    public String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    public boolean isShowLogin() {
        return this.showLogin;
    }

    public void setShowLogin(boolean z) {
        this.showLogin = z;
    }

    public void setRetryErrorMsg(String str) {
        this.retryErrorMsg = str;
    }

    public void setRetryTransaction(boolean z) {
        this.isRetryTransaction = z;
    }

    public boolean isRetryTransaction() {
        return this.isRetryTransaction;
    }

    public String getRetryErrorMsg() {
        return this.retryErrorMsg;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setTxnToken(String str) {
        this.token = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public Double getTotalCashBackAmount() {
        return this.totalCashBackAmount;
    }

    public void setTotalCashBackAmount(Double d2) {
        this.totalCashBackAmount = d2;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public boolean isWalletOtpFlow() {
        return this.isWalletOtpFlow;
    }

    public void setWalletOtpFlow(boolean z) {
        this.isWalletOtpFlow = z;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public MerchantInfoResp getMerchantInfoResp() {
        return this.merchantInfoResp;
    }

    public void setMerchantInfoResp(MerchantInfoResp merchantInfoResp2) {
        this.merchantInfoResp = merchantInfoResp2;
    }

    public boolean ismWebAppInvoke() {
        return this.mWebAppInvoke;
    }

    public boolean isPriorityEnableForOnUS() {
        return this.isPriorityEnableForOnUS;
    }

    public void setPriorityEnableForOnUS(boolean z) {
        this.isPriorityEnableForOnUS = z;
    }

    public boolean isPriorityEnableForAppInvokeFull() {
        return this.isPriorityEnableForAppInvokeFull;
    }

    public void setPriorityEnableForAppInvokeFull(boolean z) {
        this.isPriorityEnableForAppInvokeFull = z;
    }

    public boolean isValidatePromo() {
        return this.isValidatePromo;
    }

    public void setValidatePromo(boolean z) {
        this.isValidatePromo = z;
    }

    public String getAppInvokePromoCode() {
        String str = this.appInvokePromoCode;
        return str == null ? "" : str;
    }

    public void setAppInvokePromoCode(String str) {
        this.appInvokePromoCode = str;
    }

    public void setIsFromAllInOneSDK(boolean z) {
        this.isFromAllInOneSDK = z;
    }

    public boolean isFromAllInOneSDK() {
        return this.isFromAllInOneSDK;
    }
}
