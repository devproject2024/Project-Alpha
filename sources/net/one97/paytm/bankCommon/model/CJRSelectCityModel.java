package net.one97.paytm.bankCommon.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSelectCityModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRSelectCityModel> CREATOR = new Parcelable.Creator<CJRSelectCityModel>() {
        public final CJRSelectCityModel createFromParcel(Parcel parcel) {
            return new CJRSelectCityModel(parcel);
        }

        public final CJRSelectCityModel[] newArray(int i2) {
            return new CJRSelectCityModel[i2];
        }
    };
    private static final long serialVersionUID = 1;
    private boolean isHeaderShown;
    @b(a = "latitude")
    private String latitude;
    @b(a = "longitude")
    private String longitude;
    @b(a = "image")
    private String mCityImageUrl;
    @b(a = "hasEvents")
    private boolean mIsEventPresent;
    @b(a = "isTopCity")
    private boolean mIsTopCity;
    @b(a = "label")
    private String mLabel;
    @b(a = "searchKeys")
    private List<String> mSeachKeys;
    @b(a = "value")
    private String mValue;
    private String mViewType;
    @b(a = "translated")
    private CJRCityTranslationModel translated;

    public int describeContents() {
        return 0;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setlabel(String str) {
        this.mLabel = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public boolean isTopCity() {
        return this.mIsTopCity;
    }

    public void setIsTopCity(boolean z) {
        this.mIsTopCity = z;
    }

    public boolean isEventPresent() {
        return this.mIsEventPresent;
    }

    public void setEventPresent(boolean z) {
        this.mIsEventPresent = z;
    }

    public String getmCityImageUrl() {
        return this.mCityImageUrl;
    }

    public void setmCityImageUrl(String str) {
        this.mCityImageUrl = str;
    }

    public List<String> getmSeachKeys() {
        return this.mSeachKeys;
    }

    public void setmSeachKeys(List<String> list) {
        this.mSeachKeys = list;
    }

    public String getmViewType() {
        return this.mViewType;
    }

    public void setmViewType(String str) {
        this.mViewType = str;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public boolean isHeaderShown() {
        return this.isHeaderShown;
    }

    public void setHeaderShown(boolean z) {
        this.isHeaderShown = z;
    }

    public CJRCityTranslationModel getTranslated() {
        return this.translated;
    }

    public void setTranslated(CJRCityTranslationModel cJRCityTranslationModel) {
        this.translated = cJRCityTranslationModel;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mLabel);
        parcel.writeString(this.mValue);
        parcel.writeByte(this.mIsTopCity ? (byte) 1 : 0);
        parcel.writeByte(this.mIsEventPresent ? (byte) 1 : 0);
        parcel.writeString(this.mCityImageUrl);
        parcel.writeStringList(this.mSeachKeys);
        parcel.writeString(this.latitude);
        parcel.writeString(this.longitude);
        parcel.writeString(this.mViewType);
        parcel.writeByte(this.isHeaderShown ? (byte) 1 : 0);
        parcel.writeParcelable(this.translated, i2);
    }

    public CJRSelectCityModel() {
    }

    protected CJRSelectCityModel(Parcel parcel) {
        this.mLabel = parcel.readString();
        this.mValue = parcel.readString();
        boolean z = true;
        this.mIsTopCity = parcel.readByte() != 0;
        this.mIsEventPresent = parcel.readByte() != 0;
        this.mCityImageUrl = parcel.readString();
        this.mSeachKeys = parcel.createStringArrayList();
        this.latitude = parcel.readString();
        this.longitude = parcel.readString();
        this.mViewType = parcel.readString();
        this.isHeaderShown = parcel.readByte() == 0 ? false : z;
        this.translated = (CJRCityTranslationModel) parcel.readParcelable(CJRCityTranslationModel.class.getClassLoader());
    }
}
