package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmenity implements Parcelable, Comparable, IJRDataModel {
    public static final Parcelable.Creator<CJRAmenity> CREATOR = new Parcelable.Creator<CJRAmenity>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRAmenity[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRAmenity(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    @b(a = "amenity")
    private String amenity;
    @b(a = "amenity_id")
    private int amenityId;
    @b(a = "rank")
    public int rank;
    @b(a = "status")
    private int status;

    public int describeContents() {
        return 0;
    }

    public CJRAmenity() {
    }

    protected CJRAmenity(Parcel parcel) {
        this.amenityId = parcel.readInt();
        this.rank = parcel.readInt();
        this.status = parcel.readInt();
        this.amenity = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.amenityId);
        parcel.writeInt(this.rank);
        parcel.writeInt(this.status);
        parcel.writeString(this.amenity);
    }

    public int getAmenityId() {
        return this.amenityId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getAmenity() {
        return this.amenity;
    }

    public void setAmenityId(int i2) {
        this.amenityId = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setAmenity(String str) {
        this.amenity = str;
    }

    public int compareTo(Object obj) {
        if (obj instanceof CJRAmenity) {
            return ((CJRAmenity) obj).rank - this.rank;
        }
        return -1;
    }
}
