package net.one97.paytm.feed.repository.models.provider;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class ProviderData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String bannerImageUrl;
    private final long followerCount;
    private final String followerCountDisplay;
    private final int id;
    private final String imageUrl;
    private final String name;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new ProviderData(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new ProviderData[i2];
        }
    }

    public static /* synthetic */ ProviderData copy$default(ProviderData providerData, int i2, String str, String str2, String str3, long j, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = providerData.id;
        }
        if ((i3 & 2) != 0) {
            str = providerData.name;
        }
        String str5 = str;
        if ((i3 & 4) != 0) {
            str2 = providerData.imageUrl;
        }
        String str6 = str2;
        if ((i3 & 8) != 0) {
            str3 = providerData.bannerImageUrl;
        }
        String str7 = str3;
        if ((i3 & 16) != 0) {
            j = providerData.followerCount;
        }
        long j2 = j;
        if ((i3 & 32) != 0) {
            str4 = providerData.followerCountDisplay;
        }
        return providerData.copy(i2, str5, str6, str7, j2, str4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final String component4() {
        return this.bannerImageUrl;
    }

    public final long component5() {
        return this.followerCount;
    }

    public final String component6() {
        return this.followerCountDisplay;
    }

    public final ProviderData copy(int i2, String str, String str2, String str3, long j, String str4) {
        k.c(str, "name");
        k.c(str2, "imageUrl");
        k.c(str3, "bannerImageUrl");
        String str5 = str4;
        k.c(str5, "followerCountDisplay");
        return new ProviderData(i2, str, str2, str3, j, str5);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ProviderData) {
                ProviderData providerData = (ProviderData) obj;
                if ((this.id == providerData.id) && k.a((Object) this.name, (Object) providerData.name) && k.a((Object) this.imageUrl, (Object) providerData.imageUrl) && k.a((Object) this.bannerImageUrl, (Object) providerData.bannerImageUrl)) {
                    if (!(this.followerCount == providerData.followerCount) || !k.a((Object) this.followerCountDisplay, (Object) providerData.followerCountDisplay)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.id).hashCode() * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.imageUrl;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bannerImageUrl;
        int hashCode4 = (((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.valueOf(this.followerCount).hashCode()) * 31;
        String str4 = this.followerCountDisplay;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "ProviderData(id=" + this.id + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ", bannerImageUrl=" + this.bannerImageUrl + ", followerCount=" + this.followerCount + ", followerCountDisplay=" + this.followerCountDisplay + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.bannerImageUrl);
        parcel.writeLong(this.followerCount);
        parcel.writeString(this.followerCountDisplay);
    }

    public ProviderData(int i2, String str, String str2, String str3, long j, String str4) {
        k.c(str, "name");
        k.c(str2, "imageUrl");
        k.c(str3, "bannerImageUrl");
        k.c(str4, "followerCountDisplay");
        this.id = i2;
        this.name = str;
        this.imageUrl = str2;
        this.bannerImageUrl = str3;
        this.followerCount = j;
        this.followerCountDisplay = str4;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getBannerImageUrl() {
        return this.bannerImageUrl;
    }

    public final long getFollowerCount() {
        return this.followerCount;
    }

    public final String getFollowerCountDisplay() {
        return this.followerCountDisplay;
    }
}
