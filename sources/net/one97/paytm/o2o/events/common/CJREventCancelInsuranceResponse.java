package net.one97.paytm.o2o.events.common;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJREventCancelInsuranceResponse extends IJRPaytmDataModel {
    @b(a = "code")
    private int code;
    @b(a = "msg")
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
