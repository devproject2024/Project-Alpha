package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface w extends IInterface {

    public static abstract class a extends Binder implements w {

        /* renamed from: com.google.android.youtube.player.internal.w$a$a  reason: collision with other inner class name */
        static class C0621a implements w {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f37613a;

            C0621a(IBinder iBinder) {
                this.f37613a = iBinder;
            }

            public final IBinder asBinder() {
                return this.f37613a;
            }
        }

        public a() {
            attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
        }

        public static w a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof w)) ? new C0621a(iBinder) : (w) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
            return true;
        }
    }
}
