package net.one97.paytm.o2o.movies.entity;

import com.alipay.mobile.h5container.api.H5Param;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import org.json.JSONObject;

public class CJRFoodBeverageSetResponseV2 extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    public String m3dGlass;
    public String mFood;
    public String mFoodVoucher;

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRFoodBeverageSetResponseV2 cJRFoodBeverageSetResponseV2 = new CJRFoodBeverageSetResponseV2();
        JSONObject jSONObject = new JSONObject(str);
        String str2 = null;
        if (jSONObject.has("food")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("food");
            cJRFoodBeverageSetResponseV2.mFood = optJSONObject != null ? optJSONObject.toString() : null;
        }
        if (jSONObject.has(CJRFoodBeverageItemV2.FOOD_VOUCHER)) {
            JSONObject insertAdditionalFields = insertAdditionalFields(jSONObject.optJSONObject(CJRFoodBeverageItemV2.FOOD_VOUCHER), jSONObject);
            cJRFoodBeverageSetResponseV2.mFoodVoucher = insertAdditionalFields != null ? insertAdditionalFields.toString() : null;
        }
        if (jSONObject.has("3dglasses")) {
            JSONObject insertAdditionalFields2 = insertAdditionalFields(jSONObject.optJSONObject("3dglasses"), jSONObject);
            if (insertAdditionalFields2 != null) {
                str2 = insertAdditionalFields2.toString();
            }
            cJRFoodBeverageSetResponseV2.m3dGlass = str2;
        }
        return cJRFoodBeverageSetResponseV2;
    }

    private JSONObject insertAdditionalFields(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        if (jSONObject != null) {
            if (jSONObject2.has("bookingId")) {
                jSONObject.put("bookingId", jSONObject2.get("bookingId"));
            }
            if (jSONObject2.has("providerId")) {
                jSONObject.put("providerId", jSONObject2.get("providerId"));
            }
            if (jSONObject2.has("tempTransId")) {
                jSONObject.put("tempTransId", jSONObject2.get("tempTransId"));
            }
            if (jSONObject2.has("paytmCinemaId")) {
                jSONObject.put("paytmCinemaId", jSONObject2.get("paytmCinemaId"));
            }
            if (jSONObject2.has("showDateTime")) {
                jSONObject.put("showDateTime", jSONObject2.get("showDateTime"));
            }
            if (jSONObject2.has(H5Param.SESSION_ID)) {
                jSONObject.put(H5Param.SESSION_ID, jSONObject2.get(H5Param.SESSION_ID));
            }
        }
        return jSONObject;
    }
}
