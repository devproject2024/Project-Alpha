package net.one97.paytm.upi.common.entity.upi;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class UpiPendingRequestModel implements IJRDataModel {
    @c(a = "account")
    private String mAccount;
    @c(a = "amount")
    private String mAmount;
    @c(a = "bank")
    private String mBank;
    @c(a = "date")
    private String mDate;
    @c(a = "direction")
    private String mDirection;
    @c(a = "expireAfter")
    private String mExpireAfter;
    @c(a = "ifsc")
    private String mIfsc;
    @c(a = "narration")
    private String mNarration;
    @c(a = "note")
    private String mNote;
    @c(a = "payeeName")
    private String mPayeeName;
    @c(a = "payeeVa")
    private String mPayeeVa;
    @c(a = "payerName")
    private String mPayerName;
    @c(a = "payerVa")
    private String mPayerVa;
    @c(a = "seqNo")
    private String mSeqNo;
    @c(a = "status")
    private String mStatus;
    @c(a = "txnId")
    private String mTxnId;
    @c(a = "type")
    private String mType;
    @c(a = "upiTranlogId")
    private String mUpiTranlogId;

    public String getAmount() {
        return this.mAmount;
    }

    public String getPayeeVa() {
        return this.mPayeeVa;
    }

    public String getPayeeName() {
        return this.mPayeeName;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getSeqNo() {
        return this.mSeqNo;
    }

    public String getDirection() {
        return this.mDirection;
    }

    public String getUpiTranlogId() {
        return this.mUpiTranlogId;
    }

    public String getExpireAfter() {
        return this.mExpireAfter;
    }

    public String getType() {
        return this.mType;
    }

    public String getDate() {
        return this.mDate;
    }

    public String getPayerVa() {
        return this.mPayerVa;
    }

    public String getPayerName() {
        return this.mPayerName;
    }

    public String getNote() {
        return this.mNote;
    }

    public String getBank() {
        return this.mBank;
    }

    public String getNarration() {
        return this.mNarration;
    }

    public String getIfsc() {
        return this.mIfsc;
    }

    public String getAccount() {
        return this.mAccount;
    }

    public String getTxnId() {
        return this.mTxnId;
    }
}
