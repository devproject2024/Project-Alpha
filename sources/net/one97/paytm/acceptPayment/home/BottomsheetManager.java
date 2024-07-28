package net.one97.paytm.acceptPayment.home;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.business.merchant_payments.homepagedialogs.HomeDialogsManager;
import java.lang.ref.WeakReference;

public final class BottomsheetManager implements p {

    /* renamed from: a  reason: collision with root package name */
    final HomeDialogsManager f52083a;

    /* renamed from: b  reason: collision with root package name */
    final WeakReference<FragmentActivity> f52084b;

    /* renamed from: c  reason: collision with root package name */
    private k f52085c;

    public BottomsheetManager(k kVar, WeakReference<FragmentActivity> weakReference) {
        kotlin.g.b.k.d(weakReference, "activity");
        this.f52085c = kVar;
        this.f52084b = weakReference;
        this.f52083a = new HomeDialogsManager(kVar, weakReference);
        k kVar2 = this.f52085c;
        if (kVar2 != null) {
            kVar2.a(this);
        }
    }

    @aa(a = k.a.ON_DESTROY)
    public final void destroy() {
        k kVar = this.f52085c;
        if (kVar != null) {
            kVar.b(this);
        }
        this.f52085c = null;
    }
}
