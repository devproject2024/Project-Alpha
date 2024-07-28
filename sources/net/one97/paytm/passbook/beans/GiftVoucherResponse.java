package net.one97.paytm.passbook.beans;

public class GiftVoucherResponse {
    private ClaimedPPITotalBalance claimedPPITotalBalance;
    private String txnAmount;
    private String txnId;

    public ClaimedPPITotalBalance getClaimedPPITotalBalance() {
        return this.claimedPPITotalBalance;
    }

    public void setClaimedPPITotalBalance(ClaimedPPITotalBalance claimedPPITotalBalance2) {
        this.claimedPPITotalBalance = claimedPPITotalBalance2;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(String str) {
        this.txnAmount = str;
    }

    public String toString() {
        return "ClassPojo [claimedPPITotalBalance = " + this.claimedPPITotalBalance + ", txnId = " + this.txnId + ", txnAmount = " + this.txnAmount + "]";
    }
}
