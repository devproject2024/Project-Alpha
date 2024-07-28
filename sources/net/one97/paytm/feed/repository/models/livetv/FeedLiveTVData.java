package net.one97.paytm.feed.repository.models.livetv;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedLiveTVData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<Channel> channels;
    private final String deepLinkUrl;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Channel) Channel.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new FeedLiveTVData(readString, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new FeedLiveTVData[i2];
        }
    }

    public static /* synthetic */ FeedLiveTVData copy$default(FeedLiveTVData feedLiveTVData, String str, List<Channel> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedLiveTVData.deepLinkUrl;
        }
        if ((i2 & 2) != 0) {
            list = feedLiveTVData.channels;
        }
        return feedLiveTVData.copy(str, list);
    }

    public final String component1() {
        return this.deepLinkUrl;
    }

    public final List<Channel> component2() {
        return this.channels;
    }

    public final FeedLiveTVData copy(String str, List<Channel> list) {
        return new FeedLiveTVData(str, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedLiveTVData)) {
            return false;
        }
        FeedLiveTVData feedLiveTVData = (FeedLiveTVData) obj;
        return k.a((Object) this.deepLinkUrl, (Object) feedLiveTVData.deepLinkUrl) && k.a((Object) this.channels, (Object) feedLiveTVData.channels);
    }

    public final int hashCode() {
        String str = this.deepLinkUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Channel> list = this.channels;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FeedLiveTVData(deepLinkUrl=" + this.deepLinkUrl + ", channels=" + this.channels + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.deepLinkUrl);
        List<Channel> list = this.channels;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Channel writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public FeedLiveTVData(String str, List<Channel> list) {
        this.deepLinkUrl = str;
        this.channels = list;
    }

    public final String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public final List<Channel> getChannels() {
        return this.channels;
    }
}
