package net.one97.paytm.bankCommon.model;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class NomineeAdd extends IJRPaytmDataModel implements IJRDataModel {
    private String errorMessage;
    private String nomineeId;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getNomineeId() {
        return this.nomineeId;
    }
}
