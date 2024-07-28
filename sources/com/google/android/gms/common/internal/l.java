package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.d.b;
import com.google.android.gms.internal.d.d;

public interface l extends IInterface {

    public static abstract class a extends com.google.android.gms.internal.d.a implements l {

        /* renamed from: com.google.android.gms.common.internal.l$a$a  reason: collision with other inner class name */
        public static class C0131a extends b implements l {
            C0131a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            public final Account a() throws RemoteException {
                Parcel a2 = a(2, c());
                Account account = (Account) d.a(a2, Account.CREATOR);
                a2.recycle();
                return account;
            }
        }

        public static l a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof l) {
                return (l) queryLocalInterface;
            }
            return new C0131a(iBinder);
        }

        public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i2 != 2) {
                return false;
            }
            Account a2 = a();
            parcel2.writeNoException();
            d.b(parcel2, a2);
            return true;
        }
    }

    Account a() throws RemoteException;
}
