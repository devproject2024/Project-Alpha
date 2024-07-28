package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new FragmentState[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final String f3366a;

    /* renamed from: b  reason: collision with root package name */
    final String f3367b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f3368c;

    /* renamed from: d  reason: collision with root package name */
    final int f3369d;

    /* renamed from: e  reason: collision with root package name */
    final int f3370e;

    /* renamed from: f  reason: collision with root package name */
    final String f3371f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f3372g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f3373h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f3374i;
    final Bundle j;
    final boolean k;
    final int l;
    Bundle m;

    public final int describeContents() {
        return 0;
    }

    FragmentState(Fragment fragment) {
        this.f3366a = fragment.getClass().getName();
        this.f3367b = fragment.mWho;
        this.f3368c = fragment.mFromLayout;
        this.f3369d = fragment.mFragmentId;
        this.f3370e = fragment.mContainerId;
        this.f3371f = fragment.mTag;
        this.f3372g = fragment.mRetainInstance;
        this.f3373h = fragment.mRemoving;
        this.f3374i = fragment.mDetached;
        this.j = fragment.mArguments;
        this.k = fragment.mHidden;
        this.l = fragment.mMaxState.ordinal();
    }

    FragmentState(Parcel parcel) {
        this.f3366a = parcel.readString();
        this.f3367b = parcel.readString();
        boolean z = true;
        this.f3368c = parcel.readInt() != 0;
        this.f3369d = parcel.readInt();
        this.f3370e = parcel.readInt();
        this.f3371f = parcel.readString();
        this.f3372g = parcel.readInt() != 0;
        this.f3373h = parcel.readInt() != 0;
        this.f3374i = parcel.readInt() != 0;
        this.j = parcel.readBundle();
        this.k = parcel.readInt() == 0 ? false : z;
        this.m = parcel.readBundle();
        this.l = parcel.readInt();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3366a);
        sb.append(" (");
        sb.append(this.f3367b);
        sb.append(")}:");
        if (this.f3368c) {
            sb.append(" fromLayout");
        }
        if (this.f3370e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3370e));
        }
        String str = this.f3371f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f3371f);
        }
        if (this.f3372g) {
            sb.append(" retainInstance");
        }
        if (this.f3373h) {
            sb.append(" removing");
        }
        if (this.f3374i) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3366a);
        parcel.writeString(this.f3367b);
        parcel.writeInt(this.f3368c ? 1 : 0);
        parcel.writeInt(this.f3369d);
        parcel.writeInt(this.f3370e);
        parcel.writeString(this.f3371f);
        parcel.writeInt(this.f3372g ? 1 : 0);
        parcel.writeInt(this.f3373h ? 1 : 0);
        parcel.writeInt(this.f3374i ? 1 : 0);
        parcel.writeBundle(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.l);
    }
}
