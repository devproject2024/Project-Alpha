package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p000authapi.d;
import com.google.android.gms.internal.p000authapi.f;

public final class t extends d implements u {
    t(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void a(s sVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel a2 = a();
        f.a(a2, (IInterface) sVar);
        f.a(a2, (Parcelable) googleSignInOptions);
        a(102, a2);
    }

    public final void b(s sVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel a2 = a();
        f.a(a2, (IInterface) sVar);
        f.a(a2, (Parcelable) googleSignInOptions);
        a(103, a2);
    }
}
