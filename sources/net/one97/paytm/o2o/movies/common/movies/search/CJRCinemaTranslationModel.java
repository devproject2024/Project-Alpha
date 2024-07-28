package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCinemaTranslationModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRCinemaTranslationModel> CREATOR = new Parcelable.Creator<CJRCinemaTranslationModel>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRCinemaTranslationModel[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRCinemaTranslationModel(parcel);
        }
    };
    @b(a = "address")
    private String address;
    @b(a = "name")
    private String name;
    @b(a = "providerName")
    String providerName;

    public int describeContents() {
        return 0;
    }

    protected CJRCinemaTranslationModel(Parcel parcel) {
        this.name = parcel.readString();
        this.address = parcel.readString();
        this.providerName = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.address);
        parcel.writeString(this.providerName);
    }

    public String getCinemaName() {
        return this.name;
    }

    public void setCinemaName(String str) {
        this.name = str;
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
}
