package net.one97.paytm.phoenix.model;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class PhoenixHTTPRequestProviderModel extends IJRPaytmDataModel {
    private String responseRaw = "";

    public PhoenixHTTPRequestProviderModel parseResponse(String str, f fVar) throws Exception {
        try {
            PhoenixHTTPRequestProviderModel phoenixHTTPRequestProviderModel = new PhoenixHTTPRequestProviderModel();
            phoenixHTTPRequestProviderModel.setResponseRaw(str);
            return phoenixHTTPRequestProviderModel;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getResponseRaw() {
        return this.responseRaw;
    }

    private void setResponseRaw(String str) {
        this.responseRaw = str;
    }
}
