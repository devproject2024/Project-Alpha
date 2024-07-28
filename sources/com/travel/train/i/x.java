package com.travel.train.i;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public interface x {

    public interface a {
        void a(String str);

        void a(String str, String str2, String str3, String str4);
    }

    public interface b extends com.travel.train.a<a> {
        void a();

        void a(int i2, NetworkCustomError networkCustomError);

        void a(IJRPaytmDataModel iJRPaytmDataModel);

        void a(String str);

        void showNetworkDialog(com.paytm.network.a aVar, String str, String str2);
    }
}
