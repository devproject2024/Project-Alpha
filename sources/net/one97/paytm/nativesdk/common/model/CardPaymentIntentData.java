package net.one97.paytm.nativesdk.common.model;

public class CardPaymentIntentData implements BaseDataModel {
    private String bin6;
    private String bin8;
    private String cardHash;

    public String getCardHash() {
        return this.cardHash;
    }

    public void setCardHash(String str) {
        this.cardHash = str;
    }

    public String getBin6() {
        return this.bin6;
    }

    public void setBin6(String str) {
        this.bin6 = str;
    }

    public String getBin8() {
        return this.bin8;
    }

    public void setBin8(String str) {
        this.bin8 = str;
    }
}
