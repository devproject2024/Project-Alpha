package net.one97.paytm.feed.repository.models.bookmark;

import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.profile.UserData;

public final class ResultBookmark {
    private final List<FeedItem> feed;
    private final long maxId;
    private final UserData userData;

    public static /* synthetic */ ResultBookmark copy$default(ResultBookmark resultBookmark, List<FeedItem> list, long j, UserData userData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = resultBookmark.feed;
        }
        if ((i2 & 2) != 0) {
            j = resultBookmark.maxId;
        }
        if ((i2 & 4) != 0) {
            userData2 = resultBookmark.userData;
        }
        return resultBookmark.copy(list, j, userData2);
    }

    public final List<FeedItem> component1() {
        return this.feed;
    }

    public final long component2() {
        return this.maxId;
    }

    public final UserData component3() {
        return this.userData;
    }

    public final ResultBookmark copy(List<? extends FeedItem> list, long j, UserData userData2) {
        k.c(list, "feed");
        k.c(userData2, "userData");
        return new ResultBookmark(list, j, userData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ResultBookmark) {
                ResultBookmark resultBookmark = (ResultBookmark) obj;
                if (k.a((Object) this.feed, (Object) resultBookmark.feed)) {
                    if (!(this.maxId == resultBookmark.maxId) || !k.a((Object) this.userData, (Object) resultBookmark.userData)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List<FeedItem> list = this.feed;
        int i2 = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + Long.valueOf(this.maxId).hashCode()) * 31;
        UserData userData2 = this.userData;
        if (userData2 != null) {
            i2 = userData2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ResultBookmark(feed=" + this.feed + ", maxId=" + this.maxId + ", userData=" + this.userData + ")";
    }

    public ResultBookmark(List<? extends FeedItem> list, long j, UserData userData2) {
        k.c(list, "feed");
        k.c(userData2, "userData");
        this.feed = list;
        this.maxId = j;
        this.userData = userData2;
    }

    public final List<FeedItem> getFeed() {
        return this.feed;
    }

    public final long getMaxId() {
        return this.maxId;
    }

    public final UserData getUserData() {
        return this.userData;
    }
}
