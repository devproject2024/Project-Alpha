package net.one97.paytm.feed.repository.models.trending;

import android.os.Parcel;
import android.os.Parcelable;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class Trending implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String deepLink;
    private final String description;
    private final String height;
    private String id;
    private final String imageUrl;
    private final String streamUrl;
    private String tid;
    private final String title;
    private final String webUrl;
    private final String width;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Trending(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new Trending[i2];
        }
    }

    public static /* synthetic */ Trending copy$default(Trending trending, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, Object obj) {
        Trending trending2 = trending;
        int i3 = i2;
        return trending.copy((i3 & 1) != 0 ? trending2.id : str, (i3 & 2) != 0 ? trending2.tid : str2, (i3 & 4) != 0 ? trending2.title : str3, (i3 & 8) != 0 ? trending2.description : str4, (i3 & 16) != 0 ? trending2.deepLink : str5, (i3 & 32) != 0 ? trending2.imageUrl : str6, (i3 & 64) != 0 ? trending2.webUrl : str7, (i3 & 128) != 0 ? trending2.streamUrl : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? trending2.height : str9, (i3 & 512) != 0 ? trending2.width : str10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.width;
    }

    public final String component2() {
        return this.tid;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.deepLink;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.webUrl;
    }

    public final String component8() {
        return this.streamUrl;
    }

    public final String component9() {
        return this.height;
    }

    public final Trending copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        k.c(str, "id");
        k.c(str3, "title");
        String str11 = str6;
        k.c(str11, "imageUrl");
        String str12 = str9;
        k.c(str12, StringSet.height);
        String str13 = str10;
        k.c(str13, StringSet.width);
        return new Trending(str, str2, str3, str4, str5, str11, str7, str8, str12, str13);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trending)) {
            return false;
        }
        Trending trending = (Trending) obj;
        return k.a((Object) this.id, (Object) trending.id) && k.a((Object) this.tid, (Object) trending.tid) && k.a((Object) this.title, (Object) trending.title) && k.a((Object) this.description, (Object) trending.description) && k.a((Object) this.deepLink, (Object) trending.deepLink) && k.a((Object) this.imageUrl, (Object) trending.imageUrl) && k.a((Object) this.webUrl, (Object) trending.webUrl) && k.a((Object) this.streamUrl, (Object) trending.streamUrl) && k.a((Object) this.height, (Object) trending.height) && k.a((Object) this.width, (Object) trending.width);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.deepLink;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.imageUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.webUrl;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.streamUrl;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.height;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.width;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "Trending(id=" + this.id + ", tid=" + this.tid + ", title=" + this.title + ", description=" + this.description + ", deepLink=" + this.deepLink + ", imageUrl=" + this.imageUrl + ", webUrl=" + this.webUrl + ", streamUrl=" + this.streamUrl + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.tid);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.deepLink);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.webUrl);
        parcel.writeString(this.streamUrl);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
    }

    public Trending(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        k.c(str, "id");
        k.c(str3, "title");
        k.c(str6, "imageUrl");
        k.c(str9, StringSet.height);
        k.c(str10, StringSet.width);
        this.id = str;
        this.tid = str2;
        this.title = str3;
        this.description = str4;
        this.deepLink = str5;
        this.imageUrl = str6;
        this.webUrl = str7;
        this.streamUrl = str8;
        this.height = str9;
        this.width = str10;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final String getTid() {
        return this.tid;
    }

    public final void setTid(String str) {
        this.tid = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
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

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getWidth() {
        return this.width;
    }
}
