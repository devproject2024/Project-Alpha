package net.one97.paytm.feed.repository.models.comment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class FeedComment implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final boolean exception;
    private final CommentResult result;
    private final int status;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedComment(parcel.readInt() != 0, (CommentResult) CommentResult.CREATOR.createFromParcel(parcel), parcel.readInt());
        }

        public final Object[] newArray(int i2) {
            return new FeedComment[i2];
        }
    }

    public static /* synthetic */ FeedComment copy$default(FeedComment feedComment, boolean z, CommentResult commentResult, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = feedComment.exception;
        }
        if ((i3 & 2) != 0) {
            commentResult = feedComment.result;
        }
        if ((i3 & 4) != 0) {
            i2 = feedComment.status;
        }
        return feedComment.copy(z, commentResult, i2);
    }

    public final boolean component1() {
        return this.exception;
    }

    public final CommentResult component2() {
        return this.result;
    }

    public final int component3() {
        return this.status;
    }

    public final FeedComment copy(boolean z, CommentResult commentResult, int i2) {
        k.c(commentResult, "result");
        return new FeedComment(z, commentResult, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FeedComment) {
                FeedComment feedComment = (FeedComment) obj;
                if ((this.exception == feedComment.exception) && k.a((Object) this.result, (Object) feedComment.result)) {
                    if (this.status == feedComment.status) {
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
        CommentResult commentResult = this.result;
        return ((i2 + (commentResult != null ? commentResult.hashCode() : 0)) * 31) + Integer.valueOf(this.status).hashCode();
    }

    public final String toString() {
        return "FeedComment(exception=" + this.exception + ", result=" + this.result + ", status=" + this.status + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.exception ? 1 : 0);
        this.result.writeToParcel(parcel, 0);
        parcel.writeInt(this.status);
    }

    public FeedComment(boolean z, CommentResult commentResult, int i2) {
        k.c(commentResult, "result");
        this.exception = z;
        this.result = commentResult;
        this.status = i2;
    }

    public final boolean getException() {
        return this.exception;
    }

    public final CommentResult getResult() {
        return this.result;
    }

    public final int getStatus() {
        return this.status;
    }
}
