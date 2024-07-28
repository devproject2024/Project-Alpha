package net.one97.paytm.j;

import android.text.TextUtils;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.google.gson.f;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.MockUrlActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.appManager.a;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f51019a;

    /* renamed from: b  reason: collision with root package name */
    private static String f51020b = c.class.getSimpleName();

    public static c a() {
        if (f51019a == null) {
            synchronized (c.class) {
                if (f51019a == null) {
                    f51019a = new c();
                }
            }
        }
        return f51019a;
    }

    private static Object a(String str, Object obj) {
        JSONArray a2 = MockUrlActivity.a(CJRJarvisApplication.getAppContext());
        if (a2.length() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= a2.length()) {
                    break;
                }
                try {
                    JSONObject jSONObject = a2.getJSONObject(i2);
                    boolean equals = jSONObject.getString("rule_type").equals("String Replacement");
                    String string = jSONObject.getString("search_pattern");
                    String string2 = jSONObject.getString("replacement_pattern");
                    if (jSONObject.getBoolean(StringSet.is_muted)) {
                        StringBuilder sb = new StringBuilder("MockUrlActivity : URL ");
                        sb.append(string);
                        sb.append(" rule is muted. Not executing it");
                    } else if (equals && (obj instanceof String)) {
                        String str2 = (String) obj;
                        if (str2.contains(string)) {
                            if (jSONObject.getBoolean("is_full_replacement")) {
                                obj = string2;
                            } else {
                                obj = str2.replaceFirst(string, string2);
                            }
                            StringBuilder sb2 = new StringBuilder("MockUrlActivity : URL replacement successful. Replacing ");
                            sb2.append(string);
                            sb2.append(" with ");
                            sb2.append(string2);
                        }
                    } else if (str.equals(string)) {
                        if (obj instanceof String) {
                            obj = string2;
                        } else if (obj instanceof Boolean) {
                            obj = Boolean.valueOf(Boolean.parseBoolean(string2));
                        } else if (obj instanceof Integer) {
                            obj = Integer.valueOf(Integer.parseInt(string2));
                        } else if (obj instanceof Long) {
                            obj = Long.valueOf(Long.parseLong(string2));
                        } else if (obj instanceof Float) {
                            obj = Float.valueOf(Float.parseFloat(string2));
                        } else if (obj instanceof Double) {
                            obj = Double.valueOf(Double.parseDouble(string2));
                        }
                        StringBuilder sb3 = new StringBuilder("MockUrlActivity : GTM value override successful. Returning ");
                        sb3.append(string2);
                        sb3.append("for ");
                        sb3.append(string);
                    }
                } catch (JSONException e2) {
                    e2.getMessage();
                }
                i2++;
            }
        }
        return obj;
    }

    public static String a(String str) {
        return a(str, (String) null);
    }

    public static String a(String str, String str2) {
        return CJRJarvisApplication.o().a(str, str2);
    }

    public static boolean a(String str, boolean z) {
        a o = CJRJarvisApplication.o();
        Boolean valueOf = Boolean.valueOf(z);
        k.c(str, "key");
        return o.c().a(str, valueOf).booleanValue();
    }

    public static int b(String str) {
        return a(str, 0);
    }

    public static int a(String str, int i2) {
        return CJRJarvisApplication.o().a(str, Integer.valueOf(i2)).intValue();
    }

    public static long a(String str, long j) {
        return CJRJarvisApplication.o().a(str, Long.valueOf(j)).longValue();
    }

    public static boolean k() {
        return a("showCarousal", false);
    }

    public static String c(String str) {
        String a2 = a("paymentHeaderText", "");
        return TextUtils.isEmpty(a2) ? str : a2;
    }

    public static String a(String str, String str2, boolean z) {
        return "https://standinginstruction.paytmbank.com/si/ext/v1/update/markAsPaid?siId=" + str + "&siType=" + str2 + "&markAsPaid=" + z;
    }

    public static boolean ab() {
        return a("feed_sheroes_login", false);
    }

    public final Map<String, String> ad() {
        try {
            return (Map) new f().a(a("h5_vertical_ids", ""), new com.google.gson.b.a<Map<String, String>>() {
            }.getType());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public final Map<String, String> ae() {
        try {
            return (Map) new f().a(a("h5_vertical_ids_v2", ""), new com.google.gson.b.a<Map<String, String>>() {
            }.getType());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public final List<String> d(String str) {
        try {
            return (List) new f().a(a(str, ""), new com.google.gson.b.a<List<String>>() {
            }.getType());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static boolean af() {
        a();
        return a("enableCSTReactFlow", false);
    }

    public static String ag() {
        return a("h5_trustlogin_url", "");
    }

    public static String ah() {
        return a("h5_get_consent", "https://miniapps.paytm.com/h5/user/v1/getConsent");
    }

    public static String ai() {
        return a("h5_save_consent", "https://miniapps.paytm.com/h5/user/v1/saveConsent");
    }

    public static String aj() {
        return a("h5_openid_url", "");
    }

    public static String ak() {
        return a("h5_partner_apps_url", "");
    }

    public static String e(String str) {
        return a(str, "https://miniapps.paytm.com/h5/v1/user/app");
    }

    public final Map<String, String> f(String str) {
        try {
            return (Map) new f().a(a(str, "{\"app_details\":\"https://miniapps.paytm.com/h5/v2/merchant/onboarding/app\"}"), new com.google.gson.b.a<Map<String, String>>() {
            }.getType());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String al() {
        return a("h5_app_listing_file", "");
    }

    public static String am() {
        return a("pm_lite_app_url", "");
    }

    public static boolean an() {
        return a("isPMLiteOn", true);
    }

    public static Integer ap() {
        return Integer.valueOf(a("in_app_user_consent_count", 5));
    }

    public static String aq() {
        return a("prePaymentNotification", "");
    }

    public static String ar() {
        return a("myoder_h5page_url", "paytmmp://mini-app?aId=d03b0f5439f03985d38c15eb56bb491f25b6b12d&data=eyJzcGFyYW1zIjp7ImNhblB1bGxEb3duIjpmYWxzZSwicHVsbFJlZnJlc2giOmZhbHNlLCJzaG93VGl0bGVCYXIiOmZhbHNlfX0=&url=https://paytm.com/myorders");
    }

    public static String b() {
        return a("searchurl_v2", (String) null);
    }

    public static String c() {
        return a("addressesV2", (String) null);
    }

    public static String d() {
        return a("orderdetail", (String) null);
    }

    public static String e() {
        return a("newPostOrderURL", (String) null);
    }

    public static String f() {
        return a(UpiConstantServiceApi.KEY_TOKEN, (String) null);
    }

    public static String g() {
        return a("leadAPIOnAppLaunch", (String) null);
    }

    public static String h() {
        if (TextUtils.isEmpty(a("insuranceOrderSummary", (String) null))) {
            return a("orderdetail", (String) null);
        }
        return a("insuranceOrderSummary", (String) null);
    }

    public static String i() {
        return a("DeleteCard", (String) null);
    }

    public static String j() {
        return a("SavedCard", (String) null);
    }

    public final Map<String, Map<String, String>> l() {
        try {
            return (Map) new f().a(a("unknow_url_message_map", (String) null), new com.google.gson.b.a<HashMap<String, HashMap<String, String>>>() {
            }.getType());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static List<String> m() {
        try {
            String a2 = a("utilityVerticals", (String) null);
            if (TextUtils.isEmpty(a2)) {
                return new ArrayList(0);
            }
            return Arrays.asList((String[]) new f().a(a2, String[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static List<String> n() {
        try {
            String a2 = a("goldDeeplinkWhitelist", (String) null);
            if (TextUtils.isEmpty(a2)) {
                a2 = a("goldDeeplinkWhitelist", (String) null);
            }
            if (TextUtils.isEmpty(a2)) {
                return new ArrayList(0);
            }
            return Arrays.asList((String[]) new f().a(a2, String[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static String o() {
        return a("getBankList", (String) null);
    }

    public static String p() {
        return a(UpiConstantServiceApi.KEY_GET_BANK, (String) null);
    }

    public static String q() {
        return a("loanLeadCallbackUrl", (String) null);
    }

    public static String r() {
        return a("loanLeadXToken", (String) null);
    }

    public static String s() {
        return a("loanLeadSolutionType", (String) null);
    }

    public static String t() {
        String a2 = a("flyoutCatalogUrl_v2", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            return a2.trim();
        }
        return null;
    }

    public static String u() {
        return a("obdCallMerchantUrl", (String) null);
    }

    public static String v() {
        return a("categorymap", (String) null);
    }

    public static String w() {
        return a(PaymentsGTMConstants.USER_DETAILS, (String) null);
    }

    public static String x() {
        return a("check_user_balance_service", (String) null);
    }

    public static List<String> y() {
        try {
            String a2 = a("pfa_description_text", (String) null);
            if (TextUtils.isEmpty(a2)) {
                return new ArrayList(0);
            }
            return Arrays.asList((String[]) new f().a(a2, String[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static String z() {
        return a("base_url_golden_gate", (String) null);
    }

    public static String A() {
        return a("base_url_kyc", (String) null);
    }

    public static String B() {
        return a("base_url_auth", (String) null);
    }

    public static String C() {
        return a("base_url_wallet", (String) null);
    }

    public static List<Long> D() {
        try {
            String a2 = a("cstNveVerticals", (String) null);
            if (TextUtils.isEmpty(a2)) {
                return new ArrayList(0);
            }
            return Arrays.asList((Long[]) new f().a(a2, Long[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static List<String> E() {
        try {
            String a2 = a("whiteListedWebViewDomain", (String) null);
            if (TextUtils.isEmpty(a2)) {
                return new ArrayList(0);
            }
            return Arrays.asList((String[]) new f().a(a2, String[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static List<String> F() {
        try {
            String a2 = a("whiteListedDeeplinkUrls", (String) null);
            if (TextUtils.isEmpty(a2)) {
                return new ArrayList(0);
            }
            return Arrays.asList((String[]) new f().a(a2, String[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static List<String> G() {
        try {
            String a2 = a("cstNveVerticals", (String) null);
            if (TextUtils.isEmpty(a2)) {
                return new ArrayList(0);
            }
            return Arrays.asList((String[]) new f().a(a2, String[].class));
        } catch (Exception unused) {
            return new ArrayList(0);
        }
    }

    public static String H() {
        return a("offline_pg_merchant_transaction_status_URL", (String) null);
    }

    public static String I() {
        return a("upi_pop_up_logic", (String) null);
    }

    public static String J() {
        return a("saving_acc_interest", (String) null);
    }

    public static String K() {
        return a("pp_accounts_v3_url", (String) null);
    }

    public static String L() {
        return a("addBeneficiaryKYC", (String) null);
    }

    public static String M() {
        return a("validateBeneficiaryKYC", (String) null);
    }

    public static String N() {
        return a("editBeneficiaryKYC", (String) null);
    }

    public static String O() {
        return a("P2BBlockedStates", (String) null);
    }

    public static String P() {
        return a("verifier_do_view", (String) null);
    }

    public static String Q() {
        return TextUtils.isEmpty(a("feedCredentialsUrl", (String) null)) ? "https://accounts.paytm.com/oauth2/tpi/client/token?scope=BASIC" : a("feedCredentialsUrl", (String) null);
    }

    public static String R() {
        return a("errorSdkUrl", (String) null);
    }

    public static String S() {
        return a("edc_receipt_url", (String) null);
    }

    public static String T() {
        return a("feed_categories", (String) null);
    }

    public static String U() {
        return a("feed_post_feedback_tags", (String) null);
    }

    public static String V() {
        return a("feed_comment_feedback_tags", (String) null);
    }

    public static String W() {
        return a("feed_base_url", (String) null);
    }

    public static String X() {
        return a("feed_merchantdeal_base_url", (String) null);
    }

    public static String Y() {
        return a("feed_video_url", (String) null);
    }

    public static String Z() {
        return a("app_link_replacement_url_hp", (String) null);
    }

    public static String aa() {
        return a("app_link_replacement_url_grid", (String) null);
    }

    public static String ac() {
        return a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT, (String) null);
    }

    public static HashSet<String> ao() {
        try {
            String a2 = a("in_app_show_screen_names", (String) null);
            if (TextUtils.isEmpty(a2)) {
                return new HashSet<>(0);
            }
            return new HashSet<>(Arrays.asList((String[]) new f().a(a2, String[].class)));
        } catch (Exception unused) {
            return new HashSet<>(0);
        }
    }
}
