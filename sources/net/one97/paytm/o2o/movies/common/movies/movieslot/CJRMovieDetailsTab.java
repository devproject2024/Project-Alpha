package net.one97.paytm.o2o.movies.common.movies.movieslot;

import android.os.Parcel;
import android.os.Parcelable;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieDetailsTab implements Parcelable, Comparable<CJRMovieDetailsTab>, IJRDataModel {
    public static final Parcelable.Creator<CJRMovieDetailsTab> CREATOR = new Parcelable.Creator<CJRMovieDetailsTab>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieDetailsTab[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieDetailsTab(parcel);
        }
    };
    private String mDate;
    private String mDateTime;
    private String mDay;
    private String mDayName;

    public int compareTo(CJRMovieDetailsTab cJRMovieDetailsTab) {
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public String getmDate() {
        return this.mDate;
    }

    public void setmDate(String str) {
        this.mDate = str;
    }

    public String getmDay() {
        return this.mDay;
    }

    public void setmDay(String str) {
        this.mDay = str;
    }

    public String getmDayName() {
        return this.mDayName;
    }

    public void setmDayName(String str) {
        this.mDayName = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mDate);
        parcel.writeString(this.mDay);
        parcel.writeString(this.mDayName);
        parcel.writeString(this.mDateTime);
    }

    public CJRMovieDetailsTab() {
    }

    protected CJRMovieDetailsTab(Parcel parcel) {
        this.mDate = parcel.readString();
        this.mDay = parcel.readString();
        this.mDayName = parcel.readString();
        this.mDateTime = parcel.readString();
    }
}
