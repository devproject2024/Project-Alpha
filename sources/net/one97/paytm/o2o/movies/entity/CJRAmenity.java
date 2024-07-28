package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRAmenity implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "name")
    private String amenity;
    @b(a = "id")
    private Integer amenityId;
    @b(a = "rank")
    private Integer rank;
    @b(a = "status")
    private String status;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            Integer num = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new CJRAmenity(valueOf, readString, readString2, num);
        }

        public final Object[] newArray(int i2) {
            return new CJRAmenity[i2];
        }
    }

    public CJRAmenity() {
        this((Integer) null, (String) null, (String) null, (Integer) null, 15, (g) null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        Integer num = this.amenityId;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.status);
        parcel.writeString(this.amenity);
        Integer num2 = this.rank;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
            return;
        }
        parcel.writeInt(0);
    }

    public CJRAmenity(Integer num, String str, String str2, Integer num2) {
        this.amenityId = num;
        this.status = str;
        this.amenity = str2;
        this.rank = num2;
    }

    public final Integer getAmenityId() {
        return this.amenityId;
    }

    public final void setAmenityId(Integer num) {
        this.amenityId = num;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getAmenity() {
        return this.amenity;
    }

    public final void setAmenity(String str) {
        this.amenity = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAmenity(Integer num, String str, String str2, Integer num2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? -1 : num2);
    }

    public final Integer getRank() {
        return this.rank;
    }

    public final void setRank(Integer num) {
        this.rank = num;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == null || !(obj instanceof CJRAmenity) || (num = this.amenityId) == null) {
            return false;
        }
        if (num == null) {
            k.a();
        }
        return num.equals(((CJRAmenity) obj).amenityId);
    }

    public final int hashCode() {
        Integer num = this.amenityId;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
