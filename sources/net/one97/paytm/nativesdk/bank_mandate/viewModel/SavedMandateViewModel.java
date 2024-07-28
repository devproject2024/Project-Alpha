package net.one97.paytm.nativesdk.bank_mandate.viewModel;

import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandatePTCModel;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.SavedMandateBanksItem;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo;

public class SavedMandateViewModel extends ai {
    y<BankMandatePTCModel> bankMandatePTCModel;

    public y<BankMandatePTCModel> getBankMandatePTCModel(SavedMandateBanksItem savedMandateBanksItem, String str, SubscriptionDetailsInfo subscriptionDetailsInfo, PaymentModes paymentModes) {
        this.bankMandatePTCModel = new y<>();
        loadBankMandatePTCModel(savedMandateBanksItem, str, subscriptionDetailsInfo, paymentModes);
        return this.bankMandatePTCModel;
    }

    private void loadBankMandatePTCModel(SavedMandateBanksItem savedMandateBanksItem, String str, SubscriptionDetailsInfo subscriptionDetailsInfo, PaymentModes paymentModes) {
        BankMandatePTCModel bankMandatePTCModel2 = new BankMandatePTCModel();
        bankMandatePTCModel2.setAccountHolderName(savedMandateBanksItem.getAccountHolderName());
        bankMandatePTCModel2.setUserName(savedMandateBanksItem.getAccountHolderName());
        bankMandatePTCModel2.setAccountType(!TextUtils.isEmpty(savedMandateBanksItem.getAccountType()) ? DirectPaymentBL.getInstance().getMandateAccountType(savedMandateBanksItem.getAccountType()) : "ISA");
        bankMandatePTCModel2.setBankIfsc(savedMandateBanksItem.getIfsc());
        bankMandatePTCModel2.setChannelCode(savedMandateBanksItem.getChannelCode());
        bankMandatePTCModel2.setMandateAuthMode(str);
        bankMandatePTCModel2.setPaymentMode(paymentModes.getPaymentMode());
        bankMandatePTCModel2.setSubsId(subscriptionDetailsInfo.getSubsId());
        bankMandatePTCModel2.setUpiAccRefId(savedMandateBanksItem.getAccRefId());
        this.bankMandatePTCModel.postValue(bankMandatePTCModel2);
        DirectPaymentBL.getInstance().setBankMandatePTCModel(bankMandatePTCModel2);
    }
}
