package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableParcelable<T extends Parcelable> extends i<T> implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = new Parcelable.Creator<ObservableParcelable>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ObservableParcelable[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ObservableParcelable(parcel.readParcelable(getClass().getClassLoader()));
        }
    };
    static final long serialVersionUID = 1;

    public int describeContents() {
        return 0;
    }

    public ObservableParcelable(T t) {
        super(t);
    }

    public ObservableParcelable() {
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable((Parcelable) get(), 0);
    }
}
