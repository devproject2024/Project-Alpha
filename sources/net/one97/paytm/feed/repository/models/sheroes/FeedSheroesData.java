package net.one97.paytm.feed.repository.models.sheroes;

import android.os.Parcel;
import android.os.Parcelable;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedSheroesData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String deepLinkUrl;
    private final String height;
    private final String imageUrl;
    private final Boolean isSensitive;
    private final String width;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            k.c(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new FeedSheroesData(readString, readString2, bool, parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedSheroesData[i2];
        }
    }

    public static /* synthetic */ FeedSheroesData copy$default(FeedSheroesData feedSheroesData, String str, String str2, Boolean bool, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedSheroesData.deepLinkUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = feedSheroesData.imageUrl;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            bool = feedSheroesData.isSensitive;
        }
        Boolean bool2 = bool;
        if ((i2 & 8) != 0) {
            str3 = feedSheroesData.height;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = feedSheroesData.width;
        }
        return feedSheroesData.copy(str, str5, bool2, str6, str4);
    }

    public final String component1() {
        return this.deepLinkUrl;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final Boolean component3() {
        return this.isSensitive;
    }

    public final String component4() {
        return this.height;
    }

    public final String component5() {
        return this.width;
    }

    public final FeedSheroesData copy(String str, String str2, Boolean bool, String str3, String str4) {
        k.c(str2, "imageUrl");
        k.c(str3, StringSet.height);
        k.c(str4, StringSet.width);
        return new FeedSheroesData(str, str2, bool, str3, str4);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedSheroesData)) {
            return false;
        }
        FeedSheroesData feedSheroesData = (FeedSheroesData) obj;
        return k.a((Object) this.deepLinkUrl, (Object) feedSheroesData.deepLinkUrl) && k.a((Object) this.imageUrl, (Object) feedSheroesData.imageUrl) && k.a((Object) this.isSensitive, (Object) feedSheroesData.isSensitive) && k.a((Object) this.height, (Object) feedSheroesData.height) && k.a((Object) this.width, (Object) feedSheroesData.width);
    }

    public final int hashCode() {
        String str = this.deepLinkUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.isSensitive;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str3 = this.height;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.width;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "FeedSheroesData(deepLinkUrl=" + this.deepLinkUrl + ", imageUrl=" + this.imageUrl + ", isSensitive=" + this.isSensitive + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        boolean z;
        k.c(parcel, "parcel");
        parcel.writeString(this.deepLinkUrl);
        parcel.writeString(this.imageUrl);
        Boolean bool = this.isSensitive;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        parcel.writeInt(z ? 1 : 0);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
    }

    public FeedSheroesData(String str, String str2, Boolean bool, String str3, String str4) {
        k.c(str2, "imageUrl");
        k.c(str3, StringSet.height);
        k.c(str4, StringSet.width);
        this.deepLinkUrl = str;
        this.imageUrl = str2;
        this.isSensitive = bool;
        this.height = str3;
        this.width = str4;
    }

    public final String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Boolean isSensitive() {
        return this.isSensitive;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getWidth() {
        return this.width;
    }
}
