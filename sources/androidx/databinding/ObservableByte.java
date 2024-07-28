package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableByte extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new Parcelable.Creator<ObservableByte>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ObservableByte[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableByte(parcel.readByte());
        }
    };
    static final long serialVersionUID = 1;
    private byte mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableByte(byte b2) {
        this.mValue = b2;
    }

    public ObservableByte() {
    }

    public ObservableByte(h... hVarArr) {
        super(hVarArr);
    }

    public byte get() {
        return this.mValue;
    }

    public void set(byte b2) {
        if (b2 != this.mValue) {
            this.mValue = b2;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.mValue);
    }
}
