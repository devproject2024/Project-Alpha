package net.one97.paytm.feed.repository.models.promobanner;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedPromoBannerData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<Banner> banners;
    private final String id;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.c(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Banner) Banner.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new FeedPromoBannerData(readString, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new FeedPromoBannerData[i2];
        }
    }

    public static /* synthetic */ FeedPromoBannerData copy$default(FeedPromoBannerData feedPromoBannerData, String str, List<Banner> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedPromoBannerData.id;
        }
        if ((i2 & 2) != 0) {
            list = feedPromoBannerData.banners;
        }
        return feedPromoBannerData.copy(str, list);
    }

    public final String component1() {
        return this.id;
    }

    public final List<Banner> component2() {
        return this.banners;
    }

    public final FeedPromoBannerData copy(String str, List<Banner> list) {
        k.c(str, "id");
        return new FeedPromoBannerData(str, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedPromoBannerData)) {
            return false;
        }
        FeedPromoBannerData feedPromoBannerData = (FeedPromoBannerData) obj;
        return k.a((Object) this.id, (Object) feedPromoBannerData.id) && k.a((Object) this.banners, (Object) feedPromoBannerData.banners);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Banner> list = this.banners;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FeedPromoBannerData(id=" + this.id + ", banners=" + this.banners + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        List<Banner> list = this.banners;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Banner writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public FeedPromoBannerData(String str, List<Banner> list) {
        k.c(str, "id");
        this.id = str;
        this.banners = list;
    }

    public final String getId() {
        return this.id;
    }

    public final List<Banner> getBanners() {
        return this.banners;
    }
}
