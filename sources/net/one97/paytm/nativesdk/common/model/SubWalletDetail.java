package net.one97.paytm.nativesdk.common.model;

public class SubWalletDetail implements BaseDataModel {
    private String balance;
    private String displayName;
    private String imageUrl;

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
