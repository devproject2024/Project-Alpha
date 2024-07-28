package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CJRBeneficiaryResponse extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "beneficiaryList")
    private ArrayList<CJRBeneficiary> mBeneficiaryList;

    public String getName() {
        return null;
    }

    public ArrayList<CJRBeneficiary> getBeneficiaryList() {
        return this.mBeneficiaryList;
    }
}
