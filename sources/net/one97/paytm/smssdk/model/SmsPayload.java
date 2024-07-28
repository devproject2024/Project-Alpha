package net.one97.paytm.smssdk.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytmmall.clpartifact.utils.CLPConstants;
import easypay.manager.Constants;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class SmsPayload {
    private final String appVersion;
    private final String brand;
    private final String cId;
    private final String clientId;
    private final long deviceDateTime;
    private final String eventType;
    private final String event_name;
    private final String mId;
    private final String model;
    private final String osType;
    private final String osVersion;
    private final List<Payload> payload;
    private final List<Preference> preference;
    private final long uploadTime;

    public static /* synthetic */ SmsPayload copy$default(SmsPayload smsPayload, String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, String str8, String str9, List list, List list2, long j2, String str10, int i2, Object obj) {
        SmsPayload smsPayload2 = smsPayload;
        int i3 = i2;
        return smsPayload.copy((i3 & 1) != 0 ? smsPayload2.appVersion : str, (i3 & 2) != 0 ? smsPayload2.brand : str2, (i3 & 4) != 0 ? smsPayload2.cId : str3, (i3 & 8) != 0 ? smsPayload2.clientId : str4, (i3 & 16) != 0 ? smsPayload2.deviceDateTime : j, (i3 & 32) != 0 ? smsPayload2.eventType : str5, (i3 & 64) != 0 ? smsPayload2.mId : str6, (i3 & 128) != 0 ? smsPayload2.model : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? smsPayload2.osType : str8, (i3 & 512) != 0 ? smsPayload2.osVersion : str9, (i3 & TarConstants.EOF_BLOCK) != 0 ? smsPayload2.payload : list, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? smsPayload2.preference : list2, (i3 & 4096) != 0 ? smsPayload2.uploadTime : j2, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? smsPayload2.event_name : str10);
    }

    public final String component1() {
        return this.appVersion;
    }

    public final String component10() {
        return this.osVersion;
    }

    public final List<Payload> component11() {
        return this.payload;
    }

    public final List<Preference> component12() {
        return this.preference;
    }

    public final long component13() {
        return this.uploadTime;
    }

    public final String component14() {
        return this.event_name;
    }

    public final String component2() {
        return this.brand;
    }

    public final String component3() {
        return this.cId;
    }

    public final String component4() {
        return this.clientId;
    }

    public final long component5() {
        return this.deviceDateTime;
    }

    public final String component6() {
        return this.eventType;
    }

    public final String component7() {
        return this.mId;
    }

    public final String component8() {
        return this.model;
    }

    public final String component9() {
        return this.osType;
    }

    public final SmsPayload copy(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, String str8, String str9, List<Payload> list, List<Preference> list2, long j2, String str10) {
        String str11 = str;
        k.c(str11, "appVersion");
        k.c(str2, CLPConstants.BRAND_PARAMS);
        k.c(str3, "cId");
        k.c(str4, "clientId");
        k.c(str5, "eventType");
        k.c(str6, "mId");
        k.c(str7, "model");
        k.c(str8, Constants.RISK_OS_TYPE);
        k.c(str9, "osVersion");
        k.c(list, "payload");
        k.c(list2, "preference");
        k.c(str10, "event_name");
        return new SmsPayload(str11, str2, str3, str4, j, str5, str6, str7, str8, str9, list, list2, j2, str10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmsPayload)) {
            return false;
        }
        SmsPayload smsPayload = (SmsPayload) obj;
        return k.a((Object) this.appVersion, (Object) smsPayload.appVersion) && k.a((Object) this.brand, (Object) smsPayload.brand) && k.a((Object) this.cId, (Object) smsPayload.cId) && k.a((Object) this.clientId, (Object) smsPayload.clientId) && this.deviceDateTime == smsPayload.deviceDateTime && k.a((Object) this.eventType, (Object) smsPayload.eventType) && k.a((Object) this.mId, (Object) smsPayload.mId) && k.a((Object) this.model, (Object) smsPayload.model) && k.a((Object) this.osType, (Object) smsPayload.osType) && k.a((Object) this.osVersion, (Object) smsPayload.osVersion) && k.a((Object) this.payload, (Object) smsPayload.payload) && k.a((Object) this.preference, (Object) smsPayload.preference) && this.uploadTime == smsPayload.uploadTime && k.a((Object) this.event_name, (Object) smsPayload.event_name);
    }

    public final int hashCode() {
        String str = this.appVersion;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.brand;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.cId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.clientId;
        int hashCode4 = str4 != null ? str4.hashCode() : 0;
        long j = this.deviceDateTime;
        int i3 = (((hashCode3 + hashCode4) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str5 = this.eventType;
        int hashCode5 = (i3 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.model;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.osType;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.osVersion;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        List<Payload> list = this.payload;
        int hashCode10 = (hashCode9 + (list != null ? list.hashCode() : 0)) * 31;
        List<Preference> list2 = this.preference;
        int hashCode11 = list2 != null ? list2.hashCode() : 0;
        long j2 = this.uploadTime;
        int i4 = (((hashCode10 + hashCode11) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str10 = this.event_name;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return i4 + i2;
    }

    public final String toString() {
        return "SmsPayload(appVersion=" + this.appVersion + ", brand=" + this.brand + ", cId=" + this.cId + ", clientId=" + this.clientId + ", deviceDateTime=" + this.deviceDateTime + ", eventType=" + this.eventType + ", mId=" + this.mId + ", model=" + this.model + ", osType=" + this.osType + ", osVersion=" + this.osVersion + ", payload=" + this.payload + ", preference=" + this.preference + ", uploadTime=" + this.uploadTime + ", event_name=" + this.event_name + ")";
    }

    public SmsPayload(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, String str8, String str9, List<Payload> list, List<Preference> list2, long j2, String str10) {
        String str11 = str2;
        String str12 = str3;
        String str13 = str4;
        String str14 = str5;
        String str15 = str6;
        String str16 = str7;
        String str17 = str8;
        String str18 = str9;
        List<Payload> list3 = list;
        List<Preference> list4 = list2;
        String str19 = str10;
        k.c(str, "appVersion");
        k.c(str11, CLPConstants.BRAND_PARAMS);
        k.c(str12, "cId");
        k.c(str13, "clientId");
        k.c(str14, "eventType");
        k.c(str15, "mId");
        k.c(str16, "model");
        k.c(str17, Constants.RISK_OS_TYPE);
        k.c(str18, "osVersion");
        k.c(list3, "payload");
        k.c(list4, "preference");
        k.c(str19, "event_name");
        this.appVersion = str;
        this.brand = str11;
        this.cId = str12;
        this.clientId = str13;
        this.deviceDateTime = j;
        this.eventType = str14;
        this.mId = str15;
        this.model = str16;
        this.osType = str17;
        this.osVersion = str18;
        this.payload = list3;
        this.preference = list4;
        this.uploadTime = j2;
        this.event_name = str19;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getCId() {
        return this.cId;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final long getDeviceDateTime() {
        return this.deviceDateTime;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final String getMId() {
        return this.mId;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getOsType() {
        return this.osType;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final List<Payload> getPayload() {
        return this.payload;
    }

    public final List<Preference> getPreference() {
        return this.preference;
    }

    public final long getUploadTime() {
        return this.uploadTime;
    }

    public final String getEvent_name() {
        return this.event_name;
    }
}
