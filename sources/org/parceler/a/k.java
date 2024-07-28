package org.parceler.a;

import android.os.Parcel;
import org.parceler.d;

public abstract class k<T> implements d<T> {
    public abstract T a(Parcel parcel);

    public abstract void a(T t, Parcel parcel);

    public final void c(T t, Parcel parcel) {
        if (t == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(1);
        a(t, parcel);
    }

    public final T c(Parcel parcel) {
        if (parcel.readInt() == -1) {
            return null;
        }
        return a(parcel);
    }
}
