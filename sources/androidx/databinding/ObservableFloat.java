package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableFloat extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new Parcelable.Creator<ObservableFloat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ObservableFloat[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableFloat(parcel.readFloat());
        }
    };
    static final long serialVersionUID = 1;
    private float mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableFloat(float f2) {
        this.mValue = f2;
    }

    public ObservableFloat() {
    }

    public ObservableFloat(h... hVarArr) {
        super(hVarArr);
    }

    public float get() {
        return this.mValue;
    }

    public void set(float f2) {
        if (f2 != this.mValue) {
            this.mValue = f2;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.mValue);
    }
}
