package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class as extends bs implements at {
    public as() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        switch (i2) {
            case 2:
                a(parcel.readInt(), (Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                bt.a(parcel, Bundle.CREATOR);
                b(readInt);
                return true;
            case 4:
                b(parcel.readInt(), (Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                int readInt2 = parcel.readInt();
                bt.a(parcel, Bundle.CREATOR);
                a(readInt2);
                return true;
            case 6:
                a((Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                b((Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                c((Bundle) bt.a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                bt.a(parcel, Bundle.CREATOR);
                d();
                return true;
            case 11:
                bt.a(parcel, Bundle.CREATOR);
                c();
                return true;
            case 12:
                bt.a(parcel, Bundle.CREATOR);
                a();
                return true;
            case 13:
                bt.a(parcel, Bundle.CREATOR);
                b();
                return true;
            default:
                return false;
        }
    }
}
