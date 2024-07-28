package net.one97.paytm.common.entity.moneytransfer.requestmoney;

public interface RequestMoneyListener {
    void hideLoading();

    void onError(RequestMoneyError requestMoneyError, String str);

    void onSuccess(MTChatResponse mTChatResponse);

    void showLoading();
}
