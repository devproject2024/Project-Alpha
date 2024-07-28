package net.one97.paytm.common.entity.p2p;

public interface WalletPaymentCallbackListener {
    void handleAddMoneyUIChanges();

    void onAddMoneyCancelled();

    void onAddMoneyFailure(String str, String str2);

    void onAddMoneyStart();

    void onAddMoneySuccess();

    void onBeneficiaryAdditionFailure();

    void onBeneficiaryAdditionSuccess();

    void onNetworkTimeOutForWalletLimitsAPI();

    void onPaymentFailure();

    void onPaymentSuccess();

    void onWalletNotAvailableUseOtherPaymodes(String str);
}
