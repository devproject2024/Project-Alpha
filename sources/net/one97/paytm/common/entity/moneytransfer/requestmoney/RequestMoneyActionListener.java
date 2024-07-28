package net.one97.paytm.common.entity.moneytransfer.requestmoney;

import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse;

public interface RequestMoneyActionListener {
    void hideLoading();

    void onError(RequestMoneyError requestMoneyError, String str, CollectRequestType collectRequestType);

    void onSuccess(MTSDKPostPaymentResponse mTSDKPostPaymentResponse);

    void showLoading();
}
