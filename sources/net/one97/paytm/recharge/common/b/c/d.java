package net.one97.paytm.recharge.common.b.c;

import android.content.Context;
import com.paytm.network.a;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.model.creditcard.CJRCreditCardModel;
import org.json.JSONObject;

public interface d {

    public static final class a {
    }

    void a(Context context, String str, String str2, CJRCreditCardModel cJRCreditCardModel, CJRCreditCardModel cJRCreditCardModel2, ai aiVar, Object obj);

    void a(String str, String str2, ai aiVar, Object obj);

    void a(String str, String str2, ai aiVar, String str3, String str4, boolean z, JSONObject jSONObject, boolean z2, String str5, Object obj);

    void a(String str, ai aiVar, String str2, Object obj);

    void a(String str, ai aiVar, String str2, String str3, long j, Object obj);

    void a(String str, ai aiVar, String str2, String str3, String str4, Object obj);

    void a(String str, ai aiVar, String str2, String str3, CJRRechargeCart cJRRechargeCart, String str4, String str5, CJRCartProduct cJRCartProduct, Object obj);

    void a(String str, ai aiVar, String str2, String str3, net.one97.paytm.recharge.common.b.a.a aVar, Object obj);

    void a(String str, ai aiVar, String str2, HashMap<String, String> hashMap, Object obj);

    void a(String str, ai aiVar, CJRFrequentOrder cJRFrequentOrder, Object obj);

    void a(String str, ai aiVar, JSONObject jSONObject, Object obj);

    void a(String str, ai aiVar, JSONObject jSONObject, String str2, a.b bVar, Object obj, int i2, boolean z);

    void a(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj);

    void a_(String str, ai aiVar, Object obj);

    void b(String str, ai aiVar, Object obj);

    void b(String str, ai aiVar, String str2, Object obj);

    void b(String str, ai aiVar, JSONObject jSONObject, String str2, String str3, Object obj);

    void c(String str, ai aiVar, Object obj);

    void c(String str, ai aiVar, String str2, Object obj);

    void d(String str, ai aiVar, Object obj);

    void d(String str, ai aiVar, String str2, Object obj);

    void e(String str, ai aiVar, Object obj);
}
