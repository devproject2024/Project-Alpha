package net.one97.paytm.o2o.movies.common.movies.seats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAreas implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRAreas> CREATOR = new Parcelable.Creator<CJRAreas>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRAreas[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRAreas(parcel);
        }
    };
    @b(a = "AreaCode")
    private String areaCode;
    @b(a = "AreaDesc")
    private String areaDesc;
    @b(a = "available")
    private int available;

    public int describeContents() {
        return 0;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public String getAreaDesc() {
        return this.areaDesc;
    }

    public int getAvailable() {
        return this.available;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.areaCode);
        parcel.writeString(this.areaDesc);
        parcel.writeInt(this.available);
    }

    public CJRAreas() {
    }

    protected CJRAreas(Parcel parcel) {
        this.areaCode = parcel.readString();
        this.areaDesc = parcel.readString();
        this.available = parcel.readInt();
    }
}
