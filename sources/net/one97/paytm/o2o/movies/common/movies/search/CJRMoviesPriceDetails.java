package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviesPriceDetails implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMoviesPriceDetails> CREATOR = new Parcelable.Creator<CJRMoviesPriceDetails>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMoviesPriceDetails[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMoviesPriceDetails(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    @b(a = "areaCatCode")
    public String mAreaCode;
    @b(a = "cinemaId")
    public String mCinemaID;
    @b(a = "pGroupCode")
    public String mPGroupCode;
    @b(a = "price")
    public double mPrice = -1.0d;
    @b(a = "typeCode")
    public String mTypeCode;
    @b(a = "tTypeDescription")
    public String mTypeDescription;
    @b(a = "voucher_price")
    public double mVoucherPrice;

    public int describeContents() {
        return 0;
    }

    public String getCinemaID() {
        return this.mCinemaID;
    }

    public String getPGroupCode() {
        return this.mPGroupCode;
    }

    public String getTypeCode() {
        return this.mTypeCode;
    }

    public String getAreaCode() {
        return this.mAreaCode;
    }

    public String getTypeDescription() {
        return this.mTypeDescription;
    }

    public double getPrice() {
        return this.mPrice;
    }

    public double getVoucherPrice() {
        return this.mVoucherPrice;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mCinemaID);
        parcel.writeString(this.mPGroupCode);
        parcel.writeString(this.mTypeCode);
        parcel.writeString(this.mAreaCode);
        parcel.writeString(this.mTypeDescription);
        parcel.writeDouble(this.mPrice);
        parcel.writeDouble(this.mVoucherPrice);
    }

    public CJRMoviesPriceDetails() {
    }

    protected CJRMoviesPriceDetails(Parcel parcel) {
        this.mCinemaID = parcel.readString();
        this.mPGroupCode = parcel.readString();
        this.mTypeCode = parcel.readString();
        this.mAreaCode = parcel.readString();
        this.mTypeDescription = parcel.readString();
        this.mPrice = parcel.readDouble();
        this.mVoucherPrice = parcel.readDouble();
    }
}
