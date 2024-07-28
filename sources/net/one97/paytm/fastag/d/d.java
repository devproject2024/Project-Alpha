package net.one97.paytm.fastag.d;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public abstract class d extends Throwable {
    public abstract void onError(Throwable th);

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        onError(networkCustomError);
    }
}
