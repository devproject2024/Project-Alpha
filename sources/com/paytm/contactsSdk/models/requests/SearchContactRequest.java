package com.paytm.contactsSdk.models.requests;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SearchContactRequest {
    private final String contactStatus;
    private final String contactType;
    private final String deviceId;
    private final Boolean forceSync;
    private final Integer limit;
    private final Long timeStamp;

    public SearchContactRequest() {
        this((String) null, (String) null, (String) null, (Long) null, (Integer) null, (Boolean) null, 63, (g) null);
    }

    public static /* synthetic */ SearchContactRequest copy$default(SearchContactRequest searchContactRequest, String str, String str2, String str3, Long l, Integer num, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = searchContactRequest.deviceId;
        }
        if ((i2 & 2) != 0) {
            str2 = searchContactRequest.contactType;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = searchContactRequest.contactStatus;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            l = searchContactRequest.timeStamp;
        }
        Long l2 = l;
        if ((i2 & 16) != 0) {
            num = searchContactRequest.limit;
        }
        Integer num2 = num;
        if ((i2 & 32) != 0) {
            bool = searchContactRequest.forceSync;
        }
        return searchContactRequest.copy(str, str4, str5, l2, num2, bool);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.contactType;
    }

    public final String component3() {
        return this.contactStatus;
    }

    public final Long component4() {
        return this.timeStamp;
    }

    public final Integer component5() {
        return this.limit;
    }

    public final Boolean component6() {
        return this.forceSync;
    }

    public final SearchContactRequest copy(String str, String str2, String str3, Long l, Integer num, Boolean bool) {
        return new SearchContactRequest(str, str2, str3, l, num, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchContactRequest)) {
            return false;
        }
        SearchContactRequest searchContactRequest = (SearchContactRequest) obj;
        return k.a((Object) this.deviceId, (Object) searchContactRequest.deviceId) && k.a((Object) this.contactType, (Object) searchContactRequest.contactType) && k.a((Object) this.contactStatus, (Object) searchContactRequest.contactStatus) && k.a((Object) this.timeStamp, (Object) searchContactRequest.timeStamp) && k.a((Object) this.limit, (Object) searchContactRequest.limit) && k.a((Object) this.forceSync, (Object) searchContactRequest.forceSync);
    }

    public final int hashCode() {
        String str = this.deviceId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contactType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.contactStatus;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l = this.timeStamp;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.limit;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.forceSync;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "SearchContactRequest(deviceId=" + this.deviceId + ", contactType=" + this.contactType + ", contactStatus=" + this.contactStatus + ", timeStamp=" + this.timeStamp + ", limit=" + this.limit + ", forceSync=" + this.forceSync + ")";
    }

    public SearchContactRequest(String str, String str2, String str3, Long l, Integer num, Boolean bool) {
        this.deviceId = str;
        this.contactType = str2;
        this.contactStatus = str3;
        this.timeStamp = l;
        this.limit = num;
        this.forceSync = bool;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getContactType() {
        return this.contactType;
    }

    public final String getContactStatus() {
        return this.contactStatus;
    }

    public final Long getTimeStamp() {
        return this.timeStamp;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SearchContactRequest(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.Long r9, java.lang.Integer r10, java.lang.Boolean r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.models.requests.SearchContactRequest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Integer, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final Boolean getForceSync() {
        return this.forceSync;
    }
}
