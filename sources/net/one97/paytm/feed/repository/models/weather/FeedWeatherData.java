package net.one97.paytm.feed.repository.models.weather;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedWeatherData implements FeedItemData {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private final String clickUrl;
    private final String dataUrl;

    public static /* synthetic */ FeedWeatherData copy$default(FeedWeatherData feedWeatherData, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedWeatherData.dataUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = feedWeatherData.clickUrl;
        }
        return feedWeatherData.copy(str, str2);
    }

    public final String component1() {
        return this.dataUrl;
    }

    public final String component2() {
        return this.clickUrl;
    }

    public final FeedWeatherData copy(String str, String str2) {
        k.c(str, "dataUrl");
        return new FeedWeatherData(str, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedWeatherData)) {
            return false;
        }
        FeedWeatherData feedWeatherData = (FeedWeatherData) obj;
        return k.a((Object) this.dataUrl, (Object) feedWeatherData.dataUrl) && k.a((Object) this.clickUrl, (Object) feedWeatherData.clickUrl);
    }

    public final int hashCode() {
        String str = this.dataUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.clickUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FeedWeatherData(dataUrl=" + this.dataUrl + ", clickUrl=" + this.clickUrl + ")";
    }

    public FeedWeatherData(String str, String str2) {
        k.c(str, "dataUrl");
        this.dataUrl = str;
        this.clickUrl = str2;
    }

    public final String getClickUrl() {
        return this.clickUrl;
    }

    public final String getDataUrl() {
        return this.dataUrl;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FeedWeatherData(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = r3.readString()
            if (r0 != 0) goto L_0x000e
            kotlin.g.b.k.a()
        L_0x000e:
            java.lang.String r1 = "parcel.readString()!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r3 = r3.readString()
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.models.weather.FeedWeatherData.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.dataUrl);
        parcel.writeString(this.clickUrl);
    }

    public static final class CREATOR implements Parcelable.Creator<FeedWeatherData> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final FeedWeatherData createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new FeedWeatherData(parcel);
        }

        public final FeedWeatherData[] newArray(int i2) {
            return new FeedWeatherData[i2];
        }
    }
}
