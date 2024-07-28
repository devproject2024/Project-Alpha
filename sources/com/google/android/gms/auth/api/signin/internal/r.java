package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapi.c;
import com.google.android.gms.internal.p000authapi.f;

public abstract class r extends c implements s {
    public r() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i2) {
            case 101:
                f.a(parcel, GoogleSignInAccount.CREATOR);
                f.a(parcel, Status.CREATOR);
                a();
                break;
            case 102:
                a((Status) f.a(parcel, Status.CREATOR));
                break;
            case 103:
                b((Status) f.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
