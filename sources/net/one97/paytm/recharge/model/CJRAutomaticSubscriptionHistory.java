package net.one97.paytm.recharge.model;

import android.graphics.Color;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAutomaticSubscriptionHistory implements IJRDataModel {
    private final String FAILURE = "Failure";
    private final String PAYMENT_FAILURE = net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory.PAYMENT_FAILURE;
    private final String PROCESSING = net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory.PROCESSING;
    private final String SUCCESS = "Success";
    private int colorCode;
    @b(a = "order_id")
    public String orderId;
    @b(a = "pay_amt")
    public String payAmount;
    @b(a = "pay_date")
    public String payDate;
    @b(a = "pay_status")
    public String payStatus;
    @b(a = "pay_status_code")
    public int payStatusCode;

    public int isVisible() {
        return Color.parseColor("#ffffff") != this.colorCode ? 1 : 0;
    }

    public String getDate() {
        String str = this.payDate;
        return str.substring(12, str.length());
    }

    public void setColorCode(int i2) {
        this.colorCode = i2;
    }

    public int getStatusColorCode() {
        return this.colorCode;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getPayDate() {
        return this.payDate;
    }

    public void setPayDate(String str) {
        this.payDate = str;
    }

    public String getPayAmount() {
        return this.payAmount;
    }

    public void setPayAmount(String str) {
        this.payAmount = str;
    }

    public String getPayStatus() {
        return this.payStatus;
    }

    public void setPayStatus(String str) {
        this.payStatus = str;
    }

    public int getPayStatusCode() {
        int i2 = this.payStatusCode;
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return this.payStatusCode;
        }
        if (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory.PAYMENT_FAILURE.equalsIgnoreCase(this.payStatus)) {
            return 4;
        }
        if ("Success".equalsIgnoreCase(this.payStatus)) {
            return 3;
        }
        if (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory.PROCESSING.equalsIgnoreCase(this.payStatus)) {
            return 1;
        }
        if ("Failure".equalsIgnoreCase(this.payStatus)) {
            return 2;
        }
        return 0;
    }
}
