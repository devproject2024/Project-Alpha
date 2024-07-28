package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class bx extends bs implements by {
    public bx() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 == 2) {
            a((Bundle) bt.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i2 != 3) {
            return false;
        } else {
            b((Bundle) bt.a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
