package net.one97.paytm.recharge.ordersummary.b.a;

import android.content.Context;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.b.c.d;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel;
import net.one97.paytm.recharge.ordersummary.f.k;
import org.json.JSONObject;

public final class b implements d, k {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64010a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f64011e;

    /* renamed from: b  reason: collision with root package name */
    private final net.one97.paytm.recharge.common.b.b.b f64012b;

    /* renamed from: c  reason: collision with root package name */
    private final k f64013c;

    /* renamed from: d  reason: collision with root package name */
    private final d f64014d;

    public final void a(Context context, String str, String str2, CJRCreditCardModel cJRCreditCardModel, CJRCreditCardModel cJRCreditCardModel2, ai aiVar, Object obj) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, "url");
        kotlin.g.b.k.c(cJRCreditCardModel2, "responseBody");
        kotlin.g.b.k.c(aiVar, Payload.RESPONSE);
        this.f64014d.a(context, str, str2, cJRCreditCardModel, cJRCreditCardModel2, aiVar, obj);
    }

    public final void a(String str, String str2, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, "promoCode");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.f64014d.a(str, str2, aiVar, obj);
    }

    public final void a(String str, String str2, ai aiVar, String str3, String str4, boolean z, JSONObject jSONObject, boolean z2, String str5, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, "walletToken");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        JSONObject jSONObject2 = jSONObject;
        kotlin.g.b.k.c(jSONObject2, "jsonCart");
        this.f64014d.a(str, str2, aiVar, str3, str4, z, jSONObject2, z2, str5, obj);
    }

    public final void a(String str, ai aiVar, String str2, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "offersUrl");
        this.f64014d.a(str, aiVar, str2, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, long j, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str3, "rechargeNumber");
        this.f64014d.a(str, aiVar, str2, str3, j, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, String str4, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "url");
        kotlin.g.b.k.c(str3, "productId");
        this.f64014d.a(str, aiVar, str2, str3, str4, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, CJRRechargeCart cJRRechargeCart, String str4, String str5, CJRCartProduct cJRCartProduct, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "url");
        kotlin.g.b.k.c(str3, "productMasterNumber");
        String str6 = str4;
        kotlin.g.b.k.c(str6, "productMasterId");
        String str7 = str5;
        kotlin.g.b.k.c(str7, "rechargeMasterPrice");
        this.f64014d.a(str, aiVar, str2, str3, cJRRechargeCart, str6, str7, cJRCartProduct, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "url");
        this.f64014d.a(str, aiVar, str2, str3, aVar, obj);
    }

    public final void a(String str, ai aiVar, String str2, HashMap<String, String> hashMap, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "body");
        kotlin.g.b.k.c(hashMap, H5Logger.HEADER);
        this.f64014d.a(str, aiVar, str2, hashMap, obj);
    }

    public final void a(String str, ai aiVar, CJRFrequentOrder cJRFrequentOrder, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(cJRFrequentOrder, "recentOrder");
        this.f64014d.a(str, aiVar, cJRFrequentOrder, obj);
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(jSONObject, "body");
        this.f64014d.a(str, aiVar, jSONObject, obj);
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, String str2, a.b bVar, Object obj, int i2, boolean z) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(jSONObject, "jsonCart");
        kotlin.g.b.k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        kotlin.g.b.k.c(bVar, "userFacing");
        this.f64014d.a(str, aiVar, jSONObject, str2, bVar, obj, i2, z);
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "url");
        this.f64014d.a(str, aiVar, jSONObject, str2, str3, obj);
    }

    public final void a_(String str, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.f64014d.a_(str, aiVar, obj);
    }

    public final void b(String str, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.f64014d.b(str, aiVar, obj);
    }

    public final void b(String str, ai aiVar, String str2, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "categoryId");
        this.f64014d.b(str, aiVar, str2, obj);
    }

    public final void b(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(jSONObject, "body");
        kotlin.g.b.k.c(str2, "url");
        this.f64014d.b(str, aiVar, jSONObject, str2, str3, obj);
    }

    public final void c(String str, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.f64014d.c(str, aiVar, obj);
    }

    public final void c(String str, ai aiVar, String str2, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "rechargeNumber");
        this.f64014d.c(str, aiVar, str2, obj);
    }

    public final void d(String str, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.f64014d.d(str, aiVar, obj);
    }

    public final void d(String str, ai aiVar, String str2, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "body");
        this.f64014d.d(str, aiVar, str2, obj);
    }

    public final void e(String str, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.f64014d.e(str, aiVar, obj);
    }

    private b(net.one97.paytm.recharge.common.b.b.b bVar, k kVar, d dVar) {
        this.f64012b = bVar;
        this.f64013c = kVar;
        this.f64014d = dVar;
    }

    public /* synthetic */ b(net.one97.paytm.recharge.common.b.b.b bVar, k kVar, d dVar, byte b2) {
        this(bVar, kVar, dVar);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final b a(net.one97.paytm.recharge.common.b.b.b bVar, k kVar, d dVar) {
            b bVar2;
            kotlin.g.b.k.c(bVar, "rechargeLocalDataSource");
            kotlin.g.b.k.c(kVar, "rechargeRemoteDataSource");
            kotlin.g.b.k.c(dVar, "commonRemoteDataSource");
            b a2 = b.f64011e;
            if (a2 != null) {
                return a2;
            }
            synchronized (this) {
                bVar2 = new b(bVar, kVar, dVar, (byte) 0);
                b.f64011e = bVar2;
            }
            return bVar2;
        }
    }

    public final void a(String str, String str2, String str3, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, "orderId");
        kotlin.g.b.k.c(str3, "extraQueryParams");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.f64013c.a(str, str2, str3, aiVar, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, String str4, String str5, CJROrderedCart cJROrderedCart, Object obj) {
        String str6 = str;
        kotlin.g.b.k.c(str, "tag");
        ai aiVar2 = aiVar;
        kotlin.g.b.k.c(aiVar, "onSuccess");
        String str7 = str2;
        kotlin.g.b.k.c(str2, "url");
        String str8 = str3;
        kotlin.g.b.k.c(str3, "productMasterNumber");
        String str9 = str4;
        kotlin.g.b.k.c(str4, "productMasterId");
        kotlin.g.b.k.c(str5, "rechargeMasterPrice");
        kotlin.g.b.k.c(cJROrderedCart, "masterProduct");
        k kVar = this.f64013c;
        if (kVar != null) {
            kVar.a(str, aiVar, str2, str3, str4, str5, cJROrderedCart, obj);
        }
    }

    public final void a(String str, ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.f64013c.a(str, aiVar, obj);
    }
}
