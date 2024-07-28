package com.travel.bus.busticket.b;

import com.paytm.network.model.IJRPaytmDataModel;

public interface g {
    void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str);

    void onFileWriteComplete(String str);
}
