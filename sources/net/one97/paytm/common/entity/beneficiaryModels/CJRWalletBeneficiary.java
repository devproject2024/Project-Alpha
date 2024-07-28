package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRWalletBeneficiary implements IJRDataModel {
    @b(a = "accounts")
    private ArrayList<CJRWalletAccounts> accounts;

    public ArrayList<CJRWalletAccounts> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(ArrayList<CJRWalletAccounts> arrayList) {
        this.accounts = arrayList;
    }
}
