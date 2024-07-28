package net.one97.paytm.recharge.widgets.b;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public interface d {
    void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);

    void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel);
}
