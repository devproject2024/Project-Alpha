package com.google.android.gms.flags;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.b.b;

public interface e extends IInterface {
    boolean getBooleanFlagValue(String str, boolean z, int i2) throws RemoteException;

    int getIntFlagValue(String str, int i2, int i3) throws RemoteException;

    long getLongFlagValue(String str, long j, int i2) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i2) throws RemoteException;

    void init(b bVar) throws RemoteException;
}
