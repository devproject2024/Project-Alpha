package net.one97.paytm.o2o.movies.common.movies.movieslot;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaTranslationModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaTranslationModel2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieRatings;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.utils.ae;

public class CJRMovieSessionDetails implements Parcelable, Serializable, Comparable<CJRMovieSessionDetails> {
    public static final Parcelable.Creator<CJRMovieSessionDetails> CREATOR = new Parcelable.Creator<CJRMovieSessionDetails>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieSessionDetails[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieSessionDetails(parcel);
        }
    };
    private int duration;
    private int isContentAvailable;
    public boolean isSearchView;
    private String mCensor;
    private String mImageUrl;
    private String mLanguage;
    private double mLatitude;
    private String mLocalizedCinemaName;
    private String mLocalizedLanguage;
    private String mLocalizedMovieDisplay;
    private double mLogitude;
    private ArrayList<CJRMoviesSession> mMoviesSession;
    private CJRCinemaTranslationModel mTranslated;
    private CJRCinemaTranslationModel2 mTranslated2;
    private String mcinemaName;
    private String mcinemaid;
    private double mdistance;
    private String mmoviecode;
    private String mmovietitle;
    private int mno_of_sessions;
    private CJRMovieRatings ratings;
    private String screenFormat;
    private float setDistanceKm;

    public int compareTo(CJRMovieSessionDetails cJRMovieSessionDetails) {
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public CJRMovieSessionDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, int i3, String str11, ArrayList<CJRMoviesSession> arrayList, CJRCinemaTranslationModel cJRCinemaTranslationModel, int i4, CJRMovieRatings cJRMovieRatings, double d2, double d3) {
        this.mcinemaName = str;
        this.mLocalizedCinemaName = str2;
        this.mmoviecode = str3;
        this.mImageUrl = str4;
        this.mCensor = str5;
        this.mLanguage = str6;
        this.mLocalizedLanguage = str7;
        this.mcinemaid = str8;
        this.mmovietitle = str9;
        this.mLocalizedMovieDisplay = str10;
        this.mno_of_sessions = i2;
        this.duration = i3;
        this.screenFormat = str11;
        this.mMoviesSession = arrayList;
        this.mTranslated = cJRCinemaTranslationModel;
        this.isContentAvailable = i4;
        this.ratings = cJRMovieRatings;
        this.mLatitude = d2;
        this.mLogitude = d3;
    }

    public CJRMovieSessionDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, int i3, String str10, ArrayList<CJRMoviesSession> arrayList, CJRCinemaTranslationModel2 cJRCinemaTranslationModel2, int i4, CJRMovieRatings cJRMovieRatings, String str11, String str12) {
        this.mcinemaName = str;
        this.mmoviecode = str2;
        this.mImageUrl = str3;
        this.mCensor = str4;
        this.mLanguage = str5;
        this.mLocalizedLanguage = str6;
        this.mcinemaid = str7;
        this.mmovietitle = str8;
        this.mLocalizedMovieDisplay = str9;
        this.mno_of_sessions = i2;
        this.duration = i3;
        this.screenFormat = str10;
        this.mMoviesSession = arrayList;
        this.mTranslated2 = cJRCinemaTranslationModel2;
        this.isContentAvailable = i4;
        this.ratings = cJRMovieRatings;
        this.mLatitude = ae.a(str11).doubleValue();
        this.mLogitude = ae.a(str12).doubleValue();
    }

    protected CJRMovieSessionDetails(Parcel parcel) {
        this.setDistanceKm = parcel.readFloat();
        this.mLatitude = parcel.readDouble();
        this.mLogitude = parcel.readDouble();
        this.mcinemaName = parcel.readString();
        this.mLocalizedCinemaName = parcel.readString();
        this.mmoviecode = parcel.readString();
        this.mImageUrl = parcel.readString();
        this.mCensor = parcel.readString();
        this.mLanguage = parcel.readString();
        this.mLocalizedLanguage = parcel.readString();
        this.mdistance = parcel.readDouble();
        this.mcinemaid = parcel.readString();
        this.mmovietitle = parcel.readString();
        this.mLocalizedMovieDisplay = parcel.readString();
        this.mno_of_sessions = parcel.readInt();
        this.mMoviesSession = parcel.createTypedArrayList(CJRMoviesSession.CREATOR);
        this.duration = parcel.readInt();
        this.screenFormat = parcel.readString();
        this.mTranslated = (CJRCinemaTranslationModel) parcel.readParcelable(CJRCinemaTranslationModel.class.getClassLoader());
        this.mTranslated2 = (CJRCinemaTranslationModel2) parcel.readParcelable(CJRCinemaTranslationModel2.class.getClassLoader());
        this.ratings = (CJRMovieRatings) parcel.readParcelable(CJRMovieRatings.class.getClassLoader());
        this.isContentAvailable = parcel.readInt();
        this.isSearchView = parcel.readByte() != 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.setDistanceKm);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLogitude);
        parcel.writeString(this.mcinemaName);
        parcel.writeString(this.mLocalizedCinemaName);
        parcel.writeString(this.mmoviecode);
        parcel.writeString(this.mImageUrl);
        parcel.writeString(this.mCensor);
        parcel.writeString(this.mLanguage);
        parcel.writeString(this.mLocalizedLanguage);
        parcel.writeDouble(this.mdistance);
        parcel.writeString(this.mcinemaid);
        parcel.writeString(this.mmovietitle);
        parcel.writeString(this.mLocalizedMovieDisplay);
        parcel.writeInt(this.mno_of_sessions);
        parcel.writeTypedList(this.mMoviesSession);
        parcel.writeInt(this.duration);
        parcel.writeString(this.screenFormat);
        parcel.writeParcelable(this.mTranslated, i2);
        parcel.writeParcelable(this.mTranslated2, i2);
        parcel.writeParcelable(this.ratings, i2);
        parcel.writeInt(this.isContentAvailable);
        parcel.writeByte(this.isSearchView ? (byte) 1 : 0);
    }

    public float getDistanceKm() {
        return this.setDistanceKm;
    }

    public void setDistanceKm(float f2) {
        this.setDistanceKm = f2;
    }

    public double getmLatitude() {
        return this.mLatitude;
    }

    public void setmLatitude(long j) {
        this.mLatitude = (double) j;
    }

    public double getmLogitude() {
        return this.mLogitude;
    }

    public void setmLogitude(long j) {
        this.mLogitude = (double) j;
    }

    public CJRMovieRatings getRatings() {
        return this.ratings;
    }

    public void setRatings(CJRMovieRatings cJRMovieRatings) {
        this.ratings = cJRMovieRatings;
    }

    public ArrayList<CJRMoviesSession> getmMoviesSession() {
        return this.mMoviesSession;
    }

    public void setmMoviesSession(ArrayList<CJRMoviesSession> arrayList) {
        this.mMoviesSession = arrayList;
    }

    public String getMcinemaName() {
        return this.mcinemaName;
    }

    public void setMcinemaName(String str) {
        this.mcinemaName = str;
    }

    public String getmImageUrl() {
        return this.mImageUrl;
    }

    public void setmImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getmCensor() {
        return this.mCensor;
    }

    public void setmCensor(String str) {
        this.mCensor = str;
    }

    public String getmLanguage() {
        return this.mLanguage;
    }

    public void setmLanguage(String str) {
        this.mLanguage = str;
    }

    public double getMdistance() {
        return this.mdistance;
    }

    public void setMdistance(double d2) {
        this.mdistance = d2;
    }

    public String getMcinemaid() {
        return this.mcinemaid;
    }

    public void setMcinemaid(String str) {
        this.mcinemaid = str;
    }

    public String getMmoviecode() {
        return this.mmoviecode;
    }

    public void setMmoviecode(String str) {
        this.mmoviecode = str;
    }

    public int getMno_of_sessions() {
        return this.mno_of_sessions;
    }

    public void setMno_of_sessions(int i2) {
        this.mno_of_sessions = i2;
    }

    public String getMmovietitle() {
        return this.mmovietitle;
    }

    public void setMmovietitle(String str) {
        this.mmovietitle = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public String getScreenFormat() {
        return this.screenFormat;
    }

    public void setScreenFormat(String str) {
        this.screenFormat = str;
    }

    public String getmLocalizedCinemaName() {
        return this.mLocalizedCinemaName;
    }

    public void setmLocalizedCinemaName(String str) {
        this.mLocalizedCinemaName = str;
    }

    public String getmLocalizedLanguage() {
        return this.mLocalizedLanguage;
    }

    public void setmLocalizedLanguage(String str) {
        this.mLocalizedLanguage = str;
    }

    public String getmLocalizedMovieDisplay() {
        return this.mLocalizedMovieDisplay;
    }

    public void setmLocalizedMovieDisplay(String str) {
        this.mLocalizedMovieDisplay = str;
    }

    public CJRCinemaTranslationModel getmTranslated() {
        return this.mTranslated;
    }

    public void setmTranslated(CJRCinemaTranslationModel cJRCinemaTranslationModel) {
        this.mTranslated = cJRCinemaTranslationModel;
    }

    public int getIsContentAvailable() {
        return this.isContentAvailable;
    }

    public void setIsContentAvailable(int i2) {
        this.isContentAvailable = i2;
    }

    public CJRMovieSessionDetails() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof CJRMovieSessionDetails) {
            return ((CJRMovieSessionDetails) obj).mcinemaid.equalsIgnoreCase(this.mcinemaid);
        }
        return super.equals(obj);
    }
}
