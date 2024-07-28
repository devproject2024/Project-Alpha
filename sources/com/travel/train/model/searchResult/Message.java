package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Message extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "message")
    private String messageTxt;
    @a
    @b(a = "title")
    private String title;

    public Message() {
        this((String) null, (String) null, 3, (g) null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public Message(String str, String str2) {
        this.title = str;
        this.messageTxt = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Message(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getMessageTxt() {
        return this.messageTxt;
    }

    public final void setMessageTxt(String str) {
        this.messageTxt = str;
    }
}
