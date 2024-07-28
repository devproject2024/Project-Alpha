package com.paytm.analytics.models;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class SignalEvent {
    private String advertisementId;
    private String appLanguage;
    private String appVersion;
    private String brand;
    private String carrier;
    private String clientId;
    private String connectionType;
    private String customerId;
    private Long deviceDateTime;
    private String deviceId;
    private String eventType;
    private Long id;
    private String ip;
    private Long lastAppOpenDate;
    private String latitude;
    private String longitude;
    private Integer messageVersion;
    private String model;
    private String osType;
    private String osVersion;
    private Object payload;
    private Integer priority;
    private String sdkVersion;
    private Long uploadTime;

    public SignalEvent() {
        this((String) null, (Object) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16777215, (g) null);
    }

    public static /* synthetic */ SignalEvent copy$default(SignalEvent signalEvent, String str, Object obj, Integer num, Long l, String str2, String str3, Long l2, String str4, Integer num2, Long l3, String str5, String str6, Long l4, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i2, Object obj2) {
        SignalEvent signalEvent2 = signalEvent;
        int i3 = i2;
        return signalEvent.copy((i3 & 1) != 0 ? signalEvent2.eventType : str, (i3 & 2) != 0 ? signalEvent2.payload : obj, (i3 & 4) != 0 ? signalEvent2.priority : num, (i3 & 8) != 0 ? signalEvent2.id : l, (i3 & 16) != 0 ? signalEvent2.deviceId : str2, (i3 & 32) != 0 ? signalEvent2.customerId : str3, (i3 & 64) != 0 ? signalEvent2.deviceDateTime : l2, (i3 & 128) != 0 ? signalEvent2.clientId : str4, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? signalEvent2.messageVersion : num2, (i3 & 512) != 0 ? signalEvent2.uploadTime : l3, (i3 & TarConstants.EOF_BLOCK) != 0 ? signalEvent2.appVersion : str5, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? signalEvent2.appLanguage : str6, (i3 & 4096) != 0 ? signalEvent2.lastAppOpenDate : l4, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? signalEvent2.osType : str7, (i3 & 16384) != 0 ? signalEvent2.osVersion : str8, (i3 & 32768) != 0 ? signalEvent2.model : str9, (i3 & 65536) != 0 ? signalEvent2.brand : str10, (i3 & 131072) != 0 ? signalEvent2.longitude : str11, (i3 & 262144) != 0 ? signalEvent2.latitude : str12, (i3 & 524288) != 0 ? signalEvent2.advertisementId : str13, (i3 & 1048576) != 0 ? signalEvent2.ip : str14, (i3 & 2097152) != 0 ? signalEvent2.carrier : str15, (i3 & 4194304) != 0 ? signalEvent2.connectionType : str16, (i3 & 8388608) != 0 ? signalEvent2.sdkVersion : str17);
    }

    public final String component1() {
        return this.eventType;
    }

    public final Long component10$paytmanalytics_release() {
        return this.uploadTime;
    }

    public final String component11$paytmanalytics_release() {
        return this.appVersion;
    }

    public final String component12$paytmanalytics_release() {
        return this.appLanguage;
    }

    public final Long component13$paytmanalytics_release() {
        return this.lastAppOpenDate;
    }

    public final String component14$paytmanalytics_release() {
        return this.osType;
    }

    public final String component15$paytmanalytics_release() {
        return this.osVersion;
    }

    public final String component16$paytmanalytics_release() {
        return this.model;
    }

    public final String component17$paytmanalytics_release() {
        return this.brand;
    }

    public final String component18$paytmanalytics_release() {
        return this.longitude;
    }

    public final String component19$paytmanalytics_release() {
        return this.latitude;
    }

    public final Object component2() {
        return this.payload;
    }

    public final String component20$paytmanalytics_release() {
        return this.advertisementId;
    }

    public final String component21$paytmanalytics_release() {
        return this.ip;
    }

    public final String component22$paytmanalytics_release() {
        return this.carrier;
    }

    public final String component23$paytmanalytics_release() {
        return this.connectionType;
    }

    public final String component24$paytmanalytics_release() {
        return this.sdkVersion;
    }

    public final Integer component3() {
        return this.priority;
    }

    public final Long component4$paytmanalytics_release() {
        return this.id;
    }

    public final String component5$paytmanalytics_release() {
        return this.deviceId;
    }

    public final String component6$paytmanalytics_release() {
        return this.customerId;
    }

    public final Long component7$paytmanalytics_release() {
        return this.deviceDateTime;
    }

    public final String component8$paytmanalytics_release() {
        return this.clientId;
    }

    public final Integer component9$paytmanalytics_release() {
        return this.messageVersion;
    }

    public final SignalEvent copy(String str, Object obj, Integer num, Long l, String str2, String str3, Long l2, String str4, Integer num2, Long l3, String str5, String str6, Long l4, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        return new SignalEvent(str, obj, num, l, str2, str3, l2, str4, num2, l3, str5, str6, l4, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignalEvent)) {
            return false;
        }
        SignalEvent signalEvent = (SignalEvent) obj;
        return k.a((Object) this.eventType, (Object) signalEvent.eventType) && k.a(this.payload, signalEvent.payload) && k.a((Object) this.priority, (Object) signalEvent.priority) && k.a((Object) this.id, (Object) signalEvent.id) && k.a((Object) this.deviceId, (Object) signalEvent.deviceId) && k.a((Object) this.customerId, (Object) signalEvent.customerId) && k.a((Object) this.deviceDateTime, (Object) signalEvent.deviceDateTime) && k.a((Object) this.clientId, (Object) signalEvent.clientId) && k.a((Object) this.messageVersion, (Object) signalEvent.messageVersion) && k.a((Object) this.uploadTime, (Object) signalEvent.uploadTime) && k.a((Object) this.appVersion, (Object) signalEvent.appVersion) && k.a((Object) this.appLanguage, (Object) signalEvent.appLanguage) && k.a((Object) this.lastAppOpenDate, (Object) signalEvent.lastAppOpenDate) && k.a((Object) this.osType, (Object) signalEvent.osType) && k.a((Object) this.osVersion, (Object) signalEvent.osVersion) && k.a((Object) this.model, (Object) signalEvent.model) && k.a((Object) this.brand, (Object) signalEvent.brand) && k.a((Object) this.longitude, (Object) signalEvent.longitude) && k.a((Object) this.latitude, (Object) signalEvent.latitude) && k.a((Object) this.advertisementId, (Object) signalEvent.advertisementId) && k.a((Object) this.ip, (Object) signalEvent.ip) && k.a((Object) this.carrier, (Object) signalEvent.carrier) && k.a((Object) this.connectionType, (Object) signalEvent.connectionType) && k.a((Object) this.sdkVersion, (Object) signalEvent.sdkVersion);
    }

    public final int hashCode() {
        String str = this.eventType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.payload;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Integer num = this.priority;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.id;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.deviceId;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.customerId;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l2 = this.deviceDateTime;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str4 = this.clientId;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num2 = this.messageVersion;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Long l3 = this.uploadTime;
        int hashCode10 = (hashCode9 + (l3 != null ? l3.hashCode() : 0)) * 31;
        String str5 = this.appVersion;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.appLanguage;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Long l4 = this.lastAppOpenDate;
        int hashCode13 = (hashCode12 + (l4 != null ? l4.hashCode() : 0)) * 31;
        String str7 = this.osType;
        int hashCode14 = (hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.osVersion;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.model;
        int hashCode16 = (hashCode15 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.brand;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.longitude;
        int hashCode18 = (hashCode17 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.latitude;
        int hashCode19 = (hashCode18 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.advertisementId;
        int hashCode20 = (hashCode19 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.ip;
        int hashCode21 = (hashCode20 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.carrier;
        int hashCode22 = (hashCode21 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.connectionType;
        int hashCode23 = (hashCode22 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.sdkVersion;
        if (str17 != null) {
            i2 = str17.hashCode();
        }
        return hashCode23 + i2;
    }

    public final String toString() {
        return "SignalEvent(eventType=" + this.eventType + ", payload=" + this.payload + ", priority=" + this.priority + ", id=" + this.id + ", deviceId=" + this.deviceId + ", customerId=" + this.customerId + ", deviceDateTime=" + this.deviceDateTime + ", clientId=" + this.clientId + ", messageVersion=" + this.messageVersion + ", uploadTime=" + this.uploadTime + ", appVersion=" + this.appVersion + ", appLanguage=" + this.appLanguage + ", lastAppOpenDate=" + this.lastAppOpenDate + ", osType=" + this.osType + ", osVersion=" + this.osVersion + ", model=" + this.model + ", brand=" + this.brand + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", advertisementId=" + this.advertisementId + ", ip=" + this.ip + ", carrier=" + this.carrier + ", connectionType=" + this.connectionType + ", sdkVersion=" + this.sdkVersion + ")";
    }

    public SignalEvent(String str, Object obj, Integer num, Long l, String str2, String str3, Long l2, String str4, Integer num2, Long l3, String str5, String str6, Long l4, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        this.eventType = str;
        this.payload = obj;
        this.priority = num;
        this.id = l;
        this.deviceId = str2;
        this.customerId = str3;
        this.deviceDateTime = l2;
        this.clientId = str4;
        this.messageVersion = num2;
        this.uploadTime = l3;
        this.appVersion = str5;
        this.appLanguage = str6;
        this.lastAppOpenDate = l4;
        this.osType = str7;
        this.osVersion = str8;
        this.model = str9;
        this.brand = str10;
        this.longitude = str11;
        this.latitude = str12;
        this.advertisementId = str13;
        this.ip = str14;
        this.carrier = str15;
        this.connectionType = str16;
        this.sdkVersion = str17;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final void setEventType(String str) {
        this.eventType = str;
    }

    public final Object getPayload() {
        return this.payload;
    }

    public final void setPayload(Object obj) {
        this.payload = obj;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SignalEvent(java.lang.String r26, java.lang.Object r27, java.lang.Integer r28, java.lang.Long r29, java.lang.String r30, java.lang.String r31, java.lang.Long r32, java.lang.String r33, java.lang.Integer r34, java.lang.Long r35, java.lang.String r36, java.lang.String r37, java.lang.Long r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, int r50, kotlin.g.b.g r51) {
        /*
            r25 = this;
            r0 = r50
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r26
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r27
        L_0x0012:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            goto L_0x001e
        L_0x001c:
            r4 = r28
        L_0x001e:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0024
            r6 = 0
            goto L_0x0026
        L_0x0024:
            r6 = r29
        L_0x0026:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002c
            r7 = 0
            goto L_0x002e
        L_0x002c:
            r7 = r30
        L_0x002e:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0034
            r8 = 0
            goto L_0x0036
        L_0x0034:
            r8 = r31
        L_0x0036:
            r9 = r0 & 64
            r10 = 0
            if (r9 == 0) goto L_0x0041
            java.lang.Long r9 = java.lang.Long.valueOf(r10)
            goto L_0x0043
        L_0x0041:
            r9 = r32
        L_0x0043:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0049
            r12 = 0
            goto L_0x004b
        L_0x0049:
            r12 = r33
        L_0x004b:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0054
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0056
        L_0x0054:
            r5 = r34
        L_0x0056:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x005f
            java.lang.Long r13 = java.lang.Long.valueOf(r10)
            goto L_0x0061
        L_0x005f:
            r13 = r35
        L_0x0061:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0067
            r14 = 0
            goto L_0x0069
        L_0x0067:
            r14 = r36
        L_0x0069:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x006f
            r15 = 0
            goto L_0x0071
        L_0x006f:
            r15 = r37
        L_0x0071:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x007a
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            goto L_0x007c
        L_0x007a:
            r2 = r38
        L_0x007c:
            r10 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x0082
            r10 = 0
            goto L_0x0084
        L_0x0082:
            r10 = r39
        L_0x0084:
            r11 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x008a
            r11 = 0
            goto L_0x008c
        L_0x008a:
            r11 = r40
        L_0x008c:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0096
            r16 = 0
            goto L_0x0098
        L_0x0096:
            r16 = r41
        L_0x0098:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00a1
            r17 = 0
            goto L_0x00a3
        L_0x00a1:
            r17 = r42
        L_0x00a3:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00ac
            r18 = 0
            goto L_0x00ae
        L_0x00ac:
            r18 = r43
        L_0x00ae:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00b7
            r19 = 0
            goto L_0x00b9
        L_0x00b7:
            r19 = r44
        L_0x00b9:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00c2
            r20 = 0
            goto L_0x00c4
        L_0x00c2:
            r20 = r45
        L_0x00c4:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00cd
            r21 = 0
            goto L_0x00cf
        L_0x00cd:
            r21 = r46
        L_0x00cf:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00d8
            r22 = 0
            goto L_0x00da
        L_0x00d8:
            r22 = r47
        L_0x00da:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00e3
            r23 = 0
            goto L_0x00e5
        L_0x00e3:
            r23 = r48
        L_0x00e5:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r24
            if (r0 == 0) goto L_0x00ee
            java.lang.String r0 = "4.1.8"
            goto L_0x00f0
        L_0x00ee:
            r0 = r49
        L_0x00f0:
            r26 = r25
            r27 = r1
            r28 = r3
            r29 = r4
            r30 = r6
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r12
            r35 = r5
            r36 = r13
            r37 = r14
            r38 = r15
            r39 = r2
            r40 = r10
            r41 = r11
            r42 = r16
            r43 = r17
            r44 = r18
            r45 = r19
            r46 = r20
            r47 = r21
            r48 = r22
            r49 = r23
            r50 = r0
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.models.SignalEvent.<init>(java.lang.String, java.lang.Object, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final void setPriority(Integer num) {
        this.priority = num;
    }

    public final Long getId$paytmanalytics_release() {
        return this.id;
    }

    public final void setId$paytmanalytics_release(Long l) {
        this.id = l;
    }

    public final String getDeviceId$paytmanalytics_release() {
        return this.deviceId;
    }

    public final void setDeviceId$paytmanalytics_release(String str) {
        this.deviceId = str;
    }

    public final String getCustomerId$paytmanalytics_release() {
        return this.customerId;
    }

    public final void setCustomerId$paytmanalytics_release(String str) {
        this.customerId = str;
    }

    public final Long getDeviceDateTime$paytmanalytics_release() {
        return this.deviceDateTime;
    }

    public final void setDeviceDateTime$paytmanalytics_release(Long l) {
        this.deviceDateTime = l;
    }

    public final String getClientId$paytmanalytics_release() {
        return this.clientId;
    }

    public final void setClientId$paytmanalytics_release(String str) {
        this.clientId = str;
    }

    public final Integer getMessageVersion$paytmanalytics_release() {
        return this.messageVersion;
    }

    public final void setMessageVersion$paytmanalytics_release(Integer num) {
        this.messageVersion = num;
    }

    public final Long getUploadTime$paytmanalytics_release() {
        return this.uploadTime;
    }

    public final void setUploadTime$paytmanalytics_release(Long l) {
        this.uploadTime = l;
    }

    public final String getAppVersion$paytmanalytics_release() {
        return this.appVersion;
    }

    public final void setAppVersion$paytmanalytics_release(String str) {
        this.appVersion = str;
    }

    public final String getAppLanguage$paytmanalytics_release() {
        return this.appLanguage;
    }

    public final void setAppLanguage$paytmanalytics_release(String str) {
        this.appLanguage = str;
    }

    public final Long getLastAppOpenDate$paytmanalytics_release() {
        return this.lastAppOpenDate;
    }

    public final void setLastAppOpenDate$paytmanalytics_release(Long l) {
        this.lastAppOpenDate = l;
    }

    public final String getOsType$paytmanalytics_release() {
        return this.osType;
    }

    public final void setOsType$paytmanalytics_release(String str) {
        this.osType = str;
    }

    public final String getOsVersion$paytmanalytics_release() {
        return this.osVersion;
    }

    public final void setOsVersion$paytmanalytics_release(String str) {
        this.osVersion = str;
    }

    public final String getModel$paytmanalytics_release() {
        return this.model;
    }

    public final void setModel$paytmanalytics_release(String str) {
        this.model = str;
    }

    public final String getBrand$paytmanalytics_release() {
        return this.brand;
    }

    public final void setBrand$paytmanalytics_release(String str) {
        this.brand = str;
    }

    public final String getLongitude$paytmanalytics_release() {
        return this.longitude;
    }

    public final void setLongitude$paytmanalytics_release(String str) {
        this.longitude = str;
    }

    public final String getLatitude$paytmanalytics_release() {
        return this.latitude;
    }

    public final void setLatitude$paytmanalytics_release(String str) {
        this.latitude = str;
    }

    public final String getAdvertisementId$paytmanalytics_release() {
        return this.advertisementId;
    }

    public final void setAdvertisementId$paytmanalytics_release(String str) {
        this.advertisementId = str;
    }

    public final String getIp$paytmanalytics_release() {
        return this.ip;
    }

    public final void setIp$paytmanalytics_release(String str) {
        this.ip = str;
    }

    public final String getCarrier$paytmanalytics_release() {
        return this.carrier;
    }

    public final void setCarrier$paytmanalytics_release(String str) {
        this.carrier = str;
    }

    public final String getConnectionType$paytmanalytics_release() {
        return this.connectionType;
    }

    public final void setConnectionType$paytmanalytics_release(String str) {
        this.connectionType = str;
    }

    public final String getSdkVersion$paytmanalytics_release() {
        return this.sdkVersion;
    }

    public final void setSdkVersion$paytmanalytics_release(String str) {
        this.sdkVersion = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SignalEvent(String str, Object obj, Integer num) {
        this((String) null, (Object) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16777215, (g) null);
        k.c(str, "eventType");
        k.c(obj, "payload");
        this.eventType = str;
        this.payload = obj;
        this.priority = num;
    }
}
