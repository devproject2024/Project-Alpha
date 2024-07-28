package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class Result implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<FeedItem> feed;
    private final int nextPageNo;
    private final String requestId;
    private final int totalPageCount;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((FeedItem) parcel.readParcelable(Result.class.getClassLoader()));
                readInt--;
            }
            return new Result(arrayList, parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        public final Object[] newArray(int i2) {
            return new Result[i2];
        }
    }

    public static /* synthetic */ Result copy$default(Result result, List<FeedItem> list, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = result.feed;
        }
        if ((i4 & 2) != 0) {
            str = result.requestId;
        }
        if ((i4 & 4) != 0) {
            i2 = result.nextPageNo;
        }
        if ((i4 & 8) != 0) {
            i3 = result.totalPageCount;
        }
        return result.copy(list, str, i2, i3);
    }

    public final List<FeedItem> component1() {
        return this.feed;
    }

    public final String component2() {
        return this.requestId;
    }

    public final int component3() {
        return this.nextPageNo;
    }

    public final int component4() {
        return this.totalPageCount;
    }

    public final Result copy(List<? extends FeedItem> list, String str, int i2, int i3) {
        k.c(list, "feed");
        return new Result(list, str, i2, i3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Result) {
                Result result = (Result) obj;
                if (k.a((Object) this.feed, (Object) result.feed) && k.a((Object) this.requestId, (Object) result.requestId)) {
                    if (this.nextPageNo == result.nextPageNo) {
                        if (this.totalPageCount == result.totalPageCount) {
                            return true;
                        }
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
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.requestId;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((((hashCode + i2) * 31) + Integer.valueOf(this.nextPageNo).hashCode()) * 31) + Integer.valueOf(this.totalPageCount).hashCode();
    }

    public final String toString() {
        return "Result(feed=" + this.feed + ", requestId=" + this.requestId + ", nextPageNo=" + this.nextPageNo + ", totalPageCount=" + this.totalPageCount + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        List<FeedItem> list = this.feed;
        parcel.writeInt(list.size());
        for (FeedItem writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i2);
        }
        parcel.writeString(this.requestId);
        parcel.writeInt(this.nextPageNo);
        parcel.writeInt(this.totalPageCount);
    }

    public Result(List<? extends FeedItem> list, String str, int i2, int i3) {
        k.c(list, "feed");
        this.feed = list;
        this.requestId = str;
        this.nextPageNo = i2;
        this.totalPageCount = i3;
    }

    public final List<FeedItem> getFeed() {
        return this.feed;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final int getNextPageNo() {
        return this.nextPageNo;
    }

    public final int getTotalPageCount() {
        return this.totalPageCount;
    }
}
