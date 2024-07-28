package net.one97.paytm.feed.repository.models.cricket;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class FeedTeam implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String fullName;
    private String iconUrl;
    private int id;
    private String shortName;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedTeam(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedTeam[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.shortName);
        parcel.writeString(this.fullName);
        parcel.writeString(this.iconUrl);
    }

    public FeedTeam(int i2, String str, String str2, String str3) {
        k.c(str, "shortName");
        k.c(str2, "fullName");
        k.c(str3, SDKConstants.ICON_URL);
        this.id = i2;
        this.shortName = str;
        this.fullName = str2;
        this.iconUrl = str3;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getId() {
        return this.id;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public final void setFullName(String str) {
        k.c(str, "<set-?>");
        this.fullName = str;
    }

    public final void setIconUrl(String str) {
        k.c(str, "<set-?>");
        this.iconUrl = str;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setShortName(String str) {
        k.c(str, "<set-?>");
        this.shortName = str;
    }
}
