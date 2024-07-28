package com.paytm.network;

import com.paytm.network.listener.b;
import com.paytm.network.model.PaytmCommonApiSuccessModel;

public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final PaytmCommonApiSuccessModel f42972a;

    public m(PaytmCommonApiSuccessModel paytmCommonApiSuccessModel) {
        this.f42972a = paytmCommonApiSuccessModel;
    }

    public final void run() {
        b apiListener;
        PaytmCommonApiSuccessModel paytmCommonApiSuccessModel = this.f42972a;
        if (paytmCommonApiSuccessModel != null && (apiListener = paytmCommonApiSuccessModel.getApiListener()) != null) {
            apiListener.onApiSuccess(this.f42972a.getDataModel());
        }
    }
}
