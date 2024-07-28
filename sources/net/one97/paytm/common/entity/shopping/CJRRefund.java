package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRefund implements IJRDataModel {
    @b(a = "refundDestinationSwitchReason")
    private String refundDestinationSwitchReason;
    @b(a = "refund_initiated")
    boolean refundInitiated = false;
    @b(a = "status")
    private int status;
    @b(a = "status_text")
    private String status_text;
    @b(a = "total")
    private double totalRefund;
    @b(a = "transaction_details")
    private ArrayList<CJRTransactionDetails> transactionDetails;
    @b(a = "userCreditInitiateTimestamp")
    private String userCreditInitiateTimestamp;

    public String getStatus_text() {
        return this.status_text;
    }

    public ArrayList<CJRTransactionDetails> getTransactionDetails() {
        return this.transactionDetails;
    }

    public double getTotalRefund() {
        return this.totalRefund;
    }

    public boolean isRefundInitiated() {
        return this.refundInitiated;
    }

    public String getUserCreditInitiateTimestamp() {
        return this.userCreditInitiateTimestamp;
    }

    public String getRefundDestinationSwitchReason() {
        return this.refundDestinationSwitchReason;
    }

    public int getStatus() {
        return this.status;
    }
}
