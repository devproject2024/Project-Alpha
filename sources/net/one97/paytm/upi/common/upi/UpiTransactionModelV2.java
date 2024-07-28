package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiTransactionModelV2 implements UpiBaseDataModel {
    @c(a = "businessType")
    private String businessType;
    @c(a = "detailNarration")
    private String detailNarration;
    @c(a = "importantNote")
    private String importantNote;
    @c(a = "logoUrl")
    private String logoUrl;
    @c(a = "amount")
    private String mAmount;
    @c(a = "bankCustCare")
    private String mBankCustCare;
    @c(a = "cartUrl")
    private String mCartUrl;
    @c(a = "category")
    private String mCategory;
    @c(a = "date")
    private String mDate;
    @c(a = "errCode")
    private String mErrCode;
    @c(a = "errMessage")
    private String mErrMessage;
    @c(a = "initiationType")
    private String mInitiationType;
    @c(a = "merchantId")
    private String mMerchantId;
    @c(a = "narration")
    private String mNarration;
    @c(a = "narrationDirection")
    private String mNarrationDirection;
    @c(a = "note")
    private String mNote;
    @c(a = "orderId")
    private String mOrderId;
    @c(a = "orgTxnId")
    private String mOrgTxnId;
    @c(a = "payee")
    private UpiTransactionBankDetailsV2 mPayee;
    @c(a = "payer")
    private UpiTransactionBankDetailsV2 mPayer;
    @c(a = "refCategory")
    private String mRefCategory;
    @c(a = "refUrl")
    private String mRefUrl;
    @c(a = "rrn")
    private String mRrn;
    @c(a = "status")
    private String mStatus;
    @c(a = "txnId")
    private String mTxnId;
    @c(a = "txnType")
    private String mTxnType;
    @c(a = "updateDate")
    private String mUpdateDate;
    @c(a = "mandateDetails")
    private MandateDetails mandateDetails;
    @c(a = "merchantOrderId")
    private String merchantOrderId;
    @c(a = "onUsMerchant")
    private boolean onUsMerchant;
    @c(a = "themeId")
    private String themeId;
    @c(a = "timeline")
    private ArrayList<PassbookTimeline> timeline;

    public UpiTransactionModelV2() {
    }

    public UpiTransactionModelV2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiTransactionBankDetailsV2 upiTransactionBankDetailsV2, UpiTransactionBankDetailsV2 upiTransactionBankDetailsV22, String str9, String str10, String str11, String str12, MandateDetails mandateDetails2) {
        this.mTxnId = str;
        this.mStatus = str2;
        this.mAmount = str3;
        this.mDate = str4;
        this.mNote = str5;
        this.mTxnType = str6;
        this.mInitiationType = str7;
        this.mRrn = str8;
        this.mPayer = upiTransactionBankDetailsV2;
        this.mNarration = str9;
        this.logoUrl = str10;
        this.mCategory = str11;
        this.businessType = str12;
        this.mandateDetails = mandateDetails2;
        this.mPayee = upiTransactionBankDetailsV22;
    }

    public String getTxnId() {
        return this.mTxnId;
    }

    public void setTxnId(String str) {
        this.mTxnId = str;
    }

    public String getOrgTxnId() {
        return this.mOrgTxnId;
    }

    public void setOrgTxnId(String str) {
        this.mOrgTxnId = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getAmount() {
        return this.mAmount;
    }

    public void setAmount(String str) {
        this.mAmount = str;
    }

    public String getDate() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(Long.parseLong(this.mDate));
        return new SimpleDateFormat("dd MMM yyyy, hh:mm a").format(instance.getTime());
    }

    public String getOriginalDate() {
        return this.mDate;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public String getUpdateDate() {
        return this.mUpdateDate;
    }

    public void setUpdateDate(String str) {
        this.mUpdateDate = str;
    }

    public String getNote() {
        return this.mNote;
    }

    public void setNote(String str) {
        this.mNote = str;
    }

    public String getTxnType() {
        return this.mTxnType;
    }

    public void setTxnType(String str) {
        this.mTxnType = str;
    }

    public String getInitiationType() {
        return this.mInitiationType;
    }

    public void setInitiationType(String str) {
        this.mInitiationType = str;
    }

    public String getRrn() {
        return this.mRrn;
    }

    public void setRrn(String str) {
        this.mRrn = str;
    }

    public String getErrCode() {
        return this.mErrCode;
    }

    public void setErrCode(String str) {
        this.mErrCode = str;
    }

    public String getErrMessage() {
        return this.mErrMessage;
    }

    public void setErrMessage(String str) {
        this.mErrMessage = str;
    }

    public UpiTransactionBankDetailsV2 getPayer() {
        return this.mPayer;
    }

    public void setPayer(UpiTransactionBankDetailsV2 upiTransactionBankDetailsV2) {
        this.mPayer = upiTransactionBankDetailsV2;
    }

    public UpiTransactionBankDetailsV2 getPayee() {
        return this.mPayee;
    }

    public void setPayee(UpiTransactionBankDetailsV2 upiTransactionBankDetailsV2) {
        this.mPayee = upiTransactionBankDetailsV2;
    }

    public String getNarration() {
        return this.mNarration;
    }

    public void setNarration(String str) {
        this.mNarration = str;
    }

    public String getNarrationDirection() {
        return this.mNarrationDirection;
    }

    public void setNarrationDirection(String str) {
        this.mNarrationDirection = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getMerchantId() {
        return this.mMerchantId;
    }

    public void setMerchantId(String str) {
        this.mMerchantId = str;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public void setOrderId(String str) {
        this.mOrderId = str;
    }

    public String getCartUrl() {
        return this.mCartUrl;
    }

    public void setCartUrl(String str) {
        this.mCartUrl = str;
    }

    public String getBankCustCare() {
        return this.mBankCustCare;
    }

    public void setBankCustCare(String str) {
        this.mBankCustCare = str;
    }

    public String getmRefCategory() {
        return this.mRefCategory;
    }

    public String getmRefUrl() {
        return this.mRefUrl;
    }

    public String getDetailNarration() {
        return this.detailNarration;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public String getImportantNote() {
        return this.importantNote;
    }

    public ArrayList<PassbookTimeline> getTimeline() {
        return this.timeline;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(String str) {
        this.businessType = str;
    }

    public MandateDetails getMandateDetails() {
        return this.mandateDetails;
    }

    public void setMandateDetails(MandateDetails mandateDetails2) {
        this.mandateDetails = mandateDetails2;
    }

    public String getThemeId() {
        return this.themeId;
    }

    public void setThemeId(String str) {
        this.themeId = str;
    }

    public boolean isOnUsMerchant() {
        return this.onUsMerchant;
    }

    public void setOnUsMerchant(boolean z) {
        this.onUsMerchant = z;
    }

    public String getMerchantOrderId() {
        return this.merchantOrderId;
    }

    public void setMerchantOrderId(String str) {
        this.merchantOrderId = str;
    }
}
