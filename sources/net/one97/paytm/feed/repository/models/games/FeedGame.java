package net.one97.paytm.feed.repository.models.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedGame extends FeedItem {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "feedItemData")
    private final FeedGameData feedGameData;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedGame((FeedGameData) FeedGameData.CREATOR.createFromParcel(parcel));
        }

        public final Object[] newArray(int i2) {
            return new FeedGame[i2];
        }
    }

    public static /* synthetic */ FeedGame copy$default(FeedGame feedGame, FeedGameData feedGameData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedGameData2 = feedGame.feedGameData;
        }
        return feedGame.copy(feedGameData2);
    }

    public final FeedGameData component1() {
        return this.feedGameData;
    }

    public final FeedGame copy(FeedGameData feedGameData2) {
        k.c(feedGameData2, "feedGameData");
        return new FeedGame(feedGameData2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedGame) && k.a((Object) this.feedGameData, (Object) ((FeedGame) obj).feedGameData);
        }
        return true;
    }

    public final int hashCode() {
        FeedGameData feedGameData2 = this.feedGameData;
        if (feedGameData2 != null) {
            return feedGameData2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedGame(feedGameData=" + this.feedGameData + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        this.feedGameData.writeToParcel(parcel, 0);
    }

    public final FeedGameData getFeedGameData() {
        return this.feedGameData;
    }

    public FeedGame(FeedGameData feedGameData2) {
        k.c(feedGameData2, "feedGameData");
        this.feedGameData = feedGameData2;
    }
}
