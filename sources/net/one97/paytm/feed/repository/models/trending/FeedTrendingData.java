package net.one97.paytm.feed.repository.models.trending;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedTrendingData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String logoUrl;
    private final String title;
    @c(a = "cards")
    private final List<Trending> trending;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Trending) Trending.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new FeedTrendingData(readString, readString2, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new FeedTrendingData[i2];
        }
    }

    public static /* synthetic */ FeedTrendingData copy$default(FeedTrendingData feedTrendingData, String str, String str2, List<Trending> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedTrendingData.title;
        }
        if ((i2 & 2) != 0) {
            str2 = feedTrendingData.logoUrl;
        }
        if ((i2 & 4) != 0) {
            list = feedTrendingData.trending;
        }
        return feedTrendingData.copy(str, str2, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.logoUrl;
    }

    public final List<Trending> component3() {
        return this.trending;
    }

    public final FeedTrendingData copy(String str, String str2, List<Trending> list) {
        k.c(str, "title");
        k.c(str2, "logoUrl");
        return new FeedTrendingData(str, str2, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedTrendingData)) {
            return false;
        }
        FeedTrendingData feedTrendingData = (FeedTrendingData) obj;
        return k.a((Object) this.title, (Object) feedTrendingData.title) && k.a((Object) this.logoUrl, (Object) feedTrendingData.logoUrl) && k.a((Object) this.trending, (Object) feedTrendingData.trending);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.logoUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Trending> list = this.trending;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "FeedTrendingData(title=" + this.title + ", logoUrl=" + this.logoUrl + ", trending=" + this.trending + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.logoUrl);
        List<Trending> list = this.trending;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Trending writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public FeedTrendingData(String str, String str2, List<Trending> list) {
        k.c(str, "title");
        k.c(str2, "logoUrl");
        this.title = str;
        this.logoUrl = str2;
        this.trending = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final List<Trending> getTrending() {
        return this.trending;
    }
}
