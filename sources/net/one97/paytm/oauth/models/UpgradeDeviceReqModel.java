package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class UpgradeDeviceReqModel {
    @b(a = "deviceId")
    private final String deviceId;
    @b(a = "publicKey")
    private final String publicKey;

    public UpgradeDeviceReqModel(String str, String str2) {
        k.c(str, "publicKey");
        k.c(str2, "deviceId");
        this.publicKey = str;
        this.deviceId = str2;
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}
