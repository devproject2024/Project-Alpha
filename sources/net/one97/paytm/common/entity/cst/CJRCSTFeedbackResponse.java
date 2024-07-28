package net.one97.paytm.common.entity.cst;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCSTFeedbackResponse extends IJRPaytmDataModel {
    @c(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
