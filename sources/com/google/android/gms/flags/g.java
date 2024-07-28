package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.g.a;
import com.google.android.gms.internal.g.c;

public final class g extends a implements e {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    public final void init(b bVar) throws RemoteException {
        Parcel a2 = a();
        c.a(a2, (IInterface) bVar);
        Parcel obtain = Parcel.obtain();
        try {
            this.f10036a.transact(1, a2, obtain, 0);
            obtain.readException();
        } finally {
            a2.recycle();
            obtain.recycle();
        }
    }

    public final boolean getBooleanFlagValue(String str, boolean z, int i2) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        c.a(a2, z);
        a2.writeInt(i2);
        Parcel a3 = a(2, a2);
        boolean a4 = c.a(a3);
        a3.recycle();
        return a4;
    }

    public final int getIntFlagValue(String str, int i2, int i3) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i2);
        a2.writeInt(i3);
        Parcel a3 = a(3, a2);
        int readInt = a3.readInt();
        a3.recycle();
        return readInt;
    }

    public final long getLongFlagValue(String str, long j, int i2) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeLong(j);
        a2.writeInt(i2);
        Parcel a3 = a(4, a2);
        long readLong = a3.readLong();
        a3.recycle();
        return readLong;
    }

    public final String getStringFlagValue(String str, String str2, int i2) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeInt(i2);
        Parcel a3 = a(5, a2);
        String readString = a3.readString();
        a3.recycle();
        return readString;
    }
}
