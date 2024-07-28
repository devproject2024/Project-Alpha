package net.one97.paytm.feed.repository.models.livetv;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class Category implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
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
            return new Category(arrayList);
        }

        public final Object[] newArray(int i2) {
            return new Category[i2];
        }
    }

    public static /* synthetic */ Category copy$default(Category category, List<Channel> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = category.channels;
        }
        return category.copy(list);
    }

    public final List<Channel> component1() {
        return this.channels;
    }

    public final Category copy(List<Channel> list) {
        k.c(list, "channels");
        return new Category(list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Category) && k.a((Object) this.channels, (Object) ((Category) obj).channels);
        }
        return true;
    }

    public final int hashCode() {
        List<Channel> list = this.channels;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Category(channels=" + this.channels + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        List<Channel> list = this.channels;
        parcel.writeInt(list.size());
        for (Channel writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public Category(List<Channel> list) {
        k.c(list, "channels");
        this.channels = list;
    }

    public final List<Channel> getChannels() {
        return this.channels;
    }
}
