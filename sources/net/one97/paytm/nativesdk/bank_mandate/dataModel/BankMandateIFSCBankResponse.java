package net.one97.paytm.nativesdk.bank_mandate.dataModel;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class BankMandateIFSCBankResponse implements BaseDataModel {
    @c(a = "bankBranchList")
    private ArrayList<BankMandateIFSCBranchDetails> mBankBranchList;
    @c(a = "list")
    private ArrayList<String> mList;

    public ArrayList<String> getList() {
        return this.mList;
    }

    public ArrayList<BankMandateIFSCBranchDetails> getBankBranchList() {
        return this.mBankBranchList;
    }
}
