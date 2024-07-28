package net.one97.paytm.feed.repository.models;

import java.util.List;
import kotlin.g.b.k;

public final class FeedCommentReportTags {
    private final List<String> tags;

    public static /* synthetic */ FeedCommentReportTags copy$default(FeedCommentReportTags feedCommentReportTags, List<String> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = feedCommentReportTags.tags;
        }
        return feedCommentReportTags.copy(list);
    }

    public final List<String> component1() {
        return this.tags;
    }

    public final FeedCommentReportTags copy(List<String> list) {
        k.c(list, "tags");
        return new FeedCommentReportTags(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedCommentReportTags) && k.a((Object) this.tags, (Object) ((FeedCommentReportTags) obj).tags);
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
        return "FeedCommentReportTags(tags=" + this.tags + ")";
    }

    public FeedCommentReportTags(List<String> list) {
        k.c(list, "tags");
        this.tags = list;
    }

    public final List<String> getTags() {
        return this.tags;
    }
}
