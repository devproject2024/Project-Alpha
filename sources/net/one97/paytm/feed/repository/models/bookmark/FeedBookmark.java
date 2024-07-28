package net.one97.paytm.feed.repository.models.bookmark;

import kotlin.g.b.k;

public final class FeedBookmark {
    private final boolean exception;
    private final ResultBookmark result;
    private final int status;

    public static /* synthetic */ FeedBookmark copy$default(FeedBookmark feedBookmark, boolean z, ResultBookmark resultBookmark, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = feedBookmark.exception;
        }
        if ((i3 & 2) != 0) {
            resultBookmark = feedBookmark.result;
        }
        if ((i3 & 4) != 0) {
            i2 = feedBookmark.status;
        }
        return feedBookmark.copy(z, resultBookmark, i2);
    }

    public final boolean component1() {
        return this.exception;
    }

    public final ResultBookmark component2() {
        return this.result;
    }

    public final int component3() {
        return this.status;
    }

    public final FeedBookmark copy(boolean z, ResultBookmark resultBookmark, int i2) {
        k.c(resultBookmark, "result");
        return new FeedBookmark(z, resultBookmark, i2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedBookmark) {
                FeedBookmark feedBookmark = (FeedBookmark) obj;
                if ((this.exception == feedBookmark.exception) && k.a((Object) this.result, (Object) feedBookmark.result)) {
                    if (this.status == feedBookmark.status) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.exception;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        ResultBookmark resultBookmark = this.result;
        return ((i2 + (resultBookmark != null ? resultBookmark.hashCode() : 0)) * 31) + Integer.valueOf(this.status).hashCode();
    }

    public final String toString() {
        return "FeedBookmark(exception=" + this.exception + ", result=" + this.result + ", status=" + this.status + ")";
    }

    public FeedBookmark(boolean z, ResultBookmark resultBookmark, int i2) {
        k.c(resultBookmark, "result");
        this.exception = z;
        this.result = resultBookmark;
        this.status = i2;
    }

    public final boolean getException() {
        return this.exception;
    }

    public final ResultBookmark getResult() {
        return this.result;
    }

    public final int getStatus() {
        return this.status;
    }
}
