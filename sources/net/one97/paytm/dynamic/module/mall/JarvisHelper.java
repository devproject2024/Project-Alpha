package net.one97.paytm.dynamic.module.mall;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.paymentsettings.paytmassist.view.ui.PaytmAssistSettingsActivity;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.artifact.cart.entity.CJRCartProduct;
import com.paytmmall.artifact.cart.entity.CJRDetailProduct;
import com.paytmmall.artifact.common.a;
import com.paytmmall.artifact.common.entity.CJRItem;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.g;
import com.paytmmall.artifact.d.s;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.v;
import com.paytmmall.artifact.d.w;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.modal.cart.CJRCartResponse;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.a.m;
import net.one97.paytm.AJRAppLockSettingsActivity;
import net.one97.paytm.AJRNotificationSettingsWebview;
import net.one97.paytm.AJRProfileActivity;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.AJRUpdateMessage;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;
import net.one97.paytm.common.utility.e;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.dynamic.module.mall.emiSubvention.nativepghelper.MallPGHelper;
import net.one97.paytm.h5.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.utils.croptool.CropImage;
import net.one97.paytm.landingpage.utils.croptool.CropImageView;
import net.one97.paytm.marketplace.search.activity.AJRSearchActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.savedPaymentItem.AJRSavedPaymentActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import org.json.JSONException;
import org.json.JSONObject;

public class JarvisHelper implements a {
    private static JarvisHelper _instance;
    private static t _mallControllerInstance;
    private final String ACTION_UPDATE_CLP = CLPConstants.ACTION_UPDATE_CLP;
    private final String AppsFlyerChannel = "whatsapp";
    private HashSet<String> buildConfigConstants = new HashSet<String>() {
        {
            add("CLIENT_ID");
            add("CLIENT");
            add("SECRET_CODE");
            add("AUTHORIZATION_VALUE");
            add("WEEX_VERSION_KEY");
            add("WEEX_BASE_URL");
            add("BUILD_TYPE");
            add("SITE_ID");
            add("USER_ID");
            add("CHILD_SITE_ID");
            add("APP_STAMP");
            add("INVITE_LINK");
            add("IS_DEBUG");
            add("VERSION_NAME");
            add("CONTAINER_ID");
            add("schema_name");
            add("DEEPLINK_SCHEME_ID");
            add("ALIAS_CLIENT_ID_KEY_MAP");
            add("ATLAS_CLIENT_SECRET_KEY_MAP");
        }
    };
    private PaytmSDKRequestClient checkoutListener;
    m<? super String, ? super Integer, ?> generateShortUrl = new m<String, Integer, Object>() {
        public Object invoke(String str, Integer num) {
            if (!TextUtils.isEmpty(str)) {
                net.one97.paytm.marketplace.a.e(str);
                return null;
            }
            net.one97.paytm.marketplace.a.e("");
            return null;
        }
    };
    private final Map<String, Class<? extends Activity>> paytmActivityMap = getPaytmActivityMap();
    private HashSet<String> paytmRequiredClassSet = new HashSet<String>() {
        {
            add("authActivity");
            add("paySendActivity");
            add("mainActivity");
            add("checkout");
            add("raise_issue");
            add("paytm_assist");
            add("language");
            add("applock");
            add("change_password");
            add("notification_webview");
            add("saved_cards");
            add("edit_profile");
            add("passbook");
            add("notification");
            add("contact_us");
            add("update_message");
            add("qr_code");
        }
    };
    private ArrayList<CJRItem> recentlyViewedCache;
    private ISubventionProvider subventionProvider;

    private boolean checkApidAvailable() {
        return true;
    }

    public String getChannel() {
        return UpiConstants.MP_ANDROID;
    }

    public View getTabView(Activity activity) {
        return null;
    }

    public boolean isMallApp() {
        return false;
    }

    public boolean isServifyEnabled() {
        return false;
    }

    public void openContactUs(Activity activity, String str) {
    }

    public void sendAppsFlyerFbSearchClickEvent(Context context, String str, String[] strArr) {
    }

    public void sendCustomEventWithMap(Map<String, Object> map) {
    }

    private JarvisHelper(Application application) {
        this.recentlyViewedCache = getCachedRecentlyViewedResponse(application);
        d.a(getConstantMap());
        g.a(getConstantMap());
    }

    public static JarvisHelper getInstance() {
        if (_instance == null) {
            synchronized (JarvisHelper.class) {
                if (_instance == null) {
                    Application application = (Application) CJRJarvisApplication.getAppContext();
                    JarvisHelper jarvisHelper = new JarvisHelper(application);
                    _instance = jarvisHelper;
                    t.a((a) jarvisHelper, application);
                    _mallControllerInstance = t.c();
                    _instance.initH5();
                }
            }
        }
        return _instance;
    }

    public static void getMallInstance() {
        if (_instance == null) {
            synchronized (a.class) {
                Application application = (Application) CJRJarvisApplication.getAppContext();
                if (_instance == null) {
                    _instance = new JarvisHelper(application);
                }
                t.a((a) _instance, application);
                _mallControllerInstance = t.c();
                _instance.initH5();
            }
        }
    }

    public t getMallControllerInstance() {
        getInstance();
        return _mallControllerInstance;
    }

    public void setH5Data(Context context) {
        c cVar = c.f50543a;
        c.a("ddbase", new c.b(context) {
            private final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void provideValuesForKeys(String str, c.C0910c cVar) {
                JarvisHelper.this.lambda$setH5Data$0$JarvisHelper(this.f$1, str, cVar);
            }
        });
    }

    public /* synthetic */ void lambda$setH5Data$0$JarvisHelper(Context context, String str, c.C0910c cVar) {
        if (cVar != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1068855134:
                    if (str.equals("mobile")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 96619420:
                    if (str.equals(AppConstants.KEY_EMAIL)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 97513095:
                    if (str.equals("flags")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1468308994:
                    if (str.equals("USER_SESSION")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                cVar.onResult(getSessionDetails(context));
            } else if (c2 == 1) {
                cVar.onResult(getH5Flags(context));
            } else if (c2 == 2) {
                cVar.onResult(b.m(context));
            } else if (c2 == 3) {
                cVar.onResult(b.l(context));
            }
        }
    }

    private HashMap<String, Object> getSessionDetails(Context context) {
        return net.one97.paytm.marketplace.a.a(context);
    }

    private HashMap<String, Object> getH5Flags(Context context) {
        return net.one97.paytm.marketplace.a.b(context);
    }

    public String getSSOToken(Context context) {
        return net.one97.paytm.utils.t.b(context);
    }

    public void setUTMData(Uri uri) {
        CJRUrlUtmData cJRUrlUtmData = new CJRUrlUtmData();
        if (uri.getQueryParameter("utm_source") != null) {
            cJRUrlUtmData.addToUtmSource(uri.getQueryParameter("utm_source"));
        }
        if (uri.getQueryParameter("utm_medium") != null) {
            cJRUrlUtmData.setUtmMedium(uri.getQueryParameter("utm_medium"));
        }
        if (uri.getQueryParameter("utm_term") != null) {
            cJRUrlUtmData.setUtmTerm(uri.getQueryParameter("utm_term"));
        }
        if (uri.getQueryParameter("utm_content") != null) {
            cJRUrlUtmData.setUtmContent(uri.getQueryParameter("utm_content"));
        }
        if (uri.getQueryParameter("utm_campaign") != null) {
            cJRUrlUtmData.setUtmCampaign(uri.getQueryParameter("utm_campaign"));
        }
        cJRUrlUtmData.setFromPush(true);
        CJRJarvisApplication.a(cJRUrlUtmData);
    }

    public void loadPage(Context context, String str, String str2, String str3, int i2, String str4, boolean z, String str5) {
        ArrayList arrayList;
        String str6 = str2;
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) convertToPojo(str2, CJRHomePageItem.class);
        if (!TextUtils.isEmpty(str4)) {
            arrayList = (ArrayList) convertToPojo(str4, new com.google.gsonhtcfix.c.a<ArrayList<CJRHomePageItem>>() {
            }.getType());
        } else {
            arrayList = null;
        }
        j.a(context, str, (IJRDataModel) cJRHomePageItem, str3, i2, (ArrayList<? extends net.one97.paytm.common.entity.CJRItem>) arrayList, z, str5, (net.one97.paytm.c) null);
    }

    public void initH5() {
        if (getApplicationContext() instanceof Application) {
            u.a();
            u.a((Application) getApplicationContext());
            if (CJRJarvisApplication.getAppContext() != null) {
                setH5Data(CJRJarvisApplication.getAppContext());
            }
        }
    }

    public void setUTMData(String str) {
        CJRUrlUtmData g2 = CJRJarvisApplication.g();
        if (g2 == null) {
            g2 = new CJRUrlUtmData();
            g2.addToUtmSource(str);
        } else if (!g2.isFromPush()) {
            g2.addToUtmSource(str);
        }
        CJRJarvisApplication.a(g2);
    }

    public Context getApplicationContext() {
        return CJRJarvisApplication.getAppContext();
    }

    public <T> void sendEventToPaytmAnalytics(T t, String str, boolean z, boolean z2, boolean z3) {
        net.one97.paytm.j.a.a(t, str);
    }

    public String postRequestBodyForV2() {
        return l.a(CJRJarvisApplication.getAppContext(), (String) null, (String) null);
    }

    public String getSignedExpressCheckoutURL(String str, String str2) {
        return b.d(str, str2);
    }

    public String getSignedExpressCheckoutURL(String str, String str2, String str3) {
        return b.j(str, str2, str3);
    }

    public void launchHome(Activity activity, Intent intent) {
        if (intent == null) {
            intent = new Intent();
            if (isMallApp()) {
                intent.putExtra("resultant fragment position", 0);
            } else {
                intent.putExtra("resultant fragment position", 1);
            }
        } else {
            CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
            cJRHomePageItem.setUrl(ag.a(getApplicationContext()).b("home_url", "", true));
            intent.putExtra("extra_home_data", cJRHomePageItem);
            intent.putExtra("maintaince_error_503", true);
        }
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        resolveIntentByMainApp(activity, intent, "mainActivity", Integer.MIN_VALUE);
    }

    public void redirectToPaytm(Context context, String str) {
        l.a(str, context, "");
    }

    public Map<String, String> getProfileData(Context context) {
        return b.M(context);
    }

    public void openContactUs(Activity activity, String str, String str2, com.paytmmall.artifact.a.a.a aVar) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (Serializable) convertToPojo(str, CJROrderedCart.class));
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, (Serializable) convertToPojo(str2, CJRReplacementReason.class));
        }
        openH5CST(activity, aVar, bundle);
    }

    private void openH5CST(Activity activity, final com.paytmmall.artifact.a.a.a aVar, Bundle bundle) {
        aVar.a();
        AnonymousClass5 r0 = new net.one97.paytm.m() {
            public void show() {
                aVar.a();
            }

            public void dismiss() {
                aVar.b();
            }
        };
        r0.dismiss();
        bundle.putString("EXTRA_ACTION_ACTIVITY", "net.one97.paytm.cst.activity.AJRCSTOrderIssues");
        r0.dismiss();
        net.one97.paytm.deeplink.d.a((Context) activity, bundle, (net.one97.paytm.m) r0);
    }

    private <T> T convertToPojo(String str, Class<T> cls) {
        t.c();
        return t.a(str, cls);
    }

    private <T> T convertToPojo(String str, Type type) {
        t.c();
        return t.a(str, type);
    }

    public void setCrashlyticsLog(HashMap<String, String> hashMap) {
        try {
            com.google.firebase.crashlytics.c.a().b(com.paytm.utility.a.a(getApplicationContext()));
            net.one97.paytm.common.utility.l.b("version", b.Q(getApplicationContext()));
            net.one97.paytm.common.utility.l.b("app_stamp", l.a());
            net.one97.paytm.common.utility.l.b(ContactsConstant.NETWORK, com.paytm.utility.a.l(getApplicationContext()));
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    net.one97.paytm.common.utility.l.b((String) next.getKey(), (String) next.getValue());
                }
            }
            if (hashMap != null) {
                net.one97.paytm.common.utility.l.b("url", hashMap.get("url"));
                com.google.firebase.crashlytics.c.a().a((Throwable) new Exception(String.valueOf(hashMap.get("message"))));
            }
            if (hashMap != null) {
                for (Map.Entry<String, String> key : hashMap.entrySet()) {
                    net.one97.paytm.common.utility.l.b((String) key.getKey(), "");
                }
            }
            net.one97.paytm.common.utility.l.b(ContactsConstant.NETWORK, "");
        } catch (Exception unused) {
        }
    }

    public void setCrashlyticsEmailAndIdentifier() {
        try {
            com.google.firebase.crashlytics.c.a().b(com.paytm.utility.a.a(getApplicationContext()));
        } catch (Exception unused) {
        }
    }

    public void handleNotificationSettingsClick(Activity activity) {
        if (!checkApidAvailable()) {
            b.b((Context) activity, "", activity.getString(R.string.ddbase_msg_apid_not_available));
        } else if (com.paytm.utility.a.p(activity)) {
            resolveIntentByMainApp(activity, new Intent(), "notification_webview", Integer.MIN_VALUE);
        }
    }

    public void handlePlayServicesError(Activity activity) {
        e eVar = e.f49603a;
        e.a(activity);
    }

    /* access modifiers changed from: protected */
    public Class<? extends Activity> getClassFromPaytm(Activity activity, String str) throws IllegalArgumentException {
        if (isPresent(this.paytmActivityMap, str)) {
            return this.paytmActivityMap.get(str);
        }
        throw new IllegalArgumentException(getMissingKeys(activity, this.paytmRequiredClassSet, this.paytmActivityMap.keySet()));
    }

    private boolean isPresent(Map map, String str) {
        return map.containsKey(str);
    }

    private String getMissingKeys(Activity activity, Set<String> set, Set<String> set2) {
        Set<String> symmetricDifference = symmetricDifference(set, set2);
        String string = activity != null ? activity.getString(R.string.data_missing_text) : " KEYS Missing";
        if (symmetricDifference.isEmpty()) {
            return activity != null ? activity.getString(R.string.some_went_wrong) : "something went wrong";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : symmetricDifference) {
            sb.append(append);
            sb.append(" ");
        }
        sb.append(string);
        return String.valueOf(sb);
    }

    private Set<String> symmetricDifference(Set<String> set, Set<String> set2) {
        for (String next : set2) {
            if (!set.add(next)) {
                set.remove(next);
            }
        }
        return set;
    }

    public void resolveIntentByMainApp(Activity activity, Intent intent, String str, int i2) {
        Class<? extends Activity> classFromPaytm;
        if (activity != null && intent != null && !activity.isFinishing() && (classFromPaytm = getClassFromPaytm(activity, str)) != null) {
            intent.setClass(activity, classFromPaytm);
            if (i2 != Integer.MIN_VALUE) {
                activity.startActivityForResult(intent, i2);
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public Map<String, Class<? extends Activity>> getPaytmActivityMap() {
        return new HashMap<String, Class<? extends Activity>>((Class) null) {
            {
                put("authActivity", AJRAuthActivity.class);
                put("paySendActivity", PaySendActivityV2.class);
                put("mainActivity", AJRMainActivity.class);
                put("checkout", AJRRechargePaymentActivity.class);
                try {
                    put("raise_issue", Class.forName("net.one97.paytm.cst.cstWidgetization.view.AJRCSTWidgetLanding"));
                } catch (ClassNotFoundException e2) {
                    q.b(e2.getMessage());
                }
                put("paytm_assist", PaytmAssistSettingsActivity.class);
                put("qr_activity", AJRQRActivity.class);
                put("applock", AJRAppLockSettingsActivity.class);
                put("notification_webview", AJRNotificationSettingsWebview.class);
                put("saved_cards", AJRSavedPaymentActivity.class);
                put("edit_profile", AJRProfileActivity.class);
                put("notification", null);
                try {
                    put("contact_us", Class.forName("net.one97.paytm.cst.cstWidgetization.view.AJRCSTWidgetLanding"));
                } catch (ClassNotFoundException e3) {
                    q.b(e3.getMessage());
                }
                put("update_message", AJRUpdateMessage.class);
            }
        };
    }

    public Map<String, String> getConstantMap() {
        return new HashMap<String, String>() {
            {
                put("CLIENT_ID", "market-app");
                put("CLIENT", "androidapp");
                put("SECRET_CODE", "9a071762-a499-4bd9-914a-4361e7c3f4bc");
                put("AUTHORIZATION_VALUE", "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM=");
                put("BUILD_TYPE", net.one97.paytm.verifier.a.c.a() ? SDKConstants.KEY_STAGING_API : "release");
                put("SITE_ID", com.paytm.utility.a.a());
                put("USER_ID", com.paytm.utility.a.a(CJRJarvisApplication.getAppContext()));
                put("CHILD_SITE_ID", com.paytm.utility.a.b());
                put("APP_STAMP", l.a());
                put("INVITE_LINK", "http://m.p-y.tm");
                put("IS_DEBUG", "false");
                put("VERSION_NAME", "9.1.3");
                put("schema_name", "paytmmp");
                put("DEEPLINK_SCHEME_ID", "paytmmp");
                put("ATLAS_CLIENT_SECRET_KEY_MAP", "5NoeOrGVfz_6EMwGKDiR2YChPdpdPumDf1YlEd6aXesuxA5dPYvIog==");
                put("ALIAS_CLIENT_ID_KEY_MAP", "gBQwdy8VRhUZwL9vOU17u4Gu-VWla8x0NN1HhdTPaXI=");
            }
        };
    }

    public void openCheckoutActivity(Context context, Intent intent, String str, String str2, String str3, String str4, w wVar) {
        CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) convertToPojo(str, CJRRechargePayment.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra("tracking_info", (CJRParcelTrackingInfo) convertToPojo(str2, CJRParcelTrackingInfo.class));
        intent.putExtra("tracking_info_string", str2);
        intent.putExtra("intent_extra_is_from_mall", true);
        intent.putExtra(SDKConstants.IS_BANK_OFFER, isBankOffer(str3));
        int i2 = Integer.MIN_VALUE;
        if (intent.hasExtra("key_request_code")) {
            i2 = intent.getIntExtra("key_request_code", Integer.MIN_VALUE);
        }
        setCheckoutListener(context, cJRRechargePayment, wVar, str4);
        setSubventionListener(context, str4, wVar);
        if (context instanceof Activity) {
            resolveIntentByMainApp((Activity) context, intent, "checkout", i2);
        }
    }

    private void setSubventionListener(final Context context, final String str, final w wVar) {
        this.subventionProvider = new ISubventionProvider() {
            public void getBanks(ISubventionProvider.IBankListener iBankListener) {
                new MallPGHelper().getBanks(iBankListener, str, wVar);
            }

            public void fetchTenures(BankData bankData, ArrayList<PaymentIntent> arrayList, JSONObject jSONObject, ISubventionProvider.IBankTenureListener iBankTenureListener) {
                new MallPGHelper().fetchTenures(bankData, arrayList, jSONObject, iBankTenureListener, str, context, wVar);
            }

            public void validateTenure(String str, String str2, ISubventionProvider.IBankValidator iBankValidator, ArrayList<PaymentIntent> arrayList, JSONObject jSONObject) {
                new MallPGHelper().validateTenurePlan(str, str2, iBankValidator, arrayList, jSONObject, str, wVar);
            }

            public void showBottomSheet(Context context, String str, Double d2, String str2) {
                new MallPGHelper().showBottomSheet(context, str, d2, str2);
            }
        };
    }

    private boolean isBankOffer(String str) {
        return Boolean.parseBoolean(str);
    }

    private void setCheckoutListener(Context context, CJRRechargePayment cJRRechargePayment, w wVar, String str) {
        final Context context2 = context;
        final CJRRechargePayment cJRRechargePayment2 = cJRRechargePayment;
        final w wVar2 = wVar;
        final String str2 = str;
        this.checkoutListener = new PaytmSDKRequestClient() {
            public void createOrderInfoFragment(PaytmSDKRequestClient.ShowOrderInfoFragment showOrderInfoFragment, Object obj) {
            }

            public boolean isConvFeeEnabled() {
                return false;
            }

            public void verifyCart(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
            }

            public void doCheckout(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
                new MallPGHelper().doCheckout(context2, callbackData, onCheckoutResponse, cJRRechargePayment2, wVar2);
            }

            public void applyAnotherOffer(final PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
                JarvisHelper.this.removePaymentIntent(str2, wVar2, new PaytmSDKRequestClient.OtherPayOptionsListener() {
                    public void setFetchPayOptionsResponse(CJPayMethodResponse cJPayMethodResponse, double d2) {
                        PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener = applyAnotherOfferListener;
                        if (applyAnotherOfferListener != null) {
                            applyAnotherOfferListener.onSuccess();
                        }
                    }

                    public void onError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                        PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener = applyAnotherOfferListener;
                        if (applyAnotherOfferListener != null) {
                            applyAnotherOfferListener.onError(apiResponseError);
                        }
                    }
                }, false);
            }

            public void onOtherPayModeSelected(boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
                JarvisHelper.this.removePaymentIntent(MallPGHelper.getEMIApplyPromoUrl(str2), wVar2, otherPayOptionsListener, true);
            }
        };
    }

    /* access modifiers changed from: private */
    public void removePaymentIntent(String str, w wVar, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener, boolean z) {
        new MallPGHelper().removePaymentIntent(str, wVar, otherPayOptionsListener, z);
    }

    public void handleErrorCall(Activity activity, VolleyError volleyError, String str, Bundle bundle, String str2) {
        r.a(activity, (Exception) volleyError, str, bundle);
    }

    public void handleErrorReport(Activity activity, VolleyError volleyError, String str) {
        l.a((Context) activity, volleyError, str);
    }

    public boolean isWhiteListedURL(String str, Context context) {
        net.one97.paytm.j.c.a();
        return b.a(net.one97.paytm.j.c.F(), str);
    }

    public boolean checkDeepLinking(Activity activity, String str) {
        h.a aVar = h.f50349a;
        return h.a.a(activity, str, (Bundle) null);
    }

    public void getDeviceInfoDetails(Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.a(map, context);
    }

    public Exception getCropError(Object obj) {
        if (obj instanceof CropImage.ActivityResult) {
            return ((CropImage.ActivityResult) obj).f52933c;
        }
        return null;
    }

    public Class<?> getSearchActivity() {
        return AJRSearchActivity.class;
    }

    public HashMap<String, Object> getSearchMap() {
        return net.one97.paytm.marketplace.a.k();
    }

    public void setSearchMap(HashMap<String, Object> hashMap) {
        net.one97.paytm.marketplace.a.b(hashMap);
    }

    public void openPromoListActivity(Activity activity, HashMap<String, Object> hashMap, w wVar) {
        CJRCartProduct cJRCartProduct;
        HashMap<String, Object> hashMap2 = hashMap;
        if (hashMap2 != null && hashMap2.get("item") != null && (cJRCartProduct = (CJRCartProduct) com.paytmmall.artifact.e.a.a(hashMap2.get("item").toString(), CJRCartProduct.class)) != null) {
            String constructUrl = constructUrl(cJRCartProduct.getOffersUrl());
            String productId = cJRCartProduct.getProductId();
            String price = cJRCartProduct.getPrice();
            String stringParam = getStringParam(hashMap2, "mid");
            boolean parseBoolean = Boolean.parseBoolean(getStringParam(hashMap2, "is_freebie"));
            String stringParam2 = getStringParam(hashMap2, "promoData");
            String stringParam3 = getStringParam(hashMap2, "offerApplyUrl");
            int count = getCount("offerCountObject");
            if (parseBoolean || isValidData(constructUrl, productId, price)) {
                new MallPGHelper().openPromoListActivity(activity, constructUrl, productId, Double.valueOf(price).doubleValue(), stringParam, wVar, cJRCartProduct, parseBoolean, stringParam2, stringParam3, count, cJRCartProduct);
            }
        }
    }

    private String getStringParam(HashMap<String, Object> hashMap, String str) {
        return hashMap.containsKey(str) ? String.valueOf(hashMap.get(str)) : "";
    }

    private int getCount(String str) {
        try {
            return new JSONObject(str).optInt("itemCount");
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return 0;
        }
    }

    public void applyManualPromo(Activity activity, HashMap<String, Object> hashMap, w wVar) {
        String valueOf = String.valueOf(hashMap.get("offerApplyUrl"));
        String valueOf2 = String.valueOf(hashMap.get(Utility.EVENT_CATEGORY_PROMOCODE));
        boolean parseBoolean = Boolean.parseBoolean(String.valueOf(hashMap.get("is_payment_intent_required")));
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
            new MallPGHelper().applyManualPromo(activity, valueOf, valueOf2, wVar, parseBoolean);
        }
    }

    public boolean setPaymentInstruments(String str, w wVar) {
        CJPayMethodResponse cJPayMethodResponse = (CJPayMethodResponse) new f().a(str, CJPayMethodResponse.class);
        boolean z = cJPayMethodResponse != null;
        if (z) {
            PaytmSDK.setServer(Server.PRODUCTION);
            PaytmSDK.setResponse(cJPayMethodResponse, (VpaFetch) null);
        } else {
            MallPGHelper.handleInvalidInstrument(wVar);
        }
        return z;
    }

    public boolean isNativeIntentPresent() {
        return MallPGHelper.isPaymentIntentPresent();
    }

    public void resetNativeIntent() {
        MallPGHelper.resetPaymentIntent();
    }

    private boolean isValidData(String str, String str2, String str3) {
        return URLUtil.isValidUrl(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3);
    }

    private String constructUrl(String str) {
        return com.paytm.utility.c.b("https://apiproxy.paytm.com/papi".concat(String.valueOf(str)), getApplicationContext());
    }

    /* access modifiers changed from: package-private */
    public PaytmSDKRequestClient getCheckoutListener() {
        return this.checkoutListener;
    }

    /* access modifiers changed from: package-private */
    public ISubventionProvider getSubventionProvider() {
        return this.subventionProvider;
    }

    public void openImageCropActivity(Activity activity, boolean z, boolean z2) {
        CropImage.a((Uri) null).a(CropImageView.c.ON).a(activity, z, z2);
    }

    public void sendErrorAnalyticsLogs(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            au.e eVar = (au.e) new f().a(str, au.e.class);
            if (z) {
                net.one97.paytm.q.b.a(eVar, au.c.ApiLog);
            } else {
                net.one97.paytm.q.b.a(eVar, au.c.ApiError);
            }
        }
    }

    public boolean isProductAlreadyInWishList(Context context, String str) {
        return net.one97.paytm.marketplace.a.a(context, str);
    }

    public void setWishList(Context context) {
        net.one97.paytm.marketplace.a.e(context);
    }

    public String getURL(String str, String str2) {
        return net.one97.paytm.marketplace.a.d(str, str2);
    }

    public ICLPCommunicationListener getCLPCommunicationListener() {
        return new net.one97.paytm.q.a();
    }

    private void saveRecentlyViewed(Context context) {
        if (this.recentlyViewedCache != null) {
            v.a().c(context, new f().b(this.recentlyViewedCache));
        }
    }

    private com.paytmmall.artifact.common.entity.CJRHomePageItem getRecentlyViewItem(CJRDetailProduct cJRDetailProduct) {
        try {
            com.paytmmall.artifact.common.entity.CJRHomePageItem cJRHomePageItem = new com.paytmmall.artifact.common.entity.CJRHomePageItem();
            cJRHomePageItem.setName(cJRDetailProduct.getmProductName());
            String str = cJRDetailProduct.getparentID();
            if (str == null) {
                str = cJRDetailProduct.getmProductID();
            }
            cJRHomePageItem.setItemID(String.valueOf(str));
            cJRHomePageItem.setImageUrl(cJRDetailProduct.getImageUrl());
            cJRHomePageItem.setUrl(cJRDetailProduct.getmUrl());
            cJRHomePageItem.setUrlType("product");
            return cJRHomePageItem;
        } catch (Exception unused) {
            return null;
        }
    }

    public ArrayList<CJRItem> getRecentlyViewedItems() {
        this.recentlyViewedCache = new ArrayList<>();
        syncRecentlyViewedCache();
        return this.recentlyViewedCache;
    }

    public void syncRecentlyViewedCache() {
        try {
            Iterator it2 = ((ArrayList) new com.google.gsonhtcfix.f().a(v.a().a("recentProducts"), new com.google.gsonhtcfix.c.a<ArrayList<CJRDetailProduct>>() {
            }.getType())).iterator();
            while (it2.hasNext()) {
                this.recentlyViewedCache.add(getRecentlyViewItem((CJRDetailProduct) it2.next()));
            }
        } catch (Exception e2) {
            s.a(e2);
        }
    }

    public ArrayList<CJRItem> getCachedRecentlyViewedResponse(Context context) {
        String a2 = v.a().a("recentProducts");
        if (!TextUtils.isEmpty(a2)) {
            return (ArrayList) new f().a(a2, new com.google.gson.b.a<List<Item>>() {
            }.getType());
        }
        return null;
    }

    public Class<? extends Activity> getIntentClass(Activity activity, String str) {
        try {
            return getClassFromPaytm(activity, str);
        } catch (IllegalArgumentException e2) {
            Toast.makeText(activity, str + "Missing", 0).show();
            q.b(e2.getMessage());
            return null;
        }
    }

    public void handleLink(Activity activity, String str) {
        CJRHomePageItem a2 = net.one97.paytm.utils.c.a((Context) activity, str);
        if (a2 != null && !TextUtils.isEmpty(a2.getDeeplink())) {
            h.a aVar = h.f50349a;
            h.a.a(activity, a2.getDeeplink(), (Bundle) null);
        }
    }

    public void setShoppingCart(String str) {
        CJRCartResponse cJRCartResponse;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
            CartUtils.setCartItem(str);
            try {
                cJRCartResponse = (CJRCartResponse) new f().a(str, CJRCartResponse.class);
            } catch (Exception unused) {
                cJRCartResponse = null;
            }
            if (cJRCartResponse != null && cJRCartResponse.getCart() != null) {
                net.one97.paytm.utils.t.b(CJRJarvisApplication.getAppContext(), String.valueOf(cJRCartResponse.getCart().getOrderTotal()));
            }
        }
    }

    public Object getFetchValueKeysProvider() {
        try {
            return Class.forName("net.one97.paytm.phoenix.provider.PhoenixFetchValuesForKeysProvider").getConstructor(new Class[]{String.class}).newInstance(new Object[]{"ddbase"});
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return null;
        } catch (InstantiationException e3) {
            q.b(e3.getMessage());
            return null;
        } catch (InvocationTargetException e4) {
            q.b(e4.getMessage());
            return null;
        } catch (NoSuchMethodException e5) {
            q.b(e5.getMessage());
            return null;
        } catch (IllegalAccessException e6) {
            q.b(e6.getMessage());
            return null;
        }
    }

    public String getStringValue(String str, String str2) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, str2);
    }

    public int getInt(String str, int i2) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, i2);
    }

    public boolean getBooleanValue(String str, boolean z) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public String getBuildConstant(String str) throws IllegalArgumentException {
        if (getConstantMap().containsKey(str)) {
            return getConstantMap().get(str);
        }
        throw new IllegalArgumentException(getMissingKeys((Activity) null, this.buildConfigConstants, getConstantMap().keySet()));
    }

    public void generateSmartLink(Context context, Map<String, String> map, String str) {
        if (map != null) {
            try {
                String str2 = map.get("af_dp");
                if (!TextUtils.isEmpty(str2)) {
                    map.put("af_dp", URLDecoder.decode(str2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
                }
            } catch (UnsupportedEncodingException e2) {
                q.b(e2.getMessage());
            }
            net.one97.paytm.utils.m mVar = net.one97.paytm.utils.m.f69757a;
            net.one97.paytm.utils.m.a(context, "whatsapp", (HashMap) map, this.generateShortUrl, 0);
        }
    }

    public boolean isStagingApp() {
        return net.one97.paytm.verifier.a.c.a();
    }

    public void clearSessionData(Activity activity) {
        if (activity != null) {
            net.one97.paytm.auth.b.b.a(activity, false);
            net.one97.paytm.utils.w.c(activity);
        }
    }
}
