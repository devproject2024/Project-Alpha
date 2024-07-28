package net.one97.paytm.common.entity.wallet.edcreceipt;

import com.paytm.network.model.IJRPaytmDataModel;

public class EDCReceiptResponseModel extends IJRPaytmDataModel {
    private EDCReceiptResponseDataModel body;
    private String responseTimestamp;

    public String getResponseTimestamp() {
        return this.responseTimestamp;
    }

    public void setResponseTimestamp(String str) {
        this.responseTimestamp = str;
    }

    public EDCReceiptResponseDataModel getBody() {
        return this.body;
    }

    public void setBody(EDCReceiptResponseDataModel eDCReceiptResponseDataModel) {
        this.body = eDCReceiptResponseDataModel;
    }
}
