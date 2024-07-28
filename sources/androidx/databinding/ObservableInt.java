package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableInt extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new Parcelable.Creator<ObservableInt>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ObservableInt[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableInt(parcel.readInt());
        }
    };
    static final long serialVersionUID = 1;
    private int mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableInt(int i2) {
        this.mValue = i2;
    }

    public ObservableInt() {
    }

    public ObservableInt(h... hVarArr) {
        super(hVarArr);
    }

    public int get() {
        return this.mValue;
    }

    public void set(int i2) {
        if (i2 != this.mValue) {
            this.mValue = i2;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mValue);
    }
}
