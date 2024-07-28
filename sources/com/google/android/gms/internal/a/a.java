package com.google.android.gms.internal.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f9061a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9062b;

    protected a(IBinder iBinder, String str) {
        this.f9061a = iBinder;
        this.f9062b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i2, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f9061a.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f9061a;
    }

    /* access modifiers changed from: protected */
    public final Parcel l_() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f9062b);
        return obtain;
    }
}
