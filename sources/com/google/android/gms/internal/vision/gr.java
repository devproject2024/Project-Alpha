package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.vision.barcode.Barcode;

public final class gr extends u implements dq {
    gr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    public final Barcode[] a(b bVar, zzp zzp) throws RemoteException {
        Parcel a2 = a();
        as.a(a2, (IInterface) bVar);
        as.a(a2, (Parcelable) zzp);
        Parcel a3 = a(1, a2);
        Barcode[] barcodeArr = (Barcode[]) a3.createTypedArray(Barcode.CREATOR);
        a3.recycle();
        return barcodeArr;
    }

    public final Barcode[] b(b bVar, zzp zzp) throws RemoteException {
        Parcel a2 = a();
        as.a(a2, (IInterface) bVar);
        as.a(a2, (Parcelable) zzp);
        Parcel a3 = a(2, a2);
        Barcode[] barcodeArr = (Barcode[]) a3.createTypedArray(Barcode.CREATOR);
        a3.recycle();
        return barcodeArr;
    }

    public final void w_() throws RemoteException {
        b(3, a());
    }
}
