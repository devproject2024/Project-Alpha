package com.paytm.business.merchantprofile.inactivemerchant;

public interface InactiveMerchantListener {
    void getAccountReActivationStatus();

    String getHelpLineNumber();

    MerchantAccountState getInactivateMerchantData();

    void onContactUsClick(String str);

    void onInactiveMerchantDataChange(AccountActivationState accountActivationState, MerchantAccountActivationUIState merchantAccountActivationUIState);

    void onReactivationFailure();

    void onReactivationInProgress();

    void onReactivationSuccessful();

    void onViewPastPaymentsClick();

    void reactivateMerchantAccount();
}
