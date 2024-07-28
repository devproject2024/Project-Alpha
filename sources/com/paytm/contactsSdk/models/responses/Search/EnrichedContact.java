package com.paytm.contactsSdk.models.responses.Search;

import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class EnrichedContact {
    private final String contactId;
    private final SearchContactInfo contactInfo;
    private final String contactRefId;
    private final String contactType;
    private final Long creationTime;
    private final String name;
    private final String nickName;
    private final Map<String, Object> profiles;
    private final String status;
    private final Long updateDate;

    public EnrichedContact() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (SearchContactInfo) null, (Map) null, (Long) null, (Long) null, 1023, (g) null);
    }

    public static /* synthetic */ EnrichedContact copy$default(EnrichedContact enrichedContact, String str, String str2, String str3, String str4, String str5, String str6, SearchContactInfo searchContactInfo, Map map, Long l, Long l2, int i2, Object obj) {
        EnrichedContact enrichedContact2 = enrichedContact;
        int i3 = i2;
        return enrichedContact.copy((i3 & 1) != 0 ? enrichedContact2.contactId : str, (i3 & 2) != 0 ? enrichedContact2.contactRefId : str2, (i3 & 4) != 0 ? enrichedContact2.name : str3, (i3 & 8) != 0 ? enrichedContact2.nickName : str4, (i3 & 16) != 0 ? enrichedContact2.status : str5, (i3 & 32) != 0 ? enrichedContact2.contactType : str6, (i3 & 64) != 0 ? enrichedContact2.contactInfo : searchContactInfo, (i3 & 128) != 0 ? enrichedContact2.profiles : map, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? enrichedContact2.creationTime : l, (i3 & 512) != 0 ? enrichedContact2.updateDate : l2);
    }

    public final String component1() {
        return this.contactId;
    }

    public final Long component10() {
        return this.updateDate;
    }

    public final String component2() {
        return this.contactRefId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.nickName;
    }

    public final String component5() {
        return this.status;
    }

    public final String component6() {
        return this.contactType;
    }

    public final SearchContactInfo component7() {
        return this.contactInfo;
    }

    public final Map<String, Object> component8() {
        return this.profiles;
    }

    public final Long component9() {
        return this.creationTime;
    }

    public final EnrichedContact copy(String str, String str2, String str3, String str4, String str5, String str6, SearchContactInfo searchContactInfo, Map<String, ? extends Object> map, Long l, Long l2) {
        return new EnrichedContact(str, str2, str3, str4, str5, str6, searchContactInfo, map, l, l2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnrichedContact)) {
            return false;
        }
        EnrichedContact enrichedContact = (EnrichedContact) obj;
        return k.a((Object) this.contactId, (Object) enrichedContact.contactId) && k.a((Object) this.contactRefId, (Object) enrichedContact.contactRefId) && k.a((Object) this.name, (Object) enrichedContact.name) && k.a((Object) this.nickName, (Object) enrichedContact.nickName) && k.a((Object) this.status, (Object) enrichedContact.status) && k.a((Object) this.contactType, (Object) enrichedContact.contactType) && k.a((Object) this.contactInfo, (Object) enrichedContact.contactInfo) && k.a((Object) this.profiles, (Object) enrichedContact.profiles) && k.a((Object) this.creationTime, (Object) enrichedContact.creationTime) && k.a((Object) this.updateDate, (Object) enrichedContact.updateDate);
    }

    public final int hashCode() {
        String str = this.contactId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contactRefId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nickName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.status;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.contactType;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        SearchContactInfo searchContactInfo = this.contactInfo;
        int hashCode7 = (hashCode6 + (searchContactInfo != null ? searchContactInfo.hashCode() : 0)) * 31;
        Map<String, Object> map = this.profiles;
        int hashCode8 = (hashCode7 + (map != null ? map.hashCode() : 0)) * 31;
        Long l = this.creationTime;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.updateDate;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "EnrichedContact(contactId=" + this.contactId + ", contactRefId=" + this.contactRefId + ", name=" + this.name + ", nickName=" + this.nickName + ", status=" + this.status + ", contactType=" + this.contactType + ", contactInfo=" + this.contactInfo + ", profiles=" + this.profiles + ", creationTime=" + this.creationTime + ", updateDate=" + this.updateDate + ")";
    }

    public EnrichedContact(String str, String str2, String str3, String str4, String str5, String str6, SearchContactInfo searchContactInfo, Map<String, ? extends Object> map, Long l, Long l2) {
        this.contactId = str;
        this.contactRefId = str2;
        this.name = str3;
        this.nickName = str4;
        this.status = str5;
        this.contactType = str6;
        this.contactInfo = searchContactInfo;
        this.profiles = map;
        this.creationTime = l;
        this.updateDate = l2;
    }

    public final String getContactId() {
        return this.contactId;
    }

    public final String getContactRefId() {
        return this.contactRefId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getContactType() {
        return this.contactType;
    }

    public final SearchContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public final Map<String, Object> getProfiles() {
        return this.profiles;
    }

    public final Long getCreationTime() {
        return this.creationTime;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EnrichedContact(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.paytm.contactsSdk.models.responses.Search.SearchContactInfo r18, java.util.Map r19, java.lang.Long r20, java.lang.Long r21, int r22, kotlin.g.b.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.models.responses.Search.EnrichedContact.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.paytm.contactsSdk.models.responses.Search.SearchContactInfo, java.util.Map, java.lang.Long, java.lang.Long, int, kotlin.g.b.g):void");
    }

    public final Long getUpdateDate() {
        return this.updateDate;
    }
}
