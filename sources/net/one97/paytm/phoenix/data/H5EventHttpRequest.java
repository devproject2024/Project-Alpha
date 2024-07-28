package net.one97.paytm.phoenix.data;

import kotlin.g.b.k;
import org.json.JSONObject;

public final class H5EventHttpRequest {
    private Object data;
    private JSONObject headers;
    private String method;
    private String responseCharset;
    private String responseType;
    private Integer timeout;
    private String url;

    public static /* synthetic */ H5EventHttpRequest copy$default(H5EventHttpRequest h5EventHttpRequest, String str, String str2, Object obj, Integer num, String str3, String str4, JSONObject jSONObject, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = h5EventHttpRequest.url;
        }
        if ((i2 & 2) != 0) {
            str2 = h5EventHttpRequest.method;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            obj = h5EventHttpRequest.data;
        }
        Object obj3 = obj;
        if ((i2 & 8) != 0) {
            num = h5EventHttpRequest.timeout;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            str3 = h5EventHttpRequest.responseType;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            str4 = h5EventHttpRequest.responseCharset;
        }
        String str7 = str4;
        if ((i2 & 64) != 0) {
            jSONObject = h5EventHttpRequest.headers;
        }
        return h5EventHttpRequest.copy(str, str5, obj3, num2, str6, str7, jSONObject);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.method;
    }

    public final Object component3() {
        return this.data;
    }

    public final Integer component4() {
        return this.timeout;
    }

    public final String component5() {
        return this.responseType;
    }

    public final String component6() {
        return this.responseCharset;
    }

    public final JSONObject component7() {
        return this.headers;
    }

    public final H5EventHttpRequest copy(String str, String str2, Object obj, Integer num, String str3, String str4, JSONObject jSONObject) {
        return new H5EventHttpRequest(str, str2, obj, num, str3, str4, jSONObject);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H5EventHttpRequest)) {
            return false;
        }
        H5EventHttpRequest h5EventHttpRequest = (H5EventHttpRequest) obj;
        return k.a((Object) this.url, (Object) h5EventHttpRequest.url) && k.a((Object) this.method, (Object) h5EventHttpRequest.method) && k.a(this.data, h5EventHttpRequest.data) && k.a((Object) this.timeout, (Object) h5EventHttpRequest.timeout) && k.a((Object) this.responseType, (Object) h5EventHttpRequest.responseType) && k.a((Object) this.responseCharset, (Object) h5EventHttpRequest.responseCharset) && k.a((Object) this.headers, (Object) h5EventHttpRequest.headers);
    }

    public final int hashCode() {
        String str = this.url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.method;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.data;
        int hashCode3 = (hashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
        Integer num = this.timeout;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.responseType;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.responseCharset;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.headers;
        if (jSONObject != null) {
            i2 = jSONObject.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "H5EventHttpRequest(url=" + this.url + ", method=" + this.method + ", data=" + this.data + ", timeout=" + this.timeout + ", responseType=" + this.responseType + ", responseCharset=" + this.responseCharset + ", headers=" + this.headers + ")";
    }

    public H5EventHttpRequest(String str, String str2, Object obj, Integer num, String str3, String str4, JSONObject jSONObject) {
        this.url = str;
        this.method = str2;
        this.data = obj;
        this.timeout = num;
        this.responseType = str3;
        this.responseCharset = str4;
        this.headers = jSONObject;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ H5EventHttpRequest(java.lang.String r11, java.lang.String r12, java.lang.Object r13, java.lang.Integer r14, java.lang.String r15, java.lang.String r16, org.json.JSONObject r17, int r18, kotlin.g.b.g r19) {
        /*
            r10 = this;
            r0 = r18 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r3 = r1
            goto L_0x0008
        L_0x0007:
            r3 = r11
        L_0x0008:
            r0 = r18 & 2
            if (r0 == 0) goto L_0x0014
            net.one97.paytm.phoenix.c.a.a$a r0 = net.one97.paytm.phoenix.c.a.a.f59384g
            java.lang.String r0 = net.one97.paytm.phoenix.c.a.a.f59385i
            r4 = r0
            goto L_0x0015
        L_0x0014:
            r4 = r12
        L_0x0015:
            r0 = r18 & 8
            if (r0 == 0) goto L_0x0021
            r0 = 60
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6 = r0
            goto L_0x0022
        L_0x0021:
            r6 = r14
        L_0x0022:
            r0 = r18 & 16
            if (r0 == 0) goto L_0x0028
            r7 = r1
            goto L_0x0029
        L_0x0028:
            r7 = r15
        L_0x0029:
            r0 = r18 & 32
            if (r0 == 0) goto L_0x002f
            r8 = r1
            goto L_0x0031
        L_0x002f:
            r8 = r16
        L_0x0031:
            r0 = r18 & 64
            if (r0 == 0) goto L_0x0037
            r9 = r1
            goto L_0x0039
        L_0x0037:
            r9 = r17
        L_0x0039:
            r2 = r10
            r5 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.data.H5EventHttpRequest.<init>(java.lang.String, java.lang.String, java.lang.Object, java.lang.Integer, java.lang.String, java.lang.String, org.json.JSONObject, int, kotlin.g.b.g):void");
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final Object getData() {
        return this.data;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final Integer getTimeout() {
        return this.timeout;
    }

    public final void setTimeout(Integer num) {
        this.timeout = num;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final void setResponseType(String str) {
        this.responseType = str;
    }

    public final String getResponseCharset() {
        return this.responseCharset;
    }

    public final void setResponseCharset(String str) {
        this.responseCharset = str;
    }

    public final JSONObject getHeaders() {
        return this.headers;
    }

    public final void setHeaders(JSONObject jSONObject) {
        this.headers = jSONObject;
    }
}
