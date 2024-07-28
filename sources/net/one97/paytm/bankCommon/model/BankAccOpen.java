package net.one97.paytm.bankCommon.model;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class BankAccOpen extends IJRPaytmDataModel implements IJRDataModel {
    private String ackNumber;
    private String errorMessage;
    private String message;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getAckNumber() {
        return this.ackNumber;
    }

    public String getMessage() {
        return this.message;
    }
}
