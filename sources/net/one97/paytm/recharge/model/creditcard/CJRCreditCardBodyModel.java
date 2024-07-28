package net.one97.paytm.recharge.model.creditcard;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.v2.CJRCardBaseModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class CJRCreditCardBodyModel extends CJRCardBaseModel {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static String DEBIT_CARD_TYPE = SDKConstants.DEBIT;
    private String amount;
    private String bank;
    private String binNumber;
    private String cardId;
    private String cardNumber;
    private String cardScheme;
    private String cardToken;
    private String cardType;
    private String creditCardId;
    private String displayName;
    private String eligRequestId;
    private String entityName;
    private String extendedInfo;
    private String fulfilmentRequestId;
    private String isIndian;
    private String issuingBank;
    @b(a = "resultInfo")
    private CJRCreditCardResultInfo mResultInfo;
    @b(a = "savedCards")
    private List<CJRCreditCardBodyModel> mSavedCardList;
    private String maskedCardNumber;
    private String message;
    private String orderId;
    private String paytmSsoToken;
    private String referenceNumber;
    private String responseCode;
    private String responseMessage;
    private String responseStatus;
    private String savedCardId;
    private String ssoToken;
    private String uniqueId;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getDEBIT_CARD_TYPE() {
            return CJRCreditCardBodyModel.DEBIT_CARD_TYPE;
        }

        public final void setDEBIT_CARD_TYPE(String str) {
            k.c(str, "<set-?>");
            CJRCreditCardBodyModel.DEBIT_CARD_TYPE = str;
        }
    }

    public final CJRCreditCardResultInfo getMResultInfo() {
        return this.mResultInfo;
    }

    public final void setMResultInfo(CJRCreditCardResultInfo cJRCreditCardResultInfo) {
        this.mResultInfo = cJRCreditCardResultInfo;
    }

    public final List<CJRCreditCardBodyModel> getMSavedCardList() {
        return this.mSavedCardList;
    }

    public final void setMSavedCardList(List<CJRCreditCardBodyModel> list) {
        this.mSavedCardList = list;
    }

    public final String getBinNumber() {
        return this.binNumber;
    }

    public final void setBinNumber(String str) {
        this.binNumber = str;
    }

    public final String getSsoToken() {
        return this.ssoToken;
    }

    public final void setSsoToken(String str) {
        this.ssoToken = str;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(String str) {
        this.responseCode = str;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getResponseStatus() {
        return this.responseStatus;
    }

    public final void setResponseStatus(String str) {
        this.responseStatus = str;
    }

    public final String getIssuingBank() {
        return this.issuingBank;
    }

    public final void setIssuingBank(String str) {
        this.issuingBank = str;
    }

    public final String getCardScheme() {
        return this.cardScheme;
    }

    public final void setCardScheme(String str) {
        this.cardScheme = str;
    }

    public final String getExtendedInfo() {
        return this.extendedInfo;
    }

    public final void setExtendedInfo(String str) {
        this.extendedInfo = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getCardToken() {
        return this.cardToken;
    }

    public final void setCardToken(String str) {
        this.cardToken = str;
    }

    public final String getMaskedCardNumber() {
        return this.maskedCardNumber;
    }

    public final void setMaskedCardNumber(String str) {
        this.maskedCardNumber = str;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public final String getEligRequestId() {
        return this.eligRequestId;
    }

    public final void setEligRequestId(String str) {
        this.eligRequestId = str;
    }

    public final String getFulfilmentRequestId() {
        return this.fulfilmentRequestId;
    }

    public final void setFulfilmentRequestId(String str) {
        this.fulfilmentRequestId = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getEntityName() {
        return this.entityName;
    }

    public final void setEntityName(String str) {
        this.entityName = str;
    }

    public final String getReferenceNumber() {
        return this.referenceNumber;
    }

    public final void setReferenceNumber(String str) {
        this.referenceNumber = str;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final void setCardId(String str) {
        this.cardId = str;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final void setCardType(String str) {
        this.cardType = str;
    }

    public final String getBank() {
        return this.bank;
    }

    public final void setBank(String str) {
        this.bank = str;
    }

    public final String getPaytmSsoToken() {
        return this.paytmSsoToken;
    }

    public final void setPaytmSsoToken(String str) {
        this.paytmSsoToken = str;
    }

    public final String getCreditCardId() {
        return this.creditCardId;
    }

    public final void setCreditCardId(String str) {
        this.creditCardId = str;
    }

    public final String getSavedCardId() {
        return this.savedCardId;
    }

    public final void setSavedCardId(String str) {
        this.savedCardId = str;
    }

    public final String isIndian() {
        return this.isIndian;
    }

    public final void setIndian(String str) {
        this.isIndian = str;
    }

    public final boolean isPaytmFirstCard() {
        return p.a("Paytm First", this.displayName, true);
    }
}
