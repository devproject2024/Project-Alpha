package net.one97.paytm.feed.repository.models.comment;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class CommentResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<CommentResponse> commentResponseList;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((CommentResponse) CommentResponse.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new CommentResult(arrayList);
        }

        public final Object[] newArray(int i2) {
            return new CommentResult[i2];
        }
    }

    public static /* synthetic */ CommentResult copy$default(CommentResult commentResult, List<CommentResponse> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = commentResult.commentResponseList;
        }
        return commentResult.copy(list);
    }

    public final List<CommentResponse> component1() {
        return this.commentResponseList;
    }

    public final CommentResult copy(List<CommentResponse> list) {
        k.c(list, "commentResponseList");
        return new CommentResult(list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CommentResult) && k.a((Object) this.commentResponseList, (Object) ((CommentResult) obj).commentResponseList);
        }
        return true;
    }

    public final int hashCode() {
        List<CommentResponse> list = this.commentResponseList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CommentResult(commentResponseList=" + this.commentResponseList + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        List<CommentResponse> list = this.commentResponseList;
        parcel.writeInt(list.size());
        for (CommentResponse writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public CommentResult(List<CommentResponse> list) {
        k.c(list, "commentResponseList");
        this.commentResponseList = list;
    }

    public final List<CommentResponse> getCommentResponseList() {
        return this.commentResponseList;
    }
}
