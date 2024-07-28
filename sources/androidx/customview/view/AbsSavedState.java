package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new Parcelable.ClassLoaderCreator<AbsSavedState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return a(parcel, classLoader);
        }

        private static AbsSavedState a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f3244c;
            }
            throw new IllegalStateException("superState must be null");
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new AbsSavedState[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel, (ClassLoader) null);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final AbsSavedState f3244c = new AbsSavedState() {
    };

    /* renamed from: d  reason: collision with root package name */
    public final Parcelable f3245d;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ AbsSavedState(byte b2) {
        this();
    }

    private AbsSavedState() {
        this.f3245d = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f3245d = parcelable == f3244c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f3245d = readParcelable == null ? f3244c : readParcelable;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f3245d, i2);
    }
}
