package com.sendbird.android;

import android.text.TextUtils;
import android.util.Base64;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;

public class OGImage {
    private final String alt;
    private final int height;
    private final String secureUrl;
    private final String type;
    private final String url;
    private final int width;

    public String getUrl() {
        return this.url;
    }

    public String getSecureUrl() {
        return this.secureUrl;
    }

    public String getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getAlt() {
        return this.alt;
    }

    OGImage(JsonObject jsonObject) {
        String str = null;
        this.url = jsonObject.has("url") ? jsonObject.get("url").getAsString() : null;
        this.secureUrl = jsonObject.has(StringSet.secure_url) ? jsonObject.get(StringSet.secure_url).getAsString() : null;
        this.type = jsonObject.has("type") ? jsonObject.get("type").getAsString() : null;
        int i2 = 0;
        this.width = jsonObject.has(StringSet.width) ? jsonObject.get(StringSet.width).getAsInt() : 0;
        this.height = jsonObject.has(StringSet.height) ? jsonObject.get(StringSet.height).getAsInt() : i2;
        this.alt = jsonObject.has(StringSet.alt) ? jsonObject.get(StringSet.alt).getAsString() : str;
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        String str = this.url;
        if (str != null) {
            jsonObject.addProperty("url", str);
        }
        String str2 = this.secureUrl;
        if (str2 != null) {
            jsonObject.addProperty(StringSet.secure_url, str2);
        }
        String str3 = this.type;
        if (str3 != null) {
            jsonObject.addProperty("type", str3);
        }
        int i2 = this.width;
        if (i2 != 0) {
            jsonObject.addProperty(StringSet.width, (Number) Integer.valueOf(i2));
        }
        int i3 = this.height;
        if (i3 != 0) {
            jsonObject.addProperty(StringSet.height, (Number) Integer.valueOf(i3));
        }
        String str4 = this.alt;
        if (str4 != null) {
            jsonObject.addProperty(StringSet.alt, str4);
        }
        return jsonObject;
    }

    public static OGImage buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            return new OGImage(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)).getAsJsonObject());
        } catch (UnsupportedEncodingException e2) {
            Logger.e((Throwable) e2);
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
            Logger.e((Throwable) e2);
            return null;
        }
    }

    public int hashCode() {
        return p.a(this.url, this.secureUrl, this.type, Integer.valueOf(this.width), Integer.valueOf(this.height), this.alt);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OGImage)) {
            return false;
        }
        OGImage oGImage = (OGImage) obj;
        return TextUtils.equals(this.url, oGImage.url) && TextUtils.equals(this.secureUrl, oGImage.secureUrl) && TextUtils.equals(this.type, oGImage.type) && this.width == oGImage.width && this.height == oGImage.height && TextUtils.equals(this.alt, oGImage.alt);
    }

    public String toString() {
        return "OGImage{url='" + this.url + '\'' + ", secureUrl='" + this.secureUrl + '\'' + ", type='" + this.type + '\'' + ", width=" + this.width + ", height=" + this.height + ", alt='" + this.alt + '\'' + '}';
    }
}
