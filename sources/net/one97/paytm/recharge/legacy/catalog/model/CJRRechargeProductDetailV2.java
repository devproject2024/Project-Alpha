package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRRechargeProductDetailV2 extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "meta_description")
    private String mMetaDescription;
    @b(a = "name")
    private String mName;
    @b(a = "removeProducts")
    private CJRRechargeUtilRemoveProduct mRemoveProducts;
    @b(a = "variants")
    private ArrayList<CJRVarients> mVarients;
    private ArrayList<JSONObject> object = new ArrayList<>();

    public ArrayList<JSONObject> getObject() {
        return this.object;
    }

    public CJRRechargeUtilRemoveProduct getRemoveProducts() {
        return this.mRemoveProducts;
    }

    public void setRemoveProducts(CJRRechargeUtilRemoveProduct cJRRechargeUtilRemoveProduct) {
        this.mRemoveProducts = cJRRechargeUtilRemoveProduct;
    }

    public String getName() {
        return this.mName;
    }

    public ArrayList<CJRVarients> getVarients() {
        return this.mVarients;
    }

    public void parseJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = 0;
            if (jSONObject.has("variants")) {
                JSONArray jSONArray = jSONObject.getJSONArray("variants");
                while (i2 < jSONArray.length()) {
                    this.object.add(jSONArray.getJSONObject(i2));
                    i2++;
                }
            } else if (jSONObject.has("ProductList")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("ProductList");
                while (i2 < jSONArray2.length()) {
                    this.object.add(jSONArray2.getJSONObject(i2));
                    i2++;
                }
            }
        } catch (JSONException e2) {
            q.d(e2.getMessage());
        }
    }

    public String getProductMetaDescription() {
        return this.mMetaDescription;
    }
}
