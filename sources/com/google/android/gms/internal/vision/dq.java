package com.google.android.gms.internal.vision;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.vision.barcode.Barcode;

public interface dq extends IInterface {
    Barcode[] a(b bVar, zzp zzp) throws RemoteException;

    Barcode[] b(b bVar, zzp zzp) throws RemoteException;

    void w_() throws RemoteException;
}
