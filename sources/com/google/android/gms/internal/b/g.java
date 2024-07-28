package com.google.android.gms.internal.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class g implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f9100a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9101b;

    protected g(IBinder iBinder, String str) {
        this.f9100a = iBinder;
        this.f9101b = str;
    }

    public IBinder asBinder() {
        return this.f9100a;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f9101b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f9100a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
