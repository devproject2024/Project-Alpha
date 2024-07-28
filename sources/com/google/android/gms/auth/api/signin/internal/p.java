package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.p000authapi.c;

public abstract class p extends c implements q {
    public p() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 == 1) {
            a();
        } else if (i2 != 2) {
            return false;
        } else {
            b();
        }
        return true;
    }
}
