package com.google.android.gms.internal.icing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class l implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    final IBinder f10262a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10263b;

    protected l(IBinder iBinder, String str) {
        this.f10262a = iBinder;
        this.f10263b = str;
    }

    public IBinder asBinder() {
        return this.f10262a;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f10263b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f10262a.transact(8, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }
}
