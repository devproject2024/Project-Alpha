package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface k extends IInterface {

    public static abstract class a extends Binder implements k {

        /* renamed from: com.google.android.youtube.player.internal.k$a$a  reason: collision with other inner class name */
        static class C0616a implements k {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37569a;

            C0616a(IBinder iBinder) {
                this.f37569a = iBinder;
            }

            public final void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f37569a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f37569a;
            }

            public final void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f37569a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.f37569a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                a();
            } else if (i2 == 2) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                b();
            } else if (i2 == 3) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                c();
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.google.android.youtube.player.internal.IPlaylistEventListener");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a() throws RemoteException;

    void b() throws RemoteException;

    void c() throws RemoteException;
}
