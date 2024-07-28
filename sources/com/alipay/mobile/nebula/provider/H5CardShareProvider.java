package com.alipay.mobile.nebula.provider;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.CardShareInfo;
import com.alipay.mobile.h5container.api.H5Page;

public interface H5CardShareProvider {

    public interface CardShareCallBack {
        void hideLoading();

        void onCardResult(CardShareInfo cardShareInfo);

        void onNoneCardResult();

        void showLoading();
    }

    void release();

    void requestShareInfo(String str, CardShareCallBack cardShareCallBack, H5Page h5Page, e eVar);

    void syncAutoJsContent(String str, e eVar);
}
