package net.one97.paytm.passbook.beans;

public class GiftVoucherDetailData {
    private SubWalletDetailsResponse subWalletDetailsResponse;

    public SubWalletDetailsResponse getSubWalletDetailsResponse() {
        return this.subWalletDetailsResponse;
    }

    public void setSubWalletDetailsResponse(SubWalletDetailsResponse subWalletDetailsResponse2) {
        this.subWalletDetailsResponse = subWalletDetailsResponse2;
    }

    public String toString() {
        return "ClassPojo [subWalletDetailsResponse = " + this.subWalletDetailsResponse + "]";
    }
}
