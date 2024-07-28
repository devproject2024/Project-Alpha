package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

public final class ap extends br implements ar {
    ap(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    public final void a(String str, int i2, Bundle bundle, at atVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i2);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) atVar);
        a(4, a2);
    }

    public final void a(String str, at atVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (IInterface) atVar);
        a(6, a2);
    }

    public final void a(String str, List<Bundle> list, Bundle bundle, at atVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) atVar);
        a(2, a2);
    }

    public final void b(String str, List<Bundle> list, Bundle bundle, at atVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) atVar);
        a(7, a2);
    }

    public final void c(String str, List<Bundle> list, Bundle bundle, at atVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) atVar);
        a(8, a2);
    }
}
