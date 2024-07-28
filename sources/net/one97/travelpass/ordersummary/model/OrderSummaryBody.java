package net.one97.travelpass.ordersummary.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class OrderSummaryBody extends IJRPaytmDataModel {
    @b(a = "body")
    private List<OrderSummaryBodyItem> body = null;
    @b(a = "error")
    private String error;
    @b(a = "message")
    private String message;
    @b(a = "paytmStatusCode")
    private int paytmStatusCode;
    @b(a = "Status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public List<OrderSummaryBodyItem> getBody() {
        return this.body;
    }

    public void setBody(List<OrderSummaryBodyItem> list) {
        this.body = list;
    }

    public int getPaytmStatusCode() {
        return this.paytmStatusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getError() {
        return this.error;
    }
}
