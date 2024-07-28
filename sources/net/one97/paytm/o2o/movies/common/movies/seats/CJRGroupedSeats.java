package net.one97.paytm.o2o.movies.common.movies.seats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGroupedSeats implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRGroupedSeats> CREATOR = new Parcelable.Creator<CJRGroupedSeats>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRGroupedSeats[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRGroupedSeats(parcel);
        }
    };
    @b(a = "AreaNum")
    private String areaNum;
    @b(a = "GridRowId")
    private int gridRowId;
    @b(a = "GridSeatNum")
    private int gridSeatNum;

    public int describeContents() {
        return 0;
    }

    public String getAreaNum() {
        return this.areaNum;
    }

    public int getGridRowId() {
        return this.gridRowId;
    }

    public int getGridSeatNum() {
        return this.gridSeatNum;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.areaNum);
        parcel.writeInt(this.gridRowId);
        parcel.writeInt(this.gridSeatNum);
    }

    public CJRGroupedSeats() {
    }

    protected CJRGroupedSeats(Parcel parcel) {
        this.areaNum = parcel.readString();
        this.gridRowId = parcel.readInt();
        this.gridSeatNum = parcel.readInt();
    }
}
