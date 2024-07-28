package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.myorder.CJRFullfillments;
import net.one97.paytm.common.entity.wallet.CJRLedger;

public class CJROrderList extends IJRPaytmDataModel implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "fulfillments")
    private ArrayList<CJRFullfillments> fullfillments;
    @b(a = "isExchangeOrder")
    private int isExchnageOrder;
    private boolean isFooter = false;
    @b(a = "isZeroEMIOrder")
    private int isZeroEMIOrder;
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
    @b(a = "order_list_type")
    private int orderListType;
    @b(a = "order_status")
    private int orderStatus;
    @b(a = "is_physical")
    private boolean physical;
    @b(a = "total_exchange_cashback")
    private int totalExchangeCashback;
    @b(a = "total_markup_amount")
    private int totalMarkupAmount;
    @b(a = "total_zero_emi_cashback")
    private int totalZeroEmiCashback;
    @b(a = "total_zero_emi_discount")
    private int totalZeroEmiDiscount;

    public boolean isPhysical() {
        return this.physical;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public CJRLedger getLedger() {
        return this.mLedger;
    }

    public boolean isFooter() {
        return this.isFooter;
    }

    public void setFooter(boolean z) {
        this.isFooter = z;
    }

    public void setLedger(CJRLedger cJRLedger) {
        this.mLedger = cJRLedger;
    }

    public ArrayList<CJROrderItems> getOrderItems() {
        return this.mOrderItems;
    }

    public String getOrderID() {
        return this.mOrderID;
    }

    public String getOrderName() {
        return this.mOrderName;
    }

    public String getDate() {
        return this.mDate;
    }

    public String getAmount() {
        return this.mAmount;
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

    public String getStatusIcon() {
        return this.mStatusIcon;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void setOrderID(String str) {
        this.mOrderID = str;
    }

    public void setOrderName(String str) {
        this.mOrderName = str;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public void setAmount(String str) {
        this.mAmount = str;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public void setOrderItems(ArrayList<CJROrderItems> arrayList) {
        this.mOrderItems = arrayList;
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

    public ArrayList<CJRFullfillments> getFullfillments() {
        return this.fullfillments;
    }

    public void setFullfillments(ArrayList<CJRFullfillments> arrayList) {
        this.fullfillments = arrayList;
    }

    public int getOrderListType() {
        return this.orderListType;
    }

    public void setOrderListType(int i2) {
        this.orderListType = i2;
    }

    public int getTotalExchangeCashback() {
        return this.totalExchangeCashback;
    }

    public void setTotalExchangeCashback(int i2) {
        this.totalExchangeCashback = i2;
    }

    public int getTotalMarkupAmount() {
        return this.totalMarkupAmount;
    }

    public void setTotalMarkupAmount(int i2) {
        this.totalMarkupAmount = i2;
    }

    public int getTotalZeroEmiCashback() {
        return this.totalZeroEmiCashback;
    }

    public void setTotalZeroEmiCashback(int i2) {
        this.totalZeroEmiCashback = i2;
    }

    public int getTotalZeroEmiDiscount() {
        return this.totalZeroEmiDiscount;
    }

    public void setTotalZeroEmiDiscount(int i2) {
        this.totalZeroEmiDiscount = i2;
    }

    public int getIsExchnageOrder() {
        return this.isExchnageOrder;
    }

    public void setIsExchnageOrder(int i2) {
        this.isExchnageOrder = i2;
    }

    public int getIsZeroEMIOrder() {
        return this.isZeroEMIOrder;
    }

    public void setIsZeroEMIOrder(int i2) {
        this.isZeroEMIOrder = i2;
    }
}
