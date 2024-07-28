package net.one97.paytm.moneytransfer.d;

import com.google.gson.f;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.upi.util.UpiConstantServiceApi;

public final class c {
    public static final a C = new a((byte) 0);
    /* access modifiers changed from: private */
    public static c Z;
    public final String A = UpiConstantServiceApi.GTM_KEY_REFERRAL_DEEPLINK;
    public final String B = "isIntermediateInviteScreenEnabled";
    private final String D = "universal_money_transfer_promo_text";
    private final String E = "universal_money_transfer_promo_text_new";
    private final String F = UpiConstantServiceApi.GTM_KEY_BANK_TRANSFER_INVITE_URL;
    private final String G = "auto_add_upi_beneficiary";
    private final String H = UpiConstantServiceApi.GTM_KEY_ENABLE_UPI_TRANSACTION_STATUS_POLLING;
    private final String I = "enable_upi_pay_request_dialog";
    private final String J = "enable_cheque_book_scan";
    private final String K = UpiConstantServiceApi.GTM_KEY_UPI_TRANSACTION_STATUS_POLLING_LIMIT;
    private final String L = "upi_pop_up_logic";
    private final String M = "upi_icici_max_limit";
    private final String N = "do_show_non_default_bank";
    private final String O = "enable_wallet_for_mt";
    private final String P = "ppb_initiateImps";
    private final String Q = "mt_bank_name_mandatory";
    private final String R = "upi_cashback_generate";
    private final String S = "upi_cashback_eligibility";
    private final String T = "icaEnabled";
    private final String U = "editBeneficiaryKYC";
    private final String V = "validateBeneficiaryKYC";
    private final String W = "mt_v4_order_widget";
    private final String X = "syncContactConcentPageURL";
    private final String Y = "gallery_scan_popup_enabled";

    /* renamed from: a  reason: collision with root package name */
    public final String f53986a = "universal_money_transfer_promo_text_new_8_2_8";

    /* renamed from: b  reason: collision with root package name */
    public final String f53987b = "bank_transfer_offers";

    /* renamed from: c  reason: collision with root package name */
    public final String f53988c = "upi_retry_error_codes";

    /* renamed from: d  reason: collision with root package name */
    public final String f53989d = UpiConstantServiceApi.GTM_KEY_BANK_TRANSFER_INVITE_TEXT;

    /* renamed from: e  reason: collision with root package name */
    public final String f53990e = "ppb_funds_transfer";

    /* renamed from: f  reason: collision with root package name */
    public final String f53991f = "upi_id_tags";

    /* renamed from: g  reason: collision with root package name */
    public final String f53992g = UpiConstantServiceApi.GTM_KEY_UPI_CASHBACK_BASE_URL;

    /* renamed from: h  reason: collision with root package name */
    public final String f53993h = "upi_cashback_claim";

    /* renamed from: i  reason: collision with root package name */
    public final String f53994i = "mt_invite_bank_acc_upi_promo_text";
    public final String j = "mt_is_contacts_default_input_key";
    public final String k = "ppb_meta_data";
    public final String l = "ppb_pre_validate";
    public final String m = "bankIsaDetailsV2";
    public final String n = "addBeneficiaryKYC";
    public final String o = UpiConstantServiceApi.GET_BENEFICIARY_URL_V4;
    public final String p = UpiConstantServiceApi.DELETE_BENEFICIARY_URL;
    public final String q = "upi_get_top_beneficiery";
    public final String r = "mt_revamp_enabled";
    public final String s = "should_show_all_in_one";
    public final String t = "txn_history_slider_count";
    public final String u = "mt_recent_beneficiary";
    public final String v = "deleteBeneficiaryUrl";
    public final String w = "upi_mpin_interval_days";
    public final String x = "mt_bottom_nav_storefront_url";
    public final String y = "gallery_scan_popup_limit";
    public final String z = "p2p_referral_deeplink";

    public static final c g() {
        return a.a();
    }

    static final class b<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f53995a = new b();

        b() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return k.a(((Number) ((Map.Entry) obj).getValue()).intValue(), ((Number) ((Map.Entry) obj2).getValue()).intValue());
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a() {
            c f2 = c.Z;
            if (f2 != null) {
                return f2;
            }
            c cVar = new c();
            c.Z = cVar;
            return cVar;
        }
    }

    public static String a(String str) {
        d.a aVar = d.f53996a;
        String a2 = d.b(d.a.a()).a(str);
        return a2 == null ? "" : a2;
    }

    public static String a(String str, String str2) {
        d.a aVar = d.f53996a;
        String a2 = d.b(d.a.a()).a(str, str2);
        return a2 == null ? "" : a2;
    }

    public static boolean a(String str, boolean z2) {
        d.a aVar = d.f53996a;
        return d.b(d.a.a()).a(str, z2);
    }

    public static int b(String str) {
        d.a aVar = d.f53996a;
        return d.b(d.a.a()).b(str);
    }

    public final boolean a() {
        return a(this.H, false);
    }

    public final boolean b() {
        return a(this.Q, false);
    }

    public final boolean c() {
        return a(this.T, false);
    }

    public final Map<String, Integer> d() {
        String a2 = a(this.W);
        CharSequence charSequence = a2;
        if (charSequence == null || charSequence.length() == 0) {
            return new LinkedHashMap<>();
        }
        try {
            Object a3 = new f().a(a2, new C0966c().getType());
            k.a(a3, "Gson().fromJson(\n       …>() {}.type\n            )");
            List<Map.Entry> linkedList = new LinkedList<>(((HashMap) a3).entrySet());
            Collections.sort(linkedList, b.f53995a);
            Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
            for (Map.Entry entry : linkedList) {
                linkedHashMap.put((String) entry.getKey(), Integer.valueOf(((Number) entry.getValue()).intValue()));
            }
            return linkedHashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new LinkedHashMap<>();
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.d.c$c  reason: collision with other inner class name */
    public static final class C0966c extends com.google.gson.b.a<HashMap<String, Integer>> {
        C0966c() {
        }
    }

    public final boolean e() {
        return a(this.Y, false);
    }
}
