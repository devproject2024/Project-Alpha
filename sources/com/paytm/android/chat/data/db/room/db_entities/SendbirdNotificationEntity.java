package com.paytm.android.chat.data.db.room.db_entities;

import kotlin.g.b.k;

public final class SendbirdNotificationEntity {
    private String channelUrl;
    private String id = "NOT SET";
    private String payload;

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public final void setChannelUrl(String str) {
        this.channelUrl = str;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final void setPayload(String str) {
        this.payload = str;
    }
}
