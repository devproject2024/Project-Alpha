package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRPhoneStatus extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "isAvailable")
    private boolean isAvailable;
    @b(a = "error")
    private String mErrorMessge;
    @b(a = "phoneNo")
    String mPhoneNo;

    public String getErrorMessge() {
        return this.mErrorMessge;
    }

    public String getPhoneNo() {
        return this.mPhoneNo;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
}
