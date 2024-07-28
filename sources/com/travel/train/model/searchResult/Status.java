package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Status extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "message")
    private Message message;
    @a
    @b(a = "result")
    private String result;

    public Status() {
        this((String) null, (Message) null, 3, (g) null);
    }

    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        this.result = str;
    }

    public Status(String str, Message message2) {
        this.result = str;
        this.message = message2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Status(String str, Message message2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : message2);
    }

    public final Message getMessage() {
        return this.message;
    }

    public final void setMessage(Message message2) {
        this.message = message2;
    }
}
