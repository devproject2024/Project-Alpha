package net.one97.paytm.recharge.creditcard.modal;

import android.text.TextUtils;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class CJRCreditCardModelV8 implements IJRDataModel {
    private String OperaterCardTypeImage;
    private String OperaterImage;
    private String OperaterName;
    private String bankName;
    private CJRBillDetails billsDetails;
    private String cardId;
    private String cardId2;
    private String cardNumber;
    private String cardType;
    private int cardTypeId = -1;
    private String createdAT;
    private String creditCardLength;
    private HashMap<String, Object> ctaMap;
    private String deeplinkAmount;
    private String disclaimer;
    private String displayCardNumber;
    private String displayCardNumberHint;
    private String dueDate;
    private String favOrderId;
    private int freshCardId = 2;
    private int intermediateId = 3;
    private boolean isEditable;
    private boolean isPaytmFirstCreditCard;
    private Double minDue;
    private String nameOnCard;
    private String operaterLabel;
    private CJRUtilityProductV2 product;
    private int recentCardId;
    private String rechargeAmount;
    private String rechargeDate;
    private int savedCardId = 1;
    private CJRAggsItem selectedDCVariant;
    private CJRUtilityVariantV2 selectedVariant;
    private Double totalDue;

    public final int getRecentCardId() {
        return this.recentCardId;
    }

    public final void setRecentCardId(int i2) {
        this.recentCardId = i2;
    }

    public final int getSavedCardId() {
        return this.savedCardId;
    }

    public final void setSavedCardId(int i2) {
        this.savedCardId = i2;
    }

    public final int getFreshCardId() {
        return this.freshCardId;
    }

    public final void setFreshCardId(int i2) {
        this.freshCardId = i2;
    }

    public final int getIntermediateId() {
        return this.intermediateId;
    }

    public final void setIntermediateId(int i2) {
        this.intermediateId = i2;
    }

    public final int getCardTypeId() {
        return this.cardTypeId;
    }

    public final void setCardTypeId(int i2) {
        this.cardTypeId = i2;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public final String getOperaterImage() {
        return this.OperaterImage;
    }

    public final void setOperaterImage(String str) {
        this.OperaterImage = str;
    }

    public final String getOperaterCardTypeImage() {
        return this.OperaterCardTypeImage;
    }

    public final void setOperaterCardTypeImage(String str) {
        this.OperaterCardTypeImage = str;
    }

    public final String getOperaterName() {
        return this.OperaterName;
    }

    public final void setOperaterName(String str) {
        this.OperaterName = str;
    }

    public final CJRUtilityProductV2 getProduct() {
        return this.product;
    }

    public final void setProduct(CJRUtilityProductV2 cJRUtilityProductV2) {
        this.product = cJRUtilityProductV2;
    }

    public final CJRUtilityVariantV2 getSelectedVariant() {
        return this.selectedVariant;
    }

    public final void setSelectedVariant(CJRUtilityVariantV2 cJRUtilityVariantV2) {
        this.selectedVariant = cJRUtilityVariantV2;
    }

    public final CJRAggsItem getSelectedDCVariant() {
        return this.selectedDCVariant;
    }

    public final void setSelectedDCVariant(CJRAggsItem cJRAggsItem) {
        this.selectedDCVariant = cJRAggsItem;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final void setCardId(String str) {
        this.cardId = str;
    }

    public final String getCardId2() {
        return this.cardId2;
    }

    public final void setCardId2(String str) {
        this.cardId2 = str;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final void setCardType(String str) {
        this.cardType = str;
    }

    public final String getFavOrderId() {
        return this.favOrderId;
    }

    public final void setFavOrderId(String str) {
        this.favOrderId = str;
    }

    public final String getDisplayCardNumber() {
        return this.displayCardNumber;
    }

    public final void setDisplayCardNumber(String str) {
        this.displayCardNumber = str;
    }

    public final String getRechargeAmount() {
        return this.rechargeAmount;
    }

    public final void setRechargeAmount(String str) {
        this.rechargeAmount = str;
    }

    public final String getDeeplinkAmount() {
        return this.deeplinkAmount;
    }

    public final void setDeeplinkAmount(String str) {
        this.deeplinkAmount = str;
    }

    public final String getRechargeDate() {
        return this.rechargeDate;
    }

    public final void setRechargeDate(String str) {
        this.rechargeDate = str;
    }

    public final String getCreatedAT() {
        return this.createdAT;
    }

    public final void setCreatedAT(String str) {
        this.createdAT = str;
    }

    public final boolean isEditable() {
        return this.isEditable;
    }

    public final void setEditable(boolean z) {
        this.isEditable = z;
    }

    public final String getDisclaimer() {
        return this.disclaimer;
    }

    public final void setDisclaimer(String str) {
        this.disclaimer = str;
    }

    public final String getCreditCardLength() {
        return this.creditCardLength;
    }

    public final void setCreditCardLength(String str) {
        this.creditCardLength = str;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getDisplayCardNumberHint() {
        return this.displayCardNumberHint;
    }

    public final void setDisplayCardNumberHint(String str) {
        this.displayCardNumberHint = str;
    }

    public final CJRBillDetails getBillsDetails() {
        return this.billsDetails;
    }

    public final void setBillsDetails(CJRBillDetails cJRBillDetails) {
        this.billsDetails = cJRBillDetails;
    }

    public final boolean isPaytmFirstCreditCard() {
        return this.isPaytmFirstCreditCard;
    }

    public final void setPaytmFirstCreditCard(boolean z) {
        this.isPaytmFirstCreditCard = z;
    }

    public final HashMap<String, Object> getCtaMap() {
        return this.ctaMap;
    }

    public final void setCtaMap(HashMap<String, Object> hashMap) {
        this.ctaMap = hashMap;
    }

    public final Double getTotalDue() {
        return this.totalDue;
    }

    public final void setTotalDue(Double d2) {
        this.totalDue = d2;
    }

    public final Double getMinDue() {
        return this.minDue;
    }

    public final void setMinDue(Double d2) {
        this.minDue = d2;
    }

    public final String getDueDate() {
        return this.dueDate;
    }

    public final void setDueDate(String str) {
        this.dueDate = str;
    }

    public final String getNameOnCard() {
        return this.nameOnCard;
    }

    public final void setNameOnCard(String str) {
        this.nameOnCard = str;
    }

    public final String getOperaterLabel() {
        return this.operaterLabel;
    }

    public final void setOperaterLabel(String str) {
        this.operaterLabel = str;
    }

    public final String getCTAMessage() {
        HashMap<String, Object> hashMap = this.ctaMap;
        if (hashMap == null || !hashMap.containsKey("message")) {
            return null;
        }
        return String.valueOf(hashMap.get("message"));
    }

    public final String getCTAMessageColor() {
        HashMap<String, Object> hashMap = this.ctaMap;
        if (hashMap == null || !hashMap.containsKey("message_color")) {
            return null;
        }
        return String.valueOf(hashMap.get("message_color"));
    }

    public final String getCTACollapseText() {
        HashMap<String, Object> hashMap = this.ctaMap;
        if (hashMap == null || !hashMap.containsKey("collapse_text") || TextUtils.isEmpty(String.valueOf(hashMap.get("collapse_text")))) {
            return null;
        }
        return String.valueOf(hashMap.get("collapse_text"));
    }

    public final String getCTAButtonText() {
        HashMap<String, Object> hashMap = this.ctaMap;
        if (hashMap == null || !hashMap.containsKey("button_text") || TextUtils.isEmpty(String.valueOf(hashMap.get("button_text")))) {
            return null;
        }
        return String.valueOf(hashMap.get("button_text"));
    }

    public final String getFirstSixDigits() {
        String str;
        String str2 = this.cardNumber;
        if (str2 != null) {
            str = p.a(str2, " ", "", false);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str == null) {
                k.a();
            }
            if (str.length() > 6) {
                String substring = str.substring(0, 6);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }

    public final String getFirstFourDigits() {
        String str;
        String str2 = this.cardNumber;
        if (str2 != null) {
            str = p.a(str2, " ", "", false);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str == null) {
                k.a();
            }
            if (str.length() > 3) {
                String substring = str.substring(0, 4);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }

    public final String getLastFourDigits() {
        String str;
        String str2 = this.cardNumber;
        if (str2 != null) {
            str = p.a(str2, " ", "", false);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str == null) {
                k.a();
            }
            if (str.length() > 6) {
                String substring = str.substring(str.length() - 4, str.length());
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }
}
