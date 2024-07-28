package com.business.merchant_payments.notificationsettings.model;

import kotlin.g.b.k;

public final class ReceiverInfoDataModel {
    public final String additionalMobile;
    public final String primaryEmail;
    public final String primaryMobile;
    public final String secondaryEmail;
    public final String secondaryMobile;

    public static /* synthetic */ ReceiverInfoDataModel copy$default(ReceiverInfoDataModel receiverInfoDataModel, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = receiverInfoDataModel.primaryMobile;
        }
        if ((i2 & 2) != 0) {
            str2 = receiverInfoDataModel.secondaryMobile;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = receiverInfoDataModel.additionalMobile;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = receiverInfoDataModel.primaryEmail;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = receiverInfoDataModel.secondaryEmail;
        }
        return receiverInfoDataModel.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.primaryMobile;
    }

    public final String component2() {
        return this.secondaryMobile;
    }

    public final String component3() {
        return this.additionalMobile;
    }

    public final String component4() {
        return this.primaryEmail;
    }

    public final String component5() {
        return this.secondaryEmail;
    }

    public final ReceiverInfoDataModel copy(String str, String str2, String str3, String str4, String str5) {
        k.d(str, "primaryMobile");
        k.d(str2, "secondaryMobile");
        k.d(str3, "additionalMobile");
        k.d(str4, "primaryEmail");
        k.d(str5, "secondaryEmail");
        return new ReceiverInfoDataModel(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReceiverInfoDataModel)) {
            return false;
        }
        ReceiverInfoDataModel receiverInfoDataModel = (ReceiverInfoDataModel) obj;
        return k.a((Object) this.primaryMobile, (Object) receiverInfoDataModel.primaryMobile) && k.a((Object) this.secondaryMobile, (Object) receiverInfoDataModel.secondaryMobile) && k.a((Object) this.additionalMobile, (Object) receiverInfoDataModel.additionalMobile) && k.a((Object) this.primaryEmail, (Object) receiverInfoDataModel.primaryEmail) && k.a((Object) this.secondaryEmail, (Object) receiverInfoDataModel.secondaryEmail);
    }

    public final int hashCode() {
        String str = this.primaryMobile;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.secondaryMobile;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.additionalMobile;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.primaryEmail;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.secondaryEmail;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "ReceiverInfoDataModel(primaryMobile=" + this.primaryMobile + ", secondaryMobile=" + this.secondaryMobile + ", additionalMobile=" + this.additionalMobile + ", primaryEmail=" + this.primaryEmail + ", secondaryEmail=" + this.secondaryEmail + ")";
    }

    public ReceiverInfoDataModel(String str, String str2, String str3, String str4, String str5) {
        k.d(str, "primaryMobile");
        k.d(str2, "secondaryMobile");
        k.d(str3, "additionalMobile");
        k.d(str4, "primaryEmail");
        k.d(str5, "secondaryEmail");
        this.primaryMobile = str;
        this.secondaryMobile = str2;
        this.additionalMobile = str3;
        this.primaryEmail = str4;
        this.secondaryEmail = str5;
    }

    public final String getPrimaryMobile() {
        return this.primaryMobile;
    }

    public final String getSecondaryMobile() {
        return this.secondaryMobile;
    }

    public final String getAdditionalMobile() {
        return this.additionalMobile;
    }

    public final String getPrimaryEmail() {
        return this.primaryEmail;
    }

    public final String getSecondaryEmail() {
        return this.secondaryEmail;
    }
}
