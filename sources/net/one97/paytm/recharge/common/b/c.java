package net.one97.paytm.recharge.common.b;

import android.content.Context;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.n;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.b.c.d;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import org.json.JSONObject;

public class c implements net.one97.paytm.recharge.common.b.b.b, d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f60903b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f60904d;

    /* renamed from: a  reason: collision with root package name */
    final net.one97.paytm.recharge.common.b.b.b f60905a;

    /* renamed from: c  reason: collision with root package name */
    private final d f60906c;

    public final void b(String str, String str2) {
        k.c(str, "categoryId");
    }

    public c(net.one97.paytm.recharge.common.b.b.b bVar, d dVar) {
        k.c(bVar, "rechargeLocalDataSource");
        k.c(dVar, "rechargeRemoteDataSource");
        this.f60905a = bVar;
        this.f60906c = dVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final c a(net.one97.paytm.recharge.common.b.b.b bVar, d dVar) {
            c cVar;
            k.c(bVar, "rechargeLocalDataSource");
            k.c(dVar, "rechargeRemoteDataSource");
            c b2 = c.f60904d;
            if (b2 != null) {
                return b2;
            }
            synchronized (this) {
                cVar = new c(bVar, dVar);
                c.f60904d = cVar;
            }
            return cVar;
        }
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "categoryId");
        this.f60906c.a(str, aiVar, jSONObject, str2, str3, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
        String str4 = str;
        k.c(str, "tag");
        k.c(aiVar, "responseListener");
        k.c(str2, "categoryId");
        ay ayVar = ay.f61523a;
        ay.a(str, obj);
        if (aVar == null) {
            this.f60906c.a(str, aiVar, str2, str3, (net.one97.paytm.recharge.common.b.a.a) null, obj);
            return;
        }
        a(str, aiVar, str2, str3, (net.one97.paytm.recharge.common.b.b.a) new b(this, str, aiVar, str2, str3, aVar, obj), obj);
    }

    public static final class b implements net.one97.paytm.recharge.common.b.b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f60911a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f60912b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ai f60913c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f60914d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f60915e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.common.b.a.a f60916f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Object f60917g;

        public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
        }

        b(c cVar, String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj) {
            this.f60911a = cVar;
            this.f60912b = str;
            this.f60913c = aiVar;
            this.f60914d = str2;
            this.f60915e = str3;
            this.f60916f = aVar;
            this.f60917g = obj;
        }

        public final void a() {
            this.f60911a.f60906c.a(this.f60912b, (ai) new C1177c(this.f60911a, this.f60913c, this.f60914d, this.f60915e, this.f60916f), this.f60914d, this.f60915e, this.f60916f, this.f60917g);
        }

        public final void a(String str, boolean z, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            this.f60916f.a(str, z, iJRPaytmDataModel, obj);
            this.f60911a.f60906c.a(str, (ai) new C1177c(this.f60911a, this.f60913c, this.f60914d, this.f60915e, this.f60916f), this.f60914d, this.f60915e, this.f60916f, obj);
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.b.c$c  reason: collision with other inner class name */
    public static final class C1177c implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f60925a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ai f60926b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f60927c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f60928d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.common.b.a.a f60929e;

        C1177c(c cVar, ai aiVar, String str, String str2, net.one97.paytm.recharge.common.b.a.a aVar) {
            this.f60925a = cVar;
            this.f60926b = aiVar;
            this.f60927c = str;
            this.f60928d = str2;
            this.f60929e = aVar;
        }

        /* renamed from: net.one97.paytm.recharge.common.b.c$c$a */
        public static final class a implements net.one97.paytm.recharge.common.b.b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1177c f60932a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f60933b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ NetworkCustomError f60934c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Object f60935d;

            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                k.c(str, "tag");
                k.c(iJRPaytmDataModel, Payload.RESPONSE);
            }

            a(C1177c cVar, String str, NetworkCustomError networkCustomError, Object obj) {
                this.f60932a = cVar;
                this.f60933b = str;
                this.f60934c = networkCustomError;
                this.f60935d = obj;
            }

            public final void a(String str, boolean z, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                k.c(str, "tag");
                k.c(iJRPaytmDataModel, Payload.RESPONSE);
                net.one97.paytm.recharge.common.b.a.a aVar = this.f60932a.f60929e;
                if (aVar != null) {
                    aVar.a(str, false, iJRPaytmDataModel, obj);
                }
            }

            public final void a() {
                this.f60932a.f60926b.a(this.f60933b, 0, (IJRPaytmDataModel) null, this.f60934c, this.f60935d);
            }
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f60925a.a(str, this.f60926b, this.f60927c, this.f60928d, (net.one97.paytm.recharge.common.b.b.a) new a(this, str, networkCustomError, obj), obj);
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            NetworkResponse networkResponse;
            k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRCategoryData) {
                ((CJRCategoryData) iJRPaytmDataModel).setCachedLangId(n.b());
            }
            if (iJRPaytmDataModel == null || (networkResponse = iJRPaytmDataModel.getNetworkResponse()) == null || networkResponse.statusCode != 304) {
                net.one97.paytm.recharge.common.b.a.a aVar = this.f60929e;
                if (aVar != null) {
                    if (iJRPaytmDataModel == null) {
                        k.a();
                    }
                    aVar.a(str, false, iJRPaytmDataModel, obj);
                }
                this.f60925a.f60905a.b(this.f60927c, new f().a((Object) iJRPaytmDataModel));
                return;
            }
            net.one97.paytm.recharge.common.b.a.a aVar2 = this.f60929e;
            if (aVar2 != null) {
                aVar2.a(str, iJRPaytmDataModel, obj);
            }
        }
    }

    public final void a(String str, ai aiVar, String str2, String str3, long j, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str3, "rechargeNumber");
        this.f60906c.a(str, aiVar, str2, str3, j, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.b.a aVar, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "categoryId");
        this.f60905a.a(str, aiVar, str2, str3, aVar, obj);
    }

    public final void a(String str, String str2) {
        k.c(str, "categoryId");
        k.c(str2, "location");
        this.f60905a.a(str, str2);
    }

    public final String a(String str) {
        k.c(str, "categoryId");
        return this.f60905a.a(str);
    }

    public final void a(String str, ai aiVar, String str2, String str3, String str4, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "categoryId");
        k.c(str3, "productId");
        this.f60906c.a(str, aiVar, str2, str3, str4, obj);
    }

    public final boolean a() {
        ay.a(true);
        return this.f60905a.a();
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, String str2, a.b bVar, Object obj, int i2, boolean z) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(jSONObject, "jsonCart");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(bVar, "userFacing");
        this.f60906c.a(str, aiVar, jSONObject, str2, bVar, obj, i2, z);
    }

    public final void a_(String str, ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        this.f60906c.a_(str, aiVar, obj);
    }

    public final void b(String str, ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        this.f60906c.b(str, aiVar, obj);
    }

    public final void a(String str, String str2, ai aiVar, String str3, String str4, boolean z, JSONObject jSONObject, boolean z2, String str5, Object obj) {
        k.c(str, "tag");
        k.c(str2, "walletToken");
        k.c(aiVar, "onSuccess");
        JSONObject jSONObject2 = jSONObject;
        k.c(jSONObject2, "jsonCart");
        this.f60906c.a(str, str2, aiVar, str3, str4, z, jSONObject2, z2, str5, obj);
    }

    public final void b(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(jSONObject, "body");
        k.c(str2, "categoryId");
        this.f60906c.b(str, aiVar, jSONObject, str2, str3, obj);
    }

    public final void a(String str, ai aiVar, CJRFrequentOrder cJRFrequentOrder, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(cJRFrequentOrder, "recentOrder");
        this.f60906c.a(str, aiVar, cJRFrequentOrder, obj);
    }

    public final void a(String str, ai aiVar, String str2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "offersUrl");
        this.f60906c.a(str, aiVar, str2, obj);
    }

    public final void b(String str, ai aiVar, String str2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "categoryId");
        this.f60906c.b(str, aiVar, str2, obj);
    }

    public final void c(String str, ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        this.f60906c.c(str, aiVar, obj);
    }

    public final void d(String str, ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        this.f60906c.d(str, aiVar, obj);
    }

    public final void e(String str, ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        this.f60906c.e(str, aiVar, obj);
    }

    public final void c(String str, ai aiVar, String str2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "rechargeNumber");
        this.f60906c.c(str, aiVar, str2, obj);
    }

    public final void d(String str, ai aiVar, String str2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "body");
        this.f60906c.d(str, aiVar, str2, obj);
    }

    public final void a(String str, ai aiVar, JSONObject jSONObject, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(jSONObject, "body");
        this.f60906c.a(str, aiVar, jSONObject, obj);
    }

    public final void a(String str, ai aiVar, String str2, HashMap<String, String> hashMap, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "body");
        k.c(hashMap, H5Logger.HEADER);
        this.f60906c.a(str, aiVar, str2, hashMap, obj);
    }

    public final void a(Context context, String str, String str2, CJRCreditCardModel cJRCreditCardModel, CJRCreditCardModel cJRCreditCardModel2, ai aiVar, Object obj) {
        k.c(context, "context");
        k.c(str, "tag");
        k.c(str2, "url");
        k.c(cJRCreditCardModel2, "responseBody");
        k.c(aiVar, Payload.RESPONSE);
        this.f60906c.a(context, str, str2, cJRCreditCardModel, cJRCreditCardModel2, aiVar, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, CJRRechargeCart cJRRechargeCart, String str4, String str5, CJRCartProduct cJRCartProduct, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "url");
        k.c(str3, "productMasterNumber");
        String str6 = str4;
        k.c(str6, "productMasterId");
        String str7 = str5;
        k.c(str7, "rechargeMasterPrice");
        this.f60906c.a(str, aiVar, str2, str3, cJRRechargeCart, str6, str7, cJRCartProduct, obj);
    }

    public void a(String str, String str2, ai aiVar, Object obj) {
        k.c(str, "tag");
        k.c(str2, "promoCode");
        k.c(aiVar, "onSuccess");
        this.f60906c.a(str, str2, aiVar, obj);
    }
}
