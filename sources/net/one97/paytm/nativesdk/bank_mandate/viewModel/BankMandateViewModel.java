package net.one97.paytm.nativesdk.bank_mandate.viewModel;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandatePTCModel;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo;

public class BankMandateViewModel extends ai {
    y<BankMandatePTCModel> bankMandatePTCModel;

    public y<BankMandatePTCModel> getBankMandatePTCModel(String str, String str2, String str3, String str4, String str5, SubscriptionDetailsInfo subscriptionDetailsInfo, PaymentModes paymentModes) {
        this.bankMandatePTCModel = new y<>();
        loadBankMandatePTCModel(str, str2, str3, str4, str5, subscriptionDetailsInfo, paymentModes);
        return this.bankMandatePTCModel;
    }

    private void loadBankMandatePTCModel(String str, String str2, String str3, String str4, String str5, SubscriptionDetailsInfo subscriptionDetailsInfo, PaymentModes paymentModes) {
        BankMandatePTCModel bankMandatePTCModel2 = new BankMandatePTCModel();
        bankMandatePTCModel2.setAccountNumber(str);
        bankMandatePTCModel2.setAccountHolderName(str2);
        bankMandatePTCModel2.setUserName(str2);
        bankMandatePTCModel2.setAccountType(getAccountTypeValue());
        bankMandatePTCModel2.setBankIfsc(str3);
        bankMandatePTCModel2.setChannelCode(str5);
        bankMandatePTCModel2.setMandateAuthMode(str4);
        bankMandatePTCModel2.setPaymentMode(paymentModes.getPaymentMode());
        bankMandatePTCModel2.setSubsId(subscriptionDetailsInfo.getSubsId());
        DirectPaymentBL.getInstance().setBankMandatePTCModel(bankMandatePTCModel2);
        this.bankMandatePTCModel.postValue(bankMandatePTCModel2);
        DirectPaymentBL.getInstance().setBankMandatePTCModel(bankMandatePTCModel2);
    }

    private String getAccountTypeValue() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        return (instance == null || instance.getCjPayMethodResponse() == null || instance.getCjPayMethodResponse().getBody() == null || instance.getCjPayMethodResponse().getBody().getMandateAccountDetails() == null) ? "ISA" : instance.getMandateAccountType(instance.getCjPayMethodResponse().getBody().getMandateAccountDetails().getAccountType());
    }
}
