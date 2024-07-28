package net.one97.paytm.h5.model;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class H5HTTPRequestProviderModel extends IJRPaytmDataModel {
    private String responseRaw = "";

    public H5HTTPRequestProviderModel parseResponse(String str, f fVar) throws Exception {
        try {
            H5HTTPRequestProviderModel h5HTTPRequestProviderModel = new H5HTTPRequestProviderModel();
            h5HTTPRequestProviderModel.setResponseRaw(str);
            return h5HTTPRequestProviderModel;
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
