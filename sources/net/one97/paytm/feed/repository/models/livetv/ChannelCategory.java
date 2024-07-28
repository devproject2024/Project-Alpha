package net.one97.paytm.feed.repository.models.livetv;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class ChannelCategory implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String categoryId;
    private final String categoryName;
    private final int channelCount;
    private final List<Channel> channels;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Channel) Channel.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new ChannelCategory(arrayList, parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public final Object[] newArray(int i2) {
            return new ChannelCategory[i2];
        }
    }

    public static /* synthetic */ ChannelCategory copy$default(ChannelCategory channelCategory, List<Channel> list, String str, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = channelCategory.channels;
        }
        if ((i3 & 2) != 0) {
            str = channelCategory.categoryId;
        }
        if ((i3 & 4) != 0) {
            str2 = channelCategory.categoryName;
        }
        if ((i3 & 8) != 0) {
            i2 = channelCategory.channelCount;
        }
        return channelCategory.copy(list, str, str2, i2);
    }

    public final List<Channel> component1() {
        return this.channels;
    }

    public final String component2() {
        return this.categoryId;
    }

    public final String component3() {
        return this.categoryName;
    }

    public final int component4() {
        return this.channelCount;
    }

    public final ChannelCategory copy(List<Channel> list, String str, String str2, int i2) {
        k.c(list, "channels");
        k.c(str, "categoryId");
        k.c(str2, "categoryName");
        return new ChannelCategory(list, str, str2, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ChannelCategory) {
                ChannelCategory channelCategory = (ChannelCategory) obj;
                if (k.a((Object) this.channels, (Object) channelCategory.channels) && k.a((Object) this.categoryId, (Object) channelCategory.categoryId) && k.a((Object) this.categoryName, (Object) channelCategory.categoryName)) {
                    if (this.channelCount == channelCategory.channelCount) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List<Channel> list = this.channels;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.categoryId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.categoryName;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode2 + i2) * 31) + Integer.valueOf(this.channelCount).hashCode();
    }

    public final String toString() {
        return "ChannelCategory(channels=" + this.channels + ", categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", channelCount=" + this.channelCount + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        List<Channel> list = this.channels;
        parcel.writeInt(list.size());
        for (Channel writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeString(this.categoryId);
        parcel.writeString(this.categoryName);
        parcel.writeInt(this.channelCount);
    }

    public ChannelCategory(List<Channel> list, String str, String str2, int i2) {
        k.c(list, "channels");
        k.c(str, "categoryId");
        k.c(str2, "categoryName");
        this.channels = list;
        this.categoryId = str;
        this.categoryName = str2;
        this.channelCount = i2;
    }

    public final List<Channel> getChannels() {
        return this.channels;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final int getChannelCount() {
        return this.channelCount;
    }
}
