package net.one97.paytm.smssdk.model;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class SmsDataUploadResponse extends IJRPaytmDataModel {
    private final String appId;

    public static /* synthetic */ SmsDataUploadResponse copy$default(SmsDataUploadResponse smsDataUploadResponse, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smsDataUploadResponse.appId;
        }
        return smsDataUploadResponse.copy(str);
    }

    public final String component1() {
        return this.appId;
    }

    public final SmsDataUploadResponse copy(String str) {
        k.c(str, "appId");
        return new SmsDataUploadResponse(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SmsDataUploadResponse) && k.a((Object) this.appId, (Object) ((SmsDataUploadResponse) obj).appId);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.appId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "SmsDataUploadResponse(appId=" + this.appId + ")";
    }

    public SmsDataUploadResponse(String str) {
        k.c(str, "appId");
        this.appId = str;
    }

    public final String getAppId() {
        return this.appId;
    }
}
