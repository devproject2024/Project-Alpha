package net.one97.paytm.feed.repository.models.recommendedapps;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedRecommendedApps extends FeedItem {
    @c(a = "feedItemData")
    private final FeedRecommendedAppsData feedRecommendedAppsData;

    public static /* synthetic */ FeedRecommendedApps copy$default(FeedRecommendedApps feedRecommendedApps, FeedRecommendedAppsData feedRecommendedAppsData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedRecommendedAppsData2 = feedRecommendedApps.feedRecommendedAppsData;
        }
        return feedRecommendedApps.copy(feedRecommendedAppsData2);
    }

    public final FeedRecommendedAppsData component1() {
        return this.feedRecommendedAppsData;
    }

    public final FeedRecommendedApps copy(FeedRecommendedAppsData feedRecommendedAppsData2) {
        k.c(feedRecommendedAppsData2, "feedRecommendedAppsData");
        return new FeedRecommendedApps(feedRecommendedAppsData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedRecommendedApps) && k.a((Object) this.feedRecommendedAppsData, (Object) ((FeedRecommendedApps) obj).feedRecommendedAppsData);
        }
        return true;
    }

    public final int hashCode() {
        FeedRecommendedAppsData feedRecommendedAppsData2 = this.feedRecommendedAppsData;
        if (feedRecommendedAppsData2 != null) {
            return feedRecommendedAppsData2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedRecommendedApps(feedRecommendedAppsData=" + this.feedRecommendedAppsData + ")";
    }

    public FeedRecommendedApps(FeedRecommendedAppsData feedRecommendedAppsData2) {
        k.c(feedRecommendedAppsData2, "feedRecommendedAppsData");
        this.feedRecommendedAppsData = feedRecommendedAppsData2;
    }

    public final FeedRecommendedAppsData getFeedRecommendedAppsData() {
        return this.feedRecommendedAppsData;
    }
}
