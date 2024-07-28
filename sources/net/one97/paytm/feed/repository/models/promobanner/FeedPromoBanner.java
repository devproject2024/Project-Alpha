package net.one97.paytm.feed.repository.models.promobanner;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedPromoBanner extends FeedItem {
    @c(a = "feedItemData")
    private final FeedPromoBannerData feedPromoBannerData;

    public static /* synthetic */ FeedPromoBanner copy$default(FeedPromoBanner feedPromoBanner, FeedPromoBannerData feedPromoBannerData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedPromoBannerData2 = feedPromoBanner.feedPromoBannerData;
        }
        return feedPromoBanner.copy(feedPromoBannerData2);
    }

    public final FeedPromoBannerData component1() {
        return this.feedPromoBannerData;
    }

    public final FeedPromoBanner copy(FeedPromoBannerData feedPromoBannerData2) {
        k.c(feedPromoBannerData2, "feedPromoBannerData");
        return new FeedPromoBanner(feedPromoBannerData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedPromoBanner) && k.a((Object) this.feedPromoBannerData, (Object) ((FeedPromoBanner) obj).feedPromoBannerData);
        }
        return true;
    }

    public final int hashCode() {
        FeedPromoBannerData feedPromoBannerData2 = this.feedPromoBannerData;
        if (feedPromoBannerData2 != null) {
            return feedPromoBannerData2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedPromoBanner(feedPromoBannerData=" + this.feedPromoBannerData + ")";
    }

    public FeedPromoBanner(FeedPromoBannerData feedPromoBannerData2) {
        k.c(feedPromoBannerData2, "feedPromoBannerData");
        this.feedPromoBannerData = feedPromoBannerData2;
    }

    public final FeedPromoBannerData getFeedPromoBannerData() {
        return this.feedPromoBannerData;
    }
}
