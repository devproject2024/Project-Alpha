package org.parceler;

import android.os.Parcel;

public interface i<L, U extends L> {
    U c(Parcel parcel);

    void c(L l, Parcel parcel);
}
