package net.one97.paytm.feed.repository.models.sheroes;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedSheroes extends FeedItem {
    @c(a = "feedItemData")
    private final FeedSheroesData feedSheroesData;

    public static /* synthetic */ FeedSheroes copy$default(FeedSheroes feedSheroes, FeedSheroesData feedSheroesData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedSheroesData2 = feedSheroes.feedSheroesData;
        }
        return feedSheroes.copy(feedSheroesData2);
    }

    public final FeedSheroesData component1() {
        return this.feedSheroesData;
    }

    public final FeedSheroes copy(FeedSheroesData feedSheroesData2) {
        k.c(feedSheroesData2, "feedSheroesData");
        return new FeedSheroes(feedSheroesData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedSheroes) && k.a((Object) this.feedSheroesData, (Object) ((FeedSheroes) obj).feedSheroesData);
        }
        return true;
    }

    public final int hashCode() {
        FeedSheroesData feedSheroesData2 = this.feedSheroesData;
        if (feedSheroesData2 != null) {
            return feedSheroesData2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedSheroes(feedSheroesData=" + this.feedSheroesData + ")";
    }

    public final FeedSheroesData getFeedSheroesData() {
        return this.feedSheroesData;
    }

    public FeedSheroes(FeedSheroesData feedSheroesData2) {
        k.c(feedSheroesData2, "feedSheroesData");
        this.feedSheroesData = feedSheroesData2;
    }
}
