package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface i extends IInterface {

    public static abstract class a extends Binder implements i {

        /* renamed from: com.google.android.youtube.player.internal.i$a$a  reason: collision with other inner class name */
        static class C0614a implements i {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37567a;

            C0614a(IBinder iBinder) {
                this.f37567a = iBinder;
            }

            public final void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.f37567a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    obtain.writeInt(i2);
                    this.f37567a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    obtain.writeInt(z ? 1 : 0);
                    this.f37567a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f37567a;
            }

            public final void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.f37567a.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.f37567a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                a();
            } else if (i2 == 2) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                b();
            } else if (i2 == 3) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                c();
            } else if (i2 == 4) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                a(parcel.readInt() != 0);
            } else if (i2 == 5) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                a(parcel.readInt());
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.google.android.youtube.player.internal.IPlaybackEventListener");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a() throws RemoteException;

    void a(int i2) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b() throws RemoteException;

    void c() throws RemoteException;
}
