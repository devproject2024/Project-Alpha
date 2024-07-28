package net.one97.paytm.feed.repository.models.weather;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.cricket.FeedCricketData;

public final class FeedWeather extends FeedItem {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    @c(a = "feedItemData")
    private FeedWeatherData feedWeatherData;
    private Parcel parcel;

    public static /* synthetic */ FeedWeather copy$default(FeedWeather feedWeather, FeedWeatherData feedWeatherData2, Parcel parcel2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedWeatherData2 = feedWeather.feedWeatherData;
        }
        if ((i2 & 2) != 0) {
            parcel2 = feedWeather.parcel;
        }
        return feedWeather.copy(feedWeatherData2, parcel2);
    }

    public final FeedWeatherData component1() {
        return this.feedWeatherData;
    }

    public final Parcel component2() {
        return this.parcel;
    }

    public final FeedWeather copy(FeedWeatherData feedWeatherData2, Parcel parcel2) {
        k.c(feedWeatherData2, "feedWeatherData");
        return new FeedWeather(feedWeatherData2, parcel2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedWeather)) {
            return false;
        }
        FeedWeather feedWeather = (FeedWeather) obj;
        return k.a((Object) this.feedWeatherData, (Object) feedWeather.feedWeatherData) && k.a((Object) this.parcel, (Object) feedWeather.parcel);
    }

    public final int hashCode() {
        FeedWeatherData feedWeatherData2 = this.feedWeatherData;
        int i2 = 0;
        int hashCode = (feedWeatherData2 != null ? feedWeatherData2.hashCode() : 0) * 31;
        Parcel parcel2 = this.parcel;
        if (parcel2 != null) {
            i2 = parcel2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FeedWeather(feedWeatherData=" + this.feedWeatherData + ", parcel=" + this.parcel + ")";
    }

    public final FeedWeatherData getFeedWeatherData() {
        return this.feedWeatherData;
    }

    public final void setFeedWeatherData(FeedWeatherData feedWeatherData2) {
        k.c(feedWeatherData2, "<set-?>");
        this.feedWeatherData = feedWeatherData2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedWeather(FeedWeatherData feedWeatherData2, Parcel parcel2) {
        super(parcel2);
        k.c(feedWeatherData2, "feedWeatherData");
        this.feedWeatherData = feedWeatherData2;
        this.parcel = parcel2;
        Parcel parcel3 = this.parcel;
        if (parcel3 != null) {
            Parcelable readParcelable = parcel3.readParcelable(FeedCricketData.class.getClassLoader());
            if (readParcelable == null) {
                k.a();
            }
            this.feedWeatherData = (FeedWeatherData) readParcelable;
        }
    }

    public final Parcel getParcel() {
        return this.parcel;
    }

    public final void setParcel(Parcel parcel2) {
        this.parcel = parcel2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedWeather(Parcel parcel2) {
        this(new FeedWeatherData("", ""), parcel2);
        k.c(parcel2, "parcel");
    }

    public final void writeToParcel(Parcel parcel2, int i2) {
        k.c(parcel2, "parcel");
        super.writeToParcel(parcel2, i2);
        parcel2.writeParcelable(this.feedWeatherData, i2);
    }

    public static final class CREATOR implements Parcelable.Creator<FeedWeather> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final FeedWeather createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new FeedWeather(parcel);
        }

        public final FeedWeather[] newArray(int i2) {
            return new FeedWeather[i2];
        }
    }
}
