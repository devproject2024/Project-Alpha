package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class FlightOrderRefundSummaryInLineMessage implements IJRDataModel {
    private String img_url;
    private String message;
    private String msg_id;

    public String getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(String str) {
        this.msg_id = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public void setImg_url(String str) {
        this.img_url = str;
    }
}
