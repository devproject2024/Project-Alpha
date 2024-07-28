package net.one97.paytm.dynamic.module.mall.emiSubvention.nativepghelper;

import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.google.gson.f;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;
import net.one97.paytm.nativesdk.orflow.promo.model.GroupPId;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

class RequestHelper {
    RequestHelper() {
    }

    static JSONObject getApplyFreebieRequestBody(List<CJRPromoData> list, HashMap<Integer, Freebie> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "bulkadd");
            jSONObject.put("object", getBulkArray(list, hashMap));
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    private static JSONArray getBulkArray(List<CJRPromoData> list, HashMap<Integer, Freebie> hashMap) {
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        while (list != null && i2 < list.size()) {
            jSONArray.put(getBulkJson(i2, list, hashMap));
            i2++;
        }
        return jSONArray;
    }

    private static JSONObject getBulkJson(int i2, List<CJRPromoData> list, HashMap<Integer, Freebie> hashMap) {
        int i3;
        JSONObject jSONObject = new JSONObject();
        Freebie freebie = hashMap.get(Integer.valueOf(i2));
        if (freebie != null) {
            try {
                i3 = freebie.getPid();
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        } else {
            i3 = 0;
        }
        jSONObject.put(CLPConstants.PRODUCT_ID, i3);
        jSONObject.put("quantity", 1);
        jSONObject.put(CLConstants.INPUT_KEY_CONFIGURATION, getConfiguration(i2, list));
        return jSONObject;
    }

    private static JSONObject getConfiguration(int i2, List<CJRPromoData> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promo_parent_pid_key", getPromoParentKey(list.get(i2)));
            jSONObject.put("freebie_promo", list.get(i2).getPromocode());
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    private static String getPromoParentKey(CJRPromoData cJRPromoData) {
        StringBuilder sb = new StringBuilder();
        if (!(cJRPromoData == null || cJRPromoData.getGroupPids() == null)) {
            int i2 = 0;
            while (i2 < cJRPromoData.getGroupPids().size()) {
                sb.append(cJRPromoData.getGroupPids().get(i2).getPidKey());
                i2++;
                sb.append(i2 == cJRPromoData.getGroupPids().size() ? "" : "|");
            }
        }
        return sb.toString();
    }

    static List<CJRPromoData> getPromoDataArray(String str, String str2) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("cart");
            if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("promoData")) == null)) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    CJRPromoData promoDataObject = getPromoDataObject(optJSONArray.getJSONObject(i2));
                    if (!(promoDataObject == null || str2 == null || !str2.equalsIgnoreCase(promoDataObject.getPromocode()))) {
                        arrayList.add(promoDataObject);
                    }
                }
            }
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return arrayList;
    }

    static CJRPromoData getPromoDataObject(JSONObject jSONObject) {
        CJRPromoData cJRPromoData = new CJRPromoData();
        cJRPromoData.setPromocode(jSONObject.optString(Utility.EVENT_CATEGORY_PROMOCODE));
        cJRPromoData.setFreebieList(jSONObject.optString("freebieList"));
        cJRPromoData.setFreebieListUrl(jSONObject.optString("freebieListUrl"));
        try {
            cJRPromoData.setGroupPids(getGroupIdArray(jSONObject.optJSONArray("groupPids")));
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return cJRPromoData;
    }

    private static List<GroupPId> getGroupIdArray(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(getGroupIDObject(jSONArray.getJSONObject(i2)));
            }
        }
        return arrayList;
    }

    private static GroupPId getGroupIDObject(JSONObject jSONObject) {
        GroupPId groupPId = new GroupPId();
        groupPId.setPid(Integer.valueOf(jSONObject.optInt(Constants.URL_MEDIA_SOURCE)));
        groupPId.setPidKey(jSONObject.optString("pidKey"));
        groupPId.setQty(Integer.valueOf(jSONObject.optInt("pidKey")));
        return groupPId;
    }

    static JSONObject getApplyPromoRequestBody(boolean z, String str, String str2, String str3) {
        return getApplyPromoRequestBody(z, str, str2, str3, false);
    }

    static JSONObject getPaymentFilterRequestBody(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "getcart");
            jSONObject.put("paymentFilters", new JSONObject(str));
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    static CJPayMethodResponse getPaymentInstruments(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(CJRRechargeCart.KEY_PAYMENT_INSTRUMENT);
            if (optJSONObject != null) {
                return (CJPayMethodResponse) new f().a(optJSONObject.toString(), CJPayMethodResponse.class);
            }
            return null;
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    static JSONObject getPayIntentRequestBody(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "setpaymentintent");
            jSONObject.put("payment_intent", new JSONArray(str));
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    static JSONObject getRemovePayIntentBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "removepaymentintent");
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }

    static JSONObject getApplyPromoRequestBody(boolean z, String str, String str2, String str3, boolean z2) {
        String str4 = z ? "applypromo" : "cancelpromo";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", str4);
            if (z2) {
                jSONObject.put("globalcode", str2);
            } else if (z) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("item_map", jSONObject2.put(str + Constants.URL_MEDIA_SOURCE, str2));
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str + Constants.URL_MEDIA_SOURCE);
                jSONObject.put("removed_item", jSONArray);
            }
            if ((z || z2) && !TextUtils.isEmpty(str3)) {
                jSONObject.put("payment_intent", new JSONArray(str3));
            }
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
        return jSONObject;
    }
}
