package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget;
import net.one97.paytm.o2o.movies.entity.Promo;

public class CJRCinemaV2 implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRCinemaV2> CREATOR = new Parcelable.Creator<CJRCinemaV2>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRCinemaV2[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRCinemaV2(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String address;
    @b(a = "amenities")
    public ArrayList<CJRAmenity> amenities;
    @b(a = "appCoverImageUrl")
    private String appCoverImageUrl;
    @b(a = "coverImageUrl")
    private String coverImageUrl;
    @b(a = "id")
    private String id;
    private boolean itemViewed;
    @b(a = "latitude")
    private double latitude;
    @b(a = "longitude")
    private double longitude;
    @b(a = "movies")
    private List<String> movies = null;
    @b(a = "name")
    private String name;
    public ArrayList<Promo> offerList;
    @b(a = "pkey")
    private String pKey;
    @b(a = "providerChain")
    private String providerChain;
    @b(a = "providerId")
    private Integer providerId;
    @b(a = "providerName")
    private String providerName;
    @b(a = "providerType")
    private String providerType;
    @b(a = "subCity")
    private String subCity;
    @b(a = "translated")
    private CJRCinemaTranslationModel translated;
    @b(a = "widgets")
    private CJRMovieWidget widgets;

    public int describeContents() {
        return 0;
    }

    public List<CJRAmenity> getAmenities() {
        return this.amenities;
    }

    public void setAmenities(ArrayList<CJRAmenity> arrayList) {
        this.amenities = arrayList;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Integer getProviderId() {
        return this.providerId;
    }

    public void setProviderId(Integer num) {
        this.providerId = num;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public String getProviderType() {
        return this.providerType;
    }

    public void setProviderType(String str) {
        this.providerType = str;
    }

    public String getProviderChain() {
        return this.providerChain;
    }

    public void setProviderChain(String str) {
        this.providerChain = str;
    }

    public List<String> getMovies() {
        return this.movies;
    }

    public void setMovies(List<String> list) {
        this.movies = list;
    }

    public String getSubCity() {
        return this.subCity;
    }

    public void setSubCity(String str) {
        this.subCity = str;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public void setItemViewed() {
        this.itemViewed = true;
    }

    public boolean isItemViewed() {
        return this.itemViewed;
    }

    public String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public void setCoverImageUrl(String str) {
        this.coverImageUrl = str;
    }

    public String getAppCoverImageUrl() {
        return this.appCoverImageUrl;
    }

    public void setAppCoverImageUrl(String str) {
        this.appCoverImageUrl = str;
    }

    public CJRMovieWidget getWidgets() {
        return this.widgets;
    }

    public void setWidgets(CJRMovieWidget cJRMovieWidget) {
        this.widgets = cJRMovieWidget;
    }

    public CJRCinemaTranslationModel getTranslated() {
        return this.translated;
    }

    public void setTranslated(CJRCinemaTranslationModel cJRCinemaTranslationModel) {
        this.translated = cJRCinemaTranslationModel;
    }

    public String getpKey() {
        return this.pKey;
    }

    public void setpKey(String str) {
        this.pKey = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeValue(this.providerId);
        parcel.writeString(this.providerName);
        parcel.writeString(this.providerType);
        parcel.writeString(this.providerChain);
        parcel.writeStringList(this.movies);
        parcel.writeString(this.subCity);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.address);
        parcel.writeString(this.coverImageUrl);
        parcel.writeString(this.appCoverImageUrl);
        parcel.writeSerializable(this.widgets);
        parcel.writeByte(this.itemViewed ? (byte) 1 : 0);
        parcel.writeParcelable(this.translated, i2);
        parcel.writeString(this.pKey);
    }

    public CJRCinemaV2() {
    }

    protected CJRCinemaV2(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.providerId = Integer.valueOf(parcel.readInt());
        this.providerName = parcel.readString();
        this.providerType = parcel.readString();
        this.providerChain = parcel.readString();
        this.movies = parcel.createStringArrayList();
        this.subCity = parcel.readString();
        this.latitude = (double) parcel.readLong();
        this.longitude = (double) parcel.readLong();
        this.address = parcel.readString();
        this.coverImageUrl = parcel.readString();
        this.appCoverImageUrl = parcel.readString();
        this.widgets = (CJRMovieWidget) parcel.readSerializable();
        this.itemViewed = parcel.readByte() != 0;
        this.translated = (CJRCinemaTranslationModel) parcel.readParcelable(CJRCinemaTranslationModel.class.getClassLoader());
        this.pKey = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof CJRCinemaV2) {
            return ((CJRCinemaV2) obj).id.equalsIgnoreCase(this.id);
        }
        return false;
    }
}
