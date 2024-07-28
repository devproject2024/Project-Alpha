package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface cb extends IInterface {
    void a(String str, Bundle bundle, Bundle bundle2, cd cdVar) throws RemoteException;

    void a(String str, Bundle bundle, cd cdVar) throws RemoteException;

    void a(String str, List<Bundle> list, Bundle bundle, cd cdVar) throws RemoteException;

    void b(String str, Bundle bundle, Bundle bundle2, cd cdVar) throws RemoteException;

    void b(String str, Bundle bundle, cd cdVar) throws RemoteException;

    void c(String str, Bundle bundle, Bundle bundle2, cd cdVar) throws RemoteException;

    void d(String str, Bundle bundle, Bundle bundle2, cd cdVar) throws RemoteException;
}
