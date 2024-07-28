package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class mi extends a implements mg {
    mi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final void a(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, (Parcelable) bundle);
        a2.writeLong(j);
        b(1, a2);
    }

    public final int s_() throws RemoteException {
        Parcel a2 = a(2, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
