package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTransactionDetails extends IJRPaytmDataModel {
    @b(a = "amount")
    private double amount;
    @b(a = "message")
    private String message;
    @b(a = "payment_mode")
    private String payment_mode;

    public String getPayment_mode() {
        return this.payment_mode;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getMessage() {
        return this.message;
    }
}
