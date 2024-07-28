package com.travel.bus.busticket.c;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.bus.pojo.busticket.CJRBusSearch;

public interface b {

    public interface a {
        void clearAdapter();

        void onUpdateApiError(int i2, NetworkCustomError networkCustomError, IJRPaytmDataModel iJRPaytmDataModel);

        void onUpdateApiResult(CJRBusSearch cJRBusSearch);

        void showApiResponseErrorAlert();

        void showSearchApiNoNetworkDialog();

        void showTimeOutError(boolean z);
    }
}
