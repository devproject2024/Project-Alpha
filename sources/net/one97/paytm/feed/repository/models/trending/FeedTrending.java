package net.one97.paytm.feed.repository.models.trending;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedTrending extends FeedItem {
    @c(a = "feedItemData")
    private final FeedTrendingData feedTrendingData;

    public static /* synthetic */ FeedTrending copy$default(FeedTrending feedTrending, FeedTrendingData feedTrendingData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedTrendingData2 = feedTrending.feedTrendingData;
        }
        return feedTrending.copy(feedTrendingData2);
    }

    public final FeedTrendingData component1() {
        return this.feedTrendingData;
    }

    public final FeedTrending copy(FeedTrendingData feedTrendingData2) {
        k.c(feedTrendingData2, "feedTrendingData");
        return new FeedTrending(feedTrendingData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedTrending) && k.a((Object) this.feedTrendingData, (Object) ((FeedTrending) obj).feedTrendingData);
        }
        return true;
    }

    public final int hashCode() {
        FeedTrendingData feedTrendingData2 = this.feedTrendingData;
        if (feedTrendingData2 != null) {
            return feedTrendingData2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedTrending(feedTrendingData=" + this.feedTrendingData + ")";
    }

    public FeedTrending(FeedTrendingData feedTrendingData2) {
        k.c(feedTrendingData2, "feedTrendingData");
        this.feedTrendingData = feedTrendingData2;
    }

    public final FeedTrendingData getFeedTrendingData() {
        return this.feedTrendingData;
    }
}
