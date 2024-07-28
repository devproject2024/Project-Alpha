package com.google.firebase.ml.vision.barcode.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_ml.a;
import com.google.android.gms.internal.firebase_ml.ai;

public abstract class i extends a implements j {
    public static j a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.ml.vision.barcode.internal.IBarcodeDetectorCreator");
        if (queryLocalInterface instanceof j) {
            return (j) queryLocalInterface;
        }
        return new k(iBinder);
    }

    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        a a2 = a((BarcodeDetectorOptionsParcel) ai.a(parcel, BarcodeDetectorOptionsParcel.CREATOR));
        parcel2.writeNoException();
        ai.a(parcel2, (IInterface) a2);
        return true;
    }
}
