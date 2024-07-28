package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRFullFillmentObject implements IJRDataModel {
    private static String MERCHANT_NAME = "merchant_name";
    private static String PURITY = "purity";
    private String BALANCE = "balance";
    private String PPI_DETAILS_ID = "ppiDetailsId";
    private String SUB_WALLET_DETAILS = "subWalletDetails";
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
            q.b(e2.getMessage());
        }
        return this.jsonObject;
    }

    public String getMerchantName() {
        JSONObject fullFillment = getFullFillment();
        if (!fullFillment.isNull(MERCHANT_NAME)) {
            try {
                return fullFillment.getString(MERCHANT_NAME);
            } catch (JSONException e2) {
                q.b(e2.getMessage());
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
                q.b(e2.getMessage());
            }
        }
        return null;
    }

    public String getPpiDetailsId() {
        JSONObject fullFillment = getFullFillment();
        if (!fullFillment.isNull(this.SUB_WALLET_DETAILS)) {
            try {
                JSONArray jSONArray = new JSONArray(fullFillment.getString(this.SUB_WALLET_DETAILS));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (jSONArray.getJSONObject(i2).has(this.PPI_DETAILS_ID)) {
                        return jSONArray.getJSONObject(i2).getString(this.PPI_DETAILS_ID);
                    }
                }
            } catch (JSONException e2) {
                q.b(e2.getMessage());
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

    public double getBalance() {
        JSONObject fullFillment = getFullFillment();
        if (fullFillment != null && !fullFillment.isNull(this.BALANCE)) {
            try {
                return fullFillment.getDouble(this.BALANCE);
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
        return -1.0d;
    }
}
