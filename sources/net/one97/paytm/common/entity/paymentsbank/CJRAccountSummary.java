package net.one97.paytm.common.entity.paymentsbank;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAccountSummary extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accountNumber")
    private String accountNumber;
    @b(a = "effectiveBalance")
    private double effectiveBalance;
    @b(a = "accounts")
    @Deprecated
    private ArrayList<AccountBalanceModel> mAccounts;
    @b(a = "message")
    private String mMessage;
    @b(a = "response_code")
    private int mResponseCode;
    @b(a = "status")
    private String mStatus;
    @b(a = "txn_id")
    private String mTxnId;
    @b(a = "slfdBalance")
    private double slfdBalance;

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
        arrayList2.add(accountBalanceModel);
        return arrayList2;
    }
}
