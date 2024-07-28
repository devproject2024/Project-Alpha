package net.one97.paytm.feed.repository.models.livetv;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedLiveTV extends FeedItem {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "feedItemData")
    private final FeedLiveTVData feedLiveTVData;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedLiveTV((FeedLiveTVData) FeedLiveTVData.CREATOR.createFromParcel(parcel));
        }

        public final Object[] newArray(int i2) {
            return new FeedLiveTV[i2];
        }
    }

    public static /* synthetic */ FeedLiveTV copy$default(FeedLiveTV feedLiveTV, FeedLiveTVData feedLiveTVData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedLiveTVData2 = feedLiveTV.feedLiveTVData;
        }
        return feedLiveTV.copy(feedLiveTVData2);
    }

    public final FeedLiveTVData component1() {
        return this.feedLiveTVData;
    }

    public final FeedLiveTV copy(FeedLiveTVData feedLiveTVData2) {
        k.c(feedLiveTVData2, "feedLiveTVData");
        return new FeedLiveTV(feedLiveTVData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedLiveTV) && k.a((Object) this.feedLiveTVData, (Object) ((FeedLiveTV) obj).feedLiveTVData);
        }
        return true;
    }

    public final int hashCode() {
        FeedLiveTVData feedLiveTVData2 = this.feedLiveTVData;
        if (feedLiveTVData2 != null) {
            return feedLiveTVData2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedLiveTV(feedLiveTVData=" + this.feedLiveTVData + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        this.feedLiveTVData.writeToParcel(parcel, 0);
    }

    public FeedLiveTV(FeedLiveTVData feedLiveTVData2) {
        k.c(feedLiveTVData2, "feedLiveTVData");
        this.feedLiveTVData = feedLiveTVData2;
    }

    public final FeedLiveTVData getFeedLiveTVData() {
        return this.feedLiveTVData;
    }
}
