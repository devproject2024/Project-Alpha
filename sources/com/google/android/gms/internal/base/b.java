package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class b implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f9105a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9106b;

    protected b(IBinder iBinder, String str) {
        this.f9105a = iBinder;
        this.f9106b = str;
    }

    public IBinder asBinder() {
        return this.f9105a;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f9106b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f9105a.transact(2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f9105a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
