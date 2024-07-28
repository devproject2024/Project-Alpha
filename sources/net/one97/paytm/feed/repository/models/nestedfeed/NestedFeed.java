package net.one97.paytm.feed.repository.models.nestedfeed;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;

public final class NestedFeed extends FeedItem {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    @c(a = "feedItemData")
    private NestedFeedData nestedFeedData;
    private Parcel parcel;

    public static /* synthetic */ NestedFeed copy$default(NestedFeed nestedFeed, NestedFeedData nestedFeedData2, Parcel parcel2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            nestedFeedData2 = nestedFeed.nestedFeedData;
        }
        if ((i2 & 2) != 0) {
            parcel2 = nestedFeed.parcel;
        }
        return nestedFeed.copy(nestedFeedData2, parcel2);
    }

    public final NestedFeedData component1() {
        return this.nestedFeedData;
    }

    public final Parcel component2() {
        return this.parcel;
    }

    public final NestedFeed copy(NestedFeedData nestedFeedData2, Parcel parcel2) {
        k.c(nestedFeedData2, "nestedFeedData");
        return new NestedFeed(nestedFeedData2, parcel2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NestedFeed)) {
            return false;
        }
        NestedFeed nestedFeed = (NestedFeed) obj;
        return k.a((Object) this.nestedFeedData, (Object) nestedFeed.nestedFeedData) && k.a((Object) this.parcel, (Object) nestedFeed.parcel);
    }

    public final int hashCode() {
        NestedFeedData nestedFeedData2 = this.nestedFeedData;
        int i2 = 0;
        int hashCode = (nestedFeedData2 != null ? nestedFeedData2.hashCode() : 0) * 31;
        Parcel parcel2 = this.parcel;
        if (parcel2 != null) {
            i2 = parcel2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "NestedFeed(nestedFeedData=" + this.nestedFeedData + ", parcel=" + this.parcel + ")";
    }

    public final NestedFeedData getNestedFeedData() {
        return this.nestedFeedData;
    }

    public final Parcel getParcel() {
        return this.parcel;
    }

    public final void setNestedFeedData(NestedFeedData nestedFeedData2) {
        k.c(nestedFeedData2, "<set-?>");
        this.nestedFeedData = nestedFeedData2;
    }

    public final void setParcel(Parcel parcel2) {
        this.parcel = parcel2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedFeed(NestedFeedData nestedFeedData2, Parcel parcel2) {
        super(parcel2);
        k.c(nestedFeedData2, "nestedFeedData");
        this.nestedFeedData = nestedFeedData2;
        this.parcel = parcel2;
        Parcel parcel3 = this.parcel;
        if (parcel3 != null) {
            Parcelable readParcelable = parcel3.readParcelable(NestedFeedData.class.getClassLoader());
            if (readParcelable == null) {
                k.a();
            }
            this.nestedFeedData = (NestedFeedData) readParcelable;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NestedFeed(Parcel parcel2) {
        this(new NestedFeedData("", (List<FeedGeneric>) null), parcel2);
        k.c(parcel2, "parcel");
    }

    public final void writeToParcel(Parcel parcel2, int i2) {
        k.c(parcel2, "parcel");
        super.writeToParcel(parcel2, i2);
        parcel2.writeParcelable(this.nestedFeedData, i2);
    }

    public static final class CREATOR implements Parcelable.Creator<NestedFeed> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final NestedFeed createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new NestedFeed(parcel);
        }

        public final NestedFeed[] newArray(int i2) {
            return new NestedFeed[i2];
        }
    }
}
