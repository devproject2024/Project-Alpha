package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJRRechargeCart extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cart")
    private CJRCart mCart;
    @b(a = "status")
    private CJRCartStatus mCartStatus;

    public CJRCartStatus getCartStatus() {
        return this.mCartStatus;
    }

    public CJRCart getCart() {
        return this.mCart;
    }

    public void setCartJsonResponse(String str) {
        "JSON CART--".concat(String.valueOf(str));
        com.paytm.utility.b.j();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONObject("cart").getJSONArray("cart_items");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.getJSONObject(i2).has("service_options")) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2).getJSONObject("service_options");
                    if (jSONObject.has("actions")) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("actions");
                        int i3 = 0;
                        while (true) {
                            if (i3 >= jSONArray2.length()) {
                                break;
                            } else if (jSONArray2.getJSONObject(i3).has("displayValues")) {
                                this.mCart.getCartItems().get(i2).setDisplayItemIndex(i3);
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public void setmCart(CJRCart cJRCart) {
        this.mCart = cJRCart;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) fVar.a(str, new CJRRechargeCart().getClass());
        cJRRechargeCart.setCartJsonResponse(str);
        return cJRRechargeCart;
    }
}
