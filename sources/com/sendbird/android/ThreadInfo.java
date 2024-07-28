package com.sendbird.android;

import android.util.Base64;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ThreadInfo {
    private long lastRepliedAt;
    private final List<User> mostRepliedUsers;
    private int replyCount;
    private long updatedAt;

    protected ThreadInfo() {
        this.mostRepliedUsers = new ArrayList();
        this.lastRepliedAt = 0;
        this.updatedAt = 0;
        this.replyCount = 0;
    }

    protected ThreadInfo(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        ArrayList arrayList = new ArrayList();
        JsonArray asJsonArray = asJsonObject.has(StringSet.most_replies) ? asJsonObject.get(StringSet.most_replies).getAsJsonArray() : null;
        if (asJsonArray != null) {
            Iterator<JsonElement> it2 = asJsonArray.iterator();
            while (it2.hasNext()) {
                arrayList.add(new User(it2.next()));
            }
        }
        this.mostRepliedUsers = arrayList;
        long j = 0;
        this.lastRepliedAt = asJsonObject.has(StringSet.last_replied_at) ? asJsonObject.get(StringSet.last_replied_at).getAsLong() : 0;
        this.updatedAt = asJsonObject.has(StringSet.updated_at) ? asJsonObject.get(StringSet.updated_at).getAsLong() : j;
        this.replyCount = asJsonObject.has(StringSet.reply_count) ? asJsonObject.get(StringSet.reply_count).getAsInt() : 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized JsonElement toJson() {
        JsonObject jsonObject;
        jsonObject = new JsonObject();
        if (this.mostRepliedUsers != null && !this.mostRepliedUsers.isEmpty()) {
            JsonArray jsonArray = new JsonArray();
            for (User next : this.mostRepliedUsers) {
                if (next != null) {
                    jsonArray.add(next.toJson());
                }
            }
            jsonObject.add(StringSet.most_replies, jsonArray);
        }
        jsonObject.addProperty(StringSet.last_replied_at, (Number) Long.valueOf(this.lastRepliedAt));
        jsonObject.addProperty(StringSet.updated_at, (Number) Long.valueOf(this.updatedAt));
        jsonObject.addProperty(StringSet.reply_count, (Number) Integer.valueOf(this.replyCount));
        return jsonObject;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean merge(ThreadInfo threadInfo) {
        if (threadInfo.getUpdatedAt() < this.updatedAt) {
            return false;
        }
        this.mostRepliedUsers.clear();
        this.mostRepliedUsers.addAll(threadInfo.getMostRepliedUsers());
        this.lastRepliedAt = threadInfo.getLastRepliedAt();
        this.replyCount = threadInfo.getReplyCount();
        this.updatedAt = threadInfo.getUpdatedAt();
        return true;
    }

    public static ThreadInfo buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            return new ThreadInfo(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)).getAsJsonObject());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public byte[] serialize() {
        JsonObject asJsonObject = toJson().getAsJsonObject();
        asJsonObject.addProperty("version", SendBird.getSDKVersion());
        try {
            byte[] encode = Base64.encode(asJsonObject.toString().getBytes(AppConstants.UTF_8), 0);
            for (int i2 = 0; i2 < encode.length; i2++) {
                encode[i2] = (byte) (encode[i2] ^ (i2 & 255));
            }
            return encode;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<User> getMostRepliedUsers() {
        return Collections.unmodifiableList(this.mostRepliedUsers);
    }

    public long getLastRepliedAt() {
        return this.lastRepliedAt;
    }

    public int getReplyCount() {
        return this.replyCount;
    }

    /* access modifiers changed from: package-private */
    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            ThreadInfo threadInfo = (ThreadInfo) obj;
            if (this.lastRepliedAt == threadInfo.lastRepliedAt && this.replyCount == threadInfo.replyCount && this.mostRepliedUsers.equals(threadInfo.mostRepliedUsers)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return p.a(this.mostRepliedUsers, Long.valueOf(this.lastRepliedAt), Integer.valueOf(this.replyCount));
    }

    public String toString() {
        return "ThreadInfo{mostRepliedUsers=" + this.mostRepliedUsers + ", lastRepliedAt=" + this.lastRepliedAt + ", replyCount=" + this.replyCount + ", updatedAt=" + this.updatedAt + '}';
    }
}
