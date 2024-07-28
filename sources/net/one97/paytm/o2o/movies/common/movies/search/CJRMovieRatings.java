package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieRatings implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMovieRatings> CREATOR = new Parcelable.Creator<CJRMovieRatings>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieRatings[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieRatings(parcel);
        }
    };
    @b(a = "imdb")
    private CJRMovieRating imdb;

    public int describeContents() {
        return 0;
    }

    public CJRMovieRatings() {
    }

    public void setImdb(CJRMovieRating cJRMovieRating) {
        this.imdb = cJRMovieRating;
    }

    public CJRMovieRating getImdb() {
        return this.imdb;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.imdb, i2);
    }

    protected CJRMovieRatings(Parcel parcel) {
        this.imdb = (CJRMovieRating) parcel.readParcelable(CJRMovieRating.class.getClassLoader());
    }
}
