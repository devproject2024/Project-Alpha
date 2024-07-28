package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f10373a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10374b;

    protected a(IBinder iBinder, String str) {
        this.f10373a = iBinder;
        this.f10374b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f10374b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f10373a.transact(21, parcel, parcel, 0);
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
            this.f10373a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10373a;
    }

    /* access modifiers changed from: protected */
    public final void b(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f10373a.transact(i2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
