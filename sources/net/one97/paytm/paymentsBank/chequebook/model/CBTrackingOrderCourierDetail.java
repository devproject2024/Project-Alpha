package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CBTrackingOrderCourierDetail extends IJRPaytmDataModel {
    @a
    @b(a = "courier_name")
    private String courier_name;
    @a
    @b(a = "shipper_id")
    private String shipper_id;
    @a
    @b(a = "tracking_number")
    private String tracking_number;

    public String getTracking_number() {
        return this.tracking_number;
    }

    public void setTracking_number(String str) {
        this.tracking_number = str;
    }

    public String getShipper_id() {
        return this.shipper_id;
    }

    public void setShipper_id(String str) {
        this.shipper_id = str;
    }

    public String getCourier_name() {
        return this.courier_name;
    }

    public void setCourier_name(String str) {
        this.courier_name = str;
    }
}
