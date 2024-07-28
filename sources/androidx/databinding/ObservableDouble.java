package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableDouble extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableDouble> CREATOR = new Parcelable.Creator<ObservableDouble>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ObservableDouble[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableDouble(parcel.readDouble());
        }
    };
    static final long serialVersionUID = 1;
    private double mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableDouble(double d2) {
        this.mValue = d2;
    }

    public ObservableDouble() {
    }

    public ObservableDouble(h... hVarArr) {
        super(hVarArr);
    }

    public double get() {
        return this.mValue;
    }

    public void set(double d2) {
        if (d2 != this.mValue) {
            this.mValue = d2;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeDouble(this.mValue);
    }
}
