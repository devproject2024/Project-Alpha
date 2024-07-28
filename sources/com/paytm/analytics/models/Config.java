package com.paytm.analytics.models;

import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class Config {
    private String advertisementId;
    private String appLanguage;
    private String appVersion;
    private String brand;
    private String carrier;
    private String clientName;
    private String connectionType;
    private Map<String, String> customDimension;
    private String deviceId;
    private String ip;
    private Boolean isLocationEnable;
    private Long lastAppOpenDate;
    private Integer locationNightModeEndHour;
    private Integer locationNightModeStartHour;
    private Integer locationSchedulingTime;
    private Integer messageVersion;
    private String model;
    private final String osType;
    private String osVersion;
    private Integer sameLocationThreshold;
    private String secret;
    private String secretRequesterID;
    private String serverEndPoints;
    private Boolean showDebugLogs;
    private Integer timeSyncFrequency;
    private Integer uploadFrequency;
    private String userId;

    public static /* synthetic */ Config copy$default(Config config, String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, Integer num2, Boolean bool, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Map map, Boolean bool2, Long l, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i2, Object obj) {
        Config config2 = config;
        int i3 = i2;
        return config.copy((i3 & 1) != 0 ? config2.serverEndPoints : str, (i3 & 2) != 0 ? config2.clientName : str2, (i3 & 4) != 0 ? config2.appVersion : str3, (i3 & 8) != 0 ? config2.secret : str4, (i3 & 16) != 0 ? config2.secretRequesterID : str5, (i3 & 32) != 0 ? config2.messageVersion : num, (i3 & 64) != 0 ? config2.userId : str6, (i3 & 128) != 0 ? config2.deviceId : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? config2.appLanguage : str8, (i3 & 512) != 0 ? config2.uploadFrequency : num2, (i3 & TarConstants.EOF_BLOCK) != 0 ? config2.isLocationEnable : bool, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? config2.locationNightModeStartHour : num3, (i3 & 4096) != 0 ? config2.locationNightModeEndHour : num4, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? config2.sameLocationThreshold : num5, (i3 & 16384) != 0 ? config2.locationSchedulingTime : num6, (i3 & 32768) != 0 ? config2.timeSyncFrequency : num7, (i3 & 65536) != 0 ? config2.customDimension : map, (i3 & 131072) != 0 ? config2.showDebugLogs : bool2, (i3 & 262144) != 0 ? config2.lastAppOpenDate : l, (i3 & 524288) != 0 ? config2.osVersion : str9, (i3 & 1048576) != 0 ? config2.model : str10, (i3 & 2097152) != 0 ? config2.brand : str11, (i3 & 4194304) != 0 ? config2.ip : str12, (i3 & 8388608) != 0 ? config2.connectionType : str13, (i3 & 16777216) != 0 ? config2.carrier : str14, (i3 & 33554432) != 0 ? config2.advertisementId : str15);
    }

    public final String component1() {
        return this.serverEndPoints;
    }

    public final Integer component10() {
        return this.uploadFrequency;
    }

    public final Boolean component11() {
        return this.isLocationEnable;
    }

    public final Integer component12() {
        return this.locationNightModeStartHour;
    }

    public final Integer component13() {
        return this.locationNightModeEndHour;
    }

    public final Integer component14() {
        return this.sameLocationThreshold;
    }

    public final Integer component15() {
        return this.locationSchedulingTime;
    }

    public final Integer component16() {
        return this.timeSyncFrequency;
    }

    public final Map<String, String> component17() {
        return this.customDimension;
    }

    public final Boolean component18$paytmanalytics_release() {
        return this.showDebugLogs;
    }

    public final Long component19$paytmanalytics_release() {
        return this.lastAppOpenDate;
    }

    public final String component2() {
        return this.clientName;
    }

    public final String component20$paytmanalytics_release() {
        return this.osVersion;
    }

    public final String component21$paytmanalytics_release() {
        return this.model;
    }

    public final String component22$paytmanalytics_release() {
        return this.brand;
    }

    public final String component23$paytmanalytics_release() {
        return this.ip;
    }

    public final String component24$paytmanalytics_release() {
        return this.connectionType;
    }

    public final String component25$paytmanalytics_release() {
        return this.carrier;
    }

    public final String component26$paytmanalytics_release() {
        return this.advertisementId;
    }

    public final String component3() {
        return this.appVersion;
    }

    public final String component4() {
        return this.secret;
    }

    public final String component5() {
        return this.secretRequesterID;
    }

    public final Integer component6() {
        return this.messageVersion;
    }

    public final String component7$paytmanalytics_release() {
        return this.userId;
    }

    public final String component8() {
        return this.deviceId;
    }

    public final String component9() {
        return this.appLanguage;
    }

    public final Config copy(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, Integer num2, Boolean bool, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Map<String, String> map, Boolean bool2, Long l, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        return new Config(str, str2, str3, str4, str5, num, str6, str7, str8, num2, bool, num3, num4, num5, num6, num7, map, bool2, l, str9, str10, str11, str12, str13, str14, str15);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        return k.a((Object) this.serverEndPoints, (Object) config.serverEndPoints) && k.a((Object) this.clientName, (Object) config.clientName) && k.a((Object) this.appVersion, (Object) config.appVersion) && k.a((Object) this.secret, (Object) config.secret) && k.a((Object) this.secretRequesterID, (Object) config.secretRequesterID) && k.a((Object) this.messageVersion, (Object) config.messageVersion) && k.a((Object) this.userId, (Object) config.userId) && k.a((Object) this.deviceId, (Object) config.deviceId) && k.a((Object) this.appLanguage, (Object) config.appLanguage) && k.a((Object) this.uploadFrequency, (Object) config.uploadFrequency) && k.a((Object) this.isLocationEnable, (Object) config.isLocationEnable) && k.a((Object) this.locationNightModeStartHour, (Object) config.locationNightModeStartHour) && k.a((Object) this.locationNightModeEndHour, (Object) config.locationNightModeEndHour) && k.a((Object) this.sameLocationThreshold, (Object) config.sameLocationThreshold) && k.a((Object) this.locationSchedulingTime, (Object) config.locationSchedulingTime) && k.a((Object) this.timeSyncFrequency, (Object) config.timeSyncFrequency) && k.a((Object) this.customDimension, (Object) config.customDimension) && k.a((Object) this.showDebugLogs, (Object) config.showDebugLogs) && k.a((Object) this.lastAppOpenDate, (Object) config.lastAppOpenDate) && k.a((Object) this.osVersion, (Object) config.osVersion) && k.a((Object) this.model, (Object) config.model) && k.a((Object) this.brand, (Object) config.brand) && k.a((Object) this.ip, (Object) config.ip) && k.a((Object) this.connectionType, (Object) config.connectionType) && k.a((Object) this.carrier, (Object) config.carrier) && k.a((Object) this.advertisementId, (Object) config.advertisementId);
    }

    public final int hashCode() {
        String str = this.serverEndPoints;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.clientName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.appVersion;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.secret;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.secretRequesterID;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.messageVersion;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        String str6 = this.userId;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.deviceId;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.appLanguage;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num2 = this.uploadFrequency;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Boolean bool = this.isLocationEnable;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Integer num3 = this.locationNightModeStartHour;
        int hashCode12 = (hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.locationNightModeEndHour;
        int hashCode13 = (hashCode12 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.sameLocationThreshold;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.locationSchedulingTime;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.timeSyncFrequency;
        int hashCode16 = (hashCode15 + (num7 != null ? num7.hashCode() : 0)) * 31;
        Map<String, String> map = this.customDimension;
        int hashCode17 = (hashCode16 + (map != null ? map.hashCode() : 0)) * 31;
        Boolean bool2 = this.showDebugLogs;
        int hashCode18 = (hashCode17 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.lastAppOpenDate;
        int hashCode19 = (hashCode18 + (l != null ? l.hashCode() : 0)) * 31;
        String str9 = this.osVersion;
        int hashCode20 = (hashCode19 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.model;
        int hashCode21 = (hashCode20 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.brand;
        int hashCode22 = (hashCode21 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.ip;
        int hashCode23 = (hashCode22 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.connectionType;
        int hashCode24 = (hashCode23 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.carrier;
        int hashCode25 = (hashCode24 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.advertisementId;
        if (str15 != null) {
            i2 = str15.hashCode();
        }
        return hashCode25 + i2;
    }

    public final String toString() {
        return "Config(serverEndPoints=" + this.serverEndPoints + ", clientName=" + this.clientName + ", appVersion=" + this.appVersion + ", secret=" + this.secret + ", secretRequesterID=" + this.secretRequesterID + ", messageVersion=" + this.messageVersion + ", userId=" + this.userId + ", deviceId=" + this.deviceId + ", appLanguage=" + this.appLanguage + ", uploadFrequency=" + this.uploadFrequency + ", isLocationEnable=" + this.isLocationEnable + ", locationNightModeStartHour=" + this.locationNightModeStartHour + ", locationNightModeEndHour=" + this.locationNightModeEndHour + ", sameLocationThreshold=" + this.sameLocationThreshold + ", locationSchedulingTime=" + this.locationSchedulingTime + ", timeSyncFrequency=" + this.timeSyncFrequency + ", customDimension=" + this.customDimension + ", showDebugLogs=" + this.showDebugLogs + ", lastAppOpenDate=" + this.lastAppOpenDate + ", osVersion=" + this.osVersion + ", model=" + this.model + ", brand=" + this.brand + ", ip=" + this.ip + ", connectionType=" + this.connectionType + ", carrier=" + this.carrier + ", advertisementId=" + this.advertisementId + ")";
    }

    public Config(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, Integer num2, Boolean bool, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Map<String, String> map, Boolean bool2, Long l, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.serverEndPoints = str;
        this.clientName = str2;
        this.appVersion = str3;
        this.secret = str4;
        this.secretRequesterID = str5;
        this.messageVersion = num;
        this.userId = str6;
        this.deviceId = str7;
        this.appLanguage = str8;
        this.uploadFrequency = num2;
        this.isLocationEnable = bool;
        this.locationNightModeStartHour = num3;
        this.locationNightModeEndHour = num4;
        this.sameLocationThreshold = num5;
        this.locationSchedulingTime = num6;
        this.timeSyncFrequency = num7;
        this.customDimension = map;
        this.showDebugLogs = bool2;
        this.lastAppOpenDate = l;
        this.osVersion = str9;
        this.model = str10;
        this.brand = str11;
        this.ip = str12;
        this.connectionType = str13;
        this.carrier = str14;
        this.advertisementId = str15;
        this.osType = "android";
    }

    public final String getServerEndPoints() {
        return this.serverEndPoints;
    }

    public final void setServerEndPoints(String str) {
        this.serverEndPoints = str;
    }

    public final String getClientName() {
        return this.clientName;
    }

    public final void setClientName(String str) {
        this.clientName = str;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        this.appVersion = str;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final void setSecret(String str) {
        this.secret = str;
    }

    public final String getSecretRequesterID() {
        return this.secretRequesterID;
    }

    public final void setSecretRequesterID(String str) {
        this.secretRequesterID = str;
    }

    public final Integer getMessageVersion() {
        return this.messageVersion;
    }

    public final void setMessageVersion(Integer num) {
        this.messageVersion = num;
    }

    public final String getUserId$paytmanalytics_release() {
        return this.userId;
    }

    public final void setUserId$paytmanalytics_release(String str) {
        this.userId = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final String getAppLanguage() {
        return this.appLanguage;
    }

    public final void setAppLanguage(String str) {
        this.appLanguage = str;
    }

    public final Integer getUploadFrequency() {
        return this.uploadFrequency;
    }

    public final void setUploadFrequency(Integer num) {
        this.uploadFrequency = num;
    }

    public final Boolean isLocationEnable() {
        return this.isLocationEnable;
    }

    public final void setLocationEnable(Boolean bool) {
        this.isLocationEnable = bool;
    }

    public final Integer getLocationNightModeStartHour() {
        return this.locationNightModeStartHour;
    }

    public final void setLocationNightModeStartHour(Integer num) {
        this.locationNightModeStartHour = num;
    }

    public final Integer getLocationNightModeEndHour() {
        return this.locationNightModeEndHour;
    }

    public final void setLocationNightModeEndHour(Integer num) {
        this.locationNightModeEndHour = num;
    }

    public final Integer getSameLocationThreshold() {
        return this.sameLocationThreshold;
    }

    public final void setSameLocationThreshold(Integer num) {
        this.sameLocationThreshold = num;
    }

    public final Integer getLocationSchedulingTime() {
        return this.locationSchedulingTime;
    }

    public final void setLocationSchedulingTime(Integer num) {
        this.locationSchedulingTime = num;
    }

    public final Integer getTimeSyncFrequency() {
        return this.timeSyncFrequency;
    }

    public final void setTimeSyncFrequency(Integer num) {
        this.timeSyncFrequency = num;
    }

    public final Map<String, String> getCustomDimension() {
        return this.customDimension;
    }

    public final void setCustomDimension(Map<String, String> map) {
        this.customDimension = map;
    }

    public final Boolean getShowDebugLogs$paytmanalytics_release() {
        return this.showDebugLogs;
    }

    public final void setShowDebugLogs$paytmanalytics_release(Boolean bool) {
        this.showDebugLogs = bool;
    }

    public final Long getLastAppOpenDate$paytmanalytics_release() {
        return this.lastAppOpenDate;
    }

    public final void setLastAppOpenDate$paytmanalytics_release(Long l) {
        this.lastAppOpenDate = l;
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

    public final String getIp$paytmanalytics_release() {
        return this.ip;
    }

    public final void setIp$paytmanalytics_release(String str) {
        this.ip = str;
    }

    public final String getConnectionType$paytmanalytics_release() {
        return this.connectionType;
    }

    public final void setConnectionType$paytmanalytics_release(String str) {
        this.connectionType = str;
    }

    public final String getCarrier$paytmanalytics_release() {
        return this.carrier;
    }

    public final void setCarrier$paytmanalytics_release(String str) {
        this.carrier = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Config(java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.Integer r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.Integer r40, java.lang.Boolean r41, java.lang.Integer r42, java.lang.Integer r43, java.lang.Integer r44, java.lang.Integer r45, java.lang.Integer r46, java.util.Map r47, java.lang.Boolean r48, java.lang.Long r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, int r57, kotlin.g.b.g r58) {
        /*
            r30 = this;
            r0 = r57
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r9 = r2
            goto L_0x000b
        L_0x0009:
            r9 = r36
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            r10 = r2
            goto L_0x0013
        L_0x0011:
            r10 = r37
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0019
            r11 = r2
            goto L_0x001b
        L_0x0019:
            r11 = r38
        L_0x001b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0021
            r12 = r2
            goto L_0x0023
        L_0x0021:
            r12 = r39
        L_0x0023:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0029
            r13 = r2
            goto L_0x002b
        L_0x0029:
            r13 = r40
        L_0x002b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0031
            r14 = r2
            goto L_0x0033
        L_0x0031:
            r14 = r41
        L_0x0033:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0039
            r15 = r2
            goto L_0x003b
        L_0x0039:
            r15 = r42
        L_0x003b:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0042
            r16 = r2
            goto L_0x0044
        L_0x0042:
            r16 = r43
        L_0x0044:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x004b
            r17 = r2
            goto L_0x004d
        L_0x004b:
            r17 = r44
        L_0x004d:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0054
            r18 = r2
            goto L_0x0056
        L_0x0054:
            r18 = r45
        L_0x0056:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x005f
            r19 = r2
            goto L_0x0061
        L_0x005f:
            r19 = r46
        L_0x0061:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0069
            r20 = r2
            goto L_0x006b
        L_0x0069:
            r20 = r47
        L_0x006b:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0073
            r21 = r2
            goto L_0x0075
        L_0x0073:
            r21 = r48
        L_0x0075:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007d
            r22 = r2
            goto L_0x007f
        L_0x007d:
            r22 = r49
        L_0x007f:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0087
            r23 = r2
            goto L_0x0089
        L_0x0087:
            r23 = r50
        L_0x0089:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0091
            r24 = r2
            goto L_0x0093
        L_0x0091:
            r24 = r51
        L_0x0093:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009b
            r25 = r2
            goto L_0x009d
        L_0x009b:
            r25 = r52
        L_0x009d:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a5
            r26 = r2
            goto L_0x00a7
        L_0x00a5:
            r26 = r53
        L_0x00a7:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00af
            r27 = r2
            goto L_0x00b1
        L_0x00af:
            r27 = r54
        L_0x00b1:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b9
            r28 = r2
            goto L_0x00bb
        L_0x00b9:
            r28 = r55
        L_0x00bb:
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00c3
            r29 = r2
            goto L_0x00c5
        L_0x00c3:
            r29 = r56
        L_0x00c5:
            r3 = r30
            r4 = r31
            r5 = r32
            r6 = r33
            r7 = r34
            r8 = r35
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.models.Config.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.util.Map, java.lang.Boolean, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getAdvertisementId$paytmanalytics_release() {
        return this.advertisementId;
    }

    public final void setAdvertisementId$paytmanalytics_release(String str) {
        this.advertisementId = str;
    }

    public final String getOsType() {
        return this.osType;
    }

    public static final class Builder {
        private String advertisementId;
        private String appLanguage;
        private String appVersion;
        private String brand;
        private String carrier;
        private String clientName;
        private String connectionType;
        private Map<String, String> customDimension;
        private String deviceId;
        private String ip;
        private Boolean isEnableLogs;
        private Boolean isLocationEnable;
        private Long lastAppOpenDate;
        private Integer locationNightModeEndHour;
        private Integer locationNightModeStartHour;
        private Integer locationSchedulingTime;
        private Integer messageVersion;
        private String model;
        private String osVersion;
        private Integer sameLocationThreshold;
        private String secret;
        private String secretRequesterID;
        private String serverEndPoints;
        private Integer timeSyncFrequency;
        private Integer uploadFrequency;
        private String userId;

        public final Builder serverEndPoints(String str) {
            Builder builder = this;
            builder.serverEndPoints = builder.getStringWithoutSlashInTheEnd(str);
            return builder;
        }

        private final String getStringWithoutSlashInTheEnd(String str) {
            while (!TextUtils.isEmpty(str) && str != null && p.c(str, "/", false)) {
                str = p.g(str);
            }
            return str;
        }

        public final Builder clientName(String str) {
            Builder builder = this;
            builder.clientName = str;
            return builder;
        }

        public final Builder appVersion(String str) {
            Builder builder = this;
            builder.appVersion = str;
            return builder;
        }

        public final Builder secret(String str) {
            Builder builder = this;
            builder.secret = str;
            return builder;
        }

        public final Builder secretRequesterID(String str) {
            Builder builder = this;
            builder.secretRequesterID = str;
            return builder;
        }

        public final Builder messageVersion(Integer num) {
            Builder builder = this;
            builder.messageVersion = num;
            return builder;
        }

        public final Builder userId$paytmanalytics_release(String str) {
            Builder builder = this;
            builder.userId = str;
            return builder;
        }

        public final Builder deviceId(String str) {
            Builder builder = this;
            builder.deviceId = str;
            return builder;
        }

        public final Builder appLanguage(String str) {
            Builder builder = this;
            builder.appLanguage = str;
            return builder;
        }

        public final Builder uploadFrequency(Integer num) {
            Builder builder = this;
            builder.uploadFrequency = num;
            return builder;
        }

        public final Builder isLocationEnable(Boolean bool) {
            Builder builder = this;
            builder.isLocationEnable = bool;
            return builder;
        }

        public final Builder locationNightModeStartHour(Integer num) {
            Builder builder = this;
            builder.locationNightModeStartHour = num;
            return builder;
        }

        public final Builder locationNightModeEndHour(Integer num) {
            Builder builder = this;
            builder.locationNightModeEndHour = num;
            return builder;
        }

        public final Builder sameLocationThreshold(Integer num) {
            Builder builder = this;
            builder.sameLocationThreshold = num;
            return builder;
        }

        public final Builder locationSchedulingTime(Integer num) {
            Builder builder = this;
            builder.locationSchedulingTime = num;
            return builder;
        }

        public final Builder timeSyncFrequency(Integer num) {
            Builder builder = this;
            builder.timeSyncFrequency = num;
            return builder;
        }

        public final Builder customDimension(Map<String, String> map) {
            Builder builder = this;
            builder.customDimension = map;
            return builder;
        }

        public final Builder isEnableLogs$paytmanalytics_release(Boolean bool) {
            Builder builder = this;
            builder.isEnableLogs = bool;
            return builder;
        }

        public final Config build() {
            return new Config(this.serverEndPoints, this.clientName, this.appVersion, this.secret, this.secretRequesterID, this.messageVersion, this.userId, this.deviceId, this.appLanguage, this.uploadFrequency, this.isLocationEnable, this.locationNightModeStartHour, this.locationNightModeEndHour, this.sameLocationThreshold, this.locationSchedulingTime, this.timeSyncFrequency, this.customDimension, this.isEnableLogs, this.lastAppOpenDate, this.osVersion, this.model, this.brand, this.ip, this.connectionType, this.carrier, this.advertisementId);
        }
    }
}
