package com.google.android.gms.internal.h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f10040a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10041b;

    protected a(IBinder iBinder, String str) {
        this.f10040a = iBinder;
        this.f10041b = str;
    }

    public IBinder asBinder() {
        return this.f10040a;
    }

    /* access modifiers changed from: protected */
    public final Parcel n_() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f10041b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i2, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f10040a.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f10040a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
