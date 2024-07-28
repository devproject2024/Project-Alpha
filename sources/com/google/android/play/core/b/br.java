package com.google.android.play.core.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class br implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f37298a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37299b;

    protected br(IBinder iBinder, String str) {
        this.f37298a = iBinder;
        this.f37299b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f37299b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, Parcel parcel) throws RemoteException {
        try {
            this.f37298a.transact(i2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f37298a;
    }
}
