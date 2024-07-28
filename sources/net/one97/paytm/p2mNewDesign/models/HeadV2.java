package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class HeadV2 implements IJRDataModel {
    private HashMap<String, Object> additionalProperties;
    @b(a = "clientId")
    private String clientId;
    @b(a = "mid")
    private String mid;
    @b(a = "requestId")
    private String requestId;
    @b(a = "responseTimestamp")
    private String responseTimestamp;
    @b(a = "version")
    private String version;

    public HeadV2() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ HeadV2 copy$default(HeadV2 headV2, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = headV2.mid;
        }
        if ((i2 & 2) != 0) {
            str2 = headV2.version;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = headV2.responseTimestamp;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = headV2.requestId;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = headV2.clientId;
        }
        return headV2.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.mid;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.responseTimestamp;
    }

    public final String component4() {
        return this.requestId;
    }

    public final String component5() {
        return this.clientId;
    }

    public final HeadV2 copy(String str, String str2, String str3, String str4, String str5) {
        return new HeadV2(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeadV2)) {
            return false;
        }
        HeadV2 headV2 = (HeadV2) obj;
        return k.a((Object) this.mid, (Object) headV2.mid) && k.a((Object) this.version, (Object) headV2.version) && k.a((Object) this.responseTimestamp, (Object) headV2.responseTimestamp) && k.a((Object) this.requestId, (Object) headV2.requestId) && k.a((Object) this.clientId, (Object) headV2.clientId);
    }

    public final int hashCode() {
        String str = this.mid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.version;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.responseTimestamp;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.requestId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.clientId;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "HeadV2(mid=" + this.mid + ", version=" + this.version + ", responseTimestamp=" + this.responseTimestamp + ", requestId=" + this.requestId + ", clientId=" + this.clientId + ")";
    }

    public HeadV2(String str, String str2, String str3, String str4, String str5) {
        this.mid = str;
        this.version = str2;
        this.responseTimestamp = str3;
        this.requestId = str4;
        this.clientId = str5;
        this.additionalProperties = new HashMap<>();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HeadV2(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.HeadV2.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getResponseTimestamp() {
        return this.responseTimestamp;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setClientId(String str) {
        this.clientId = str;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setResponseTimestamp(String str) {
        this.responseTimestamp = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final HashMap<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public final void setAdditionalProperties(HashMap<String, Object> hashMap) {
        k.c(hashMap, "<set-?>");
        this.additionalProperties = hashMap;
    }

    /* renamed from: getAdditionalProperties  reason: collision with other method in class */
    public final Map<String, Object> m634getAdditionalProperties() {
        return this.additionalProperties;
    }

    public final void setAdditionalProperty(String str, Object obj) {
        k.c(str, "name");
        k.c(obj, "value");
        this.additionalProperties.put(str, obj);
    }
}
