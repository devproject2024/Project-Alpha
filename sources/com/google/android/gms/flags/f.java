package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.g.b;
import com.google.android.gms.internal.g.c;

public abstract class f extends b implements e {
    public f() {
        super("com.google.android.gms.flags.IFlagProvider");
    }

    public static e asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        if (queryLocalInterface instanceof e) {
            return (e) queryLocalInterface;
        }
        return new g(iBinder);
    }

    public final boolean dispatchTransaction$3d31fa39(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 == 1) {
            init(b.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i2 == 2) {
            boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), c.a(parcel), parcel.readInt());
            parcel2.writeNoException();
            c.a(parcel2, booleanFlagValue);
        } else if (i2 == 3) {
            int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(intFlagValue);
        } else if (i2 == 4) {
            long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(longFlagValue);
        } else if (i2 != 5) {
            return false;
        } else {
            String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeString(stringFlagValue);
        }
        return true;
    }
}
