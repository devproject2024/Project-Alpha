package net.one97.paytm.recharge.common.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.h;
import kotlin.k.i;
import kotlin.m.p;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import org.json.JSONObject;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f61813a;

    /* renamed from: b  reason: collision with root package name */
    public static final y f61814b = new y();

    /* renamed from: c  reason: collision with root package name */
    private static final g f61815c = h.a(a.INSTANCE);

    /* renamed from: d  reason: collision with root package name */
    private static final g f61816d = h.a(b.INSTANCE);

    /* renamed from: e  reason: collision with root package name */
    private static List<CJRAggsItem> f61817e;

    /* renamed from: f  reason: collision with root package name */
    private static List<? extends CJRUtilityVariantV2> f61818f;

    /* renamed from: g  reason: collision with root package name */
    private static CJRCategoryDataHelper f61819g;

    /* renamed from: h  reason: collision with root package name */
    private static CJROrderSummary f61820h;

    /* renamed from: i  reason: collision with root package name */
    private static JSONObject f61821i;
    private static LinkedList<CJRSelectedGroupItem> j;
    private static net.one97.paytm.recharge.mobile.d.a k;
    private static net.one97.paytm.recharge.creditcard.c.a l;

    public static HashMap<String, String> a() {
        return (HashMap) f61815c.getValue();
    }

    public static HashMap<String, String> b() {
        return (HashMap) f61816d.getValue();
    }

    static {
        Class<y> cls = y.class;
        f61813a = new i[]{kotlin.g.b.y.a((v) new w(kotlin.g.b.y.b(cls), "mCategoryOrderMapURL", "getMCategoryOrderMapURL()Ljava/util/HashMap;")), kotlin.g.b.y.a((v) new w(kotlin.g.b.y.b(cls), "mCategoryOrderMapURLType", "getMCategoryOrderMapURLType()Ljava/util/HashMap;"))};
    }

    private y() {
    }

    static final class a extends l implements kotlin.g.a.a<HashMap<String, String>> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final HashMap<String, String> invoke() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("17", "https://catalog.paytm.com/v1/mobile/mobile-prepaid/17");
            hashMap.put("18", "https://catalog.paytm.com/v1/mobile/DTH/18");
            hashMap.put("19", "https://catalog.paytm.com/v1/mobile/datacard-prepaid/19");
            hashMap.put("21", "https://catalog.paytm.com/v1/mobile/mobile-postpaid/21");
            hashMap.put("23", "https://catalog.paytm.com/v1/mobile/datacard-postpaid/23");
            hashMap.put("26", "https://catalog.paytm.com/v1/mobile/getproductlist/26?group=brand");
            hashMap.put("75505", "https://catalog.paytm.com/v1/mobile/getproductlist/75505?group=brand");
            hashMap.put("68869", "https://catalog.paytm.com/v1//mobile/getproductlist/68869?group=brand");
            hashMap.put("78640", "https://catalog.paytm.com/v1/mobile/getproductlist/78640");
            hashMap.put("99932", "https://catalog.paytm.com/v1/mobile/getproductlist/99932?group=brand");
            hashMap.put("1567805", "https://catalog.paytm.com/v2/mobile/getproductlist/156705");
            hashMap.put("123988", "https://catalog.paytm.com/v2/mobile/getproductlist/123988");
            hashMap.put("101950", "https://catalog.paytm.com/v1/mobile/getproductlist/101950");
            hashMap.put("46007", "https://catalog.paytm.com/v1/mobile/getproductlist/46007?group=brand");
            hashMap.put("46006", "https://catalog.paytm.com/v1/mobile/getproductlist/46006?group=brand");
            hashMap.put("107730", "https://catalog.paytm.com/v2/mobile/getproductlist/107730");
            hashMap.put("77409", "https://catalog.paytm.com/v1/mobile/getproductlist/77409?group=brand");
            hashMap.put("100253", "https://catalog.paytm.com/v1/mobile/getproductlist/100253?group=brand");
            hashMap.put("64739", "https://catalog.paytm.com/v1/mobile/getproductlist/64739?group=brand");
            hashMap.put("75505", "https://catalog.paytm.com/v1/mobile/getproductlist/75505?group=brand");
            hashMap.put("156705", "https://catalog.paytm.com/v2/mobile/getproductlist/156705");
            hashMap.put("166690", "https://catalog.paytm.com/v2/mobile/getproductlist/166690");
            hashMap.put("37217", "https://catalog.paytm.com/v1/mobile/getproductlist/37217");
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                hashMap.put("131651", "https://catalog.paytm.com/v2/mobile/getproductlist/131651");
                hashMap.put("106971", "https://catalog.paytm.com/v2/mobile/getproductlist/106971");
                hashMap.put("132343", "https://catalog.paytm.com/v1/mobile/getproductlist/132343");
                hashMap.put("166260", "https://catalog.paytm.com/v1/mobile/getproductlist/166260");
                hashMap.put("205763", "https://catalog.paytm.com/v2/mobile/getproductlist/205763");
                hashMap.put("93659", "https://catalog.paytm.com/v2/mobile/getproductlist/93659");
                hashMap.put("93590", "https://catalog.paytm.com/v2/mobile/getproductlist/93590");
                hashMap.put("93645", "https://catalog.paytm.com/v2/mobile/getproductlist/104154");
                hashMap.put("213935", "https://staging.paytm.com/ott/v1/index.html");
                hashMap.put("215903", "https://staging.paytm.com/rentalservices/v1/index.html");
            } else {
                hashMap.put("132935", "https://catalog.paytm.com/v2/mobile/getproductlist/132935");
                hashMap.put("127781", "https://catalog.paytm.com/v2/mobile/getproductlist/127781");
                hashMap.put("204854", "https://catalog.paytm.com/v1/mobile/getproductlist/204854");
                hashMap.put("207075", "https://catalog.paytm.com/v1/mobile/getproductlist/207075");
                hashMap.put("205763", "https://catalog.paytm.com/v1/mobile/getproductlist/205763");
                hashMap.put("219876", "https://paytm.com/ott/v1/index.html");
                hashMap.put("262072", "https://paytm.com/rentalservices/v1/index.html");
                hashMap.put("107730", "https://catalog.paytm.com/v2/mobile/getproductlist/93659");
                hashMap.put("101950", "https://catalog.paytm.com/v2/mobile/getproductlist/93590");
                hashMap.put("104154", "https://catalog.paytm.com/v2/mobile/getproductlist/104154");
            }
            return hashMap;
        }
    }

    static final class b extends l implements kotlin.g.a.a<HashMap<String, String>> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        public final HashMap<String, String> invoke() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("17", "mobile-prepaid");
            hashMap.put("18", "DTH");
            hashMap.put("19", "datacard-prepaid");
            hashMap.put("21", "mobile-postpaid");
            hashMap.put("23", "datacard-prepaid");
            hashMap.put("26", "utility");
            hashMap.put("75505", "utility");
            hashMap.put("68869", "utility");
            hashMap.put("78640", "utility");
            hashMap.put("99932", "utility");
            hashMap.put("1567805", "utility");
            hashMap.put("123988", "utility");
            hashMap.put("166690", "utility");
            hashMap.put("101950", "utility");
            hashMap.put("46007", "utility");
            hashMap.put("46006", "utility");
            hashMap.put("107730", "utility");
            hashMap.put("77409", "utility");
            hashMap.put("100253", "utility");
            hashMap.put("64739", "utility");
            hashMap.put("75505", "utility");
            hashMap.put("156705", "utility");
            hashMap.put("37217", "utility");
            if (p.a("release", SDKConstants.KEY_STAGING_API, true)) {
                hashMap.put("131651", "utility");
                hashMap.put("106971", "utility");
                hashMap.put("132343", "utility_donation");
                hashMap.put("166260", "fastag-recharge");
                hashMap.put("205763", "utility");
                hashMap.put("93659", "utility");
                hashMap.put("93590", "utility");
                hashMap.put("93645", "challan");
                hashMap.put("213935", "ottsubscription-recharge");
                hashMap.put("215903", "mymonthlypayment");
            } else {
                hashMap.put("132935", "utility");
                hashMap.put("127781", "utility");
                hashMap.put("205763", "utility");
                hashMap.put("204854", "utility_donation");
                hashMap.put("207075", "fastag-recharge");
                hashMap.put("219876", "ottsubscription-recharge");
                hashMap.put("262072", "mymonthlypayment");
                hashMap.put("107730", "utility");
                hashMap.put("101950", "utility");
                hashMap.put("104154", "challan");
            }
            return hashMap;
        }
    }

    public static void a(List<CJRAggsItem> list) {
        f61817e = list;
    }

    public static List<CJRAggsItem> c() {
        return f61817e;
    }

    public static void b(List<? extends CJRUtilityVariantV2> list) {
        f61818f = list;
    }

    public static List<CJRUtilityVariantV2> d() {
        return f61818f;
    }

    public static void a(CJRCategoryDataHelper cJRCategoryDataHelper) {
        f61819g = cJRCategoryDataHelper;
    }

    public static CJRCategoryDataHelper e() {
        return f61819g;
    }

    public static void a(CJROrderSummary cJROrderSummary) {
        f61820h = cJROrderSummary;
    }

    public static CJROrderSummary f() {
        return f61820h;
    }

    public static void a(JSONObject jSONObject) {
        f61821i = jSONObject;
    }

    public static JSONObject g() {
        return f61821i;
    }

    public static void a(LinkedList<CJRSelectedGroupItem> linkedList) {
        j = linkedList;
    }

    public static LinkedList<CJRSelectedGroupItem> h() {
        return j;
    }

    public static LinkedList<CJRSelectedGroupItem> i() {
        LinkedList<CJRSelectedGroupItem> linkedList = j;
        j = null;
        return linkedList;
    }

    public static void a(net.one97.paytm.recharge.mobile.d.a aVar) {
        k = aVar;
    }

    public static net.one97.paytm.recharge.mobile.d.a j() {
        return k;
    }

    public static void a(net.one97.paytm.recharge.creditcard.c.a aVar) {
        l = aVar;
    }

    public static net.one97.paytm.recharge.creditcard.c.a k() {
        return l;
    }
}
