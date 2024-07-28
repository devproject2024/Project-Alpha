package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;

public class ThreadInfoUpdateEvent {
    private final BaseChannel.ChannelType channelType;
    private final String channelUrl;
    private long targetMessageId;
    private ThreadInfo threadInfo;

    ThreadInfoUpdateEvent(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.targetMessageId = asJsonObject.has(StringSet.root_message_id) ? asJsonObject.get(StringSet.root_message_id).getAsLong() : 0;
        this.channelUrl = asJsonObject.has(StringSet.channel_url) ? asJsonObject.get(StringSet.channel_url).getAsString() : "";
        this.channelType = asJsonObject.has(StringSet.channel_type) ? BaseChannel.ChannelType.fromValue(asJsonObject.get(StringSet.channel_type).getAsString()) : BaseChannel.ChannelType.GROUP;
        this.threadInfo = asJsonObject.has(StringSet.thread_info) ? new ThreadInfo(asJsonObject.get(StringSet.thread_info)) : null;
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.root_message_id, (Number) Long.valueOf(this.targetMessageId));
        jsonObject.addProperty(StringSet.channel_url, this.channelUrl);
        jsonObject.addProperty(StringSet.channel_type, this.channelType.value());
        ThreadInfo threadInfo2 = this.threadInfo;
        if (threadInfo2 != null) {
            jsonObject.add(StringSet.thread_info, threadInfo2.toJson());
        }
        return jsonObject;
    }

    public long getTargetMessageId() {
        return this.targetMessageId;
    }

    public String getChannelUrl() {
        return this.channelUrl;
    }

    public BaseChannel.ChannelType getChannelType() {
        return this.channelType;
    }

    public ThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    public String toString() {
        return "ThreadInfoUpdateEvent{targetMessageId=" + this.targetMessageId + ", channelUrl='" + this.channelUrl + '\'' + ", channelType=" + this.channelType + ", threadInfo=" + this.threadInfo + '}';
    }
}
