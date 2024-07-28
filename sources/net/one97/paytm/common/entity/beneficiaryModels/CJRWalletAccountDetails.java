package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRWalletAccountDetails implements IJRDataModel {
    @b(a = "beneficiaryCustId")
    private String beneficiaryCustId;
    @b(a = "beneficiaryName")
    private String beneficiaryName;
    @b(a = "beneficiaryPhone")
    private String beneficiaryPhone;
    @b(a = "walletGuid")
    private String walletGuid;
    @b(a = "walletType")
    private String walletType;

    public String getBeneficiaryName() {
        return this.beneficiaryName;
    }

    public void setBeneficiaryName(String str) {
        this.beneficiaryName = str;
    }

    public String getBeneficiaryPhone() {
        return this.beneficiaryPhone;
    }

    public void setBeneficiaryPhone(String str) {
        this.beneficiaryPhone = str;
    }

    public String getWalletGuid() {
        return this.walletGuid;
    }

    public void setWalletGuid(String str) {
        this.walletGuid = str;
    }

    public String getWalletType() {
        return this.walletType;
    }

    public void setWalletType(String str) {
        this.walletType = str;
    }

    public String getBeneficiaryCustId() {
        return this.beneficiaryCustId;
    }

    public void setBeneficiaryCustId(String str) {
        this.beneficiaryCustId = str;
    }
}
