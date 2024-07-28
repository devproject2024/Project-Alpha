package net.one97.paytm.feed.repository.models.weather;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class FeedWeatherDetails implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String clickUrl;
    private String dateText;
    private String locationText;
    private String maxMinTemperatureText;
    private String temperatureText;
    private String weatherIconUrl;
    private String weatherText;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FeedWeatherDetails(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedWeatherDetails[i2];
        }
    }

    public static /* synthetic */ FeedWeatherDetails copy$default(FeedWeatherDetails feedWeatherDetails, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedWeatherDetails.locationText;
        }
        if ((i2 & 2) != 0) {
            str2 = feedWeatherDetails.weatherText;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = feedWeatherDetails.weatherIconUrl;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = feedWeatherDetails.temperatureText;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = feedWeatherDetails.maxMinTemperatureText;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = feedWeatherDetails.dateText;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = feedWeatherDetails.clickUrl;
        }
        return feedWeatherDetails.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.locationText;
    }

    public final String component2() {
        return this.weatherText;
    }

    public final String component3() {
        return this.weatherIconUrl;
    }

    public final String component4() {
        return this.temperatureText;
    }

    public final String component5() {
        return this.maxMinTemperatureText;
    }

    public final String component6() {
        return this.dateText;
    }

    public final String component7() {
        return this.clickUrl;
    }

    public final FeedWeatherDetails copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(str, "locationText");
        k.c(str2, "weatherText");
        k.c(str3, "weatherIconUrl");
        k.c(str4, "temperatureText");
        k.c(str5, "maxMinTemperatureText");
        k.c(str6, "dateText");
        String str8 = str7;
        k.c(str8, "clickUrl");
        return new FeedWeatherDetails(str, str2, str3, str4, str5, str6, str8);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedWeatherDetails)) {
            return false;
        }
        FeedWeatherDetails feedWeatherDetails = (FeedWeatherDetails) obj;
        return k.a((Object) this.locationText, (Object) feedWeatherDetails.locationText) && k.a((Object) this.weatherText, (Object) feedWeatherDetails.weatherText) && k.a((Object) this.weatherIconUrl, (Object) feedWeatherDetails.weatherIconUrl) && k.a((Object) this.temperatureText, (Object) feedWeatherDetails.temperatureText) && k.a((Object) this.maxMinTemperatureText, (Object) feedWeatherDetails.maxMinTemperatureText) && k.a((Object) this.dateText, (Object) feedWeatherDetails.dateText) && k.a((Object) this.clickUrl, (Object) feedWeatherDetails.clickUrl);
    }

    public final int hashCode() {
        String str = this.locationText;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.weatherText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.weatherIconUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.temperatureText;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.maxMinTemperatureText;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.dateText;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.clickUrl;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "FeedWeatherDetails(locationText=" + this.locationText + ", weatherText=" + this.weatherText + ", weatherIconUrl=" + this.weatherIconUrl + ", temperatureText=" + this.temperatureText + ", maxMinTemperatureText=" + this.maxMinTemperatureText + ", dateText=" + this.dateText + ", clickUrl=" + this.clickUrl + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.locationText);
        parcel.writeString(this.weatherText);
        parcel.writeString(this.weatherIconUrl);
        parcel.writeString(this.temperatureText);
        parcel.writeString(this.maxMinTemperatureText);
        parcel.writeString(this.dateText);
        parcel.writeString(this.clickUrl);
    }

    public FeedWeatherDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(str, "locationText");
        k.c(str2, "weatherText");
        k.c(str3, "weatherIconUrl");
        k.c(str4, "temperatureText");
        k.c(str5, "maxMinTemperatureText");
        k.c(str6, "dateText");
        k.c(str7, "clickUrl");
        this.locationText = str;
        this.weatherText = str2;
        this.weatherIconUrl = str3;
        this.temperatureText = str4;
        this.maxMinTemperatureText = str5;
        this.dateText = str6;
        this.clickUrl = str7;
    }

    public final String getLocationText() {
        return this.locationText;
    }

    public final String getWeatherText() {
        return this.weatherText;
    }

    public final void setLocationText(String str) {
        k.c(str, "<set-?>");
        this.locationText = str;
    }

    public final void setWeatherText(String str) {
        k.c(str, "<set-?>");
        this.weatherText = str;
    }

    public final String getTemperatureText() {
        return this.temperatureText;
    }

    public final String getWeatherIconUrl() {
        return this.weatherIconUrl;
    }

    public final void setTemperatureText(String str) {
        k.c(str, "<set-?>");
        this.temperatureText = str;
    }

    public final void setWeatherIconUrl(String str) {
        k.c(str, "<set-?>");
        this.weatherIconUrl = str;
    }

    public final String getDateText() {
        return this.dateText;
    }

    public final String getMaxMinTemperatureText() {
        return this.maxMinTemperatureText;
    }

    public final void setDateText(String str) {
        k.c(str, "<set-?>");
        this.dateText = str;
    }

    public final void setMaxMinTemperatureText(String str) {
        k.c(str, "<set-?>");
        this.maxMinTemperatureText = str;
    }

    public final String getClickUrl() {
        return this.clickUrl;
    }

    public final void setClickUrl(String str) {
        k.c(str, "<set-?>");
        this.clickUrl = str;
    }
}
