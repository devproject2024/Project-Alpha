package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGWDataModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "gwDataId")
    private String gwDataId;
    @b(a = "message")
    private String message;
    @b(a = "status")
    private boolean status;
    @b(a = "statusCode")
    private Integer statusCode;

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public String getGwDataId() {
        return this.gwDataId;
    }

    public void setGwDataId(String str) {
        this.gwDataId = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer num) {
        this.statusCode = num;
    }
}
