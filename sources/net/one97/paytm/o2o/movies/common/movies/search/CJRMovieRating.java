package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieRating implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMovieRating> CREATOR = new Parcelable.Creator<CJRMovieRating>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieRating[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieRating(parcel);
        }
    };
    @b(a = "base_rating")
    private String base_rating;
    @b(a = "rating")
    private String rating;
    @b(a = "rating_count")
    private long rating_count;

    public int describeContents() {
        return 0;
    }

    public CJRMovieRating() {
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public void setBase_rating(String str) {
        this.base_rating = str;
    }

    public String getBase_rating() {
        return this.base_rating;
    }

    public String getRating() {
        return this.rating;
    }

    protected CJRMovieRating(Parcel parcel) {
        this.rating = parcel.readString();
        this.rating_count = parcel.readLong();
        this.base_rating = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.rating);
        parcel.writeDouble((double) this.rating_count);
        parcel.writeString(this.base_rating);
    }
}
