package net.one97.paytm.wifi.models;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class WifiSampleModel extends IJRPaytmDataModel {
    public String string;

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return new WifiSampleModel();
    }
}
