package com.paytm.android.chat.data.db.room.db_entities;

import kotlin.g.b.k;

public final class ChatChannelUsersJoinEntity {
    private String channelUrl = "NOT SET";
    private long entryId;
    private String uniqueId;

    public final long getEntryId() {
        return this.entryId;
    }

    public final void setEntryId(long j) {
        this.entryId = j;
    }

    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public final void setChannelUrl(String str) {
        k.c(str, "<set-?>");
        this.channelUrl = str;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setUniqueId(String str) {
        this.uniqueId = str;
    }
}
