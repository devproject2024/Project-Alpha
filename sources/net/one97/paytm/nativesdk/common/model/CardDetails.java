package net.one97.paytm.nativesdk.common.model;

public class CardDetails implements BaseDataModel {
    private String bin;
    private String cardHash;
    private String cardId;
    private String cardType;
    private String expiryDate;
    private String firstEightDigit;
    private String firstSixDigit;
    private String lastFourDigit;
    private String status;

    public String getBin() {
        return this.bin;
    }

    public void setBin(String str) {
        this.bin = str;
    }

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public String getLastFourDigit() {
        return this.lastFourDigit;
    }

    public void setLastFourDigit(String str) {
        this.lastFourDigit = str;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public String getFirstSixDigit() {
        return this.firstSixDigit;
    }

    public void setFirstSixDigit(String str) {
        this.firstSixDigit = str;
    }

    public String getCardHash() {
        return this.cardHash;
    }

    public void setCardHash(String str) {
        this.cardHash = str;
    }

    public String getFirstEightDigit() {
        return this.firstEightDigit;
    }

    public void setFirstEightDigit(String str) {
        this.firstEightDigit = str;
    }

    public String toString() {
        return "ClassPojo [cardId = " + this.cardId + ", status = " + this.status + ", expiryDate = " + this.expiryDate + ", lastFourDigit = " + this.lastFourDigit + ", cardType = " + this.cardType + ", firstSixDigit = " + this.firstSixDigit + "]";
    }
}
