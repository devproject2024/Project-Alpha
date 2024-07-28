package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

public final class bz extends br implements cb {
    bz(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    public final void a(String str, Bundle bundle, Bundle bundle2, cd cdVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (Parcelable) bundle2);
        bt.a(a2, (IInterface) cdVar);
        a(6, a2);
    }

    public final void a(String str, Bundle bundle, cd cdVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) cdVar);
        a(5, a2);
    }

    public final void a(String str, List<Bundle> list, Bundle bundle, cd cdVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) cdVar);
        a(14, a2);
    }

    public final void b(String str, Bundle bundle, Bundle bundle2, cd cdVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (Parcelable) bundle2);
        bt.a(a2, (IInterface) cdVar);
        a(7, a2);
    }

    public final void b(String str, Bundle bundle, cd cdVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) cdVar);
        a(10, a2);
    }

    public final void c(String str, Bundle bundle, Bundle bundle2, cd cdVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (Parcelable) bundle2);
        bt.a(a2, (IInterface) cdVar);
        a(9, a2);
    }

    public final void d(String str, Bundle bundle, Bundle bundle2, cd cdVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (Parcelable) bundle2);
        bt.a(a2, (IInterface) cdVar);
        a(11, a2);
    }
}
