package net.one97.paytm.common.entity.wallet;

import java.io.Serializable;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNobleInitiative implements IJRDataModel {
    public String metadata;
    public String orderId;
    public String requestGuid;
    public CJRNobleInitiativeResponse response;
    public String status;
    public String statusCode;
    public String statusMessage;
    public String type;

    public String toString() {
        return "CJRNobleInitiative{type='" + this.type + '\'' + ", requestGuid='" + this.requestGuid + '\'' + ", orderId='" + this.orderId + '\'' + ", statusMessage='" + this.statusMessage + '\'' + ", statusCode='" + this.statusCode + '\'' + ", status='" + this.status + '\'' + ", metadata='" + this.metadata + '\'' + ", response=" + this.response + '}';
    }

    public static class CJRNobleInitiativeResponse implements Serializable {
        public String description;
        public String heading;
        public String imageUrlBig;
        public String imageUrlSmall;
        public String industryType;
        public String merchantGuid;
        public String merchantName;
        public String merchantQr;
        public ArrayList<Integer> slab;
        public String subHeader;
        public String userQr;

        public String toString() {
            return "CJRNobleInitiativeResponse{merchantName='" + this.merchantName + '\'' + ", description='" + this.description + '\'' + ", subHeader='" + this.subHeader + '\'' + ", imageUrlSmall='" + this.imageUrlSmall + '\'' + ", imageUrlBig='" + this.imageUrlBig + '\'' + ", slab=" + this.slab + ", merchantQr='" + this.merchantQr + '\'' + ", userQr='" + this.userQr + '\'' + ", merchantGuid='" + this.merchantGuid + '\'' + ", industryType='" + this.industryType + '\'' + ", heading='" + this.heading + '\'' + '}';
        }
    }
}
