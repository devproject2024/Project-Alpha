package net.one97.paytm.paymentsBank.model.slfd;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class NomineeDetailsResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "areaName")
    private final String areaName;
    @b(a = "city")
    private final String city;
    @b(a = "custId")
    private final String custId;
    @b(a = "dob")
    private final String dob;
    @b(a = "email")
    private final String email;
    @b(a = "houseNo")
    private final String houseNo;
    @b(a = "active")
    private final boolean isActive;
    @b(a = "latitude")
    private final String latitude;
    @b(a = "longitude")
    private final String longitude;
    @b(a = "name")
    private final String name;
    @b(a = "nomineeFinservId")
    private final String nomineeFinservId;
    @b(a = "oauthId")
    private final String oauthId;
    @b(a = "pinCode")
    private final String pinCode;
    @b(a = "relationship")
    private final String relationship;
    @b(a = "state")
    private final String state;
    @b(a = "streetName")
    private final String streetName;

    public NomineeDetailsResponse() {
        this(false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 65535, (g) null);
    }

    public static /* synthetic */ NomineeDetailsResponse copy$default(NomineeDetailsResponse nomineeDetailsResponse, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i2, Object obj) {
        NomineeDetailsResponse nomineeDetailsResponse2 = nomineeDetailsResponse;
        int i3 = i2;
        return nomineeDetailsResponse.copy((i3 & 1) != 0 ? nomineeDetailsResponse2.isActive : z, (i3 & 2) != 0 ? nomineeDetailsResponse2.areaName : str, (i3 & 4) != 0 ? nomineeDetailsResponse2.city : str2, (i3 & 8) != 0 ? nomineeDetailsResponse2.custId : str3, (i3 & 16) != 0 ? nomineeDetailsResponse2.dob : str4, (i3 & 32) != 0 ? nomineeDetailsResponse2.email : str5, (i3 & 64) != 0 ? nomineeDetailsResponse2.houseNo : str6, (i3 & 128) != 0 ? nomineeDetailsResponse2.nomineeFinservId : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? nomineeDetailsResponse2.name : str8, (i3 & 512) != 0 ? nomineeDetailsResponse2.relationship : str9, (i3 & TarConstants.EOF_BLOCK) != 0 ? nomineeDetailsResponse2.latitude : str10, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? nomineeDetailsResponse2.longitude : str11, (i3 & 4096) != 0 ? nomineeDetailsResponse2.pinCode : str12, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? nomineeDetailsResponse2.state : str13, (i3 & 16384) != 0 ? nomineeDetailsResponse2.streetName : str14, (i3 & 32768) != 0 ? nomineeDetailsResponse2.oauthId : str15);
    }

    public final boolean component1() {
        return this.isActive;
    }

    public final String component10() {
        return this.relationship;
    }

    public final String component11() {
        return this.latitude;
    }

    public final String component12() {
        return this.longitude;
    }

    public final String component13() {
        return this.pinCode;
    }

    public final String component14() {
        return this.state;
    }

    public final String component15() {
        return this.streetName;
    }

    public final String component16() {
        return this.oauthId;
    }

    public final String component2() {
        return this.areaName;
    }

    public final String component3() {
        return this.city;
    }

    public final String component4() {
        return this.custId;
    }

    public final String component5() {
        return this.dob;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.houseNo;
    }

    public final String component8() {
        return this.nomineeFinservId;
    }

    public final String component9() {
        return this.name;
    }

    public final NomineeDetailsResponse copy(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        boolean z2 = z;
        k.c(str, "areaName");
        k.c(str2, "city");
        k.c(str3, "custId");
        k.c(str4, "dob");
        k.c(str5, AppConstants.KEY_EMAIL);
        k.c(str6, "houseNo");
        k.c(str7, "nomineeFinservId");
        k.c(str8, "name");
        k.c(str9, "relationship");
        k.c(str10, "latitude");
        k.c(str11, "longitude");
        k.c(str12, "pinCode");
        k.c(str13, "state");
        k.c(str14, "streetName");
        k.c(str15, "oauthId");
        return new NomineeDetailsResponse(z, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NomineeDetailsResponse) {
                NomineeDetailsResponse nomineeDetailsResponse = (NomineeDetailsResponse) obj;
                if (!(this.isActive == nomineeDetailsResponse.isActive) || !k.a((Object) this.areaName, (Object) nomineeDetailsResponse.areaName) || !k.a((Object) this.city, (Object) nomineeDetailsResponse.city) || !k.a((Object) this.custId, (Object) nomineeDetailsResponse.custId) || !k.a((Object) this.dob, (Object) nomineeDetailsResponse.dob) || !k.a((Object) this.email, (Object) nomineeDetailsResponse.email) || !k.a((Object) this.houseNo, (Object) nomineeDetailsResponse.houseNo) || !k.a((Object) this.nomineeFinservId, (Object) nomineeDetailsResponse.nomineeFinservId) || !k.a((Object) this.name, (Object) nomineeDetailsResponse.name) || !k.a((Object) this.relationship, (Object) nomineeDetailsResponse.relationship) || !k.a((Object) this.latitude, (Object) nomineeDetailsResponse.latitude) || !k.a((Object) this.longitude, (Object) nomineeDetailsResponse.longitude) || !k.a((Object) this.pinCode, (Object) nomineeDetailsResponse.pinCode) || !k.a((Object) this.state, (Object) nomineeDetailsResponse.state) || !k.a((Object) this.streetName, (Object) nomineeDetailsResponse.streetName) || !k.a((Object) this.oauthId, (Object) nomineeDetailsResponse.oauthId)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.isActive;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.areaName;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.city;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.custId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.dob;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.email;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.houseNo;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.nomineeFinservId;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.name;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.relationship;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.latitude;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.longitude;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.pinCode;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.state;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.streetName;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.oauthId;
        if (str15 != null) {
            i3 = str15.hashCode();
        }
        return hashCode14 + i3;
    }

    public final String toString() {
        return "NomineeDetailsResponse(isActive=" + this.isActive + ", areaName=" + this.areaName + ", city=" + this.city + ", custId=" + this.custId + ", dob=" + this.dob + ", email=" + this.email + ", houseNo=" + this.houseNo + ", nomineeFinservId=" + this.nomineeFinservId + ", name=" + this.name + ", relationship=" + this.relationship + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", pinCode=" + this.pinCode + ", state=" + this.state + ", streetName=" + this.streetName + ", oauthId=" + this.oauthId + ")";
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final String getAreaName() {
        return this.areaName;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCustId() {
        return this.custId;
    }

    public final String getDob() {
        return this.dob;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getHouseNo() {
        return this.houseNo;
    }

    public final String getNomineeFinservId() {
        return this.nomineeFinservId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRelationship() {
        return this.relationship;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final String getLongitude() {
        return this.longitude;
    }

    public final String getPinCode() {
        return this.pinCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getStreetName() {
        return this.streetName;
    }

    public NomineeDetailsResponse(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        String str16 = str;
        String str17 = str2;
        String str18 = str3;
        String str19 = str4;
        String str20 = str5;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str9;
        String str25 = str10;
        String str26 = str11;
        String str27 = str12;
        String str28 = str13;
        String str29 = str14;
        k.c(str16, "areaName");
        k.c(str17, "city");
        k.c(str18, "custId");
        k.c(str19, "dob");
        k.c(str20, AppConstants.KEY_EMAIL);
        k.c(str21, "houseNo");
        k.c(str22, "nomineeFinservId");
        k.c(str23, "name");
        k.c(str24, "relationship");
        k.c(str25, "latitude");
        k.c(str26, "longitude");
        k.c(str27, "pinCode");
        k.c(str28, "state");
        k.c(str29, "streetName");
        k.c(str15, "oauthId");
        this.isActive = z;
        this.areaName = str16;
        this.city = str17;
        this.custId = str18;
        this.dob = str19;
        this.email = str20;
        this.houseNo = str21;
        this.nomineeFinservId = str22;
        this.name = str23;
        this.relationship = str24;
        this.latitude = str25;
        this.longitude = str26;
        this.pinCode = str27;
        this.state = str28;
        this.streetName = str29;
        this.oauthId = str15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NomineeDetailsResponse(boolean r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, kotlin.g.b.g r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r18
        L_0x000a:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0012
            r2 = r3
            goto L_0x0014
        L_0x0012:
            r2 = r19
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r3
            goto L_0x001c
        L_0x001a:
            r4 = r20
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r3
            goto L_0x0024
        L_0x0022:
            r5 = r21
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r3
            goto L_0x002c
        L_0x002a:
            r6 = r22
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r3
            goto L_0x0034
        L_0x0032:
            r7 = r23
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = r3
            goto L_0x003c
        L_0x003a:
            r8 = r24
        L_0x003c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0042
            r9 = r3
            goto L_0x0044
        L_0x0042:
            r9 = r25
        L_0x0044:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004a
            r10 = r3
            goto L_0x004c
        L_0x004a:
            r10 = r26
        L_0x004c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0052
            r11 = r3
            goto L_0x0054
        L_0x0052:
            r11 = r27
        L_0x0054:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005a
            r12 = r3
            goto L_0x005c
        L_0x005a:
            r12 = r28
        L_0x005c:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0062
            r13 = r3
            goto L_0x0064
        L_0x0062:
            r13 = r29
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006a
            r14 = r3
            goto L_0x006c
        L_0x006a:
            r14 = r30
        L_0x006c:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0072
            r15 = r3
            goto L_0x0074
        L_0x0072:
            r15 = r31
        L_0x0074:
            r18 = r3
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x007d
            r3 = r18
            goto L_0x007f
        L_0x007d:
            r3 = r32
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0089
            r0 = r18
            goto L_0x008b
        L_0x0089:
            r0 = r33
        L_0x008b:
            r18 = r17
            r19 = r1
            r20 = r2
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r3
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.slfd.NomineeDetailsResponse.<init>(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getOauthId() {
        return this.oauthId;
    }
}
