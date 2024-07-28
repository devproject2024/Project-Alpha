package com.paytm.android.chat.bean;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class ChannelMetaData {
    @b(a = "type")
    private String chatType = ChatType.P2P.toString();
    @b(a = "pay:site:1")
    private String payAllowed;
    @b(a = "request:site:1")
    private String requestAllowed;
    @b(a = "source")
    private String source;

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getPayAllowed() {
        return this.payAllowed;
    }

    public final void setPayAllowed(String str) {
        this.payAllowed = str;
    }

    public final String getRequestAllowed() {
        return this.requestAllowed;
    }

    public final void setRequestAllowed(String str) {
        this.requestAllowed = str;
    }

    public final void setType(ChatType chatType2) {
        k.c(chatType2, "newType");
        this.chatType = chatType2.toString();
    }

    public final ChatType getChatType() {
        ChatType fromString = ChatType.Companion.fromString(this.chatType);
        return fromString == null ? ChatType.P2P : fromString;
    }
}
