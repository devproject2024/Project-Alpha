package net.one97.paytm.acceptPayment.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class RequestData {
    private final Object additionParams;
    private final String screenName;
    private final String url;

    public static /* synthetic */ RequestData copy$default(RequestData requestData, String str, String str2, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = requestData.screenName;
        }
        if ((i2 & 2) != 0) {
            str2 = requestData.url;
        }
        if ((i2 & 4) != 0) {
            obj = requestData.additionParams;
        }
        return requestData.copy(str, str2, obj);
    }

    public final String component1() {
        return this.screenName;
    }

    public final String component2() {
        return this.url;
    }

    public final Object component3() {
        return this.additionParams;
    }

    public final RequestData copy(String str, String str2, Object obj) {
        k.d(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        return new RequestData(str, str2, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestData)) {
            return false;
        }
        RequestData requestData = (RequestData) obj;
        return k.a((Object) this.screenName, (Object) requestData.screenName) && k.a((Object) this.url, (Object) requestData.url) && k.a(this.additionParams, requestData.additionParams);
    }

    public final int hashCode() {
        String str = this.screenName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.additionParams;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "RequestData(screenName=" + this.screenName + ", url=" + this.url + ", additionParams=" + this.additionParams + ")";
    }

    public RequestData(String str, String str2, Object obj) {
        k.d(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.screenName = str;
        this.url = str2;
        this.additionParams = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestData(String str, String str2, Object obj, int i2, g gVar) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : obj);
    }

    public final Object getAdditionParams() {
        return this.additionParams;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final String getUrl() {
        return this.url;
    }
}
