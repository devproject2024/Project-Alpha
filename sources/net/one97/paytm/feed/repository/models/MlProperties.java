package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class MlProperties implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String buckets;
    private String contentFormat;
    private String mlCategory;
    private String mlVersion;
    private Double score;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new MlProperties(parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new MlProperties[i2];
        }
    }

    public static /* synthetic */ MlProperties copy$default(MlProperties mlProperties, Double d2, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = mlProperties.score;
        }
        if ((i2 & 2) != 0) {
            str = mlProperties.buckets;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = mlProperties.contentFormat;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = mlProperties.mlVersion;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = mlProperties.mlCategory;
        }
        return mlProperties.copy(d2, str5, str6, str7, str4);
    }

    public final Double component1() {
        return this.score;
    }

    public final String component2() {
        return this.buckets;
    }

    public final String component3() {
        return this.contentFormat;
    }

    public final String component4() {
        return this.mlVersion;
    }

    public final String component5() {
        return this.mlCategory;
    }

    public final MlProperties copy(Double d2, String str, String str2, String str3, String str4) {
        return new MlProperties(d2, str, str2, str3, str4);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MlProperties)) {
            return false;
        }
        MlProperties mlProperties = (MlProperties) obj;
        return k.a((Object) this.score, (Object) mlProperties.score) && k.a((Object) this.buckets, (Object) mlProperties.buckets) && k.a((Object) this.contentFormat, (Object) mlProperties.contentFormat) && k.a((Object) this.mlVersion, (Object) mlProperties.mlVersion) && k.a((Object) this.mlCategory, (Object) mlProperties.mlCategory);
    }

    public final int hashCode() {
        Double d2 = this.score;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        String str = this.buckets;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.contentFormat;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mlVersion;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mlCategory;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "MlProperties(score=" + this.score + ", buckets=" + this.buckets + ", contentFormat=" + this.contentFormat + ", mlVersion=" + this.mlVersion + ", mlCategory=" + this.mlCategory + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        Double d2 = this.score;
        if (d2 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.buckets);
        parcel.writeString(this.contentFormat);
        parcel.writeString(this.mlVersion);
        parcel.writeString(this.mlCategory);
    }

    public MlProperties(Double d2, String str, String str2, String str3, String str4) {
        this.score = d2;
        this.buckets = str;
        this.contentFormat = str2;
        this.mlVersion = str3;
        this.mlCategory = str4;
    }

    public final Double getScore() {
        return this.score;
    }

    public final void setScore(Double d2) {
        this.score = d2;
    }

    public final String getBuckets() {
        return this.buckets;
    }

    public final void setBuckets(String str) {
        this.buckets = str;
    }

    public final String getContentFormat() {
        return this.contentFormat;
    }

    public final void setContentFormat(String str) {
        this.contentFormat = str;
    }

    public final String getMlVersion() {
        return this.mlVersion;
    }

    public final void setMlVersion(String str) {
        this.mlVersion = str;
    }

    public final String getMlCategory() {
        return this.mlCategory;
    }

    public final void setMlCategory(String str) {
        this.mlCategory = str;
    }
}
