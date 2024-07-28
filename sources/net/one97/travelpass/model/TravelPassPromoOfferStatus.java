package net.one97.travelpass.model;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class TravelPassPromoOfferStatus extends IJRPaytmDataModel implements IJRDataModel {
    private String result;

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
