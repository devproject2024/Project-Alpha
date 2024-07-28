package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryPayment implements IJRDataModel {
    public static final int KIND_PAYMENT = 1;
    public static final int KIND_REFUND = 2;
    private static final long serialVersionUID = 1;
    @b(a = "bank_transaction_id")
    private String mBankTransactionId;
    @b(a = "created_at")
    private String mCreatedAt;
    @b(a = "gateway")
    private String mGateway;
    @b(a = "id")
    private String mId;
    @b(a = "kind")
    private int mKind;
    @b(a = "mid")
    private String mMID;
    @b(a = "order_id")
    private String mOrderId;
    @b(a = "payment_bank")
    private String mPaymentBank;
    @b(a = "payment_method")
    private String mPaymentMethod;
    @b(a = "payment_option")
    private String mPaymentOption;
    @b(a = "paytm_cash")
    private double mPaytmCash;
    @b(a = "pg_amount")
    private double mPgAmount;
    @b(a = "pg_response_code")
    private String mPgResponseCode;
    @b(a = "provider")
    private String mProvider;
    @b(a = "status")
    private String mStatus;
    @b(a = "transaction_number")
    private String mTransactionNumber;
    @b(a = "transaction_response")
    private String mTransactionResponse;
    @b(a = "wallet_transaction_id")
    private String mWalletTranactionId;
    @b(a = "wallet_type")
    private String mWalletType;

    public double getmPgAmount() {
        return this.mPgAmount;
    }

    public void setmPgAmount(double d2) {
        this.mPgAmount = d2;
    }

    public String getId() {
        return this.mId;
    }

    public String getPaymentMethod() {
        return this.mPaymentMethod;
    }

    public String getPaymentOption() {
        return this.mPaymentOption;
    }

    public String getGateway() {
        return this.mGateway;
    }

    public String getTransactionNumber() {
        return this.mTransactionNumber;
    }

    public String getTransactionResponse() {
        return this.mTransactionResponse;
    }

    public double getPaytmCash() {
        return this.mPaytmCash;
    }

    public double getPgAmount() {
        return this.mPgAmount;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getMID() {
        return this.mMID;
    }

    public String getProvider() {
        return this.mProvider;
    }

    public String getPaymentBank() {
        return this.mPaymentBank;
    }

    public String getBankTransactionId() {
        return this.mBankTransactionId;
    }

    public String getWalletTranactionId() {
        return this.mWalletTranactionId;
    }

    public String getWalletType() {
        return this.mWalletType;
    }

    public String getPgResponseCode() {
        return this.mPgResponseCode;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getCreatedAt() {
        return this.mCreatedAt;
    }

    public int getKind() {
        return this.mKind;
    }
}
