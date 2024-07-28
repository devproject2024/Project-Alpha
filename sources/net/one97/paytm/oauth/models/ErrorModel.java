package net.one97.paytm.oauth.models;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public class ErrorModel extends IJRPaytmDataModel {
    private NetworkCustomError customError;
    private IJRPaytmDataModel responseModel;
    private int status;

    public ErrorModel(int i2, IJRPaytmDataModel iJRPaytmDataModel) {
        this.status = i2;
        this.responseModel = iJRPaytmDataModel;
    }

    public ErrorModel(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.status = i2;
        this.responseModel = iJRPaytmDataModel;
        this.customError = networkCustomError;
    }

    public int getStatus() {
        return this.status;
    }

    public NetworkCustomError getCustomError() {
        return this.customError;
    }
}
