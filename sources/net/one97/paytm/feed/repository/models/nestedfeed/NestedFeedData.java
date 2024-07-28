package net.one97.paytm.feed.repository.models.nestedfeed;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;

public final class NestedFeedData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "cards")
    private final List<FeedGeneric> genericPostList;
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
                    arrayList.add((FeedGeneric) parcel.readParcelable(NestedFeedData.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new NestedFeedData(readString, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new NestedFeedData[i2];
        }
    }

    public static /* synthetic */ NestedFeedData copy$default(NestedFeedData nestedFeedData, String str, List<FeedGeneric> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = nestedFeedData.title;
        }
        if ((i2 & 2) != 0) {
            list = nestedFeedData.genericPostList;
        }
        return nestedFeedData.copy(str, list);
    }

    public final String component1() {
        return this.title;
    }

    public final List<FeedGeneric> component2() {
        return this.genericPostList;
    }

    public final NestedFeedData copy(String str, List<FeedGeneric> list) {
        return new NestedFeedData(str, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NestedFeedData)) {
            return false;
        }
        NestedFeedData nestedFeedData = (NestedFeedData) obj;
        return k.a((Object) this.title, (Object) nestedFeedData.title) && k.a((Object) this.genericPostList, (Object) nestedFeedData.genericPostList);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FeedGeneric> list = this.genericPostList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "NestedFeedData(title=" + this.title + ", genericPostList=" + this.genericPostList + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.title);
        List<FeedGeneric> list = this.genericPostList;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (FeedGeneric writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i2);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public NestedFeedData(String str, List<FeedGeneric> list) {
        this.title = str;
        this.genericPostList = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<FeedGeneric> getGenericPostList() {
        return this.genericPostList;
    }
}
