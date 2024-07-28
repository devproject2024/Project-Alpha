package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovies implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMovies> CREATOR = new Parcelable.Creator<CJRMovies>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovies[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovies(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    private boolean gridItemViewed;
    private boolean itemViewed;
    @b(a = "app_cover_url")
    private String mAppCoverUrl;
    @b(a = "catName")
    private String mCatName;
    @b(a = "censor")
    private String mCensor;
    @b(a = "code")
    private String mCode;
    @b(a = "content")
    private String mContent;
    @b(a = "openingDate")
    private String mDate;
    @b(a = "display")
    private String mDisplay;
    @b(a = "duration")
    private int mDuration;
    @b(a = "image_url")
    private String mImageURL;
    @b(a = "language")
    private String mLanguage;
    @b(a = "sessions")
    private ArrayList<CJRMoviesSession> mMoviesSession;
    @b(a = "providerName")
    private String mProviderName;
    @b(a = "title")
    private String mTitle;
    @b(a = "urlForTrailer")
    private String mTrailerURL;
    @b(a = "genre")
    private String mgenre;
    private double rating = -1.0d;

    public int describeContents() {
        return 0;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double d2) {
        this.rating = d2;
    }

    public String getCode() {
        return this.mCode;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public String getImageURL() {
        return this.mImageURL;
    }

    public String getDisplay() {
        return this.mDisplay;
    }

    public String getTitle() {
        String str = this.mTitle;
        return str != null ? str : "";
    }

    public String getCensor() {
        return this.mCensor;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getCatName() {
        return this.mCatName;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public String getTrailerURL() {
        return this.mTrailerURL;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getDate() {
        return this.mDate;
    }

    public ArrayList<CJRMoviesSession> getMoviesSession() {
        return this.mMoviesSession;
    }

    public void setImageURL(String str) {
        this.mImageURL = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setCensor(String str) {
        this.mCensor = str;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setItemViewed() {
        this.itemViewed = true;
    }

    public boolean isItemViewed() {
        return this.itemViewed;
    }

    public boolean isGridItemViewed() {
        return this.gridItemViewed;
    }

    public void setGridItemViewed() {
        this.gridItemViewed = true;
    }

    public String getAppCoverUrl() {
        return this.mAppCoverUrl;
    }

    public String getMgenre() {
        return this.mgenre;
    }

    public void setMgenre(String str) {
        this.mgenre = str;
    }

    public void setDuration(int i2) {
        this.mDuration = i2;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mCode);
        parcel.writeString(this.mProviderName);
        parcel.writeString(this.mImageURL);
        parcel.writeString(this.mDisplay);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mCensor);
        parcel.writeString(this.mContent);
        parcel.writeString(this.mCatName);
        parcel.writeInt(this.mDuration);
        parcel.writeString(this.mTrailerURL);
        parcel.writeString(this.mLanguage);
        parcel.writeString(this.mDate);
        parcel.writeTypedList(this.mMoviesSession);
        parcel.writeString(this.mAppCoverUrl);
        parcel.writeString(this.mgenre);
        parcel.writeByte(this.itemViewed ? (byte) 1 : 0);
        parcel.writeByte(this.gridItemViewed ? (byte) 1 : 0);
        parcel.writeDouble(this.rating);
    }

    public CJRMovies() {
    }

    protected CJRMovies(Parcel parcel) {
        this.mCode = parcel.readString();
        this.mProviderName = parcel.readString();
        this.mImageURL = parcel.readString();
        this.mDisplay = parcel.readString();
        this.mTitle = parcel.readString();
        this.mCensor = parcel.readString();
        this.mContent = parcel.readString();
        this.mCatName = parcel.readString();
        this.mDuration = parcel.readInt();
        this.mTrailerURL = parcel.readString();
        this.mLanguage = parcel.readString();
        this.mDate = parcel.readString();
        this.mMoviesSession = parcel.createTypedArrayList(CJRMoviesSession.CREATOR);
        this.mAppCoverUrl = parcel.readString();
        this.mgenre = parcel.readString();
        boolean z = true;
        this.itemViewed = parcel.readByte() != 0;
        this.gridItemViewed = parcel.readByte() == 0 ? false : z;
        this.rating = parcel.readDouble();
    }
}
