package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class BeneficiaryListV2Response extends IJRPaytmDataModel {
    @b(a = "beneficiaryResponseList")
    ArrayList<BeneficiaryDetails> beneficiaryResponseList;

    public ArrayList<BeneficiaryDetails> getBeneficiaryResponseList() {
        return this.beneficiaryResponseList;
    }

    public void setBeneficiaryResponseList(ArrayList<BeneficiaryDetails> arrayList) {
        this.beneficiaryResponseList = arrayList;
    }
}
