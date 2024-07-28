package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.order.entity.impsdataentity.CJRPostReturnRefundConsultView;

public class CJRCancelAPIResponse extends IJRPaytmDataModel {
    @b(a = "cancelled_at")
    private String cancelledAT;
    @b(a = "confirmation_title")
    private String confirmationTitle;
    @b(a = "description_line_1")
    private String descText1;
    @b(a = "description_line_2")
    private String descText2;
    @b(a = "estimated_refund_time")
    private String estimatedRefundTime;
    @b(a = "message")
    private String message;
    @b(a = "refundConsultInfo")
    private CJRPostReturnRefundConsultView refundConsultInfo;
    @b(a = "statusCode")
    private int statusCode;

    public String getCancelledAT() {
        return this.cancelledAT;
    }

    public String getDescText1() {
        return this.descText1;
    }

    public String getDescText2() {
        return this.descText2;
    }

    public String getEstimatedRefundTime() {
        return this.estimatedRefundTime;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getConfirmationTitle() {
        return this.confirmationTitle;
    }

    public CJRPostReturnRefundConsultView getRefundConsultInfo() {
        return this.refundConsultInfo;
    }
}
