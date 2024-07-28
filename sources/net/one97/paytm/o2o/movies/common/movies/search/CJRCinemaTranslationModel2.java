package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCinemaTranslationModel2 implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRCinemaTranslationModel2> CREATOR = new Parcelable.Creator<CJRCinemaTranslationModel2>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRCinemaTranslationModel2[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRCinemaTranslationModel2(parcel);
        }
    };
    @b(a = "address")
    private String address;
    @b(a = "cinemaName")
    private String cinemaName;
    @b(a = "providerName")
    String providerName;

    public int describeContents() {
        return 0;
    }

    protected CJRCinemaTranslationModel2(Parcel parcel) {
        this.cinemaName = parcel.readString();
        this.address = parcel.readString();
        this.providerName = parcel.readString();
    }

    public String getCinemaName() {
        return this.cinemaName;
    }

    public void setCinemaName(String str) {
        this.cinemaName = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.cinemaName);
        parcel.writeString(this.address);
        parcel.writeString(this.providerName);
    }
}
