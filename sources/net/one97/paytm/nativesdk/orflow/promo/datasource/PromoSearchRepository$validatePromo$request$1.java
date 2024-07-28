package net.one97.paytm.nativesdk.orflow.promo.datasource;

import android.text.TextUtils;
import com.android.volley.Response;
import kotlin.m.p;
import net.one97.paytm.nativesdk.orflow.promo.model.ValidatePromoResponse;
import org.json.JSONObject;

final class PromoSearchRepository$validatePromo$request$1<T> implements Response.Listener<String> {
    public static final PromoSearchRepository$validatePromo$request$1 INSTANCE = new PromoSearchRepository$validatePromo$request$1();

    PromoSearchRepository$validatePromo$request$1() {
    }

    public final void onResponse(String str) {
        JSONObject jSONObject = new JSONObject(str);
        ValidatePromoResponse validatePromoResponse = new ValidatePromoResponse();
        validatePromoResponse.setPaytm_promocode(jSONObject.optString("paytm_promocode"));
        validatePromoResponse.setPromofailuretext(jSONObject.optString("promofailuretext"));
        validatePromoResponse.setPromostatus(jSONObject.optString("promostatus"));
        if (TextUtils.isEmpty(validatePromoResponse.getPromostatus()) || !p.a(validatePromoResponse.getPromostatus(), "success", true)) {
            TextUtils.isEmpty(validatePromoResponse.getPromofailuretext());
        }
    }
}
