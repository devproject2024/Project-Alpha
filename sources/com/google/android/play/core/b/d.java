package com.google.android.play.core.b;

import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.play.core.e.p;
import java.util.List;

final /* synthetic */ class d implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    private final l f37302a;

    d(l lVar) {
        this.f37302a = lVar;
    }

    public final void binderDied() {
        l lVar = this.f37302a;
        lVar.f37311a.d("reportBinderDeath", new Object[0]);
        if (((g) lVar.f37314d.get()) == null) {
            lVar.f37311a.d("%s : Binder has died.", lVar.f37312b);
            List<c> list = lVar.f37313c;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                p<?> pVar = list.get(i2).f37300g;
                if (pVar != null) {
                    pVar.b((Exception) Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(lVar.f37312b).concat(" : Binder has died.")));
                }
            }
            lVar.f37313c.clear();
            return;
        }
        lVar.f37311a.d("calling onBinderDied", new Object[0]);
    }
}
