package net.one97.paytm.games.model.pfg;

public final class UserBalance extends ResponseResult<String> {
    private String balance = "0";
    private String cash = "0.00";
    private String voucher = "0";

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        this.balance = str;
    }

    public final String getVoucher() {
        return this.voucher;
    }

    public final void setVoucher(String str) {
        this.voucher = str;
    }

    public final String getCash() {
        return this.cash;
    }

    public final void setCash(String str) {
        this.cash = str;
    }
}
