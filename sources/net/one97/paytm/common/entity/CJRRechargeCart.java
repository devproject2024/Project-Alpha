package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJRRechargeCart extends IJRPaytmDataModel implements IJRDataModel {
    public static final String KEY_GROUP_DISPLAY = "groupDisplay";
    public static final String KEY_GROUP_DISPLAY_KEY = "key";
    public static final String KEY_GROUP_DISPLAY_LABEl = "label";
    public static final String KEY_GROUP_DISPLAY_VALUES = "values";
    public static final String KEY_PAYMENT_INFO = "paymentInfo";
    public static final String KEY_PAYMENT_INSTRUMENT = "payment_instruments";
    public static final String KEY_VALIDATION_ACTIONS = "actions";
    public static final String KEY_VALIDATION_CART = "cart";
    public static final String KEY_VALIDATION_CART_ITEMS = "cart_items";
    public static final String KEY_VALIDATION_DISPLAY_VALUES = "displayValues";
    public static final String KEY_VALIDATION_SERVICE_OPTIONS = "service_options";
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
                            }
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                            setGroupDisplayKeyArray(jSONObject2, i2);
                            if (jSONObject2.has("displayValues")) {
                                this.mCart.getCartItems().get(i2).setDisplayItemIndex(i3);
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void setGroupDisplayKeyArray(JSONObject jSONObject, int i2) {
        JSONArray jSONArray;
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray("groupDisplay");
            if (jSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    if (!(jSONObject2 == null || (jSONArray = jSONObject2.getJSONArray("values")) == null || jSONArray.length() <= 0)) {
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                            this.mCart.getCartItems().get(i2).getServiceOptions().getActions().get(0).getGroupDisplay().get(i3).addToMap(jSONObject3.optString("label"), jSONObject3.optJSONArray("key").toString());
                        }
                    }
                }
            }
        } catch (Exception unused) {
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
