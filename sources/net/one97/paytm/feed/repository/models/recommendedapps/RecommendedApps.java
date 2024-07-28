package net.one97.paytm.feed.repository.models.recommendedapps;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class RecommendedApps implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String appSize;
    private final String bgColor;
    private final String category;
    private final String description;
    private final String downloads;
    private String id;
    private final String imageUrl;
    private final String packageName;
    private final String rating;
    private String rid;
    private final String title;
    private final String type;
    private final String url;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new RecommendedApps(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new RecommendedApps[i2];
        }
    }

    public static /* synthetic */ RecommendedApps copy$default(RecommendedApps recommendedApps, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2, Object obj) {
        RecommendedApps recommendedApps2 = recommendedApps;
        int i3 = i2;
        return recommendedApps.copy((i3 & 1) != 0 ? recommendedApps2.id : str, (i3 & 2) != 0 ? recommendedApps2.rid : str2, (i3 & 4) != 0 ? recommendedApps2.bgColor : str3, (i3 & 8) != 0 ? recommendedApps2.description : str4, (i3 & 16) != 0 ? recommendedApps2.downloads : str5, (i3 & 32) != 0 ? recommendedApps2.imageUrl : str6, (i3 & 64) != 0 ? recommendedApps2.rating : str7, (i3 & 128) != 0 ? recommendedApps2.title : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? recommendedApps2.packageName : str9, (i3 & 512) != 0 ? recommendedApps2.category : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? recommendedApps2.appSize : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? recommendedApps2.type : str12, (i3 & 4096) != 0 ? recommendedApps2.url : str13);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.category;
    }

    public final String component11() {
        return this.appSize;
    }

    public final String component12() {
        return this.type;
    }

    public final String component13() {
        return this.url;
    }

    public final String component2() {
        return this.rid;
    }

    public final String component3() {
        return this.bgColor;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.downloads;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.rating;
    }

    public final String component8() {
        return this.title;
    }

    public final String component9() {
        return this.packageName;
    }

    public final RecommendedApps copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        String str14 = str;
        k.c(str14, "id");
        String str15 = str6;
        k.c(str15, "imageUrl");
        String str16 = str8;
        k.c(str16, "title");
        String str17 = str12;
        k.c(str17, "type");
        String str18 = str13;
        k.c(str18, "url");
        return new RecommendedApps(str14, str2, str3, str4, str5, str15, str7, str16, str9, str10, str11, str17, str18);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendedApps)) {
            return false;
        }
        RecommendedApps recommendedApps = (RecommendedApps) obj;
        return k.a((Object) this.id, (Object) recommendedApps.id) && k.a((Object) this.rid, (Object) recommendedApps.rid) && k.a((Object) this.bgColor, (Object) recommendedApps.bgColor) && k.a((Object) this.description, (Object) recommendedApps.description) && k.a((Object) this.downloads, (Object) recommendedApps.downloads) && k.a((Object) this.imageUrl, (Object) recommendedApps.imageUrl) && k.a((Object) this.rating, (Object) recommendedApps.rating) && k.a((Object) this.title, (Object) recommendedApps.title) && k.a((Object) this.packageName, (Object) recommendedApps.packageName) && k.a((Object) this.category, (Object) recommendedApps.category) && k.a((Object) this.appSize, (Object) recommendedApps.appSize) && k.a((Object) this.type, (Object) recommendedApps.type) && k.a((Object) this.url, (Object) recommendedApps.url);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.rid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bgColor;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.downloads;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.imageUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.rating;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.title;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.packageName;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.category;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.appSize;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.type;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.url;
        if (str13 != null) {
            i2 = str13.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "RecommendedApps(id=" + this.id + ", rid=" + this.rid + ", bgColor=" + this.bgColor + ", description=" + this.description + ", downloads=" + this.downloads + ", imageUrl=" + this.imageUrl + ", rating=" + this.rating + ", title=" + this.title + ", packageName=" + this.packageName + ", category=" + this.category + ", appSize=" + this.appSize + ", type=" + this.type + ", url=" + this.url + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.rid);
        parcel.writeString(this.bgColor);
        parcel.writeString(this.description);
        parcel.writeString(this.downloads);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.rating);
        parcel.writeString(this.title);
        parcel.writeString(this.packageName);
        parcel.writeString(this.category);
        parcel.writeString(this.appSize);
        parcel.writeString(this.type);
        parcel.writeString(this.url);
    }

    public RecommendedApps(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        k.c(str, "id");
        k.c(str6, "imageUrl");
        k.c(str8, "title");
        k.c(str12, "type");
        k.c(str13, "url");
        this.id = str;
        this.rid = str2;
        this.bgColor = str3;
        this.description = str4;
        this.downloads = str5;
        this.imageUrl = str6;
        this.rating = str7;
        this.title = str8;
        this.packageName = str9;
        this.category = str10;
        this.appSize = str11;
        this.type = str12;
        this.url = str13;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final String getRid() {
        return this.rid;
    }

    public final void setRid(String str) {
        this.rid = str;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDownloads() {
        return this.downloads;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getRating() {
        return this.rating;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getAppSize() {
        return this.appSize;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }
}
