package com.travel.train.i;

import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse;

public interface k extends aa {
    void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, a aVar);

    void a(IJRPaytmDataModel iJRPaytmDataModel);

    void a(CJRNpsTrackingResponse cJRNpsTrackingResponse);

    void c();

    void showNetworkDialog(a aVar, String str, String str2);
}
