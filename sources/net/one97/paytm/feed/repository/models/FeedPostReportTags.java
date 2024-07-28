package net.one97.paytm.feed.repository.models;

import java.util.List;
import kotlin.g.b.k;

public final class FeedPostReportTags {
    private final List<String> tags;

    public static /* synthetic */ FeedPostReportTags copy$default(FeedPostReportTags feedPostReportTags, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = feedPostReportTags.tags;
        }
        return feedPostReportTags.copy(list);
    }

    public final List<String> component1() {
        return this.tags;
    }

    public final FeedPostReportTags copy(List<String> list) {
        k.c(list, "tags");
        return new FeedPostReportTags(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedPostReportTags) && k.a((Object) this.tags, (Object) ((FeedPostReportTags) obj).tags);
        }
        return true;
    }

    public final int hashCode() {
        List<String> list = this.tags;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedPostReportTags(tags=" + this.tags + ")";
    }

    public FeedPostReportTags(List<String> list) {
        k.c(list, "tags");
        this.tags = list;
    }

    public final List<String> getTags() {
        return this.tags;
    }
}
