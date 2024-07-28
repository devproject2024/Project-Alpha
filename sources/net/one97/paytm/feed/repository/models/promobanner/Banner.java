package net.one97.paytm.feed.repository.models.promobanner;

import android.os.Parcel;
import android.os.Parcelable;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class Banner implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String bid;
    private final String deepLink;
    private final String height;
    private String id;
    private final String imageUrl;
    private final String webUrl;
    private final String width;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Banner(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new Banner[i2];
        }
    }

    public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = banner.id;
        }
        if ((i2 & 2) != 0) {
            str2 = banner.bid;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = banner.deepLink;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = banner.imageUrl;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = banner.webUrl;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = banner.height;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = banner.width;
        }
        return banner.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.bid;
    }

    public final String component3() {
        return this.deepLink;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final String component5() {
        return this.webUrl;
    }

    public final String component6() {
        return this.height;
    }

    public final String component7() {
        return this.width;
    }

    public final Banner copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(str, "id");
        k.c(str4, "imageUrl");
        k.c(str6, StringSet.height);
        String str8 = str7;
        k.c(str8, StringSet.width);
        return new Banner(str, str2, str3, str4, str5, str6, str8);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Banner)) {
            return false;
        }
        Banner banner = (Banner) obj;
        return k.a((Object) this.id, (Object) banner.id) && k.a((Object) this.bid, (Object) banner.bid) && k.a((Object) this.deepLink, (Object) banner.deepLink) && k.a((Object) this.imageUrl, (Object) banner.imageUrl) && k.a((Object) this.webUrl, (Object) banner.webUrl) && k.a((Object) this.height, (Object) banner.height) && k.a((Object) this.width, (Object) banner.width);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.deepLink;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imageUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.webUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.height;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.width;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "Banner(id=" + this.id + ", bid=" + this.bid + ", deepLink=" + this.deepLink + ", imageUrl=" + this.imageUrl + ", webUrl=" + this.webUrl + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.bid);
        parcel.writeString(this.deepLink);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.webUrl);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
    }

    public Banner(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(str, "id");
        k.c(str4, "imageUrl");
        k.c(str6, StringSet.height);
        k.c(str7, StringSet.width);
        this.id = str;
        this.bid = str2;
        this.deepLink = str3;
        this.imageUrl = str4;
        this.webUrl = str5;
        this.height = str6;
        this.width = str7;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        this.bid = str;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getWidth() {
        return this.width;
    }
}
