package net.one97.paytm.wallet.newdesign.nearby.datamodals;

import net.one97.paytm.common.entity.IJRDataModel;

public class LikeDislikeResponseModal implements IJRDataModel {
    public String metadata;
    public String orderId;
    public String requestGuid;
    public Response response;
    public String status;
    public String statusCode;
    public String statusMessage;

    public class Response {
        public String heading;
        public String terminalId = "";

        public Response() {
        }
    }
}
