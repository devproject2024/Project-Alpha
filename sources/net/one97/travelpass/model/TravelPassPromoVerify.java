package net.one97.travelpass.model;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class TravelPassPromoVerify extends IJRPaytmDataModel implements IJRDataModel {
    private TravelPassPromoVerifyBody body;
    private String code;
    private String error;
    private TravelPassPromoOfferStatus status;

    public TravelPassPromoVerifyBody getBody() {
        return this.body;
    }

    public void setBody(TravelPassPromoVerifyBody travelPassPromoVerifyBody) {
        this.body = travelPassPromoVerifyBody;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public TravelPassPromoOfferStatus getStatus() {
        return this.status;
    }

    public void setStatus(TravelPassPromoOfferStatus travelPassPromoOfferStatus) {
        this.status = travelPassPromoOfferStatus;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }
}
