package net.one97.paytm.feed.repository.models.polls;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class PollsResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<Options> options;
    private final int totalVoteCount;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((Options) Options.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new PollsResponse(readInt, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new PollsResponse[i2];
        }
    }

    public static /* synthetic */ PollsResponse copy$default(PollsResponse pollsResponse, int i2, List<Options> list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = pollsResponse.totalVoteCount;
        }
        if ((i3 & 2) != 0) {
            list = pollsResponse.options;
        }
        return pollsResponse.copy(i2, list);
    }

    public final int component1() {
        return this.totalVoteCount;
    }

    public final List<Options> component2() {
        return this.options;
    }

    public final PollsResponse copy(int i2, List<Options> list) {
        k.c(list, "options");
        return new PollsResponse(i2, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PollsResponse) {
                PollsResponse pollsResponse = (PollsResponse) obj;
                if (!(this.totalVoteCount == pollsResponse.totalVoteCount) || !k.a((Object) this.options, (Object) pollsResponse.options)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.totalVoteCount).hashCode() * 31;
        List<Options> list = this.options;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "PollsResponse(totalVoteCount=" + this.totalVoteCount + ", options=" + this.options + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.totalVoteCount);
        List<Options> list = this.options;
        parcel.writeInt(list.size());
        for (Options writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public PollsResponse(int i2, List<Options> list) {
        k.c(list, "options");
        this.totalVoteCount = i2;
        this.options = list;
    }

    public final int getTotalVoteCount() {
        return this.totalVoteCount;
    }

    public final List<Options> getOptions() {
        return this.options;
    }
}
