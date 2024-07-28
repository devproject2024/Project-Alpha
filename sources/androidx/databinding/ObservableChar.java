package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableChar extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = new Parcelable.Creator<ObservableChar>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ObservableChar[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableChar((char) parcel.readInt());
        }
    };
    static final long serialVersionUID = 1;
    private char mValue;

    public int describeContents() {
        return 0;
    }

    public ObservableChar(char c2) {
        this.mValue = c2;
    }

    public ObservableChar() {
    }

    public ObservableChar(h... hVarArr) {
        super(hVarArr);
    }

    public char get() {
        return this.mValue;
    }

    public void set(char c2) {
        if (c2 != this.mValue) {
            this.mValue = c2;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mValue);
    }
}
