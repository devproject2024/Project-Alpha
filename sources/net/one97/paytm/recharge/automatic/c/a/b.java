package net.one97.paytm.recharge.automatic.c.a;

import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.c.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f60258a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static net.one97.paytm.recharge.automatic.c.b f60259b = ((net.one97.paytm.recharge.automatic.c.b) d.f60261b.getValue());

    static {
        d dVar = d.f60262c;
    }

    private b() {
    }

    public static String a() {
        String a2 = f60259b.a("automatic_status_update_api");
        return a2 == null ? "https://digitalproxy.paytm.com/subscription/v1/subscriber/statusupdate" : a2;
    }

    public static String b() {
        return f60259b.a("frequentOrdersAndroid");
    }

    public static String c() {
        return f60259b.a("orderdetail");
    }

    public static String d() {
        return f60259b.a("updated_auto_subscription_url");
    }

    public static String e() {
        String a2 = f60259b.a("updated_auto_subscription_url");
        return a2 == null ? "" : a2;
    }

    public static String f() {
        String a2 = f60259b.a("automatic_create_subscription_api");
        return a2 == null ? "https://apiproxy.paytm.com/subscription/v1/subscribe" : a2;
    }

    public static String g() {
        String a2 = f60259b.a("automatic_fetch_payment_option_api");
        return a2 == null ? "https://securegw.paytm.in/fetchPaymentOptions" : a2;
    }

    public static boolean h() {
        return f60259b.a("is_automatic_debit_card_allowed", false);
    }

    public static String i() {
        return f60259b.a("fetch_subscription_cards");
    }

    public static String j() {
        return f60259b.a("credit_card_fetch_bin_api_v2");
    }

    public static String k() {
        String a2 = f60259b.a("ruFetchPPBLBalance");
        return TextUtils.isEmpty(a2) ? "https://securegw.paytm.in/userAsset/fetchBalanceInfo" : a2;
    }

    public static String l() {
        String a2 = f60259b.a("automatic_fetch_categories_api");
        return a2 == null ? "https://storefront.paytm.com/v1/h/automatic-flow" : a2;
    }

    public static ArrayList<String> m() {
        ArrayList<String> arrayList = new ArrayList<>();
        String a2 = f60259b.a("key_automatic_not_supported_card_list");
        if (TextUtils.isEmpty(a2)) {
            a2 = "[DINERS]";
        }
        try {
            Object a3 = new f().a(a2, new a().getType());
            k.a(a3, "Gson().fromJson(jsonResp…List<String>>() {}.type )");
            return (ArrayList) a3;
        } catch (Exception unused) {
            return arrayList;
        }
    }

    public static final class a extends com.google.gsonhtcfix.c.a<ArrayList<String>> {
        a() {
        }
    }

    public static String n() {
        String a2 = f60259b.a("automatic_save_bill_name_api");
        if (TextUtils.isEmpty(a2)) {
            return "https://digitalproxy.paytm.com/subscription/v1/subscriber/update";
        }
        if (a2 == null) {
            k.a();
        }
        return a2;
    }

    public static int o() {
        return f60259b.a("automatic_list_items", 32);
    }

    public static String p() {
        return f60259b.a("goldOnBoardingURL");
    }

    public static String a(String str, String str2) {
        return f60259b.a("processTxnAddMoneyURL") + "?mid=" + str + "&orderId=" + str2;
    }

    public static ArrayList<String> q() {
        ArrayList<String> arrayList = new ArrayList<>();
        String a2 = f60259b.a("popular_e_mandate_bank_list");
        if (TextUtils.isEmpty(a2)) {
            a2 = "[\"AXIS\",\"HDFC\",\"ICICI\",\"PNB\",\"SBI\",\"YES\"]";
        }
        try {
            Object a3 = new f().a(a2, new C1162b().getType());
            k.a(a3, "com.google.gsonhtcfix.Gs…List<String>>() {}.type )");
            return (ArrayList) a3;
        } catch (Exception unused) {
            return arrayList;
        }
    }

    /* renamed from: net.one97.paytm.recharge.automatic.c.a.b$b  reason: collision with other inner class name */
    public static final class C1162b extends com.google.gsonhtcfix.c.a<ArrayList<String>> {
        C1162b() {
        }
    }

    public static int r() {
        return f60259b.a("automatic_subscription_response_reset", 60000);
    }

    public static String s() {
        String a2 = f60259b.a("h5_ott_subscription_url", "");
        if (TextUtils.isEmpty(a2)) {
            return p.a("release", SDKConstants.KEY_STAGING_API, true) ? "https://staging.paytm.com/ott/v1/index.html" : "https://paytm.com/ott/v1/index.html";
        }
        return a2;
    }
}
