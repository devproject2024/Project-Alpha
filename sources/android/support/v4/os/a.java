package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface a extends IInterface {
    void a(int i2, Bundle bundle) throws RemoteException;

    /* renamed from: android.support.v4.os.a$a  reason: collision with other inner class name */
    public static abstract class C0018a extends Binder implements a {
        public IBinder asBinder() {
            return this;
        }

        public C0018a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0019a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }

        /* renamed from: android.support.v4.os.a$a$a  reason: collision with other inner class name */
        static class C0019a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f917a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f918b;

            C0019a(IBinder iBinder) {
                this.f918b = iBinder;
            }

            public final IBinder asBinder() {
                return this.f918b;
            }

            public final void a(int i2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f918b.transact(1, obtain, (Parcel) null, 1) || C0018a.a() == null) {
                        obtain.recycle();
                    } else {
                        C0018a.a().a(i2, bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static a a() {
            return C0019a.f917a;
        }
    }
}
