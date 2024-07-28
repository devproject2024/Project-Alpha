package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROtherBankBeneficiary implements IJRDataModel {
    @b(a = "accounts")
    private ArrayList<CJROtherBankAccounts> accounts;

    public ArrayList<CJROtherBankAccounts> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(ArrayList<CJROtherBankAccounts> arrayList) {
        this.accounts = arrayList;
    }
}
