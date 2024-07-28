package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRAutomaticSubscriptionCheckModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "status")
    private Integer status;

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
