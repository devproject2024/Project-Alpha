package net.one97.paytm.acceptPayment.d;

import android.content.Context;
import android.text.TextUtils;
import com.business.common_module.b.i;
import com.business.common_module.e.b;
import com.business.common_module.utilities.LogUtility;
import com.paytm.business.merchantprofile.common.utility.MerchantTypeToPPIMapperKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;

public final class a implements i {

    /* renamed from: a  reason: collision with root package name */
    public static final a f52050a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Context f52051b;

    static {
        Context a2 = net.one97.paytm.acceptPayment.configs.a.a().b().a();
        k.b(a2, "AcceptPaymentsConfig.get…).getApplicationContext()");
        f52051b = a2;
    }

    private a() {
    }

    public static void b(b bVar) {
        k.d(bVar, "merchant");
        b bVar2 = b.f52053b;
        k.d(bVar, "merchant");
        try {
            com.business.common_module.e.a d2 = b.d();
            if (d2 != null) {
                Iterator<b> it2 = d2.getMerchants().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    b next = it2.next();
                    k.b(next, "curr");
                    if (k.a((Object) next.getMid(), (Object) bVar.getMid())) {
                        d2.getMerchants().set(d2.getMerchants().indexOf(next), bVar);
                        b.a(d2);
                        break;
                    }
                }
            }
            LogUtility.d(b.f52052a, "Replace Merchant Operation failed !!");
        } catch (Exception e2) {
            LogUtility.d(b.f52052a, "Replace Merchant Operation failed !!");
            LogUtility.printStackTrace(e2);
        }
    }

    public final boolean I() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "ROLE_TXNWISE_SETTLEMENT", false);
    }

    public final boolean J() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "PERMISSION_INSTANT_SETTLEMENT", false);
    }

    public final boolean K() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_merchant_info_exists", false);
    }

    public final void L() {
        net.one97.paytm.acceptPayment.e.a.a.f52055a.a(f52051b, "is_merchant_active", true);
    }

    public final String H() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "CUSTOMER_ID", "");
    }

    public static void M() {
        b bVar = b.f52053b;
        b.b();
        b.c();
        b.a();
    }

    public final void a(b bVar) {
        k.d(bVar, "merchant");
        b bVar2 = b.f52053b;
        b.a(bVar);
    }

    public final com.business.common_module.e.a b() {
        b bVar = b.f52053b;
        return b.d();
    }

    public final String D() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "merchant_id", "");
    }

    public final void a(String str) {
        k.d(str, "name");
        net.one97.paytm.acceptPayment.e.a.a.f52055a.a(f52051b, "key_merchant_name", str);
    }

    public final String E() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_merchant_name", "");
    }

    public static void b(String str) {
        k.d(str, "name");
        net.one97.paytm.acceptPayment.e.a.a.f52055a.a(f52051b, "user_display_name", str);
    }

    public final String G() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "user_display_name", "");
    }

    public final String C() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_merchant_email", "");
    }

    public static void a(com.business.common_module.e.a aVar) {
        k.d(aVar, "merchantInfo");
        b bVar = b.f52053b;
        b.a(aVar);
    }

    public final ArrayList<b> a(String str, ArrayList<b> arrayList) {
        k.d(str, "currentMerchantId");
        k.d(arrayList, "merchantsArrayList");
        return b.a(str, arrayList);
    }

    public static String N() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_user_id", (String) null);
    }

    public static void c(String str) {
        k.d(str, "url");
        net.one97.paytm.acceptPayment.e.a.a.f52055a.a(f52051b, "user_pic_url", str);
    }

    public final String a() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "user_pic_url", "");
    }

    public final String B() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "user_token", (String) null);
    }

    public final boolean i() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "is_merchant_migrated", false);
    }

    public final boolean p() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "BW_PASSBOOK_PERMISSION", false);
    }

    public final boolean q() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "tag_is_merchant_online", false);
    }

    public final boolean x() {
        String b2 = net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_merchant_type", "");
        return !TextUtils.isEmpty(b2) && p.a(b2, "nonsd", true);
    }

    public final boolean r() {
        return !x();
    }

    public final boolean s() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_merchant_admin", false);
    }

    public final boolean v() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "edc_merchant_role", false);
    }

    public final boolean y() {
        String b2 = net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_merchant_type", "");
        return x() || (!TextUtils.isEmpty(b2) && p.a(b2, MerchantTypeToPPIMapperKt.CONST_UNLIMITED_SD, true));
    }

    public final String z() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_phone_number", (String) null);
    }

    public final String A() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "merchant_guid", (String) null);
    }

    public final boolean c() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "is_merchant_active", false);
    }

    public final String t() {
        String b2 = net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "key_merchant_type", "");
        k.a((Object) b2);
        return b2;
    }

    public final boolean w() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "EDIT_DISPLAY_NAME_PERMISSION", false);
    }

    public final boolean u() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "PAYMENT_LINK_SHARE_PERMISSION", false);
    }

    public final boolean j() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "ADD_PRIMARY_DETAIL", false);
    }

    public final boolean k() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "TXN_LIST_REFUND_PERMISSION", false);
    }

    public final boolean l() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "TXN_LIST_DEF_PERMISSION", false);
    }

    public final boolean m() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "BW_TRANSFER_TO_BANK_PERMISSION", false);
    }

    public final boolean n() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "NON_BW_DOWNLOAD_STATEMENT_PERMISSION", false);
    }

    public final boolean o() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "SHOW_SETTLEMENT_PERMISSION", false);
    }

    public final boolean e() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "PAYMENT_LINK_PERMISSION", false);
    }

    public final boolean f() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "PAYMENT_CREATE_PERMISSION", false);
    }

    public final boolean g() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "TXN_INIT_REFUND_PERMISSION", false);
    }

    public final boolean h() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "TXN_LIST_DOWNLOAD_PERMISSION", false);
    }

    public final boolean d() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "create_and_update_qr_code_role", false);
    }

    public final boolean F() {
        return net.one97.paytm.acceptPayment.e.a.a.f52055a.b(f52051b, "business_wallet_role", false);
    }
}
