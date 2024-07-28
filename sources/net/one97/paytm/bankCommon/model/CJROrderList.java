package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderList extends IJRPaytmDataModel implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    private boolean isFooter = false;
    @b(a = "amount")
    private String mAmount;
    @b(a = "date")
    private String mDate;
    @b(a = "id")
    private String mID;
    @b(a = "item_count")
    private int mItemCount;
    private CJRLedger mLedger;
    @b(a = "lifafa")
    private CJRLifafa mLifafa;
    @b(a = "order_detail_url")
    private String mOrderDetailUrl;
    @b(a = "order_id")
    private String mOrderID;
    @b(a = "items")
    private ArrayList<CJROrderItems> mOrderItems;
    @b(a = "order_name")
    private String mOrderName;
    @b(a = "payment_status")
    private String mPaymentStatus;
    @b(a = "refund")
    private CJROrderSummaryRefundToBank mRefundToBank;
    @b(a = "status")
    private String mStatus;
    @b(a = "status_icon")
    private String mStatusIcon;
    private int orderItemSelected = 0;
    @b(a = "order_status")
    private int orderStatus;
    @b(a = "is_physical")
    private boolean physical;

    public boolean isPhysical() {
        return this.physical;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public CJRLedger getLedger() {
        return this.mLedger;
    }

    public void setLedger(CJRLedger cJRLedger) {
        this.mLedger = cJRLedger;
    }

    public boolean isFooter() {
        return this.isFooter;
    }

    public void setFooter(boolean z) {
        this.isFooter = z;
    }

    public ArrayList<CJROrderItems> getOrderItems() {
        return this.mOrderItems;
    }

    public void setOrderItems(ArrayList<CJROrderItems> arrayList) {
        this.mOrderItems = arrayList;
    }

    public String getOrderID() {
        return this.mOrderID;
    }

    public void setOrderID(String str) {
        this.mOrderID = str;
    }

    public String getOrderName() {
        return this.mOrderName;
    }

    public void setOrderName(String str) {
        this.mOrderName = str;
    }

    public String getDate() {
        return this.mDate;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public String getAmount() {
        return this.mAmount;
    }

    public void setAmount(String str) {
        this.mAmount = str;
    }

    public String getPaymentStatus() {
        return this.mPaymentStatus;
    }

    public String getmOrderDetailUrl() {
        return this.mOrderDetailUrl;
    }

    public void setmOrderDetailUrl(String str) {
        this.mOrderDetailUrl = str;
    }

    public CJROrderSummaryRefundToBank getRefund() {
        return this.mRefundToBank;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getStatusIcon() {
        return this.mStatusIcon;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int getOrderItemSelected() {
        return this.orderItemSelected;
    }

    public void setOrderItemSelected(int i2) {
        this.orderItemSelected = i2;
    }

    public CJROrderList clone() throws CloneNotSupportedException {
        return (CJROrderList) super.clone();
    }

    public CJRLifafa getLifafa() {
        return this.mLifafa;
    }

    public String getID() {
        return this.mID;
    }

    public void setID(String str) {
        this.mID = str;
    }
}
