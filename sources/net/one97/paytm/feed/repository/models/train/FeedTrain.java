package net.one97.paytm.feed.repository.models.train;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedTrain extends FeedItem {
    @c(a = "feedItemData")
    private final FeedTrainData feedTrainData;

    public static /* synthetic */ FeedTrain copy$default(FeedTrain feedTrain, FeedTrainData feedTrainData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedTrainData2 = feedTrain.feedTrainData;
        }
        return feedTrain.copy(feedTrainData2);
    }

    public final FeedTrainData component1() {
        return this.feedTrainData;
    }

    public final FeedTrain copy(FeedTrainData feedTrainData2) {
        k.c(feedTrainData2, "feedTrainData");
        return new FeedTrain(feedTrainData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedTrain) && k.a((Object) this.feedTrainData, (Object) ((FeedTrain) obj).feedTrainData);
        }
        return true;
    }

    public final int hashCode() {
        FeedTrainData feedTrainData2 = this.feedTrainData;
        if (feedTrainData2 != null) {
            return feedTrainData2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedTrain(feedTrainData=" + this.feedTrainData + ")";
    }

    public FeedTrain(FeedTrainData feedTrainData2) {
        k.c(feedTrainData2, "feedTrainData");
        this.feedTrainData = feedTrainData2;
    }

    public final FeedTrainData getFeedTrainData() {
        return this.feedTrainData;
    }
}
