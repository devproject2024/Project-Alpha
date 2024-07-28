package com.paytmmall.artifact.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.utility.q;
import com.paytmmall.a.a;
import com.paytmmall.artifact.cart.entity.CJRAddress;
import com.paytmmall.artifact.d.c;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.s;
import com.paytmmall.artifact.d.t;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: d  reason: collision with root package name */
    private static String f15648d = "WebViewCommunicationListener";

    /* renamed from: a  reason: collision with root package name */
    Activity f15649a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f15650b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15651c = "mallCallback";

    public b(Activity activity, WebView webView) {
        this.f15649a = activity;
        this.f15650b = webView;
    }

    @JavascriptInterface
    public final String handleEvent(String str, String str2) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1732177575:
                if (str.equals("MYORDERS_CLICKED")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1671588758:
                if (str.equals("GRID_SEARCH_CLICK")) {
                    c2 = 18;
                    break;
                }
                break;
            case -1122042010:
                if (str.equals("CONTACTUS_CLICKED")) {
                    c2 = 7;
                    break;
                }
                break;
            case -956700996:
                if (str.equals("mpOpenPage")) {
                    c2 = 9;
                    break;
                }
                break;
            case -892837944:
                if (str.equals("mpSetGetKey")) {
                    c2 = 12;
                    break;
                }
                break;
            case -876217445:
                if (str.equals("USERNAME_EDIT_CLICKED")) {
                    c2 = 3;
                    break;
                }
                break;
            case -613569519:
                if (str.equals("SEARCH_CLICK")) {
                    c2 = 10;
                    break;
                }
                break;
            case -473318395:
                if (str.equals("SET_TAB_BAR_VISIBILITY")) {
                    c2 = 30;
                    break;
                }
                break;
            case -385519706:
                if (str.equals("SEND_MAP_ONLY")) {
                    c2 = 13;
                    break;
                }
                break;
            case -331012208:
                if (str.equals("NOTIFICATIONS_CLICKED")) {
                    c2 = 5;
                    break;
                }
                break;
            case -188287160:
                if (str.equals("CHOOSE_LANGUAGE_CLICKED")) {
                    c2 = 25;
                    break;
                }
                break;
            case -179023086:
                if (str.equals("CHANGE_PASSWORD_CLICKED")) {
                    c2 = 24;
                    break;
                }
                break;
            case -161774901:
                if (str.equals("BACK_PRESS")) {
                    c2 = 1;
                    break;
                }
                break;
            case -101111838:
                if (str.equals("TRACK_ORDER_CLICKED")) {
                    c2 = 11;
                    break;
                }
                break;
            case -35485521:
                if (str.equals("DEBUG_SETTINGS")) {
                    c2 = 0;
                    break;
                }
                break;
            case 18558767:
                if (str.equals("PAYTM_ASSIST_CLICKED")) {
                    c2 = 27;
                    break;
                }
                break;
            case 200425995:
                if (str.equals("MANAGE_APP_LOCK_CLICKED")) {
                    c2 = 26;
                    break;
                }
                break;
            case 368948223:
                if (str.equals("SEND_EVENT_WITH_MAP")) {
                    c2 = 14;
                    break;
                }
                break;
            case 410146371:
                if (str.equals("LUCKYLIFAFA_CLICKED")) {
                    c2 = 19;
                    break;
                }
                break;
            case 507397939:
                if (str.equals("SAVED_CARDS_CLICKED")) {
                    c2 = 23;
                    break;
                }
                break;
            case 675269841:
                if (str.equals("INVITE_CLICKED")) {
                    c2 = 21;
                    break;
                }
                break;
            case 726032288:
                if (str.equals("PROFILE_BACK_PRESSED")) {
                    c2 = 17;
                    break;
                }
                break;
            case 1003181833:
                if (str.equals("GET_PROFILE_DATA")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1060984723:
                if (str.equals("LOG_OUT")) {
                    c2 = 28;
                    break;
                }
                break;
            case 1214184595:
                if (str.equals("mpOpenDeeplink")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1378230463:
                if (str.equals("NOTIFICATION_SETTINGS_CLICKED")) {
                    c2 = 22;
                    break;
                }
                break;
            case 1626067025:
                if (str.equals("DELIVERY_ADDRESS_CLICKED")) {
                    c2 = 20;
                    break;
                }
                break;
            case 1643743903:
                if (str.equals("EDIT_ADDRESS")) {
                    c2 = 29;
                    break;
                }
                break;
            case 1972468443:
                if (str.equals("HELP_CENTER_CLICKED")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1985819622:
                if (str.equals("GET_GA_DATA")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2006214101:
                if (str.equals("GET_USER_DATA")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 15:
            case 20:
            case 21:
                break;
            case 1:
                Activity activity = this.f15649a;
                if (activity != null && !activity.isFinishing()) {
                    this.f15649a.runOnUiThread(new Runnable() {
                        public final void run() {
                            b.this.f15649a.onBackPressed();
                        }
                    });
                    break;
                }
            case 2:
                if (this.f15649a != null) {
                    a.c();
                    break;
                }
                break;
            case 3:
                Activity activity2 = this.f15649a;
                if (!d.d((Context) activity2)) {
                    Intent intent = new Intent();
                    intent.putExtra("sign_in_sign_up_with_step_2", true);
                    if (!TextUtils.isEmpty((CharSequence) null)) {
                        intent.putExtra("sign_in_title", (String) null);
                    }
                    if (!TextUtils.isEmpty((CharSequence) null)) {
                        intent.putExtra("sign_up_title", (String) null);
                    }
                    intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
                    intent.putExtra("launchSignUp", false);
                    a(activity2, "authActivity", 111, intent);
                    break;
                } else {
                    a((Context) activity2, "edit_profile");
                    break;
                }
            case 4:
                com.paytmmall.artifact.common.a.b.b("/Help and Support", "profile", (Context) this.f15649a);
                a((Context) this.f15649a, "contact_us");
                break;
            case 5:
                t.e().resolveIntentByMainApp(this.f15649a, new Intent(), "notification", Integer.MIN_VALUE);
                break;
            case 6:
                f fVar = new f();
                if (d.d(t.e().getApplicationContext())) {
                    return fVar.b(c.l(t.e().getApplicationContext()));
                }
                return fVar.b(new HashMap());
            case 7:
                a((Context) this.f15649a, "contact_us");
                break;
            case 8:
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    if (this.f15649a != null) {
                        t.e().handleLink(this.f15649a, jSONObject2.getString("deeplink"));
                        break;
                    }
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                    break;
                }
                break;
            case 9:
                try {
                    JSONObject jSONObject3 = new JSONObject(str2);
                    if (this.f15649a != null) {
                        a.b(a.e() + jSONObject3.getString(H5TabbarUtils.MATCH_TYPE_PATH));
                        break;
                    }
                } catch (Exception e3) {
                    q.c(e3.getMessage());
                    break;
                }
                break;
            case 10:
                Activity activity3 = this.f15649a;
                if (activity3 != null) {
                    com.paytmmall.artifact.b.a(activity3);
                    break;
                }
                break;
            case 11:
                try {
                    new JSONObject(str2);
                    break;
                } catch (JSONException e4) {
                    q.b(e4.getMessage());
                    break;
                }
            case 12:
                return a(str2);
            case 13:
                try {
                    com.paytmmall.artifact.common.b.a.a.a(b(new JSONObject(str2).toString()));
                    break;
                } catch (Exception e5) {
                    s.a(e5);
                    break;
                }
            case 14:
                try {
                    JSONObject jSONObject4 = new JSONObject(str2);
                    com.paytmmall.artifact.common.b.a.a.a(String.valueOf(jSONObject4.get(AppConstants.NOTIFICATION_DETAILS.EVENT)), (Map) b(jSONObject4.toString()));
                    break;
                } catch (Exception e6) {
                    s.a(e6);
                    break;
                }
            case 16:
                try {
                    return new f().b(com.paytmmall.artifact.common.b.a.a.c());
                } catch (Exception e7) {
                    s.a(e7);
                    break;
                }
            case 17:
                this.f15649a.onBackPressed();
                break;
            case 18:
                com.paytmmall.artifact.b.a(this.f15649a);
                break;
            case 19:
                a.c();
                break;
            case 22:
                t.e().handleNotificationSettingsClick(this.f15649a);
                break;
            case 23:
                com.paytmmall.artifact.common.a.b.a((Context) this.f15649a, "wallet_profile", "saved_card_other_payment_option_clicked", "", "", "//profile", "wallet");
                t.e().resolveIntentByMainApp(this.f15649a, new Intent(), "saved_cards", Integer.MIN_VALUE);
                break;
            case 24:
                t.e().resolveIntentByMainApp(this.f15649a, new Intent(), "change_password", 619);
                break;
            case 25:
                Intent intent2 = new Intent();
                intent2.putExtra("from_profile", H5AppHandler.CHECK_VALUE);
                t.e().resolveIntentByMainApp(this.f15649a, intent2, "language", 112);
                break;
            case 26:
                t.e().resolveIntentByMainApp(this.f15649a, new Intent(), "applock", 207);
                break;
            case 27:
                t.e().resolveIntentByMainApp(this.f15649a, new Intent(), "paytm_assist", Integer.MIN_VALUE);
                break;
            case 28:
                com.paytmmall.a.b.b.a(this.f15649a);
                t.e().launchHome(this.f15649a, (Intent) null);
                break;
            case 29:
                try {
                    jSONObject = new JSONObject(String.valueOf(str2));
                } catch (JSONException e8) {
                    q.b(e8.getMessage());
                    jSONObject = null;
                }
                boolean parseBoolean = Boolean.parseBoolean(String.valueOf(jSONObject.opt("isEdit")));
                String valueOf = String.valueOf(jSONObject.opt(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS));
                if (parseBoolean && !TextUtils.isEmpty(valueOf) && !valueOf.equals("null") && !valueOf.equals("{}")) {
                    com.paytmmall.artifact.e.a.a(valueOf, CJRAddress.class);
                    break;
                }
            case 30:
                if (t.e().isMallApp()) {
                    Type type = new com.google.gson.b.a<HashMap<String, Object>>() {
                    }.getType();
                    Activity activity4 = this.f15649a;
                    HashMap hashMap = (HashMap) new f().a(str2, type);
                    View tabView = t.e().getTabView(activity4);
                    if (!(tabView == null || hashMap == null || !hashMap.containsKey("visible"))) {
                        try {
                            activity4.runOnUiThread(new Runnable(tabView, Boolean.parseBoolean(String.valueOf(hashMap.get("visible")))) {
                                private final /* synthetic */ View f$1;
                                private final /* synthetic */ boolean f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void run() {
                                    b.this.a(this.f$1, this.f$2);
                                }
                            });
                            break;
                        } catch (Exception e9) {
                            q.c(e9.getMessage());
                            break;
                        }
                    }
                }
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" Doesnot Exist");
                boolean z = c.f15691a;
                break;
        }
        return "";
    }

    private String a(String str) {
        try {
            HashMap hashMap = (HashMap) new f().a(str, new com.google.gson.b.a<HashMap<String, Object>>() {
            }.getType());
            String valueOf = String.valueOf(hashMap.get("action"));
            char c2 = 65535;
            int hashCode = valueOf.hashCode();
            if (hashCode != -934610812) {
                if (hashCode != 102230) {
                    if (hashCode == 113762) {
                        if (valueOf.equals("set")) {
                            c2 = 1;
                        }
                    }
                } else if (valueOf.equals("get")) {
                    c2 = 0;
                }
            } else if (valueOf.equals("remove")) {
                c2 = 2;
            }
            if (c2 == 0) {
                return e(a((HashMap<String, Object>) hashMap));
            }
            if (c2 == 1) {
                return d(a((HashMap<String, Object>) hashMap));
            }
            if (c2 != 2) {
                return "";
            }
            return c(a((HashMap<String, Object>) hashMap));
        } catch (Exception e2) {
            s.a(e2);
            return "";
        }
    }

    private static String a(HashMap<String, Object> hashMap) {
        return new f().b(hashMap.get("data"));
    }

    private HashMap b(String str) {
        return (HashMap) new f().a(str, new com.google.gson.b.a<HashMap<String, Object>>() {
        }.getType());
    }

    private static void a(Context context, String str) {
        a(context, str, Integer.MIN_VALUE, new Intent());
    }

    private static void a(Context context, String str, int i2, Intent intent) {
        if (context instanceof Activity) {
            t.e().resolveIntentByMainApp((Activity) context, intent, str, i2);
        }
    }

    private String c(String str) {
        try {
            return com.paytmmall.a.a.c.a(this.f15649a, (JSONArray) new JSONObject(str).opt("keys")).toString();
        } catch (Exception e2) {
            s.a(e2);
            return "";
        }
    }

    private String d(String str) {
        try {
            com.paytmmall.a.a.c.a(this.f15649a, new JSONObject(str).optJSONObject("keys"));
            return "";
        } catch (Exception e2) {
            s.a(e2);
            return "";
        }
    }

    private String e(String str) {
        try {
            return com.paytmmall.a.a.c.b(this.f15649a, new JSONObject(str).optJSONArray("keys")).toString();
        } catch (Exception e2) {
            s.a(e2);
            return "";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z) {
        if (view.getVisibility() == 8 && z) {
            view.setVisibility(0);
        } else if (view.getVisibility() == 0 && !z) {
            view.setVisibility(8);
        }
    }
}
