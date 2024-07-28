package net.one97.paytm.common.entity.upgradeKyc;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class EkycDataResponse extends IJRPaytmDataModel implements IJRDataModel {
    private String errorCode;
    private String message;
    private int statusCode;
    private String successMsg;

    public String getSuccessMsg() {
        return this.successMsg;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
