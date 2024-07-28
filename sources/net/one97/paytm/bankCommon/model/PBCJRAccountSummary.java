package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBCJRAccountSummary extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accountNumber")
    private String accountNumber;
    @b(a = "effectiveBalance")
    private double effectiveBalance;
    @b(a = "accounts")
    @Deprecated
    private ArrayList<PBAccountBalanceModel> mAccounts;
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
    @b(a = "totalBalance")
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

    public void setTotalBalance(double d2) {
        this.totalBalance = d2;
    }

    @Deprecated
    public ArrayList<PBAccountBalanceModel> getAccounts() {
        ArrayList<PBAccountBalanceModel> arrayList = this.mAccounts;
        if (arrayList != null && arrayList.size() > 0) {
            return this.mAccounts;
        }
        ArrayList<PBAccountBalanceModel> arrayList2 = new ArrayList<>();
        PBAccountBalanceModel pBAccountBalanceModel = new PBAccountBalanceModel();
        pBAccountBalanceModel.setAccountNumber(this.accountNumber);
        pBAccountBalanceModel.setmEffectiveBalance(this.effectiveBalance);
        pBAccountBalanceModel.setmSlfdBalance(this.slfdBalance);
        arrayList2.add(pBAccountBalanceModel);
        return arrayList2;
    }
}
