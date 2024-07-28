package net.one97.paytm.feed.repository.models.progress;

import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedProgress extends FeedItem {
    private final String progressType;

    public static /* synthetic */ FeedProgress copy$default(FeedProgress feedProgress, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedProgress.progressType;
        }
        return feedProgress.copy(str);
    }

    public final String component1() {
        return this.progressType;
    }

    public final FeedProgress copy(String str) {
        k.c(str, "progressType");
        return new FeedProgress(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedProgress) && k.a((Object) this.progressType, (Object) ((FeedProgress) obj).progressType);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.progressType;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedProgress(progressType=" + this.progressType + ")";
    }

    public FeedProgress(String str) {
        k.c(str, "progressType");
        this.progressType = str;
        setFeedItemType(this.progressType);
    }

    public final String getProgressType() {
        return this.progressType;
    }
}
