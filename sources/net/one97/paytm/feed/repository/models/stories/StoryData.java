package net.one97.paytm.feed.repository.models.stories;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class StoryData extends FeedItem {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "stories")
    private final List<Stories> storyList;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Stories) Stories.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new StoryData(arrayList);
        }

        public final Object[] newArray(int i2) {
            return new StoryData[i2];
        }
    }

    public static /* synthetic */ StoryData copy$default(StoryData storyData, List<Stories> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = storyData.storyList;
        }
        return storyData.copy(list);
    }

    public final List<Stories> component1() {
        return this.storyList;
    }

    public final StoryData copy(List<Stories> list) {
        k.c(list, "storyList");
        return new StoryData(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof StoryData) && k.a((Object) this.storyList, (Object) ((StoryData) obj).storyList);
        }
        return true;
    }

    public final int hashCode() {
        List<Stories> list = this.storyList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "StoryData(storyList=" + this.storyList + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        List<Stories> list = this.storyList;
        parcel.writeInt(list.size());
        for (Stories writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public StoryData(List<Stories> list) {
        k.c(list, "storyList");
        this.storyList = list;
    }

    public final List<Stories> getStoryList() {
        return this.storyList;
    }
}
