package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface o extends IInterface {

    public static abstract class a extends Binder implements o {

        /* renamed from: com.google.android.youtube.player.internal.o$a$a  reason: collision with other inner class name */
        static class C0619a implements o {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37574a;

            C0619a(IBinder iBinder) {
                this.f37574a = iBinder;
            }

            public final void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.f37574a.transact(3, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    obtain.writeString(str);
                    this.f37574a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.f37574a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f37574a;
            }

            public final void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.f37574a.transact(4, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.f37574a.transact(5, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.f37574a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static o a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof o)) ? new C0619a(iBinder) : (o) queryLocalInterface;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                        a(parcel.readString());
                        break;
                    case 2:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                        a(parcel.readString(), parcel.readInt());
                        break;
                    case 3:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                        a();
                        break;
                    case 4:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                        b();
                        break;
                    case 5:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                        c();
                        break;
                    case 6:
                        parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                        d();
                        break;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderService");
            return true;
        }
    }

    void a() throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, int i2) throws RemoteException;

    void b() throws RemoteException;

    void c() throws RemoteException;

    void d() throws RemoteException;
}
