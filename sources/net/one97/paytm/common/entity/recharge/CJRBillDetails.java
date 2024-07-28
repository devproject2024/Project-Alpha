package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBillDetails implements IJRDataModel {
    @b(a = "amount")
    private Double amount;
    @b(a = "bill_date")
    private String billDate;
    @b(a = "bills_label_color")
    private String billsLabelColor;
    private int daysDiff;
    @b(a = "due_date")
    private String dueDate;
    @b(a = "expiry")
    private String expiry;
    private String label;
    @b(a = "last_paid_amount")
    private Double lastPaidAmount = null;
    @b(a = "min_due_amount")
    private Double minDueAmount = null;
    @b(a = "original_due_amount")
    private Double originalDueAmount = null;
    @b(a = "original_min_due_amount")
    private Double originalMinDueAmount = null;
    @b(a = "plan")
    private String plan;
    @b(a = "plan_bucket")
    private String planBucket;

    public void setBillDate(String str) {
        this.billDate = str;
    }

    public String getPlanBucket() {
        return this.planBucket;
    }

    public void setPlanBucket(String str) {
        this.planBucket = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setBillsLabelColor(String str) {
        this.billsLabelColor = str;
    }

    public String getBillsLabelColor() {
        return this.billsLabelColor;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public Double getAmount() {
        Double d2 = this.amount;
        return Double.valueOf(d2 == null ? 0.0d : d2.doubleValue());
    }

    public int getDaysDiff() {
        return this.daysDiff;
    }

    public void setDaysDiff(int i2) {
        this.daysDiff = i2;
    }

    public String getExpiry() {
        return this.expiry;
    }

    public String getBillDate() {
        return this.billDate;
    }

    public String getPlan() {
        return this.plan;
    }

    public double getMinDueAmount() {
        Double d2 = this.minDueAmount;
        if (d2 == null) {
            return -1000.0d;
        }
        return d2.doubleValue();
    }

    public double getOriginalDueAmount() {
        Double d2 = this.originalDueAmount;
        if (d2 == null) {
            return -1000.0d;
        }
        return d2.doubleValue();
    }

    public double getOriginalMinDueAmount() {
        Double d2 = this.originalMinDueAmount;
        if (d2 == null) {
            return -1000.0d;
        }
        return d2.doubleValue();
    }

    public double getLastPaidAmount() {
        Double d2 = this.lastPaidAmount;
        if (d2 == null) {
            return -1000.0d;
        }
        return d2.doubleValue();
    }
}
