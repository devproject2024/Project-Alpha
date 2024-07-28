package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    ArrayList<FragmentState> f3361a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f3362b;

    /* renamed from: c  reason: collision with root package name */
    BackStackState[] f3363c;

    /* renamed from: d  reason: collision with root package name */
    int f3364d;

    /* renamed from: e  reason: collision with root package name */
    String f3365e = null;

    public final int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.f3361a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f3362b = parcel.createStringArrayList();
        this.f3363c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f3364d = parcel.readInt();
        this.f3365e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f3361a);
        parcel.writeStringList(this.f3362b);
        parcel.writeTypedArray(this.f3363c, i2);
        parcel.writeInt(this.f3364d);
        parcel.writeString(this.f3365e);
    }
}
