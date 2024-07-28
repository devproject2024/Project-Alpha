package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class MerchantWiseDetail extends IJRDataModel {
    @a
    @b(a = "merchantDisplayName")
    private String merchantDisplayName;
    @a
    @b(a = "merchantTotalBlockedAmount")
    private Double merchantTotalBlockedAmount;
    @a
    @b(a = "txnLevelDetails")
    private List<TxnLevelDetail> txnLevelDetails = null;

    public String getMerchantDisplayName() {
        return this.merchantDisplayName;
    }

    public void setMerchantDisplayName(String str) {
        this.merchantDisplayName = str;
    }

    public Double getMerchantTotalBlockedAmount() {
        return this.merchantTotalBlockedAmount;
    }

    public void setMerchantTotalBlockedAmount(Double d2) {
        this.merchantTotalBlockedAmount = d2;
    }

    public List<TxnLevelDetail> getTxnLevelDetails() {
        return this.txnLevelDetails;
    }

    public void setTxnLevelDetails(List<TxnLevelDetail> list) {
        this.txnLevelDetails = list;
    }
}
