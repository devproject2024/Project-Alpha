package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.d.a;
import com.google.android.gms.internal.d.d;

public abstract class ar extends a implements as {
    public ar() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static as a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof as) {
            return (as) queryLocalInterface;
        }
        return new at(iBinder);
    }

    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 == 1) {
            b a2 = a();
            parcel2.writeNoException();
            d.a(parcel2, (IInterface) a2);
        } else if (i2 != 2) {
            return false;
        } else {
            int b2 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b2);
        }
        return true;
    }
}
