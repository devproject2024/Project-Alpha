package net.one97.paytm.common.entity.shopping;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStatus implements IJRDataModel {
    @c(a = "message")
    private Message mMessage;
    @c(a = "title")
    private String mResult;

    public String getmResult() {
        return this.mResult;
    }

    public void setmResult(String str) {
        this.mResult = str;
    }

    public Message getmMessage() {
        return this.mMessage;
    }

    public void setmMessage(Message message) {
        this.mMessage = message;
    }
}
