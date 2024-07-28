package com.business.merchant_payments.model.businesswallet;

import com.business.merchant_payments.model.BaseModel;

public class ResultInfo extends BaseModel {
    public static final long serialVersionUID = -615561941386393965L;
    public String resultCode;
    public String resultCodeId;
    public String resultMsg;
    public String resultStatus;

    public String getResultStatus() {
        return this.resultStatus;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultCodeId() {
        return this.resultCodeId;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }
}
