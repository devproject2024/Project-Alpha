package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusMyTripList implements IJRDataModel {
    @b(a = "bus_type")
    private String busType;
    @b(a = "destination")
    private String dest;
    @b(a = "doj")
    private String doj;
    @b(a = "operator_name")
    private String operatorName;
    @b(a = "order_id")
    private String orderId;
    @b(a = "source")
    private String source;
    @b(a = "status")
    private String status;

    public String getDoj() {
        return this.doj;
    }

    public void setDoj(String str) {
        this.doj = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getDest() {
        return this.dest;
    }

    public void setDest(String str) {
        this.dest = str;
    }

    public String getOperatorName() {
        return this.operatorName;
    }

    public void setOperatorName(String str) {
        this.operatorName = str;
    }

    public String getBusType() {
        return this.busType;
    }

    public void setBusType(String str) {
        this.busType = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
