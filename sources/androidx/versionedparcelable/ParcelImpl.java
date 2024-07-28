package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ParcelImpl[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final c f4929a;

    public int describeContents() {
        return 0;
    }

    protected ParcelImpl(Parcel parcel) {
        this.f4929a = new b(parcel).i();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        new b(parcel).b(this.f4929a);
    }
}
