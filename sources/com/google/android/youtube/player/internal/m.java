package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface m extends IInterface {

    public static abstract class a extends Binder implements m {

        /* renamed from: com.google.android.youtube.player.internal.m$a$a  reason: collision with other inner class name */
        static class C0618a implements m {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37571a;

            C0618a(IBinder iBinder) {
                this.f37571a = iBinder;
            }

            public final void a(Bitmap bitmap, String str, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f37571a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    obtain.writeString(str);
                    int i2 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f37571a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f37571a;
            }
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            boolean z = false;
            if (i2 == 1) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                Bitmap bitmap = parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null;
                String readString = parcel.readString();
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                a(bitmap, readString, z2, z);
            } else if (i2 == 2) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                String readString2 = parcel.readString();
                boolean z3 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                a(readString2, z3, z);
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(Bitmap bitmap, String str, boolean z, boolean z2) throws RemoteException;

    void a(String str, boolean z, boolean z2) throws RemoteException;
}
