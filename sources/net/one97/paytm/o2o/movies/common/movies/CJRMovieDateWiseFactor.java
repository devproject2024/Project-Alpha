package net.one97.paytm.o2o.movies.common.movies;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieDateWiseFactor implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMovieDateWiseFactor> CREATOR = new Parcelable.Creator<CJRMovieDateWiseFactor>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieDateWiseFactor[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieDateWiseFactor(parcel);
        }
    };
    @b(a = "cinemaChain")
    public CJRCinemaListModel cinemaChain;
    @b(a = "format")
    public CJRMovieShowTimeSearchFilterItem format;
    @b(a = "premium")
    public CJRMovieShowTimeSearchFilterItem premium;
    @b(a = "price")
    public CJRMovieShowTimeSearchFilterItem price;
    @b(a = "showTime")
    public CJRMovieShowTimeSearchFilterItem showTime;

    public int describeContents() {
        return 0;
    }

    public CJRMovieShowTimeSearchFilterItem getPremium() {
        return this.premium;
    }

    public void setPremium(CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem) {
        this.premium = cJRMovieShowTimeSearchFilterItem;
    }

    public CJRCinemaListModel getCinemaChain() {
        return this.cinemaChain;
    }

    public void setCinemaChain(CJRCinemaListModel cJRCinemaListModel) {
        this.cinemaChain = cJRCinemaListModel;
    }

    public CJRMovieShowTimeSearchFilterItem getPrice() {
        return this.price;
    }

    public CJRMovieShowTimeSearchFilterItem getShowTime() {
        return this.showTime;
    }

    public CJRMovieShowTimeSearchFilterItem getFormat() {
        return this.format;
    }

    public void setFormat(CJRMovieShowTimeSearchFilterItem cJRMovieShowTimeSearchFilterItem) {
        this.format = cJRMovieShowTimeSearchFilterItem;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.price, i2);
        parcel.writeParcelable(this.showTime, i2);
        parcel.writeParcelable(this.format, i2);
        parcel.writeParcelable(this.premium, i2);
        parcel.writeParcelable(this.cinemaChain, i2);
    }

    public CJRMovieDateWiseFactor() {
    }

    protected CJRMovieDateWiseFactor(Parcel parcel) {
        this.price = (CJRMovieShowTimeSearchFilterItem) parcel.readParcelable(CJRMovieShowTimeSearchFilterItem.class.getClassLoader());
        this.showTime = (CJRMovieShowTimeSearchFilterItem) parcel.readParcelable(CJRMovieShowTimeSearchFilterItem.class.getClassLoader());
        this.format = (CJRMovieShowTimeSearchFilterItem) parcel.readParcelable(CJRMovieShowTimeSearchFilterItem.class.getClassLoader());
        this.premium = (CJRMovieShowTimeSearchFilterItem) parcel.readParcelable(CJRMovieShowTimeSearchFilterItem.class.getClassLoader());
        this.cinemaChain = (CJRCinemaListModel) parcel.readParcelable(CJRCinemaListModel.class.getClassLoader());
    }
}
