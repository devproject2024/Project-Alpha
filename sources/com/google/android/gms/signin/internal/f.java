package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.a;
import com.google.android.gms.internal.base.d;

public abstract class f extends a implements c {
    public f() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 == 3) {
            d.a(parcel, ConnectionResult.CREATOR);
            d.a(parcel, zab.CREATOR);
        } else if (i2 == 4) {
            d.a(parcel, Status.CREATOR);
        } else if (i2 == 6) {
            d.a(parcel, Status.CREATOR);
        } else if (i2 == 7) {
            d.a(parcel, Status.CREATOR);
            d.a(parcel, GoogleSignInAccount.CREATOR);
        } else if (i2 != 8) {
            return false;
        } else {
            a((zak) d.a(parcel, zak.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
