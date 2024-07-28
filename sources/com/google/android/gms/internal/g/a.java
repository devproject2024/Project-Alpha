package com.google.android.gms.internal.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    protected final IBinder f10036a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10037b;

    protected a(IBinder iBinder, String str) {
        this.f10036a = iBinder;
        this.f10037b = str;
    }

    public IBinder asBinder() {
        return this.f10036a;
    }

    /* access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f10037b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i2, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f10036a.transact(i2, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }
}
