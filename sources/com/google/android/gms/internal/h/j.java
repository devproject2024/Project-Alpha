package com.google.android.gms.internal.h;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;

public final class j extends a implements h {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    public final b a(Bitmap bitmap) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (Parcelable) bitmap);
        Parcel a2 = a(6, n_);
        b a3 = b.a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
