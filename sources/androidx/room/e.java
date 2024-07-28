package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.d;

public interface e extends IInterface {
    int a(d dVar, String str) throws RemoteException;

    void a(int i2, String[] strArr) throws RemoteException;

    void a(d dVar, int i2) throws RemoteException;

    public static abstract class a extends Binder implements e {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C0070a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int a2 = a(d.a.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                a(d.a.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                a(parcel.readInt(), parcel.createStringArray());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
        }

        /* renamed from: androidx.room.e$a$a  reason: collision with other inner class name */
        static class C0070a implements e {

            /* renamed from: a  reason: collision with root package name */
            public static e f4413a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f4414b;

            C0070a(IBinder iBinder) {
                this.f4414b = iBinder;
            }

            public final IBinder asBinder() {
                return this.f4414b;
            }

            public final int a(d dVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    obtain.writeString(str);
                    if (!this.f4414b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(dVar, str);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(d dVar, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    obtain.writeInt(i2);
                    if (this.f4414b.transact(2, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                    } else {
                        a.a().a(dVar, i2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (this.f4414b.transact(3, obtain, (Parcel) null, 1) || a.a() == null) {
                        obtain.recycle();
                    } else {
                        a.a().a(i2, strArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static e a() {
            return C0070a.f4413a;
        }
    }
}
