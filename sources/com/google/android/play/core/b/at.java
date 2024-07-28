package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface at extends IInterface {
    void a() throws RemoteException;

    void a(int i2) throws RemoteException;

    void a(int i2, Bundle bundle) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(List<Bundle> list) throws RemoteException;

    void b() throws RemoteException;

    void b(int i2) throws RemoteException;

    void b(int i2, Bundle bundle) throws RemoteException;

    void b(Bundle bundle) throws RemoteException;

    void c() throws RemoteException;

    void c(Bundle bundle) throws RemoteException;

    void d() throws RemoteException;
}
