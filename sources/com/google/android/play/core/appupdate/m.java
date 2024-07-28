package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.a.a;
import com.google.android.play.core.b.b;
import com.google.android.play.core.e.p;

final class m extends l<Void> {
    m(o oVar, p<Void> pVar) {
        super(oVar, new b("OnCompleteUpdateCallback"), pVar);
    }

    public final void b(Bundle bundle) throws RemoteException {
        super.b(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f36913b.b((Exception) new a(bundle.getInt("error.code", -2)));
        } else {
            this.f36913b.b(null);
        }
    }
}
