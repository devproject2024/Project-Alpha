package net.one97.paytm.passbook.beans;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJREDCTransaction extends IJRDataModel {
    @c(a = "amount")
    public String amount;
    @c(a = "bankLogoUrl")
    public String bankLogoUrl;
    @c(a = "bankName")
    public String bankName;
    @c(a = "cardScheme")
    public String cardScheme;
    @c(a = "cardType")
    public String cardType;
    @c(a = "createdOn")
    public String createdOn;
    @c(a = "maskedCardNo")
    public String maskedCardNo;
    @c(a = "merchantLogoUrl")
    public String merchantLogoUrl;
    @c(a = "merchantName")
    public String merchantName;
    @c(a = "mid")
    public String mid;
    @c(a = "receiptUrl")
    public String receiptUrl;
    @c(a = "terminalAddress")
    public String terminalAddress;
    @c(a = "tid")
    public String tid;
    @c(a = "txnId")
    public String txnId;
    @c(a = "userId")
    public String userId;
}
