package net.one97.paytm.hotel4.service.model.details;

import com.google.gsonhtcfix.a.a;
import com.paytm.network.model.IJRPaytmDataModel;

public final class CancellationPolicy extends IJRPaytmDataModel {
    @a
    private Integer code;
    @a
    private CancellationData data;
    @a
    private String message;
    @a
    private String requestId;

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final CancellationData getData() {
        return this.data;
    }

    public final void setData(CancellationData cancellationData) {
        this.data = cancellationData;
    }
}
