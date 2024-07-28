package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.auth-api.d  reason: invalid package */
public class d implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f9067a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9068b;

    protected d(IBinder iBinder, String str) {
        this.f9067a = iBinder;
        this.f9068b = str;
    }

    public IBinder asBinder() {
        return this.f9067a;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f9068b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f9067a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
