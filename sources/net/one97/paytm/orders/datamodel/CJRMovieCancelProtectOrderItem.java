package net.one97.paytm.orders.datamodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieCancelProtectOrderItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cancellationDone")
    private Boolean cancellationDone;
    @b(a = "message")
    private String message;

    public Boolean isCancellationDone() {
        return this.cancellationDone;
    }

    public void setCancellationDone(boolean z) {
        this.cancellationDone = Boolean.valueOf(z);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
