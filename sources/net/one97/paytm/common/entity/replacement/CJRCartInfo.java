package net.one97.paytm.common.entity.replacement;

import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRCartInfo implements IJRDataModel {
    private final String ADDRESS = "replacement_address";
    private final String PRODUCT_ID = CLPConstants.PRODUCT_ID;
    @b(a = "product_id")
    private String productId;

    public JSONObject getIssueJSON(long j, CJRAddress cJRAddress) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CLPConstants.PRODUCT_ID, String.valueOf(j));
            jSONObject.put("replacement_address", getAddress(cJRAddress));
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    private JSONObject getAddress(CJRAddress cJRAddress) {
        JSONObject jSONObject = new JSONObject();
        if (cJRAddress != null) {
            try {
                jSONObject.put("id", cJRAddress.getId());
                jSONObject.put("name", cJRAddress.getName());
                jSONObject.put("city", cJRAddress.getCity());
                jSONObject.put("state", cJRAddress.getState());
                jSONObject.put("pin", cJRAddress.getPin());
                jSONObject.put("mobile", cJRAddress.getMobile());
                jSONObject.put("address1", cJRAddress.getAddress1());
                jSONObject.put("address2", cJRAddress.getAddress2());
                jSONObject.put("priority", cJRAddress.getPriority());
                jSONObject.put("title", cJRAddress.getTitle());
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
        return jSONObject;
    }
}
