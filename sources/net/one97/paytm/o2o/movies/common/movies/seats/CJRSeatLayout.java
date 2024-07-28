package net.one97.paytm.o2o.movies.common.movies.seats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSeatLayout implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRSeatLayout> CREATOR = new Parcelable.Creator<CJRSeatLayout>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRSeatLayout[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRSeatLayout(parcel);
        }
    };
    @b(a = "colAreas")
    private CJRColAreas CJRColAreas;

    public int describeContents() {
        return 0;
    }

    public CJRColAreas getColAreas() {
        return this.CJRColAreas;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSerializable(this.CJRColAreas);
    }

    public CJRSeatLayout() {
    }

    protected CJRSeatLayout(Parcel parcel) {
        this.CJRColAreas = (CJRColAreas) parcel.readSerializable();
    }
}
