package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;

public class CJROrder extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private String mAmount;
    @b(a = "date")
    private String mDate;
    @b(a = "item_count")
    private int mItemCount;
    @b(a = "order_detail_url")
    private String mOrderDetailUrl;
    @b(a = "order_id")
    private String mOrderID;
    @b(a = "order_name")
    private String mOrderName;
    @b(a = "product_type")
    private String mProductType;
    @b(a = "status")
    private String mStatus;
    @b(a = "status_icon")
    private String mStatusIcon;

    public int getItemCount() {
        return this.mItemCount;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public String getOrderID() {
        return this.mOrderID;
    }

    public String getDate() {
        return this.mDate;
    }

    public String getAmount() {
        return this.mAmount;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getStatusIcon() {
        return this.mStatusIcon;
    }

    public String getOrderDetailUrl() {
        return this.mOrderDetailUrl;
    }

    public String getName() {
        return this.mOrderName;
    }
}
