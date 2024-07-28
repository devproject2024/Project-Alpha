package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;
import net.one97.paytm.feed.e.b;

public class BaseItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String buckets = "";
    private int feedItemRank = 0;
    private String feedItemType = "";

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            if (parcel.readInt() != 0) {
                return new BaseItem();
            }
            return null;
        }

        public final Object[] newArray(int i2) {
            return new BaseItem[i2];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(1);
    }

    public BaseItem() {
        b bVar = b.f34268c;
        b.k();
    }

    public final String getBuckets() {
        return this.buckets;
    }

    public final void setBuckets(String str) {
        k.c(str, "<set-?>");
        this.buckets = str;
    }

    public final String getFeedItemType() {
        return this.feedItemType;
    }

    public final void setFeedItemType(String str) {
        k.c(str, "<set-?>");
        this.feedItemType = str;
    }

    public final int getFeedItemRank() {
        return this.feedItemRank;
    }

    public final void setFeedItemRank(int i2) {
        this.feedItemRank = i2;
    }
}
