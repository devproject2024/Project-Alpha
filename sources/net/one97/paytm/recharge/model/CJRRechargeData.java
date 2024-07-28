package net.one97.paytm.recharge.model;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargeProduct;

public class CJRRechargeData implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isFastForward;
    private String mAmount;
    private String mCircle;
    private int mCircleSelectionIndex;
    private int mConfigSelected;
    private String mNo;
    private String mOperator;
    private String mOperatorDisplay;
    private String mOperatorUrl;
    private String mOperatorUrlType;
    private String mProductId;
    private String mPromoCode;
    private CJRRechargeProduct mRechargeProduct;

    public int getCircleSelectionIndex() {
        return this.mCircleSelectionIndex;
    }

    public void setCircleSelectionIndex(int i2) {
        this.mCircleSelectionIndex = i2;
    }

    public int getConfigSelected() {
        return this.mConfigSelected;
    }

    public void setConfigSelected(int i2) {
        this.mConfigSelected = i2;
    }

    public String getOperatorUrl() {
        return this.mOperatorUrl;
    }

    public void setOperatorUrl(String str) {
        this.mOperatorUrl = str;
    }

    public String getOperatorUrlType() {
        return this.mOperatorUrlType;
    }

    public void setOperatorUrlType(String str) {
        this.mOperatorUrlType = str;
    }

    public boolean isFastForward() {
        return this.isFastForward;
    }

    public void setFastForward(boolean z) {
        this.isFastForward = z;
    }

    public String getOperator() {
        return this.mOperator;
    }

    public void setOperator(String str) {
        this.mOperator = str;
    }

    public String getCircle() {
        return this.mCircle;
    }

    public void setCircle(String str) {
        this.mCircle = str;
    }

    public String getAmount() {
        return this.mAmount;
    }

    public void setAmount(String str) {
        this.mAmount = str;
    }

    public String getNo() {
        return this.mNo;
    }

    public void setNo(String str) {
        this.mNo = str;
    }

    public CJRRechargeProduct getRechargeProduct() {
        return this.mRechargeProduct;
    }

    public void setRechargeProduct(CJRRechargeProduct cJRRechargeProduct) {
        this.mRechargeProduct = cJRRechargeProduct;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setPromoCode(String str) {
        this.mPromoCode = str;
    }

    public String getPromoCode() {
        return this.mPromoCode;
    }

    public String getOperatorDisplay() {
        return this.mOperatorDisplay;
    }

    public void setOperatorDisplay(String str) {
        this.mOperatorDisplay = str;
    }
}
