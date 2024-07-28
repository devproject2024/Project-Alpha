package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRInputFields;
import net.one97.paytm.common.entity.recharge.CJRRechargeDetailProductList;
import org.json.JSONObject;

public class CJRGroupField implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private ArrayList<CJRGroupField> groupFields;
    private ArrayList<CJRInputFields> inputFields;
    private ArrayList<String> mCheckedIds = new ArrayList<>();
    private ArrayList<ArrayList<CJRInputFields>> mGroupFieldsArray;
    private ArrayList<CJRRechargeVarientDetail> mGrouplist;
    private transient ArrayList<JSONObject> mJSONObject;
    @b(a = "key")
    public String mKey;
    @b(a = "label")
    public String mLabel;
    @b(a = "name")
    public String mName;
    private CJRRechargeDetailProductList mProductList;
    private ArrayList<CJRRechargeDetailProductList> mRechargeProductList;
    @b(a = "type")
    public String mType;
    private transient ArrayList<JSONObject> mVArientObject;
    @b(a = "showfield")
    public boolean showfield = true;

    public void setType(String str) {
        this.mType = str;
    }

    public CJRRechargeDetailProductList getmProductList() {
        return this.mProductList;
    }

    public ArrayList<JSONObject> getVArientObject() {
        return this.mVArientObject;
    }

    public String getmName() {
        return this.mName;
    }

    public String getmType() {
        return this.mType;
    }

    public String getmLabel() {
        return this.mLabel;
    }

    public String getKey() {
        return this.mKey;
    }

    public void setmJSONObject(ArrayList<JSONObject> arrayList) {
        this.mJSONObject = arrayList;
    }

    public ArrayList<JSONObject> getJSONObject() {
        return this.mJSONObject;
    }

    public void setJSONObject(ArrayList<JSONObject> arrayList) {
        this.mJSONObject = arrayList;
    }

    public void setVariantObject(ArrayList<JSONObject> arrayList) {
        this.mVArientObject = arrayList;
    }

    public ArrayList<CJRRechargeVarientDetail> getmGrouplist() {
        return this.mGrouplist;
    }

    public void setGroupFieldData(ArrayList<CJRRechargeVarientDetail> arrayList) {
        this.mGrouplist = arrayList;
    }

    public void setProductData(CJRRechargeDetailProductList cJRRechargeDetailProductList) {
        this.mProductList = cJRRechargeDetailProductList;
    }

    public void setInputFields(ArrayList<CJRInputFields> arrayList) {
        this.inputFields = arrayList;
    }

    public ArrayList<CJRGroupField> getGroupFields() {
        return this.groupFields;
    }

    public void setCJRGroupFields(ArrayList<CJRGroupField> arrayList) {
        this.groupFields = arrayList;
    }

    public ArrayList<CJRRechargeDetailProductList> getRechargeProductList() {
        return this.mRechargeProductList;
    }

    public void setRechargeProductList(ArrayList<CJRRechargeDetailProductList> arrayList) {
        this.mRechargeProductList = arrayList;
    }

    public void setGroupInputFieldsArray(ArrayList<ArrayList<CJRInputFields>> arrayList) {
        this.mGroupFieldsArray = arrayList;
    }

    public ArrayList<ArrayList<CJRInputFields>> getGroupInputFieldsArray() {
        return this.mGroupFieldsArray;
    }

    public ArrayList<String> getmCheckedIds() {
        return this.mCheckedIds;
    }

    public void setmCheckedIds(ArrayList<String> arrayList) {
        this.mCheckedIds = arrayList;
    }

    public boolean isShowfield() {
        return this.showfield;
    }

    public void setShowfield(boolean z) {
        this.showfield = z;
    }
}
