package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import net.one97.paytm.nativesdk.orflow.Utility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRBusRechargeCart extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cart")
    private CJRCart mCart;
    @b(a = "status")
    private CJRCartStatus mCartStatus;

    public void setmCartStatus(CJRCartStatus cJRCartStatus) {
        this.mCartStatus = cJRCartStatus;
    }

    public CJRCartStatus getCartStatus() {
        return this.mCartStatus;
    }

    public CJRCart getCart() {
        return this.mCart;
    }

    public void setmCart(CJRCart cJRCart) {
        this.mCart = cJRCart;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRBusRechargeCart cJRBusRechargeCart = new CJRBusRechargeCart();
        cJRBusRechargeCart.parseJson(str, cJRBusRechargeCart);
        return cJRBusRechargeCart;
    }

    /* access modifiers changed from: package-private */
    public void parseJson(String str, CJRBusRechargeCart cJRBusRechargeCart) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("cart");
        JSONObject jSONObject3 = jSONObject.getJSONObject("status");
        CJRCartStatus cJRCartStatus = new CJRCartStatus();
        if (!jSONObject3.isNull("result")) {
            cJRCartStatus.setmResult(jSONObject3.getString("result"));
        }
        CJRCart cJRCart = new CJRCart();
        if (!jSONObject2.isNull("final_price_excl_shipping")) {
            cJRCart.setFinalPriceExclShipping(jSONObject2.getString("final_price_excl_shipping"));
        }
        if (!jSONObject2.isNull("paytm_discount")) {
            cJRCart.setPaytmDiscount(jSONObject2.getString("paytm_discount"));
        }
        if (!jSONObject2.isNull("promostatus")) {
            cJRCart.setmPromoStatus(jSONObject2.getString("promostatus"));
        }
        if (!jSONObject2.isNull("promofailuretext")) {
            cJRCart.setPromoFailureText(jSONObject2.getString("promofailuretext"));
        }
        if (!jSONObject2.isNull("paytm_cashback")) {
            cJRCart.setPaytmCashBack(jSONObject2.getString("paytm_cashback"));
        }
        if (!jSONObject2.isNull("paytm_promocode")) {
            cJRCart.setmPaytmPromocode(jSONObject2.getString("paytm_promocode"));
        }
        if (!jSONObject2.isNull("promotext")) {
            cJRCart.setmPromoText(jSONObject2.getString("promotext"));
        }
        if (!jSONObject2.isNull(Utility.EVENT_CATEGORY_PROMOCODE)) {
            cJRCart.setPromoCode(jSONObject2.getString(Utility.EVENT_CATEGORY_PROMOCODE));
        }
        if (!jSONObject2.isNull("cart_items")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject2.getJSONArray("cart_items");
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    CJRCartProduct cJRCartProduct = new CJRCartProduct();
                    JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                    if (!jSONObject4.isNull(Utility.EVENT_CATEGORY_PROMOCODE)) {
                        cJRCartProduct.setmPromoCode(jSONObject4.getString(Utility.EVENT_CATEGORY_PROMOCODE));
                    }
                    if (!jSONObject4.isNull("promostatus")) {
                        cJRCartProduct.setmPromoCode(jSONObject4.getString("promostatus"));
                    }
                    if (!jSONObject4.isNull("promotext")) {
                        cJRCartProduct.setmPromoText(jSONObject4.getString("promotext"));
                    }
                    arrayList.add(cJRCartProduct);
                }
            }
            cJRCart.setCartItems(arrayList);
        }
        cJRBusRechargeCart.setmCart(cJRCart);
        cJRBusRechargeCart.setmCartStatus(cJRCartStatus);
    }
}
