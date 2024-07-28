package net.one97.paytm.common.entity.paymentsbank;

import com.google.gsonhtcfix.a.b;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UADPincode extends IJRPaytmDataModel implements IJRDataModel {
    private HashSet<String> cities;
    private String pincode;
    private ArrayList<SubPincode> pincodeList;
    @b(a = "addressDictionary")
    private Map<String, List<SubPincode>> pincodeMap;
    private String responseCode;
    private String responseMessage;

    public class SubPincode {
        private String pincode;
        private String state;
        private String tier3Type;
        private String tier3Value;
        private String tier4Type;
        private String tier4Value;
        private String zone;

        public SubPincode() {
        }

        public String getPincode() {
            return this.pincode;
        }

        public void setPincode(String str) {
            this.pincode = str;
        }

        public String getZone() {
            return this.zone;
        }

        public void setZone(String str) {
            this.zone = str;
        }

        public String getState() {
            return this.state;
        }

        public void setState(String str) {
            this.state = str;
        }

        public String getTier3Type() {
            return this.tier3Type;
        }

        public void setTier3Type(String str) {
            this.tier3Type = str;
        }

        public String getTier3Value() {
            return this.tier3Value;
        }

        public void setTier3Value(String str) {
            this.tier3Value = str;
        }

        public String getTier4Type() {
            return this.tier4Type;
        }

        public void setTier4Type(String str) {
            this.tier4Type = str;
        }

        public String getTier4Value() {
            return this.tier4Value;
        }

        public void setTier4Value(String str) {
            this.tier4Value = str;
        }
    }

    public Map<String, List<SubPincode>> getPincodeMap() {
        return this.pincodeMap;
    }

    public void setPincodeMap(Map<String, List<SubPincode>> map) {
        this.pincodeMap = map;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getPincode() {
        return this.pincode;
    }

    public ArrayList<SubPincode> getPincodeList() {
        return this.pincodeList;
    }

    public void setPincode(String str) {
        this.pincode = str;
    }

    public String[] getCities() {
        HashSet<String> hashSet = this.cities;
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public void parseJsonString(String str) {
        JSONArray jSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.responseCode = jSONObject.optString("responseCode");
            this.responseMessage = jSONObject.optString("responseMessage");
            JSONObject optJSONObject = jSONObject.optJSONObject("addressDictionary");
            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray(this.pincode)) != null && jSONArray.length() > 0) {
                this.pincodeList = new ArrayList<>();
                this.cities = new HashSet<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        SubPincode subPincode = new SubPincode();
                        subPincode.setPincode(jSONObject2.optString(AddEditGstinViewModelKt.BODY_PARAM_PINCODE));
                        subPincode.setZone(jSONObject2.optString("zone"));
                        subPincode.setState(jSONObject2.optString("state"));
                        subPincode.setTier3Type(jSONObject2.optString("tier3Type"));
                        subPincode.setTier3Value(jSONObject2.optString("tier3Value"));
                        subPincode.setTier4Type(jSONObject2.optString("tier4Type"));
                        subPincode.setTier4Value(jSONObject2.optString("tier4Value"));
                        this.cities.add(jSONObject2.optString("tier3Value"));
                        this.pincodeList.add(subPincode);
                    }
                }
            }
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        }
    }
}
