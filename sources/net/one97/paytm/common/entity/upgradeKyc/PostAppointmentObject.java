package net.one97.paytm.common.entity.upgradeKyc;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class PostAppointmentObject {
    private boolean addressChanged;
    private String altPhoneNumber;
    private String appointmentDate;
    private String appointmentTimeSlot;
    private String cancelAppointment;
    private String cancelReason;
    private String customerId;
    private KycAddress kycAddress;
    private String leadSource;
    private String phoneNumber;
    private String qrCodeId;
    private String reSchedule;
    private String reScheduleReason;

    public PostAppointmentObject() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, (KycAddress) null, 8191, (g) null);
    }

    public static /* synthetic */ PostAppointmentObject copy$default(PostAppointmentObject postAppointmentObject, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, KycAddress kycAddress2, int i2, Object obj) {
        PostAppointmentObject postAppointmentObject2 = postAppointmentObject;
        int i3 = i2;
        return postAppointmentObject.copy((i3 & 1) != 0 ? postAppointmentObject2.customerId : str, (i3 & 2) != 0 ? postAppointmentObject2.qrCodeId : str2, (i3 & 4) != 0 ? postAppointmentObject2.leadSource : str3, (i3 & 8) != 0 ? postAppointmentObject2.phoneNumber : str4, (i3 & 16) != 0 ? postAppointmentObject2.altPhoneNumber : str5, (i3 & 32) != 0 ? postAppointmentObject2.appointmentDate : str6, (i3 & 64) != 0 ? postAppointmentObject2.appointmentTimeSlot : str7, (i3 & 128) != 0 ? postAppointmentObject2.cancelAppointment : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? postAppointmentObject2.cancelReason : str9, (i3 & 512) != 0 ? postAppointmentObject2.reSchedule : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? postAppointmentObject2.reScheduleReason : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? postAppointmentObject2.addressChanged : z, (i3 & 4096) != 0 ? postAppointmentObject2.kycAddress : kycAddress2);
    }

    public final String component1() {
        return this.customerId;
    }

    public final String component10() {
        return this.reSchedule;
    }

    public final String component11() {
        return this.reScheduleReason;
    }

    public final boolean component12() {
        return this.addressChanged;
    }

    public final KycAddress component13() {
        return this.kycAddress;
    }

    public final String component2() {
        return this.qrCodeId;
    }

    public final String component3() {
        return this.leadSource;
    }

    public final String component4() {
        return this.phoneNumber;
    }

    public final String component5() {
        return this.altPhoneNumber;
    }

    public final String component6() {
        return this.appointmentDate;
    }

    public final String component7() {
        return this.appointmentTimeSlot;
    }

    public final String component8() {
        return this.cancelAppointment;
    }

    public final String component9() {
        return this.cancelReason;
    }

    public final PostAppointmentObject copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, KycAddress kycAddress2) {
        String str12 = str3;
        k.c(str12, "leadSource");
        String str13 = str9;
        k.c(str13, "cancelReason");
        String str14 = str11;
        k.c(str14, "reScheduleReason");
        return new PostAppointmentObject(str, str2, str12, str4, str5, str6, str7, str8, str13, str10, str14, z, kycAddress2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PostAppointmentObject) {
                PostAppointmentObject postAppointmentObject = (PostAppointmentObject) obj;
                if (k.a((Object) this.customerId, (Object) postAppointmentObject.customerId) && k.a((Object) this.qrCodeId, (Object) postAppointmentObject.qrCodeId) && k.a((Object) this.leadSource, (Object) postAppointmentObject.leadSource) && k.a((Object) this.phoneNumber, (Object) postAppointmentObject.phoneNumber) && k.a((Object) this.altPhoneNumber, (Object) postAppointmentObject.altPhoneNumber) && k.a((Object) this.appointmentDate, (Object) postAppointmentObject.appointmentDate) && k.a((Object) this.appointmentTimeSlot, (Object) postAppointmentObject.appointmentTimeSlot) && k.a((Object) this.cancelAppointment, (Object) postAppointmentObject.cancelAppointment) && k.a((Object) this.cancelReason, (Object) postAppointmentObject.cancelReason) && k.a((Object) this.reSchedule, (Object) postAppointmentObject.reSchedule) && k.a((Object) this.reScheduleReason, (Object) postAppointmentObject.reScheduleReason)) {
                    if (!(this.addressChanged == postAppointmentObject.addressChanged) || !k.a((Object) this.kycAddress, (Object) postAppointmentObject.kycAddress)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.customerId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.qrCodeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.leadSource;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.phoneNumber;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.altPhoneNumber;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.appointmentDate;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.appointmentTimeSlot;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.cancelAppointment;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.cancelReason;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.reSchedule;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.reScheduleReason;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        boolean z = this.addressChanged;
        if (z) {
            z = true;
        }
        int i3 = (hashCode11 + (z ? 1 : 0)) * 31;
        KycAddress kycAddress2 = this.kycAddress;
        if (kycAddress2 != null) {
            i2 = kycAddress2.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "PostAppointmentObject(customerId=" + this.customerId + ", qrCodeId=" + this.qrCodeId + ", leadSource=" + this.leadSource + ", phoneNumber=" + this.phoneNumber + ", altPhoneNumber=" + this.altPhoneNumber + ", appointmentDate=" + this.appointmentDate + ", appointmentTimeSlot=" + this.appointmentTimeSlot + ", cancelAppointment=" + this.cancelAppointment + ", cancelReason=" + this.cancelReason + ", reSchedule=" + this.reSchedule + ", reScheduleReason=" + this.reScheduleReason + ", addressChanged=" + this.addressChanged + ", kycAddress=" + this.kycAddress + ")";
    }

    public PostAppointmentObject(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, KycAddress kycAddress2) {
        k.c(str3, "leadSource");
        k.c(str9, "cancelReason");
        k.c(str11, "reScheduleReason");
        this.customerId = str;
        this.qrCodeId = str2;
        this.leadSource = str3;
        this.phoneNumber = str4;
        this.altPhoneNumber = str5;
        this.appointmentDate = str6;
        this.appointmentTimeSlot = str7;
        this.cancelAppointment = str8;
        this.cancelReason = str9;
        this.reSchedule = str10;
        this.reScheduleReason = str11;
        this.addressChanged = z;
        this.kycAddress = kycAddress2;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        this.customerId = str;
    }

    public final String getQrCodeId() {
        return this.qrCodeId;
    }

    public final void setQrCodeId(String str) {
        this.qrCodeId = str;
    }

    public final String getLeadSource() {
        return this.leadSource;
    }

    public final void setLeadSource(String str) {
        k.c(str, "<set-?>");
        this.leadSource = str;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public final String getAltPhoneNumber() {
        return this.altPhoneNumber;
    }

    public final void setAltPhoneNumber(String str) {
        this.altPhoneNumber = str;
    }

    public final String getAppointmentDate() {
        return this.appointmentDate;
    }

    public final void setAppointmentDate(String str) {
        this.appointmentDate = str;
    }

    public final String getAppointmentTimeSlot() {
        return this.appointmentTimeSlot;
    }

    public final void setAppointmentTimeSlot(String str) {
        this.appointmentTimeSlot = str;
    }

    public final String getCancelAppointment() {
        return this.cancelAppointment;
    }

    public final void setCancelAppointment(String str) {
        this.cancelAppointment = str;
    }

    public final String getCancelReason() {
        return this.cancelReason;
    }

    public final void setCancelReason(String str) {
        k.c(str, "<set-?>");
        this.cancelReason = str;
    }

    public final String getReSchedule() {
        return this.reSchedule;
    }

    public final void setReSchedule(String str) {
        this.reSchedule = str;
    }

    public final String getReScheduleReason() {
        return this.reScheduleReason;
    }

    public final void setReScheduleReason(String str) {
        k.c(str, "<set-?>");
        this.reScheduleReason = str;
    }

    public final boolean getAddressChanged() {
        return this.addressChanged;
    }

    public final void setAddressChanged(boolean z) {
        this.addressChanged = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PostAppointmentObject(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, boolean r26, net.one97.paytm.common.entity.upgradeKyc.KycAddress r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            java.lang.String r4 = "App"
            goto L_0x001b
        L_0x0019:
            r4 = r17
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r18
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r19
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r20
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r21
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r22
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004b
            java.lang.String r10 = "testing purposes"
            goto L_0x004d
        L_0x004b:
            r10 = r23
        L_0x004d:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0053
            r11 = r2
            goto L_0x0055
        L_0x0053:
            r11 = r24
        L_0x0055:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005c
            java.lang.String r12 = ""
            goto L_0x005e
        L_0x005c:
            r12 = r25
        L_0x005e:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0064
            r13 = 0
            goto L_0x0066
        L_0x0064:
            r13 = r26
        L_0x0066:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r2 = r27
        L_0x006d:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.upgradeKyc.PostAppointmentObject.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, net.one97.paytm.common.entity.upgradeKyc.KycAddress, int, kotlin.g.b.g):void");
    }

    public final KycAddress getKycAddress() {
        return this.kycAddress;
    }

    public final void setKycAddress(KycAddress kycAddress2) {
        this.kycAddress = kycAddress2;
    }
}
