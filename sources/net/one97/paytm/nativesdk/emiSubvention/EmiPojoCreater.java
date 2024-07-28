package net.one97.paytm.nativesdk.emiSubvention;

import java.util.ArrayList;
import java.util.HashSet;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmiPojoCreater {
    private static final String EMI_BANK_CODE = "bankCode";
    private static final String EMI_BANK_DETAILS = "emi_bank_details";
    private static final String EMI_BANK_LOGO_URL = "bankLogoUrl";
    private static final String EMI_BANK_NAME = "bankName";
    private static final String EMI_CARD_TYPE = "cardType";
    private static final String EMI_CARD_TYPES = "cardTypes";
    private static final String EMI_LABEL = "label";
    private static final String EMI_REAL_BANK_DETAILS = "bankDetails";
    private static final String EMI_TYPE = "type";

    public static ArrayList<BankData> getBankList(String str) {
        JSONArray jSONArray;
        ArrayList<BankData> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        JSONObject jSONObject = getJSONObject(str);
        if (!(jSONObject == null || (jSONArray = getJSONArray(jSONObject, EMI_BANK_DETAILS)) == null)) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("type");
                    String optString2 = optJSONObject.optString("label");
                    JSONArray optJSONArray = optJSONObject.optJSONArray(EMI_CARD_TYPES);
                    if (optJSONArray != null) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                            String optString3 = optJSONObject2.optString("cardType");
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray(EMI_REAL_BANK_DETAILS);
                            if (optJSONArray2 != null) {
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                                    BankData enabled = new BankData().setBankName(optJSONObject3.optString(EMI_BANK_NAME)).setBankCode(optJSONObject3.optString(EMI_BANK_CODE)).setBankLogoUrl(optJSONObject3.optString("bankLogoUrl")).setType(optString).setLabel(optString2).setCardType(optString3).setEnabled(true);
                                    if (!hashSet.contains(optString)) {
                                        enabled.setTitle();
                                        hashSet.add(optString);
                                        BankData bankData = arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : null;
                                        if (bankData != null) {
                                            bankData.setLastData(true);
                                        }
                                    }
                                    arrayList.add(enabled);
                                }
                            }
                        }
                    }
                }
            }
        }
        BankData bankData2 = arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : null;
        if (bankData2 != null) {
            bankData2.setIsEndData(true);
        }
        return arrayList;
    }

    private static JSONObject getJSONObject(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
            return null;
        }
    }

    private static JSONArray getJSONArray(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }
}
