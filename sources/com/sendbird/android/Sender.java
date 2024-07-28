package com.sendbird.android;

import android.util.Base64;
import com.sendbird.android.Member;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;

public class Sender extends User {
    private boolean mIsBlockedByMe;
    private Member.Role role = Member.Role.NONE;

    protected Sender(JsonElement jsonElement) {
        super(jsonElement);
        if (!jsonElement.isJsonNull()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            this.mIsBlockedByMe = asJsonObject.has("is_blocked_by_me") && asJsonObject.get("is_blocked_by_me").getAsBoolean();
            if (asJsonObject.has(StringSet.role)) {
                this.role = Member.Role.fromValue(asJsonObject.get(StringSet.role).getAsString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject asJsonObject = super.toJson().getAsJsonObject();
        asJsonObject.addProperty("is_blocked_by_me", Boolean.valueOf(this.mIsBlockedByMe));
        asJsonObject.addProperty(StringSet.role, this.role.getValue());
        return asJsonObject;
    }

    static Sender toSender(User user, Member.Role role2) {
        if (user == null) {
            return null;
        }
        JsonElement json = user.toJson();
        if (role2 != null && (json instanceof JsonObject)) {
            ((JsonObject) json).addProperty(StringSet.role, role2.getValue());
        }
        return new Sender(json);
    }

    public boolean isBlockedByMe() {
        return this.mIsBlockedByMe;
    }

    public Member.Role getRole() {
        return this.role;
    }

    public String toString() {
        return super.toString() + "\nSender{mIsBlockedByMe=" + this.mIsBlockedByMe + "role=" + this.role + '}';
    }

    public static Sender buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            return new Sender(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)));
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
}
