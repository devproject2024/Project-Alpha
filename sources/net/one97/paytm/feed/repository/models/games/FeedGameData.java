package net.one97.paytm.feed.repository.models.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedGameData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String deepLinkUrl;
    private final String height;
    private final String imageUrl;
    private final boolean isSensitive;
    private final String width;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedGameData(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedGameData[i2];
        }
    }

    public static /* synthetic */ FeedGameData copy$default(FeedGameData feedGameData, String str, String str2, boolean z, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedGameData.deepLinkUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = feedGameData.imageUrl;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            z = feedGameData.isSensitive;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str3 = feedGameData.height;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = feedGameData.width;
        }
        return feedGameData.copy(str, str5, z2, str6, str4);
    }

    public final String component1() {
        return this.deepLinkUrl;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final boolean component3() {
        return this.isSensitive;
    }

    public final String component4() {
        return this.height;
    }

    public final String component5() {
        return this.width;
    }

    public final FeedGameData copy(String str, String str2, boolean z, String str3, String str4) {
        k.c(str2, "imageUrl");
        k.c(str3, StringSet.height);
        k.c(str4, StringSet.width);
        return new FeedGameData(str, str2, z, str3, str4);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedGameData) {
                FeedGameData feedGameData = (FeedGameData) obj;
                if (k.a((Object) this.deepLinkUrl, (Object) feedGameData.deepLinkUrl) && k.a((Object) this.imageUrl, (Object) feedGameData.imageUrl)) {
                    if (!(this.isSensitive == feedGameData.isSensitive) || !k.a((Object) this.height, (Object) feedGameData.height) || !k.a((Object) this.width, (Object) feedGameData.width)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.deepLinkUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isSensitive;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str3 = this.height;
        int hashCode3 = (i3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.width;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "FeedGameData(deepLinkUrl=" + this.deepLinkUrl + ", imageUrl=" + this.imageUrl + ", isSensitive=" + this.isSensitive + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.deepLinkUrl);
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.isSensitive ? 1 : 0);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
    }

    public FeedGameData(String str, String str2, boolean z, String str3, String str4) {
        k.c(str2, "imageUrl");
        k.c(str3, StringSet.height);
        k.c(str4, StringSet.width);
        this.deepLinkUrl = str;
        this.imageUrl = str2;
        this.isSensitive = z;
        this.height = str3;
        this.width = str4;
    }

    public final String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean isSensitive() {
        return this.isSensitive;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getWidth() {
        return this.width;
    }
}
