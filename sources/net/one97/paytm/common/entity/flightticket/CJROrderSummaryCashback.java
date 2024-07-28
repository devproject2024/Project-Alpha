package net.one97.paytm.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryCashback implements IJRDataModel {
    private String amount;
    private String cashback_text;

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getCashback_text() {
        return this.cashback_text;
    }

    public void setCashback_text(String str) {
        this.cashback_text = str;
    }
}
