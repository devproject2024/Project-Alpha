package net.one97.paytm.common.entity;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCashbackEligibiltyCheckDataModel extends IJRPaytmDataModel {
    String code;
    boolean eligible;
    String message;
    String status;

    public boolean isEligible() {
        return this.eligible;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
