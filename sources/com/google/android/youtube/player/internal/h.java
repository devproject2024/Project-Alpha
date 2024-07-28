package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        /* renamed from: com.google.android.youtube.player.internal.h$a$a  reason: collision with other inner class name */
        static class C0613a implements h {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37566a;

            C0613a(IBinder iBinder) {
                this.f37566a = iBinder;
            }

            public final void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    obtain.writeInt(z ? 1 : 0);
                    this.f37566a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final IBinder asBinder() {
                return this.f37566a;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.IOnFullscreenListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
                a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("com.google.android.youtube.player.internal.IOnFullscreenListener");
                return true;
            }
        }
    }

    void a(boolean z) throws RemoteException;
}
