package com.google.android.c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface b extends IInterface {
    Bundle a(String str, String str2) throws RemoteException;

    public static abstract class a extends Binder implements b {
        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.now.INowAuthService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0110a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 2) {
                parcel.enforceInterface("com.google.android.now.INowAuthService");
                Bundle a2 = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.google.android.now.INowAuthService");
                return true;
            }
        }

        /* renamed from: com.google.android.c.b$a$a  reason: collision with other inner class name */
        static class C0110a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f7631a;

            C0110a(IBinder iBinder) {
                this.f7631a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f7631a;
            }

            public final Bundle a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.now.INowAuthService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f7631a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
