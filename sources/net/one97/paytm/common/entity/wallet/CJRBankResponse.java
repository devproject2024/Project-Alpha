package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBankResponse implements IJRDataModel {
    @b(a = "bankBranchList")
    private ArrayList<CJRBranchDetails> mBankBranchList;
    @b(a = "list")
    private ArrayList<String> mList;

    public ArrayList<String> getList() {
        return this.mList;
    }

    public ArrayList<CJRBranchDetails> getBankBranchList() {
        return this.mBankBranchList;
    }
}
