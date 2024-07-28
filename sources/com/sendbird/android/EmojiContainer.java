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
import java.util.List;

public class EmojiContainer {
    private final List<EmojiCategory> emojiCategories = new ArrayList();
    private final String emojiHash;

    EmojiContainer(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.emojiHash = asJsonObject.has(StringSet.emoji_hash) ? asJsonObject.get(StringSet.emoji_hash).getAsString() : "";
        if (asJsonObject.has(StringSet.emoji_categories)) {
            JsonArray asJsonArray = asJsonObject.getAsJsonArray(StringSet.emoji_categories);
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                if (asJsonArray.get(i2) != null) {
                    this.emojiCategories.add(new EmojiCategory(asJsonArray.get(i2).getAsJsonObject()));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.emoji_hash, this.emojiHash);
        synchronized (this.emojiCategories) {
            if (this.emojiCategories.size() > 0) {
                JsonArray jsonArray = new JsonArray();
                for (EmojiCategory next : this.emojiCategories) {
                    if (next != null) {
                        jsonArray.add(next.toJson());
                    }
                }
                jsonObject.add(StringSet.emoji_categories, jsonArray);
            }
        }
        return jsonObject;
    }

    public static EmojiContainer buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            return new EmojiContainer(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)));
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

    public String getEmojiHash() {
        return this.emojiHash;
    }

    public List<EmojiCategory> getEmojiCategories() {
        return Collections.unmodifiableList(this.emojiCategories);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return getEmojiHash().equals(((EmojiContainer) obj).getEmojiHash());
    }

    public int hashCode() {
        return p.a(getEmojiHash());
    }

    public String toString() {
        return "EmojiContainer{emojiHash='" + this.emojiHash + '\'' + ", emojiCategories=" + this.emojiCategories + '}';
    }
}
