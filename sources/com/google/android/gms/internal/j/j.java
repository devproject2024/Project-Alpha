package com.google.android.gms.internal.j;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class j extends a implements i {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.safetynet.internal.ISafetyNetService");
    }

    public final void a(g gVar) throws RemoteException {
        Parcel a2 = a();
        c.a(a2, (IInterface) gVar);
        a(12, a2);
    }

    public final void a(g gVar, String str) throws RemoteException {
        Parcel a2 = a();
        c.a(a2, (IInterface) gVar);
        a2.writeString(str);
        a(6, a2);
    }

    public final void a(g gVar, String str, int[] iArr, int i2, String str2) throws RemoteException {
        Parcel a2 = a();
        c.a(a2, (IInterface) gVar);
        a2.writeString(str);
        a2.writeIntArray(iArr);
        a2.writeInt(i2);
        a2.writeString(str2);
        a(3, a2);
    }

    public final void a(g gVar, byte[] bArr, String str) throws RemoteException {
        Parcel a2 = a();
        c.a(a2, (IInterface) gVar);
        a2.writeByteArray(bArr);
        a2.writeString(str);
        a(7, a2);
    }

    public final void b(g gVar) throws RemoteException {
        Parcel a2 = a();
        c.a(a2, (IInterface) gVar);
        a(14, a2);
    }

    public final void c(g gVar) throws RemoteException {
        Parcel a2 = a();
        c.a(a2, (IInterface) gVar);
        a(4, a2);
    }

    public final void d(g gVar) throws RemoteException {
        Parcel a2 = a();
        c.a(a2, (IInterface) gVar);
        a(5, a2);
    }

    public final void t_() throws RemoteException {
        a(13, a());
    }
}
