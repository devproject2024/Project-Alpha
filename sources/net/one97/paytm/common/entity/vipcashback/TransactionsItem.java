package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TransactionsItem extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cancellation_text")
    private String cancellationText;
    @b(a = "status")
    private String status;
    @b(a = "transaction_amount")
    private double transactionAmount;
    @b(a = "transaction_time")
    private String transactionTime;
    @b(a = "user_mobile_no")
    private String userMobileNo;

    public String getUserMobileNo() {
        return this.userMobileNo;
    }

    public String getCancellationText() {
        return this.cancellationText;
    }

    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public String getTransactionTime() {
        return this.transactionTime;
    }

    public String getStatus() {
        return this.status;
    }
}
