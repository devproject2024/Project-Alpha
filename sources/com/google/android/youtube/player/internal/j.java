package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface j extends IInterface {

    public static abstract class a extends Binder implements j {

        /* renamed from: com.google.android.youtube.player.internal.j$a$a  reason: collision with other inner class name */
        static class C0615a implements j {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37568a;

            C0615a(IBinder iBinder) {
                this.f37568a = iBinder;
            }

            public final void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                    this.f37568a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                    obtain.writeString(str);
                    this.f37568a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f37568a;
            }

            public final void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                    this.f37568a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                    obtain.writeString(str);
                    this.f37568a.transact(6, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                    this.f37568a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                    this.f37568a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IPlayerStateChangeListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                        a();
                        break;
                    case 2:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                        a(parcel.readString());
                        break;
                    case 3:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                        b();
                        break;
                    case 4:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                        c();
                        break;
                    case 5:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                        d();
                        break;
                    case 6:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                        b(parcel.readString());
                        break;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
            return true;
        }
    }

    void a() throws RemoteException;

    void a(String str) throws RemoteException;

    void b() throws RemoteException;

    void b(String str) throws RemoteException;

    void c() throws RemoteException;

    void d() throws RemoteException;
}
