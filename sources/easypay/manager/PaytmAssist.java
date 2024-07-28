package easypay.manager;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import easypay.listeners.AppCallbacks;
import easypay.listeners.AssistBuilderCallBack;
import easypay.listeners.WebClientListener;
import easypay.utils.b;
import java.util.ArrayList;
import java.util.Map;

public class PaytmAssist {
    private static AssistMerchantDetails merchantDetails;

    public static void startAssist() {
        AssistMerchantDetails assistMerchantDetails = merchantDetails;
        if (assistMerchantDetails != null) {
            assistMerchantDetails.accessCheckApi();
        }
    }

    public static void removeAssist() {
        AssistMerchantDetails.getInstance().clearInstance();
        if (merchantDetails != null) {
            merchantDetails = null;
        }
    }

    public static void setSmsListener(AppCallbacks appCallbacks) {
        AssistMerchantDetails assistMerchantDetails = merchantDetails;
        if (assistMerchantDetails != null) {
            assistMerchantDetails.setListener(appCallbacks);
        }
    }

    public static void addWebClientListeners(WebClientListener webClientListener) {
        AssistMerchantDetails assistMerchantDetails = merchantDetails;
        if (assistMerchantDetails != null) {
            assistMerchantDetails.getWebClientInstance().addAssistWebClientListener(webClientListener);
        }
    }

    public static void removeWebClientListeners(WebClientListener webClientListener) {
        AssistMerchantDetails assistMerchantDetails = merchantDetails;
        if (assistMerchantDetails != null) {
            assistMerchantDetails.getWebClientInstance().removeAssistWebClientListener(webClientListener);
        }
    }

    public static void setBankInfo(String str, String str2, String str3) {
        AssistMerchantDetails assistMerchantDetails = merchantDetails;
        if (assistMerchantDetails != null) {
            assistMerchantDetails.setBankInfo(str, str2, str3);
        }
    }

    public static EasypayWebViewClient getWebViewClientInstance() {
        AssistMerchantDetails assistMerchantDetails = merchantDetails;
        if (assistMerchantDetails != null) {
            return assistMerchantDetails.getWebClientInstance();
        }
        return null;
    }

    public static Map<String, ArrayList<String>> fetchNBUserIds(Context context) {
        return b.d(context);
    }

    public static int deleteNbUserId(Context context, String str, String str2) {
        return b.a(context, str, str2);
    }

    public static int saveUserId(Context context, String str, String str2) {
        return b.b(context, str2, str);
    }

    private PaytmAssist(Builder builder) {
        merchantDetails = AssistMerchantDetails.getInstance();
        if (builder.context == null) {
            if (builder.callBackListener != null) {
                builder.callBackListener.onBuilderStartFailure("Context cannot be null", new IllegalArgumentException("Context cannot be null"));
            }
            throw new IllegalArgumentException("Context cannot be null");
        }
        if (builder.mid == null || TextUtils.isEmpty(builder.mid)) {
            if (builder.callBackListener != null) {
                builder.callBackListener.onBuilderStartFailure("Merchant ID cannot be null or empty.", new IllegalArgumentException("Merchant ID cannot be null or empty."));
            }
            builder.setAssistEnabled(false);
        }
        merchantDetails.setMid(builder.mid);
        merchantDetails.setOrderId(builder.orderId);
        merchantDetails.setContext(builder.context);
        merchantDetails.setWebView(builder.webView);
        merchantDetails.setFragmentViewId(builder.viewId);
        merchantDetails.setmWcListListener(new ArrayList());
        merchantDetails.setEasyPayHelper();
        merchantDetails.setWebClientInstance(builder.context);
        merchantDetails.setEasyPayEnabled(builder.isAssistEnabled);
        AssistMerchantDetails assistMerchantDetails = merchantDetails;
        StringBuilder sb = new StringBuilder();
        sb.append(builder.isAssistEnabled);
        assistMerchantDetails.setEventInEventMap(Constants.EVENTS_IS_ASSIST_ENABLE, sb.toString());
        AssistMerchantDetails assistMerchantDetails2 = merchantDetails;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(builder.isNativeEnabled);
        assistMerchantDetails2.setEventInEventMap(Constants.EVENTS_IS_NATIVE_OTP_ENABLED, sb2.toString());
        merchantDetails.setServer("PRODUCTION");
        merchantDetails.setEnableLogging(builder.enableLogging);
        merchantDetails.setNativeOtpEnabled(builder.isNativeEnabled);
        merchantDetails.setExtraInfoForEvents();
        merchantDetails.setUserId(builder.userId);
        merchantDetails.setTransactionId(builder.transactionId);
        merchantDetails.setRiskEventLinkId(builder.riskEventLinkId);
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public AssistBuilderCallBack callBackListener;
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public boolean enableLogging = false;
        /* access modifiers changed from: private */
        public boolean isAssistEnabled = true;
        /* access modifiers changed from: private */
        public boolean isNativeEnabled = false;
        /* access modifiers changed from: private */
        public String mid;
        /* access modifiers changed from: private */
        public String orderId;
        /* access modifiers changed from: private */
        public String riskEventLinkId;
        private String server = "PRODUCTION";
        /* access modifiers changed from: private */
        public String transactionId;
        /* access modifiers changed from: private */
        public String userId;
        /* access modifiers changed from: private */
        public Integer viewId;
        /* access modifiers changed from: private */
        public WebView webView;

        public Builder(Context context2, String str, String str2) {
            this.context = context2;
            this.mid = str;
            this.orderId = str2;
        }

        public PaytmAssist build() {
            return new PaytmAssist(this);
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public void setContext(Context context2) {
            this.context = context2;
        }

        public void setAssistEnabled(boolean z) {
            this.isAssistEnabled = z;
        }

        public void setNativeEnabled(boolean z) {
            this.isNativeEnabled = z;
        }

        public void setServer(String str) {
            this.server = str;
        }

        public void setEnableLogging(boolean z) {
            this.enableLogging = z;
        }

        public void setViewId(Integer num) {
            this.viewId = num;
        }

        public void setWebView(WebView webView2) {
            this.webView = webView2;
        }

        public void setCallBackListener(AssistBuilderCallBack assistBuilderCallBack) {
            this.callBackListener = assistBuilderCallBack;
        }

        public void setUserId(String str) {
            this.userId = str;
        }

        public void setRiskEventLinkId(String str) {
            this.riskEventLinkId = str;
        }

        public void setTransactionId(String str) {
            this.transactionId = str;
        }
    }
}
