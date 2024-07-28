package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public interface u extends IInterface {
    void a(s sVar, GoogleSignInOptions googleSignInOptions) throws RemoteException;

    void b(s sVar, GoogleSignInOptions googleSignInOptions) throws RemoteException;
}
