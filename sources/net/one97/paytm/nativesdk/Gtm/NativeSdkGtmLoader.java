package net.one97.paytm.nativesdk.Gtm;

import android.text.TextUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.payments.visascp.VisaSDK;

public class NativeSdkGtmLoader {
    private static String GTM_CONTAINER1 = "container1";
    private static String GTM_CONTAINER2 = "container2";
    public static String MPASS_API_URL = "https://mas-log.paas.paytm.com/loggw/dwcookieLogGet.do";
    private static String TAG = NativeSdkGtmLoader.class.getSimpleName();
    private static String authUrl;
    private static String dev_pg_url = "https://dev2.paytm.in/theia";
    private static String miniAppAuthUAT = "https://accounts-uat.paytm.com";
    private static String miniAppStage = "https://securegw-stage.paytm.in/theia";
    private static String pre_prod_url = "https://securegw-preprod.paytm.in/theia";
    private static String prodUpi = "https://upisecure.paytmbank.com/Paytm_UPI/upi";
    private static String prodUpiNew = "https://upipms.paytmbank.com";
    private static String prod_url = "https://securegw.paytm.in/theia";
    private static String prod_url_auth = "https://accounts.paytm.com";
    private static final NativeSdkGtmLoader sInstance = new NativeSdkGtmLoader();
    private static String serverUrl;
    private static String staging = "https://pgp-staging.paytm.in/theia";
    private static String stagingAuth = "https://accounts-staging.paytm.in";
    private static String stagingUpi = "https://upisecure-staging.paytmbank.com";
    private static String stagingUpiNew = "https://upipms-staging1.paytmbank.com";
    private static String upiUrl;
    private static String upiUrlNew;

    public static String getCloseOrderUrl() {
        return "https://cart.paytm.com/v1/myorders/order/cancel";
    }

    public static String getIFSC() {
        return "https://trust.paytm.in/wallet-web/wrapper/getList";
    }

    public static String getUpiAvailabilityUrl() {
        return "";
    }

    public static void setServerUrl(Server server) {
        if (server == Server.STAGING || server == Server.MINI_APP_STAGING) {
            VisaSDK.setServer(net.one97.paytm.payments.visascp.Server.STAGING);
        }
        int i2 = AnonymousClass1.$SwitchMap$net$one97$paytm$nativesdk$Utils$Server[server.ordinal()];
        if (i2 == 1) {
            serverUrl = staging;
            authUrl = stagingAuth;
            upiUrl = stagingUpi;
            upiUrlNew = stagingUpiNew;
        } else if (i2 == 2) {
            serverUrl = prod_url;
            authUrl = prod_url_auth;
            upiUrl = prodUpi;
            upiUrlNew = prodUpiNew;
        } else if (i2 == 3) {
            serverUrl = miniAppStage;
            authUrl = miniAppAuthUAT;
            upiUrl = stagingUpi;
            upiUrlNew = stagingUpiNew;
        } else if (i2 == 4) {
            serverUrl = pre_prod_url;
            authUrl = prod_url_auth;
            upiUrl = prodUpi;
            upiUrlNew = prodUpiNew;
        } else if (i2 == 5) {
            serverUrl = dev_pg_url;
            authUrl = prod_url_auth;
            upiUrl = prodUpi;
            upiUrlNew = prodUpiNew;
        }
    }

    /* renamed from: net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$one97$paytm$nativesdk$Utils$Server = new int[Server.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                net.one97.paytm.nativesdk.Utils.Server[] r0 = net.one97.paytm.nativesdk.Utils.Server.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$one97$paytm$nativesdk$Utils$Server = r0
                int[] r0 = $SwitchMap$net$one97$paytm$nativesdk$Utils$Server     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.nativesdk.Utils.Server r1 = net.one97.paytm.nativesdk.Utils.Server.STAGING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$net$one97$paytm$nativesdk$Utils$Server     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.nativesdk.Utils.Server r1 = net.one97.paytm.nativesdk.Utils.Server.PRODUCTION     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$net$one97$paytm$nativesdk$Utils$Server     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.nativesdk.Utils.Server r1 = net.one97.paytm.nativesdk.Utils.Server.MINI_APP_STAGING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$net$one97$paytm$nativesdk$Utils$Server     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.nativesdk.Utils.Server r1 = net.one97.paytm.nativesdk.Utils.Server.PRE_PROD     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$net$one97$paytm$nativesdk$Utils$Server     // Catch:{ NoSuchFieldError -> 0x0040 }
                net.one97.paytm.nativesdk.Utils.Server r1 = net.one97.paytm.nativesdk.Utils.Server.DEV_PG     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = $SwitchMap$net$one97$paytm$nativesdk$Utils$Server     // Catch:{ NoSuchFieldError -> 0x004b }
                net.one97.paytm.nativesdk.Utils.Server r1 = net.one97.paytm.nativesdk.Utils.Server.CUSTOM_IP     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader.AnonymousClass1.<clinit>():void");
        }
    }

    public static void setServerUrl(String str) {
        serverUrl = "https://" + str + "/theia";
        authUrl = "https://".concat(String.valueOf(str));
    }

    public static String getBaseUrl() {
        return serverUrl;
    }

    private static String getAuthUrl() {
        return authUrl;
    }

    private static String getUpiUrl() {
        return upiUrl;
    }

    private static String getUpiUrlNew() {
        return upiUrlNew;
    }

    public static String getBaseUrl(Server server) {
        setServerUrl(server);
        String str = serverUrl;
        return str == null ? "" : str;
    }

    public static NativeSdkGtmLoader getInstance() {
        return sInstance;
    }

    public static String getOtpUrl(String str, String str2) {
        return getBaseUrl() + "/api/v1/login/sendOtp?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getListKeysUrl() {
        return getUpiUrl() + "/list-keys";
    }

    public static String getTokenUrl() {
        return getUpiUrl() + "/get-token";
    }

    public static String getDeviceBindingUrl() {
        return getUpiUrl() + "/device-binding";
    }

    public static String getValidateOtp(String str, String str2) {
        return getBaseUrl() + "/api/v1/login/validateOtp?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getFetchPay(String str, String str2) {
        return getBaseUrl() + "/api/v2/fetchPaymentOptions?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getFetchPay(String str) {
        return getBaseUrl() + "/api/v2/fetchPaymentOptions?mid=" + str;
    }

    public static String getCardDetails(String str) {
        return getBaseUrl() + "/api/v1/fetchCardDetails?mid=" + str;
    }

    public static String getFetchVpa(String str, String str2) {
        return getBaseUrl() + "/api/v1/fetchVpaDetails?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getMapingRequest(String str, String str2) {
        return getBaseUrl() + "/api/v2/fetchMerchantInfo?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getMapingRequestV1(String str, String str2) {
        return getBaseUrl() + "/api/v1/fetchMerchantInfo?mid=" + str + "&orderId=" + str2;
    }

    public static String getBinDetails(String str, String str2) {
        return getBaseUrl() + "/api/v1/fetchBinDetail?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getBinDetails(String str) {
        return getBaseUrl() + "/api/v1/fetchBinDetail?mid=" + str;
    }

    public static String getPromoCodeApiUrl(String str, String str2) {
        return getBaseUrl() + "/api/v1/fetchPromoCodeDetail?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getPromoCodeApiUrl(String str) {
        return getBaseUrl() + "/api/v1/fetchPromoCodeDetail?mid=" + str;
    }

    public static String getProcessTranscationUrl(String str, String str2) {
        return getBaseUrl() + "/api/v1/processTransaction?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getNBList(String str, String str2) {
        return getBaseUrl() + "/api/v1/fetchNBPaymentChannels?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getNBList(String str) {
        return getBaseUrl() + "/api/v1/fetchNBPaymentChannels?mid=" + str;
    }

    public static String getFetchBalanceUrl(String str, String str2) {
        return getBaseUrl() + "/api/v1/fetchBalanceInfo?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getFetchBalanceUrl(String str) {
        return getBaseUrl() + "/api/v1/fetchBalanceInfo?mid=" + str;
    }

    public static String getEmiDetailsUrl(String str, String str2) {
        return getBaseUrl() + "/api/v1/fetchEMIDetail?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getEmiDetailsUrl(String str) {
        return getBaseUrl() + "/api/v1/fetchEMIDetail?mid=" + str;
    }

    public static String getValidateVPAUrl(String str, String str2) {
        return getBaseUrl() + "/api/v1/vpa/validate?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getValidateVPAUrl(String str) {
        return getBaseUrl() + "/api/v1/vpa/validate?mid=" + str;
    }

    public static String getUpiDeeplink(String str, String str2) {
        return getBaseUrl() + "/v1/createUPILink?mid=" + str + "&orderId=" + str2 + "&ORDER_ID=" + str2;
    }

    public static String getApplyPromoUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return getBaseUrl() + "/api/v1/applyPromo?mid=" + str + "&orderId=" + str2;
        }
        return getBaseUrl() + "/api/v1/applyPromo?mid=" + str;
    }

    public static String getUpiTransactionStatus() {
        return getBaseUrl() + "/transactionStatus";
    }

    public static String getUpiTransactionStatus(String str, String str2, String str3) {
        return getBaseUrl() + "/v1/transactionStatus?mid=" + str + "&orderId=" + str2 + "&transId=" + str3;
    }

    public static String getToken() {
        return getAuthUrl() + "/oauth2/token";
    }

    public static String getFetchCardDetailsUrl(String str) {
        return getBaseUrl() + "/api/v1/fetchCardDetails?mid=" + str;
    }

    public static String postCheckStatus(String str) {
        String replace = getBaseUrl().replace("/theia", "");
        return replace + "/subscription/subscription/checkStatus";
    }

    public static String postSendOtp(String str, String str2) {
        if (getBaseUrl().contains("securegw.paytm.in")) {
            return "https://securegw.paytm.in/login/sendOtp?mid=" + str + "&orderId=" + str2;
        }
        return getBaseUrl() + "/api/v1/login/sendOtp?mid=" + str + "&orderId=" + str2;
    }

    public static String postValidateOtp(String str, String str2) {
        if (getBaseUrl().contains("securegw.paytm.in")) {
            return "https://securegw.paytm.in/login/validateOtp?mid=" + str + "&orderId=" + str2;
        }
        return getBaseUrl() + "/api/v1/login/validateOtp?mid=" + str + "&orderId=" + str2;
    }

    public static String getUpiConsentApi() {
        return getUpiUrlNew() + "/upi/ext/meta/app/v1/user/consent";
    }

    public static String getTransactionStatus() {
        return getBaseUrl() + "/v1/transactionStatus";
    }

    public static String getFallBackMerchantLogoUrl() {
        return GTMLoader.getString(SDKConstants.FALLBACK_MERCHANT_LOGO);
    }

    public static String getPcfDetails(String str, String str2) {
        return getBaseUrl() + "/api/v1/fetchPcfDetails?mid=" + str + "&orderId=" + str2;
    }
}
