package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        /* renamed from: com.google.android.youtube.player.internal.f$a$a  reason: collision with other inner class name */
        static class C0611a implements f {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37564a;

            C0611a(IBinder iBinder) {
                this.f37564a = iBinder;
            }

            public final void a(String str, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    this.f37564a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f37564a;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IConnectionCallbacks");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                a(parcel.readString(), parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.google.android.youtube.player.internal.IConnectionCallbacks");
                return true;
            }
        }
    }

    void a(String str, IBinder iBinder) throws RemoteException;
}
