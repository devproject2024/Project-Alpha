package com.paytm.android.chat.bean.jsonbean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class KycInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String kycNameKey;
    private String kycNameValue;
    private String verifiedIconUrl;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new KycInfo(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new KycInfo[i2];
        }
    }

    public KycInfo() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ KycInfo copy$default(KycInfo kycInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kycInfo.kycNameKey;
        }
        if ((i2 & 2) != 0) {
            str2 = kycInfo.kycNameValue;
        }
        if ((i2 & 4) != 0) {
            str3 = kycInfo.verifiedIconUrl;
        }
        return kycInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.kycNameKey;
    }

    public final String component2() {
        return this.kycNameValue;
    }

    public final String component3() {
        return this.verifiedIconUrl;
    }

    public final KycInfo copy(String str, String str2, String str3) {
        return new KycInfo(str, str2, str3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KycInfo)) {
            return false;
        }
        KycInfo kycInfo = (KycInfo) obj;
        return k.a((Object) this.kycNameKey, (Object) kycInfo.kycNameKey) && k.a((Object) this.kycNameValue, (Object) kycInfo.kycNameValue) && k.a((Object) this.verifiedIconUrl, (Object) kycInfo.verifiedIconUrl);
    }

    public final int hashCode() {
        String str = this.kycNameKey;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.kycNameValue;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.verifiedIconUrl;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "KycInfo(kycNameKey=" + this.kycNameKey + ", kycNameValue=" + this.kycNameValue + ", verifiedIconUrl=" + this.verifiedIconUrl + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.kycNameKey);
        parcel.writeString(this.kycNameValue);
        parcel.writeString(this.verifiedIconUrl);
    }

    public KycInfo(String str, String str2, String str3) {
        this.kycNameKey = str;
        this.kycNameValue = str2;
        this.verifiedIconUrl = str3;
    }

    public final String getKycNameKey() {
        return this.kycNameKey;
    }

    public final void setKycNameKey(String str) {
        this.kycNameKey = str;
    }

    public final String getKycNameValue() {
        return this.kycNameValue;
    }

    public final void setKycNameValue(String str) {
        this.kycNameValue = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KycInfo(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getVerifiedIconUrl() {
        return this.verifiedIconUrl;
    }

    public final void setVerifiedIconUrl(String str) {
        this.verifiedIconUrl = str;
    }
}
