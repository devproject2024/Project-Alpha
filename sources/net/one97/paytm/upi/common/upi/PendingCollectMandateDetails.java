package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class PendingCollectMandateDetails implements IJRDataModel {
    @c(a = "accRefId")
    private String accRefId;
    @c(a = "amountRule")
    private String amountRule;
    @c(a = "lastAmount")
    private String lastAmount;
    @c(a = "maxDebitAmount")
    private String maxDebitAmount;
    @c(a = "recurrence")
    private String recurrence;
    @c(a = "recurrenceRule")
    private String recurrenceRule;
    @c(a = "recurrenceType")
    private String recurrenceType;
    @c(a = "type")
    private String type;
    @c(a = "umn")
    private String umn;
    @c(a = "validityEndDate")
    private String validityEndDate;
    @c(a = "validityStartDate")
    private String validityStartDate;

    public String getMaxDebitAmount() {
        return this.maxDebitAmount;
    }

    public void setMaxDebitAmount(String str) {
        this.maxDebitAmount = str;
    }

    public String getLastAmount() {
        return this.lastAmount;
    }

    public String getAmountRule() {
        return this.amountRule;
    }

    public String getUmn() {
        return this.umn;
    }

    public String getValidityEndDate() {
        return this.validityEndDate;
    }

    public String getValidityStartDate() {
        return this.validityStartDate;
    }

    public String getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public String getRecurrenceType() {
        return this.recurrenceType;
    }

    public String getRecurrence() {
        return this.recurrence;
    }

    public String getAccRefId() {
        return this.accRefId;
    }

    public String getType() {
        return this.type;
    }

    public void setUmn(String str) {
        this.umn = str;
    }
}
