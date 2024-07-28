package net.one97.paytm.passbook.utility;

import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.x;

public class PassbookLifecycleObserver_LifecycleAdapter implements h {

    /* renamed from: a  reason: collision with root package name */
    final PassbookLifecycleObserver f59227a;

    PassbookLifecycleObserver_LifecycleAdapter(PassbookLifecycleObserver passbookLifecycleObserver) {
        this.f59227a = passbookLifecycleObserver;
    }

    public final void a(k.a aVar, boolean z, x xVar) {
        boolean z2 = xVar != null;
        if (!z) {
            if (aVar == k.a.ON_PAUSE) {
                if (!z2 || xVar.a("activityOnPause")) {
                    this.f59227a.activityOnPause();
                }
            } else if (aVar != k.a.ON_STOP) {
            } else {
                if (!z2 || xVar.a("activityOnStop")) {
                    this.f59227a.activityOnStop();
                }
            }
        }
    }
}
