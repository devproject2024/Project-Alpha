package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank;

public class CJRBusOrderSummary extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "aggregate_item_price")
    private String mAggregateItemPrice;
    @b(a = "created_at")
    private String mCreatedAt;
    @b(a = "id")
    private String mId;
    @b(a = "items")
    private ArrayList<CJRBusOrderedCart> mOrderedCartList;
    @b(a = "payments")
    private ArrayList<CJROrderSummaryPayment> mPaymentInfo;
    @b(a = "payment_status")
    private String mPaymentStatus;
    @b(a = "payment_text")
    private String mPaymentText;
    @b(a = "refund")
    private CJROrderSummaryRefundToBank mRefundToBank;
    @b(a = "status")
    private String mStatus;
    @b(a = "onward_bank_cashback")
    private Double onwardBankCashback;
    @b(a = "onward_bank_discount")
    private Double onwardBankDiscount;
    @b(a = "order_status")
    private int orderStatus;
    @b(a = "refund_source_text")
    private String refundSourceText;
    @b(a = "return_bank_cashback")
    private Double returnBankCashback;
    @b(a = "return_bank_discount")
    private Double returnBankDiscount;

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getPaymentStatus() {
        return this.mPaymentStatus;
    }

    public ArrayList<CJRBusOrderedCart> getOrderedCartList() {
        return this.mOrderedCartList;
    }

    public ArrayList<CJROrderSummaryPayment> getPaymentInfo() {
        return this.mPaymentInfo;
    }

    public String getId() {
        return this.mId;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getCreatedAt() {
        return this.mCreatedAt;
    }

    public String getPaymentText() {
        return this.mPaymentText;
    }

    public CJROrderSummaryRefundToBank getRefund() {
        return this.mRefundToBank;
    }

    public String getAggregateItemPrice() {
        return this.mAggregateItemPrice;
    }

    public String getRefundSourceText() {
        return this.refundSourceText;
    }

    public Double getOnwardBankDiscount() {
        return this.onwardBankDiscount;
    }

    public Double getOnwardBankCashback() {
        return this.onwardBankCashback;
    }

    public Double getReturnBankDiscount() {
        return this.returnBankDiscount;
    }

    public Double getReturnBankCashback() {
        return this.returnBankCashback;
    }
}
