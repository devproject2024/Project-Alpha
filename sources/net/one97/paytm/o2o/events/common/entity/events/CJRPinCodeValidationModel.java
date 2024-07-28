package net.one97.paytm.o2o.events.common.entity.events;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPinCodeValidationModel extends IJRPaytmDataModel implements IJRDataModel {
    private a data;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public a getData() {
        return this.data;
    }
}
