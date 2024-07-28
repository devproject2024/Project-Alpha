package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInstrumentPreferences implements IJRDataModel {
    @b(a = "otherBank")
    private CJROtherBankBeneficiary otherBank;
    @b(a = "wallet")
    private CJRWalletBeneficiary wallet;

    public CJROtherBankBeneficiary getOtherBank() {
        return this.otherBank;
    }

    public void setOtherBank(CJROtherBankBeneficiary cJROtherBankBeneficiary) {
        this.otherBank = cJROtherBankBeneficiary;
    }

    public CJRWalletBeneficiary getWallet() {
        return this.wallet;
    }

    public void setWallet(CJRWalletBeneficiary cJRWalletBeneficiary) {
        this.wallet = cJRWalletBeneficiary;
    }
}
