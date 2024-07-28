package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface d extends IInterface {
    void a(String[] strArr) throws RemoteException;

    public static abstract class a extends Binder implements d {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C0069a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
                a(parcel.createStringArray());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
        }

        /* renamed from: androidx.room.d$a$a  reason: collision with other inner class name */
        static class C0069a implements d {

            /* renamed from: a  reason: collision with root package name */
            public static d f4411a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f4412b;

            C0069a(IBinder iBinder) {
                this.f4412b = iBinder;
            }

            public final IBinder asBinder() {
                return this.f4412b;
            }

            public final void a(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    if (this.f4412b.transact(1, obtain, (Parcel) null, 1) || a.a() == null) {
                        obtain.recycle();
                    } else {
                        a.a().a(strArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static d a() {
            return C0069a.f4411a;
        }
    }
}
