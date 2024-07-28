package net.one97.paytm.feed.repository.models.train;

import android.os.Parcel;
import android.os.Parcelable;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.b.k;

public final class FeedTrainData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String description;
    private final String logoUrl;
    private final String title;
    private final String url;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedTrainData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedTrainData[i2];
        }
    }

    public static /* synthetic */ FeedTrainData copy$default(FeedTrainData feedTrainData, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedTrainData.title;
        }
        if ((i2 & 2) != 0) {
            str2 = feedTrainData.logoUrl;
        }
        if ((i2 & 4) != 0) {
            str3 = feedTrainData.description;
        }
        if ((i2 & 8) != 0) {
            str4 = feedTrainData.url;
        }
        return feedTrainData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.logoUrl;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.url;
    }

    public final FeedTrainData copy(String str, String str2, String str3, String str4) {
        k.c(str, "title");
        k.c(str2, "logoUrl");
        k.c(str3, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str4, "url");
        return new FeedTrainData(str, str2, str3, str4);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedTrainData)) {
            return false;
        }
        FeedTrainData feedTrainData = (FeedTrainData) obj;
        return k.a((Object) this.title, (Object) feedTrainData.title) && k.a((Object) this.logoUrl, (Object) feedTrainData.logoUrl) && k.a((Object) this.description, (Object) feedTrainData.description) && k.a((Object) this.url, (Object) feedTrainData.url);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.logoUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.url;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "FeedTrainData(title=" + this.title + ", logoUrl=" + this.logoUrl + ", description=" + this.description + ", url=" + this.url + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
    }

    public FeedTrainData(String str, String str2, String str3, String str4) {
        k.c(str, "title");
        k.c(str2, "logoUrl");
        k.c(str3, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str4, "url");
        this.title = str;
        this.logoUrl = str2;
        this.description = str3;
        this.url = str4;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getUrl() {
        return this.url;
    }
}
