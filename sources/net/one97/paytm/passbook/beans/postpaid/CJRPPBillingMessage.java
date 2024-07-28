package net.one97.paytm.passbook.beans.postpaid;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class CJRPPBillingMessage extends IJRDataModel {
    @c(a = "message")
    private String message;
    @c(a = "title")
    private String title;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
