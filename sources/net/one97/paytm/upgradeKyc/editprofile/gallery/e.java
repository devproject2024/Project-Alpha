package net.one97.paytm.upgradeKyc.editprofile.gallery;

import androidx.lifecycle.z;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.x;

public final class e<T> implements z<b<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T, x> f65855a;

    public e(b<? super T, x> bVar) {
        k.c(bVar, "onEventUnhandledContent");
        this.f65855a = bVar;
    }

    public final /* synthetic */ void onChanged(Object obj) {
        T t;
        b bVar = (b) obj;
        if (bVar != null) {
            if (bVar.f65852a) {
                t = null;
            } else {
                bVar.f65852a = true;
                t = bVar.f65853b;
            }
            if (t != null) {
                this.f65855a.invoke(t);
            }
        }
    }
}
