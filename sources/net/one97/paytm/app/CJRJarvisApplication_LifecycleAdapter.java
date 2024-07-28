package net.one97.paytm.app;

import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.x;

public class CJRJarvisApplication_LifecycleAdapter implements h {

    /* renamed from: a  reason: collision with root package name */
    final CJRJarvisApplication f49017a;

    CJRJarvisApplication_LifecycleAdapter(CJRJarvisApplication cJRJarvisApplication) {
        this.f49017a = cJRJarvisApplication;
    }

    public final void a(k.a aVar, boolean z, x xVar) {
        boolean z2 = xVar != null;
        if (!z) {
            if (aVar == k.a.ON_START) {
                if (!z2 || xVar.a("onAppForground")) {
                    this.f49017a.onAppForground();
                }
            } else if (aVar != k.a.ON_STOP) {
            } else {
                if (!z2 || xVar.a("onAppStop")) {
                    this.f49017a.onAppStop();
                }
            }
        }
    }
}
