package org.parceler.a;

import android.os.Parcel;
import org.parceler.d;

public final class b implements d<boolean[]> {
    public final /* synthetic */ void c(Object obj, Parcel parcel) {
        boolean[] zArr = (boolean[]) obj;
        if (zArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(zArr.length);
        parcel.writeBooleanArray(zArr);
    }

    public final /* synthetic */ Object c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        parcel.readBooleanArray(zArr);
        return zArr;
    }
}
