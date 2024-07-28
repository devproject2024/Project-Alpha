package com.google.android.play.core.b;

import android.os.IBinder;
import android.os.IInterface;

public abstract class aq extends bs implements ar {
    public static ar a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof ar ? (ar) queryLocalInterface : new ap(iBinder);
    }
}
