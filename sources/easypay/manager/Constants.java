package easypay.manager;

import okhttp3.MediaType;

public class Constants {
    public static final int ACTION_DELAY_PASSWORD_FOUND = 156;
    public static final int ACTION_DISABLE_AUTO_SUBMIT = 300;
    public static final int ACTION_INCORRECT_OTP = 158;
    public static final int ACTION_NB_NEXT_BTN_CLICKED = 159;
    public static final int ACTION_NB_PREVIOUS_BTN_CLICKED = 160;
    static final int ACTION_NB_REMOVE_LOADER = 164;
    static final int ACTION_NB_RESEND_CLICKED = 163;
    public static final int ACTION_NB_WV_LOGIN_CLICKED = 161;
    public static final int ACTION_PASSWORD_FOUND = 154;
    public static final int ACTION_PASSWORD_VIEWER = 151;
    public static final int ACTION_READ_OTP_VIA_WEB = 201;
    public static final int ACTION_REMOVE_NB_LAYOUT = 153;
    public static final int ACTION_SAVE_CUST_ID = 157;
    public static final int ACTION_START_NB_OTP = 155;
    public static final int ACTION_SUBMIT_CLICKED = 106;
    public static final int ACTION_SUCCESS_USERID_ONLY_SCRIPTS = 100;
    static final int ACTION_SUCCESS_USERID_PWD_SCRIPT = 101;
    public static final int ACTION_UID_VIEWER = 152;
    static final int ACTION_WEB_OPTIMIZATION_EXECUTED = 165;
    public static final String ASSIST_LOG_CONSTANT = "AssistLogs";
    public static final String AUTHORIZATION = "Authorization";
    public static final String AUTOFILL_USERID = "AUTOFILL_USERID";
    static final String Assist_Invoke_Exception_Message = "PaytmAssist Not Configured! Did you Missed StartConfigAssist";
    public static final String BANKPREF = "bankpref";
    public static final String DEFAULT_BANK = "Bank";
    static final String EASYPAY_JS_INTERFACE = "EasyPay";
    public static final String EASYPAY_NEW_PREFERENCE_FILE = "com.paytm.com.paytm.pgsdk.easypay.NEW_PREFERENCE_FILE_KEY";
    public static final String EASYPAY_PAYTYPE_CREDIT_CARD = "CC";
    public static final String EASYPAY_PAYTYPE_DEBIT_CARD = "DC";
    public static final String EASYPAY_PAYTYPE_NETBANKING = "NB";
    public static final String EASY_PAY_CONFIG_BANK_LIST_KEY = "configList";
    public static final String EASY_PAY_CONFIG_PREF_KEY = "config";
    public static final int EASY_PAY_DEFAULT_COUNTDOWN_TIMER = 8;
    public static final String EASY_PAY_ETAG_PREF = "newETAGPreference";
    public static final int EASY_PAY_GENERIC_CALLBACK = 225;
    public static final int EASY_PAY_INVISIBLE_ASSIST = 224;
    public static final int EASY_PAY_MAXIMIZE_ASSIST = 222;
    public static final int EASY_PAY_MINIMIZE_ASSIST = 221;
    public static final int EASY_PAY_PREF_LIST_SIZE = 5;
    public static final int EASY_PAY_VISIBLE_ASSIST = 223;
    public static final int ERROR_OCCURRED_OTP = 109;
    public static final String EVENTS_ACS_URL = "acsUrl";
    public static final String EVENTS_ACS_URL_LOADED = "acsUrlLoaded";
    public static final String EVENTS_ACS_URL_REQUESTED = "acsUrlRequested";
    public static final String EVENTS_API_ERROR_RECEIVED = "apiErrorReceived";
    public static final String EVENTS_AUTO_SUBMIT_TIMER = "autoSubmitTimer";
    public static final String EVENTS_BACK_PRESS_CLICKED = "backPressClicked";
    public static final String EVENTS_CALLBACK_FUNCTION = "callBackFunction";
    public static final String EVENTS_CARD_ISSUER = "cardIssuer";
    public static final String EVENTS_CARD_TRANSACTION = "isCardTransaction";
    public static final String EVENTS_CARD_TYPE = "cardType";
    public static final String EVENTS_EXTENDED_INFO = "extendedInfo";
    public static final String EVENTS_IS_ASSIST_ENABLE = "isAssistEnable";
    public static final String EVENTS_IS_ASSIST_MINIMIZED = "isAssistMinimized";
    public static final String EVENTS_IS_ASSIST_MINIMIZED_USER = "isAssistMinimizedByUser";
    public static final String EVENTS_IS_ASSIST_POPPED = "isAssistPopped";
    public static final String EVENTS_IS_AUTOFILL_SUCCESS = "isAutoFillSuccess";
    public static final String EVENTS_IS_AUTOFILL_USER_ID_SUCCESS = "isAutoFillUserIdSuccess";
    public static final String EVENTS_IS_AUTO_SUBMIT_ASSIST_EVENTS = "isAutoSubmitAssistEvent";
    public static final String EVENTS_IS_BACK_CLICKED_ON_ACS_PAGE = "isBackClickedOnAcsPage";
    public static final String EVENTS_IS_BANK_ENABLED = "isBankEnabled";
    public static final String EVENTS_IS_NATIVE_OTP_ENABLED = "isNativeOtpEnabled";
    public static final String EVENTS_IS_NB_SUBMIT_CLICKED = "isNbSubmitButtonClicked";
    public static final String EVENTS_IS_NET_BANKING = "isNetbanking";
    public static final String EVENTS_IS_PAUSE_BUTTON_TAPPED = "isPauseButtonTapped";
    public static final String EVENTS_IS_REMEMBER_USER_ID_CHECKED = "isRememberUserIdChecked";
    public static final String EVENTS_IS_SHOW_PASSWORD_CLICKED = "isShowPasswordClicked";
    public static final String EVENTS_IS_SMS_PERMISSION = "smsPermission";
    public static final String EVENTS_IS_SMS_READ = "isSmsRead";
    public static final String EVENTS_IS_SUBMITTED = "isSubmitted";
    public static final String EVENTS_IS_SUBMIT_BUTTON_CLICKED_MANUALLY = "isSubmitButtonClickedManually";
    public static final String EVENTS_IS_WRAPPER_PAGER = "isWrapperPage";
    public static final String EVENTS_NB_PAGE_URL = "NBPageUrl";
    public static final String EVENTS_NEW_EVENTS_LOG = "newEventsLog";
    public static final String EVENTS_NON_OTP_REQUEST = "NonOTPRequest";
    public static final String EVENTS_OTP_MANUALLY_REQUESTED = "OTPManuallyEntered";
    public static final String EVENTS_REDIRECT_URLS = "redirectUrls";
    public static final String EVENTS_SMS_DETECTED = "smsDetected";
    public static final String EXTRA_APP_NAME = "appName";
    public static final String EXTRA_APP_VERSION = "appVersion";
    public static final String EXTRA_BANK_CODE = "bnkCode";
    public static final String EXTRA_BANK_PAGE_ACS = "ACS";
    public static final String EXTRA_BANK_PAGE_DIRECT = "DIRECT";
    public static final String EXTRA_BANK_PAGE_TYPE = "bankPageType";
    public static final String EXTRA_BANK_PAGE_WRAPPER = "WRAPPER";
    public static final String EXTRA_BANK_PAYTYPE = "payType";
    public static final String EXTRA_BANK_REQ_JSON = "extra_bank_req";
    public static final String EXTRA_BANK_SCHEME = "cardScheme";
    public static final String EXTRA_DEVICE_TYPE = "deviceType";
    public static final String EXTRA_MID = "mid";
    public static final String EXTRA_ORDER_ID = "orderId";
    public static final String EXTRA_SENDER_INFO = "senderInfo";
    public static String EventUrl = "https://securegw.paytm.in/payassist/api/submit/event/logs";
    public static String FETCH_URL_API = "https://securegw.paytm.in/payassist/api/getURLByAppVersion";
    public static final String FILLER_FROM_CODE = "FILLER_FROM_CODE";
    public static final String FILLER_FROM_WEB = "FILLER_FROM_WEB";
    public static boolean IS_RELEASE_8_1_0 = false;
    public static MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final String KEY_APP_VERSION = "version";
    public static final String KEY_DEVICE_TYPE = "deviceType";
    public static final int LOG_ERROR_OTP = 110;
    public static final String NEXT_BTN = "NEXT_BTN";
    public static final int OTP_FILLER_WEB_SUCCESS = 107;
    public static final int OTP_FILLER_WEB_SUCCESS_WRAPER_PAGE = 112;
    public static final int OTP_PASSWORD_TXT_CHANGED = 108;
    public static final String PASSWORD_FINDER = "PASSWORD_FINDER";
    public static final String PASSWORD_INPUT_REGISTER = "PASSOWRD_INPUT_REGISTER";
    public static final String PREVIOUS_BTN = "PREVIOUS_BTN";
    public static final String READ_OTP = "READ_OTP";
    public static final String RESEND_BTN = "RESEND_BUTTON";
    public static final String RISK_ASYNC_API_URL = "https://riskengine.paytm.com/risk/policy/nonstandard/asyncConsult";
    public static final String RISK_BIZ_SCENE = "bizScene";
    public static final String RISK_CLIENT_IP = "clientIp";
    public static final String RISK_DEVICE_ID = "deviceId";
    public static final String RISK_ENV_INFO = "envInfo";
    public static final String RISK_EVENT_LINK_ID = "eventLinkId";
    public static final String RISK_EXTENDED_INFO = "extendInfo";
    public static final String RISK_MERCHANT_APP_VERSION = "merchantAppVersion";
    public static final String RISK_OCCURRENCE_TIME = "occurTime";
    public static final String RISK_OS_TYPE = "osType";
    public static final String RISK_SDK_VERSION = "sdkVersion";
    public static final String RISK_TERMINAL_TYPE = "terminalType";
    public static final String RISK_TRANSACTION_ID = "transactionId";
    public static final String RISK_USER_ID = "paytmUserId";
    public static final String RISK_WEBSITE_LANGUAGE = "websiteLanguage";
    public static final int SMS_CONSENT_REQUEST = 121;
    public static final String SUBMIT_BTN = "SUBMIT_BTN";
    public static final String TAG = "EasyPay";
    public static final String TIMESTAMP_ASSIST_POPPED = "timeStampAssistPopped";
    public static final String TIMESTAMP_OTP_AUTO_READ = "timeStampOtpAutoRead";
    public static final String TIMESTAMP_OTP_NOT_AUTO_READ = "timeStampOtpNotAutoRead";
    public static final String TIMESTAMP_SUBMIT_OTP_AUTO = "timeStampSubmitOtpAuto";
    public static final String TIMESTAMP_SUBMIT_OTP_MANUAL = "timeStampSubmitOtpManual";
    public static final String TIMESTAMP_TAP_TO_PAUSE = "timeStampTapToPause";
    public static final String UNKNOWN_ERROR = "Unknown error occurred";
    public static final String USER_ID_NET_BANK_KEY = "USER_ID_NET_BANK_KEY";
    public static final String VALUE_DEVICE_TYPE = "android";
    public static String WelcomeApi = "https://securegw.paytm.in/merchant-settlement-service/paytmAssist/enable";

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setBaseUrl(java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = r4.hashCode()
            r1 = 2
            r2 = 1
            r3 = -2056856391(0xffffffff8566dcb9, float:-1.08550884E-35)
            if (r0 == r3) goto L_0x002a
            r3 = -482625645(0xffffffffe33bb793, float:-3.462769E21)
            if (r0 == r3) goto L_0x0020
            r3 = 103214261(0x626ecb5, float:3.1395035E-35)
            if (r0 == r3) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "CUSTOM_IP"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "PRE_PROD"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "PRODUCTION"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0042
            if (r4 == r2) goto L_0x003f
            if (r4 != r1) goto L_0x003c
            goto L_0x0044
        L_0x003c:
            java.lang.String r5 = ""
            goto L_0x0044
        L_0x003f:
            java.lang.String r5 = "https://securegw-preprod.paytm.in/"
            goto L_0x0044
        L_0x0042:
            java.lang.String r5 = "https://securegw.paytm.in/"
        L_0x0044:
            updateApiUrl(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: easypay.manager.Constants.setBaseUrl(java.lang.String, java.lang.String):void");
    }

    public static void updateApiUrl(String str) {
        EventUrl = str + "payassist/api/submit/event/logs";
        WelcomeApi = str + "merchant-settlement-service/paytmAssist/enable";
        FETCH_URL_API = str + "payassist/api/getURLByAppVersion";
    }
}
