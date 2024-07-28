package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviesSessionDetails implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMoviesSessionDetails> CREATOR = new Parcelable.Creator<CJRMoviesSessionDetails>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMoviesSessionDetails[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMoviesSessionDetails(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    @b(a = "areaCatCode")
    public String mAreaCatCode;
    @b(a = "cinemaId")
    public String mCinemaID;
    @b(a = "priceDetails")
    public CJRMoviesPriceDetails mMoviesPriceDetails;
    @b(a = "priceCode")
    public String mPriceCode;
    @b(a = "seatsAvail")
    public int mSeatsAvailable;
    @b(a = "sessionId")
    public String mSessionID;
    @b(a = "seatsTotal")
    public int mTotalSeats;

    public int describeContents() {
        return 0;
    }

    public String getCinemaID() {
        return this.mCinemaID;
    }

    public String getSessionID() {
        return this.mSessionID;
    }

    public String getAreaCatCode() {
        return this.mAreaCatCode;
    }

    public int getSeatsAvailable() {
        return this.mSeatsAvailable;
    }

    public int getTotalSeats() {
        return this.mTotalSeats;
    }

    public String getPriceCode() {
        return this.mPriceCode;
    }

    public CJRMoviesPriceDetails getMoviesPriceDetails() {
        return this.mMoviesPriceDetails;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mCinemaID);
        parcel.writeString(this.mSessionID);
        parcel.writeString(this.mAreaCatCode);
        parcel.writeInt(this.mSeatsAvailable);
        parcel.writeInt(this.mTotalSeats);
        parcel.writeString(this.mPriceCode);
        parcel.writeParcelable(this.mMoviesPriceDetails, i2);
    }

    public CJRMoviesSessionDetails() {
    }

    protected CJRMoviesSessionDetails(Parcel parcel) {
        this.mCinemaID = parcel.readString();
        this.mSessionID = parcel.readString();
        this.mAreaCatCode = parcel.readString();
        this.mSeatsAvailable = parcel.readInt();
        this.mTotalSeats = parcel.readInt();
        this.mPriceCode = parcel.readString();
        this.mMoviesPriceDetails = (CJRMoviesPriceDetails) parcel.readParcelable(CJRMoviesPriceDetails.class.getClassLoader());
    }
}
