package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROtherBankAccounts implements IJRDataModel {
    @b(a = "accountDetail")
    private CJROtherBankAccountDetails accountDetail;
    @b(a = "creationTime")
    private String creationTime;
    @b(a = "limits")
    private ArrayList<CJRBeneficiaryLimits> limits;
    @b(a = "uuid")
    private String uuid;

    public ArrayList<CJRBeneficiaryLimits> getLimits() {
        return this.limits;
    }

    public CJROtherBankAccountDetails getAccountDetail() {
        return this.accountDetail;
    }

    public void setAccountDetail(CJROtherBankAccountDetails cJROtherBankAccountDetails) {
        this.accountDetail = cJROtherBankAccountDetails;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(String str) {
        this.creationTime = str;
    }
}
