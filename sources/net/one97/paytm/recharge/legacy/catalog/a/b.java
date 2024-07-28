package net.one97.paytm.recharge.legacy.catalog.a;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

@Deprecated
public interface b {
    void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);

    void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel);
}
