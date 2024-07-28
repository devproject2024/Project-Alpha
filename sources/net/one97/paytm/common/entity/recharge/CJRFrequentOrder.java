package net.one97.paytm.common.entity.recharge;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.g;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.v2.CJRCardBaseModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRFrequentOrder extends CJRCardBaseModel implements Cloneable, Comparable<CJRFrequentOrder>, IJRDataModel {
    private static final long serialVersionUID = 1;
    public final String TAG_CREDIT_CARD_ID = "creditCardId";
    public final String TAG_DISPLAY_VALUES = "displayValues";
    public final String TAG_PAY_TYPE = "paytype";
    public final String TAG_RECHARGE_AMOUNT = "price";
    public final String TAG_RECHARGE_AMOUNT2 = "price_new";
    public final String TAG_RECHARGE_NUMBER = "recharge_number";
    public final String TAG_RECHARGE_NUMBER_2 = "recharge_number_2";
    public final String TAG_SERVICE = "service";
    private String automaticScheduledText;
    private CJRBillDetails cjrBillDetails;
    private String contactName;
    private String date;
    private ArrayList<String> displayValueKeys = new ArrayList<>();
    private Map<String, String> displayValueMap = new HashMap();
    private boolean isBillDueToday;
    private boolean isFirstLoad = true;
    private boolean isMarkAsPaidShown;
    private boolean isPaytmFirst;
    private boolean isPhoneContact;
    @b(a = "bills")
    private List<CJRBillDetails> mBillDetails;
    @b(a = "BillReminder")
    private Boolean mBillReminder;
    private String mCircle;
    @b(a = "configuration")
    private Map<String, String> mConfiguration;
    @b(a = "created_desc")
    protected String mCreatedAt;
    @b(a = "cta")
    private HashMap<String, Object> mCtaMap;
    @b(a = "favLabel")
    private String mFavLabel;
    @b(a = "favLabelId")
    private String mFavOrderId;
    @b(a = "cta_obj")
    private HashMap<String, Object> mNewCtaMap;
    @b(a = "operatorData")
    private Map<String, String> mOperatorData;
    @b(a = "operatorRecentData")
    private Map<String, Object> mOperatorDataNew;
    @b(a = "updated_at")
    private String mPaidOn;
    private String mPhoneCarrierName;
    private String mPhoneNumber;
    @b(a = "price_new")
    private String mPriceNew;
    @b(a = "product_id")
    private String mProductID;
    @b(a = "product")
    private CJRFrequentOrderProduct mProducts;
    @b(a = "frequency")
    private int mRechargeFrequency;
    private String mService;
    private boolean maskAmount = false;
    private String name;
    @b(a = "ope_logo_url")
    private String operatorLogoURL;
    @b(a = "reminderNotificationEnabled")
    private Boolean reminderNotificationEnabled;
    public String viewType;

    public CJRFrequentOrder() {
    }

    public CJRFrequentOrder(String str, String str2) {
        this.mPhoneNumber = str;
        this.mPhoneCarrierName = str2;
    }

    public void setCtaMap(HashMap<String, Object> hashMap) {
        this.mCtaMap = hashMap;
    }

    public HashMap<String, Object> getCtaMap() {
        return this.mCtaMap;
    }

    public void setNewCtaMap(HashMap<String, Object> hashMap) {
        this.mNewCtaMap = hashMap;
    }

    public HashMap<String, Object> getNewCtaMap() {
        return this.mNewCtaMap;
    }

    public String getPaidOn() {
        return this.mPaidOn;
    }

    public String getFavLabel() {
        return this.mFavLabel;
    }

    public String getFavOrderId() {
        return this.mFavOrderId;
    }

    public int getRechargeFrequency() {
        return this.mRechargeFrequency;
    }

    public Map<String, String> getConfiguration() {
        return this.mConfiguration;
    }

    public Boolean getReminderNotificationEnabled() {
        return this.reminderNotificationEnabled;
    }

    public void setReminderNotificationEnabled(Boolean bool) {
        this.reminderNotificationEnabled = bool;
    }

    public CJRFrequentOrderProduct getFrequentOrderProduct() {
        return this.mProducts;
    }

    public String getRechargeNumber() {
        if (this.mConfiguration.containsKey("recharge_number")) {
            return this.mConfiguration.get("recharge_number");
        }
        return new StringBuilder().toString();
    }

    public String getRechargeNumber2() {
        if (this.mConfiguration.containsKey("recharge_number_2")) {
            return this.mConfiguration.get("recharge_number_2");
        }
        return new StringBuilder().toString();
    }

    public String getRechargeAmount() {
        if (this.mConfiguration.containsKey("price")) {
            return this.mConfiguration.get("price");
        }
        return new StringBuilder().toString();
    }

    public void setMaskAmount(boolean z) {
        this.maskAmount = z;
    }

    public boolean isAmountMasked() {
        return this.maskAmount;
    }

    public String getNewRechargeAmount() {
        if (this.mConfiguration.containsKey("price_new")) {
            return this.mConfiguration.get("price_new");
        }
        return new StringBuilder().toString();
    }

    public String getService() {
        return this.mProducts.getService();
    }

    public String getPayType() {
        return this.mProducts.getPaytype();
    }

    public String getOperator() {
        return this.mProducts.getOperator();
    }

    public int compareTo(CJRFrequentOrder cJRFrequentOrder) {
        return cJRFrequentOrder.getRechargeFrequency() - this.mRechargeFrequency;
    }

    public String getOperatorLabel() {
        return this.mProducts.getOperatorLabel();
    }

    public String getOperatorDisplayLabel() {
        if (!TextUtils.isEmpty(this.mProducts.getOperatorDisplayLabel())) {
            return this.mProducts.getOperatorDisplayLabel();
        }
        return getOperatorLabel();
    }

    public String getProductID() {
        return this.mProductID;
    }

    public String getConfigAsJSON() {
        return new f().a((Object) this.mConfiguration);
    }

    public String getCircle() {
        return this.mProducts.getCircle();
    }

    public String getOperatorLogoURL() {
        return this.operatorLogoURL;
    }

    public void setOperatorLogoURL(String str) {
        this.operatorLogoURL = str;
    }

    public String getAutomaticScheduledText() {
        return this.automaticScheduledText;
    }

    public void setAutomaticScheduledText(String str) {
        this.automaticScheduledText = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public String getPhoneCarrierName() {
        return this.mPhoneCarrierName;
    }

    public void setPhoneCarrierName(String str) {
        this.mPhoneCarrierName = str;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getmCreatedAt() {
        return this.mCreatedAt;
    }

    public void setmCreatedAt(String str) {
        this.mCreatedAt = str;
    }

    public String getPayLabel() {
        return this.mProducts.getPaytypeLabel();
    }

    public String getPayTypeDisplayLabel() {
        if (!TextUtils.isEmpty(this.mProducts.getPayTypeDisplayLabel())) {
            return this.mProducts.getPayTypeDisplayLabel();
        }
        return getPayLabel();
    }

    public String setRechargeNumber(String str) {
        Map<String, String> map = this.mConfiguration;
        if (map == null) {
            this.mConfiguration = new HashMap();
            return this.mConfiguration.put("recharge_number", str);
        }
        map.put("recharge_number", str);
        return "";
    }

    public void setPhoneContact(boolean z) {
        this.isPhoneContact = z;
    }

    public boolean isPhoneContact() {
        return this.isPhoneContact;
    }

    public void setService(String str) {
        if (this.mProducts == null) {
            this.mProducts = new CJRFrequentOrderProduct();
        }
        this.mProducts.setService(str);
    }

    public List<CJRBillDetails> getmBillDetails() {
        return this.mBillDetails;
    }

    public boolean isBillDueToday() {
        return this.isBillDueToday;
    }

    public void setBillDueToday(boolean z) {
        this.isBillDueToday = z;
    }

    public CJRBillDetails getCjrBillDetails() {
        return this.cjrBillDetails;
    }

    public void setCjrBillDetails(CJRBillDetails cJRBillDetails) {
        this.cjrBillDetails = cJRBillDetails;
    }

    public CJRFrequentOrder clone() throws CloneNotSupportedException {
        return (CJRFrequentOrder) super.clone();
    }

    public boolean isMarkAsPaidShown() {
        return this.isMarkAsPaidShown;
    }

    public void setMarkAsPaidShown(boolean z) {
        this.isMarkAsPaidShown = z;
    }

    public boolean isFirstLoad() {
        return this.isFirstLoad;
    }

    public void setFirstLoad(boolean z) {
        this.isFirstLoad = z;
    }

    public Map<String, String> getmOperatorData() {
        return this.mOperatorData;
    }

    public void setmOperatorData(Map<String, String> map) {
        this.mOperatorData = map;
    }

    public Map<String, Object> getOperatorDataNew() {
        return this.mOperatorDataNew;
    }

    public void setOperatorDataNew(Map<String, Object> map) {
        this.mOperatorDataNew = map;
    }

    public String getBankCode() {
        CJRFrequentOrderProduct cJRFrequentOrderProduct = this.mProducts;
        if (cJRFrequentOrderProduct != null) {
            return cJRFrequentOrderProduct.getBankCode();
        }
        return null;
    }

    public String getCardType() {
        CJRFrequentOrderProduct cJRFrequentOrderProduct = this.mProducts;
        if (cJRFrequentOrderProduct != null) {
            return cJRFrequentOrderProduct.getCardType();
        }
        return null;
    }

    public String getCardId() {
        Map<String, String> map = this.mOperatorData;
        if (map == null || !map.containsKey("creditCardId")) {
            return new StringBuilder().toString();
        }
        return this.mOperatorData.get("creditCardId");
    }

    public Boolean getBillReminder() {
        return this.mBillReminder;
    }

    public Map<String, String> getProductAttributes() {
        return this.mProducts.getAttributes();
    }

    public String getViewType() {
        return this.viewType;
    }

    public void setViewType(String str) {
        this.viewType = str;
    }

    public JSONArray getDisplayValue() {
        Map<String, Object> map = this.mOperatorDataNew;
        if (map != null && map.containsKey("displayValues")) {
            try {
                JSONArray jSONArray = new JSONObject(new g().a().a((Object) this.mOperatorDataNew)).getJSONArray("displayValues");
                generateKeyValueMap(jSONArray);
                return jSONArray;
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
        return null;
    }

    private void generateKeyValueMap(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    if (jSONObject != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                this.displayValueKeys.add(next);
                                this.displayValueMap.put(next, jSONObject.get(next).toString());
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public ArrayList<String> getDisplayValueKeys() {
        return this.displayValueKeys;
    }

    public Map<String, String> getDisplayValueMap() {
        return this.displayValueMap;
    }

    public boolean isPaytmFirst() {
        return this.isPaytmFirst;
    }

    public void setIsPaytmFirstCard(boolean z) {
        this.isPaytmFirst = z;
    }
}
