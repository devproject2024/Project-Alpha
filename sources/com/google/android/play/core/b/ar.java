package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public interface ar extends IInterface {
    void a(String str, int i2, Bundle bundle, at atVar) throws RemoteException;

    void a(String str, at atVar) throws RemoteException;

    void a(String str, List<Bundle> list, Bundle bundle, at atVar) throws RemoteException;

    void b(String str, List<Bundle> list, Bundle bundle, at atVar) throws RemoteException;

    void c(String str, List<Bundle> list, Bundle bundle, at atVar) throws RemoteException;
}
