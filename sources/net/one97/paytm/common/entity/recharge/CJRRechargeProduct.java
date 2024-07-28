package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.CJRError;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRProduct;

public class CJRRechargeProduct extends CJRProduct {
    private static final long serialVersionUID = 1;
    @b(a = "circle")
    protected String mCircle;
    private ArrayList<CJRCircle> mCircles;
    @b(a = "configurations")
    private CJRRechargeConfiguration mConfiguration;
    @b(a = "convenience_fee")
    private String mConvenientFee;
    @b(a = "error")
    private CJRError mError;
    @b(a = "fetch_amt")
    protected boolean mFetchAmt;
    @b(a = "form_fields")
    private ArrayList<CJRInputFields> mFormFields;
    @b(a = "input_fields")
    private ArrayList<CJRInputFields> mInputFields;
    @b(a = "max_amount")
    private int mMaxAmount;
    @b(a = "message")
    private String mMessage;
    @b(a = "min_amount")
    private int mMinAmount;
    @b(a = "image")
    private String mOperatorImageUrl;
    @b(a = "operator_label")
    private String mOperatorLabel;
    @b(a = "prefetch")
    private int mPrefetch;
    @b(a = "product_id")
    protected String mProductId;
    @b(a = "regEx")
    private String mRegExp;
    @b(a = "short_desc")
    private String mShortDesc;
    @b(a = "softblock")
    private boolean mSoftblock;
    @b(a = "status")
    private String mStatus;
    @b(a = "type")
    protected String mType;

    public String getmOperatorImageUrl() {
        return this.mOperatorImageUrl;
    }

    public void setmOperatorImageUrl(String str) {
        this.mOperatorImageUrl = str;
    }

    public ArrayList<CJRInputFields> getInputFields() {
        return this.mInputFields;
    }

    public ArrayList<CJRInputFields> getFormFields() {
        return this.mFormFields;
    }

    public String getShortDesc() {
        return this.mShortDesc;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public int getMinAmount() {
        return this.mMinAmount;
    }

    public int getMaxAmount() {
        return this.mMaxAmount;
    }

    public String getOperatorLabel() {
        return this.mOperatorLabel;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public boolean getSoftblock() {
        return this.mSoftblock;
    }

    public CJRError getError() {
        return this.mError;
    }

    public String getCircle() {
        return this.mCircle;
    }

    public void setCircle(String str) {
        this.mCircle = str;
    }

    public String getmProductId() {
        return this.mProductId;
    }

    public ArrayList<CJRCircle> getCircles() {
        return this.mCircles;
    }

    public void setCircles(ArrayList<CJRCircle> arrayList) {
        this.mCircles = arrayList;
    }

    public String getConvenientFee() {
        return this.mConvenientFee;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public String getName() {
        return this.mName;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public CJRRechargeConfiguration getConfiguration() {
        return this.mConfiguration;
    }

    public String getRegExp() {
        return this.mRegExp;
    }

    public void setConfiguration(CJRRechargeConfiguration cJRRechargeConfiguration) {
        this.mConfiguration = cJRRechargeConfiguration;
    }

    public void setRegExp(String str) {
        this.mRegExp = str;
    }

    public int getmPrefetch() {
        return this.mPrefetch;
    }

    public boolean isFetchable() {
        return this.mFetchAmt;
    }

    public String getmMessage() {
        return this.mMessage;
    }

    public void setmMessage(String str) {
        this.mMessage = str;
    }
}
