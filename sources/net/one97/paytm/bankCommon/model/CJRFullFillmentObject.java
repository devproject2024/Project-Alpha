package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRFullFillmentObject implements IJRDataModel {
    private static String MERCHANT_NAME = "merchant_name";
    private static String PURITY = "purity";
    private transient JSONObject jsonObject;
    @b(a = "fulfillment_response")
    private String mFulfillmentResponse;

    public String getFulfillmentResponse() {
        return this.mFulfillmentResponse;
    }

    public void setFulfillmentResponse(String str) {
        this.mFulfillmentResponse = str;
    }

    public JSONObject getFullFillment() {
        String str = this.mFulfillmentResponse;
        if (str == null) {
            return null;
        }
        try {
            this.jsonObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.jsonObject;
    }

    public String getMerchantName() {
        JSONObject fullFillment = getFullFillment();
        if (!fullFillment.isNull(MERCHANT_NAME)) {
            try {
                return fullFillment.getString(MERCHANT_NAME);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public String getPurity() {
        JSONObject fullFillment = getFullFillment();
        if (!fullFillment.isNull(PURITY)) {
            try {
                return fullFillment.getString(PURITY);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public CJRGiftCardFulfillmentMetaData getProductFulfillmentMetaData() {
        JSONObject fullFillment = getFullFillment();
        if (fullFillment == null) {
            return null;
        }
        return (CJRGiftCardFulfillmentMetaData) new f().a(fullFillment.toString(), CJRGiftCardFulfillmentMetaData.class);
    }
}
