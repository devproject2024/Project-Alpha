package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRefund implements IJRDataModel {
    @b(a = "refund_initiated")
    boolean refundInitiated = false;
    @b(a = "status_text")
    private String status_text;
    @b(a = "total")
    private int totalRefund;
    @b(a = "transaction_details")
    private ArrayList<CJRTransactionDetails> transactionDetails;

    public String getStatus_text() {
        return this.status_text;
    }

    public ArrayList<CJRTransactionDetails> getTransactionDetails() {
        return this.transactionDetails;
    }

    public int getTotalRefund() {
        return this.totalRefund;
    }

    public boolean isRefundInitiated() {
        return this.refundInitiated;
    }
}
