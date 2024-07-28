package com.sendbird.android;

import android.util.Base64;
import com.sendbird.android.ReactionEvent;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Reaction implements Comparable<Reaction> {
    private final String key;
    private final Map<String, Long> reactionUpdateMap = new ConcurrentHashMap();
    private long updatedAt;
    private final List<String> userIds = new ArrayList();

    Reaction(ReactionEvent reactionEvent) {
        this.key = reactionEvent.getKey();
        this.updatedAt = reactionEvent.getUpdatedAt();
        this.userIds.add(reactionEvent.getUserId());
        this.reactionUpdateMap.put(reactionEvent.getUserId(), Long.valueOf(reactionEvent.getUpdatedAt()));
    }

    Reaction(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.key = asJsonObject.get("key").getAsString();
        this.updatedAt = asJsonObject.has("latest_updated_at") ? asJsonObject.get("latest_updated_at").getAsLong() : 0;
        if (asJsonObject.has("user_ids")) {
            JsonArray asJsonArray = asJsonObject.getAsJsonArray("user_ids");
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                if (asJsonArray.get(i2) != null) {
                    String asString = asJsonArray.get(i2).getAsString();
                    this.userIds.add(asString);
                    this.reactionUpdateMap.put(asString, Long.valueOf(this.updatedAt));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("key", this.key);
        jsonObject.addProperty("latest_updated_at", (Number) Long.valueOf(this.updatedAt));
        synchronized (this.userIds) {
            if (this.userIds.size() > 0) {
                JsonArray jsonArray = new JsonArray();
                for (String next : this.userIds) {
                    if (next != null) {
                        jsonArray.add(next);
                    }
                }
                jsonObject.add("user_ids", jsonArray);
            }
        }
        return jsonObject;
    }

    /* access modifiers changed from: package-private */
    public boolean merge(ReactionEvent reactionEvent) {
        if (this.updatedAt < reactionEvent.getUpdatedAt()) {
            this.updatedAt = reactionEvent.getUpdatedAt();
        }
        Long l = this.reactionUpdateMap.get(reactionEvent.getUserId());
        if (l == null) {
            l = 0L;
        }
        if (l.longValue() > reactionEvent.getUpdatedAt()) {
            return false;
        }
        this.reactionUpdateMap.put(reactionEvent.getUserId(), Long.valueOf(reactionEvent.getUpdatedAt()));
        synchronized (this.userIds) {
            this.userIds.remove(reactionEvent.getUserId());
            if (reactionEvent.getOperation() == ReactionEvent.ReactionEventAction.ADD) {
                this.userIds.add(reactionEvent.getUserId());
            }
        }
        return true;
    }

    public static Reaction buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            return new Reaction(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)));
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

    public String getKey() {
        return this.key;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public List<String> getUserIds() {
        return Collections.unmodifiableList(this.userIds);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return getKey().equals(((Reaction) obj).getKey());
    }

    public int hashCode() {
        return p.a(getKey());
    }

    public String toString() {
        return "Reaction{key='" + this.key + '\'' + ", updatedAt=" + this.updatedAt + ", userIds=" + this.userIds + '}';
    }

    public int compareTo(Reaction reaction) {
        return (int) (this.updatedAt - reaction.updatedAt);
    }

    public static Reaction clone(Reaction reaction) {
        return new Reaction(reaction.toJson());
    }
}
