package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CJRAccountSummary implements UpiBaseDataModel {
    @c(a = "accountNumber")
    private String accountNumber;
    @c(a = "effectiveBalance")
    private double effectiveBalance;
    @c(a = "accounts")
    @Deprecated
    private ArrayList<AccountBalanceModel> mAccounts;
    @c(a = "message")
    private String mMessage;
    @c(a = "response_code")
    private int mResponseCode;
    @c(a = "status")
    private String mStatus;
    @c(a = "txn_id")
    private String mTxnId;
    @c(a = "slfdBalance")
    private double slfdBalance;
    @c(a = "totalBalance")
    private double totalBalance;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public double getEffectiveBalance() {
        return this.effectiveBalance;
    }

    public void setEffectiveBalance(double d2) {
        this.effectiveBalance = d2;
    }

    public double getSlfdBalance() {
        return this.slfdBalance;
    }

    public void setSlfdBalance(double d2) {
        this.slfdBalance = d2;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public String getTxnId() {
        return this.mTxnId;
    }

    public double getTotalBalance() {
        return this.totalBalance;
    }

    @Deprecated
    public ArrayList<AccountBalanceModel> getAccounts() {
        ArrayList<AccountBalanceModel> arrayList = this.mAccounts;
        if (arrayList != null && arrayList.size() > 0) {
            return this.mAccounts;
        }
        ArrayList<AccountBalanceModel> arrayList2 = new ArrayList<>();
        AccountBalanceModel accountBalanceModel = new AccountBalanceModel();
        accountBalanceModel.setAccountNumber(this.accountNumber);
        accountBalanceModel.setmEffectiveBalance(this.effectiveBalance);
        accountBalanceModel.setmSlfdBalance(this.slfdBalance);
        accountBalanceModel.setTotalBalance(this.totalBalance);
        arrayList2.add(accountBalanceModel);
        return arrayList2;
    }
}
