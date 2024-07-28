package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableShort extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new Parcelable.Creator<ObservableShort>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ObservableShort[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableShort((short) parcel.readInt());
        }
    };
    static final long serialVersionUID = 1;
    private short mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableShort(short s) {
        this.mValue = s;
    }

    public ObservableShort() {
    }

    public ObservableShort(h... hVarArr) {
        super(hVarArr);
    }

    public short get() {
        return this.mValue;
    }

    public void set(short s) {
        if (s != this.mValue) {
            this.mValue = s;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mValue);
    }
}
