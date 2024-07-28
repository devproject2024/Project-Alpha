package com.business.merchant_payments.model.user;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class DefaultInfo {
    public final String countryCode;
    public final String customerCreationDate;
    public final String customerStatus;
    public final String displayName;
    public final boolean emailNotificationEnabled;
    public final boolean emailVerificationStatus;
    public final String firstName;
    public final String gender;
    public final boolean isKyc;
    public final String lastName;
    public final String phone;
    public final boolean phoneVerificationStatus;
    public final String userPicture;

    public static /* synthetic */ DefaultInfo copy$default(DefaultInfo defaultInfo, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, boolean z3, String str7, String str8, boolean z4, String str9, int i2, Object obj) {
        DefaultInfo defaultInfo2 = defaultInfo;
        int i3 = i2;
        return defaultInfo.copy((i3 & 1) != 0 ? defaultInfo2.countryCode : str, (i3 & 2) != 0 ? defaultInfo2.customerCreationDate : str2, (i3 & 4) != 0 ? defaultInfo2.customerStatus : str3, (i3 & 8) != 0 ? defaultInfo2.displayName : str4, (i3 & 16) != 0 ? defaultInfo2.emailNotificationEnabled : z, (i3 & 32) != 0 ? defaultInfo2.emailVerificationStatus : z2, (i3 & 64) != 0 ? defaultInfo2.firstName : str5, (i3 & 128) != 0 ? defaultInfo2.gender : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? defaultInfo2.isKyc : z3, (i3 & 512) != 0 ? defaultInfo2.lastName : str7, (i3 & TarConstants.EOF_BLOCK) != 0 ? defaultInfo2.phone : str8, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? defaultInfo2.phoneVerificationStatus : z4, (i3 & 4096) != 0 ? defaultInfo2.userPicture : str9);
    }

    public final String component1() {
        return this.countryCode;
    }

    public final String component10() {
        return this.lastName;
    }

    public final String component11() {
        return this.phone;
    }

    public final boolean component12() {
        return this.phoneVerificationStatus;
    }

    public final String component13() {
        return this.userPicture;
    }

    public final String component2() {
        return this.customerCreationDate;
    }

    public final String component3() {
        return this.customerStatus;
    }

    public final String component4() {
        return this.displayName;
    }

    public final boolean component5() {
        return this.emailNotificationEnabled;
    }

    public final boolean component6() {
        return this.emailVerificationStatus;
    }

    public final String component7() {
        return this.firstName;
    }

    public final String component8() {
        return this.gender;
    }

    public final boolean component9() {
        return this.isKyc;
    }

    public final DefaultInfo copy(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, boolean z3, String str7, String str8, boolean z4, String str9) {
        String str10 = str;
        k.d(str10, "countryCode");
        String str11 = str2;
        k.d(str11, "customerCreationDate");
        String str12 = str3;
        k.d(str12, "customerStatus");
        String str13 = str4;
        k.d(str13, "displayName");
        String str14 = str5;
        k.d(str14, "firstName");
        String str15 = str6;
        k.d(str15, "gender");
        String str16 = str7;
        k.d(str16, "lastName");
        String str17 = str8;
        k.d(str17, ContactColumn.PHONE_NUMBER);
        String str18 = str9;
        k.d(str18, "userPicture");
        return new DefaultInfo(str10, str11, str12, str13, z, z2, str14, str15, z3, str16, str17, z4, str18);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultInfo)) {
            return false;
        }
        DefaultInfo defaultInfo = (DefaultInfo) obj;
        return k.a((Object) this.countryCode, (Object) defaultInfo.countryCode) && k.a((Object) this.customerCreationDate, (Object) defaultInfo.customerCreationDate) && k.a((Object) this.customerStatus, (Object) defaultInfo.customerStatus) && k.a((Object) this.displayName, (Object) defaultInfo.displayName) && this.emailNotificationEnabled == defaultInfo.emailNotificationEnabled && this.emailVerificationStatus == defaultInfo.emailVerificationStatus && k.a((Object) this.firstName, (Object) defaultInfo.firstName) && k.a((Object) this.gender, (Object) defaultInfo.gender) && this.isKyc == defaultInfo.isKyc && k.a((Object) this.lastName, (Object) defaultInfo.lastName) && k.a((Object) this.phone, (Object) defaultInfo.phone) && this.phoneVerificationStatus == defaultInfo.phoneVerificationStatus && k.a((Object) this.userPicture, (Object) defaultInfo.userPicture);
    }

    public final int hashCode() {
        String str = this.countryCode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.customerCreationDate;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.customerStatus;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.displayName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.emailNotificationEnabled;
        if (z) {
            z = true;
        }
        int i3 = (hashCode4 + (z ? 1 : 0)) * 31;
        boolean z2 = this.emailVerificationStatus;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        String str5 = this.firstName;
        int hashCode5 = (i4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.gender;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z3 = this.isKyc;
        if (z3) {
            z3 = true;
        }
        int i5 = (hashCode6 + (z3 ? 1 : 0)) * 31;
        String str7 = this.lastName;
        int hashCode7 = (i5 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.phone;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z4 = this.phoneVerificationStatus;
        if (z4) {
            z4 = true;
        }
        int i6 = (hashCode8 + (z4 ? 1 : 0)) * 31;
        String str9 = this.userPicture;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return i6 + i2;
    }

    public final String toString() {
        return "DefaultInfo(countryCode=" + this.countryCode + ", customerCreationDate=" + this.customerCreationDate + ", customerStatus=" + this.customerStatus + ", displayName=" + this.displayName + ", emailNotificationEnabled=" + this.emailNotificationEnabled + ", emailVerificationStatus=" + this.emailVerificationStatus + ", firstName=" + this.firstName + ", gender=" + this.gender + ", isKyc=" + this.isKyc + ", lastName=" + this.lastName + ", phone=" + this.phone + ", phoneVerificationStatus=" + this.phoneVerificationStatus + ", userPicture=" + this.userPicture + ")";
    }

    public DefaultInfo(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, boolean z3, String str7, String str8, boolean z4, String str9) {
        k.d(str, "countryCode");
        k.d(str2, "customerCreationDate");
        k.d(str3, "customerStatus");
        k.d(str4, "displayName");
        k.d(str5, "firstName");
        k.d(str6, "gender");
        k.d(str7, "lastName");
        k.d(str8, ContactColumn.PHONE_NUMBER);
        k.d(str9, "userPicture");
        this.countryCode = str;
        this.customerCreationDate = str2;
        this.customerStatus = str3;
        this.displayName = str4;
        this.emailNotificationEnabled = z;
        this.emailVerificationStatus = z2;
        this.firstName = str5;
        this.gender = str6;
        this.isKyc = z3;
        this.lastName = str7;
        this.phone = str8;
        this.phoneVerificationStatus = z4;
        this.userPicture = str9;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getCustomerCreationDate() {
        return this.customerCreationDate;
    }

    public final String getCustomerStatus() {
        return this.customerStatus;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean getEmailNotificationEnabled() {
        return this.emailNotificationEnabled;
    }

    public final boolean getEmailVerificationStatus() {
        return this.emailVerificationStatus;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getGender() {
        return this.gender;
    }

    public final boolean isKyc() {
        return this.isKyc;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final boolean getPhoneVerificationStatus() {
        return this.phoneVerificationStatus;
    }

    public final String getUserPicture() {
        return this.userPicture;
    }
}
