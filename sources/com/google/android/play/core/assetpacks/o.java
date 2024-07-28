package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.e.p;

final class o extends n<ParcelFileDescriptor> {
    o(s sVar, p<ParcelFileDescriptor> pVar) {
        super(sVar, pVar);
    }

    public final void b(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.b(bundle, bundle2);
        this.f37229a.b((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
