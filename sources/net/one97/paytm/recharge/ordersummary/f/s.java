package net.one97.paytm.recharge.ordersummary.f;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public interface s {

    public interface a {
        void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Integer num);

        void a(String str, NetworkCustomError networkCustomError, Integer num);
    }
}
