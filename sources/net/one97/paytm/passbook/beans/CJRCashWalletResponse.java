package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRCashWalletResponse extends IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private double mAmount;
    @b(a = "otherSubWalletBalance")
    private double mOtherSubWalletBalance;
    @b(a = "paytmWalletBalance")
    private double mPaytmWalletBalance;
    @b(a = "subWalletDetailsList")
    private List<CJRSubWallet> mSubWalletDetailList = new ArrayList();
    @b(a = "totalBalance")
    private double mTotalBalance;
    @b(a = "walletGrade")
    private String mWalletGrade;
    @b(a = "unClaimedGVCount")
    private int unClaimedGVCount;

    public String getWalletGrade() {
        return this.mWalletGrade;
    }

    public void setWalletGrade(String str) {
        this.mWalletGrade = str;
    }

    public double getAmount() {
        return this.mAmount;
    }

    public void setAmount(double d2) {
        this.mAmount = d2;
    }

    public double getTotalBalance() {
        return this.mTotalBalance;
    }

    public void setTotalBalance(double d2) {
        this.mTotalBalance = d2;
    }

    public double getPaytmWalletBalance() {
        return this.mPaytmWalletBalance;
    }

    public void setPaytmWalletBalance(double d2) {
        this.mPaytmWalletBalance = d2;
    }

    public double getOtherSubWalletBalance() {
        return this.mOtherSubWalletBalance;
    }

    public void setOtherSubWalletBalance(double d2) {
        this.mOtherSubWalletBalance = d2;
    }

    public List<CJRSubWallet> getSubWalletDetailList() {
        return this.mSubWalletDetailList;
    }

    public void setSubWalletDetailList(List<CJRSubWallet> list) {
        this.mSubWalletDetailList = list;
    }

    public int getUnClaimedGVCount() {
        return this.unClaimedGVCount;
    }

    public void setUnClaimedGVCount(int i2) {
        this.unClaimedGVCount = i2;
    }
}
