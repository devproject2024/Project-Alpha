package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.d.d;

public interface n extends IInterface {
    void a(int i2, Bundle bundle) throws RemoteException;

    void a(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(int i2, IBinder iBinder, zzc zzc) throws RemoteException;

    public static abstract class a extends com.google.android.gms.internal.d.a implements n {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i2 == 1) {
                a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) d.a(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                a(parcel.readInt(), (Bundle) d.a(parcel, Bundle.CREATOR));
            } else if (i2 != 3) {
                return false;
            } else {
                a(parcel.readInt(), parcel.readStrongBinder(), (zzc) d.a(parcel, zzc.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
