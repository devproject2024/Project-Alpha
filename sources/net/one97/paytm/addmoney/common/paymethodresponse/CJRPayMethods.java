package net.one97.paytm.addmoney.common.paymethodresponse;

import com.google.gson.b.a;
import com.google.gson.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRPayMethods extends IJRPaytmDataModel implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private List<String> enabledFlows = null;
    private ExtendInfo extendInfo;
    private MerchantDetails merchantDetails;
    private String orderId;
    private PayMethodViews payMethodViews;
    private PostConvinienceFee postConvinienceFee;
    private ResultInfo resultInfo;
    private String signature;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public PostConvinienceFee getPostConvinienceFee() {
        return this.postConvinienceFee;
    }

    public void setPostConvinienceFee(PostConvinienceFee postConvinienceFee2) {
        this.postConvinienceFee = postConvinienceFee2;
    }

    public List<String> getEnabledFlows() {
        return this.enabledFlows;
    }

    public void setEnabledFlows(List<String> list) {
        this.enabledFlows = list;
    }

    public PayMethodViews getPayMethodViews() {
        return this.payMethodViews;
    }

    public void setPayMethodViews(PayMethodViews payMethodViews2) {
        this.payMethodViews = payMethodViews2;
    }

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(ExtendInfo extendInfo2) {
        this.extendInfo = extendInfo2;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }

    public MerchantDetails getMerchantDetails() {
        return this.merchantDetails;
    }

    public void setMerchantDetails(MerchantDetails merchantDetails2) {
        this.merchantDetails = merchantDetails2;
    }

    public void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.a(str, new a<CJRPayMethods>() {
            }.getType());
            JSONObject optJSONObject = jSONObject.optJSONObject("body");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("payMethodViews");
                if (optJSONObject2 != null) {
                    this.payMethodViews = (PayMethodViews) fVar.a(optJSONObject2.toString(), PayMethodViews.class);
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("enabledFlows");
                this.enabledFlows = new ArrayList();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.enabledFlows.add(optJSONArray.optString(i2));
                    }
                }
                setOrderId(optJSONObject.optString("orderId"));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
