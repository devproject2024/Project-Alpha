package net.one97.paytm.passbook.beans;

public class ClaimedPPITotalBalance {
    private String GIFT_VOUCHER;

    public String getGIFT_VOUCHER() {
        return this.GIFT_VOUCHER;
    }

    public void setGIFT_VOUCHER(String str) {
        this.GIFT_VOUCHER = str;
    }

    public String toString() {
        return "ClassPojo [GIFT_VOUCHER = " + this.GIFT_VOUCHER + "]";
    }
}
