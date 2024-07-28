package net.one97.paytm.bankCommon.g;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public final class g {

    public interface a {
        void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);
    }

    public interface b<T> {
        void onResponse(T t);
    }
}
