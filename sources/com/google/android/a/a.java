package com.google.android.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    protected final String f7622a;

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f7623b;

    protected a(IBinder iBinder, String str) {
        this.f7623b = iBinder;
        this.f7622a = str;
    }

    public IBinder asBinder() {
        return this.f7623b;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f7623b.transact(1, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }
}
