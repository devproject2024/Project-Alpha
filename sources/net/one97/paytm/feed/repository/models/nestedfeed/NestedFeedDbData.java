package net.one97.paytm.feed.repository.models.nestedfeed;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;
import net.one97.paytm.feed.repository.models.FeedOfFeed;

public final class NestedFeedDbData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "cards")
    private final List<FeedOfFeed> genericPostList;
    private final String title;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((FeedOfFeed) FeedOfFeed.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new NestedFeedDbData(readString, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new NestedFeedDbData[i2];
        }
    }

    public static /* synthetic */ NestedFeedDbData copy$default(NestedFeedDbData nestedFeedDbData, String str, List<FeedOfFeed> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = nestedFeedDbData.title;
        }
        if ((i2 & 2) != 0) {
            list = nestedFeedDbData.genericPostList;
        }
        return nestedFeedDbData.copy(str, list);
    }

    public final String component1() {
        return this.title;
    }

    public final List<FeedOfFeed> component2() {
        return this.genericPostList;
    }

    public final NestedFeedDbData copy(String str, List<FeedOfFeed> list) {
        k.c(str, "title");
        return new NestedFeedDbData(str, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NestedFeedDbData)) {
            return false;
        }
        NestedFeedDbData nestedFeedDbData = (NestedFeedDbData) obj;
        return k.a((Object) this.title, (Object) nestedFeedDbData.title) && k.a((Object) this.genericPostList, (Object) nestedFeedDbData.genericPostList);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FeedOfFeed> list = this.genericPostList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "NestedFeedDbData(title=" + this.title + ", genericPostList=" + this.genericPostList + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.title);
        List<FeedOfFeed> list = this.genericPostList;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (FeedOfFeed writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public NestedFeedDbData(String str, List<FeedOfFeed> list) {
        k.c(str, "title");
        this.title = str;
        this.genericPostList = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<FeedOfFeed> getGenericPostList() {
        return this.genericPostList;
    }
}
