package net.one97.travelpass.ordersummary.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class OrderSummary extends IJRPaytmDataModel {
    @b(a = "body")
    private OrderSummaryBody body;
    @b(a = "code")
    private Integer code;
    @b(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public OrderSummaryBody getBody() {
        return this.body;
    }

    public void setBody(OrderSummaryBody orderSummaryBody) {
        this.body = orderSummaryBody;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }
}
