package net.one97.paytm.feed.repository.models.merchantstorefront;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedMerchantStoreFront extends FeedItem {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "feedItemData")
    private final FeedMerchantStoreFrontData feedMerchantStoreFrontData;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedMerchantStoreFront((FeedMerchantStoreFrontData) FeedMerchantStoreFrontData.CREATOR.createFromParcel(parcel));
        }

        public final Object[] newArray(int i2) {
            return new FeedMerchantStoreFront[i2];
        }
    }

    public static /* synthetic */ FeedMerchantStoreFront copy$default(FeedMerchantStoreFront feedMerchantStoreFront, FeedMerchantStoreFrontData feedMerchantStoreFrontData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedMerchantStoreFrontData2 = feedMerchantStoreFront.feedMerchantStoreFrontData;
        }
        return feedMerchantStoreFront.copy(feedMerchantStoreFrontData2);
    }

    public final FeedMerchantStoreFrontData component1() {
        return this.feedMerchantStoreFrontData;
    }

    public final FeedMerchantStoreFront copy(FeedMerchantStoreFrontData feedMerchantStoreFrontData2) {
        k.c(feedMerchantStoreFrontData2, "feedMerchantStoreFrontData");
        return new FeedMerchantStoreFront(feedMerchantStoreFrontData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedMerchantStoreFront) && k.a((Object) this.feedMerchantStoreFrontData, (Object) ((FeedMerchantStoreFront) obj).feedMerchantStoreFrontData);
        }
        return true;
    }

    public final int hashCode() {
        FeedMerchantStoreFrontData feedMerchantStoreFrontData2 = this.feedMerchantStoreFrontData;
        if (feedMerchantStoreFrontData2 != null) {
            return feedMerchantStoreFrontData2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedMerchantStoreFront(feedMerchantStoreFrontData=" + this.feedMerchantStoreFrontData + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        this.feedMerchantStoreFrontData.writeToParcel(parcel, 0);
    }

    public final FeedMerchantStoreFrontData getFeedMerchantStoreFrontData() {
        return this.feedMerchantStoreFrontData;
    }

    public FeedMerchantStoreFront(FeedMerchantStoreFrontData feedMerchantStoreFrontData2) {
        k.c(feedMerchantStoreFrontData2, "feedMerchantStoreFrontData");
        this.feedMerchantStoreFrontData = feedMerchantStoreFrontData2;
    }
}
