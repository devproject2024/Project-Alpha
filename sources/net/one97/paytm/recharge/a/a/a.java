package net.one97.paytm.recharge.a.a;

import android.content.Context;
import io.reactivex.rxjava3.a.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.a.a.b;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionSavedCardsModel;
import net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse;
import net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse;
import net.one97.paytm.recharge.domain.entities.CJRPaymentOptionResponse;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b f60187a = new b();

    public static y<CJRAutomaticSubscriptionCheckModel> a(Context context, Long l, Integer num) {
        k.c(context, "context");
        k.c(context, "context");
        y<CJRAutomaticSubscriptionCheckModel> a2 = y.a(new b.a(l, num, context));
        k.a((Object) a2, "Single.create { emitter …)\n            }\n        }");
        return a2;
    }

    public static y<CJRAutomaticSubscriptionCheckModel> a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "number");
        k.c(context, "context");
        k.c(str, "number");
        y<CJRAutomaticSubscriptionCheckModel> a2 = y.a(new b.C1159b(str, context));
        k.a((Object) a2, "Single.create { emitter …)\n            }\n        }");
        return a2;
    }

    public static y<CJRCreateSubscriptionApiResponse> b(Context context, String str) {
        k.c(context, "context");
        k.c(str, "reqBody");
        k.c(context, "context");
        k.c(str, "reqBody");
        y<CJRCreateSubscriptionApiResponse> a2 = y.a(new b.c(context, str));
        k.a((Object) a2, "Single.create { emitter …)\n            }\n        }");
        return a2;
    }

    public static y<CJROrderSummary> a(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "orderId");
        k.c(context, "context");
        k.c(str, "orderId");
        y<CJROrderSummary> a2 = y.a(new b.e(str, context, str2));
        k.a((Object) a2, "Single.create { emitter …)\n            }\n        }");
        return a2;
    }

    public static y<CJRTaggedObservable<CJRFetchBalanceResponse>> a(Context context, String str, String str2, String str3, String str4) {
        k.c(context, "context");
        k.c(str, "mid");
        k.c(str2, "orderId");
        k.c(str3, "txnToken");
        k.c(str4, "channelId");
        k.c(context, "context");
        k.c(str, "mid");
        k.c(str2, "orderId");
        k.c(str3, "txnToken");
        k.c(str4, "channelId");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("channelId", str4);
        map.put("txnToken", str3);
        map.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("txnToken", str3);
        jSONObject.put("head", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("paymentMode", SDKConstants.AI_KEY_PPBL);
        jSONObject.put("body", jSONObject3);
        y<CJRTaggedObservable<CJRFetchBalanceResponse>> a2 = y.a(new b.f(str, str2, context, hashMap, jSONObject));
        k.a((Object) a2, "Single.create { emitter-…)\n            }\n        }");
        return a2;
    }

    public static y<CJRPaymentOptionResponse> a(Context context, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "reqBody");
        k.c(str2, "mid");
        k.c(str3, "orderId");
        k.c(context, "context");
        k.c(str, "reqBody");
        k.c(str2, "mid");
        k.c(str3, "orderId");
        y<CJRPaymentOptionResponse> a2 = y.a(new b.g(str2, str3, context, str));
        k.a((Object) a2, "Single.create { emitter …)\n            }\n        }");
        return a2;
    }

    public static y<CJRAutomaticSubscriptionSavedCardsModel> a(Context context) {
        k.c(context, "context");
        k.c(context, "context");
        y<CJRAutomaticSubscriptionSavedCardsModel> a2 = y.a(new b.h(context));
        k.a((Object) a2, "Single.create { emitter …)\n            }\n        }");
        return a2;
    }

    public static y<CJRAutomaticSubscriptionListModel> b(Context context) {
        k.c(context, "context");
        k.c(context, "context");
        y<CJRAutomaticSubscriptionListModel> a2 = y.a(new b.i(context));
        k.a((Object) a2, "Single.create { emitter …)\n            }\n        }");
        return a2;
    }

    public static y<CJRFrequentOrderList> c(Context context) {
        k.c(context, "context");
        k.c(context, "context");
        y<CJRFrequentOrderList> a2 = y.a(new b.j(context));
        k.a((Object) a2, "Single.create { emitter …)\n            }\n        }");
        return a2;
    }
}
