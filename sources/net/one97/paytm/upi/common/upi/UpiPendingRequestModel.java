package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class UpiPendingRequestModel implements IJRDataModel {
    @c(a = "amount")
    private String amount;
    @c(a = "date")
    private String date;
    @c(a = "direction")
    private String direction;
    @c(a = "expireAfter")
    private String expireAfter;
    @c(a = "isVerifiedMerchant")
    private boolean isVerifiedMerchant;
    @c(a = "logoUrl")
    private String logoUrl;
    @c(a = "seqNo")
    private String mSeqNo;
    @c(a = "upiTranlogId")
    private String mUpiTranlogId;
    @c(a = "mandateDetails")
    private PendingCollectMandateDetails mandateDetails;
    @c(a = "mcc")
    private String mcc;
    @c(a = "narration")
    private String narration;
    @c(a = "note")
    private String note;
    @c(a = "payeeName")
    private String payeeName;
    @c(a = "payeeVa")
    private String payeeVa;
    @c(a = "payerName")
    private String payerName;
    @c(a = "payerVa")
    private String payerVa;
    @c(a = "purpose")
    private String purpose;
    @c(a = "refCategory")
    private String refCategory;
    @c(a = "refUrl")
    private String refUrl;
    @c(a = "txnId")
    private String txnId;
    @c(a = "type")
    private String type;

    public String getmUpiTranlogId() {
        return this.mUpiTranlogId;
    }

    public String getMcc() {
        return this.mcc;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public void setMcc(String str) {
        this.mcc = str;
    }

    public void setPurpose(String str) {
        this.purpose = str;
    }

    public String getUpiTranlogId() {
        return this.mUpiTranlogId;
    }

    public String getRefCategory() {
        return this.refCategory;
    }

    public String getRefUrl() {
        return this.refUrl;
    }

    public String getSeqNo() {
        return this.mSeqNo;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getPayerName() {
        return this.payerName;
    }

    public String getPayerVa() {
        return this.payerVa;
    }

    public String getNarration() {
        return this.narration;
    }

    public String getPayeeName() {
        return this.payeeName;
    }

    public PendingCollectMandateDetails getMandateDetails() {
        return this.mandateDetails;
    }

    public String getType() {
        return this.type;
    }

    public String getPayeeVa() {
        return this.payeeVa;
    }

    public String getExpireAfter() {
        return this.expireAfter;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getNote() {
        return this.note;
    }

    public String getDate() {
        return this.date;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setPayerName(String str) {
        this.payerName = str;
    }

    public void setPayerVa(String str) {
        this.payerVa = str;
    }

    public void setNarration(String str) {
        this.narration = str;
    }

    public void setPayeeName(String str) {
        this.payeeName = str;
    }

    public void setMandateDetails(PendingCollectMandateDetails pendingCollectMandateDetails) {
        this.mandateDetails = pendingCollectMandateDetails;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setPayeeVa(String str) {
        this.payeeVa = str;
    }

    public void setExpireAfter(String str) {
        this.expireAfter = str;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setmSeqNo(String str) {
        this.mSeqNo = str;
    }

    public void setRefUrl(String str) {
        this.refUrl = str;
    }

    public void setRefCategory(String str) {
        this.refCategory = str;
    }

    public void setmUpiTranlogId(String str) {
        this.mUpiTranlogId = str;
    }

    public boolean isVerifiedMerchant() {
        return this.isVerifiedMerchant;
    }
}
