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

public class OGMetaData {
    private final String description;
    private final OGImage ogImage;
    private final String title;
    private final String url;

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDescription() {
        return this.description;
    }

    public OGImage getOGImage() {
        return this.ogImage;
    }

    OGMetaData(JsonObject jsonObject) {
        OGImage oGImage = null;
        this.title = jsonObject.has(StringSet.og_title) ? jsonObject.get(StringSet.og_title).getAsString() : null;
        this.url = jsonObject.has(StringSet.og_url) ? jsonObject.get(StringSet.og_url).getAsString() : null;
        this.description = jsonObject.has(StringSet.og_description) ? jsonObject.get(StringSet.og_description).getAsString() : null;
        this.ogImage = jsonObject.get(StringSet.og_image) instanceof JsonObject ? new OGImage(jsonObject.get(StringSet.og_image).getAsJsonObject()) : oGImage;
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        String str = this.title;
        if (str != null) {
            jsonObject.addProperty(StringSet.og_title, str);
        }
        String str2 = this.url;
        if (str2 != null) {
            jsonObject.addProperty(StringSet.og_url, str2);
        }
        String str3 = this.description;
        if (str3 != null) {
            jsonObject.addProperty(StringSet.og_description, str3);
        }
        OGImage oGImage = this.ogImage;
        if (oGImage != null) {
            jsonObject.add(StringSet.og_image, oGImage.toJson());
        }
        return jsonObject;
    }

    public static OGMetaData buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            JsonElement parse = new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8));
            if (parse.isJsonObject()) {
                return new OGMetaData(parse.getAsJsonObject());
            }
            return null;
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
        return p.a(this.title, this.url, this.description, this.ogImage);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OGMetaData)) {
            return false;
        }
        OGMetaData oGMetaData = (OGMetaData) obj;
        if (TextUtils.equals(this.title, oGMetaData.title) && TextUtils.equals(this.url, oGMetaData.url) && TextUtils.equals(this.description, oGMetaData.description)) {
            OGImage oGImage = this.ogImage;
            OGImage oGImage2 = oGMetaData.ogImage;
            return oGImage != null ? oGImage.equals(oGImage2) : oGImage2 == null;
        }
    }

    public String toString() {
        return "OGMetaData{title='" + this.title + '\'' + ", url='" + this.url + '\'' + ", description='" + this.description + '\'' + ", ogImage=" + this.ogImage + '}';
    }
}
