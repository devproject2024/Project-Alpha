package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderItems implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isOrderSelected;
    private boolean isSendToBankEnabled;
    private boolean isUpdated;
    private String mDate;
    @b(a = "fulfillment_req")
    private FulFillmentRequest mFulFillmentReq;
    @b(a = "id")
    private long mId;
    @b(a = "item_detail_url")
    private String mItemDetailUrl;
    @b(a = "item_status")
    private String mItemStatus;
    @b(a = "merchant_id")
    private String mMerchantId;
    @b(a = "name")
    private String mName;
    private String mOrderId;
    @b(a = "price")
    private String mPrice;
    @b(a = "product")
    private CJROrderItemProduct mProduct;
    @b(a = "quantity")
    private String mQuantity;
    @b(a = "repeat")
    private boolean mRepeat;
    @b(a = "retry")
    private boolean mRetry;
    @b(a = "status")
    private String mStatus;
    @b(a = "status_text")
    private String mStatusText;
    @b(a = "status_text2")
    private String mStatusText2;
    @b(a = "subtotal")
    private String mSubTotal;
    @b(a = "total_price")
    private String mTotalPrice;
    @b(a = "orderId")
    private long orderId;
    private int orderItemSelected = 0;
    @b(a = "is_physical")
    private boolean physical;

    public long getId() {
        return this.mId;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public FulFillmentRequest getmFulFillmentReq() {
        return this.mFulFillmentReq;
    }

    public String getmMerchantId() {
        return this.mMerchantId;
    }

    public void setmMerchantId(String str) {
        this.mMerchantId = str;
    }

    public String getmItemDetailUrl() {
        return this.mItemDetailUrl;
    }

    public void setmItemDetailUrl(String str) {
        this.mItemDetailUrl = str;
    }

    public String getmStatusText2() {
        return this.mStatusText2;
    }

    public boolean isPhysical() {
        return this.physical;
    }

    public String getmDate() {
        return this.mDate;
    }

    public void setmDate(String str) {
        this.mDate = str;
    }

    public String getmOrderId() {
        return this.mOrderId;
    }

    public void setmOrderId(String str) {
        this.mOrderId = str;
    }

    public boolean isSendToBankEnabled() {
        return this.isSendToBankEnabled;
    }

    public void setSendToBankEnabled(boolean z) {
        this.isSendToBankEnabled = z;
    }

    public CJROrderItemProduct getProduct() {
        return this.mProduct;
    }

    public void setProduct(CJROrderItemProduct cJROrderItemProduct) {
        this.mProduct = cJROrderItemProduct;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public String getTotalPrice() {
        return this.mTotalPrice;
    }

    public String getSubTotal() {
        return this.mSubTotal;
    }

    public String getStatusText() {
        return this.mStatusText;
    }

    public void setStatusText(String str) {
        this.mStatusText = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getItemStatus() {
        return this.mItemStatus;
    }

    public boolean getIsRetry() {
        return this.mRetry;
    }

    public boolean getIsRepeat() {
        return this.mRepeat;
    }

    public boolean isOrderSelected() {
        return this.isOrderSelected;
    }

    public void setOrderSelected(boolean z) {
        this.isOrderSelected = z;
    }

    public CJROrderItems clone() throws CloneNotSupportedException {
        return (CJROrderItems) super.clone();
    }

    public void setmRetry(boolean z) {
        this.mRetry = z;
    }

    public void setmRepeat(boolean z) {
        this.mRepeat = z;
    }

    public boolean isUpdated() {
        return this.isUpdated;
    }

    public void setUpdated(boolean z) {
        this.isUpdated = z;
    }

    public int getOrderItemSelected() {
        return this.orderItemSelected;
    }

    public void setOrderItemSelected(int i2) {
        this.orderItemSelected = i2;
    }

    public long getOrderId() {
        return this.orderId;
    }
}
