package net.one97.paytm.recharge.model;

import android.text.TextUtils;
import android.util.Pair;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJRDynamicBrowsePlans extends IJRPaytmDataModel implements IJRDataModel {
    public String operator;
    public boolean planFetchSuccessful;
    public UserPlansResponse userPlansResponse;

    public static class UserPlansResponse implements IJRDataModel {
        public String connectionError;
        public boolean deducedStatus;
        public String deducedStatusDetails;
        public String noBill;
        public String operatorErrorCode;
        public String operatorErrorMessage;
        public ArrayList<DynamicPlansData> plansArray;
        public ArrayList<StaticPlansData> staticPlansData;

        public boolean isDeducedStatus() {
            return this.deducedStatus;
        }

        public void setDeducedStatus(boolean z) {
            this.deducedStatus = z;
        }

        public String getNoBill() {
            return this.noBill;
        }

        public void setNoBill(String str) {
            this.noBill = str;
        }

        public String getDeducedStatusDetails() {
            return this.deducedStatusDetails;
        }

        public void setDeducedStatusDetails(String str) {
            this.deducedStatusDetails = str;
        }

        public String getOperatorErrorCode() {
            return this.operatorErrorCode;
        }

        public void setOperatorErrorCode(String str) {
            this.operatorErrorCode = str;
        }

        public String getOperatorErrorMessage() {
            return this.operatorErrorMessage;
        }

        public void setOperatorErrorMessage(String str) {
            this.operatorErrorMessage = str;
        }

        public String getConnectionError() {
            return this.connectionError;
        }

        public void setConnectionError(String str) {
            this.connectionError = str;
        }

        public ArrayList<DynamicPlansData> getPlansArray() {
            return this.plansArray;
        }

        public void setPlansArray(ArrayList<DynamicPlansData> arrayList) {
            this.plansArray = arrayList;
        }

        public ArrayList<StaticPlansData> getStaticPlansData() {
            return this.staticPlansData;
        }

        public void setStaticPlansData(ArrayList<StaticPlansData> arrayList) {
            this.staticPlansData = arrayList;
        }
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public boolean isPlanFetchSuccessful() {
        return this.planFetchSuccessful;
    }

    public void setPlanFetchSuccessful(boolean z) {
        this.planFetchSuccessful = z;
    }

    public UserPlansResponse getUserPlansResponse() {
        return this.userPlansResponse;
    }

    public void setUserPlansResponse(UserPlansResponse userPlansResponse2) {
        this.userPlansResponse = userPlansResponse2;
    }

    public static class StaticPlansData implements IJRDataModel {
        private String planDescription;
        private String planGuiId;
        private String planId;
        private String planName;
        private String planPrice;
        private String planValidity;

        public String getPlanGuiId() {
            return this.planGuiId;
        }

        public void setPlanGuiId(String str) {
            this.planGuiId = str;
        }

        public String getPlanId() {
            return this.planId;
        }

        public void setPlanId(String str) {
            this.planId = str;
        }

        public String getPlanName() {
            return this.planName;
        }

        public void setPlanName(String str) {
            this.planName = str;
        }

        public String getPlanPrice() {
            return this.planPrice;
        }

        public void setPlanPrice(String str) {
            this.planPrice = str;
        }

        public String getPlanDescription() {
            return this.planDescription;
        }

        public void setPlanDescription(String str) {
            this.planDescription = str;
        }

        public String getPlanValidity() {
            return this.planValidity;
        }

        public void setPlanValidity(String str) {
            this.planValidity = str;
        }
    }

    public static class DynamicPlansData implements IJRDataModel {
        private boolean isOTC;
        public List<Pair<String, String>> planColumns;
        public String planKey;
        public String planLabel;
        public ArrayList<HashMap<String, String>> plansColumnsData;
        public String transactionType;

        public boolean isOTC() {
            return this.isOTC;
        }

        public void setOTC(boolean z) {
            this.isOTC = z;
        }

        public String getPlanKey() {
            return this.planKey;
        }

        public void setPlanKey(String str) {
            this.planKey = str;
        }

        public String getPlanLabel() {
            return this.planLabel;
        }

        public void setPlanLabel(String str) {
            this.planLabel = str;
        }

        public String getTransactionType() {
            return this.transactionType;
        }

        public void setTransactionType(String str) {
            this.transactionType = str;
        }

        public List<Pair<String, String>> getPlanColumns() {
            return this.planColumns;
        }

        public void setPlanColumns(List<Pair<String, String>> list) {
            this.planColumns = list;
        }

        public ArrayList<HashMap<String, String>> getPlansColumnsData() {
            return this.plansColumnsData;
        }

        public void setPlansColumnsData(ArrayList<HashMap<String, String>> arrayList) {
            this.plansColumnsData = arrayList;
        }
    }

    public void parseJSONObject(String str) {
        String str2;
        JSONArray jSONArray;
        JSONObject jSONObject;
        String str3;
        StaticPlansData staticPlansData;
        JSONObject optJSONObject;
        String str4 = "PlanGuiId";
        String str5 = "Order";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                if (jSONObject2.has(StringSet.operator)) {
                    setOperator(jSONObject2.getString(StringSet.operator));
                }
                if (jSONObject2.has("planFetchSuccessful")) {
                    setPlanFetchSuccessful(jSONObject2.getBoolean("planFetchSuccessful"));
                }
                if (jSONObject2.has("userplansGwResponse")) {
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("userplansGwResponse");
                    UserPlansResponse userPlansResponse2 = new UserPlansResponse();
                    if (optJSONObject2 != null) {
                        int i2 = 0;
                        userPlansResponse2.setDeducedStatus(optJSONObject2.optBoolean("deducedStatus", false));
                        userPlansResponse2.setNoBill(optJSONObject2.optString("deducedStatus", (String) null));
                        userPlansResponse2.setDeducedStatusDetails(optJSONObject2.optString("deducedStatusDetails", (String) null));
                        userPlansResponse2.setOperatorErrorCode(optJSONObject2.optString("operatorErrorCode", (String) null));
                        userPlansResponse2.setOperatorErrorMessage(optJSONObject2.optString("operatorErrorMessage", (String) null));
                        userPlansResponse2.setConnectionError(optJSONObject2.optString("connectionError", (String) null));
                        if (optJSONObject2.has("plansArray")) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            JSONArray optJSONArray = optJSONObject2.optJSONArray("plansArray");
                            if (optJSONArray == null) {
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("plansArray");
                                optJSONArray = new JSONArray();
                                optJSONArray.put(optJSONObject3);
                            }
                            if (optJSONArray.length() > 0) {
                                JSONObject optJSONObject4 = optJSONArray.optJSONObject(0);
                                JSONArray optJSONArray2 = optJSONObject4.optJSONArray(str5);
                                int i3 = 0;
                                while (i3 < optJSONArray2.length()) {
                                    DynamicPlansData dynamicPlansData = new DynamicPlansData();
                                    StaticPlansData staticPlansData2 = new StaticPlansData();
                                    String string = optJSONArray2.getString(i3);
                                    if (!(string == null || (optJSONObject = optJSONObject4.optJSONObject(string)) == null)) {
                                        dynamicPlansData.setOTC(optJSONObject.optBoolean("isOTC"));
                                        dynamicPlansData.setPlanKey(string);
                                        dynamicPlansData.setPlanLabel(optJSONObject.optString("Label"));
                                        dynamicPlansData.setTransactionType(optJSONObject.optString("TransactionType"));
                                        JSONObject optJSONObject5 = optJSONObject.optJSONObject("Plans");
                                        if (optJSONObject5 != null) {
                                            JSONArray optJSONArray3 = optJSONObject5.optJSONArray(str5);
                                            ArrayList<Pair> arrayList3 = new ArrayList<>();
                                            str3 = str5;
                                            while (i2 < optJSONArray3.length()) {
                                                JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i2);
                                                arrayList3.add(new Pair(optJSONObject6.optString("name"), optJSONObject6.optString("label")));
                                                i2++;
                                                optJSONObject4 = optJSONObject4;
                                                optJSONArray2 = optJSONArray2;
                                                staticPlansData2 = staticPlansData2;
                                            }
                                            jSONObject = optJSONObject4;
                                            jSONArray = optJSONArray2;
                                            arrayList3.add(new Pair("PlanId", "PlanId"));
                                            arrayList3.add(new Pair(str4, str4));
                                            dynamicPlansData.setPlanColumns(arrayList3);
                                            JSONArray optJSONArray4 = optJSONObject5.optJSONArray("Data");
                                            ArrayList arrayList4 = new ArrayList();
                                            staticPlansData = staticPlansData2;
                                            int i4 = 0;
                                            while (i4 < optJSONArray4.length()) {
                                                JSONObject optJSONObject7 = optJSONArray4.optJSONObject(i4);
                                                HashMap hashMap = new HashMap();
                                                for (Pair pair : arrayList3) {
                                                    String str6 = str4;
                                                    if (optJSONObject7.optString((String) pair.first) != null && optJSONObject7.has((String) pair.first)) {
                                                        hashMap.put(pair.first, optJSONObject7.getString((String) pair.first));
                                                    }
                                                    str4 = str6;
                                                }
                                                arrayList4.add(hashMap);
                                                staticPlansData = setStaticPlansDataWithMap(hashMap);
                                                i4++;
                                                str4 = str4;
                                            }
                                            str2 = str4;
                                            dynamicPlansData.setPlansColumnsData(arrayList4);
                                            arrayList.add(dynamicPlansData);
                                            arrayList2.add(staticPlansData);
                                            i3++;
                                            str5 = str3;
                                            optJSONObject4 = jSONObject;
                                            optJSONArray2 = jSONArray;
                                            str4 = str2;
                                            i2 = 0;
                                        }
                                    }
                                    str2 = str4;
                                    str3 = str5;
                                    jSONObject = optJSONObject4;
                                    jSONArray = optJSONArray2;
                                    staticPlansData = staticPlansData2;
                                    arrayList.add(dynamicPlansData);
                                    arrayList2.add(staticPlansData);
                                    i3++;
                                    str5 = str3;
                                    optJSONObject4 = jSONObject;
                                    optJSONArray2 = jSONArray;
                                    str4 = str2;
                                    i2 = 0;
                                }
                            }
                            userPlansResponse2.setPlansArray(arrayList);
                            userPlansResponse2.setStaticPlansData(arrayList2);
                        }
                    }
                    setUserPlansResponse(userPlansResponse2);
                }
            } catch (Exception unused) {
            }
        }
    }

    private StaticPlansData setStaticPlansDataWithMap(HashMap<String, String> hashMap) {
        StaticPlansData staticPlansData = new StaticPlansData();
        if (hashMap.containsKey("PlanId")) {
            staticPlansData.setPlanId(hashMap.get("PlanId"));
        }
        if (hashMap.containsKey("PlanName")) {
            staticPlansData.setPlanName(hashMap.get("PlanName"));
        }
        if (hashMap.containsKey("PlanCostInRs")) {
            staticPlansData.setPlanPrice(hashMap.get("PlanCostInRs"));
        }
        if (hashMap.containsKey("PlanGuiId")) {
            staticPlansData.setPlanGuiId(hashMap.get("PlanGuiId"));
        }
        return staticPlansData;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        parseJSONObject(str);
        return this;
    }
}
