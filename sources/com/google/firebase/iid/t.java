package com.google.firebase.iid;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

interface t extends IInterface {
    void a(Message message) throws RemoteException;

    public static class a implements t {

        /* renamed from: a  reason: collision with root package name */
        private final IBinder f38890a;

        a(IBinder iBinder) {
            this.f38890a = iBinder;
        }

        public final void a(Message message) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            obtain.writeInt(1);
            message.writeToParcel(obtain, 0);
            try {
                this.f38890a.transact(1, obtain, (Parcel) null, 1);
            } finally {
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.f38890a;
        }
    }
}
