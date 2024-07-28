package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface s extends IInterface {
    void a() throws RemoteException;

    void a(Status status) throws RemoteException;

    void b(Status status) throws RemoteException;
}
