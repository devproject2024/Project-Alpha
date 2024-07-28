package org.parceler.a;

import android.os.Parcel;
import android.util.SparseArray;
import org.parceler.d;

public abstract class l<T> implements d<SparseArray<T>> {
    public abstract T a(Parcel parcel);

    public abstract void a(T t, Parcel parcel);

    public final /* synthetic */ void c(Object obj, Parcel parcel) {
        SparseArray sparseArray = (SparseArray) obj;
        if (sparseArray == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(sparseArray.size());
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            parcel.writeInt(sparseArray.keyAt(i2));
            a(sparseArray.valueAt(i2), parcel);
        }
    }

    public final /* synthetic */ Object c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        SparseArray sparseArray = new SparseArray(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            sparseArray.append(parcel.readInt(), a(parcel));
        }
        return sparseArray;
    }
}
