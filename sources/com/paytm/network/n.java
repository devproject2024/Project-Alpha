package com.paytm.network;

import com.paytm.network.listener.c;
import com.paytm.network.model.PaytmMultipartApiSuccessModel;

public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final PaytmMultipartApiSuccessModel f42973a;

    public n(PaytmMultipartApiSuccessModel paytmMultipartApiSuccessModel) {
        this.f42973a = paytmMultipartApiSuccessModel;
    }

    public final void run() {
        c apiListener;
        PaytmMultipartApiSuccessModel paytmMultipartApiSuccessModel = this.f42973a;
        if (paytmMultipartApiSuccessModel != null && (apiListener = paytmMultipartApiSuccessModel.getApiListener()) != null) {
            apiListener.onApiSuccess(this.f42973a.getDataModel());
        }
    }
}
