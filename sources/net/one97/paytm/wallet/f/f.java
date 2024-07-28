package net.one97.paytm.wallet.f;

public interface f {
    void onAddMoneyInvalidAmountEntered(String str);

    void onAddMoneyRequestComplete();

    void onAddMoneyRequestStart();

    void onAddMoneyVerifyResponse(String str);
}
