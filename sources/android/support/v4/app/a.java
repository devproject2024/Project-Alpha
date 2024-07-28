package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface a extends IInterface {
    void a(String str) throws RemoteException;

    void a(String str, int i2, String str2) throws RemoteException;

    void a(String str, int i2, String str2, Notification notification) throws RemoteException;

    /* renamed from: android.support.v4.app.a$a  reason: collision with other inner class name */
    public static abstract class C0009a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0010a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                a(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                a(parcel.readString());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("android.support.v4.app.INotificationSideChannel");
                return true;
            }
        }

        /* renamed from: android.support.v4.app.a$a$a  reason: collision with other inner class name */
        static class C0010a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f785a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f786b;

            C0010a(IBinder iBinder) {
                this.f786b = iBinder;
            }

            public final IBinder asBinder() {
                return this.f786b;
            }

            public final void a(String str, int i2, String str2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f786b.transact(1, obtain, (Parcel) null, 1) || C0009a.a() == null) {
                        obtain.recycle();
                    } else {
                        C0009a.a().a(str, i2, str2, notification);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public final void a(String str, int i2, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    if (this.f786b.transact(2, obtain, (Parcel) null, 1) || C0009a.a() == null) {
                        obtain.recycle();
                    } else {
                        C0009a.a().a(str, i2, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    if (this.f786b.transact(3, obtain, (Parcel) null, 1) || C0009a.a() == null) {
                        obtain.recycle();
                    } else {
                        C0009a.a().a(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static a a() {
            return C0010a.f785a;
        }
    }
}
