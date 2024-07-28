package com.sendbird.android;

import android.util.Base64;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;

public class Emoji {
    private final String key;
    private final String url;

    Emoji(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String str = "";
        this.key = asJsonObject.has("key") ? asJsonObject.get("key").getAsString() : str;
        this.url = asJsonObject.has("url") ? asJsonObject.get("url").getAsString() : str;
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("key", this.key);
        jsonObject.addProperty("url", this.url);
        return jsonObject;
    }

    public static Emoji buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            return new Emoji(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)));
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

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return getKey().equals(((Emoji) obj).getKey());
    }

    public int hashCode() {
        return p.a(getKey());
    }

    public String toString() {
        return "Emoji{, key='" + this.key + '\'' + ", url='" + this.url + '\'' + '}';
    }
}
