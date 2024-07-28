package com.google.firebase.ml.vision.barcode.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.firebase_ml.ag;
import com.google.android.gms.internal.firebase_ml.ai;
import com.google.android.gms.internal.firebase_ml.zzsb;

public final class h extends ag implements a {
    h(IBinder iBinder) {
        super(iBinder, "com.google.firebase.ml.vision.barcode.internal.IBarcodeDetector");
    }

    public final void Q_() throws RemoteException {
        b(1, a());
    }

    public final b a(b bVar, zzsb zzsb) throws RemoteException {
        Parcel a2 = a();
        ai.a(a2, (IInterface) bVar);
        ai.a(a2, (Parcelable) zzsb);
        Parcel a3 = a(2, a2);
        b a4 = b.a.a(a3.readStrongBinder());
        a3.recycle();
        return a4;
    }

    public final void b() throws RemoteException {
        b(3, a());
    }
}
