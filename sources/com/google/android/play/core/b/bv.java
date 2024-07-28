package com.google.android.play.core.b;

import android.os.IBinder;
import android.os.IInterface;

public abstract class bv extends bs implements bw {
    public static bw a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof bw ? (bw) queryLocalInterface : new bu(iBinder);
    }
}
