package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class cg extends br implements ch {
    cg(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    public final void a(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        bt.a(a2, (Parcelable) bundle);
        a(3, a2);
    }

    public final void a(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a2 = a();
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (Parcelable) bundle2);
        a(2, a2);
    }

    public final void b(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        bt.a(a2, (Parcelable) bundle);
        a(4, a2);
    }
}
