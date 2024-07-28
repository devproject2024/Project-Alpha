package com.paytm.android.chat.data.db.room.db_entities;

import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.UserExtendedMetaData;
import kotlin.g.b.k;

public final class UserExtendedMetaDataEntity {
    private UserExtendedMetaData cacheMetaData;
    private String metaDataString;
    private String sendbirdUserId = "NOT SET";
    private Long updatedAt;

    public final String getSendbirdUserId() {
        return this.sendbirdUserId;
    }

    public final void setSendbirdUserId(String str) {
        k.c(str, "<set-?>");
        this.sendbirdUserId = str;
    }

    public final String getMetaDataString() {
        return this.metaDataString;
    }

    public final void setMetaDataString(String str) {
        this.metaDataString = str;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(Long l) {
        this.updatedAt = l;
    }

    public final UserExtendedMetaData getCacheMetaData() {
        return this.cacheMetaData;
    }

    public final void setCacheMetaData(UserExtendedMetaData userExtendedMetaData) {
        this.cacheMetaData = userExtendedMetaData;
    }

    public final UserExtendedMetaData getMetaData() {
        UserExtendedMetaData userExtendedMetaData = this.cacheMetaData;
        if (userExtendedMetaData != null) {
            return userExtendedMetaData;
        }
        try {
            this.cacheMetaData = (UserExtendedMetaData) new f().a(this.metaDataString, UserExtendedMetaData.class);
        } catch (Exception unused) {
        }
        return this.cacheMetaData;
    }
}
