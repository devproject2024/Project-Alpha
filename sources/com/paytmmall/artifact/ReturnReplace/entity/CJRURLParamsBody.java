package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.paytmmall.artifact.cart.entity.CJRAddress;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRURLParamsBody extends IJRPaytmDataModel {
    private final String ANDROID = "android";
    private final String CART_INFO = "cart_info";
    private final String CATEGORY_ID = "category_id";
    private final String CHANNEL = "channel";
    private final String COMMENT = CJRQRScanResultModel.KEY_COMMENT_SMALL;
    private final String ISSUE_INFO = "issue_info";
    private final String PICKUPADDRESS = "pickupAddress";
    private final String REASON_ID = "reason_id";
    private final String RETURN_INFO = "return_info";
    String TAG_LOG = "CJRURLParamsBody";
    private final String TYPE = "type";
    @b(a = "cart_info")
    private CJRCartInfo cartInfo;
    @b(a = "category_id")
    private String categoryId;
    @b(a = "comment")
    private String comment;
    @b(a = "issue_info")
    private CJRIssueInfo issueInfo;
    @b(a = "reason_id")
    private String reasonId;

    public String prepareReturnPostBody(int i2, int i3, String str, int i4, CJRAddress cJRAddress, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("category_id", String.valueOf(i2));
            jSONObject2.put("reason_id", String.valueOf(i3));
            jSONObject2.put("channel", "android");
            jSONObject2.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, str);
            jSONObject2.put("type", i4);
            jSONObject2.put("pickupAddress", getPickupAddress(cJRAddress));
            if (jSONObject != null && jSONObject.length() > 0) {
                jSONObject2.put("refundConsultInfo", jSONObject);
            }
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject2.toString();
    }

    private JSONObject getPickupAddress(CJRAddress cJRAddress) {
        JSONObject jSONObject = new JSONObject();
        if (cJRAddress != null) {
            try {
                jSONObject.put("firstname", cJRAddress.getName());
                jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, cJRAddress.getAddress1());
                jSONObject.put("address2", cJRAddress.getAddress2());
                jSONObject.put("city", cJRAddress.getCity());
                jSONObject.put("state", cJRAddress.getState());
                jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, cJRAddress.getPin());
                jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_COUNTRY, cJRAddress.getCountry());
                jSONObject.put(ContactColumn.PHONE_NUMBER, cJRAddress.getMobile());
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        return jSONObject;
    }

    public String prepareReplacePostBody(int i2, long j, int i3, CJRAddress cJRAddress, CJRAddress cJRAddress2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.issueInfo != null) {
                jSONObject.put("issue_info", this.issueInfo.getIssueJSON(i2));
            }
            if (this.cartInfo != null && j >= 0) {
                jSONObject.put("cart_info", this.cartInfo.getIssueJSON(j, cJRAddress2));
            }
            jSONObject.put("return_info", getReturnInfoObject(cJRAddress, i3));
            jSONObject.put("channel", "android");
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject.toString();
    }

    private JSONObject getReturnInfoObject(CJRAddress cJRAddress, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("pickupAddress", getPickupAddress(cJRAddress));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
