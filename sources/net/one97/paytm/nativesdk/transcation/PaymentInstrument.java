package net.one97.paytm.nativesdk.transcation;

import com.google.gson.f;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Utils.CardData;

public class PaymentInstrument implements Serializable {
    private static final long serialVersionUID = 1;
    private String bankCode;
    private CardData cardDetails;
    private String cardType;
    private String gaFlowType;
    private String gaPaymentMethod;
    private String gaPaymentMode;
    private String gaVisaPaymentMode;
    private boolean isSingleClickTransaction;
    private HashMap<String, String> mPGParams;
    private String mPGUrlToHit;
    private String mid;
    private String oneClickInfo;
    private String orderId;
    private String payType;
    private String requestBody;
    private String riskExtendInfo;
    private long transactionStartTime;

    public PaymentInstrument(String str, String str2, String str3, HashMap<String, String> hashMap) {
        this.mid = str;
        this.orderId = str2;
        this.mPGParams = hashMap;
        this.mPGUrlToHit = str3;
    }

    public CardData getCardDetails() {
        return this.cardDetails;
    }

    public void setCardDetails(CardData cardData) {
        this.cardDetails = cardData;
    }

    public String getOneClickInfo() {
        return this.oneClickInfo;
    }

    public void setOneClickInfo(String str) {
        this.oneClickInfo = str;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public void setmPGUrlToHit(String str) {
        this.mPGUrlToHit = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getMid() {
        return this.mid;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public HashMap<String, String> getmPGParams() {
        return this.mPGParams;
    }

    public String getmPGUrlToHit() {
        return this.mPGUrlToHit;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public String getPayType() {
        return this.payType;
    }

    public void setPayType(String str) {
        this.payType = str;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public String getRequestBody() {
        String str = this.requestBody;
        return str == null ? new f().b(this.mPGParams) : str;
    }

    public void setRequestBody(String str) {
        this.requestBody = str;
    }

    public String getGaPaymentMode() {
        return this.gaPaymentMode;
    }

    public void setGaPaymentMode(String str) {
        this.gaPaymentMode = str;
    }

    public String getGaFlowType() {
        return this.gaFlowType;
    }

    public void setGaFlowType(String str) {
        this.gaFlowType = str;
    }

    public String getGaPaymentMethod() {
        return this.gaPaymentMethod;
    }

    public void setGaPaymentMethod(String str) {
        this.gaPaymentMethod = str;
    }

    public String getRiskExtendInfo() {
        return this.riskExtendInfo;
    }

    public void setRiskExtendInfo(String str) {
        this.riskExtendInfo = str;
    }

    public void setGaVisaPaymentMode(String str) {
        this.gaVisaPaymentMode = str;
    }

    public String getGaVisaPaymentMode() {
        return this.gaVisaPaymentMode;
    }

    public long getTransactionStartTime() {
        return this.transactionStartTime;
    }

    public void setTransactionStartTime(long j) {
        this.transactionStartTime = j;
    }

    public boolean isSingleClickTransaction() {
        return this.isSingleClickTransaction;
    }

    public void setSingleClickTransaction(boolean z) {
        this.isSingleClickTransaction = z;
    }
}
