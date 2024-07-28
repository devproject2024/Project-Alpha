package net.one97.travelpass.model;

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

public class TravelPassRechargeCart extends IJRPaytmDataModel {
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
        TravelPassRechargeCart travelPassRechargeCart = new TravelPassRechargeCart();
        travelPassRechargeCart.parseJson(str, travelPassRechargeCart);
        return travelPassRechargeCart;
    }

    /* access modifiers changed from: package-private */
    public void parseJson(String str, TravelPassRechargeCart travelPassRechargeCart) throws JSONException {
        if (!str.isEmpty() && travelPassRechargeCart != null) {
            JSONObject jSONObject = new JSONObject(str);
            CJRCartStatus cJRCartStatus = new CJRCartStatus();
            cJRCartStatus.setmResult(jSONObject.has("message") ? jSONObject.getString("message") : "");
            JSONObject jSONObject2 = jSONObject.has("body") ? jSONObject.getJSONObject("body") : null;
            if (jSONObject2 != null) {
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
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            if (!jSONObject3.isNull(Utility.EVENT_CATEGORY_PROMOCODE)) {
                                cJRCartProduct.setmPromoCode(jSONObject3.getString(Utility.EVENT_CATEGORY_PROMOCODE));
                                cJRCart.setPromoCode(jSONObject3.getString(Utility.EVENT_CATEGORY_PROMOCODE));
                            }
                            if (!jSONObject3.isNull("promostatus")) {
                                cJRCartProduct.setmPromoCode(jSONObject3.getString("promostatus"));
                            }
                            if (!jSONObject3.isNull("promotext")) {
                                cJRCartProduct.setmPromoText(jSONObject3.getString("promotext"));
                                cJRCart.setmPromoText(jSONObject3.getString("promotext"));
                            }
                            arrayList.add(cJRCartProduct);
                        }
                    }
                    cJRCart.setCartItems(arrayList);
                }
                travelPassRechargeCart.setmCart(cJRCart);
                travelPassRechargeCart.setmCartStatus(cJRCartStatus);
            }
        }
    }
}
