package com.google.android.b.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.a.b;
import com.google.android.a.c;

public interface a extends IInterface {
    Bundle a(Bundle bundle) throws RemoteException;

    /* renamed from: com.google.android.b.a.a$a  reason: collision with other inner class name */
    public static abstract class C0108a extends b implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new C0109a(iBinder);
        }

        /* renamed from: com.google.android.b.a.a$a$a  reason: collision with other inner class name */
        public static class C0109a extends com.google.android.a.a implements a {
            C0109a(IBinder iBinder) {
                super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            }

            public final Bundle a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f7622a);
                c.a(obtain, (Parcelable) bundle);
                Parcel a2 = a(obtain);
                Bundle bundle2 = (Bundle) c.a(a2, Bundle.CREATOR);
                a2.recycle();
                return bundle2;
            }
        }
    }
}
