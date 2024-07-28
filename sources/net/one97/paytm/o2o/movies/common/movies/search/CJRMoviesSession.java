package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviesSession extends IJRPaytmDataModel implements Parcelable, Comparable<CJRMoviesSession>, IJRDataModel {
    public static final Parcelable.Creator<CJRMoviesSession> CREATOR = new Parcelable.Creator<CJRMoviesSession>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMoviesSession[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMoviesSession(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    public String colorCode;
    @b(a = "display_premium_label")
    private int displayPremiumLabel;
    @b(a = "fid")
    private String frmtId;
    private int isCurrentSession = 0;
    @b(a = "is_premium")
    private int isPremium;
    @b(a = "address")
    private String mAddress;
    @b(a = "audi")
    private String mAudi;
    @b(a = "branchCode")
    private String mBranchCode;
    @b(a = "cinemaId")
    private String mCinemaID;
    @b(a = "cinemaName")
    private String mCinemaName;
    @b(a = "filmCode")
    private String mFilmCode;
    @b(a = "filmFirstShow")
    private String mFilmFirstShowDateTime;
    @b(a = "freeSeating")
    private boolean mFreeSeating;
    @b(a = "isFoodAvailable")
    private int mIsFoodAvailable;
    @b(a = "is_mandatory_voucher")
    private int mIsFoodMandatoryVoucer;
    @b(a = "is_show_popup")
    private boolean mIsShowPopup;
    @b(a = "latitude")
    private String mLatitude;
    @b(a = "longitude")
    private String mLongitude;
    @b(a = "maxTickets")
    private int mMaxTickets = 10;
    @b(a = "sessionDetails")
    private ArrayList<CJRMoviesSessionDetails> mMoviesSessionDetails;
    @b(a = "multipleEticket")
    private String mMultipleTickets;
    @b(a = "pGroupCode")
    private String mPGroupCode;
    @b(a = "providerId")
    private String mProviderId;
    /* access modifiers changed from: private */
    @b(a = "realShow")
    public String mRealShowDateTime;
    @b(a = "screenNum")
    private String mScreenNumber;
    @b(a = "screenOnTop")
    private int mScreenTop;
    @b(a = "seatsAvail")
    private int mSeatsAvailable;
    @b(a = "sessionId")
    private String mSessionID;
    @b(a = "tokenFeeOnly")
    private boolean mTokenFeeOnly;
    @b(a = "tokenFeePickupTime")
    private int mTokenFeePickupTime;
    @b(a = "message")
    private String mmFoodMandatoryMessage;
    @b(a = "movieCode")
    String movieCode;
    @b(a = "msg_id")
    private String msg_id;
    @b(a = "pkey")
    private String pKey;
    @b(a = "premium_label")
    private String premiumLabel;
    @b(a = "providerName")
    private String providerName;
    private String screenFormat;
    @b(a = "stype")
    private String stype;
    private String tempMoveCode;
    public int totalSeats = 0;
    @b(a = "translated")
    private CJRCinemaTranslationModel2 translated;

    public int compareTo(CJRMoviesSession cJRMoviesSession) {
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public String getFrmtId() {
        return this.frmtId;
    }

    public void setFrmtId(String str) {
        this.frmtId = str;
    }

    protected CJRMoviesSession(Parcel parcel) {
        boolean z = false;
        this.mCinemaID = parcel.readString();
        this.totalSeats = parcel.readInt();
        this.mCinemaName = parcel.readString();
        this.mLatitude = parcel.readString();
        this.mLongitude = parcel.readString();
        this.mAddress = parcel.readString();
        this.mBranchCode = parcel.readString();
        this.mMultipleTickets = parcel.readString();
        this.mScreenTop = parcel.readInt();
        this.mSessionID = parcel.readString();
        this.mFilmCode = parcel.readString();
        this.mScreenNumber = parcel.readString();
        this.mRealShowDateTime = parcel.readString();
        this.mPGroupCode = parcel.readString();
        this.mSeatsAvailable = parcel.readInt();
        this.mFilmFirstShowDateTime = parcel.readString();
        this.mAudi = parcel.readString();
        this.mProviderId = parcel.readString();
        this.mFreeSeating = parcel.readByte() != 0;
        this.mTokenFeeOnly = parcel.readByte() != 0;
        this.mTokenFeePickupTime = parcel.readInt();
        this.mMaxTickets = parcel.readInt();
        this.mMoviesSessionDetails = parcel.createTypedArrayList(CJRMoviesSessionDetails.CREATOR);
        this.mIsFoodAvailable = parcel.readInt();
        this.mIsShowPopup = parcel.readByte() != 0 ? true : z;
        this.msg_id = parcel.readString();
        this.stype = parcel.readString();
        this.movieCode = parcel.readString();
        this.translated = (CJRCinemaTranslationModel2) parcel.readParcelable(CJRCinemaTranslationModel2.class.getClassLoader());
        this.providerName = parcel.readString();
        this.isCurrentSession = parcel.readInt();
        this.frmtId = parcel.readString();
        this.isPremium = parcel.readInt();
        this.premiumLabel = parcel.readString();
        this.displayPremiumLabel = parcel.readInt();
        this.colorCode = parcel.readString();
        this.tempMoveCode = parcel.readString();
        this.mIsFoodMandatoryVoucer = parcel.readInt();
        this.mmFoodMandatoryMessage = parcel.readString();
        this.screenFormat = parcel.readString();
        this.pKey = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mCinemaID);
        parcel.writeInt(this.totalSeats);
        parcel.writeString(this.mCinemaName);
        parcel.writeString(this.mLatitude);
        parcel.writeString(this.mLongitude);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mBranchCode);
        parcel.writeString(this.mMultipleTickets);
        parcel.writeInt(this.mScreenTop);
        parcel.writeString(this.mSessionID);
        parcel.writeString(this.mFilmCode);
        parcel.writeString(this.mScreenNumber);
        parcel.writeString(this.mRealShowDateTime);
        parcel.writeString(this.mPGroupCode);
        parcel.writeInt(this.mSeatsAvailable);
        parcel.writeString(this.mFilmFirstShowDateTime);
        parcel.writeString(this.mAudi);
        parcel.writeString(this.mProviderId);
        parcel.writeByte(this.mFreeSeating ? (byte) 1 : 0);
        parcel.writeByte(this.mTokenFeeOnly ? (byte) 1 : 0);
        parcel.writeInt(this.mTokenFeePickupTime);
        parcel.writeInt(this.mMaxTickets);
        parcel.writeTypedList(this.mMoviesSessionDetails);
        parcel.writeInt(this.mIsFoodAvailable);
        parcel.writeByte(this.mIsShowPopup ? (byte) 1 : 0);
        parcel.writeString(this.msg_id);
        parcel.writeString(this.stype);
        parcel.writeString(this.movieCode);
        parcel.writeParcelable(this.translated, i2);
        parcel.writeString(this.providerName);
        parcel.writeInt(this.isCurrentSession);
        parcel.writeString(this.frmtId);
        parcel.writeInt(this.isPremium);
        parcel.writeString(this.premiumLabel);
        parcel.writeInt(this.displayPremiumLabel);
        parcel.writeString(this.colorCode);
        parcel.writeString(this.tempMoveCode);
        parcel.writeInt(this.mIsFoodMandatoryVoucer);
        parcel.writeString(this.mmFoodMandatoryMessage);
        parcel.writeString(this.screenFormat);
        parcel.writeString(this.pKey);
    }

    public String getpKey() {
        return this.pKey;
    }

    public void setpKey(String str) {
        this.pKey = str;
    }

    public int getIsPremium() {
        return this.isPremium;
    }

    public int getDisplayPremiumLabel() {
        return this.displayPremiumLabel;
    }

    public String getPremiumLabel() {
        return this.premiumLabel;
    }

    public void setIsPremium(int i2) {
        this.isPremium = i2;
    }

    public void setmCinemaID(String str) {
        this.mCinemaID = str;
    }

    public void setmCinemaName(String str) {
        this.mCinemaName = str;
    }

    public void setmAddress(String str) {
        this.mAddress = str;
    }

    public void setmBranchCode(String str) {
        this.mBranchCode = str;
    }

    public void setmMultipleTickets(String str) {
        this.mMultipleTickets = str;
    }

    public void setmScreenTop(int i2) {
        this.mScreenTop = i2;
    }

    public void setmSessionID(String str) {
        this.mSessionID = str;
    }

    public void setmFilmCode(String str) {
        this.mFilmCode = str;
    }

    public void setmScreenNumber(String str) {
        this.mScreenNumber = str;
    }

    public void setmRealShowDateTime(String str) {
        this.mRealShowDateTime = str;
    }

    public void setmPGroupCode(String str) {
        this.mPGroupCode = str;
    }

    public void setmSeatsAvailable(int i2) {
        this.mSeatsAvailable = i2;
    }

    public void setmFilmFirstShowDateTime(String str) {
        this.mFilmFirstShowDateTime = str;
    }

    public void setmAudi(String str) {
        this.mAudi = str;
    }

    public void setmProviderId(String str) {
        this.mProviderId = str;
    }

    public void setmFreeSeating(boolean z) {
        this.mFreeSeating = z;
    }

    public void setmTokenFeeOnly(boolean z) {
        this.mTokenFeeOnly = z;
    }

    public void setmTokenFeePickupTime(int i2) {
        this.mTokenFeePickupTime = i2;
    }

    public void setmMaxTickets(int i2) {
        this.mMaxTickets = i2;
    }

    public void setmMoviesSessionDetails(ArrayList<CJRMoviesSessionDetails> arrayList) {
        this.mMoviesSessionDetails = arrayList;
    }

    public void setMsg_id(String str) {
        this.msg_id = str;
    }

    public void setStype(String str) {
        this.stype = str;
    }

    public void setIsCurrentSession(int i2) {
        this.isCurrentSession = i2;
    }

    public void setPremiumLabel(String str) {
        this.premiumLabel = str;
    }

    public void setDisplayPremiumLabel(int i2) {
        this.displayPremiumLabel = i2;
    }

    public void setTempMoveCode(String str) {
        this.tempMoveCode = str;
    }

    public int getmIsFoodMandatoryVoucer() {
        return this.mIsFoodMandatoryVoucer;
    }

    public void setmIsFoodMandatoryVoucer(int i2) {
        this.mIsFoodMandatoryVoucer = i2;
    }

    public String getMmFoodMandatoryMessage() {
        return this.mmFoodMandatoryMessage;
    }

    public void setMmFoodMandatoryMessage(String str) {
        this.mmFoodMandatoryMessage = str;
    }

    public int getmIsFoodAvailable() {
        return this.mIsFoodAvailable;
    }

    public void setmIsFoodAvailable(int i2) {
        this.mIsFoodAvailable = i2;
    }

    public boolean getmIsShowPopup() {
        return this.mIsShowPopup;
    }

    public void setmIsShowPopup(boolean z) {
        this.mIsShowPopup = z;
    }

    public String getCinemaID() {
        return this.mCinemaID;
    }

    public String getCinemaName() {
        return this.mCinemaName;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getBranchCode() {
        return this.mBranchCode;
    }

    public String getMultipleTickets() {
        return this.mMultipleTickets;
    }

    public int getScreenTop() {
        return this.mScreenTop;
    }

    public String getSessionID() {
        return this.mSessionID;
    }

    public String getFilmCode() {
        return this.mFilmCode;
    }

    public String getScreenNumber() {
        return this.mScreenNumber;
    }

    public String getRealShowDateTime() {
        return this.mRealShowDateTime;
    }

    public Date getRealDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return simpleDateFormat.parse(this.mRealShowDateTime);
        } catch (ParseException unused) {
            return null;
        }
    }

    public String getPGroupCode() {
        return this.mPGroupCode;
    }

    public int getSeatsAvailable() {
        return this.mSeatsAvailable;
    }

    public String getFilmFirstShowDateTime() {
        return this.mFilmFirstShowDateTime;
    }

    public ArrayList<CJRMoviesSessionDetails> getMoviesSessionDetails() {
        return this.mMoviesSessionDetails;
    }

    public String getmLatitude() {
        return this.mLatitude;
    }

    public void setmLatitude(String str) {
        this.mLatitude = str;
    }

    public String getmLongitude() {
        return this.mLongitude;
    }

    public void setmLongitude(String str) {
        this.mLongitude = str;
    }

    public String getStype() {
        return this.stype;
    }

    public static class a implements Comparator<CJRMoviesSession> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((CJRMoviesSession) obj).mRealShowDateTime.compareTo(((CJRMoviesSession) obj2).mRealShowDateTime);
        }
    }

    public String getAudi() {
        return this.mAudi;
    }

    public String getProviderId() {
        return this.mProviderId;
    }

    public boolean isFreeSeating() {
        return this.mFreeSeating;
    }

    public boolean isTokenFeeOnly() {
        return this.mTokenFeeOnly;
    }

    public int getTokenFeePickupTime() {
        return this.mTokenFeePickupTime;
    }

    public int getMaxTickets() {
        return this.mMaxTickets;
    }

    public String getMsgId() {
        return this.msg_id;
    }

    public String getMovieCode() {
        return this.movieCode;
    }

    public void setMovieCode(String str) {
        this.movieCode = str;
    }

    public CJRMoviesSession transform(String str) {
        this.tempMoveCode = str;
        return this;
    }

    public String getScreenFormat() {
        return this.screenFormat;
    }

    public void setScreenFormat(String str) {
        this.screenFormat = str;
    }

    public int getTotalSeats() {
        ArrayList<CJRMoviesSessionDetails> arrayList = this.mMoviesSessionDetails;
        if (arrayList == null) {
            return 0;
        }
        Iterator<CJRMoviesSessionDetails> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.totalSeats += it2.next().getTotalSeats();
        }
        return this.totalSeats;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public String getTempMoveCode() {
        return this.tempMoveCode;
    }

    public CJRCinemaTranslationModel2 getTranslated() {
        return this.translated;
    }

    public void setTranslated(CJRCinemaTranslationModel2 cJRCinemaTranslationModel2) {
        this.translated = cJRCinemaTranslationModel2;
    }

    public int isCurrentSession() {
        return this.isCurrentSession;
    }

    public void setCurrentSession(int i2) {
        this.isCurrentSession = i2;
    }

    public CJRMoviesSession() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CJRMoviesSession)) {
            return false;
        }
        return this.mSessionID.equalsIgnoreCase(((CJRMoviesSession) obj).mSessionID);
    }
}
