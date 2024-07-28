package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRP2BBeneficiaryListResponse extends IJRDataModel {
    @b(a = "beneficiaryList")
    private ArrayList<CJRP2BBeneficiaryItem> mBeneficiaryList;

    public ArrayList<CJRP2BBeneficiaryItem> getBeneficiaryList() {
        return this.mBeneficiaryList;
    }
}
