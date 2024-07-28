package com.google.android.gms.internal.j;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f10334a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10335b;

    protected a(IBinder iBinder, String str) {
        this.f10334a = iBinder;
        this.f10335b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f10335b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f10334a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f10334a;
    }
}
