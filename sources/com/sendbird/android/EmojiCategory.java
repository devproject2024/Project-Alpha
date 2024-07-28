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

public class EmojiCategory {
    private final List<Emoji> emojis = new ArrayList();
    private final long id;
    private final String name;
    private final String url;

    EmojiCategory(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.id = asJsonObject.has("id") ? asJsonObject.get("id").getAsLong() : 0;
        String str = "";
        this.name = asJsonObject.has("name") ? asJsonObject.get("name").getAsString() : str;
        this.url = asJsonObject.has("url") ? asJsonObject.get("url").getAsString() : str;
        if (asJsonObject.has(StringSet.emojis)) {
            JsonArray asJsonArray = asJsonObject.getAsJsonArray(StringSet.emojis);
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                if (asJsonArray.get(i2) != null) {
                    this.emojis.add(new Emoji(asJsonArray.get(i2).getAsJsonObject()));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", (Number) Long.valueOf(this.id));
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("url", this.url);
        synchronized (this.emojis) {
            if (this.emojis.size() > 0) {
                JsonArray jsonArray = new JsonArray();
                for (Emoji next : this.emojis) {
                    if (next != null) {
                        jsonArray.add(next.toJson());
                    }
                }
                jsonObject.add(StringSet.emojis, jsonArray);
            }
        }
        return jsonObject;
    }

    public static EmojiCategory buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            return new EmojiCategory(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)));
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

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public List<Emoji> getEmojis() {
        return Collections.unmodifiableList(this.emojis);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass() && getId() == ((EmojiCategory) obj).getId()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return p.a(Long.valueOf(getId()));
    }

    public String toString() {
        return "EmojiCategory{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + ", emojis=" + this.emojis + '}';
    }
}
