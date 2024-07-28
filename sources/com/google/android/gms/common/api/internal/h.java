package com.google.android.gms.common.api.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.d;

public interface h extends IInterface {
    void a(Status status) throws RemoteException;

    public static abstract class a extends com.google.android.gms.internal.base.a implements h {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i2 != 1) {
                return false;
            }
            a((Status) d.a(parcel, Status.CREATOR));
            return true;
        }
    }
}
