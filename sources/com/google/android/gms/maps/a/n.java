package com.google.android.gms.maps.a;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.h.e;
import com.google.android.gms.internal.h.f;
import com.google.android.gms.internal.h.l;

public abstract class n extends e implements m {
    public n() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        boolean a2 = a(l.a(parcel.readStrongBinder()));
        parcel2.writeNoException();
        f.a(parcel2, a2);
        return true;
    }
}
