package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class cc extends bs implements cd {
    public cc() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        switch (i2) {
            case 2:
                int readInt = parcel.readInt();
                bt.a(parcel, Bundle.CREATOR);
                a(readInt);
                return true;
            case 3:
                int readInt2 = parcel.readInt();
                bt.a(parcel, Bundle.CREATOR);
                b(readInt2);
                return true;
            case 4:
                int readInt3 = parcel.readInt();
                bt.a(parcel, Bundle.CREATOR);
                c(readInt3);
                return true;
            case 5:
                a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                bt.a(parcel, Bundle.CREATOR);
                b((Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                a((Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                bt.a(parcel, Bundle.CREATOR);
                c((Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                bt.a(parcel, Bundle.CREATOR);
                d((Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 11:
                a((Bundle) bt.a(parcel, Bundle.CREATOR), (Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 12:
                b((Bundle) bt.a(parcel, Bundle.CREATOR), (Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                bt.a(parcel, Bundle.CREATOR);
                bt.a(parcel, Bundle.CREATOR);
                a();
                return true;
            case 14:
                bt.a(parcel, Bundle.CREATOR);
                bt.a(parcel, Bundle.CREATOR);
                c();
                return true;
            case 15:
                bt.a(parcel, Bundle.CREATOR);
                b();
                return true;
            default:
                return false;
        }
    }
}
