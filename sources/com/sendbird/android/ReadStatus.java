package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;

public final class ReadStatus {
    private String mChannelType;
    private String mChannelUrl;
    private User mReader;
    private long mTimestamp;

    ReadStatus(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.mReader = new User(asJsonObject.get(StringSet.user));
        this.mTimestamp = asJsonObject.get(StringSet.ts).getAsLong();
        this.mChannelUrl = asJsonObject.has(StringSet.channel_url) ? asJsonObject.get(StringSet.channel_url).getAsString() : "";
        this.mChannelType = asJsonObject.has(StringSet.channel_type) ? asJsonObject.get(StringSet.channel_type).getAsString() : BaseChannel.ChannelType.GROUP.value();
    }

    ReadStatus(User user, long j) {
        this.mReader = user;
        this.mTimestamp = j;
    }

    public final long getTimestamp() {
        return this.mTimestamp;
    }

    public final User getReader() {
        return this.mReader;
    }

    /* access modifiers changed from: package-private */
    public final String getChannelUrl() {
        return this.mChannelUrl;
    }

    /* access modifiers changed from: package-private */
    public final String getChannelType() {
        return this.mChannelType;
    }

    public final int hashCode() {
        return p.a(getChannelUrl(), Long.valueOf(getTimestamp()), getReader());
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            ReadStatus readStatus = (ReadStatus) obj;
            if (!getChannelUrl().equals(readStatus.getChannelUrl()) || getTimestamp() != readStatus.getTimestamp() || !getReader().equals(readStatus.getReader())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String toString() {
        return "ReadStatus{mReader=" + this.mReader + ", mTimestamp=" + this.mTimestamp + ", mChannelUrl='" + this.mChannelUrl + '\'' + ", mChannelType='" + this.mChannelType + '\'' + '}';
    }
}
