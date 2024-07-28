package com.google.android.play.core.b;

import android.os.IBinder;
import android.os.IInterface;

public abstract class ca extends bs implements cb {
    public static cb a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof cb ? (cb) queryLocalInterface : new bz(iBinder);
    }
}
