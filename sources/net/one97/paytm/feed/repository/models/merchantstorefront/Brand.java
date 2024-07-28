package net.one97.paytm.feed.repository.models.merchantstorefront;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.share.Constants;
import kotlin.g.b.k;

public final class Brand implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String contractId;
    private final String deepLink;
    private final String logoUrl;
    private final String name;
    private String pid;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Brand(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new Brand[i2];
        }
    }

    public static /* synthetic */ Brand copy$default(Brand brand, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = brand.deepLink;
        }
        if ((i2 & 2) != 0) {
            str2 = brand.contractId;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = brand.logoUrl;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = brand.name;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = brand.pid;
        }
        return brand.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.deepLink;
    }

    public final String component2() {
        return this.contractId;
    }

    public final String component3() {
        return this.logoUrl;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.pid;
    }

    public final Brand copy(String str, String str2, String str3, String str4, String str5) {
        k.c(str, "deepLink");
        k.c(str2, "contractId");
        k.c(str3, "logoUrl");
        k.c(str4, "name");
        k.c(str5, Constants.URL_MEDIA_SOURCE);
        return new Brand(str, str2, str3, str4, str5);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Brand)) {
            return false;
        }
        Brand brand = (Brand) obj;
        return k.a((Object) this.deepLink, (Object) brand.deepLink) && k.a((Object) this.contractId, (Object) brand.contractId) && k.a((Object) this.logoUrl, (Object) brand.logoUrl) && k.a((Object) this.name, (Object) brand.name) && k.a((Object) this.pid, (Object) brand.pid);
    }

    public final int hashCode() {
        String str = this.deepLink;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contractId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.logoUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.pid;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "Brand(deepLink=" + this.deepLink + ", contractId=" + this.contractId + ", logoUrl=" + this.logoUrl + ", name=" + this.name + ", pid=" + this.pid + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.deepLink);
        parcel.writeString(this.contractId);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.pid);
    }

    public Brand(String str, String str2, String str3, String str4, String str5) {
        k.c(str, "deepLink");
        k.c(str2, "contractId");
        k.c(str3, "logoUrl");
        k.c(str4, "name");
        k.c(str5, Constants.URL_MEDIA_SOURCE);
        this.deepLink = str;
        this.contractId = str2;
        this.logoUrl = str3;
        this.name = str4;
        this.pid = str5;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final String getContractId() {
        return this.contractId;
    }

    public final void setContractId(String str) {
        k.c(str, "<set-?>");
        this.contractId = str;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPid() {
        return this.pid;
    }

    public final void setPid(String str) {
        k.c(str, "<set-?>");
        this.pid = str;
    }
}
