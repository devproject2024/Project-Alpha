package easypay.manager;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.actions.EasypayBrowserFragment;
import easypay.actions.a;
import easypay.actions.c;
import easypay.actions.e;
import easypay.entity.AssistDetailsResponse;
import easypay.entity.AssistUrlResponse;
import easypay.entity.GetUrlResponse;
import easypay.entity.NewConfigResponse;
import easypay.listeners.AppCallbacks;
import easypay.listeners.WebClientListener;
import easypay.listeners.b;
import easypay.utils.AssistLogs;
import easypay.utils.EasyPayConfigDownloader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Headers;
import okhttp3.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

public class AssistMerchantDetails {
    private static AssistMerchantDetails _instance;
    public MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String appVersion;
    private NewConfigResponse.AssistFeatureEvents assistFeatureEvents;
    private String bankName;
    private String bankPageType = Constants.EXTRA_BANK_PAGE_ACS;
    private String cardDetails;
    private String configUrlToHit;
    private Context context;
    private String detailString = "";
    private EasyPayHelper easyPayHelper;
    private boolean enableLogging = true;
    /* access modifiers changed from: private */
    public EasypayBrowserFragment fragment;
    private Integer fragmentViewId;
    private String ipAddress = "";
    private boolean isEasyPayEnabled = true;
    private boolean isFragmentResumed = true;
    private boolean isFragmentStopped = true;
    private boolean isNativeOtpEnabled = false;
    private boolean isPayTypeNB;
    private String lastLoadedUrl;
    private AppCallbacks listener;
    private AppCompatActivity mActivity;
    private ConcurrentHashMap<String, Object> mAssistEventMap = new ConcurrentHashMap<>();
    private Map<String, Object> mEventMap = new HashMap();
    private ConcurrentHashMap<String, Object> mExtraInfoEventMap = new ConcurrentHashMap<>();
    private EasyPayConfigDownloader.b mListener;
    private boolean mUseSmsConsent = true;
    private String mUserId;
    private ArrayList<WebClientListener> mWcListListener;
    private String mid;
    private c nativeFragment;
    private String orderId;
    private String riskEventLinkId;
    private JSONObject riskExtendedInfo;
    private String server = "PRODUCTION";
    private String timeFinish;
    private String timeStart;
    private String transactionId;
    private EasypayWebViewClient webClientInstance;
    private WebView webView = null;

    public String getBankPageType() {
        return this.bankPageType;
    }

    public void setBankPageType(String str) {
        this.bankPageType = str;
    }

    public static synchronized AssistMerchantDetails getInstance() {
        AssistMerchantDetails assistMerchantDetails;
        synchronized (AssistMerchantDetails.class) {
            if (_instance == null) {
                _instance = new AssistMerchantDetails();
            }
            assistMerchantDetails = _instance;
        }
        return assistMerchantDetails;
    }

    public boolean isFragmentResumed() {
        return this.isFragmentResumed;
    }

    public void setFragmentResumed(boolean z) {
        this.isFragmentResumed = z;
    }

    public boolean isFragmentPaused() {
        return this.isFragmentStopped;
    }

    public void setFragmentPaused(boolean z) {
        this.isFragmentStopped = z;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public boolean isEnableLogging() {
        return this.enableLogging;
    }

    public void setEasyPayEnabled(boolean z) {
        this.isEasyPayEnabled = z;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getCardDetails() {
        return this.cardDetails;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public EasyPayHelper getEasyPayHelper() {
        if (this.easyPayHelper == null) {
            setEasyPayHelper();
        }
        return this.easyPayHelper;
    }

    public void setEasyPayHelper() {
        this.easyPayHelper = new EasyPayHelper();
    }

    public String getLastLoadedUrl() {
        return this.lastLoadedUrl;
    }

    public void setLastLoadedUrl(String str) {
        this.lastLoadedUrl = str;
    }

    public void setFragmentViewId(Integer num) {
        this.fragmentViewId = num;
    }

    public EasypayWebViewClient getWebClientInstance() {
        if (this.webClientInstance == null) {
            setWebClientInstance(this.mActivity);
        }
        return this.webClientInstance;
    }

    public void setWebClientInstance(Context context2) {
        if (context2 != null) {
            this.webClientInstance = new EasypayWebViewClient(this.mActivity);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.webClientInstance = (EasypayWebViewClient) webViewClient;
    }

    public ArrayList<WebClientListener> getmWcListListener() {
        return this.mWcListListener;
    }

    /* access modifiers changed from: protected */
    public void setmWcListListener(ArrayList<WebClientListener> arrayList) {
        this.mWcListListener = arrayList;
    }

    public WebView getWebView() {
        return this.webView;
    }

    public void setWebView(WebView webView2) {
        this.webView = webView2;
    }

    public EasypayBrowserFragment getFragment() {
        return this.fragment;
    }

    public String geTxnBank() {
        if (TextUtils.isEmpty(this.bankName)) {
            return null;
        }
        return this.bankName;
    }

    public String getConfigUrlToHit() {
        return this.configUrlToHit;
    }

    public void setConfigUrlToHit(String str) {
        this.configUrlToHit = str;
    }

    public boolean isUseSmsConsent() {
        return this.mUseSmsConsent;
    }

    public void setUseSmsConsent(boolean z) {
        this.mUseSmsConsent = z;
    }

    public EasyPayConfigDownloader.b getConfigDownloadListener() {
        return this.mListener;
    }

    public boolean isEasyPayEnabled() {
        return this.isEasyPayEnabled;
    }

    public void setDetailString(String str) {
        this.detailString = str;
    }

    public String getDetailString() {
        return this.detailString;
    }

    public void downloadBankWiseConfig(String str) {
        try {
            this.mListener = new EasyPayConfigDownloader.b() {
                public void OnJsonDownLoadSuccess(String str) {
                    if (AssistMerchantDetails.this.fragment != null) {
                        AssistLogs.printLog("Config download success", this);
                        EasypayBrowserFragment access$000 = AssistMerchantDetails.this.fragment;
                        try {
                            if (access$000.f46015b != null) {
                                access$000.f46014a = (AssistDetailsResponse) new f().a(access$000.f46015b.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0).getString(Constants.EASY_PAY_CONFIG_PREF_KEY, ""), AssistDetailsResponse.class);
                                if (access$000.f46014a != null) {
                                    Iterator<AssistUrlResponse> it2 = access$000.f46014a.getResponse().iterator();
                                    while (it2.hasNext()) {
                                        AssistUrlResponse next = it2.next();
                                        if (access$000.f46015b != null) {
                                            access$000.f46015b.runOnUiThread(new EasypayBrowserFragment.a(next));
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            AssistLogs.printLog("Activity context found null while loading configuration from shared preferences.", access$000);
                        } catch (Exception e2) {
                            AssistLogs.printLog("EXCEPTION", e2);
                        }
                    }
                }

                public void OnJsonDownLoadFailure(String str) {
                    AssistLogs.printLog("Fetching bank detail failed", this);
                }
            };
            Intent intent = new Intent(this.mActivity, EasyPayConfigDownloader.class);
            intent.putExtra(Constants.EXTRA_BANK_REQ_JSON, str);
            EasyPayConfigDownloader.a(this.mActivity.getBaseContext(), intent);
        } catch (Exception unused) {
        }
    }

    public void clearInstance() {
        String str;
        if (this.isNativeOtpEnabled) {
            this.mAssistEventMap.put("extendedInfo", this.mExtraInfoEventMap);
            hitEventsApi();
            setBankPageType(Constants.EXTRA_BANK_PAGE_DIRECT);
            setRiskExtendedInfoParam(Constants.EXTRA_BANK_PAGE_TYPE, getBankPageType());
            if (!this.isPayTypeNB) {
                hitRiskEventsApi();
            }
            AppCompatActivity appCompatActivity = this.mActivity;
            if (!(appCompatActivity == null || appCompatActivity.getSupportFragmentManager().c("NativeHeadLessFragment") == null)) {
                try {
                    this.mActivity.getSupportFragmentManager().a().a((Fragment) this.nativeFragment).c();
                    this.nativeFragment = null;
                    AssistLogs.printLog("Deleted and removed Native HeadLess fragment", this);
                } catch (Exception e2) {
                    AssistLogs.printLog("EXCEPTION", e2);
                }
            }
        }
        if (!(this.fragment == null || this.mActivity == null)) {
            setRiskExtendedInfoParam(Constants.EXTRA_BANK_PAGE_TYPE, getBankPageType());
            if (!this.isPayTypeNB) {
                hitRiskEventsApi();
            }
            setEventInEventMap(Constants.EVENTS_REDIRECT_URLS, this.fragment.getRedirectUrl().toString());
            this.mAssistEventMap.put("extendedInfo", this.mExtraInfoEventMap);
            String str2 = "time not captured";
            if (this.timeStart == null || this.timeFinish == null) {
                str = str2;
            } else {
                str2 = this.timeStart;
                str = this.timeFinish;
                AssistLogs.printLog(str2 + str + " Check", this);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                setEventInEventMap(Constants.EVENTS_ACS_URL_REQUESTED, str2);
                setEventInEventMap(Constants.EVENTS_ACS_URL_LOADED, str);
            }
            hitEventsApi();
            AppCompatActivity appCompatActivity2 = this.mActivity;
            if (!(appCompatActivity2 == null || appCompatActivity2.getSupportFragmentManager().c(Constants.TAG) == null)) {
                try {
                    this.mActivity.getSupportFragmentManager().a().a((Fragment) this.fragment).c();
                    this.fragment = null;
                    AssistLogs.printLog("Deleted and removed EasyPayBrowser fragment", this);
                } catch (Exception e3) {
                    AssistLogs.printLog("EXCEPTION", e3);
                }
            }
        }
        if (this.context != null) {
            e.a().d();
        }
        e.b();
        a.a();
        _instance = null;
    }

    private void inflatePaytmAssist() {
        AssistLogs.printLog("Started inflatePaytmAssist", this);
        if (getInstance().isEasyPayEnabled()) {
            try {
                AssistLogs.printLog("Creating EasypayBrowserFragment", this);
                if (this.fragment == null && this.mActivity != null) {
                    AssistLogs.printLog("Fragment is null, initializing fragment", this);
                    this.fragment = EasypayBrowserFragment.a();
                    q a2 = this.mActivity.getSupportFragmentManager().a();
                    a2.a(this.fragmentViewId.intValue(), this.fragment, Constants.TAG);
                    a2.c();
                    this.webView.setWebChromeClient(new WebChromeClient());
                }
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
            setEventInEventMap(Constants.EVENTS_IS_NATIVE_OTP_ENABLED, "false");
        } else if (getInstance().isNativeOtpEnabled()) {
            AssistLogs.printLog("Native flow enabled, starting headless fragment", this);
            this.mActivity.getSupportFragmentManager().c("NativeHeadLessFragment");
            if (this.nativeFragment == null) {
                this.nativeFragment = c.a();
                this.mActivity.getSupportFragmentManager().a().a((Fragment) this.nativeFragment, "NativeHeadLessFragment").c();
            }
            e.a().c();
            setEventInEventMap(Constants.EVENTS_IS_NATIVE_OTP_ENABLED, "true");
        }
    }

    public void setEnableLogging(boolean z) {
        this.enableLogging = z;
    }

    private void fetchAPIByAppVersion(final String str) {
        a.a(new b() {
            public void onSuccess(String str) {
                if (str != null) {
                    try {
                        GetUrlResponse getUrlResponse = (GetUrlResponse) new f().a(new JSONObject(str).toString(), GetUrlResponse.class);
                        if (getUrlResponse != null && getUrlResponse.getResponseCode() == 200) {
                            if (!TextUtils.isEmpty(getUrlResponse.getResponseUrl())) {
                                AssistMerchantDetails.getInstance().setConfigUrlToHit(getUrlResponse.getResponseUrl());
                                AssistMerchantDetails.this.downloadBankWiseConfig(str);
                                AssistLogs.printLog("Get Config URL to hitURL:" + AssistMerchantDetails.getInstance().getConfigUrlToHit(), this);
                                return;
                            }
                            AssistMerchantDetails.getInstance().setConfigUrlToHit("");
                        }
                    } catch (JSONException e2) {
                        AssistLogs.printLog("EXCEPTION", e2);
                    }
                }
            }

            public void onFailure(String str) {
                AssistLogs.printLog("Error in executing fetchUrlByAppVersion API: ".concat(String.valueOf(str)), this);
                if (str != null) {
                    AssistMerchantDetails.this.setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "getUniqueAssist $".concat(String.valueOf(str)));
                } else {
                    AssistMerchantDetails.this.setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "getUniqueAssist $ API Failed while executing");
                }
            }
        });
    }

    public void accessCheckApi() {
        a.a(this.server, this.ipAddress, (b) new b() {
            public void onSuccess(String str) {
                if (str != null && AssistMerchantDetails.getInstance().getActivity() != null) {
                    AssistMerchantDetails.getInstance().getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            AssistLogs.printLog("Welcome API returned success, start initAssist", this);
                            AssistMerchantDetails.this.initAssist();
                        }
                    });
                }
            }

            public void onFailure(String str) {
                AssistLogs.printLog("Error in executing Welcome API: ".concat(String.valueOf(str)), this);
                if (str != null) {
                    AssistMerchantDetails.this.setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "accessCheckApi $".concat(String.valueOf(str)));
                } else {
                    AssistMerchantDetails.this.setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "accessCheckApi $ API Failed while executing");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void initAssist() {
        if (this.mActivity != null && this.context != null) {
            AssistLogs.printLog("Started initAssist", this);
            try {
                if (this.mActivity.getPackageManager() != null) {
                    this.appVersion = this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName;
                    setEventInEventMap("appName", this.mActivity.getPackageName());
                    setEventInEventMap("orderId", this.orderId);
                    setEventInEventMap("appVersion", this.appVersion);
                } else {
                    setEventInEventMap("appName", this.mActivity.getPackageName());
                    setEventInEventMap("orderId", this.orderId);
                    setEventInEventMap("appVersion", "Version not found");
                }
                setEventInEventMap("mid", this.mid);
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
            if (androidx.core.app.a.a(this.context, "android.permission.RECEIVE_SMS") == 0 && (getInstance().isEasyPayEnabled() || getInstance().isNativeOtpEnabled())) {
                setEventInEventMap(Constants.EVENTS_IS_SMS_PERMISSION, "true");
                inflatePaytmAssist();
            } else if (androidx.core.app.a.a(this.context, "android.permission.RECEIVE_SMS") == 0) {
            } else {
                if (getInstance().isEasyPayEnabled() || getInstance().isNativeOtpEnabled()) {
                    setEventInEventMap(Constants.EVENTS_IS_SMS_PERMISSION, "true");
                    getInstance().setUseSmsConsent(true);
                    inflatePaytmAssist();
                }
            }
        }
    }

    public void setNativeOtpEnabled(boolean z) {
        this.isNativeOtpEnabled = z;
    }

    public boolean isNativeOtpEnabled() {
        return this.isNativeOtpEnabled;
    }

    public void setContext(Context context2) {
        this.context = context2;
        if (context2 instanceof AppCompatActivity) {
            this.mActivity = (AppCompatActivity) context2;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setCardDetails(String str) {
        this.cardDetails = str;
    }

    public Map<String, Object> getEventMap() {
        return this.mExtraInfoEventMap;
    }

    public void setExtraInfoForEvents() {
        this.mExtraInfoEventMap.put("deviceInfo", easypay.utils.b.a());
        DisplayMetrics b2 = easypay.utils.b.b(getContext());
        double d2 = (double) b2.densityDpi;
        double d3 = ((double) b2.heightPixels) / d2;
        double d4 = ((double) b2.widthPixels) / d2;
        ConcurrentHashMap<String, Object> concurrentHashMap = this.mExtraInfoEventMap;
        concurrentHashMap.put("display", b2.heightPixels + "|" + b2.widthPixels);
        ConcurrentHashMap<String, Object> concurrentHashMap2 = this.mExtraInfoEventMap;
        concurrentHashMap2.put("displayInInches", d3 + "|" + d4);
        String a2 = easypay.utils.b.a(this.context);
        if (a2 != null) {
            this.mExtraInfoEventMap.put("networkType", a2);
        }
    }

    public void setBankInfo(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && str.contains("-")) {
            str = str.substring(0, str.indexOf("-"));
        }
        setBankName(str);
        String lowerCase = str2.toLowerCase();
        setEventInEventMap("cardType", str2);
        if (lowerCase.equals("nb")) {
            this.isPayTypeNB = true;
            getInstance().setEventInEventMap(Constants.EVENTS_CARD_TRANSACTION, "false");
        } else {
            this.isPayTypeNB = false;
            getInstance().setEventInEventMap(Constants.EVENTS_CARD_TRANSACTION, "true");
        }
        setEventInEventMap(Constants.EVENTS_CARD_ISSUER, str3);
        setCardDetails(str + str3 + str2);
        String lowerCase2 = (str + str3 + str2).toLowerCase();
        if (lowerCase2.contains("idebit") || lowerCase2.contains("atm")) {
            setEventInEventMap(Constants.EVENTS_NON_OTP_REQUEST, "true");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_BANK_CODE, str);
            jSONObject.put(Constants.EXTRA_BANK_PAYTYPE, str2);
            jSONObject.put(Constants.EXTRA_BANK_SCHEME, str3);
            setDetailString(jSONObject.toString());
            fetchAPIByAppVersion(this.detailString);
        } catch (JSONException e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    public void setCustomIpAddress(String str) {
        this.ipAddress = str;
    }

    public AppCallbacks getListener() {
        return this.listener;
    }

    public void setListener(AppCallbacks appCallbacks) {
        this.listener = appCallbacks;
    }

    public AppCompatActivity getActivity() {
        return this.mActivity;
    }

    public Headers getHeaders() {
        AppCompatActivity appCompatActivity = this.mActivity;
        String str = "";
        String packageName = appCompatActivity != null ? appCompatActivity.getPackageName() : str;
        String str2 = this.mid;
        if (str2 != null) {
            str = str2;
        }
        return new Headers.Builder().add("midParam", str).add("pkgName", packageName).add("encryptMsg", easypay.utils.b.a(str, packageName)).build();
    }

    public boolean isAdded(EasypayBrowserFragment easypayBrowserFragment) {
        EasypayBrowserFragment easypayBrowserFragment2;
        AppCompatActivity appCompatActivity = this.mActivity;
        if (appCompatActivity == null || (easypayBrowserFragment2 = (EasypayBrowserFragment) appCompatActivity.getSupportFragmentManager().c((String) Constants.TAG)) == null) {
            return false;
        }
        return easypayBrowserFragment2.equals(easypayBrowserFragment);
    }

    public void setTimeStart(String str) {
        this.timeStart = str;
    }

    public void setTimeFinish(String str) {
        this.timeFinish = str;
    }

    private void hitEventsApi() {
        a.a(this.mAssistEventMap, (b) new b() {
            public void onSuccess(String str) {
                AssistLogs.printLog("Events log API response:".concat(String.valueOf(str)), this);
            }

            public void onFailure(String str) {
                AssistLogs.printLog("Error in executing events API: ".concat(String.valueOf(str)), this);
                if (str != null) {
                    AssistMerchantDetails.this.setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "eventLogsApi $".concat(String.valueOf(str)));
                } else {
                    AssistMerchantDetails.this.setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "eventLogsApi $ API Failed while executing");
                }
            }
        });
    }

    public NewConfigResponse.AssistFeatureEvents getAssistFeatureEvents() {
        return this.assistFeatureEvents;
    }

    public void setAssistFeatureEvents(NewConfigResponse.AssistFeatureEvents assistFeatureEvents2) {
        this.assistFeatureEvents = assistFeatureEvents2;
    }

    public void setRiskEventLinkId(String str) {
        this.riskEventLinkId = str;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public void setRiskExtendedInfoParam(String str, String str2) {
        if (this.riskExtendedInfo == null) {
            this.riskExtendedInfo = new JSONObject();
        }
        try {
            this.riskExtendedInfo.put(str, str2);
        } catch (JSONException e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    private void hitRiskEventsApi() {
        a.a(this.riskEventLinkId, this.appVersion, this.transactionId, this.mUserId, this.orderId, this.context, this.riskExtendedInfo, new b() {
            public void onSuccess(String str) {
                AssistLogs.printLog("Risk API response:".concat(String.valueOf(str)), this);
            }

            public void onFailure(String str) {
                AssistLogs.printLog("Error in executing Risk events API: ".concat(String.valueOf(str)), this);
                if (str != null) {
                    AssistMerchantDetails.this.setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "riskAsyncEventsApi $".concat(String.valueOf(str)));
                } else {
                    AssistMerchantDetails.this.setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "riskAsyncEventsApi $ API Failed while executing");
                }
            }
        });
    }

    public void setEventInEventMap(String str, Object obj) {
        this.mAssistEventMap.put(str, obj);
        AssistLogs.printLog("AssistAnalytics:" + str + AppConstants.COLON + obj, this);
    }

    public void logNewEvents(String str, Object obj) {
        this.mExtraInfoEventMap.put(str, obj);
        AssistLogs.printLog("AssistAnalytics:" + str + AppConstants.COLON + obj, this);
    }

    public void OnBackPressClicked(Boolean bool) {
        AssistLogs.printLog("AssistAnalytics:backPressClicked:".concat(String.valueOf(bool)), this);
        if (!this.isFragmentResumed || TextUtils.isEmpty(this.lastLoadedUrl) || this.lastLoadedUrl.contains("paytm")) {
            setEventInEventMap(Constants.EVENTS_BACK_PRESS_CLICKED, String.valueOf(bool));
        } else {
            setEventInEventMap(Constants.EVENTS_IS_BACK_CLICKED_ON_ACS_PAGE, String.valueOf(bool));
        }
    }
}
