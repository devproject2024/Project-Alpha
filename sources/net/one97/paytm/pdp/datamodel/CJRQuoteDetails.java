package net.one97.paytm.pdp.datamodel;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRQuoteDetails implements IJRDataModel {
    @b(a = "brand")
    private String mBrandName;
    @b(a = "errorCode")
    private String mErrorCode;
    @b(a = "error")
    private String mErrorMsg;
    @b(a = "exchange_amount")
    private int mExchangeAmount;
    @b(a = "expiry_date")
    private String mExpiryDate;
    @b(a = "instruction_text")
    private String mInstructionText;
    @b(a = "markup_amount")
    private int mMarkupAmount;
    @b(a = "model")
    private String mModelName;
    @b(a = "quote_id")
    private String mQuoteid;
    @b(a = "sub_title")
    private String mSubTitle;
    @b(a = "title")
    private String mTitle;
    @b(a = "total_amount")
    private int mTotalAmount;

    public String getmInstructionText() {
        return this.mInstructionText;
    }

    public String getQuoteId() {
        return this.mQuoteid;
    }

    public void setQuoteId(String str) {
        this.mQuoteid = str;
    }

    public String getExpiryDate() {
        return this.mExpiryDate;
    }

    public void setExpiryDate(String str) {
        this.mExpiryDate = str;
    }

    public int getExchangeAmount() {
        return this.mExchangeAmount;
    }

    public void setExchangeAmount(int i2) {
        this.mExchangeAmount = i2;
    }

    public String getModel() {
        return this.mModelName;
    }

    public void setmModelName(String str) {
        this.mModelName = str;
    }

    public String getBrand() {
        return this.mBrandName;
    }

    public void setBrand(String str) {
        this.mBrandName = str;
    }

    public int getTotalAmount() {
        return this.mTotalAmount;
    }

    public void setTotalAmount(int i2) {
        this.mTotalAmount = i2;
    }

    public int getMarkupAmount() {
        return this.mMarkupAmount;
    }

    public void setMarkupAmount(int i2) {
        this.mMarkupAmount = i2;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getmErrorMsg() {
        return this.mErrorMsg;
    }

    public String getmErrorCode() {
        return this.mErrorCode;
    }
}
