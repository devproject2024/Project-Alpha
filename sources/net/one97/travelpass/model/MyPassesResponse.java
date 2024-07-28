package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class MyPassesResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private MyPasses body;
    @b(a = "code")
    private int code;
    @b(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }

    public MyPasses getBody() {
        return this.body;
    }
}
