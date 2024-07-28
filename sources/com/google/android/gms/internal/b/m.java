package com.google.android.gms.internal.b;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class m extends a implements k {
    public m() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        a((Status) i.a(parcel, Status.CREATOR));
        return true;
    }
}
