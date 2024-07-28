package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class TxnLevelDetail extends IJRDataModel {
    @a
    @b(a = "blockedAmount")
    private Double blockedAmount;
    @a
    @b(a = "expectedReleaseDate")
    private String expectedReleaseDate;
    @a
    @b(a = "orderId")
    private String orderId;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public Double getBlockedAmount() {
        return this.blockedAmount;
    }

    public void setBlockedAmount(Double d2) {
        this.blockedAmount = d2;
    }

    public String getExpectedReleaseDate() {
        return this.expectedReleaseDate;
    }

    public void setExpectedReleaseDate(String str) {
        this.expectedReleaseDate = str;
    }
}
