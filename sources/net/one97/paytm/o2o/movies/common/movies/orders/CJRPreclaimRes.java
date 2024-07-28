package net.one97.paytm.o2o.movies.common.movies.orders;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class CJRPreclaimRes extends IJRPaytmDataModel {
    @b(a = "disclaimer")
    private String disclaimer;
    @b(a = "message")
    private String message;
    @b(a = "totalRefundAmount")
    private String totalRefundAmount;

    public final String getTotalRefundAmount() {
        return this.totalRefundAmount;
    }

    public final void setTotalRefundAmount(String str) {
        this.totalRefundAmount = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getDisclaimer() {
        return this.disclaimer;
    }

    public final void setDisclaimer(String str) {
        this.disclaimer = str;
    }
}
