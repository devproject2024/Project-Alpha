package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableLong extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableLong> CREATOR = new Parcelable.Creator<ObservableLong>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ObservableLong[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableLong(parcel.readLong());
        }
    };
    static final long serialVersionUID = 1;
    private long mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableLong(long j) {
        this.mValue = j;
    }

    public ObservableLong() {
    }

    public ObservableLong(h... hVarArr) {
        super(hVarArr);
    }

    public long get() {
        return this.mValue;
    }

    public void set(long j) {
        if (j != this.mValue) {
            this.mValue = j;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.mValue);
    }
}
