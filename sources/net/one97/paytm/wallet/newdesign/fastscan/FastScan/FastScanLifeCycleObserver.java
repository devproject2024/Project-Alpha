package net.one97.paytm.wallet.newdesign.fastscan.FastScan;

import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import net.one97.paytm.fastscanner.b.d;

public final class FastScanLifeCycleObserver implements p {
    @aa(a = k.a.ON_RESUME)
    public final void startCamera() {
        d dVar = d.f50426a;
        d.c();
    }

    @aa(a = k.a.ON_PAUSE)
    public final void stopCamera() {
        d dVar = d.f50426a;
        d.i();
    }
}
