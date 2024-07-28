package org.parceler.a;

import android.os.Parcel;
import org.parceler.d;

public final class c implements d<char[]> {
    public final /* synthetic */ void c(Object obj, Parcel parcel) {
        char[] cArr = (char[]) obj;
        if (cArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(cArr.length);
        parcel.writeCharArray(cArr);
    }

    public final /* synthetic */ Object c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        char[] cArr = new char[readInt];
        parcel.readCharArray(cArr);
        return cArr;
    }
}
